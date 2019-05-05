package com.website.dao;

import java.util.List;
import java.util.Map;

import com.website.bean.PlatTeamDetails;

public interface PlatTeamDetailsMapper {
    int insert(PlatTeamDetails record);

    int insertSelective(PlatTeamDetails record);
    int newPlatTeamDetails(PlatTeamDetails record);
    
    public List<PlatTeamDetails> selectPlatTeamDetailsList(Map param);
    
    PlatTeamDetails selectByPrimaryKey(Integer id);
    
}