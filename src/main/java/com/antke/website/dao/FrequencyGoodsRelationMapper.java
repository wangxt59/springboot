package com.antke.website.dao;

import java.util.List;
import java.util.Map;

import com.antke.website.model.bean.FrequencyGoodsRelation;

public interface FrequencyGoodsRelationMapper {
    int insert(FrequencyGoodsRelation record);

    int insertSelective(FrequencyGoodsRelation record);

    FrequencyGoodsRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FrequencyGoodsRelation record);

    int updateByPrimaryKey(FrequencyGoodsRelation record);
    
    
    public List getFrequencyGoodsRelationListById(Map map);
    
    public int deleteFrequencyGoodsRelationById(int id);
}