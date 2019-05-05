package com.website.dao;

import com.website.bean.AccountDetails;

public interface AccountDetailsMapper {
    int insert(AccountDetails record);

    int insertSelective(AccountDetails record);

    AccountDetails selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccountDetails record);

    int updateByPrimaryKey(AccountDetails record);
}