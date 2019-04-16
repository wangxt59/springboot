package com.antke.website.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antke.website.dao.FrequencyCategoryRelationMapper;
import com.antke.website.model.bean.FrequencyCategoryRelation;
import com.antke.website.service.IFrequencyCategoryRelationService;

@Service
public class FrequencyCategoryRelationServiceImpl implements IFrequencyCategoryRelationService {

	@Autowired
	public FrequencyCategoryRelationMapper frequencyCategoryRelationMapper;

 
	@Override
	public int addFrequencyCategoryRelation(FrequencyCategoryRelation frequencyCategoryRelation) {
		return frequencyCategoryRelationMapper.insertSelective(frequencyCategoryRelation);
	}

	@Override
	public int updateFrequencyCategoryRelation(FrequencyCategoryRelation frequencyCategoryRelation) {
		return frequencyCategoryRelationMapper.updateByPrimaryKeySelective(frequencyCategoryRelation);
	}
	
	@Override
	public List<Map> getFrequencyCategoryRelationListById(Map map) {
		return frequencyCategoryRelationMapper.getFrequencyCategoryRelationListById(map);
	}
	
	public int deleteFrequencyCategoryRelationById(int id) {
		return  frequencyCategoryRelationMapper.deleteFrequencyCategoryRelationById(id);
	}

}
