package com.antke.website.service;

import java.util.List;
import java.util.Map;

import com.antke.website.model.bean.Category;
import com.antke.website.model.bean.PageInfo;

public interface ICategoryService {
	
	/**
	 * 更新分类信息
	 * @param Category
	 * @return
	 */
	public int updateCategory(Category category);

	/**
	 * 查询分类信息列表
	 * @param map
	 * @return
	 */
	public PageInfo<Category> queryCategoryListByPage(PageInfo<Category> pageInfo,Map map);
	
	/**
	 * 查询分类列表
	 * @param map
	 * @return
	 */
	public List queryCategoryList(Map map);
	
	/**
	 * 查询分类信息
	 * @param map
	 * @return
	 */
	public Category queryCategory(Map map);
	
	/**
	 * 新增分类信息
	 * @param Category
	 * @return
	 */
	public int insertCategory(Category category);

	/**
	 * 查询分类列表包含下级分类
	 * @param map
	 * @return
	 */
	public List queryCategoryLists(Map map);
	
	public List queryCategoryListsByPid(String category_id);

}
