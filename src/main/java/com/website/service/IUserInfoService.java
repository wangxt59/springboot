package com.website.service;

import java.util.List;
import java.util.Map;

import com.website.bean.PageInfo;
import com.website.bean.UserInfo;


/**  
 * 描述: 
 * @Company: 博众援创 
 * @author shengtaihua 
 * @date  2018-10-11 
 */
public interface IUserInfoService {
	
	public PageInfo<List> queryUserInfoListByPages(PageInfo<List> pageInfo, Map<String, Object> map);

	public PageInfo<List> queryUserInfoList(PageInfo<List> pageInfo, Map<String, Object> map);
	
	public int updateUserInfo(UserInfo userInfo) ;
	
	public UserInfo getUserInfoById(Integer id);
	
	public UserInfo queryUserInfo(Map map);

}
