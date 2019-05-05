package com.website.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.website.bean.PlatTeamRegion;

public interface IPlatTeamRegionService {

	PlatTeamRegion getRegionById(Integer id);

	void saveTeamRegion(Map<String, Object> param,Date date,SimpleDateFormat sdf,int platid);

	int updateRegion(PlatTeamRegion region);
	
	public int insertPlatTeamRegion(PlatTeamRegion region);
	
	 int updateSelective(PlatTeamRegion region);
	 
	 List<PlatTeamRegion> selectPlatTeamRegionList(Map map);
	 
	 List<Map> selectRegionList(Map map);
}
