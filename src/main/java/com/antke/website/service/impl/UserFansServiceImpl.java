package com.antke.website.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antke.website.dao.UserFansMapper;
import com.antke.website.model.bean.PageInfo;
import com.antke.website.model.bean.UserFans;
import com.antke.website.service.IUserFansService;
import com.antke.website.utils.CommonsUtil;

@Service
public class UserFansServiceImpl implements IUserFansService {
	
	@Autowired
	UserFansMapper userFansMapper;

	@Override
	public PageInfo selectFansList(PageInfo pageInfo, Map<String, Object> param) {
		int size = userFansMapper.queryFansListCount(param);
		RowBounds rowBounds = new RowBounds(pageInfo.getStartRow(),pageInfo.getPageSize());
		List userList = userFansMapper.selectFansList(rowBounds, param);
		pageInfo.init(String.valueOf(pageInfo.getCurrentPage()), size,userList);
		return pageInfo;
	}

}
