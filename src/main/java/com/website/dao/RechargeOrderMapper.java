package com.website.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.website.bean.RechargeOrder;

public interface RechargeOrderMapper {
    int insert(RechargeOrder record);

    int insertSelective(RechargeOrder record);

    RechargeOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RechargeOrder record);

    int updateByPrimaryKey(RechargeOrder record);
    
    public int queryRechargeOrderListCount(Map map);
	
   	public List queryRechargeOrderListByPages(RowBounds rowBounds, Map map); 
}