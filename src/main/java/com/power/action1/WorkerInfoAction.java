package com.power.action1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.power.bean.RUMaping;
import com.power.bean.RolesInfo;
import com.power.bean.WorkerInfo;
import com.power.service.IRolesService;
import com.power.service.IWorkerInfoService;
import com.website.action.BaseAction;
import com.website.bean.PageInfo;
import com.website.utils.DateUtil;

/**
 * demo类
 * @author bizf
 */
@Controller
@Scope("prototype")
@RequestMapping("/worker")
public class WorkerInfoAction extends BaseAction {
	
	/**
	 * 生成日志对象
	 */
	private static Logger log = Logger.getLogger(WorkerInfoAction.class);
	
	/**
	 * 查询asp的信息的服务对象
	 */
	@Autowired
	private IWorkerInfoService workerInfoService;
	
	@Autowired
	private IRolesService rolesService;
	
	 
	/**
	 * 查询结果的list
	 */
	private PageInfo<WorkerInfo> pageInfo;//显示分页列表
	
	/**
	 * 查询结果的实体类
	 */
	private WorkerInfo worker;//员工信息实体类

	private String[] rolerarray;//权限列表

	private String worker_id;
	
	private List rolesList;
	
	private List rolesIdList;
	
	private List roleUserList;
	
	private String worker_code;
	/**
	 * 查询员工信息列表操作
	 * @return
	 */
	@RequestMapping("/selectWorkerInfoList.do")
	public ModelAndView selectWorkerInfoList(PageInfo<WorkerInfo> pageInfo,HttpSession session,WorkerInfo worker){
		
		WorkerInfo workerInfo = (WorkerInfo) session.getAttribute("workerInfo");
 
		if (workerInfo == null) {
			return new ModelAndView("redirect:/login/workLogin.action");
		}
		
//		如果是初次访问或新的查询时，重置分页
		if(pageInfo == null || pageInfo.getCurrentPage() == 0){
			pageInfo = new PageInfo<WorkerInfo>();
			pageInfo.setCurrentPage("1");
		}
//		查询咨询信息
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> resultMap = new HashMap<String,Object>();
		if(StringUtils.isNotBlank(worker.getWorker_name())){
			map.put("worker_name", worker.getWorker_name().trim());
			resultMap.put("worker_name", worker.getWorker_name().trim());
		}
		if(StringUtils.isNotBlank(worker.getWorker_code())){
			map.put("worker_code", worker.getWorker_code().trim());
			resultMap.put("worker_code", worker.getWorker_code().trim());
		}
		if(StringUtils.isNotBlank(worker.getCompany())){
			map.put("company", worker.getCompany());
			resultMap.put("company", worker.getCompany());
		}
		if(StringUtils.isNotBlank(worker.getCommunity())){
			map.put("community", worker.getCommunity());
			resultMap.put("community", worker.getCommunity());
		}
		if(StringUtils.isNotBlank(worker.getProfessional())){
			map.put("professional", worker.getProfessional());
			resultMap.put("professional", worker.getProfessional());
		}
		if(StringUtils.isNotBlank(worker.getStatus())){
			map.put("status", worker.getStatus());
			resultMap.put("status", worker.getStatus());
		}else{
			map.put("status", 0);
		}
	 
		pageInfo = workerInfoService.queryWorkerInfoListByPage(pageInfo, map);
		resultMap.put("pageInfo", pageInfo);
		return new ModelAndView("/power/worker/workerinfolist.jsp","map",resultMap);
	}
	
	/**
	 * 进入添加员工信息界面
	 * @return
	 */
	@RequestMapping("/addWorkerPage.do")
	public ModelAndView addWorkerPage(HttpSession session){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		WorkerInfo workerInfo = (WorkerInfo) session.getAttribute("workerInfo");
		resultMap.put("login_name", workerInfo.getLogin_name());
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("status_flg", 1);//0无效，1有效
		List<RolesInfo> rolesList = rolesService.queryRolesList(map);
		resultMap.put("rolesList", rolesList);
		log.info("resultMap+"+resultMap);
		return new ModelAndView("/power/worker/addworkerinfo.jsp","map",resultMap);
	}
	
	/**
	 * 添加员工信息操作
	 * @return
	 */
	@RequestMapping("/insertWorkerInfo.do")
	public String insertWorkerInfo(WorkerInfo worker,HttpSession session){
		try{
			log.info("*****************进入添加操作*****************");
			WorkerInfo workerInfo = (WorkerInfo) session.getAttribute("workerInfo");
			log.info("*****************worker="+worker+",workerInfo="+workerInfo);
			workerInfoService.insertWorkerInfo(worker,workerInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "redirect:selectWorkerInfoList.do";
		
	}
	/**
	 * 查询员工编号是否存在
	 *(ZHZ)2017-3-31
	 * @return
	 */
	@RequestMapping("/checkWorker.do")
	public String  checkWorker(String worker_code,HttpServletResponse response){
		//worker_code
		WorkerInfo workerInfo = workerInfoService.queryWorkerCodeIsExist(worker_code);
		try {
			if(workerInfo!=null){
				response.getWriter().write("no");
			}else{
				response.getWriter().write("ok");
			}
		} catch (IOException e) {
			log.error("响应异常");
		}
		return null;
	}
	/**
	 * 查询员工编号是否存在
	 *(ZHZ)2017-3-31
	 * @return
	 */
	@RequestMapping("/checkLoginName.do")
	public String  checkLoginName(String login_name,HttpServletResponse response){
		WorkerInfo workerInfo = workerInfoService.queryWorkerCodeIsExist(login_name);
		try {
			if(workerInfo!=null){
				response.getWriter().write("no");
			}else{
				response.getWriter().write("ok");
			}
		} catch (IOException e) {
			log.error("响应异常");
		}
		return null;
	}
	/**
	 * 更新员工状态信息操作
	 * @return
	 */
	@RequestMapping("/updateWorkerInfoStatus.do")
	public String updateWorkerInfoStatus(WorkerInfo worker){
		Map map=new HashMap();
		try {
			map.put("worker_id",worker.getWorker_id());
			WorkerInfo temp = workerInfoService.queryWorkerInfo(map);
			temp.setStatus(worker.getStatus());
			String nowdate = DateUtil.getSysTime();
			temp.setUpdate_date(nowdate);
//		执行更新咨询信息操作
			workerInfoService.updateWorkerInfo(temp);
		} catch (Exception e) {
			return "404/404.html";
		}
//		worker_id = temp.getWorker_id();
		return "redirect:selectWorkerInfoList.do";
	}
	
	/**
	 * 进入更新员工信息界面
	 * @return
	 */
	@RequestMapping("/updateWorkerInfoPage.do")
	public ModelAndView updateWorkerInfoPage(WorkerInfo worker){
		Map map = new HashMap();
		Map resultMap = new HashMap();
		map.put("worker_id",worker.getWorker_id());
		worker = workerInfoService.queryWorkerInfo(map);
		map.clear();
		map.put("status_flg", 1); 
		List rolesList = rolesService.queryRolesList(map);
		RUMaping ruMaping = rolesService.selectByUserId(worker.getWorker_id());
 
		resultMap.put("worker", worker);
		resultMap.put("rolesList", rolesList);
		resultMap.put("ruMaping", ruMaping);
		 
		map.clear();
		map.put("chant_id", worker.getChant_id());
		return new ModelAndView("/power/worker/updateworkerinfo.jsp","map",resultMap);
	}
	
	/**
	 * 更新员工信息操作
	 * @return
	 */
	@RequestMapping("/updateWorkerInfo.do")
	public String updateWorkerInfo(WorkerInfo worker,HttpSession session, String rolesIdList){
		WorkerInfo workerInfo = (WorkerInfo) session.getAttribute("workerInfo");
		worker.setRoleId(rolesIdList);
		workerInfoService.updateWorkerInfo(worker,workerInfo);
		
		return "redirect:selectWorkerInfoList.do";
	}
	
	/**
	 * 修改密码
	 */
	public String updatePassword()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		WorkerInfo workerInfo = new WorkerInfo();
		Object object = new Object();
		object = session.getAttribute("workerInfo");	
		workerInfo = (WorkerInfo)object;
		worker.setWorker_id(workerInfo.getWorker_id());
		
		int number = workerInfoService.updateWorkerInfo(worker);
		if(number > 0)
		{
			request.setAttribute("msge", "true");
			return  "success";
		}
		
		request.setAttribute("msg", "修改密码错误");
		return "failed";
		
		
	}
	
	/**
	 * 由数据返回用户数据
	 */
	
	public String queryUserInfo()
	{
		try {
			String oldpassword = request.getParameter("oldpassword").toString();
			if (oldpassword != "" && !oldpassword.isEmpty()) {
				HttpServletRequest request = ServletActionContext.getRequest();
				HttpSession session = request.getSession();
				WorkerInfo workerInfo = new WorkerInfo();
				Object object = new Object();
				object = session.getAttribute("workerInfo");
				workerInfo = (WorkerInfo) object;
				HashMap map = new HashMap();
				map.put("password", oldpassword);
				map.put("worker_id", workerInfo.getWorker_id());

				WorkerInfo workerInf = new WorkerInfo();
				workerInf = workerInfoService.queryWorkerInfo(map);
				if (workerInf != null) {
					PrintWriter out = response.getWriter();
					//response顾名思义就是服务器对浏览器的相应，PrintWriter它的实例就是向前台的JSP页面输出结果，比如
					out.write("{\"success\": true}");
					out.close();
					return null;

				}
				else
				{
					PrintWriter out = response.getWriter();
					//response顾名思义就是服务器对浏览器的相应，PrintWriter它的实例就是向前台的JSP页面输出结果，比如
					out.write("{\"failed\": false}");
					out.close();
					return null;
					
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "success";
	}
	
	/**
	 * 更新员工权限
	 * @return
	 */
	public String updateWorkerRoler(){
		
		String rolerString="";
		if(rolerarray!=null && !"".equals(rolerarray)){
			for(int i=0;i<rolerarray.length;i++){
				rolerString+=rolerarray[i]+",";
			}
		}
		
		Map map = new HashMap();
		map.put("worker_id",worker.getWorker_id());
		WorkerInfo workerinfo = workerInfoService.queryWorkerInfo(map);
		
		String nowdate = DateUtil.getSysTime();
		workerinfo.setUpdate_date(nowdate);
		workerInfoService.updateWorkerInfo(workerinfo);
		return "success";
	}
	
	//分配货柜 start 2018-4-18 10:01:38
	/**
	 * 分配货柜的员工及其货柜查询
	 * @return
	 */
	@RequestMapping("/queryWorkerInfo.do")
	public ModelAndView queryWorkerInfo(WorkerInfo worker){
		Map map = new HashMap();
		Map resultMap = new HashMap();
		map.put("worker_id",worker.getWorker_id());
		worker = workerInfoService.queryWorkerInfo(map);
		map.clear();
		map.put("status_flg", 1); 
		List rList = rolesService.queryRolesList(map);
		
		map.clear();
		map.put("user_id",worker.getWorker_id());
		roleUserList = rolesService.queryRUMapingList(map);
		Map rMap = new HashMap();
		for(int j=0;j<roleUserList.size();j++){
			RUMaping ruMaping = (RUMaping)roleUserList.get(j);
			String r_id = ruMaping.getR_id();
			rMap.put(r_id, r_id);
		}
		
		rolesList = new ArrayList();
		for(int i=0;i<rList.size();i++){
			RolesInfo rolesInfo = (RolesInfo)rList.get(i);
			String rule_id = rolesInfo.getRole_id();
			String isnull=(String)rMap.get(rule_id);
			if(!"".equals(isnull) &&isnull!=null && !"null".equals(isnull)){
				rolesInfo.setCheck("1");
				rolesList.add(rolesInfo);
			}else{
				rolesList.add(rolesInfo);
			}
		}
		resultMap.put("worker", worker);
		resultMap.put("rolesList", rolesList);
		return new ModelAndView("/power/worker/alotCabinet.jsp","map",resultMap);
	}
 
	
	public PageInfo<WorkerInfo> getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo<WorkerInfo> pageInfo) {
		this.pageInfo = pageInfo;
	}

	public WorkerInfo getWorker() {
		return worker;
	}

	public void setWorker(WorkerInfo worker) {
		this.worker = worker;
	}

	public static Logger getLog() {
		return log;
	}

	public static void setLog(Logger log) {
		WorkerInfoAction.log = log;
	}

	public IWorkerInfoService getWorkerInfoService() {
		return workerInfoService;
	}

	public void setWorkerInfoService(IWorkerInfoService workerInfoService) {
		this.workerInfoService = workerInfoService;
	}

	public String[] getRolerarray() {
		return rolerarray;
	}

	public void setRolerarray(String[] rolerarray) {
		this.rolerarray = rolerarray;
	}

	public String getWorker_id() {
		return worker_id;
	}

	public void setWorker_id(String workerId) {
		worker_id = workerId;
	}

	public IRolesService getRolesService() {
		return rolesService;
	}

	public void setRolesService(IRolesService rolesService) {
		this.rolesService = rolesService;
	}

	public List getRolesList() {
		return rolesList;
	}

	public void setRolesList(List rolesList) {
		this.rolesList = rolesList;
	}

	public List getRolesIdList() {
		return rolesIdList;
	}

	public void setRolesIdList(List rolesIdList) {
		this.rolesIdList = rolesIdList;
	}

	public List getRoleUserList() {
		return roleUserList;
	}

	public void setRoleUserList(List roleUserList) {
		this.roleUserList = roleUserList;
	}

	public String getWorker_code() {
		return worker_code;
	}

	public void setWorker_code(String workerCode) {
		worker_code = workerCode;
	}
	
	/**
	 * 验证添加员工手机号是否重复
	 */
	@RequestMapping("checkTelehphone.do")
//	@ResponseBody
	public void checkTelehphone(@RequestParam("contact") String contact, HttpServletResponse response) {
		try {
			WorkerInfo WorkInfo = workerInfoService.selectWorkerByContact(contact);
			if(WorkInfo!=null){
				response.getWriter().write("no");
			}else{
				response.getWriter().write("ok");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}


