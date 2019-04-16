package com.antke.website.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antke.website.dao.LoginLogMapper;
import com.antke.website.model.bean.LoginLog;
import com.antke.website.model.bean.PageInfo;
import com.antke.website.service.ILoginLogService;

@Service
public class LoginLogServiceImpl implements ILoginLogService {
	
	//注入登录Dao
	@Autowired
	private LoginLogMapper loginLogMapper;

	/**
	 * 1.
	 * 描述: 添加登录数据
	 */
	@Override
	public int add(LoginLog loginLog) {
		return loginLogMapper.insertSelective(loginLog);
	}

	/**
	 * 2.
	 * 描述: 查询登录日志集合
	 */
	@Override
	public List<LoginLog> selectLoginLogs(Map<String, Object> map) {
		return loginLogMapper.selectLoginLogs(map);
	}

	/**
	 * 2.1
	 * 描述: 更新登出时间
	 */
	@Override
	public void updateLoginLog(LoginLog llog) {
		loginLogMapper.updateByPrimaryKeySelective(llog);
	}

	/**
	 * 3.
	 * 描述: 查询登录日志列表
	 */
	@Override
	public PageInfo<LoginLog> selectLoginLogListByPage(PageInfo<LoginLog> pageInfo, Map<String, Object> map) {
		int totalRecord = loginLogMapper.selectLoginLogCount(map);
		RowBounds rowBounds = new RowBounds(pageInfo.getStartRow(), pageInfo.getPageSize());
		List<LoginLog> datas = loginLogMapper.selectLoginLogListByPage(rowBounds, map);
		pageInfo.init(String.valueOf(pageInfo.getCurrentPage()), totalRecord, datas);
		return pageInfo;
	}

}
