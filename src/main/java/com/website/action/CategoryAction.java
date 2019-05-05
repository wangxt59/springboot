package com.website.action;

import java.io.File;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.power.bean.WorkerInfo;
import com.website.bean.Category;
import com.website.bean.GoodsInfo;
import com.website.bean.PageInfo;
import com.website.service.ICategoryService;
import com.website.utils.FileUtil;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/category")
public class CategoryAction extends BaseAction {

	private static final long serialVersionUID = -7520474363708666414L;
 
	private static Logger log = Logger.getLogger(CategoryAction.class);
	
	/**
	 * 分类管理Service层
	 */
	@Autowired
	private ICategoryService categoryService;
	
	private PageInfo<Category> pageInfo;//显示分页列表
	
	private Category category;//分类信息实体类
	
	private Category secondCategory;//编辑三级分类使用
	
	private String category_id;//分类ID
	
	private String operation;//操作说明
	
	private String second_id;//二级分类id
	
	 /*上传图片及其名称集合*/
    private List<File> myImageFile;
    private List<String> myImageFileFileName;
     
	private List categoryList;
	private List secondCategoryList;
	
	private List childList;
	private List thildList;
	/**
	 * 进入分类信息添加页面
	 * @return
	 */
	@RequestMapping("/insertCategoryPage.do")
	public ModelAndView insertCategoryPage(Model model){
		//返回结果Map
		Map<String,Object> returnMap = new HashMap<String,Object>();
//		查询分类信息
		Map map = new HashMap();
		map.put("rank", 1);
		map.put("status", 1);
		categoryList = categoryService.queryCategoryList(map);
		returnMap.put("categoryList", categoryList);
		return new ModelAndView("/category/addCategory.jsp","map",returnMap);
	}
	/**
	 * 新增分类
	 * @return
	 */
	@RequestMapping("/insertCategory.do")
	public String insertCategory(HttpServletRequest request,Category category, HttpSession session) {
		
		WorkerInfo worker = (WorkerInfo) session.getAttribute("workerInfo");
		String operator = worker.getWorker_name();
		
		String parent_id = category.getParent_id();
		category.setCreate_date(new Date());//发表时间
		category.setUpdate_date(new Date());//更新时间
		category.setOperator(operator);//UNDO
		categoryService.insertCategory(category);
		return "redirect:selectCategoryList.do";
	 
	}
	
	
	
	/**
	 * 查询分类信息列表操作
	 * @return
	 */
	@RequestMapping("/selectCategoryList.do")
	public ModelAndView selectCategoryList(HttpServletRequest request,Category category,
			@RequestParam(value="category_id",required =false)String category_id,PageInfo pageInfo){
		//返回结果Map
		Map<String,Object> returnMap = new HashMap<String,Object>();
//		如果是初次访问或新的查询时，重置分页
		if(pageInfo == null || pageInfo.getCurrentPage() == 0){
			pageInfo = new PageInfo<Category>();
			pageInfo.setCurrentPage("1");
		}
//		查询分类信息
		Map map = new HashMap();
		String category_name = category.getCategory_name();
		if (null!=category_name&&!"".equals(category_name)) {
			category_name =  category_name.trim();
			map.put("category_name", category_name);
			returnMap.put("category_name", category_name);
		}
		if (null!=category_id&&!"".equals(category_id.trim())) {
			category_id =  category_id.trim();
			map.put("category_id", category_id);
			returnMap.put("category_id", category_id);
		}
		if (null!=category.getStatus()) {
			map.put("status", category.getStatus());
			returnMap.put("status", category.getStatus());
		}else{
			map.put("status", 1);
			returnMap.put("status", 1);
		}
		if (null!=category.getIs_show()) {
			map.put("is_show", category.getIs_show());
			returnMap.put("is_show", category.getIs_show());
		}else{
			map.put("is_show", 1);
			returnMap.put("is_show", 1);
		}
			
		String parent_id = category.getParent_id();
		String child_id = category.getChild_id();
			
		if(parent_id!=null && !"".equals(parent_id)){
			map.put("parent_id",parent_id);
			returnMap.put("parent_id", parent_id);
			if(child_id!=null && !"".equals(child_id)){
				map.put("parent_id", child_id);
				returnMap.put("child_id", child_id);
			}
		}
		pageInfo = categoryService.queryCategoryListByPage(pageInfo, map);
		//查询一级
		map.clear();
		map.put("rank", 1);
		map.put("status", 1);
		categoryList = categoryService.queryCategoryList(map);
		//查询二级
		if( category.getParent_id()!=null && ! category.getParent_id().equals("")){
			map.clear();
			map.put("rank", 2);
			map.put("status", 1);
			map.put("parent_id",  category.getParent_id());
			childList = categoryService.queryCategoryList(map);
			//查询三级
			if(category.getChild_id()!=null && ! category.getChild_id().equals("")){
				map.clear();
				map.put("rank", 3);
				map.put("status", 1);
				map.put("parent_id",  category.getChild_id());
				thildList = categoryService.queryCategoryList(map);
			}
		}
		
		//返回结果集
		returnMap.put("categoryList", categoryList);
		returnMap.put("childList", childList);
		returnMap.put("thildList", thildList);
		returnMap.put("pageInfo", pageInfo);
		return new ModelAndView("category/categoryList.jsp", "map", returnMap);
	}
	
	/**
	 * 更新分类状态信息操作
	 * @return
	 */
	@RequestMapping("/updateCategoryStatus.do")
	public void updateCategoryStatus(String category_id, HttpServletResponse response){
		Map map=new HashMap();
		map.put("category_id",category_id);
		Category category = categoryService.queryCategory(map);
		category.setStatus(2);//删除
		category.setIs_show(2);//不显示
		category.setUpdate_date(new Date());
		int count = categoryService.updateCategory(category);
		if(count>0){
			response(response, "OK", "操作成功！");
		}else{
			response(response, "fail", "操作失败！");
		}
	}
	
	/**
	 * 更新分类信息
	 * @return
	 */
	@RequestMapping("/updateCategory.do")
	public String updateCategory(Category category,HttpSession session,
			@RequestParam(value="second_id",required=false)String second_id){
		String images_path = FileUtil.getProperty("images_path");
		WorkerInfo worker = (WorkerInfo) session.getAttribute("workerInfo");
		category_id=category.getCategory_id();
		category.setOperator(worker.getWorker_name());
		category.setUpdate_date(new Date());
		
		//判断二级分类是否选中如果选中了则添加的是三级分类信息
		String parent_id = category.getParent_id();
		if(second_id!=null && !"".equals(second_id)){
			category.setParent_id(second_id);
			category.setRank(3);
		}else{
			if(parent_id!=null && !"".equals(parent_id)){
				category.setParent_id(parent_id);
				category.setRank(2);
			}else{
				category.setParent_id("-1");
				category.setRank(1);
			}
		}
		int count = categoryService.updateCategory(category);
		if(count>0){
			
			int is_show = category.getIs_show();
			int rank = category.getRank();
			if(rank==2&&is_show==2){
				//当前更新的未二级分类
				Map resMap = new HashMap();
				resMap.put("parent_id", category_id);
				List categoryList = categoryService.queryCategoryList(resMap);
				if(categoryList!=null && categoryList.size()>0){
					for(int i=0;i<categoryList.size();i++){
						
						Map cateMap = (Map)categoryList.get(i);
						String category_id = ""+cateMap.get("category_id");
						Category cate = new Category();
						cate.setCategory_id(category_id);
						cate.setIs_show(2);
						cate.setUpdate_date(new Date());
						categoryService.updateCategory(cate);
					}
				}
			}
			
			return "redirect:selectCategoryList.do";
		}else{
			request.setAttribute("msg","操作异常！");
			return "error.jsp";
		}
		
	}
	/**
	 * 查询分类信息
	 * @return
	 */
	@RequestMapping("/queryCategory.do")
	public ModelAndView queryCategory(Model model,@RequestParam("operation")String operation,
			@RequestParam("category_id")String category_id){
		//返回结果Map
		Map<String,Object> returnMap = new HashMap<String,Object>();
		if(operation!=null && "add".equals(operation)){
			return new ModelAndView("category/addCategory.jsp","map",returnMap);
		}else{
			Map map = new HashMap();
			map.put("category_id", category_id);//2级
			category = categoryService.queryCategory(map);
			returnMap.put("category", category);
			if(category.getRank()==3){
				map.clear();
				map.put("category_id", category.getParent_id());
				secondCategory = categoryService.queryCategory(map);
				returnMap.put("secondCategory", secondCategory);
			}
		 
			if(operation!=null && "edit".equals(operation)){
				map.clear();
				map.put("rank", 1);
				categoryList = categoryService.queryCategoryList(map);
				returnMap.put("categoryList", categoryList);
				map.clear();
				if(category.getRank()==2){
					map.put("parent_id", category.getParent_id());
					secondCategoryList = categoryService.queryCategoryList(map);
					returnMap.put("secondCategoryList", secondCategoryList);
				}
				if(category.getRank()==3){
					map.put("parent_id", secondCategory.getParent_id());
					secondCategoryList = categoryService.queryCategoryList(map);
					returnMap.put("secondCategoryList", secondCategoryList);
				}
				
				return new ModelAndView("category/updateCategory.jsp","map",returnMap);
			}else if(operation!=null && "query".equals(operation)){
				return new ModelAndView("category/query.jsp","map",returnMap);
			}
		}
		return null;
	}
	

	/**
	 * 获取分类相关父类信息
	 */
	@RequestMapping("/getSecondType.do")
	public void getSecondType(HttpServletResponse response,@RequestParam("category_id")String category_id){
		PrintWriter out = null;
		try {
			Map categoryMap = new HashMap();
			categoryMap.put("status", 1);
		    categoryMap.put("parent_id", category_id);
		    
			List list = categoryService.queryCategoryList(categoryMap);
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
	 * 获取对应等级的分类
	 */
	@RequestMapping("/getCategory.do")
	public void getCategory(HttpServletResponse response,@RequestParam("rank")String rank){
		PrintWriter out = null;
		try {
			Map categoryMap = new HashMap();
			categoryMap.put("status", 1);
		    categoryMap.put("rank", rank);
		    
			List list = categoryService.queryCategoryLists(categoryMap);
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
	public static Logger getLog() {
		return log;
	}

	public static void setLog(Logger log) {
		CategoryAction.log = log;
	}

	public ICategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(ICategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public PageInfo<Category> getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo<Category> pageInfo) {
		this.pageInfo = pageInfo;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String categoryId) {
		category_id = categoryId;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public List<File> getMyImageFile() {
		return myImageFile;
	}

	public void setMyImageFile(List<File> myImageFile) {
		this.myImageFile = myImageFile;
	}

	public List<String> getMyImageFileFileName() {
		return myImageFileFileName;
	}

	public void setMyImageFileFileName(List<String> myImageFileFileName) {
		this.myImageFileFileName = myImageFileFileName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List categoryList) {
		this.categoryList = categoryList;
	}
	public List getChildList() {
		return childList;
	}
	public void setChildList(List childList) {
		this.childList = childList;
	}
	public String getSecond_id() {
		return second_id;
	}
	public void setSecond_id(String secondId) {
		second_id = secondId;
	}
	public List getSecondCategoryList() {
		return secondCategoryList;
	}
	public void setSecondCategoryList(List secondCategoryList) {
		this.secondCategoryList = secondCategoryList;
	}
	public Category getSecondCategory() {
		return secondCategory;
	}
	public void setSecondCategory(Category secondCategory) {
		this.secondCategory = secondCategory;
	}
	
	
	/**
	 * 1.查询所有三级分类
	 */
	@RequestMapping("/selectCategory.do")
	public Map selectCategory(HttpSession session, GoodsInfo goodsInfo) {
		Map<String,Object> resultMap = new HashMap<String, Object>();
		Map<String,Object> map = new HashMap<String,Object>();
		map.clear();
		map.put("rank", 3);
		map.put("status", 1);
		List categoryList = categoryService.queryCategoryList(map);
		resultMap.put("categoryList", categoryList);
		return resultMap;
	}
}
