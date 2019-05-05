package com.website.dao;

import java.util.List;
import java.util.Map;

import com.website.bean.RefundOrderItems;

public interface RefundOrderItemsMapper {
    int insert(RefundOrderItems record);

    int insertSelective(RefundOrderItems record);

    RefundOrderItems selectByPrimaryKey(Integer itemId);
    List<RefundOrderItems> selectOrderItemsByMap(Map map);

    int updateByPrimaryKeySelective(RefundOrderItems record);

    int updateByPrimaryKey(RefundOrderItems record);
}