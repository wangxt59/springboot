package com.website.service;

import java.util.List;
import java.util.Map;

import com.website.bean.Attribute;


public interface IAttributeService {
	
	/**
	 * 新增属性
	 */
	public int insertAttribute(Attribute attribute);

	/**
	 * 更新属性
	 */
	public int updateAttribute(Attribute attribute);
	
	/**
	 * 删除属性 
	 */
	public int deleteAttribute(String attr_id);
	
	/**
	 * 查询属性信息
	 */
	public Attribute queryAttribute(Map map);
	
	/**
	 * 查询属性列表
	 */
	public List queryAttributeList(Map map);
	
	/**
	 * 查询属性名称列表
	 */
	public List queryAttributeList1(Map map);
	
	
	/**
	 *查询分类的属性项
	 * @param map
	 * @return
	 *  @author bizifei
	 */
	public List queryCategoryAttr(Map map );
	/**
	 * 指定属性项的属性值
	 * @param map
	 * @return
	 * @author bizifei
	 */
	public List queryAttrValueList(Map map );
}
