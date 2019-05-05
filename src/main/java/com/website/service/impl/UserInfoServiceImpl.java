/**
 * 
 */
package com.website.service.impl;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.bean.PageInfo;
import com.website.bean.UserInfo;
import com.website.dao.UserInfoMapper;
import com.website.service.IUserInfoService;

/**
 * 描述:
 * 
 * @Company: 博众援创
 * @author shengtaihua
 * @date 2018-10-11
 */
@Service
public class UserInfoServiceImpl implements IUserInfoService {
	private final static Log log = LogFactory.getLog(UserInfoServiceImpl.class);
	@Autowired
	public UserInfoMapper userInfoMapper;
	
	public PageInfo<List> queryUserInfoListByPages(PageInfo<List> pageInfo, Map<String, Object> map) {
		int count = userInfoMapper.queryUserInfoListCount(map);
		RowBounds rowBounds = new RowBounds(pageInfo.getStartRow(),pageInfo.getPageSize());
		List<List> userList = userInfoMapper.queryUserInfoListByPages(rowBounds, map);
		pageInfo.init(String.valueOf(pageInfo.getCurrentPage()), count,userList);
		return pageInfo;
	}
	
	@Override
	public int updateUserInfo(UserInfo userInfo) {
		return userInfoMapper.updateByPrimaryKeySelective(userInfo);
	}
	
	@Override
	public UserInfo getUserInfoById(Integer id) {
		return userInfoMapper.selectByPrimaryKey(id);
	}
	
	public PageInfo<List> queryUserInfoList(PageInfo<List> pageInfo, Map<String, Object> map) {
		int count = userInfoMapper.queryListCount(map);
		RowBounds rowBounds = new RowBounds(pageInfo.getStartRow(),pageInfo.getPageSize());
		List<List> userList = userInfoMapper.queryUserInfoList(rowBounds, map);
		pageInfo.init(String.valueOf(pageInfo.getCurrentPage()), count,userList);
		return pageInfo;
	}
	
	
	@Override
	public UserInfo queryUserInfo(Map map) {
		return userInfoMapper.queryUserInfo(map);
	}

}
