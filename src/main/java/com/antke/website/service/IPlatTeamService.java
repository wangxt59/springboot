package com.antke.website.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.antke.website.model.bean.PageInfo;
import com.antke.website.model.bean.PlatTeam;
import com.antke.website.model.bean.PlatTeamGoods;

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
