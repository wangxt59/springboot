package com.antke.power.action;

import java.io.PrintWriter;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.antke.power.model.bean.Menu;
import com.antke.power.model.bean.WorkerInfo;
import com.antke.power.service.IMenuService;
import com.antke.power.service.IPowerGroupService;
import com.antke.power.service.IRolesService;
import com.antke.power.service.IWorkerInfoService;
import com.antke.website.model.bean.LoginLog;
import com.antke.website.model.bean.PageInfo;
import com.antke.website.service.ILoginLogService;
import com.antke.website.utils.CommonsUtil;
import com.antke.website.utils.DateUtil;
//import com.antke.website.utils.MD5;

/**
 * 员工信息类
 * 
 * @author bizf
 */
@Controller
@RequestMapping("/login")
public class LoginAction {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(LoginAction.class);
	@Autowired
	private IWorkerInfoService workerInfoService;
	@Autowired
	private IRolesService rolesService;
	@Autowired
	private IPowerGroupService powerGroupService;
	@Autowired
	private IMenuService menuService;
	
	//注入登录Service
	@Autowired
	private ILoginLogService loginLogService;
	
	
	/**
	 * 员工登陆
	 * 
	 * @return
	 */
	@RequestMapping("/workLogin.action")
	public ModelAndView workLogin(WorkerInfo worker,HttpServletRequest request,HttpSession session) {
		//返回结果Map
		Map<String,Object> returnMap = new HashMap<String,Object>();
		//参数Map
		Map<String,Object> paramMap = new HashMap<String,Object>();
		WorkerInfo workerInfo = null;
		try {
			
			String login_name = worker.getLogin_name();
			paramMap.put("login_name", login_name);
			paramMap.put("status", 0);
			List<WorkerInfo> workerList = workerInfoService.queryWorkerInfoList(paramMap);
			if(workerList.size()>0){
				workerInfo = workerList.get(0);
			}else{
				returnMap.put("error_code", "100002");
				return new ModelAndView("login.jsp", "map", returnMap);
			}
			
			//验证用户密码
//			String pwd = MD5.encode(worker.getPassword(), null);
			String pwd = worker.getPassword();
			System.out.println(pwd);
			String password = workerInfo.getPassword();
			if(password!=null && pwd!=null && !password.equals(pwd)){
				returnMap.put("error_code", "100001");
				log.info("登录失败");
				return new ModelAndView("login.jsp", "map", returnMap);
			}
			//修改WorkerInfo 登录ip
			paramMap.clear();
			paramMap.put("password", pwd);
			paramMap.put("login_name", login_name);
			WorkerInfo info=workerInfoService.queryWorkerInfo(paramMap);
			if(info!=null)
			{
				String ip=InetAddress.getLocalHost().getHostAddress();
				info.setUpdate_date(DateUtil.getCurrTime());
				workerInfoService.updateWorkerInfo(info);
			}
			
			//通过员工ID获取员工角色
			String user_id = workerInfo.getWorker_id();
			paramMap = new HashMap();
			paramMap.put("user_id", user_id);
			List rolerUserList = rolesService.queryRolesUserList(paramMap);
			if(rolerUserList!=null && rolerUserList.size()>0){
				List<Map> topMenuList = new ArrayList<Map>();//上导航列表
				for(int i=0;i<rolerUserList.size();i++){
					Map ruMap = (Map)rolerUserList.get(i);
					String r_id = (String)ruMap.get("r_id");//员工拥有的角色信息
					paramMap.clear();
					paramMap.put("r_id", r_id);
					//通过员工角色获取权限列表
					List rgroupList = rolesService.queryRGroupsList(paramMap);
					
					if(rgroupList!=null && rgroupList.size()>0){
						for(int j=0;j<rgroupList.size();j++){
							Map rgMap = (Map)rgroupList.get(j);//角色对应权限对象
							String pgroup_id = (String)rgMap.get("pgroup_id");//权限组信息
							//通过权限组获取菜单信息
							paramMap.clear();
							paramMap.put("pgroup_id", pgroup_id);
							paramMap.put("levels", '2');
							paramMap.put("status", 1);
							System.out.println("角色对应权限信息="+pgroup_id);
							List gmList2 = rolesService.queryGMenuList(paramMap);//二级菜单列表
							System.out.println("---------------"+gmList2+"---------------");
							if(gmList2!=null && gmList2.size()>0){
								for(int m=0;m<gmList2.size();m++){
									
									List childMenuList = null;
									Map gmMap = (Map)gmList2.get(m);
									String m_id = (String)gmMap.get("m_id");
									paramMap.clear();
									paramMap.put("m_id", m_id);
									Menu menu = (Menu)menuService.queryMenu(paramMap);
									System.out.println("---------------"+menu+"---------------");
									//判断是否有重复的菜单
									boolean flag = true;
									for (Map obj : topMenuList) {
										if(obj.get("menu_id").equals(menu.getM_id())){
											flag = false;
										}
									}
									if(flag){
										Map menuMap = new HashMap();
										
										String menu_name = menu.getMenu_name();
										String menu_desciption = menu.getMenu_desciption();
										String menu_id = menu.getM_id();
										String url = menu.getUrl();
										String icon_url = menu.getIcon_url();
										menuMap.put("menu_id", menu_id);
										menuMap.put("menu_name", menu_name);
										menuMap.put("url", url);
										menuMap.put("icon_url", icon_url);
										menuMap.put("menu_desciption", menu_desciption);
										
										paramMap.clear();
										paramMap.put("pgroup_id", pgroup_id);
										paramMap.put("levels", '3');
										paramMap.put("parentid", m_id);
										paramMap.put("status", 1);
										
										List gmList3 = rolesService.queryGMenuList(paramMap);//三级菜单列表
										
										if(gmList3!=null && gmList3.size()>0){
											childMenuList = new ArrayList();//做导航列表
											String parentid ="";
											for(int n=0;n<gmList3.size();n++){
												Map gmMap3 = (Map)gmList3.get(n);
												String m_id3 = (String)gmMap3.get("m_id");
												paramMap.clear();
												paramMap.put("m_id", m_id3);
												paramMap.put("status", "1");
												
												Menu menu3 = (Menu)menuService.queryMenu(paramMap);
												Map menuMap3 = new HashMap();
												
												String menu_name3 = menu3.getMenu_name();
												String menu_id3 = menu3.getM_id();
												String url3 = menu3.getUrl();
												String menu_desciption3 = menu3.getMenu_desciption();
												menuMap3.put("tm_id", m_id);
												menuMap3.put("menu_id", menu_id3);
												menuMap3.put("menu_name", menu_name3);
												menuMap3.put("url", url3);
												menuMap3.put("menu_desciption", menu_desciption3);
												childMenuList.add(menuMap3);//第三级菜单列表
												parentid = menu3.getParentid();
											}
											menuMap.put("childMenuList", childMenuList);
										}
										
										topMenuList.add(menuMap);
									}
								}
							}
						}
					}
				}
				
				session.setAttribute("topMenuList", topMenuList);
			}
			
			
			
			//缓存权限列表
			
			if (workerInfo != null && !"".equals(workerInfo)) {
				if (!"0".equals(workerInfo.getStatus())) {
					request.setAttribute("errorinfo", "登录失败，此用户已被冻结或注销！！");
				}
				int login_num = workerInfo.getLogin_num();
				String isfirst = workerInfo.getIsfirst();
				request.getSession().setAttribute("workerInfo", workerInfo);
				Map updateMap = new HashMap();

				updateMap.put("login_num", login_num + 1);

				workerInfo.setLogin_num(login_num + 1);

				if ("0".equals(isfirst)) {
					workerInfo.setIsfirst("1");
				}

				workerInfo.setUpdate_date(DateUtil.getCurrTime());
				int lineasd = workerInfoService.updateWorkerInfo(workerInfo);
				System.out.println("更新条数===" + lineasd);
				if (lineasd < 1) {
					request.setAttribute("errorinfo", "登录处理异常！");
				} 
			} else {
				request.setAttribute("errorinfo", "用户名或密码错误！");
			}
			returnMap.put("workerInfo", workerInfo);
			session.setAttribute("workerInfo", workerInfo);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorinfo", "登录处理异常！");
			log.error("登录处理异常！", e);
		}
		return new ModelAndView("login/index.jsp", "map", returnMap);
	}

	/**
	 * 退出重新登录系统
	 * @return 
	 * 
	 * @return
	 */
	@RequestMapping("/loginOut.do")
	public String loginOut(HttpServletRequest request,HttpSession session) {
//		//更新登出时间
//		WorkerInfo workerInfo = (WorkerInfo) session.getAttribute("workerInfo");
//		Integer chant_id = null;
//		String worker_id = null;
//		if (workerInfo.getChant_id() != null) {
//			chant_id = workerInfo.getChant_id();
//			worker_id = workerInfo.getWorker_id();
//		}	
//		if (chant_id != null && worker_id != null) {
//			//查询当前登录员工的登录信息
//			Map<String,Object> map = new HashMap<String, Object>();
//			List<LoginLog> loginLogs = loginLogService.selectLoginLogs(map);
//			if (loginLogs.size() > 0) {
//				for (LoginLog loginLog : loginLogs) {
//					loginLog.setStatus(1);
//					loginLog.setLoginIp(getIp());
//					loginLog.setUpdateDate(new Date());
//					loginLogService.updateLoginLog(loginLog);
//				}
//			}
//		}
		session.invalidate();
		return "/login.jsp";
	}
	//首页信息统计
	@RequestMapping("/countInfo.do")
	public void countInfo(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> queryMap = new HashMap<String,Object>();
		JSONObject json = new JSONObject();
		response.setContentType("text/html");// 配置响应异步
		PrintWriter out = null;
		try {
			out.print(json);
		} catch (Exception e) {
			log.error("countInfo异常", e);
		}finally{
			out.flush();
			out.close();
		}
	}

	public static String getSpecifiedDayBefore(String specifiedDay){ 
		Calendar c = Calendar.getInstance(); 
		Date date=null; 
		try { 
		date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay); 
		} catch (Exception e) { 
		e.printStackTrace(); 
		} 
		c.setTime(date); 
		int day=c.get(Calendar.DATE); 
		c.set(Calendar.DATE,day-1); 

		String dayBefore=new SimpleDateFormat("yyyy-MM-dd").format(c.getTime()); 
		return dayBefore; 
		}
	
	
	static String getNowMonth(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		Calendar c = Calendar.getInstance();    
         c.add(Calendar.MONTH, 0);
         c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
         String first = format.format(c.getTime());
         return first;
	}
	
	public static void main(String[] args) {
	}
	
	// 得到计算机的ip
	public static String getIp() {
		String ip = null;
		try {
			InetAddress addr = InetAddress.getLocalHost();
			ip = addr.getHostAddress().toString(); // 获取本机ip
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ip;
	}
	
	/**
	 * 1.查询登录日志列表
	 */
	@RequestMapping("/list.do")
	public ModelAndView selectGoodsInfo(HttpSession session,PageInfo<LoginLog> pageInfo,
			@RequestParam(value = "worker_id", required = false) String worker_id,
			@RequestParam(value = "create_date_start", required = false) String create_date_start,
			@RequestParam(value = "create_date_end", required = false) String create_date_end) {
		log.info("----------------后台登录日志分页查询开始!");
		//获取商户id
		WorkerInfo worker = (WorkerInfo) session.getAttribute("workerInfo");
		if (worker == null) {
			return new ModelAndView("redirect:/login/workLogin.action");
		}
		Integer chant_id = worker.getChant_id();	
		
		Map<String,Object> map = new HashMap<String, Object>();
		Map<String,Object> returnMap = new HashMap<String, Object>();

		// 如果是初次访问或新的查询时，重置分页
		if (pageInfo == null || pageInfo.getCurrentPage() == 0) {
			pageInfo = new PageInfo<LoginLog>();
			pageInfo.setCurrentPage("1");
		}
		if (chant_id != null) {
			map.put("chant_id", chant_id);
		}
		if (CommonsUtil.isNotEmpty(worker_id)) {
			map.put("worker_id", worker_id);
			returnMap.put("worker_id", worker_id);
		}
		if (CommonsUtil.isNotEmpty(create_date_start)) {
			map.put("create_date_start", create_date_start);
			returnMap.put("create_date_start", create_date_start);
		}
		if (CommonsUtil.isNotEmpty(create_date_end)) {
			map.put("create_date_end", create_date_end);
			returnMap.put("create_date_end", create_date_end);
		}
		pageInfo = loginLogService.selectLoginLogListByPage(pageInfo, map);
		returnMap.put("pageInfo", pageInfo);
		log.info("----------------后台登录日志分页查询结束!");
		return new ModelAndView("login/loglist.jsp", "map", returnMap);
	}
	
	
}
