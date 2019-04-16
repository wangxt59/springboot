package com.antke.website.service;

import java.util.List;
import java.util.Map;

import com.antke.website.model.bean.Commander;
import com.antke.website.model.bean.PageInfo;

public interface ICommanderService {
	
//	团长列表
	public PageInfo selectCommanderByPages(PageInfo pageInfo, Map<String, Object> map);

	Map getCommanderById(Integer apply_id);

	public int saveReasonById(String apply_id, String user_id, String status,String refuse_reason);

}
