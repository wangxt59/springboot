package com.power.action1;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.power.bean.PowerGroup;
import com.power.bean.RolesInfo;
import com.power.service.IPowerGroupService;
import com.power.service.IRolesService;
import com.website.action.BaseAction;
import com.website.bean.PageInfo;
import com.website.utils.CommonsUtil;

@Controller
@Scope("prototype")
@RequestMapping("/role")
public class RolesAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7520474363708666414L;

	/**
	 * 生成日志对象
	 */
	private static Logger log = Logger.getLogger(RolesAction.class);
	
	/**
	 * 角色管理Service层
	 */
	@Autowired
	private IRolesService rolesService;

	/**
	 * 权限管理Service层
	 */
	@Autowired
	private IPowerGroupService  powerGroupService;
	
	
	
	
	
	//角色
	private RolesInfo roleInfo ;
	
	//角色集合
	private PageInfo<RolesInfo> pageInfo;//显示分页列表
	
	private List<PowerGroup>  oldGroupList ;//未分配的权限
	private List<PowerGroup>  newGroupList ;//已经分配的权限
	
	private String selectedPgroup ;//权限组串
	private String opType ;//操作类型
	
	private String role_id;
	/**
	 * 查询角色列表操作
	 * @return
	 */
	@RequestMapping("/selectRoleList.do")
	public ModelAndView selectRoleList(RolesInfo rolesInfo,PageInfo pageInfo
			,@RequestParam(value="role_id",required=false) String role_id){
	    Map<String, Object> returnMap=new HashMap<String, Object>();
		Map paramMap = new HashMap();
		if(rolesInfo.getRole_name()!=null ||rolesInfo.getStatus_flg()!=null){
			paramMap.put("role_name", rolesInfo.getRole_name());
			paramMap.put("status_flg", rolesInfo.getStatus_flg());//1:有效，0：无效
			returnMap.put("role_name", rolesInfo.getRole_name());
			returnMap.put("status_flg", rolesInfo.getStatus_flg());
		}else{
			rolesInfo = new RolesInfo();
			paramMap.put("role_id",role_id);
			
			paramMap.put("status_flg", "1");//1:有效，0：无效
			returnMap.put("status_flg", "1");
			
		}
		//如果是初次访问或新的查询时，重置分页
		if(pageInfo == null || pageInfo.getCurrentPage() == 0){
			pageInfo = new PageInfo<RolesInfo>();
			pageInfo.setCurrentPage("1");
		}
		pageInfo = rolesService.queryRolesListByPage(pageInfo, paramMap);
		List<RolesInfo> roleList = pageInfo.getDatas();
		for (int i = 0; i <roleList.size(); i++) {
			RolesInfo bean = roleList.get(i);
			paramMap.clear();
			paramMap.put("role_id", bean.getRole_id());
			//查询角色下的权限组列表
			paramMap.put("status", 1);
			List<Map> groupList = rolesService.queryRolesGroupsList(paramMap);
			if(groupList.size()>0){
				String selectedPgroup =""; 
				for (int j = 0; j < groupList.size(); j++) {
					Map voMap = groupList.get(j);
					String gName =  (String)voMap.get("groups_name");
					String roleId =  bean.getRole_id();
					if(CommonsUtil.isNotEmpty(roleId)){
						selectedPgroup = selectedPgroup+gName+",";
					}
				}
				if(CommonsUtil.isNotEmpty(selectedPgroup)){
					bean.setSelectedPgroup(selectedPgroup.substring(0,selectedPgroup.length()-1));
				}
				
			}
		
		}
		returnMap.put("pageInfo", pageInfo);
		
		return new ModelAndView("/power/role/list.jsp","map",returnMap);
	}

	/**
	 * 跳转到角色修改页面
	 * @return
	 */
	@RequestMapping("/queryRole.do")
	public ModelAndView queryRole(String role_id){
		Map<String, Object> returnMap=new HashMap<String, Object>();
		Map paramMap = new HashMap();
		newGroupList = new ArrayList();
		oldGroupList = new ArrayList();
		if(role_id!=null){
			paramMap.put("role_id", role_id);
			roleInfo = rolesService.queryRolesInfo(paramMap);
			returnMap.put("roleInfo", roleInfo);
			//查询角色下的权限组列表
			paramMap.put("status", 1);
			paramMap.put("role_id", role_id);
			List<Map> groupListOld = rolesService.queryRolesGroupsList(paramMap);
			if(groupListOld.size()>0){
				for (int i = 0; i < groupListOld.size(); i++) {
					Map bean = groupListOld.get(i);
					PowerGroup groupBean = new PowerGroup();
					String gId = ""+bean.get("pgroup_id");
					String gName = ""+bean.get("groups_name");
//					String roleId = ""+ bean.get(role_id);
					groupBean.setPgroup_id(gId);
					groupBean.setGroups_name(gName);
					oldGroupList.add(groupBean);
				}
			}
			//查询角色没有关联的权限组列表
			List<Map> groupListNew = rolesService.queryNotRolesGroupsList(paramMap);
			if(groupListNew.size()>0){
				for (int i = 0; i < groupListNew.size(); i++) {
					Map bean = groupListNew.get(i);
					PowerGroup groupBean = new PowerGroup();
					String gId = ""+bean.get("pgroup_id");
					String gName = ""+bean.get("groups_name");
//					String roleId = ""+ bean.get(role_id);
					groupBean.setPgroup_id(gId);
					groupBean.setGroups_name(gName);
					newGroupList.add(groupBean);
				}
			}
			returnMap.put("newGroupList", newGroupList);
			returnMap.put("oldGroupList", oldGroupList);
			return new ModelAndView("/power/role/edit.jsp","map",returnMap);
		}else{
			//跳转到增加页面
			paramMap.put("status", 1);
			List<Map> groupList = rolesService.queryNotRolesGroupsList(paramMap);
			if(groupList.size()>0){
				for (int i = 0; i < groupList.size(); i++) {
					Map bean = groupList.get(i);
					PowerGroup groupBean = new PowerGroup();
					String gId =(String) bean.get("pgroup_id");
					String gName =  (String)bean.get("groups_name");
//					String roleId =  (String)bean.get(role_id);
					groupBean.setPgroup_id(gId);
					groupBean.setGroups_name(gName);
					newGroupList.add(groupBean);
				}
			}
			
			returnMap.put("newGroupList", newGroupList);
			returnMap.put("oldGroupList", oldGroupList);
			return new ModelAndView("/power/role/add.jsp","map",returnMap);
		}
	}
	
	
	/**
	 * 修改角色信息
	 * @return
	 */
	@RequestMapping("/updateRole.do")
	public String updateRole(String role_id,RolesInfo roleInfo,
			@RequestParam(value="selectedPgroup",required=false)String selectedPgroup){
		Map paramMap = new HashMap();
		if(roleInfo!=null){
			Date nowDate = new Date();
			roleInfo.setUpdate_date(nowDate);
			rolesService.updateRoles(roleInfo);
			if(CommonsUtil.isNotEmpty(role_id)){
				//删除角色的权限组管理
				powerGroupService.deleteGroups(role_id);
				//增加角色和权限组关联关系
				if (selectedPgroup != null && !"".equals(selectedPgroup)) {
					String[] pgroupList = selectedPgroup.split("#");
					for (String pg : pgroupList) {
						Map<String, Object> paramArrMap = new HashMap<String, Object>();
						paramArrMap.put("rg_id","RG"+CommonsUtil.getPrimaryKey());
						paramArrMap.put("r_id", role_id);
						paramArrMap.put("pgroup_id", pg);
						paramArrMap.put("create_date", nowDate);
						paramArrMap.put("update_date", nowDate);
						powerGroupService.insertRoleGroup(paramArrMap);
					}
				}
			}
		}
		return "redirect:selectRoleList.do";
	}
	
	/**
	 * 增加角色信息
	 * @return
	 */
	@RequestMapping("/addRole.do")
	public String addRole(RolesInfo roleInfo,String selectedPgroup){
		Map paramMap = new HashMap();
		if(roleInfo!=null){
			Date nowDate = new Date();
			role_id = CommonsUtil.getPrimaryKey();
			roleInfo.setUpdate_date(nowDate);
			roleInfo.setCreate_date(nowDate);
			roleInfo.setRole_id(role_id);
			rolesService.insertRolesInfo(roleInfo);
			//增加角色和权限组关联关系
			if (selectedPgroup != null && !"".equals(selectedPgroup)) {
				String[] pgroupList = selectedPgroup.split("#");
				for (String pg : pgroupList) {
					Map<String, Object> paramArrMap = new HashMap<String, Object>();
					paramArrMap.put("rg_id","RG"+CommonsUtil.getPrimaryKey());
					paramArrMap.put("r_id", role_id);
					paramArrMap.put("pgroup_id", pg);
					paramArrMap.put("create_date", nowDate);
					paramArrMap.put("update_date", nowDate);
					powerGroupService.insertRoleGroup(paramArrMap);
				}
			}
		
		}
		return "redirect:selectRoleList.do";
	}
	public static Logger getLog() {
		return log;
	}

	public static void setLog(Logger log) {
		RolesAction.log = log;
	}

	public IRolesService getRolesService() {
		return rolesService;
	}

	public void setRolesService(IRolesService rolesService) {
		this.rolesService = rolesService;
	}

	public RolesInfo getRoleInfo() {
		return roleInfo;
	}

	public void setRoleInfo(RolesInfo roleInfo) {
		this.roleInfo = roleInfo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public PageInfo<RolesInfo> getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo<RolesInfo> pageInfo) {
		this.pageInfo = pageInfo;
	}

	public List<PowerGroup> getOldGroupList() {
		return oldGroupList;
	}

	public void setOldGroupList(List<PowerGroup> oldGroupList) {
		this.oldGroupList = oldGroupList;
	}

	public List<PowerGroup> getNewGroupList() {
		return newGroupList;
	}

	public void setNewGroupList(List<PowerGroup> newGroupList) {
		this.newGroupList = newGroupList;
	}

	public String getSelectedPgroup() {
		return selectedPgroup;
	}

	public void setSelectedPgroup(String selectedPgroup) {
		this.selectedPgroup = selectedPgroup;
	}

	public IPowerGroupService getPowerGroupService() {
		return powerGroupService;
	}

	public void setPowerGroupService(IPowerGroupService powerGroupService) {
		this.powerGroupService = powerGroupService;
	}

	public String getOpType() {
		return opType;
	}

	public void setOpType(String opType) {
		this.opType = opType;
	}

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String roleId) {
		role_id = roleId;
	}
	
	
	
}
