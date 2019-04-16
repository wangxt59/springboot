package com.antke.website.dao;

import java.util.List;
import java.util.Map;

import com.antke.website.model.bean.OrderItems;

public interface OrderItemsMapper {
    int insert(OrderItems record);

    int insertSelective(OrderItems record);

    OrderItems selectByPrimaryKey(Integer itemId);

    int updateByPrimaryKeySelective(OrderItems record);

    int updateByPrimaryKey(OrderItems record);
    
    List<OrderItems> selectOrderItemsByMap(Map map);
    
    List<OrderItems> selectOrderItemsById(Integer orderId);
    public OrderItems getOrderItemsByFlowNo(String flow_no);
}