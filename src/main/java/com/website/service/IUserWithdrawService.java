package com.website.service;

import java.util.List;
import java.util.Map;

import com.website.bean.PageInfo;
import com.website.bean.UserWithdraw;


/**  
 * 描述: 
 * @Company: 博众援创 
 * @author shengtaihua 
 * @date  2018-10-11 
 */
public interface IUserWithdrawService {

	public PageInfo<List> queryWithdrawListByPages(PageInfo<List> pageInfo, Map<String, Object> map);

	public int updateWithdraw(UserWithdraw userWithdraw);
	
	public UserWithdraw getWithdrawById(int withdrawId);
}
