package com.antke.website.service;

import java.util.List;
import java.util.Map;

import com.antke.website.model.bean.AttributeValue;


public interface IAttributeValueService {
	
	/**
	 * 新增属性值
	 */
	public int insertAttributeValue(AttributeValue attributeValue);
	
	/**
	 * 更新属性值
	 */
	public int updateAttributeValue(AttributeValue attributeValue);
	
	/**
	 * 删除属性
	 */
	public int deleteAttributeValue(String value_id);
	
	/**
	 * 查询属性值
	 */
	public AttributeValue queryAttributeValue(Map map);
	
	/**
	 * 查询属性值列表
	 */
	public List queryAttributeValueList(Map map);
	
	/**
	 * 查询单个属性值
	 */
	public List queryAttributeValue1(Map map);
	
	/**
	 * 删除属性值的方法
	 */
	public AttributeValue deleteAttributeValue(Map map);
	
	public int delAttributeValue(Map map);
}
