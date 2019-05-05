package com.power.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.power.bean.RUMaping;
import com.power.bean.RolesInfo;

@Repository
@Mapper
public interface RolesDao {

	/**
	 * 更新角色信息
	 * @param Goods
	 * @return
	 */
	public int updateRoles(RolesInfo rolesInfo);

	/**
	 * 查询角色信息列表
	 * @param map
	 * @return
	 */
	public List queryRolesListByPage(RowBounds rowBounds,Map map);
	
	/**
	 * 查询角色信息
	 * @param map
	 * @return
	 */
	public RolesInfo queryRolesInfo(Map map);
	
	/**
	 * 新增角色信息
	 * @param Goods
	 * @return
	 */
	public int insertRolesInfo(RolesInfo rolesInfo);
	
	
	/**
	 * 删除角色分类关系
	 * @param goods_id
	 * @return
	 */
	public int deleteRolesInfo(String roles_id);
	
	
	/**
	 * 查询角色信息总数
	 * @param map
	 * @return
	 */
	public int queryRolesListCount(Map map);
	
	
	/**
	 * 查询角色的权限组列表
	 * @param map
	 * @return
	 */
	public List<Map> queryRolesGroupsList(Map map);
	/**
	 * 查询角色没有关联的权限组列表
	 * @param map
	 * @return
	 */
	public List<Map> queryNotRolesGroupsList(Map map);
	/**
	 * 新增用户角色关系
	 * @param ruMaping
	 * @return
	 */
	public int insertRoleUser(RUMaping ruMaping);
	
	/**
	 * 删除用户角色关系
	 * @param user_id
	 * @return
	 */
	public int deleteRoleUser(String user_id);
	
	/**
	 * 查询用户角色关系
	 * @param map
	 * @return
	 */
	public List queryRUMapingList(Map map);
	/**
	 * 获取角色列表
	 * @param map
	 * @return
	 */
	public List queryRolesList(Map map);
	/**
	 * 查询角色信息
	 * @param id
	 * @return
	 */
	public RolesInfo queryRoleById(String id);
	/**
	 * 获取角色用户关系列表
	 * @param map
	 * @return
	 */
	public List queryRolesUserList(Map map);
	
	/**
	 * 获取角色对应权限组
	 * @param map
	 * @return
	 */
	public List queryRGroupsList(Map map);
	/**
	 * 获取权限组对应菜单列表
	 * @param map
	 * @return
	 */
	public List queryGMenuList(Map map);

	/**
	 * 描述: 根据user_id查询角色关联信息
	 */
	public RUMaping selectByUserId(String user_id);

	/**
	 * 描述: 更新角色关系信息
	 */
	public int updateRuMaping(RUMaping ruMaping);
}
