/**
 * 
 */
package com.antke.website.service.impl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antke.website.dao.AccountDetailsMapper;
import com.antke.website.model.bean.AccountDetails;
import com.antke.website.service.IAccountDetailsService;

/**
 * 描述:
 * 
 * @Company: 博众援创
 * @author shengtaihua
 * @date 2018-10-11
 */
@Service
public class AccountDetailsServiceImpl implements IAccountDetailsService {
	private final static Log log = LogFactory.getLog(AccountDetailsServiceImpl.class);
	@Autowired
	public AccountDetailsMapper accountDetailsMapper;
	
	public int insertAccountDetails(AccountDetails accountDetails) {
		return  accountDetailsMapper.insertSelective(accountDetails);
	}
	
}
