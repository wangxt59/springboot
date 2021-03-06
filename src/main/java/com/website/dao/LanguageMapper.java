package com.website.dao;

import java.util.List;
import java.util.Map;

import com.website.bean.Language;

public interface LanguageMapper {
    int insert(Language record);

    int insertSelective(Language record);

    Language selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Language record);

    int updateByPrimaryKey(Language record);
    
     
	public List queryLanguageList(Map map);
}