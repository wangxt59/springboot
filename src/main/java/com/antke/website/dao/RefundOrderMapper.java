package com.antke.website.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.antke.website.model.bean.RefundOrder;

public interface RefundOrderMapper {
    int insert(RefundOrder record);

    int insertSelective(RefundOrder record);

    RefundOrder selectByPrimaryKey(Integer refundId);

    int updateByPrimaryKeySelective(RefundOrder record);

    int updateByPrimaryKey(RefundOrder record);
    List orderListByPages(Map refundId);
    List orderListByPages(RowBounds rowBounds,Map refundId);
    
    
}