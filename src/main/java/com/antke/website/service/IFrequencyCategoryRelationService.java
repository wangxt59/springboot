package com.antke.website.service;

import java.util.List;
import java.util.Map;

import com.antke.website.model.bean.FrequencyCategoryRelation;

 
public interface IFrequencyCategoryRelationService {
 
	public int addFrequencyCategoryRelation(FrequencyCategoryRelation frequencyCategoryRelation);
 
	public int updateFrequencyCategoryRelation(FrequencyCategoryRelation frequencyCategoryRelation);
	
	public List<Map> getFrequencyCategoryRelationListById(Map map);
	
	public int deleteFrequencyCategoryRelationById(int id);
}
