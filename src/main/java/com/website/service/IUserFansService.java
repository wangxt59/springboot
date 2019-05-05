package com.website.service;

import java.util.Map;

import com.website.bean.PageInfo;

public interface IUserFansService {

	PageInfo selectFansList(PageInfo pageInfo, Map<String, Object> param);

}
