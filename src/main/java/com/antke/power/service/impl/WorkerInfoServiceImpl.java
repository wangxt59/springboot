package com.antke.power.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antke.power.dao.RolesDao;
import com.antke.power.dao.WorkerInfoDao;
import com.antke.power.model.bean.RUMaping;
import com.antke.power.model.bean.RolesInfo;
import com.antke.power.model.bean.WorkerInfo;
import com.antke.power.service.IWorkerInfoService;
import com.antke.website.model.bean.PageInfo;
import com.antke.website.utils.CommonsUtil;
import com.antke.website.utils.DateUtil;
import com.antke.website.utils.MD5;
@Service
public class WorkerInfoServiceImpl implements IWorkerInfoService{
	
	private final static Log log = LogFactory.getLog(WorkerInfoServiceImpl.class);
	@Autowired
	public WorkerInfoDao workerInfoDao;

	@Autowired
	public RolesDao rolesDao;
//	删除员工信息
	@Override
	public int deleteWorkerInfo(String work_id) {
		return workerInfoDao.deleteWorkerInfo(work_id);
	}

//	新增员工信息操作
	@Override
	public int insertWorkerInfo(WorkerInfo worker,WorkerInfo workerInfo) {
		int count = 0;
		try {
			String nowdate = DateUtil.getSysTime();
			String worker_id = CommonsUtil.getPrimaryKey();
			/*//		设置默认城市编号（仅供测试使用）
			worker.setProvince("test");
			worker.setCity("test");
			worker.setDistrict("test");*/
	//		设置员工初始信息
			worker.setPassword(MD5.encode(worker.getPassword(), null));
			worker.setWorker_id(worker_id);
			worker.setStatus("0");
			worker.setLogin_num(0);
			worker.setIsfirst("0");
			worker.setCreate_date(nowdate);
			worker.setUpdate_date(nowdate);
			if(!workerInfo.getLogin_name().equals("admin")){
				System.out.println("**********************"+workerInfo.getLogin_name()+worker.getChant_id());
				worker.setChant_id(workerInfo.getChant_id());
			}
			List rolesIdList = worker.getRolesIdList();
			int rank = -1;
			if(rolesIdList!=null && rolesIdList.size()>0){
				for(int i=0;i<rolesIdList.size();i++){
					String role_id = (String)rolesIdList.get(i);
					RolesInfo rolesInfo = rolesDao.queryRoleById(role_id);
			//		rank = rolesInfo.getRank();
					RUMaping ruMaping = new RUMaping();
					String ru_id = "RU"+CommonsUtil.getPrimaryKey();
					ruMaping.setRu_id(ru_id);
					ruMaping.setR_id(role_id);
					ruMaping.setUser_id(worker_id);
					ruMaping.setCreate_date(new Date());//发表时间
					ruMaping.setUpdate_date(new Date());//更新时间
					ruMaping.setOperator(workerInfo.getWorker_id());
					rolesDao.insertRoleUser(ruMaping);
				}
			}
			worker.setRank(rank);
			System.out.println("**********************"+worker);
			count = workerInfoDao.insertWorkerInfo(worker);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return count;
	}

//	查询单个员工信息
	@Override
	public WorkerInfo queryWorkerInfo(Map map) {
		return workerInfoDao.queryWorkerInfo(map);
	}

//	查询员工列表
	@Override
	public List queryWorkerInfoList(Map map) {
		return workerInfoDao.queryWorkerInfoList(map);
	}

//	更新员工信息
	@Override
	public int updateWorkerInfo(WorkerInfo worker,WorkerInfo workerInfo) {
		int count = 0;
		String update_date = DateUtil.getSysTime();//当前时间
		worker.setUpdate_date(update_date);
		try {
			if(worker.getPassword()!=null && !"".equals(worker.getPassword()) && !"null".equals(worker.getPassword()) ){
				worker.setPassword(MD5.encode(worker.getPassword(), null));
			}
			String roleId = worker.getRoleId();	
			count = workerInfoDao.updateWorkerInfo(worker);
			
			String worker_id = worker.getWorker_id();
			String[] roleIds = roleId.split(",");
			if(roleId!=null){
				rolesDao.deleteRoleUser(worker_id);
				for(int i=0;i<roleIds.length;i++){
					String role_id = roleIds[i];
					RUMaping ruMaping = new RUMaping();
					String ru_id = "RU"+CommonsUtil.getPrimaryKey();
					ruMaping.setRu_id(ru_id);
					ruMaping.setR_id(role_id);
					ruMaping.setUser_id(worker_id);
					ruMaping.setCreate_date(new Date());//发表时间
					ruMaping.setUpdate_date(new Date());//更新时间
					ruMaping.setOperator(workerInfo.getWorker_id());
					rolesDao.insertRoleUser(ruMaping);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
//	更新员工信息
	@Override
	public int updateWorkerInfo(WorkerInfo worker) {
		
		return workerInfoDao.updateWorkerInfo(worker);
	}

//	查询员工列表信息带分页
	@Override
	public PageInfo<WorkerInfo> queryWorkerInfoListByPage(
			PageInfo<WorkerInfo> pageInfo, Map map) {
		int totalRecord = workerInfoDao.queryWorkerInfoListCount(map);
		RowBounds rowBounds = new RowBounds(pageInfo.getStartRow(), pageInfo.getPageSize());
		List<WorkerInfo> datas = workerInfoDao.queryWorkerInfoListByPage(rowBounds, map);
		pageInfo.init(String.valueOf(pageInfo.getCurrentPage()), totalRecord, datas);
		return pageInfo;
	}

	@Override
	public WorkerInfo queryWorkerCodeIsExist(String workerCode) {
		return workerInfoDao.queryWorkerCodeIsExist(workerCode);
	}
	@Override
	public WorkerInfo queryLoginNameIsExist(String login_name) {
		return workerInfoDao.queryLoginNameIsExist(login_name);
	}

	/**
	 * 描述: 新增员工手机号验重
	 */
	@Override
	public WorkerInfo selectWorkerByContact(String contact) {
		return workerInfoDao.selectWorkerByContact(contact);
	}
/**
	 * 描述: 根据商户id查询所有worker
	 */
	@Override
	public List<WorkerInfo> selectWorkerById(Integer chant_id) {
		return workerInfoDao.selectWorkerById(chant_id);
	}
 
	/**
	 * 描述: 根据worker_id查询员工
	 */
	@Override
	public WorkerInfo selectWorkerByWorkerId(String worker_id) {
		return workerInfoDao.selectWorkerByWorkerId(worker_id);
	}

}
