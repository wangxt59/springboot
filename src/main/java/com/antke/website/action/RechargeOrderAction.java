/**
 * 
 */
package com.antke.website.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.antke.power.model.bean.WorkerInfo;
import com.antke.website.model.bean.OrderInfo;
import com.antke.website.model.bean.PageInfo;
import com.antke.website.model.bean.RechargeOrder;
import com.antke.website.service.IRechargeOrderService;
import com.antke.website.utils.CommonsUtil;

/**  
 * 描述: 
 * @Company: 博众援创 
 * @author shengtaihua 
 * @date  2018-10-11 
 */
@Controller
@RequestMapping("/rechargeOrder")
public class RechargeOrderAction extends BaseAction{
 
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(RechargeOrderAction.class);
	
	@Autowired
	private IRechargeOrderService rechargeOrderService;
		@RequestMapping("/queryRechargeOrderList.do")
		public ModelAndView queryRechargeOrderList(PageInfo pageInfo, HttpSession session,
				@RequestParam(value = "product_name", required = false) String product_name,
				@RequestParam(value = "user_id", required = false) String user_id,
				@RequestParam(value = "order_code", required = false) String order_code,
				@RequestParam(value = "status", required = false) String status,
				@RequestParam(value = "create_date_start", required = false) String create_date_start,
				@RequestParam(value = "create_date_end", required = false) String create_date_end) {
			WorkerInfo worker = (WorkerInfo) session.getAttribute("workerInfo");
			if (worker == null) {
				return new ModelAndView("redirect:/login/workLogin.action");
			}
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
			 
				if (product_name != null && !"".equals(product_name.trim())) {
					map.put("product_name", product_name);
					returnMap.put("product_name", product_name);
				}
				if (user_id != null && !"".equals(user_id.trim())) {
					map.put("user_id", user_id);
					returnMap.put("user_id", user_id);
				}
				
				if (order_code != null && !"".equals(order_code.trim())) {
					map.put("order_code", order_code);
					returnMap.put("order_code", order_code);
				}
				
				if (status != null && !"".equals(status.trim())) {
					map.put("status", status);
					returnMap.put("status", status);
				}
		 
				if (create_date_start != null && CommonsUtil.isNotEmpty("" + create_date_start)) {
					map.put("create_date_start", create_date_start);
					returnMap.put("create_date_start", create_date_start);
				}
				if (create_date_end != null && CommonsUtil.isNotEmpty("" + create_date_end)) {
					map.put("create_date_end", create_date_end );
					returnMap.put("create_date_end", create_date_end);
				}
				
				pageInfo = rechargeOrderService.queryRechargeOrderListByPages(pageInfo, map);
				returnMap.put("pageInfo", pageInfo);
			} catch (Exception e) {
				e.printStackTrace();
				log.error("查询订单列表异常", e);
			}
			return new ModelAndView("rechargeOrder/rechargeOrderList.jsp", "map", returnMap);
		}
		
		
		@RequestMapping("gotoUpdateRechargeOrder.do")
		public ModelAndView gotoUpdateRechargeOrder(String id) {
			RechargeOrder info = rechargeOrderService.getRechargeOrderById(Integer.valueOf(id));
			Map<String, Object> returnMap = new HashMap<String, Object>();
			returnMap.put("info", info);
			return new ModelAndView("rechargeOrder/updateRechargeOrder.jsp", "map", returnMap);
		}
		
		@RequestMapping("updateRechargeOrder.do")
		public String updateRechargeOrder(RechargeOrder rechargeOrder) {
			rechargeOrder.setUpdateDate(new Date());
			rechargeOrderService.updateRechargeOrder(rechargeOrder);
			return "redirect:queryRechargeOrderList.do";
		}

}
