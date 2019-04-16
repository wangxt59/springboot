package com.antke.power.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.antke.power.model.bean.Menu;
import com.antke.power.service.IMenuService;
import com.antke.power.service.IPowerGroupService;
import com.antke.website.action.BaseAction;
import com.antke.website.model.bean.PageInfo;
import com.antke.website.utils.CommonsUtil;

@Controller
@Scope("prototype")
public class MenuAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7520474363708666414L;

	/**
	 * 生成日志对象
	 */
	private static Logger log = Logger.getLogger(MenuAction.class);
	
	/**
	 * 商品管理Service层
	 */
	@Autowired
	private IMenuService menuService;
	
	private List menuList;
	
	private PageInfo<Menu> pageInfo;//显示分页列表
	
	private Menu menu;//菜单实体类
	
	private String pgroup_id;//菜单ID
	
	private String operation;//操作说明
	
	private String menuInfo ; //数组字符串
	private String parentid;
	
	private List<Menu> firstMenuList;//第一级菜单列表
	private List<Menu> secMenuList;//第二季菜单列表
	
	private String menu_id;
	@Autowired
	private IPowerGroupService powerGroupService;
	
	/**
	 * 查询菜单信息列表操作
	 * @return
	 */
	public String selectMenuList(){
//		如果是初次访问或新的查询时，重置分页
		if(pageInfo == null || pageInfo.getCurrentPage() == 0){
			pageInfo = new PageInfo<Menu>();
			pageInfo.setCurrentPage("1");
		}
//		查询商品信息
		Map map = new HashMap();
		if(menu != null){
			map.put("menu_name", menu.getMenu_name());
//			map.put("status", menu.getStatus());
//			map.put("operator", menu.getOperator());
//			map.put("start_create_date", menu.getStart_create_date());
//			map.put("end_create_date", menu.getEnd_create_date());
//			map.put("start_update_date", menu.getStart_update_date());
//			map.put("end_update_date", menu.getEnd_update_date());
		}
		map.put("status", 1);
		List<Menu> list = menuService.queryMenuList(map);
		if(list.size()>0){
			menuList = new ArrayList();
			for (int i = 0; i <list.size(); i++) {
				Menu bean = list.get(i);
				Map temMap = new HashMap();
				temMap.put("name", bean.getMenu_name());
				temMap.put("id",  bean.getM_id());
				temMap.put("rank",  bean.getLevels());
				temMap.put("parent",  bean.getParentid());
				temMap.put("status",  bean.getStatus());
				menuList.add(temMap);
			}
			ObjectMapper object = new ObjectMapper();
			try {
				menuInfo =  object.writeValueAsString(menuList);
				System.out.println(menuInfo);
			} catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "toMenuList";
	}
	
	/**
	 * 进入菜单信息添加页面
	 * @return
	 */
	public String insertMenuPage(){
	
		Map map = new HashMap();
		map.put("levels", 1);
		map.put("status", 1);
		menuList = menuService.queryMenuList(map);
		
		return "insertMenuPage";
	}
	
	/**
	 * 获取父类的子集信息
	 */
	public void getChildMenu(){
		PrintWriter out = null;
		try {
			Map map = new HashMap();
			map.put("status", 1);
			map.put("levels", 2);
			map.put("parentid", parentid);
			
			List list =  menuService.queryMenuList(map);
			response.setContentType("text/html;charset=UTF-8");
			out = response.getWriter();
			JSONArray jsonArray = JSONArray.fromObject(list);
			out.write(list == null || list.size() < 1 ? "[]" : jsonArray
					.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(out != null){
				out.flush();
				out.close();
			}
		}
	}
	
	/**
	 * 新增菜单
	 * @return
	 */
	public String insertMenu() {
		
//		根据登录者设置相关信息
		menu_id = "M"+CommonsUtil.getPrimaryKey();
		menu.setM_id(menu_id);
		menu.setStatus(1);
		menu.setCreate_date(new Date());//发表时间
		menu.setUpdate_date(new Date());//更新时间
		menu.setOperator("admin");//UNDO
		String rank =menu.getLevels();
		if("1".equals(rank)){
			menu.setParentid(null);
		}
		int count = menuService.insertMenu(menu);
		
//		if(count>0){
//			for(int i=0;i<categoryIdList.size();i++){
//				String cid = (String)categoryIdList.get(i);
//				GoodsRelation goodsRelation = new GoodsRelation();
//				
//				String relation_id = CommonsUtil.getPrimaryKey();
//				goodsRelation.setRelation_id(relation_id);
//				goodsRelation.setGoods_id(goods_id);
//				goodsRelation.setCategory_id(cid);
//				goodsRelation.setCreate_date(new Date());//发表时间
//				goodsRelation.setUpdate_date(new Date());//更新时间
//				goodsService.insertGoodsRelation(goodsRelation);
//				System.out.print(cid);
//			}
//		}
		return "insertMenu";
	}
	
	/**
	 * 更新菜单状态信息操作
	 * @return
	 */
	public String updateMenuStatus(){
		Map map=new HashMap();
		map.put("m_id",menu.getM_id());
		Menu menu = menuService.queryMenu(map);
		menu.setStatus(2);//删除
		menu.setUpdate_date(new Date());
		int count = menuService.updateMenu(menu);
		if(count>0){
			map.put("m_id", menu.getM_id());
			powerGroupService.deleteGroupMenu(map);
			return "updateMenuStatus";
		}else{
			return "fail";
		}
	}
	/**
	 * 更新菜单信息
	 * @return
	 */
	public String updateMenu(){
		
		menu.setOperator("admin");
		menu.setUpdate_date(new Date());
		String rank =menu.getLevels();
		if("1".equals(rank)){
			menu.setParentid(null);
		}
		menu_id = menu.getM_id();
		int count = menuService.updateMenu(menu);
		if(count>0){
//			String goods_id = goods.getGoods_id();
//			int dcount = goodsService.deleteGoodsCategory(goods_id);
//			if(dcount>0){
//				for(int i=0;i<categoryIdList.size();i++){
//					String cid = (String)categoryIdList.get(i);
//					GoodsRelation goodsRelation = new GoodsRelation();
//					
//					String relation_id = CommonsUtil.getPrimaryKey();
//					goodsRelation.setRelation_id(relation_id);
//					goodsRelation.setGoods_id(goods_id);
//					goodsRelation.setCategory_id(cid);
//					goodsRelation.setCreate_date(new Date());//发表时间
//					goodsRelation.setUpdate_date(new Date());//更新时间
//					goodsService.insertGoodsRelation(goodsRelation);
//					System.out.print(cid);
//				}
//			}
			
			
			return "queryMenuList";
		}else{
			request.setAttribute("msg","操作异常！");
			return "failed";
		}
		
	}
	/**
	 * 查询菜单信息
	 * @return
	 */
	public String queryMenu(){
		
//		回显各级分类
		Map map = new HashMap();
		map.put("m_id", menu.getM_id());
		menu = (Menu)menuService.queryMenu(map);
		if("3".equals(menu.getLevels())){
			request.setAttribute("thirdGradeName", menu.getMenu_name());
			Menu temp = getMenu(menu.getParentid());
			request.setAttribute("secondGradeName", temp.getMenu_name() + "&nbsp;&rarr;&nbsp;");
			request.setAttribute("firstGradeName", getMenu(temp.getParentid()).getMenu_name() + "&nbsp;&rarr;&nbsp;");
		}else if("2".equals(menu.getLevels())){
			request.setAttribute("thirdGradeName", "");
			request.setAttribute("secondGradeName", menu.getMenu_name() + "&nbsp;&rarr;&nbsp;");
			request.setAttribute("firstGradeName", getMenu(menu.getParentid()).getMenu_name() + "&nbsp;&rarr;&nbsp;");
		}else{
			request.setAttribute("thirdGradeName", "");
			request.setAttribute("secondGradeName", "");
			request.setAttribute("firstGradeName", menu.getMenu_name());
		}
		
		map.clear();
		map.put("levels", 1);
		map.put("status", 1);
		menuList = menuService.queryMenuList(map);
		
		return "queryMenu";
	}
	public Menu getMenu(String m_id){
//		获取分类名称信息
		Map map = new HashMap();
		map.put("m_id", m_id);
		Menu temp = menuService.queryMenu(map);
		return temp;
	}
	

	public List<Menu> getFirstMenuList() {
		return firstMenuList;
	}

	public void setFirstMenuList(List<Menu> firstMenuList) {
		this.firstMenuList = firstMenuList;
	}

	public List<Menu> getSecMenuList() {
		return secMenuList;
	}

	public void setSecMenuList(List<Menu> secMenuList) {
		this.secMenuList = secMenuList;
	}

	public static Logger getLog() {
		return log;
	}

	public static void setLog(Logger log) {
		MenuAction.log = log;
	}

	public IMenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(IMenuService menuService) {
		this.menuService = menuService;
	}

	public List getMenuList() {
		return menuList;
	}

	public void setMenuList(List menuList) {
		this.menuList = menuList;
	}

	public PageInfo<Menu> getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo<Menu> pageInfo) {
		this.pageInfo = pageInfo;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
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

	public String getMenuInfo() {
		return menuInfo;
	}

	public void setMenuInfo(String menuInfo) {
		this.menuInfo = menuInfo;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(String menuId) {
		menu_id = menuId;
	}

	
}
