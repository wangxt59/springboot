package com.website.service;

import java.util.List;
import java.util.Map;

import com.website.bean.OrderItems;


/**  
 * 描述: 
 * @Company: 博众援创 
 * @author shengtaihua 
 * @date  2018-10-11 
 */
public interface IOrderItemsService {

	public OrderItems getOrderItemsByFlowNo(String flow_no);

	public List<OrderItems> selectOrderItemsByMap(Map requestMap);
}
