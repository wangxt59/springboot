package com.antke.website.service;

import java.util.Map;

import com.antke.website.model.bean.Frequency;
import com.antke.website.model.bean.PageInfo;

 
public interface IFrequencyService {
 
	public int addFrequency(Frequency frequency);
 
	public PageInfo<Frequency> queryFrequencyListByPages(PageInfo<Frequency> pageInfo, Map<String, Object> map);
	
	public Frequency qyById(Map map);
 
	public int updateFrequency(Frequency frequency);
	
	public Frequency qyByCategoryId(Map map);
	
	public Frequency qyByGoodsId(Map map);
	

}
