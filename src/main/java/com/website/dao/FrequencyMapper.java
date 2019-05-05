package com.website.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.website.bean.Frequency;

public interface FrequencyMapper {
    int insert(Frequency record);

    int insertSelective(Frequency record);

    Frequency selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Frequency record);

    int updateByPrimaryKey(Frequency record);
    
    
    public int queryFrequencyListCount(Map map);
	
  	public List<Frequency> queryFrequencyListByPages(RowBounds rowBounds, Map map);
  	
  	public Frequency qyById(Map map);
  	public Frequency qyByCategoryId(Map map);
  	public Frequency qyByGoodsId(Map map);
}