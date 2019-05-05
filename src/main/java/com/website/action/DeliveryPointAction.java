package com.website.action;

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

import com.website.bean.PageInfo;
import com.website.service.IDeliveryPointService;
import com.website.utils.CommonsUtil;

@Controller
@RequestMapping("/deliveryPoint")
public class DeliveryPointAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5901851491095645964L;
	private static Logger log = Logger.getLogger(DeliveryPointAction.class);
	
	@Autowired
	private IDeliveryPointService deliveryPointService;
	
	
	/**
	 * 自提点列表
	 * point_name 自提点名称
	 * contact 手机号
	 * status 自提点状态 1使用 0删除 2、审核中 3审核失败,
	 * @return
	 */
	@RequestMapping("/seMePointList.do")
	public ModelAndView seMePointList(PageInfo pageInfo, HttpSession session,
			@RequestParam(value = "point_name", required = false) String point_name,
			@RequestParam(value = "contact", required = false) String contact,
			@RequestParam(value = "status", required = false) String status) {
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
			if (CommonsUtil.isNotEmpty(point_name)) {
				map.put("point_name", point_name);
				returnMap.put("point_name", point_name);
			}
			if (CommonsUtil.isNotEmpty(contact)) {
				map.put("contact", contact);
				returnMap.put("contact", contact);
			}

			if (CommonsUtil.isNotEmpty(status)) {
				map.put("status", status);
				returnMap.put("status", status);
			}
			pageInfo = deliveryPointService.selectSeMePointByPages(pageInfo, map);
			returnMap.put("pageInfo", pageInfo);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("查询订单列表异常", e);
		}
		return new ModelAndView("/commander/pointList.jsp", "map", returnMap);
	}
	
	/**
	 * 查询团长和自提点信息
	 * @param apply_id
	 * @return
	 */
	@RequestMapping("/getseMePointById.action")
	public ModelAndView getCommanderPointById(@RequestParam("id")Integer seMePointId,@RequestParam("userId")Integer user_id) {
		// 定义回显Map
		Map<String, Object> map = new HashMap<String, Object>();
		// 定义返回值Map
		Map<String, Object> returnMap = new HashMap<String, Object>();
		if(seMePointId != null || seMePointId != 0){
			map.put("id", seMePointId);
			returnMap.put("id",seMePointId);
		}
		if(user_id != null || user_id != 0){
			map.put("user_id", user_id);
			returnMap.put("user_id",user_id);
		}
		Map seMePoint = deliveryPointService.getDeliveryPoint(seMePointId,user_id);
		returnMap.put("seMePoint", seMePoint);
		return new ModelAndView("/commander/pointDetail.jsp", "map", returnMap);
	}
	
	/**
	 * 审核自提点
	 * @param id
	 * @param refuse_reason
	 * @param status
	 * @return
	 */
	@RequestMapping("/saveReasonById.action")
	@ResponseBody
	public int saveReasonById(@RequestParam("id")String id,
			@RequestParam("refuse_reason")String refuse_reason,
			@RequestParam("status")String status) {
		return deliveryPointService.saveReasonById(id,status,refuse_reason);
	}
}
