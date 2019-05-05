/**
 * 
 */
package com.website.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.bean.AccountInfo;
import com.website.dao.AccountInfoMapper;
import com.website.service.IAccountInfoService;

/**
 * 描述:
 * 
 * @Company: 博众援创
 * @author shengtaihua
 * @date 2018-10-11
 */
@Service
public class AccountInfoServiceImpl implements IAccountInfoService {
	private final static Log log = LogFactory
			.getLog(AccountInfoServiceImpl.class);
	@Autowired
	public AccountInfoMapper accountInfoMapper;

	public AccountInfo getAccountInfoByUserId(String user_id) {
		return accountInfoMapper.getAccountInfoByUserId(user_id);
	}

	public int updateAccountInfo(AccountInfo accountInfo) {
		return accountInfoMapper.updateByPrimaryKeySelective(accountInfo);
	}

}
