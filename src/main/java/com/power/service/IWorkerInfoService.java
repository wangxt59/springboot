package com.power.service;

import java.util.List;
import java.util.Map;

import com.power.bean.WorkerInfo;
import com.website.bean.PageInfo;

public interface IWorkerInfoService {
	
	/**
	 * 查询员工列表带分页
	 * @param pageInfo
	 * @param map
	 * @return
	 */
	public PageInfo<WorkerInfo> queryWorkerInfoListByPage(PageInfo<WorkerInfo> pageInfo, Map map);
	
	/**
	 * 新增员工信息
	 * @param workInfo
	 * @return
	 */
	public int insertWorkerInfo(WorkerInfo worker,WorkerInfo workerInfo);

	/**
	 * 更新员工信息
	 * @param workInfo
	 * @return
	 */
	public int updateWorkerInfo(WorkerInfo worker,WorkerInfo workerInfo);
	
	/**
	 * 更新员工信息
	 * @param workInfo
	 * @return
	 */
	public int updateWorkerInfo(WorkerInfo worker);

	/**
	 * 查询单条员工信息
	 * @param map
	 * @return
	 */
	public WorkerInfo queryWorkerInfo(Map map);
	
	/**
	 * 查询员工信息列表
	 * @param map
	 * @return
	 */
	public List queryWorkerInfoList(Map map);

	/**
	 * @Description 删除员工信息
	 * @param work_id
	 * @return
	 */
	public int deleteWorkerInfo(String work_id);
	/**
	 * 查询员工编号是否存在
	 *(ZHZ)2017-3-31
	 * @param workerCode
	 * @return
	 */
	public WorkerInfo queryWorkerCodeIsExist(String workerCode);
	/**
	 * 查询员工登录名是否存在
	 *(ZHZ)2017-3-31
	 * @param workerCode
	 * @return
	 */
	public WorkerInfo queryLoginNameIsExist(String login_name);

	/**
	 * 描述: 新增员工手机号验重
	 */
	public WorkerInfo selectWorkerByContact(String contact);
	/**
	 * 描述: 根据商户id查询所有worker
	 */
	public List<WorkerInfo> selectWorkerById(Integer chant_id);
 

	/**
	 * 描述: 根据worker_id查询员工
	 */
	public WorkerInfo selectWorkerByWorkerId(String worker_id);
}
