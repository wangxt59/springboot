package com.website.service;

import java.util.List;
import java.util.Map;

import com.website.bean.FrequencyGoodsRelation;

 
public interface IFrequencyGoodsRelationService {
 
	public int addFrequencyGoodsRelation(FrequencyGoodsRelation frequencyGoodsRelation);
 
	public int updateFrequencyGoodsRelation(FrequencyGoodsRelation frequencyGoodsRelation);
	
	public List<Map> getFrequencyGoodsRelationListById(Map map);
	
	public int deleteFrequencyGoodsRelationById(int id);
}
