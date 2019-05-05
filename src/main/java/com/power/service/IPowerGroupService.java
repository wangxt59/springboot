package com.power.service;

import java.util.List;
import java.util.Map;

import com.power.bean.GMMaping;
import com.power.bean.PowerGroup;
import com.website.bean.PageInfo;

public interface IPowerGroupService {
	
	/**
	 * 查询权限组列表分页
	 * @param map
	 * @return
	 */
	public PageInfo<PowerGroup> queryPowerGroupListByPage(PageInfo<PowerGroup> pageInfo,Map map);
	/**
	 * 查询权限组列表
	 * @param map
	 * @return
	 */
	public List queryPowerGroupList(Map map);
	/**
	 * 新增权限组信息
	 * @param powerGroup
	 * @return
	 */
	public int insertPowerGroup(PowerGroup powerGroup);

	/**
	 * 更新权限组信息
	 * @param powerGroup
	 * @return
	 */
	public int updatePowerGroup(PowerGroup powerGroup);

	/**
	 * 查询权限组信息
	 * @param map
	 * @return
	 */
	public PowerGroup queryPowerGroup(Map map);
	
	/**
	 * 删除权限组
	 * @param powerGroup_id
	 * @return
	 */
	public int deletePowerGroup(String powerGroup_id);
	
	/**
	 * 删除权限组
	 * @param powerGroup_id
	 * @return
	 */
	public int deleteGroups(String powerGroup_id);
	
	/**
	 * 新增角色与权限组关联
	 * @param powerGroup
	 * @return
	 */
	public int insertRoleGroup(Map map);
	
	/**
	 * 新增菜单与权限组关联
	 * @param gmMaping
	 * @return
	 */
	public int insertGroupMenu(GMMaping gmMaping);
	
	/**
	 * 查询权限组菜单信息
	 * @param map
	 * @return
	 */
	public List queryGroupMenuList(Map map);
	
	/**
	 * 删除权限菜单关系
	 * @param map
	 * @return
	 */
	public int deleteGroupMenu(Map map);
	
}
