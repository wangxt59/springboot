package com.power.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.power.bean.GMMaping;
import com.power.bean.PowerGroup;
import com.power.dao.PowerGroupDao;
import com.power.service.IPowerGroupService;
import com.website.bean.PageInfo;
@Service
public class PowerGroupServiceImpl implements IPowerGroupService{
	
	private final static Log log = LogFactory.getLog(PowerGroupServiceImpl.class);
	@Autowired
	public PowerGroupDao powerGroupDao;
	
	//查询权限组带分页
	@Override
	public PageInfo<PowerGroup> queryPowerGroupListByPage(PageInfo<PowerGroup> pageInfo,Map map){
		int totalRecord = powerGroupDao.queryPowerGroupListCount(map);
		RowBounds rowBounds = new RowBounds(pageInfo.getStartRow(), pageInfo.getPageSize());
		List<PowerGroup> datas = powerGroupDao.queryPowerGroupListByPage(rowBounds, map);
		pageInfo.init(String.valueOf(pageInfo.getCurrentPage()), totalRecord, datas);
		return pageInfo;
	}

	@Override
	public int deletePowerGroup(String rolesId) {
		return powerGroupDao.deletePowerGroup(rolesId);
	}

	@Override
	public int insertPowerGroup(PowerGroup powerGroup) {
		return powerGroupDao.insertPowerGroup(powerGroup);
	}

	@Override
	public PowerGroup queryPowerGroup(Map map) {
		return powerGroupDao.queryPowerGroup(map);
	}

	@Override
	public int updatePowerGroup(PowerGroup powerGroup) {
		return powerGroupDao.updatePowerGroup(powerGroup);
	}

	@Override
	public List queryPowerGroupList(Map map) {
		return powerGroupDao.queryPowerGroupList(map);
	}

	@Override
	public int deleteGroups(String role_id) {
		return powerGroupDao.deleteGroupsByRoleId(role_id);
	}

	@Override
	public int insertRoleGroup(Map map) {
		return powerGroupDao.insertRoleGroup(map);
	}

	@Override
	public int insertGroupMenu(GMMaping gmMaping) {
		return powerGroupDao.insertGroupMenu(gmMaping);
	}

	@Override
	public List queryGroupMenuList(Map map) {
		return powerGroupDao.queryGroupMenuList(map);
	}

	@Override
	public int deleteGroupMenu(Map map) {
		return powerGroupDao.deleteGroupMenu(map);
	}

	

}
