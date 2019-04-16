package com.antke.website.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.antke.website.model.bean.Category;

@Repository
public interface CategoryDao {
	
	/**
	 * 新增分类信息
	 * @param category
	 * @return
	 */
	public int insertCategory(Category category);

	/**
	 * 更新分类信息
	 * @param category
	 * @return
	 */
	public int updateCategory(Category category);

	/**
	 * 查询分类信息
	 * @param map
	 * @return
	 */
	public Category queryCategory(Map map);
	

	/**
	 * 查询分类信息总数
	 * @param map
	 * @return
	 */
	public int queryCategoryListCount(Map map);
	
	/**
	 * 查询分类列表带分页
	 * @param map
	 * @return
	 */
	public List queryCategoryListByPage(RowBounds rowBounds, Map map);
	/**
	 * 查询分类列表
	 * @param map
	 * @return
	 */
	public List queryCategoryList(Map map);
	/**
	 * 查询分类列表
	 * @param map
	 * @return
	 */
	public List queryCategoryLists(Map map);
	
	public List selectByPrimaryKey1(String category_id);
}
