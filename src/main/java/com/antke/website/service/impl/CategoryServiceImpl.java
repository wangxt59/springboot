package com.antke.website.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antke.website.dao.CategoryDao;
import com.antke.website.model.bean.Category;
import com.antke.website.model.bean.PageInfo;
import com.antke.website.service.ICategoryService;
@Service
public class CategoryServiceImpl implements ICategoryService{
	
	private final static Log log = LogFactory.getLog(CategoryServiceImpl.class);
	@Autowired
	public CategoryDao categoryDao;
	
	//查询分类列表信息带分页
	@Override
	public PageInfo<Category> queryCategoryListByPage(PageInfo<Category> pageInfo, Map map) {
		int totalRecord = categoryDao.queryCategoryListCount(map);
		RowBounds rowBounds = new RowBounds(pageInfo.getStartRow(), pageInfo.getPageSize());
		List<Category> datas = categoryDao.queryCategoryListByPage(rowBounds, map);
		pageInfo.init(String.valueOf(pageInfo.getCurrentPage()), totalRecord, datas);
		return pageInfo;
	}

	@Override
	public int insertCategory(Category category) {
		return categoryDao.insertCategory(category);
	}

	@Override
	public Category queryCategory(Map map) {
		return categoryDao.queryCategory(map);
	}

	@Override
	public int updateCategory(Category category) {
		return categoryDao.updateCategory(category);
	}

	@Override
	public List queryCategoryList(Map map) {
		return categoryDao.queryCategoryList(map);
	}
	
	@Override
	public List queryCategoryLists(Map map) {
		return categoryDao.queryCategoryLists(map);
	}
	
	@Override
	public List queryCategoryListsByPid(String category_id) {
		return categoryDao.selectByPrimaryKey1(category_id);
	}

}
