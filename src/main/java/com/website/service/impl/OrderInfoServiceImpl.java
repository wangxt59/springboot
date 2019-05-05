/**
 * 
 */
package com.website.service.impl;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.bean.OrderInfo;
import com.website.bean.PageInfo;
import com.website.dao.OrderInfoMapper;
import com.website.dao.RefundOrderMapper;
import com.website.service.IOrderInfoService;

/**
 * 描述:
 * 
 * @Company: 博众援创
 * @author shengtaihua
 * @date 2018-10-11
 */
@Service
public class OrderInfoServiceImpl implements IOrderInfoService {
	private final static Log log = LogFactory.getLog(OrderInfoServiceImpl.class);
	@Autowired
	public OrderInfoMapper orderInfoMapper;
	@Autowired
	public RefundOrderMapper rRefundOrderMapper;
	
	public PageInfo<Map> orderList(PageInfo<Map> pageInfo, Map<String, Object> map) {
		List<Map> orderListsize = orderInfoMapper.orderListByPages(map);
		int count=orderListsize.size();
		RowBounds rowBounds = new RowBounds(pageInfo.getStartRow(),pageInfo.getPageSize());
		List<Map> orderList = orderInfoMapper.orderListByPages(rowBounds, map);
		pageInfo.init(String.valueOf(pageInfo.getCurrentPage()), count,orderList);
		return pageInfo;
	}

	public PageInfo<Map> refundOrderList(PageInfo<Map> pageInfo, Map<String, Object> map) {
		List orderListsize = rRefundOrderMapper.orderListByPages(map);
		int count=orderListsize.size();
		RowBounds rowBounds = new RowBounds(pageInfo.getStartRow(),pageInfo.getPageSize());
		List orderList = rRefundOrderMapper.orderListByPages(rowBounds, map);
		pageInfo.init(String.valueOf(pageInfo.getCurrentPage()), count,orderList);
		return pageInfo;
	}

	
	
	
	
	
	//////////////////////////////////////////
	public PageInfo<List> queryOrderListByPages(PageInfo<List> pageInfo, Map<String, Object> map) {
		int count = orderInfoMapper.queryOrderListCount(map);
		RowBounds rowBounds = new RowBounds(pageInfo.getStartRow(),pageInfo.getPageSize());
		List<List> orderList = orderInfoMapper.queryOrderListByPages(rowBounds, map);
		pageInfo.init(String.valueOf(pageInfo.getCurrentPage()), count,orderList);
		return pageInfo;
	}
	
	public PageInfo<List> orderStatisticsList(PageInfo<List> pageInfo, Map<String, Object> map) {
		int count = orderInfoMapper.orderStatisticsListCount(map);
		RowBounds rowBounds = new RowBounds(pageInfo.getStartRow(),pageInfo.getPageSize());
		List<List> orderList = orderInfoMapper.orderStatisticsList(rowBounds, map);
		pageInfo.init(String.valueOf(pageInfo.getCurrentPage()), count,orderList);
		return pageInfo;
	}
	
	public int updateOrder(OrderInfo orderInfo) {
		return  orderInfoMapper.updateByPrimaryKeySelective(orderInfo);
	}
	
	public OrderInfo getOrderById(int orderId) {
		return  orderInfoMapper.selectByPrimaryKey(orderId);
	}
	
	public Map queryTradeOrderSum(Map<String, Object> map) {
		return  orderInfoMapper.queryTradeOrderSum(map);
	}
	
	
}
