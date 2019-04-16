package com.antke.website.dao;

import com.antke.website.model.bean.AccountInfo;

public interface AccountInfoMapper {
    int insert(AccountInfo record);

    int insertSelective(AccountInfo record);

    AccountInfo selectByPrimaryKey(Integer accountId);

    int updateByPrimaryKeySelective(AccountInfo record);

    int updateByPrimaryKey(AccountInfo record);
    
    AccountInfo getAccountInfoByUserId(String userId);
}