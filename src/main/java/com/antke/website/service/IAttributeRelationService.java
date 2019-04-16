package com.antke.website.service;

import java.util.List;
import java.util.Map;

import com.antke.website.model.bean.Attribute;
import com.antke.website.model.bean.AttributeRelation;
import com.antke.website.model.bean.AttributeValue;
import com.antke.website.model.bean.PageInfo;

public interface IAttributeRelationService {
	

	/**
	 * 新增属性关系信息
	 */
	public int insertAttributeRelation(AttributeRelation attributeRelation);
	
	/**
	 * 更新属性关系
	 */
	public int updateAttributeRelation(AttributeRelation attributeRelation);
	
	/**
	 * 删除属性关系
	 */
	public void deleteAttributeRelation(int relation_id);
	
	/**
	 * 查询属性关系
	 */
	public List<AttributeRelation> queryAttributeRelation(Map map);
	
	/**
	 * 查询属性关系列表
	 */
	public List<AttributeRelation> queryAttributeRelationList(Map<String, Object> map);
	
	/**
	 * 查询分类属性列表
	 * @param map
	 * @return
	 */
	public List<Attribute> queryAttributeList(Map<String, Object> map);
	/**
	 * 查询属性关系列表带分页
	 */
	public PageInfo<AttributeRelation> queryAttributeRelationListByPage(PageInfo<AttributeRelation> pageInfo,Map map);

	/**
	 *  查询单个属性ID的方法
	 */
	public List queryAttributeRelationList1(Map map);
	
	/**
	 *  查询单个属性值ID得方法
	 */
	public List queryAttributeRelationList2(Map map);
	
	/**
	 * 删除属性关系的方法
	 */
	public AttributeRelation deleteAttributeRelation(Map map);
	
	
	/**
	 * 查询分类属性列表
	 * @param map
	 * @return
	 */
	public List<AttributeValue> queryAttributeValueList(Map<String, Object> map);
	
	/**
	 * 查询分类属性列表
	 * @param map
	 * @return
	 */
	public List<AttributeRelation> queryCateExtendAttrIsExist(String category_id);
	
}




