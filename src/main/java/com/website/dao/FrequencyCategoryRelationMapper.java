package com.website.dao;

import java.util.List;
import java.util.Map;

import com.website.bean.FrequencyCategoryRelation;

public interface FrequencyCategoryRelationMapper {
    int insert(FrequencyCategoryRelation record);

    int insertSelective(FrequencyCategoryRelation record);

    FrequencyCategoryRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FrequencyCategoryRelation record);

    int updateByPrimaryKey(FrequencyCategoryRelation record);
    
    
    public List getFrequencyCategoryRelationListById(Map map);
    
    public int deleteFrequencyCategoryRelationById(int id);
}