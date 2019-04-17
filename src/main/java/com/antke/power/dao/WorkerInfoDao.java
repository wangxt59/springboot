package com.antke.power.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.antke.power.model.bean.WorkerInfo;

@Repository
@Mapper
public interface WorkerInfoDao {
	
	/**
	 * 查询员工信息总数
	 * @param map
	 * @return
	 */
	public int queryWorkerInfoListCount(Map map);
	
	/**
	 * 查询资讯评论列表带分页
	 * @param map
	 * @return
	 */
	public List queryWorkerInfoListByPage(RowBounds rowBounds, Map map);
	
	/**
	 * 新增员工信息
	 * @param workInfo
	 * @return
	 */
	public int insertWorkerInfo(WorkerInfo workerInfo);

	/**
	 * 更新员工信息
	 * @param workInfo
	 * @return
	 */
	public int updateWorkerInfo(WorkerInfo workerInfo);

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
	 * @param worker_id
	 * @return
	 */
	public int deleteWorkerInfo(String worker_id);
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
	 * 描述: 查询员工管理的货柜
	 */
	public List<Map<String, Object>> selectCabinetWithWorker(Map map);

	/**
	 * 描述: 根据worker_id查询员工
	 */
	public WorkerInfo selectWorkerByWorkerId(String workerId);

}
