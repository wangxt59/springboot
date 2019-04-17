package com.antke.power.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.antke.power.model.bean.GMMaping;
import com.antke.power.model.bean.PowerGroup;

@Repository
@Mapper
public interface PowerGroupDao {
	
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
	 * 查询权限组信息总数
	 * @param map
	 * @return
	 */
	public int queryPowerGroupListCount(Map map);
	
	/**
	 * 查询权限组列表带分页
	 * @param map
	 * @return
	 */
	public List queryPowerGroupListByPage(RowBounds rowBounds, Map map);
	/**
	 * 查询权限组列表
	 * @param map
	 * @return
	 */
	public List queryPowerGroupList(Map map);
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
	public int deleteGroupsByRoleId(String role_id);
	
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
