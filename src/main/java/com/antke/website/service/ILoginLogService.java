package com.antke.website.service;

import java.util.List;
import java.util.Map;

import com.antke.website.model.bean.LoginLog;
import com.antke.website.model.bean.PageInfo;




public interface ILoginLogService {

	/**
	 * 1.
	 * 描述: 添加登录数据
	 */
	int add(LoginLog loginLog);

	/**
	 * 2.
	 * 描述: 查询登录日志集合
	 */
	List<LoginLog> selectLoginLogs(Map<String, Object> map);

	/**
	 * 2.1
	 * 描述: 更新登出时间
	 */
	void updateLoginLog(LoginLog llog);

	/**
	 * 3.
	 * 描述: 查询登录日志列表
	 */
	PageInfo<LoginLog> selectLoginLogListByPage(PageInfo<LoginLog> pageInfo, Map<String, Object> map);

}
