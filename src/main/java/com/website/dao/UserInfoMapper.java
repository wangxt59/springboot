package com.website.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.website.bean.UserInfo;

public interface UserInfoMapper {
    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
    
    public int queryUserInfoListCount(Map map);
	
   	public List queryUserInfoListByPages(RowBounds rowBounds, Map map); 
   	
   	public int queryListCount(Map map);
	
   	public List queryUserInfoList(RowBounds rowBounds, Map map); 
   	
   	UserInfo queryUserInfo(Map map);

}