package com.power.action1;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.power.bean.GMMaping;
import com.power.bean.Menu;
import com.power.bean.PowerGroup;
import com.power.bean.WorkerInfo;
import com.power.service.IMenuService;
import com.power.service.IPowerGroupService;
import com.website.action.BaseAction;
import com.website.bean.PageInfo;
import com.website.utils.CommonsUtil;

@Controller
@Scope("prototype")
@RequestMapping("/group")
public class PowerGroupAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7520474363708666414L;

	/**
	 * 生成日志对象
	 */
	private static Logger log = Logger.getLogger(PowerGroupAction.class);
	
	/**
	 * 商品管理Service层
	 */
	@Autowired
	private IPowerGroupService powerGroupService;
	
	private List powerGroupList;
	
	private PageInfo<PowerGroup> pageInfo;//显示分页列表
	
	private PowerGroup powerGroup;//权限组实体类
	
	private String pgroup_id;//权限组ID
	
	private String operation;//操作说明
	@Autowired
	private IMenuService menuService;
	
	private List fristMuenList = new ArrayList();
	
	private List menuList;
	/**
	 * 查询权限组信息列表操作
	 * @return
	 */
	@RequestMapping("/selectPowerGroupList.do")
	public ModelAndView selectPowerGroupList(PageInfo pageInfo, PowerGroup powerGroup ){
		Map<String, Object> returnMap=new HashMap<String, Object>();
//		如果是初次访问或新的查询时，重置分页
		if(pageInfo == null || pageInfo.getCurrentPage() == 0){
			pageInfo = new PageInfo<PowerGroup>();
			pageInfo.setCurrentPage("1");
		}
		Map map = new HashMap();
		if(powerGroup.getGroups_name() != null || powerGroup.getPgroup_id()!=null || powerGroup.getStatus()!=null 
				||powerGroup.getOperator()!=null){
			map.put("pgroup_id", powerGroup.getPgroup_id());
			map.put("groups_name", powerGroup.getGroups_name());
			map.put("status", powerGroup.getStatus());
			map.put("operator", powerGroup.getOperator());
//			map.put("start_create_date", powerGroup.getStart_create_date());
//			map.put("end_create_date", powerGroup.getEnd_create_date());
//			map.put("start_update_date", powerGroup.getStart_update_date());
//			map.put("end_update_date", powerGroup.getEnd_update_date());
			returnMap.put("pgroup_id", powerGroup.getPgroup_id());
			returnMap.put("groups_name", powerGroup.getGroups_name());
			returnMap.put("status",  powerGroup.getStatus());
			returnMap.put("operator", powerGroup.getOperator());
		}else{
			returnMap.put("status", "1");
			map.put("status", "1");
		}
		pageInfo = powerGroupService.queryPowerGroupListByPage(pageInfo, map);
		returnMap.put("pageInfo", pageInfo);
		return new ModelAndView("/power/groups/list.jsp","map",returnMap);
	}
	
	/**
	 * 进入权限组信息添加页面
	 * @return
	 */
	@RequestMapping("/insertPowerGroupPage.do")
	public ModelAndView insertPowerGroupPage(){
		Map<String, Object> returnMap=new HashMap<String, Object>();
    	Map map = new HashMap();
    	map.put("levels", 1);
    	map.put("status", 1);
		List firstMenuArr = menuService.queryMenuList(map);
		
		if(firstMenuArr != null && firstMenuArr.size() > 0){
			for(int i = 0; i < firstMenuArr.size(); i++){
//				Map menuMap = (Map)firstMenuArr.get(i);
//				String m_id = (String)menuMap.get("m_id");
//				String menu_name = (String)menuMap.get("menu_name");
//				String levels = (String)menuMap.get("levels");
				
				Menu menuMap = (Menu)firstMenuArr.get(i);
				String m_id = (String)menuMap.getM_id();
				String menu_name = (String)menuMap.getMenu_name();
				String levels = (String)menuMap.getLevels();
				
				Menu menu = new Menu();
				menu.setM_id(m_id);
				menu.setMenu_name(menu_name);
				menu.setLevels(levels);
				
    			map.clear();
    			map.put("parentid", m_id);
    			map.put("level", "2");
    			List twoMenuArr = menuService.queryMenuList(map);
    			List<Menu> secondMuenList = new ArrayList<Menu>();
    			if(twoMenuArr != null && twoMenuArr.size() > 0){
    				for(int j = 0; j < twoMenuArr.size(); j++){
    					
//    					Map twoMenuMap = (Map)twoMenuArr.get(j);
//    					String t_m_id = (String)twoMenuMap.get("m_id");
//    					String t_menu_name = (String)twoMenuMap.get("menu_name");
//    					String t_levels = (String)twoMenuMap.get("levels");
    					Menu twoMenuMap = (Menu)twoMenuArr.get(j);
    					String t_m_id = (String)twoMenuMap.getM_id();
    					String t_menu_name = (String)twoMenuMap.getMenu_name();
    					String t_levels = (String)twoMenuMap.getLevels();
    					
    					
    					Menu t_menu = new Menu();
    					t_menu.setM_id(t_m_id);
    					t_menu.setMenu_name(t_menu_name);
    					t_menu.setLevels(t_levels);
    					
    					map.clear();
    	    			map.put("parentid", t_m_id);
    	    			map.put("level", "3");
    	    			map.put("status", "1");
    	    			List threeMenuArr = menuService.queryMenuList(map);
            			List<Menu> thirdMuenList = new ArrayList<Menu>();
            			if(threeMenuArr != null && threeMenuArr.size() > 0){
            				for(int k = 0; k < threeMenuArr.size(); k++){
            					
//            					Map threeMenuMap = (Map)threeMenuArr.get(k);
//            					String th_m_id = (String)threeMenuMap.get("m_id");
//            					String th_menu_name = (String)threeMenuMap.get("menu_name");
//            					String th_levels = (String)threeMenuMap.get("levels");
            					
            					Menu threeMenuMap = (Menu)threeMenuArr.get(k);
            					String th_m_id = (String)threeMenuMap.getM_id();
            					String th_menu_name = (String)threeMenuMap.getMenu_name();
            					String th_levels = (String)threeMenuMap.getLevels();
            					
            					Menu th_menu = new Menu();
            					th_menu.setM_id(th_m_id);
            					th_menu.setMenu_name(th_menu_name);
            					th_menu.setLevels(th_levels);
            					thirdMuenList.add(th_menu);
                    		}
            				t_menu.setThirdMuenList(thirdMuenList);
            				secondMuenList.add(t_menu);//第二级
            			}
            		}
    				menu.setSecondMuenList(secondMuenList);
    			}
    			fristMuenList.add(menu);//第一级
    		}
		}
		returnMap.put("fristMuenList", fristMuenList);
		return new ModelAndView("/power/groups/add.jsp","map",returnMap) ;
	}
	
	/**
	 * 新增权限组
	 * @return
	 */
	@RequestMapping("/insertPowerGroup.do")
	public String insertPowerGroup(PowerGroup powerGroup,@RequestParam(required = false, value = "list")String list) {
		
//		根据登录者设置相关信息
		pgroup_id = "PG"+CommonsUtil.getPrimaryKey();
		powerGroup.setPgroup_id(pgroup_id);
		powerGroup.setStatus(1);
		powerGroup.setCreate_date(new Date());//发表时间
		powerGroup.setUpdate_date(new Date());//更新时间
		powerGroup.setOperator("admin");//UNDO
		int count = powerGroupService.insertPowerGroup(powerGroup);
		
		if(count>0){
			String [] menu=list.split(",");
			if(menu.length>0){
				for(int i=0;i<menu.length;i++){
					String menuid = (String)menu[i];
					GMMaping gmMaping = new GMMaping();
					String gm_id = "GM"+CommonsUtil.getPrimaryKey();
					gmMaping.setGm_id(gm_id);
					gmMaping.setPgroup_id(pgroup_id);
					gmMaping.setM_id(menuid);
					gmMaping.setCreate_date(new Date());//发表时间
					gmMaping.setUpdate_date(new Date());//更新时间
					gmMaping.setOperator("admin");
					powerGroupService.insertGroupMenu(gmMaping);
					System.out.println(menuid);
				}
			}
			
		}
		return "redirect:selectPowerGroupList.do";
	}
	
	/**
	 * 更新权限组状态信息操作
	 * @return
	 */
	@RequestMapping("/updatePowerGroupStatus.do")
	public String updatePowerGroupStatus(String pgroup_id){
		Map map=new HashMap();
		map.put("pgroup_id",pgroup_id);
		PowerGroup powerGroup = powerGroupService.queryPowerGroup(map);
		powerGroup.setStatus(2);//删除
		powerGroup.setUpdate_date(new Date());
		int count = powerGroupService.updatePowerGroup(powerGroup);
		if(count>0){
			return "redirect:selectPowerGroupList.do";
		}else{
			return "fail";
		}
	}
	/**
	 * 更新权限组信息
	 * @return
	 */
	@RequestMapping("/updatePowerGroup.do")
	public String updatePowerGroup(PowerGroup powerGroup,HttpSession session,
			@RequestParam(value="list",required=false)String list){
		//获取操作人
		WorkerInfo workerInfo = (WorkerInfo) session.getAttribute("workerInfo");
		powerGroup.setOperator(workerInfo.getWorker_name());
		powerGroup.setUpdate_date(new Date());
		pgroup_id=powerGroup.getPgroup_id();
		int count = powerGroupService.updatePowerGroup(powerGroup);
		if(count>0){
			String pgroup_id = powerGroup.getPgroup_id();
			Map map = new HashMap();
			map.put("pgroup_id", pgroup_id);
			int dcount = powerGroupService.deleteGroupMenu(map);
			String [] menu=list.split(",");
			if(menu.length>0){
				for(int i=0;i<menu.length;i++){
					String menuid = (String)menu[i];
					GMMaping gmMaping = new GMMaping();
					String gm_id = "GM"+CommonsUtil.getPrimaryKey();
					gmMaping.setGm_id(gm_id);
					gmMaping.setPgroup_id(pgroup_id);
					gmMaping.setM_id(menuid);
					gmMaping.setCreate_date(new Date());//发表时间
					gmMaping.setUpdate_date(new Date());//更新时间
					gmMaping.setOperator(workerInfo.getWorker_name());
					powerGroupService.insertGroupMenu(gmMaping);
				}
			}
			
			return "redirect:selectPowerGroupList.do";
		}else{
			request.setAttribute("msg","操作异常！");
			return "failed";
		}
		
	}
	/**
	 * 查询权限组信息
	 * @return
	 */
	@RequestMapping("/queryPowerGroup.do")
	public ModelAndView queryPowerGroup(String pgroup_id,String operation){
		Map<String, Object> returnMap=new HashMap<String, Object>();
			Map map = new HashMap();
			map.put("pgroup_id", pgroup_id);
			powerGroup = powerGroupService.queryPowerGroup(map);
			returnMap.put("powerGroup", powerGroup);
			if(operation!=null && "edit".equals(operation)){
				
				List gmList = powerGroupService.queryGroupMenuList(map);
				Map relaitonMap = new HashMap();
				if(gmList!=null){
					for(int m=0;m<gmList.size();m++){
						Map rMap = (Map)gmList.get(m);
						String m_id = (String)rMap.get("m_id");
						relaitonMap.put(m_id, m_id);
					}
				}
				
				
				map.clear();
		    	map.put("levels", 1);
		    	map.put("status", 1);
				List firstMenuArr = menuService.queryMenuList(map);
				
				if(firstMenuArr != null && firstMenuArr.size() > 0){
					for(int i = 0; i < firstMenuArr.size(); i++){
						Menu menuMap = (Menu)firstMenuArr.get(i);
						String m_id = (String)menuMap.getM_id();
						String menu_name = (String)menuMap.getMenu_name();
						String levels = (String)menuMap.getLevels();
						Menu menu = new Menu();
						menu.setM_id(m_id);
						menu.setMenu_name(menu_name);
						menu.setLevels(levels);
						if(relaitonMap.get(m_id)!=null && !"".equals(relaitonMap.get(m_id))){
							menu.setCheck("1");
						}
						
		    			map.clear();
		    			map.put("parentid", m_id);
		    			map.put("levels", "2");
		    			map.put("status", 1);
		    			List twoMenuArr = menuService.queryMenuList(map);
		    			List<Menu> secondMuenList = new ArrayList<Menu>();
		    			if(twoMenuArr != null && twoMenuArr.size() > 0){
		    				for(int j = 0; j < twoMenuArr.size(); j++){
		    					
		    					Menu twoMenuMap = (Menu)twoMenuArr.get(j);
		    					String t_m_id = (String)twoMenuMap.getM_id();
		    					String t_menu_name = (String)twoMenuMap.getMenu_name();
		    					String t_levels = (String)twoMenuMap.getLevels();
		    					Menu t_menu = new Menu();
		    					t_menu.setM_id(t_m_id);
		    					t_menu.setMenu_name(t_menu_name);
		    					t_menu.setLevels(t_levels);
		    					if(relaitonMap.get(t_m_id)!=null && !"".equals(relaitonMap.get(t_m_id))){
		    						t_menu.setCheck("1");
								}
		    					map.clear();
		    	    			map.put("parentid", t_m_id);
		    	    			map.put("levels", "3");
		    	    			map.put("status", 1);
		    	    			List threeMenuArr = menuService.queryMenuList(map);
		            			List<Menu> thirdMuenList = new ArrayList<Menu>();
		            			if(threeMenuArr != null && threeMenuArr.size() > 0){
		            				for(int k = 0; k < threeMenuArr.size(); k++){
		            					
		            					Menu threeMenuMap = (Menu)threeMenuArr.get(k);
		            					String th_m_id = (String)threeMenuMap.getM_id();
		            					String th_menu_name = (String)threeMenuMap.getMenu_name();
		            					String th_levels = (String)threeMenuMap.getLevels();
		            					Menu th_menu = new Menu();
		            					th_menu.setM_id(th_m_id);
		            					th_menu.setMenu_name(th_menu_name);
		            					th_menu.setLevels(th_levels);
		            					if(relaitonMap.get(th_m_id)!=null && !"".equals(relaitonMap.get(th_m_id))){
		            						th_menu.setCheck("1");
										}
		            					thirdMuenList.add(th_menu);
		                    		}
		            				t_menu.setThirdMuenList(thirdMuenList);
		            				secondMuenList.add(t_menu);//第二级
		            			}
		            		}
		    				menu.setSecondMuenList(secondMuenList);
		    			}
		    			fristMuenList.add(menu);//第一级
		    		}
				}
				
			}
			returnMap.put("fristMuenList", fristMuenList);
		return new ModelAndView("/power/groups/edit.jsp","map",returnMap);
	}

	public static Logger getLog() {
		return log;
	}

	public static void setLog(Logger log) {
		PowerGroupAction.log = log;
	}

	public IPowerGroupService getPowerGroupService() {
		return powerGroupService;
	}

	public void setPowerGroupService(IPowerGroupService powerGroupService) {
		this.powerGroupService = powerGroupService;
	}

	public List getPowerGroupList() {
		return powerGroupList;
	}

	public void setPowerGroupList(List powerGroupList) {
		this.powerGroupList = powerGroupList;
	}

	public PageInfo<PowerGroup> getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo<PowerGroup> pageInfo) {
		this.pageInfo = pageInfo;
	}

	public PowerGroup getPowerGroup() {
		return powerGroup;
	}

	public void setPowerGroup(PowerGroup powerGroup) {
		this.powerGroup = powerGroup;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPgroup_id() {
		return pgroup_id;
	}

	public void setPgroup_id(String pgroupId) {
		pgroup_id = pgroupId;
	}

	public IMenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(IMenuService menuService) {
		this.menuService = menuService;
	}

	public List getFristMuenList() {
		return fristMuenList;
	}

	public void setFristMuenList(List fristMuenList) {
		this.fristMuenList = fristMuenList;
	}

	public List getMenuList() {
		return menuList;
	}

	public void setMenuList(List menuList) {
		this.menuList = menuList;
	}

	
}
