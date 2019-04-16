package com.antke.website.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antke.website.dao.FrequencyMapper;
import com.antke.website.model.bean.Frequency;
import com.antke.website.model.bean.PageInfo;
import com.antke.website.service.IFrequencyService;

@Service
public class FrequencyServiceImpl implements IFrequencyService {

	@Autowired
	FrequencyMapper frequencyMapper;

 
	@Override
	public int addFrequency(Frequency frequency) {
		return frequencyMapper.insertSelective(frequency);
	}

	@Override
	public PageInfo<Frequency> queryFrequencyListByPages(PageInfo<Frequency> pageInfo, Map<String, Object> map) {
		int count = frequencyMapper.queryFrequencyListCount(map);
		RowBounds rowBounds = new RowBounds(pageInfo.getStartRow(),pageInfo.getPageSize());
		List<Frequency> frequencyList = frequencyMapper.queryFrequencyListByPages(rowBounds, map);
		pageInfo.init(String.valueOf(pageInfo.getCurrentPage()), count,frequencyList);
		return pageInfo;
	}

	@Override
	public Frequency qyById(Map map) {
		return frequencyMapper.qyById(map);
	}
 
	@Override
	public Frequency qyByCategoryId(Map map) {
		return frequencyMapper.qyByCategoryId(map);
	}
	@Override
	public Frequency qyByGoodsId(Map map) {
		return frequencyMapper.qyByGoodsId(map);
	}
	
	@Override
	public int updateFrequency(Frequency frequency) {
		return frequencyMapper.updateByPrimaryKeySelective(frequency);
	}

}
