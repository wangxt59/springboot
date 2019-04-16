package com.antke.website.dao;

import java.util.List;
import java.util.Map;

import com.antke.website.model.bean.PlatTeamRegion;

public interface PlatTeamRegionMapper {
    int insert(PlatTeamRegion record);

    int insertSelective(PlatTeamRegion record);

    PlatTeamRegion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlatTeamRegion record);

    int updateByPrimaryKey(PlatTeamRegion record);
    
    int newPlatTeamRegion(PlatTeamRegion record);

    PlatTeamRegion getRegionById(Integer Id);

    int updateRegion(PlatTeamRegion region);
    
    int updateSelective(PlatTeamRegion region);
    
    List<PlatTeamRegion> selectPlatTeamRegionList(Map map);
    
    List<Map> selectRegionList(Map map);
}