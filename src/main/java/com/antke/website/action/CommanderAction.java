package com.antke.website.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.antke.website.model.bean.PageInfo;
import com.antke.website.service.IApplyDeliveryPointService;
import com.antke.website.service.ICommanderService;
import com.antke.website.service.IDeliveryPointService;
import com.antke.website.utils.CommonsUtil;

@Controller
@RequestMapping("/commander")
public class CommanderAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(CommanderAction.class);
	
	@Autowired
	private ICommanderService commanderService;
	@Autowired
	private IApplyDeliveryPointService  applyDeliveryPointService;
	@Autowired
	private IDeliveryPointService deliveryPointService;
	
	/**
	 * 团长列表
	 * 
	 * @return
	 */
	@RequestMapping("/commanderList.do")
	public ModelAndView commanderList(PageInfo pageInfo, HttpSession session,
			@RequestParam(value = "real_name", required = false) String real_name,
			@RequestParam(value = "contact", required = false) String contact,
			@RequestParam(value = "status", required = false) String status,
			@RequestParam(value = "city", required = false) String city) {
		// 定义返回值Map
		Map<String, Object> returnMap = new HashMap<String, Object>();
		// 定义回显Map
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 如果是初次访问或新的查询时，重置分页
			if (pageInfo == null || pageInfo.getCurrentPage() == 0) {
				pageInfo = new PageInfo<List>();
				pageInfo.setCurrentPage("1");
			}
			if (CommonsUtil.isNotEmpty(real_name)) {
				map.put("real_name", real_name);
				returnMap.put("real_name", real_name);
			}
			if (CommonsUtil.isNotEmpty(contact)) {
				map.put("contact", contact);
				returnMap.put("contact", contact);
			}

			if (CommonsUtil.isNotEmpty(status)) {
				map.put("status", status);
				returnMap.put("status", status);
			}
			if (CommonsUtil.isNotEmpty(city)) {
				map.put("city", city);
				returnMap.put("city", city);
			}
			pageInfo = commanderService.selectCommanderByPages(pageInfo, map);
			returnMap.put("pageInfo", pageInfo);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("查询订单列表异常", e);
		}
		return new ModelAndView("/commander/commanderList.jsp", "map", returnMap);
	}

	/**
	 *   查询团长信息
	 * @param apply_id
	 * @return
	 */
	@RequestMapping("/getCommanderById.action")
	public ModelAndView getCommanderById(@RequestParam("id")Integer apply_id) {
		// 定义回显Map
		Map<String, Object> map = new HashMap<String, Object>();
		// 定义返回值Map
		Map<String, Object> returnMap = new HashMap<String, Object>();
		if(apply_id == null || apply_id == 0){
			map.put("id", apply_id);
			returnMap.put("id",apply_id);
		}
		Map commander = commanderService.getCommanderById(apply_id);
		returnMap.put("commander", commander);
		returnMap.put("apply_id", apply_id);
		return new ModelAndView("/commander/commanderDetail.jsp", "map", returnMap);
	}
	
	/*
	 *     审核团长
	 * @param apply_id 
	 * @param user_id
	 * @param refuse_reason
	 * @param status
	 * @return
	 */
	@RequestMapping("/saveReasonById.action")
	@ResponseBody
	public int saveReasonById(@RequestParam("apply_id")String apply_id,
			@RequestParam("user_id")String user_id,
			@RequestParam("refuse_reason")String refuse_reason,
			@RequestParam("status")String status) {
		return commanderService.saveReasonById(apply_id,user_id,status,refuse_reason);
	}
	
}
