package com.website.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.website.bean.PageInfo;
import com.website.bean.PlatTeam;
import com.website.bean.PlatTeamGoods;

public interface IPlatTeamService {

	PageInfo<Map> selectPlatTeamListByMap(Map map, PageInfo pageInfo);
	
	List<Map>  slectAllByPlatmId(Integer platId);
	
	PlatTeam  slectPlatTeamByPlatmId(Integer platId);

	int savePlatTeam(PlatTeam platTeam) throws ParseException;

	int export(MultipartFile file, Map<String, Object> param) throws IOException;

	public int insertPlatTeamGoods(PlatTeamGoods platTeamGoods); 
	
	int updatePlatTeam(PlatTeam platTeam);
	
	int deletePlatTeamGoods(Integer platmId);
	
	int deletePlatTeamRegion(Integer platmId);
}
