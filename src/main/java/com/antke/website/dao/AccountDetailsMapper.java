package com.antke.website.dao;

import com.antke.website.model.bean.AccountDetails;

public interface AccountDetailsMapper {
    int insert(AccountDetails record);

    int insertSelective(AccountDetails record);

    AccountDetails selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccountDetails record);

    int updateByPrimaryKey(AccountDetails record);
}