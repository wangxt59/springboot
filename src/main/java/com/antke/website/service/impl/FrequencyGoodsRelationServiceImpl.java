package com.antke.website.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antke.website.dao.FrequencyGoodsRelationMapper;
import com.antke.website.model.bean.FrequencyGoodsRelation;
import com.antke.website.service.IFrequencyGoodsRelationService;

@Service
public class FrequencyGoodsRelationServiceImpl implements IFrequencyGoodsRelationService {

	@Autowired
	public FrequencyGoodsRelationMapper frequencyGoodsRelationMapper;

 
	@Override
	public int addFrequencyGoodsRelation(FrequencyGoodsRelation frequencyGoodsRelation) {
		return frequencyGoodsRelationMapper.insertSelective(frequencyGoodsRelation);
	}

	@Override
	public int updateFrequencyGoodsRelation(FrequencyGoodsRelation frequencyGoodsRelation) {
		return frequencyGoodsRelationMapper.updateByPrimaryKeySelective(frequencyGoodsRelation);
	}
	
	@Override
	public List<Map> getFrequencyGoodsRelationListById(Map map) {
		return frequencyGoodsRelationMapper.getFrequencyGoodsRelationListById(map);
	}
	
	public int deleteFrequencyGoodsRelationById(int id) {
		return  frequencyGoodsRelationMapper.deleteFrequencyGoodsRelationById(id);
	}

}
