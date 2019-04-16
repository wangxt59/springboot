package com.antke.website.service;

import java.util.List;
import java.util.Map;

import com.antke.website.model.bean.OrderInfo;
import com.antke.website.model.bean.PageInfo;


/**  
 * 描述: 
 * @Company: 博众援创 
 * @author shengtaihua 
 * @date  2018-10-11 
 */
public interface IOrderInfoService {
	
	public PageInfo<Map> orderList(PageInfo<Map> pageInfo, Map<String, Object> map);
	public PageInfo<Map> refundOrderList(PageInfo<Map> pageInfo, Map<String, Object> map);
	
	
	
//	///////////////////////////////////////
	public PageInfo<List> queryOrderListByPages(PageInfo<List> pageInfo, Map<String, Object> map);
	
	public PageInfo<List> orderStatisticsList(PageInfo<List> pageInfo, Map<String, Object> map);

	public int updateOrder(OrderInfo orderInfo);
	
	public OrderInfo getOrderById(int orderId);
	
	public Map queryTradeOrderSum(Map<String, Object> map) ;
}
