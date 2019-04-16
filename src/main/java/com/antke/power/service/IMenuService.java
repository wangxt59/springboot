package com.antke.power.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.antke.power.model.bean.Menu;
import com.antke.website.model.bean.PageInfo;

public interface IMenuService {
	
	@Transactional(propagation = Propagation.REQUIRED)
	/**
	 * 查询菜单列表分页
	 * @param map
	 * @return
	 */
	public PageInfo<Menu> queryMenuListByPage(PageInfo<Menu> pageInfo,Map map);
	/**
	 * 查询菜单列表
	 * @param map
	 * @return
	 */
	public List queryMenuList(Map map);
	/**
	 * 新增菜单信息
	 * @param menu
	 * @return
	 */
	public int insertMenu(Menu menu);

	/**
	 * 更新菜单信息
	 * @param menu
	 * @return
	 */
	public int updateMenu(Menu menu);

	/**
	 * 查询菜单信息
	 * @param map
	 * @return
	 */
	public Menu queryMenu(Map map);
	
	/**
	 * 删除菜单
	 * @param menu_id
	 * @return
	 */
	public int deleteMenu(Map map);
	
}
