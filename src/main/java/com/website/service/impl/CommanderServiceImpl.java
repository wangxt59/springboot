package com.website.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.bean.ApplyDeliveryPoint;
import com.website.bean.Commander;
import com.website.bean.PageInfo;
import com.website.bean.UserInfo;
import com.website.dao.ApplyDeliveryPointMapper;
import com.website.dao.CommanderMapper;
import com.website.dao.DeliveryPointMapper;
import com.website.dao.UserInfoMapper;
import com.website.service.ICommanderService;
import com.website.utils.CommonsUtil;


@Service
public class CommanderServiceImpl implements ICommanderService {
	private final static Log log = LogFactory.getLog(CommanderServiceImpl.class);
	
	@Autowired
	public CommanderMapper commanderMapper;
	@Autowired
	public UserInfoMapper  userInfoMapper;
	@Autowired
	public ApplyDeliveryPointMapper applyDeliveryPointMapper;
	@Autowired
	public DeliveryPointMapper deliveryPointMapper;
	
	
	/* 
	 * 获取团长列表
	 * @see com.website.service.ICommanderService#selectCommanderByPages(com.website.bean.PageInfo, java.util.Map)
	 */
	@Override
	public PageInfo selectCommanderByPages(PageInfo pageInfo, Map<String, Object> map) {
		List list = commanderMapper.queryCommanderListCount(map);
		int count = list.size();
		String[] strArray = null;
		RowBounds rowBounds = new RowBounds(pageInfo.getStartRow(), pageInfo.getPageSize());
		List<Map> userList = commanderMapper.queryUserInfoListByPages(rowBounds, map);
		for (Map user : userList) {
			List<String> reasonArr = new ArrayList<>();
			if (CommonsUtil.isNotEmpty(user.get("apply_reason") + "")) {
				strArray = (user.get("apply_reason") + "").split(",");
				for (String reason : strArray) {
					reasonArr.add(commanderMapper.queryReasonById(Integer.valueOf(reason)));
				}
			}

			user.put("apply_reason", (reasonArr + "").substring(1, (reasonArr + "").length() - 1));
		}
		pageInfo.init(String.valueOf(pageInfo.getCurrentPage()), count, userList);
		return pageInfo;
	}

	/* 
	 *   通过团申请id获取申请团信息
	 * @see com.website.service.ICommanderService#getCommanderById(java.lang.Integer)
	 */
	@Override
	public Map getCommanderById(Integer apply_id) {
		Map commander = commanderMapper.getCommanderById(apply_id);
		if (CommonsUtil.isNotEmpty(commander.get("apply_reason") + "")) {
			String[] strArray = null;
			List<String> reasonArr = new ArrayList<>();
			strArray = (commander.get("apply_reason") + "").split(",");
			for (String reason : strArray) {
				reasonArr.add(commanderMapper.queryReasonById(Integer.valueOf(reason)));
			}
			commander.put("apply_reason", (reasonArr + "").substring(1, (reasonArr + "").length() - 1));
		}
		return commander;
	}

	/* 
	 *  审核团长接口
	 * @see com.website.service.ICommanderService#saveReasonById(java.util.Map)
	 */
	@Override
	public int saveReasonById(String applyId, String user_id, String statu,String refuse_reason) {
		ApplyDeliveryPoint applyDeliveryPoint = new ApplyDeliveryPoint();
		if (CommonsUtil.isNotEmpty(applyId)) {
			Date date = new Date();
			Integer apply_id = Integer.valueOf(applyId);
			if (CommonsUtil.isNotEmpty(statu)) {
				Integer status = Integer.valueOf(statu);
				Commander commander = new Commander();
				commander.setApplyId(apply_id);
				commander.setStatus(status);
				commander.setUpdateDate(date);
				//审核拒绝
				if (Integer.valueOf(status) == 3) {
					if (CommonsUtil.isNotEmpty(refuse_reason)) {
						commander.setRefuseReason(refuse_reason);
					} else {
						commander.setRefuseReason("");
					}
					//审批自提点
					approvalPoint(applyDeliveryPoint,3,date,user_id);
					commanderMapper.saveReasonById(commander);
				} else if (Integer.valueOf(status) == 2 && CommonsUtil.isNotEmpty(user_id)) {
					Map userInfo = commanderMapper.getUserInfoByapplyId(apply_id);
					//封装user结果集
					UserInfo user = getUserInfo(userInfo);
					user.setUpdateDate(date);
					commanderMapper.saveReasonById(commander);
					userInfoMapper.updateByPrimaryKeySelective(user);
					//审批自提点
					approvalPoint(applyDeliveryPoint,2,date,user_id);
					Map param = new HashMap();
					param.put("user_id", user_id);
					param.put("status", 1);
					List<Map<String, Object>> pointList = applyDeliveryPointMapper.queryPointListByParam(param);
					for (Map<String, Object> map : pointList) {
						map.put("create_date", date);
						map.put("update_date", date);
						map.put("status", 1);
						deliveryPointMapper.savePoint(map);
					}
				} else if (Integer.valueOf(status) == 4) {
					commanderMapper.saveReasonById(commander);
				}
			}
			return 1;
		}
		return 0;
	}

	/**
	 * 封装user结果集
	 * @param userInfo
	 * @return
	 */
	private UserInfo getUserInfo(Map userInfo) {
		String user_id = userInfo.get("user_id") + "";
		String real_name = userInfo.get("real_name") + "";
		String contact = userInfo.get("contact") + "";
		String id_card_no = userInfo.get("id_card_no") + "";
		String id_card_front = userInfo.get("id_card_front") + "";
		String id_card_back = userInfo.get("id_card_back") + "";
		String address = userInfo.get("address") + "";
		String community = userInfo.get("community") + "";
		String province = userInfo.get("province") + "";
		String city = userInfo.get("city") + "";
		UserInfo user = new UserInfo();
		if(CommonsUtil.isNotEmpty(user_id)) {
			user.setId(Integer.valueOf(user_id));
			user.setRole(1);
		}
		if(CommonsUtil.isNotEmpty(real_name)) {
			user.setRealName(real_name);
		}
		if(CommonsUtil.isNotEmpty(contact)) {
			user.setContact(contact);
		}
		if(CommonsUtil.isNotEmpty(id_card_no)) {
			user.setIdCardNo(id_card_no);
		}
		if(CommonsUtil.isNotEmpty(id_card_front)) {
			user.setIdCardFront(id_card_front);
		}
		if(CommonsUtil.isNotEmpty(id_card_back)) {
			user.setIdCardBack(id_card_back);
		}
		if(CommonsUtil.isNotEmpty(address)) {
			user.setAddress(address);
		}
		if(CommonsUtil.isNotEmpty(community)) {
			user.setCommunity(community);
		}
		if(CommonsUtil.isNotEmpty(province)) {
			user.setProvince(province);
		}
		if(CommonsUtil.isNotEmpty(city)) {
			user.setCity(city);
		}
		return user;
	}

	/**
	 *  审批自提点
	 * @param applyDeliveryPoint
	 * @param i
	 * @param date
	 * @param user_id
	 */
	private void approvalPoint(ApplyDeliveryPoint applyDeliveryPoint, int status, Date date, String user_id) {
		Map<String, Object> param = new HashMap<>();
		param.put("user_id", user_id);
		List<Map<String, Object>> list = applyDeliveryPointMapper.queryPointListByParam(param);
		if(list.size() > 0){
			for (Map<String, Object> map : list) {
				applyDeliveryPoint.setId(Integer.valueOf(map.get("id") + ""));
				applyDeliveryPoint.setUserId(Integer.valueOf(user_id));
				applyDeliveryPoint.setUpdateDate(date);
				applyDeliveryPoint.setStatus(status);
				applyDeliveryPointMapper.updateByPrimaryKeySelective(applyDeliveryPoint);
			}
		}
	}

}
