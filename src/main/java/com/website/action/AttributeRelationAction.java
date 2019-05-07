package com.website.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.power.bean.WorkerInfo;
import com.website.bean.Attribute;
import com.website.bean.AttributeRelation;
import com.website.bean.AttributeValue;
import com.website.bean.Category;
import com.website.bean.PageInfo;
import com.website.service.IAttributeRelationService;
import com.website.service.IAttributeService;
import com.website.service.IAttributeValueService;
import com.website.service.ICategoryService;
import com.website.utils.CommonsUtil;
import com.website.utils.DateUtil;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/attributeRelation")
public class AttributeRelationAction extends BaseAction{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1l;
	
	/**
	 *  生成日志对象
	 */
	private static Logger log = Logger.getLogger(AttributeRelationAction.class);

	/**
	 *  属性信息的service对象
	 */
	@Autowired
	private IAttributeRelationService attributeRelationService;
	@Autowired
	private IAttributeService attributeService;
	@Autowired
	private IAttributeValueService attributeValueService;
/*	@Autowired
	private IGoodsService goodsService;
	@Autowired
	private IGoodsAttrInfoService goodsAttrInfoService;*/
	@Autowired
	private ICategoryService categoryService;
	
	private List attributeRelationList;				//分类列表
	private PageInfo<AttributeRelation> pageInfo;	//显示分页列表
	private List attributeList;
	private List attributeValueList;
	private List goodsList;
	
	/**
	 * 查询结果实体类
	 */

	private AttributeRelation attributeRelation;
	private Attribute attribute;
	private AttributeValue attributeValue;
	/*private GoodsAttrInfo goodsAttrInfo;
	private Goods goods;*/
	
	/**
	 * 查询条件
	 */
	private String relation_id;
	private String goods_id;
	private String value_id;
	private String attr_id;
	private String attr_name;		//属性名称
	private String value_name;		//属性值
	private String value_name_new; //新增属性
	private Integer status;			//状态
	private String array;
	private String value_id_Str; //属性id字符串
	
	private String category_id;//分类ID
	
	/**
	 * 查询属性信息列表
	 */
	@RequestMapping("/selectAttributeRelationList.do")
	public ModelAndView selectAttributeRelationList(PageInfo pageInfo,AttributeRelation attributeRelation){
		//返回结果Map
		Map<String,Object> returnMap = new HashMap<String,Object>();
		if(pageInfo == null || pageInfo.getCurrentPage() == 0){
			pageInfo = new PageInfo<AttributeRelation>();
			pageInfo.setCurrentPage("1"); 
		}
		Map requestMap = new HashMap();
		String category_name = attributeRelation.getCategory_name();
		if(attributeRelation.getAttr_name() != null&&  !"".equals(attributeRelation.getAttr_name())){
			requestMap.put("attr_name", attributeRelation.getAttr_name());		//属性名称
			returnMap.put("attr_name", attributeRelation.getAttr_name());
		}
		if( attributeRelation.getStatus()!=null &&  !"".equals( attributeRelation.getStatus())&&!"0".equals( attributeRelation.getStatus())){
			returnMap.put("status", attributeRelation.getStatus());
			requestMap.put("status", attributeRelation.getStatus());
		}else{
			returnMap.put("status", "1");
			requestMap.put("status", "1");
		}
		if(CommonsUtil.isNotEmpty(category_name)){
			returnMap.put("category_name", category_name);
			requestMap.put("category_name", category_name);
		}
		
		pageInfo = attributeRelationService.queryAttributeRelationListByPage(pageInfo, requestMap);
		returnMap.put("pageInfo", pageInfo);
		return new ModelAndView("attributeRelation/attributeRelationlist.jsp","map",returnMap);
	}
	
	/**
	 * 进入属性信息
	 */
	@RequestMapping("/insertAttributeRelationPage.do")
	public ModelAndView insertAttributeRelationPage(){
		//查询map
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//返回结果Map
		Map<String,Object> returnMap = new HashMap<String,Object>();
		//查询关联一级分类
		requestMap.clear();
		requestMap.put("rank", 1);
		requestMap.put("status", 1);
		List categoryList = categoryService.queryCategoryList(requestMap);
		returnMap.put("categoryList", categoryList);
		
		attribute = new Attribute();
		Map  map = new HashMap();
		map.put("status", 0);
		attributeList = attributeService.queryAttributeList(map);
		String sb = "";
		if(attributeList != null && attributeList.size() >0){
			for(int i = 0; i <attributeList.size(); i++){
				Map reslutMap = (Map) attributeList.get(i);
				String attr_id = "" + reslutMap.get("attr_id");
				sb +=attr_id;
			}
		}
		attribute.setStr(sb);
		returnMap.put("attribute", attribute);
		
		return new ModelAndView("attributeRelation/addAttributeRelation.jsp","map",returnMap);
	}
	
	/**
	 * 添加属性操作
	 */
	@RequestMapping("/insertAttributeRelation.do")
	public String insertAttributeRelation(Attribute attribute,AttributeValue attributeValue,
			@RequestParam(value="array")String array,
			@RequestParam(value="category_id")String category_id,
			HttpServletRequest request){
		WorkerInfo workerInfo = (WorkerInfo)request.getSession().getAttribute("workerInfo");
		if(workerInfo == null){
			return "redirect:/login/workLogin.do";
		}
		attributeRelation = new AttributeRelation();
		attributeValue = new AttributeValue();
		
		String worker_id = workerInfo.getWorkerId();
		attribute.setStatus(1);
		attribute.setUpload_person(worker_id);
		attribute.setCreate_date(new Date());
		attribute.setUpdate_date(new Date());
		attribute.setSort(0);
		attributeService.insertAttribute(attribute);
		attr_id = attribute.getAttr_id()+"";
		
		String [] stringArr= array.split(",");  
		for(int i = 0; i < stringArr.length; i ++){
			value_name = stringArr[i].trim();
			relation_id = CommonsUtil.getPrimaryKey();
			attributeValue.setValue_name(value_name);
			attributeValue.setUpload_person(worker_id);
			attributeValue.setCreate_date(new Date());
			attributeValue.setUpdate_date(new Date());
			attributeValueService.insertAttributeValue(attributeValue);
			value_id =attributeValue.getValue_id()+"";
			attributeRelation.setAttr_id(attr_id);
			attributeRelation.setValue_id(value_id);
			attributeRelation.setCategory_id(category_id);
			attributeRelationService.insertAttributeRelation(attributeRelation);
		}
		
		return "redirect:selectAttributeRelationList.do";
	}
	
	
	/**
	 * 进入更新页
	 */
	@RequestMapping("/updateAttributeRelationPage.do")
	public ModelAndView updateAttributeRelationPage(@RequestParam(value="attr_id")String attr_id){
		//返回结果Map
		Map<String,Object> returnMap = new HashMap<String,Object>();
		Map map = new HashMap();
		map.put("attr_id", attr_id);
		attribute = attributeService.queryAttribute(map);
		List<AttributeRelation> attributeRelationList = attributeRelationService.queryAttributeRelationList(map);
		attributeValueList = attributeValueService.queryAttributeValueList(map);
		
		if(null != attributeValueList && 0 < attributeValueList.size()){
			Map tmepMap = new HashMap();
			value_id_Str = "";
			for(Object obj : attributeValueList){
				tmepMap = (Map) obj;
				value_id_Str += tmepMap.get("value_id") + ",";
			}
			value_id_Str = value_id_Str.substring(0, value_id_Str.length() - 1);
			returnMap.put("value_id_Str", value_id_Str);
		}
		
		returnMap.put("attribute", attribute);
		returnMap.put("attributeValueList", attributeValueList);
		returnMap.put("attr_id", attr_id);
		//查询所属三级分类
		map.clear();
		if(attributeRelationList!=null && attributeRelationList.size()>0){
			AttributeRelation attributeRelation = attributeRelationList.get(0);
			if(attributeRelation.getCategory_id()!=null && !"".equals(attributeRelation.getCategory_id())){
				map.put("category_id", attributeRelation.getCategory_id());
				map.put("status", 1);
				Category category = categoryService.queryCategory(map);
				if(null != category){
					String child_id = category.getParent_id();
					returnMap.put("category_id", category.getCategory_id());//三级分类
					returnMap.put("child_id", child_id);//二级分类
					map.put("category_id", child_id);
					Category childCategory = categoryService.queryCategory(map);
					if(null != childCategory){
						map.clear();
						map.put("parent_id", child_id);
						map.put("status", 1);
						List categoryList = categoryService.queryCategoryList(map);
						returnMap.put("categoryList", categoryList);//三级分类集合
						map.put("parent_id", childCategory.getParent_id());
						List childCategoryList = categoryService.queryCategoryList(map);
						returnMap.put("parent_id", childCategory.getParent_id());//一级分类
						returnMap.put("childCategoryList", childCategoryList);	//二级分类集合
					}
				}
			}
		}
		//查询关联一级分类
		map.clear();
		map.put("rank", 1);
		map.put("status", 1);
		List parentCategoryList = categoryService.queryCategoryList(map);
		returnMap.put("parentCategoryList", parentCategoryList);
		
		return new ModelAndView("attributeRelation/updateAttributeRelation.jsp","map",returnMap);
	}
	
	/**
	 * 更新属性信息
	 */ 
	@RequestMapping("/updateAttributeRelation.do")
	public String updateAttributeRelation(Attribute attribute,HttpSession session,
			@RequestParam(value="value_name")String value_name,
			@RequestParam(value="value_id_Str")String value_id_Str,
			@RequestParam(value="value_name_new")String value_name_new,
			@RequestParam(value="category_id")String category_id,
			@RequestParam(value="attr_id")String attr_id){
		//WorkerInfo workerInfo = (WorkerInfo)request.getSession().getAttribute("workerInfo");
		WorkerInfo workerInfo = (WorkerInfo) session.getAttribute("workerInfo");
		if(workerInfo == null){
			return "redirect:/login/workLogin.do";
		}
		String worker_id = workerInfo.getWorkerId();
		attribute.setUpdate_date(new Date());
		if(!"".equals(value_name) && !"".equals(value_id_Str)){
			String[] strvalue = value_name.split(",");
			String[] strvalue_id = value_id_Str.split(",");
			if(strvalue.length == strvalue_id.length){
				for(int i = 0 ; i < strvalue.length; i++){
					value_id = strvalue_id[i];
					value_name = strvalue[i];
					attributeValue = new AttributeValue();
					attributeValue.setValue_id(Integer.valueOf(value_id));
					attributeValue.setValue_name(value_name);
					attributeValue.setUpdate_date(new Date());
					attributeValueService.updateAttributeValue(attributeValue);
				}
				attributeRelation = new AttributeRelation();
				attributeRelation.setAttr_id(attr_id);
				attributeRelation.setCategory_id(category_id);
				attributeRelationService.updateAttributeRelation(attributeRelation);
			}
		}
		if(!"".equals(value_name_new)){
			String[] strvalue_new = value_name_new.split(",");
			for(int i = 0 ; i < strvalue_new.length; i++){
				attributeRelation = new AttributeRelation();
				attributeValue = new AttributeValue();
				attributeValue.setValue_name(strvalue_new[i].trim());
				attributeValue.setCreate_date(new Date());
				attributeValue.setUpdate_date(new Date());
				attributeValue.setUpload_person(worker_id);
				attributeValueService.insertAttributeValue(attributeValue);
				value_id =attributeValue.getValue_id()+"";
				attributeRelation.setValue_id(value_id);
				attributeRelation.setAttr_id(attr_id);
				attributeRelation.setCategory_id(category_id);
				attributeRelationService.insertAttributeRelation(attributeRelation);
			}
		}
		attributeService.updateAttribute(attribute);  // 更改属性名称

		
		return "redirect:selectAttributeRelationList.do";
	}
	
	/**
	 *  删除属性
	 */ 
	@RequestMapping("/updateAttributeRelationStatus.do")
	public String updateAttributeRelationStatus(HttpServletRequest request,
			@RequestParam(value="attr_id")String attr_id,
			@RequestParam(value="status")String status){     //   更新状态
		WorkerInfo workerInfo = (WorkerInfo)request.getSession().getAttribute("workerInfo");
		if(workerInfo == null){
			return "redirect:/login/workLogin.do";
		}
		String worker_id = workerInfo.getWorkerId();
		String nowdate = DateUtil.getSysTime();
		Map map = new HashMap();
		
		//String attr_ids = request.getParameter("attr_id");
		if (attr_id!=null) {
			map.put("attr_id", attr_id); 
		}
		
		
		List<AttributeRelation> attributeRelationList = attributeRelationService.queryAttributeRelation(map);
		attributeRelation = attributeRelationList.get(0);
		if(attribute == null){
			attribute = new Attribute();
		}
		attribute.setStatus(Integer.parseInt(status));
		attribute.setAttr_id(Integer.valueOf(attributeRelation.getAttr_id()));
		attribute.setUpdate_date(new Date());
		attribute.setUpload_person(worker_id);
		int updateAttribute = attributeService.updateAttribute(attribute);
		return "redirect:selectAttributeRelationList.do";
	}

/*	
	/**
	 *  删除属性
	 */
	@RequestMapping("/deleteAttributeRelationStatus.do")
	public String deleteAttributeRelationStatus(HttpServletRequest request,@RequestParam(value="attr_id")String attr_id){
		WorkerInfo workerInfo = (WorkerInfo)request.getSession().getAttribute("workerInfo");
		if(workerInfo == null){
			return "redirect:/login/workLogin.do";
		}
	/*	goodsAttrInfo = new GoodsAttrInfo();*/
		Map requestMap = new HashMap();
		requestMap.put("attr_id", attr_id);
		System.out.println("attr_id=" + attr_id);
		requestMap.put("is_on_sale", 1);
	/*	goodsList = goodsService.queryGoodsListByAttrId(requestMap);*/
		/*if(null != goodsList && 0 < goodsList.size()){
			return "attributeRelation/showGoodsList.jsp";
		}else{*/
			requestMap.clear();
			requestMap.put("attr_id", attr_id);
			Attribute attribute = attributeService.queryAttribute(requestMap);
			attribute.setStatus(2);
			attributeService.updateAttribute(attribute);
		/*}*/
		return "redirect:selectAttributeRelationList.do";
	}
	
	
	
	
	/**
	 * Ajax 获得属性ID
	 */
	@RequestMapping("/getProerty.do")
	public void getProerty(HttpServletRequest request,HttpServletResponse response){
		PrintWriter out = null;
		try{
			String attr_name = new String(request.getParameter("attr_name").getBytes("iso8859-1"),"utf-8"); 
			Map map = new HashMap();
			map.put("attr_name", attr_name);
			List list = attributeService.queryAttributeList1(map);
			
			response.setContentType("text/html;charset=UTF-8");
			out = response.getWriter();
			JSONArray jsonArray = JSONArray.fromObject(list);
			out.write(list == null || list.size()<1 ? "[]" : jsonArray.toString());
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(out != null){
				out.flush();
				out.close();
			}
		}
		
	}
	
	
	/**
	 * 获取属性列表
	 */
	@RequestMapping("/getAttributeInfo.do")
	public void getAttributeInfo(@RequestParam(value="category_id")String category_id,HttpServletResponse response){
		PrintWriter out = null;
		try {
			Map categoryMap = new HashMap();
			categoryMap.put("status", 0);
			categoryMap.put("category_id", category_id);
			List list = attributeService.queryCategoryAttr(categoryMap);
			
			List resultList = new ArrayList();
			
			Map resultMap = null;
			
			for(int i=0;i<list.size();i++){
				
				resultMap = new HashMap();
				Map category = (Map)list.get(i);
				String attr_id = ""+category.get("attr_id");
				String attr_name = ""+category.get("attr_name");
				
				resultMap.put("attr_id", attr_id);
				resultMap.put("attr_name", attr_name);
				
				Map attrValueMap = new HashMap();
				attrValueMap.put("attr_id", attr_id);
				List attrValueList = attributeService.queryAttrValueList(attrValueMap);
				resultMap.put("attr_value", attrValueList);
				resultList.add(resultMap);
			}
			response.setContentType("text/html;charset=UTF-8");
			out = response.getWriter();
			JSONArray jsonArray = JSONArray.fromObject(resultList);
			out.write(resultList == null || resultList.size() < 1 ? "[]" : jsonArray
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
	 * 属性详情页
	 */
	@RequestMapping("/detailsAttributeRelationPage.do")
	public ModelAndView detailsAttributeRelationPage(@RequestParam(value="attr_id")String attr_id){
		//返回结果Map
		Map<String,Object> returnMap = new HashMap<String,Object>();
		Map map = new HashMap();
		map.put("attr_id", attr_id);
		attribute = attributeService.queryAttribute(map);
		attributeRelationList = attributeRelationService.queryAttributeRelationList(map);
		returnMap.put("attributeRelationList", attributeRelationList);
		returnMap.put("attribute", attribute);
		return  new ModelAndView("attributeRelation/detailsattributerelation.jsp","map",returnMap);
	}
	
	/***
	 * 根据属性值id 删除属性name
	 * @param value_id
	 * @return
	 */
	@RequestMapping("/delAttribute.do")
	public void delAttribute(String value_id,String relation_id, HttpServletResponse response){
		if(value_id!=null && !value_id.equals("")){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("value_id", value_id);
			int a =attributeValueService.delAttributeValue(map);
			if(a>0){
				attributeRelationService.deleteAttributeRelation(Integer.valueOf(relation_id));
				response(response, "OK", "操作成功！");
			}
		}
		response(response, "fail", "操作失败！");
	}
	
	
	public IAttributeRelationService getAttributeRelationService() {
		return attributeRelationService;
	}

	public void setAttributeRelationService(
			IAttributeRelationService attributeRelationService) {
		this.attributeRelationService = attributeRelationService;
	}

	public IAttributeService getAttributeService() {
		return attributeService;
	}

	public void setAttributeService(IAttributeService attributeService) {
		this.attributeService = attributeService;
	}

	public IAttributeValueService getAttributeValueService() {
		return attributeValueService;
	}

	public void setAttributeValueService(
			IAttributeValueService attributeValueService) {
		this.attributeValueService = attributeValueService;
	}

	public List getAttributeRelationList() {
		return attributeRelationList;
	}

	public void setAttributeRelationList(List attributeRelationList) {
		this.attributeRelationList = attributeRelationList;
	}

	public PageInfo<AttributeRelation> getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo<AttributeRelation> pageInfo) {
		this.pageInfo = pageInfo;
	}

	public AttributeRelation getAttributeRelation() {
		return attributeRelation;
	}

	public void setAttributeRelation(AttributeRelation attributeRelation) {
		this.attributeRelation = attributeRelation;
	}

	public Attribute getAttribute() {
		return attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}

	public AttributeValue getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(AttributeValue attributeValue) {
		this.attributeValue = attributeValue;
	}

	public String getAttr_name() {
		return attr_name;
	}

	public void setAttr_name(String attr_name) {
		this.attr_name = attr_name;
	}

	public String getValue_name() {
		return value_name;
	}

	public void setValue_name(String value_name) {
		this.value_name = value_name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRelation_id() {
		return relation_id;
	}

	public void setRelation_id(String relation_id) {
		this.relation_id = relation_id;
	}

	public String getValue_id() {
		return value_id;
	}

	public void setValue_id(String value_id) {
		this.value_id = value_id;
	}

	public String getAttr_id() {
		return attr_id;
	}

	public void setAttr_id(String attr_id) {
		this.attr_id = attr_id;
	}

/*	public IGoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(IGoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public IGoodsAttrInfoService getGoodsAttrInfoService() {
		return goodsAttrInfoService;
	}

	public void setGoodsAttrInfoService(IGoodsAttrInfoService goodsAttrInfoService) {
		this.goodsAttrInfoService = goodsAttrInfoService;
	}

	public GoodsAttrInfo getGoodsAttrInfo() {
		return goodsAttrInfo;
	}

	public void setGoodsAttrInfo(GoodsAttrInfo goodsAttrInfo) {
		this.goodsAttrInfo = goodsAttrInfo;
	}
*/
	public String getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}

	public List getAttributeList() {
		return attributeList;
	}

	public void setAttributeList(List attributeList) {
		this.attributeList = attributeList;
	}

	public String getArray() {
		return array;
	}

	public void setArray(String array) {
		this.array = array;
	}

	public List getAttributeValueList() {
		return attributeValueList;
	}

	public void setAttributeValueList(List attributeValueList) {
		this.attributeValueList = attributeValueList;
	}

	public String getValue_id_Str() {
		return value_id_Str;
	}

	public void setValue_id_Str(String valueIdStr) {
		this.value_id_Str = valueIdStr;
	}

	public String getValue_name_new() {
		return value_name_new;
	}

	public void setValue_name_new(String valueNameNew) {
		this.value_name_new = valueNameNew;
	}
	
	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String categoryId) {
		category_id = categoryId;
	}

	public List getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List goodsList) {
		this.goodsList = goodsList;
	}
	
	/**
	 * 根据分类查询分类下的属性
	 */
	@RequestMapping("/getAttrbuteByCateId.do")
	public void getAttrbuteByCateId(HttpServletResponse response,@RequestParam("category_id")String category_id){
		PrintWriter out = null;
		try {
			Map attrMap = new HashMap();
			attrMap.put("category_id", category_id);
			List list = attributeRelationService.queryAttributeList(attrMap);
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
	 * 根据属性id查询属性值
	 */
	@RequestMapping("/getAttrValueById.do")
	public void getAttrValueById(HttpServletResponse response,@RequestParam("attr_id")String attr_id){
		PrintWriter out = null;
		try {
			Map attrMap = new HashMap();
			attrMap.put("attr_id", attr_id);
			List list = attributeRelationService.queryAttributeValueList(attrMap);
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
	 * 查询分类是否有扩展信息
	 *(ZHZ)2017-3-30
	 * @return
	 */
	@RequestMapping("/queryCateExtendAttrIsExist.do")
	public void queryCateExtendAttrIsExist(HttpServletResponse response,String category_id,String rank){
		try {
			//如果是1级.2级
			if("1".equals(rank)||"2".equals(rank)){
				List categoryList =categoryService.queryCategoryListsByPid(category_id);
				//分类有扩展属性，不能删除
				if(categoryList.size() >0){
					response.getWriter().write("no");
				}else{
					//分类没有扩展属性，可以删除
					response.getWriter().write("ok");
				}
			}else{
				List <AttributeRelation> extendInfoes = attributeRelationService.queryCateExtendAttrIsExist(category_id);
				//分类有扩展属性，不能删除
				if(extendInfoes.size() >0){
					response.getWriter().write("no");
				}else{
					//分类没有扩展属性，可以删除
					response.getWriter().write("ok");
				}
			}
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
}
