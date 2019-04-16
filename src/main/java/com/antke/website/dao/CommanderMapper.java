package com.antke.website.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.antke.website.model.bean.Commander;

public interface CommanderMapper {

	List queryCommanderListCount(Map<String, Object> map);

	List queryUserInfoListByPages(RowBounds rowBounds, Map<String, Object> map);

	Map getCommanderById(Integer id);

	void saveReasonById(Commander commander);

	String queryReasonById(Integer id);
	
	Map getUserInfoByapplyId(Integer apply_id);

}
