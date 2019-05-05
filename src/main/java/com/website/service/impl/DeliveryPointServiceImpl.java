package com.website.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.bean.DeliveryPoint;
import com.website.bean.PageInfo;
import com.website.dao.DeliveryPointMapper;
import com.website.service.IDeliveryPointService;
import com.website.utils.CommonsUtil;

@Service
public class DeliveryPointServiceImpl implements IDeliveryPointService {

	@Autowired
	public DeliveryPointMapper deliveryPointMapper;

	/*
	 * 查询用户和对应自提点
	 * 
	 * @see
	 * com.website.service.IDeliveryPointService#selectSeMePointByPages(com.
	 * website.model.bean.PageInfo, java.util.Map)
	 */
	@Override
	public PageInfo selectSeMePointByPages(PageInfo pageInfo, Map<String, Object> map) {
		List list = deliveryPointMapper.querySeMePointList(map);
		int count = list.size();
		RowBounds rowBounds = new RowBounds(pageInfo.getStartRow(), pageInfo.getPageSize());
		pageInfo.init(String.valueOf(pageInfo.getCurrentPage()), count, list);
		return pageInfo;
	}

	/* 
	 * 获取自提点详情
	 * @see com.website.service.IDeliveryPointService#getDeliveryPoint(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public Map getDeliveryPoint(Integer seMePointId, Integer user_id) {
		Map<String, Object> param = new HashMap<>();
		param.put("id", seMePointId);
		param.put("user_id", user_id);
		return deliveryPointMapper.getDeliveryPoint(param);
	}

	/* 
	 * 审核自提点
	 * @see com.website.service.IDeliveryPointService#saveReasonById(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public int saveReasonById(String id, String status, String refuse_reason) {
		DeliveryPoint deliveryPoint = new DeliveryPoint();
		if(CommonsUtil.isNotEmpty(id)){
			deliveryPoint.setId(Integer.valueOf(id));
			deliveryPoint.setUpdateDate(new Date());
			if(CommonsUtil.isNotEmpty(status)) {
				deliveryPoint.setStatus(status);
			}
			if(CommonsUtil.isNotEmpty(refuse_reason)) {
				deliveryPoint.setRefuseReason(refuse_reason);
			}
			return deliveryPointMapper.updateByPrimaryKeySelective(deliveryPoint);
		}
		return 0;
	}

}
