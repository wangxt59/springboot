package com.website.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.website.bean.Attribute;
import com.website.bean.AttributeRelation;
import com.website.bean.AttributeValue;


public interface AttributeRelationDao {
	
	/**
	 * 新增属性关系
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
	 * 查询属性关系
	 */
	public List<AttributeRelation> queryAttributeRelation(Map map);
	
	/**
	 * 查询属性列表总数
	 */
	public int queryAttributeRelationListCount(Map map);
	
	/**
	 * 查询属性列表带分页
	 */
	public List queryAttributeRelationListByPage(RowBounds rowBounds,Map map);
	
	/**
	 * 查询单个属性ID的方法
	 */
	public List queryAttributeRelationList1(Map map);
	
	/**
	 * 查询属性值ID的方法
	 */
	public List queryAttributeRelationList2(Map map);
	
	/**
	 * 删除关联关系的方法
	 */
	public AttributeRelation deleteAttributeRelation(Map map);
	
	
	/**
	 * 查询分类属性列表
	 * @param map
	 * @return
	 */
	public List<AttributeValue> queryAttributeValueList(Map<String, Object> map);
	
	
	/**
	 * 查询属性值ID的方法
	 */
	public List<AttributeRelation> queryCateExtendAttrIsExist(String attrId);
	
}
