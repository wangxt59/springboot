/**
 * 
 */
package com.antke.website.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.views.xslt.ArrayAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.antke.power.model.bean.WorkerInfo;
import com.antke.website.dao.RefundOrderItemsMapper;
import com.antke.website.dao.RefundOrderMapper;
import com.antke.website.model.bean.AccountDetails;
import com.antke.website.model.bean.AccountInfo;
import com.antke.website.model.bean.GoodsInfo;
import com.antke.website.model.bean.OrderInfo;
import com.antke.website.model.bean.OrderItems;
import com.antke.website.model.bean.PageInfo;
import com.antke.website.model.bean.RankBrokerage;
import com.antke.website.model.bean.RefundOrderItems;
import com.antke.website.model.bean.UserInfo;
import com.antke.website.service.IAccountDetailsService;
import com.antke.website.service.IAccountInfoService;
import com.antke.website.service.IGoodsInfoService;
import com.antke.website.service.IOrderInfoService;
import com.antke.website.service.IOrderItemsService;
import com.antke.website.service.IRankBrokerageService;
import com.antke.website.service.IUserInfoService;
import com.antke.website.utils.ArithmeticUtils;
import com.antke.website.utils.CommonsUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**  
 * 描述: 
 * @Company: 博众援创 
 * @author shengtaihua 
 * @date  2018-10-11 
 */
@Controller
@RequestMapping("/orderInfo")
public class OrderInfoAction extends BaseAction{
 
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(OrderInfoAction.class);
	
	@Autowired
	private IOrderInfoService orderInfoService;
	@Autowired
	private IOrderItemsService orderItemsService;
	@Autowired
	private IGoodsInfoService goodsInfoService;
	@Autowired
	private IUserInfoService userInfoService;
	@Autowired
	private IRankBrokerageService rankBrokerageService;
	@Autowired
	private IAccountInfoService accountInfoService;
	@Autowired
	private IAccountDetailsService accountDetailsService;
	@Autowired
	private RefundOrderItemsMapper refundOrderItemsMapper;
	
	
	//订单列表
	@RequestMapping("/orderList.do")
	public ModelAndView orderList(ModelAndView modelAndView,HttpSession session,@RequestParam Map map ) {
		WorkerInfo worker = (WorkerInfo) session.getAttribute("workerInfo");
		if (worker == null) {
			return new ModelAndView("redirect:/login/workLogin.action");
		}
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String, Object> requestMap = new HashMap<String, Object>();
		String string="/orderInfo/orderInfoList.jsp";
		try {
//			if (pageInfo == null || pageInfo.getCurrentPage() == 0) {
//				pageInfo = new PageInfo<List>();
//				pageInfo.setCurrentPage("1");
//			}
			
			if (CommonsUtil.isNotEmpty(modelAndView.getViewName())) {
				 string=modelAndView.getViewName();
			}
			String order_code=map.get("order_code")+"";
			String user_name=map.get("user_name")+"";
			String team_name=map.get("team_name")+"";
			String status=map.get("status")+"";
			
			String delivery_type=map.get("delivery_type")+"";
			String satrt_date=map.get("satrt_date")+"";
			String end_date=map.get("end_date")+"";
			String currentPage=map.get("currentPage")+"";
			
			PageInfo<Map> pageInfo = new PageInfo<Map>();
			pageInfo.setCurrentPage("1");
			if (CommonsUtil.isNotEmpty(currentPage)) {
				if (("0").equals(currentPage.trim())) {
					pageInfo.setCurrentPage(1);
				}else {
					pageInfo.setCurrentPage(currentPage);
				}
			}
			if (CommonsUtil.isNotEmpty(order_code)) {
				requestMap.put("order_code", order_code);
			}
			if (CommonsUtil.isNotEmpty(user_name)) {
				requestMap.put("user_name", user_name);
			}
			if (CommonsUtil.isNotEmpty(team_name)) {
				requestMap.put("team_name", team_name);
			}
			if (CommonsUtil.isNotEmpty(status)) {
				requestMap.put("status", status);
			}
			if (CommonsUtil.isNotEmpty(delivery_type)) {
				requestMap.put("delivery_type", delivery_type);
			}
			if (CommonsUtil.isNotEmpty(satrt_date)) {
				requestMap.put("satrt_date", satrt_date);
			}
			if (CommonsUtil.isNotEmpty(end_date)) {
				requestMap.put("end_date", end_date);
			}
			pageInfo=orderInfoService.orderList(pageInfo, requestMap);
//			List datalist=new ArrayList();
//			for (Map map2 : pageInfo.getDatas()) {
//				Map<String, Object> map3=new HashMap<String, Object>();
//				map3.put("order_code", map2.get("order_code"));
//				map3.put("team_name", map2.get("team_name"));
//				map3.put("nick_name", map2.get("nick_name"));
//				map3.put("user_name", map2.get("user_name"));
//				map3.put("create_date", map2.get("create_date"));
//				map3.put("order_total", map2.get("order_total"));
//				map3.put("point_name", map2.get("point_name"));
//				map3.put("delivery_type", map2.get("delivery_type"));
//				map3.put("id", map2.get("id"));
//				
//				datalist.add(map3);
//			}
//			returnMap.put("map", pageInfo);
			returnMap.put("request", map);
			
//			pageInfo = orderInfoService.orderStatisticsList(pageInfo, map);
			returnMap.put("pageInfo", pageInfo);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("查询订单列表异常", e);
		}
		
		return new ModelAndView(string, "map", returnMap);
	}
	//订单详情
		@RequestMapping("/orderDetails.do")
		public ModelAndView orderDetails(ModelAndView modelAndView,HttpSession session,@RequestParam String id ) {
			WorkerInfo worker = (WorkerInfo) session.getAttribute("workerInfo");
			if (worker == null) {
				return new ModelAndView("redirect:/login/workLogin.action");
			}
			Map<String, Object> requestMap = new HashMap<String, Object>();
			Map<String, Object> returnMap=new HashMap<String, Object>();
			try {
				if (CommonsUtil.isEmpty(id)) {
					return new ModelAndView();
				}
				PageInfo pageInfo = new PageInfo<Map>();
				pageInfo.setCurrentPage("1");
				requestMap.put("id", id);
				pageInfo=orderInfoService.orderList(pageInfo, requestMap);
				returnMap=(Map<String, Object>) pageInfo.getDatas().get(0);
				List list=new ArrayList();
				requestMap.clear();
				requestMap.put("orderId", id);
				List<OrderItems> orderItemsList=orderItemsService.selectOrderItemsByMap(requestMap);
				for (OrderItems orderItems : orderItemsList) {
					Map<String, Object> map=new HashMap<String, Object>();
					map.put("goods_name", orderItems.getGoodsName());
					map.put("goods_num", orderItems.getGoodsNum());
					
					if (CommonsUtil.isEmpty(orderItems.getVipPrice()+"")) {
						map.put("region_price", orderItems.getRegionPrice());
						map.put("total_money", orderItems.getTotalMoney());
					}else {
						map.put("total_money", orderItems.getVipPrice()*orderItems.getGoodsNum());
						map.put("region_price", orderItems.getVipPrice());
					}
					
					
					list.add(map);
				}
				returnMap.put("list",list);
//				pageInfo = orderInfoService.orderStatisticsList(pageInfo, map);
//				returnMap.put("pageInfo", pageInfo);
			} catch (Exception e) {
				e.printStackTrace();
				log.error("查询订单列表异常", e);
			}
			
			return new ModelAndView("/orderInfo/orderDetails.jsp", "data", returnMap);
		}
		//售后订单列表
		@RequestMapping("/afterSaleOrder.do")
		public ModelAndView afterSaleOrder(ModelAndView modelAndView,HttpSession session,@RequestParam Map map ) {
			WorkerInfo worker = (WorkerInfo) session.getAttribute("workerInfo");
			if (worker == null) {
				return new ModelAndView("redirect:/login/workLogin.action");
			}
			
			Map<String, Object> returnMap = new HashMap<String, Object>();
			Map<String, Object> requestMap = new HashMap<String, Object>();
			String string="/orderInfo/afterSaleOrder.jsp";
			try {
//				if (pageInfo == null || pageInfo.getCurrentPage() == 0) {
//					pageInfo = new PageInfo<List>();
//					pageInfo.setCurrentPage("1");
//				}
				
				if (CommonsUtil.isNotEmpty(modelAndView.getViewName())) {
					 string=modelAndView.getViewName();
				}
				String order_code=map.get("order_code")+"";
				String user_name=map.get("user_name")+"";
				String team_name=map.get("team_name")+"";
				String status=map.get("status")+"";
				
				String delivery_type=map.get("delivery_type")+"";
				String satrt_date=map.get("satrt_date")+"";
				String end_date=map.get("end_date")+"";
				String currentPage=map.get("currentPage")+"";
				
				PageInfo pageInfo = new PageInfo<Map>();
				pageInfo.setCurrentPage("1");
				if (CommonsUtil.isNotEmpty(currentPage)) {
					if (("0").equals(currentPage.trim())) {
						pageInfo.setCurrentPage(1);
					}else {
						pageInfo.setCurrentPage(currentPage);
					}
				}
				if (CommonsUtil.isNotEmpty(order_code)) {
					requestMap.put("order_id", order_code);
				}
				if (CommonsUtil.isNotEmpty(user_name)) {
					requestMap.put("user_name", user_name);
				}
				if (CommonsUtil.isNotEmpty(team_name)) {
					requestMap.put("team_name", team_name);
				}
				if (CommonsUtil.isNotEmpty(status)) {
					requestMap.put("status", status);
				}
				if (CommonsUtil.isNotEmpty(delivery_type)) {
					requestMap.put("delivery_type", delivery_type);
				}
				if (CommonsUtil.isNotEmpty(satrt_date)) {
					requestMap.put("satrt_date", satrt_date);
				}
				if (CommonsUtil.isNotEmpty(end_date)) {
					requestMap.put("end_date", end_date);
				}
				pageInfo=orderInfoService.refundOrderList(pageInfo, requestMap);
				returnMap.put("pageInfo", pageInfo);
				returnMap.put("request", map);
				
//				pageInfo = orderInfoService.orderStatisticsList(pageInfo, map);
//				returnMap.put("pageInfo", pageInfo);
			} catch (Exception e) {
				e.printStackTrace();
				log.error("查询订单列表异常", e);
			}
			
			return new ModelAndView(string, "map", returnMap);
		}
		//售后订单处理
		@RequestMapping("/refundOrderDetails.do")
		public ModelAndView refundOrderDetails(ModelAndView modelAndView,HttpSession session,@RequestParam String id ) {
			WorkerInfo worker = (WorkerInfo) session.getAttribute("workerInfo");
			if (worker == null) {
				return new ModelAndView("redirect:/login/workLogin.action");
			}
			Map<String, Object> requestMap = new HashMap<String, Object>();
			Map<String, Object> returnMap=new HashMap<String, Object>();
			try {
				if (CommonsUtil.isEmpty(id)) {
					return new ModelAndView();
				}
				PageInfo pageInfo = new PageInfo<Map>();
				pageInfo.setCurrentPage("1");
				requestMap.put("id", id);
				pageInfo=orderInfoService.refundOrderList(pageInfo, requestMap);
				if (pageInfo.getDatas().size()!=0) {
					Map<String, Object> resultMap=(Map<String, Object>) pageInfo.getDatas().get(0);
					returnMap.put("team_name", resultMap.get("team_name"));
					returnMap.put("pay_code", resultMap.get("pay_code"));
					returnMap.put("order_id", resultMap.get("order_id"));
					returnMap.put("create_date", resultMap.get("create_date"));
					returnMap.put("pay_time", resultMap.get("pay_time"));
					returnMap.put("receive_date", resultMap.get("receive_date"));
					returnMap.put("nick_name", resultMap.get("nick_name"));
					returnMap.put("contact", resultMap.get("contact"));
					returnMap.put("delivery_type", resultMap.get("delivery_type"));
					returnMap.put("status", resultMap.get("status"));
				}
				
				
				List list=new ArrayList();
				requestMap.clear();
				requestMap.put("refund_id", id);
				List<RefundOrderItems> refundOrderItemsList =refundOrderItemsMapper.selectOrderItemsByMap(requestMap);
				for (RefundOrderItems refundOrderItems : refundOrderItemsList) {
					Map<String, Object> map=new HashMap<String, Object>();
					map.put("goods_name", refundOrderItems.getGoodsName());
					map.put("goods_num", refundOrderItems.getGoodsNum());
					map.put("total_money", refundOrderItems.getTotalMoney());
					map.put("region_price", refundOrderItems.getRegionPrice());
					list.add(map);
				}
				returnMap.put("list",list);
//				pageInfo = orderInfoService.orderStatisticsList(pageInfo, map);
//				returnMap.put("pageInfo", pageInfo);
			} catch (Exception e) {
				e.printStackTrace();
				log.error("查询订单列表异常", e);
			}
			return new ModelAndView("/orderInfo/refundOrderDetails.jsp", "data", returnMap);
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//////////////////////////////////////////////////	
	
		@RequestMapping("/queryOrderList.do")
		public ModelAndView queryOrderList(PageInfo pageInfo, HttpSession session,
				@RequestParam(value = "seller_name", required = false) String seller_name,
				@RequestParam(value = "buyer_name", required = false) String buyer_name,
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
			 
				if (buyer_name != null && !"".equals(buyer_name.trim())) {
					map.put("buyer_name", buyer_name);
					returnMap.put("buyer_name", buyer_name);
				}
				if (seller_name != null && !"".equals(seller_name.trim())) {
					map.put("seller_name", seller_name);
					returnMap.put("seller_name", seller_name);
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
				
				pageInfo = orderInfoService.queryOrderListByPages(pageInfo, map);
				returnMap.put("pageInfo", pageInfo);
				Map sumMap = orderInfoService.queryTradeOrderSum(map);
				returnMap.put("coin_num_sum", sumMap.get("coin_num"));
				returnMap.put("order_total_sum", sumMap.get("order_total"));
			} catch (Exception e) {
				e.printStackTrace();
				log.error("查询订单列表异常", e);
			}
			return new ModelAndView("orderInfo/orderInfoList.jsp", "map", returnMap);
		}
		
		
		@RequestMapping("/orderStatisticsList.do")
		public ModelAndView orderStatisticsList(PageInfo pageInfo, HttpSession session,
				@RequestParam(value = "real_name", required = false) String real_name,
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
			 
				if (real_name != null && !"".equals(real_name.trim())) {
					map.put("real_name", real_name);
					returnMap.put("real_name", real_name);
				}
				if (create_date_start != null && CommonsUtil.isNotEmpty("" + create_date_start)) {
					map.put("create_date_start", create_date_start);
					returnMap.put("create_date_start", create_date_start);
				}
				if (create_date_end != null && CommonsUtil.isNotEmpty("" + create_date_end)) {
					map.put("create_date_end", create_date_end );
					returnMap.put("create_date_end", create_date_end);
				}
				
				pageInfo = orderInfoService.orderStatisticsList(pageInfo, map);
				returnMap.put("pageInfo", pageInfo);
			} catch (Exception e) {
				e.printStackTrace();
				log.error("查询订单列表异常", e);
			}
			return new ModelAndView("orderInfo/orderstatistics.jsp", "map", returnMap);
		}
		
		
		/*@RequestMapping("gotoUpdateOrder.do")
		public ModelAndView gotoUpdateOrder(String orderId) {
			OrderInfo info = orderInfoService.getOrderById(Integer.valueOf(orderId));
			Map<String, Object> returnMap = new HashMap<String, Object>();
			returnMap.put("info", info);
			return new ModelAndView("orderInfo/updateOrder.jsp", "map", returnMap);
		}
		
		@RequestMapping("updateOrder.do")
		public String updateOrder(OrderInfo orderInfo) {
			
			//查询订单信息
			OrderInfo info = orderInfoService.getOrderById(orderInfo.getOrderId());
			orderInfo.setUpdateDate(new Date());
			orderInfo.setPayTime(new Date());
			orderInfoService.updateOrder(orderInfo);
			//如果待支付订单，改为已支付订单
			if(info.getStatus()==0 && orderInfo.getStatus()==1){
				//如果是会员购物
				if("1".equals(info.getChannel())){
					//根据flow_no查询购买的商品订单
					OrderItems orderItems =orderItemsService.getOrderItemsByFlowNo(info.getFlowNo());
					GoodsInfo goodsInfo =goodsInfoService.qyById(orderItems.getGoodsId());
					int goodsRank=goodsInfo.getRank();
					//查询购买的用户
					UserInfo userInfo =userInfoService.getUserInfoById(Integer.valueOf(info.getUserId()));
					int userRank=userInfo.getRank();
					//如果商品星等大于用户星等,更新用户星等
				    if(goodsRank>userRank){
				    	userInfo.setRank(goodsRank);
				    	userInfoService.updateUserInfo(userInfo);
				    	userRank=goodsRank;
				     }
					//根据用户星等查询返还积分
				    RankBrokerage rankBrokerage=rankBrokerageService.getBrokerageByRank(userRank);
				    double integral=rankBrokerage.getIntegral();
				    double brokerageRatio=rankBrokerage.getBrokerageRatio();
				    double brokerageNum=ArithmeticUtils.mul(rankBrokerage.getAmount(), brokerageRatio,2);
				    //更新用户账户积分信息
				    AccountInfo  userAccount= accountInfoService.getAccountInfoByUserId(userInfo.getId().toString());
				    userAccount.setIntegral(ArithmeticUtils.add(integral, userAccount.getIntegral()));
				    userAccount.setUpdateDate(new Date());
				    userAccount.setCoin(String.valueOf(ArithmeticUtils.add(integral, Double.valueOf(userAccount.getCoin()))));
				    accountInfoService.updateAccountInfo(userAccount);
				    //打入流水
				    AccountDetails accountDetails  =new  AccountDetails();
				    accountDetails.setUserId(info.getUserId());
				    accountDetails.setAccountId(String.valueOf(userAccount.getAccountId()));
				    accountDetails.setTradeType(3);
				    accountDetails.setDirection(1);
				    accountDetails.setCreateDate(new Date());
				    accountDetails.setUpdateDate(new Date());
				    accountDetails.setOrderId(String.valueOf(orderInfo.getOrderId()));
				    accountDetails.setIntegral(String.valueOf(integral));
				    accountDetailsService.insertAccountDetails(accountDetails);
				    //更新分享人账户积分，返佣信息
				    
				    
				    int superiorId=userInfo.getDirectSuperior();
				    AccountInfo  superiorAccount= accountInfoService.getAccountInfoByUserId(String.valueOf(superiorId));
				   
				    superiorAccount.setIntegral(ArithmeticUtils.add(integral, superiorAccount.getIntegral()));
				    superiorAccount.setCoin(String.valueOf(ArithmeticUtils.add(integral, Double.valueOf(superiorAccount.getCoin()))));
				    //90%打入余额。10%打入冻结金额
				    superiorAccount.setBalance(ArithmeticUtils.add(ArithmeticUtils.mul(brokerageNum, 0.9,2), superiorAccount.getBalance()));
				    superiorAccount.setFrozen(ArithmeticUtils.add(ArithmeticUtils.mul(brokerageNum, 0.1,2), superiorAccount.getFrozen()));
				    superiorAccount.setUpdateDate(new Date());
				    accountInfoService.updateAccountInfo(superiorAccount);
				    //打入积分流水
				    AccountDetails superiorAccountDetails  =new  AccountDetails();
				    superiorAccountDetails.setUserId(String.valueOf(superiorId));
				    superiorAccountDetails.setAccountId(String.valueOf(superiorAccount.getAccountId()));
				    superiorAccountDetails.setTradeType(3);
				    superiorAccountDetails.setDirection(1);
				    superiorAccountDetails.setCreateDate(new Date());
				    superiorAccountDetails.setUpdateDate(new Date());
				    superiorAccountDetails.setOrderId(String.valueOf(orderInfo.getOrderId()));
				    superiorAccountDetails.setIntegral(String.valueOf(integral));
				    accountDetailsService.insertAccountDetails(superiorAccountDetails);
				    
				    //打入佣金流水
				    AccountDetails superiorAccountDetail  =new  AccountDetails();
				    superiorAccountDetail.setUserId(String.valueOf(superiorId));
				    superiorAccountDetail.setAccountId(String.valueOf(superiorAccount.getAccountId()));
				    superiorAccountDetail.setTradeType(1);
				    superiorAccountDetail.setDirection(1);
				    superiorAccountDetail.setCreateDate(new Date());
				    superiorAccountDetail.setUpdateDate(new Date());
				    superiorAccountDetail.setOrderId(String.valueOf(orderInfo.getOrderId()));
				    superiorAccountDetail.setAmount(""+ArithmeticUtils.mul(brokerageNum, 0.9,2));
				    accountDetailsService.insertAccountDetails(superiorAccountDetail);
				    
				    //打入佣金流水
				    AccountDetails asd  =new  AccountDetails();
				    asd.setUserId(String.valueOf(superiorId));
				    asd.setAccountId(String.valueOf(superiorAccount.getAccountId()));
				    asd.setTradeType(5);
				    asd.setDirection(1);
				    asd.setCreateDate(new Date());
				    asd.setUpdateDate(new Date());
				    asd.setOrderId(String.valueOf(orderInfo.getOrderId()));
				    asd.setAmount(""+ArithmeticUtils.mul(brokerageNum, 0.1,2));
				    accountDetailsService.insertAccountDetails(asd);
					
				}
			}
			
			
			return "redirect:queryOrderList.do";
		}
*/
	
}
