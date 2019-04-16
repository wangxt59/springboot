package com.antke.power.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antke.power.dao.RolesDao;
import com.antke.power.model.bean.RUMaping;
import com.antke.power.model.bean.RolesInfo;
import com.antke.power.service.IRolesService;
import com.antke.website.model.bean.PageInfo;
@Service
public class RolesServiceImpl implements IRolesService{
	
	private final static Log log = LogFactory.getLog(RolesServiceImpl.class);
	@Autowired
	public RolesDao rolesDao;
	
	//查询商品列表信息带分页
	@Override
	public PageInfo<RolesInfo> queryRolesListByPage(PageInfo<RolesInfo> pageInfo,Map map){
		int totalRecord = rolesDao.queryRolesListCount(map);
		RowBounds rowBounds = new RowBounds(pageInfo.getStartRow(), pageInfo.getPageSize());
		List<RolesInfo> datas = rolesDao.queryRolesListByPage(rowBounds, map);
		pageInfo.init(String.valueOf(pageInfo.getCurrentPage()), totalRecord, datas);
		return pageInfo;
	}

	@Override
	public int deleteRolesInfo(String rolesId) {
		return rolesDao.deleteRolesInfo(rolesId);
	}

	@Override
	public int insertRolesInfo(RolesInfo rolesInfo) {
		return rolesDao.insertRolesInfo(rolesInfo);
	}

	@Override
	public RolesInfo queryRolesInfo(Map map) {
		return rolesDao.queryRolesInfo(map);
	}

	@Override
	public int updateRoles(RolesInfo rolesInfo) {
		return rolesDao.updateRoles(rolesInfo);
	}

	@Override
	public List<Map> queryRolesGroupsList(Map map) {
		return rolesDao.queryRolesGroupsList(map);
	}
	@Override
	public List<Map> queryNotRolesGroupsList(Map map) {
		return rolesDao.queryNotRolesGroupsList(map);
	}

	@Override
	public List queryRolesList(Map map) {
		return rolesDao.queryRolesList(map);
	}

	@Override
	public List queryRolesUserList(Map map) {
		return rolesDao.queryRolesUserList(map);
	}

	@Override
	public List queryRGroupsList(Map map) {
		return rolesDao.queryRGroupsList(map);
	}

	@Override
	public List queryGMenuList(Map map) {
		return rolesDao.queryGMenuList(map);
	}

	@Override
	public int insertRoleUser(RUMaping ruMaping) {
		return rolesDao.insertRoleUser(ruMaping);
	}

	@Override
	public int deleteRoleUser(String user_id) {
		return rolesDao.deleteRoleUser(user_id);
	}
	
	@Override
	public List queryRUMapingList(Map map){
		return rolesDao.queryRUMapingList(map);
	}

	/**
	 * 描述: 根据user_id查询角色关联信息
	 */
	@Override
	public RUMaping selectByUserId(String user_id) {
		return rolesDao.selectByUserId(user_id);
	}

	/**
	 * 描述: 更新角色关系信息
	 */
	@Override
	public int updateRuMaping(RUMaping ruMaping) {
		return rolesDao.updateRuMaping(ruMaping);
	}

}
