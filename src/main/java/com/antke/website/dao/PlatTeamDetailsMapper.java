package com.antke.website.dao;

import java.util.List;
import java.util.Map;

import com.antke.website.model.bean.PlatTeamDetails;

public interface PlatTeamDetailsMapper {
    int insert(PlatTeamDetails record);

    int insertSelective(PlatTeamDetails record);
    int newPlatTeamDetails(PlatTeamDetails record);
    
    public List<PlatTeamDetails> selectPlatTeamDetailsList(Map param);
    
    PlatTeamDetails selectByPrimaryKey(Integer id);
    
}