package com.website.service;

import java.util.Map;

import com.website.bean.Frequency;
import com.website.bean.PageInfo;

 
public interface IFrequencyService {
 
	public int addFrequency(Frequency frequency);
 
	public PageInfo<Frequency> queryFrequencyListByPages(PageInfo<Frequency> pageInfo, Map<String, Object> map);
	
	public Frequency qyById(Map map);
 
	public int updateFrequency(Frequency frequency);
	
	public Frequency qyByCategoryId(Map map);
	
	public Frequency qyByGoodsId(Map map);
	

}
