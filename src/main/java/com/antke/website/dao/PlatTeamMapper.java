package com.antke.website.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.antke.website.model.bean.PlatTeam;
import com.antke.website.model.bean.PlatTeamRegion;

public interface PlatTeamMapper {
    int insert(PlatTeam record);

    int insertSelective(PlatTeam record);

	int selectPlatTeamCountByMap(Map map);
	
	List<Map> selectPlatTeamListByMap(RowBounds rowBounds, Map map);
	
//	发布团
	int newPlatTeam(PlatTeam record);

	List<Map> slectAllByPlatmId(Integer platmId);
	
	PlatTeam  slectPlatTeamByPlatmId(Integer platId);

	int updatePlatTeam(PlatTeam record);
	
	int deletePlatTeamGoods(Integer platmId);
	
	int deletePlatTeamRegion(Integer platmId);
	
}