/**
 * 
 */
package com.antke.website.service.impl;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antke.website.dao.OrderInfoMapper;
import com.antke.website.dao.OrderItemsMapper;
import com.antke.website.model.bean.OrderInfo;
import com.antke.website.model.bean.OrderItems;
import com.antke.website.model.bean.PageInfo;
import com.antke.website.service.IOrderInfoService;
import com.antke.website.service.IOrderItemsService;

/**
 * 描述:
 * 
 * @Company: 博众援创
 * @author shengtaihua
 * @date 2018-10-11
 */
@Service
public class OrderItemsServiceImpl implements IOrderItemsService {
	private final static Log log = LogFactory.getLog(OrderItemsServiceImpl.class);
	@Autowired
	public OrderItemsMapper orderItemsMapper;
	
	
	public OrderItems getOrderItemsByFlowNo(String flow_no) {
		return  orderItemsMapper.getOrderItemsByFlowNo(flow_no);
	}
	public List<OrderItems> selectOrderItemsByMap(Map flow_no) {
		return  orderItemsMapper.selectOrderItemsByMap(flow_no);
	}
	
}
