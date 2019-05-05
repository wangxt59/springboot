package com.website.dao;

import java.util.List;
import java.util.Map;

import com.website.bean.AttributeValue;


public interface AttributeValueDao {
	
	/**
	 * 新增属性值
	 */
	public int insertAttributeValue(AttributeValue attributeValue);

	/**
	 * 更新属性值
	 */
	public int updateAttributeValue(AttributeValue attributeValue);
	
	/**
	 * 删除属性值
	 */
	public int deleteAttributeValue(String value_id);
	
	/**
	 * 查询属性值
	 */
	public AttributeValue queryAttributeValue(Map map);
	
	/**
	 * 单独查询属性值
	 */
	public List queryAttributeValue1(Map map);
	
	/**
	 * 查询属性值列表
	 */
	public List queryAttributeValueList(Map map);
	
	/**
	 * 删除属性值的方法
	 */
	public AttributeValue deleteAttributeValue(Map map );
	
	
	public int delAttributeValue(Map map);
	
	
	
	
	/**
	 * 根据属性id查询属性值列表
	 * @param map
	 * @return
	 */
	public List queryAttributeValueListAtIF(Map map);
	
}
