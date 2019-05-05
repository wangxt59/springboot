package com.website.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.website.bean.LoginLog;

public interface LoginLogMapper {
    int insert(LoginLog record);

    int insertSelective(LoginLog record);

    LoginLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoginLog record);

    int updateByPrimaryKey(LoginLog record);
    
    /**
	 * 2.
	 * 描述: 查询登录日志集合
	 */
	List<LoginLog> selectLoginLogs(Map<String, Object> map);

	/**
	 * 3.
	 * 描述: 查询登录日志列表
	 */
	List<LoginLog> selectLoginLogListByPage(RowBounds rowBounds, Map<String, Object> map);

	/**
	 * 3.1
	 * 描述: 查询总数
	 */
	int selectLoginLogCount(Map<String, Object> map);
}