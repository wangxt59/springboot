package com.power.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.power.bean.Menu;
import com.power.dao.MenuDao;
import com.power.service.IMenuService;
import com.website.bean.PageInfo;
@Service
public class MenuServiceImpl implements IMenuService{
	
	private final static Log log = LogFactory.getLog(MenuServiceImpl.class);
	@Autowired
	public MenuDao menuDao;
	
	//查询菜单带分页
	@Override
	public PageInfo<Menu> queryMenuListByPage(PageInfo<Menu> pageInfo,Map map){
		int totalRecord = menuDao.queryMenuListCount(map);
		RowBounds rowBounds = new RowBounds(pageInfo.getStartRow(), pageInfo.getPageSize());
		List<Menu> datas = menuDao.queryMenuListByPage(rowBounds, map);
		pageInfo.init(String.valueOf(pageInfo.getCurrentPage()), totalRecord, datas);
		return pageInfo;
	}

	@Override
	public int deleteMenu(Map map) {
		return menuDao.deleteMenu(map);
	}

	@Override
	public int insertMenu(Menu menu) {
		return menuDao.insertMenu(menu);
	}

	@Override
	public Menu queryMenu(Map map) {
		return menuDao.queryMenu(map);
	}

	@Override
	public int updateMenu(Menu menu) {
		return menuDao.updateMenu(menu);
	}

	@Override
	public List queryMenuList(Map map) {
		return menuDao.queryMenuList(map);
	}


}
