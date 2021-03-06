package com.website.service;

import com.website.bean.AccountInfo;

/**
 * 描述:
 * 
 * @Company: 博众援创
 * @author shengtaihua
 * @date 2018-10-11
 */
public interface IAccountInfoService {

	public AccountInfo getAccountInfoByUserId(String user_id);
	
	public int updateAccountInfo(AccountInfo accountInfo);
}
