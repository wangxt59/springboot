package com.antke.website.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.antke.website.model.bean.OrderInfo;

public interface OrderInfoMapper {
    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    OrderInfo selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);

    public int queryOrderListCount(Map map);
	
   	public List queryOrderListByPages(RowBounds rowBounds, Map map);
//   	
   	public int orderListCount(Map map);
	public List orderListByPages( Map map);
   	public List orderListByPages(RowBounds rowBounds, Map map);
//   	
   	public int orderStatisticsListCount(Map map);
   	
   	public List orderStatisticsList(RowBounds rowBounds, Map map);
   	
   	public Map queryTradeOrderSum(Map map);
   	
}