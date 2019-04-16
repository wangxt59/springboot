package com.antke.website.service;

import java.util.Map;

import com.antke.website.model.bean.PageInfo;

public interface IUserFansService {

	PageInfo selectFansList(PageInfo pageInfo, Map<String, Object> param);

}
