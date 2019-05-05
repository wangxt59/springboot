package com.website.dao;

import com.website.bean.AccountInfo;

public interface AccountInfoMapper {
    int insert(AccountInfo record);

    int insertSelective(AccountInfo record);

    AccountInfo selectByPrimaryKey(Integer accountId);

    int updateByPrimaryKeySelective(AccountInfo record);

    int updateByPrimaryKey(AccountInfo record);
    
    AccountInfo getAccountInfoByUserId(String userId);
}