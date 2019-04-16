package com.antke.power.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.antke.power.model.bean.Menu;

@Repository
public interface MenuDao {
	
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
	 * 查询菜单信息总数
	 * @param map
	 * @return
	 */
	public int queryMenuListCount(Map map);
	
	/**
	 * 查询菜单列表带分页
	 * @param map
	 * @return
	 */
	public List queryMenuListByPage(RowBounds rowBounds, Map map);
	/**
	 * 查询菜单列表
	 * @param map
	 * @return
	 */
	public List queryMenuList(Map map);
	/**
	 * 删除菜单
	 * @param menu_id
	 * @return
	 */
	public int deleteMenu(Map map);
	
}
