package com.antke.website.service;

import java.util.Map;

import com.antke.website.model.bean.PageInfo;

public interface IDeliveryPointService {

	PageInfo selectSeMePointByPages(PageInfo pageInfo, Map<String, Object> map);

	Map getDeliveryPoint(Integer seMePointId, Integer user_id);

	int saveReasonById(String id, String status, String refuse_reason);

}
