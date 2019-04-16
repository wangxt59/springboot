package com.antke.website.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.antke.website.model.bean.UserWithdraw;

public interface UserWithdrawMapper {
    int insert(UserWithdraw record);

    int insertSelective(UserWithdraw record);

    UserWithdraw selectByPrimaryKey(Integer withdrawId);

    int updateByPrimaryKeySelective(UserWithdraw record);

    int updateByPrimaryKey(UserWithdraw record);
    
    public int queryWithdrawListCount(Map map);
	
   	public List queryWithdrawListByPages(RowBounds rowBounds, Map map);
}