package com.antke.website.service;

import java.util.List;
import java.util.Map;

import com.antke.website.model.bean.PlatTeamDetails;


public interface IPlatTeamDetailsService {

	void saveTeamDetails(Map<String, Object> param, int platid);
	
	
	List<PlatTeamDetails> selectPlatTeamDetailsList(Map param);

}
