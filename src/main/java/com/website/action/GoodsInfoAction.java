/**
 * 
 */
package com.website.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.power.bean.WorkerInfo;
import com.website.bean.Category;
import com.website.bean.GoodsInfo;
import com.website.bean.GoodsInfoWithBLOBs;
import com.website.bean.GoodsLabel;
import com.website.bean.GoodsPic;
import com.website.bean.PageInfo;
import com.website.service.IAttributeRelationService;
import com.website.service.ICategoryService;
import com.website.service.IChannelService;
import com.website.service.IGoodsInfoService;
import com.website.service.IGoodsLabelServise;
import com.website.service.IGoodsPicService;
import com.website.service.IGoodsRelationService;
import com.website.service.IGoodsSkuRelationService;
import com.website.service.IGoodsSkuService;
import com.website.service.ILanguageService;
import com.website.service.IRecommendGoodsService;
import com.website.utils.CommonsUtil;

/**  
 * 描述: 
 * @Company: 博众援创 
 * @author shengtaihua 
 * @date  2018-10-11 
 */
@Controller
@RequestMapping("/goodsInfo")
public class GoodsInfoAction extends BaseAction{
 
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(GoodsInfoAction.class);
	
	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private ILanguageService languageService;
	@Autowired
	private IChannelService channelService;
	@Autowired
	private IGoodsInfoService goodsInfoService;
	@Autowired
	private IGoodsRelationService goodsRelationService;
	@Autowired
	private IRecommendGoodsService recommendGoodsService;
	@Autowired
	private IGoodsSkuService goodsSkuService;
	@Autowired
	private IGoodsSkuRelationService goodsSkuRelationService;
	@Autowired
	private IGoodsPicService goodsPicService;
	@Autowired
	private IAttributeRelationService attributeRelationService;
	@Autowired
	private IGoodsLabelServise goodsLabelServise;
	/**
	 * 查询商品信息列表
	 */
	@RequestMapping("/selectGoodsInfoList.do")
	public ModelAndView selectGoodsInfoList(HttpServletRequest request,PageInfo<Map> pageInfo,GoodsInfoWithBLOBs goodsInfo){
		//返回结果Map
		Map<String,Object> returnMap = new HashMap<String,Object>();
		try {
			if(pageInfo == null || pageInfo.getCurrentPage() == 0){
				pageInfo = new PageInfo<Map>();
				pageInfo.setCurrentPage("1"); 
			}
			Map map = new HashMap();
			
			if(goodsInfo.getStatus()!=null &&  !"".equals(goodsInfo.getStatus())&&!"0".equals(goodsInfo.getStatus())){
				returnMap.put("status", goodsInfo.getStatus());
				map.put("status", goodsInfo.getStatus()+"");
			}
			
			String goodsName = goodsInfo.getGoodsName();
			if(CommonsUtil.isNotEmpty(goodsName)){
				returnMap.put("goodsName", goodsName);
				map.put("goodsName", goodsName);
			}
			String goodsCode = goodsInfo.getGoodsCode();
			if(CommonsUtil.isNotEmpty(goodsCode)){
				returnMap.put("goodsCode", goodsCode);
				map.put("goodsCode", goodsCode);
			}
			Integer categoryId = goodsInfo.getCategoryId();
			if(CommonsUtil.isNotEmpty(categoryId+"")){
				returnMap.put("category_id", categoryId);
				map.put("category_id", categoryId);
			}
			returnMap.put("vip_price", goodsInfo.getVipPrice());
//			 category_id = goodsInfo.getCategory_id();
			Integer parent_id = goodsInfo.getParent_id();
			Integer child_id = goodsInfo.getChild_id();
			Integer category_id = goodsInfo.getCategory_id();
			if(parent_id!=null && !"".equals(parent_id)){
				map.put("parent_id",parent_id);
				returnMap.put("parent_id", parent_id);
				if(child_id!=null && !"".equals(child_id)){
					map.put("child_id", child_id);
					returnMap.put("child_id", child_id);
					if(category_id!=null && !"".equals(category_id)){
						map.put("category_id", category_id);
						returnMap.put("category_id", category_id);
					}
				}
			}
		 	pageInfo = goodsInfoService.queryGoodsListByPage(pageInfo, map);
			returnMap.put("pageInfo", pageInfo); 
			returnMap.put("parent_id", goodsInfo.getParent_id()); 
			//查询一级
			map.clear();
			map.put("rank", 1);
			map.put("status", 1);
		    List categoryList = categoryService.queryCategoryList(map);
		    List thildList = new ArrayList();
		    List childList = new ArrayList();
			//查询二级
		    System.out.println(goodsInfo.toString());
			if(goodsInfo.getParent_id()+""!=null && ! ("").equals(goodsInfo.getParent_id()+"")){
				map.clear();
				map.put("rank", 2);
				map.put("status", 1);
				map.put("parent_id",  goodsInfo.getParent_id());
				childList = categoryService.queryCategoryList(map);
				//查询三级
				if(goodsInfo.getChild_id()!=null && ! ("").equals(goodsInfo.getChild_id())){
					map.clear();
					map.put("rank", 3);
					map.put("status", 1);
					map.put("parent_id",  goodsInfo.getChild_id());
				    thildList = categoryService.queryCategoryList(map);
				}
			
			map.clear();
			map.put("status", 1);
//			List languageList=languageService.queryLanguageList(map);
			List channelList= channelService.queryChannelList(map);
			//返回结果集
			returnMap.put("categoryList", categoryList);
			returnMap.put("childList", childList);
			returnMap.put("thildList", thildList);
//			returnMap.put("languageList", languageList);
			returnMap.put("channelList", channelList);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ModelAndView("goodsInfo/goodsInfoList.jsp","map",returnMap);
	}
	
	
	/**
	 * 团购管理查询商品信息列表
	 */
	@RequestMapping("/getGoodsInfoList.do")
	@ResponseBody
	public Map getGoodsInfoList(PageInfo<Map> pageInfo,GoodsInfo goodsInfo){
		//返回结果Map
		Map<String,Object> returnMap = new HashMap<String,Object>();
		Map map = new HashMap();
		String goodsName = goodsInfo.getGoodsName();
		if(CommonsUtil.isNotEmpty(goodsName)){
			returnMap.put("goodsName", goodsName);
			map.put("goodsName", goodsName);
		}
		String goodsCode = goodsInfo.getGoodsCode();
		if(CommonsUtil.isNotEmpty(goodsCode)){
			returnMap.put("goodsCode", goodsCode);
			map.put("goodsCode", goodsCode);
		}
	 	pageInfo = goodsInfoService.getGoodsInfoList(pageInfo, map);
		returnMap.put("pageInfo", pageInfo); 
		/*map.clear();
		map.put("status", 1);
		List channelList= channelService.queryChannelList(map);
		returnMap.put("channelList", channelList);*/
		System.out.println(returnMap);
		return returnMap;
	}

	/**wxt新增商品
	 * 进入属性信息
	 */
	@RequestMapping("/insertGoodsInfoPage.do")
	public ModelAndView insertGoodsInfoPage(){
		//查询map
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//返回结果Map
		Map<String,Object> returnMap = new HashMap<String,Object>();
		//查询关联一级分类
		try {
			requestMap.clear();
			requestMap.put("rank", 1);
			requestMap.put("status", 1);
			List categoryList = categoryService.queryCategoryList(requestMap);
			returnMap.put("categoryList", categoryList);
			
			requestMap.clear();
			requestMap.put("status", 1);
//			List languageList=languageService.queryLanguageList(requestMap);
			List channelList= channelService.queryChannelList(requestMap);
//			returnMap.put("languageList", languageList);
			returnMap.put("channelList", channelList);
			List<GoodsLabel> goodsLabels=goodsLabelServise.selectByMap(new HashMap());
			returnMap.put("goodsLabels", goodsLabels);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ModelAndView("goodsInfo/addGoodsInfo.jsp","map",returnMap);
	}
	
	/**
	 * 1.查询所有商品
	 */
	@RequestMapping("/selectGoods.do")
	public ModelAndView selectGoods(HttpSession session,HttpServletRequest request,HttpServletResponse response,GoodsInfo goodsInfo,String recgGoodsIds) {
		Map<String,Object> resultMap = new HashMap<String, Object>();
		Map<String,Object> requestMap = new HashMap<String,Object>();
		String goodsName = goodsInfo.getGoodsName();
		if(CommonsUtil.isNotEmpty(goodsName)){
			requestMap.put("goodsName", goodsName);
			resultMap.put("goodsName", goodsName);
		}
		String goodsCode = goodsInfo.getGoodsCode();
		if(CommonsUtil.isNotEmpty(goodsCode)){
			requestMap.put("goodsCode", goodsCode);
			resultMap.put("goodsCode", goodsCode);
		}
		requestMap.put("status", 1);
		List<Map> allGoodsList= goodsInfoService.queryAllGoodsList(requestMap);
		resultMap.put("allGoodsList", allGoodsList);
		return new ModelAndView("goodsInfo/goodsInfoList.jsp", "map", requestMap);
	}
	
	/**
	 * wxt新增商品
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/insertGoods.do")
	public ModelAndView insertGoods(HttpSession session,HttpServletRequest request,HttpServletResponse response,GoodsInfoWithBLOBs goodsInfo) throws IOException {
		WorkerInfo worker = (WorkerInfo) session.getAttribute("workerInfo");
		try {
			goodsInfo.setCreateDate(new Date());
			goodsInfo.setUpdateDate(new Date());
			goodsInfo.setCreateUserId(worker.getWorker_id());
//			goodsInfo.setStatus(1);
			goodsInfo.setGoodsCode(CommonsUtil.getPrimaryKey());
			goodsInfo.setSaleCount(0);
			goodsInfo.setDescription(goodsInfo.getAdWords());;
			//保存商品分类
			if (goodsInfo.getCategoryId()!=null) {
				Map map=new HashMap();
				map.put("category_id", goodsInfo.getCategoryId());
				Category category=categoryService.queryCategory(map);
				goodsInfo.setCategoryName(category.getCategory_name());
			}
			//保存标签
			if (goodsInfo.getLabelId()!=null&&goodsInfo.getLabelId()==0&& goodsInfo.getLabelName()!=null) {
				GoodsLabel goodsLabel=new GoodsLabel();
				goodsLabel.setCreateDate(new Date());
				goodsLabel.setUpdateDate(new Date());
				goodsLabel.setOperator(worker.getWorker_id());
				goodsLabel.setStatus(1);
				goodsLabel.setLabelName(goodsInfo.getLabelName());
				goodsLabelServise.insertSelective(goodsLabel);
				
				goodsInfo.setLabelId(goodsLabel.getLabelId());
			}
			
		
			//保存商品分类
//			goodsRelation.setCreateDate(new Date());
//			goodsRelation.setUpdateDate(new Date());
//			goodsRelation.setGoodsId(goodsInfo.getGoodsId());
//		 	goodsRelationService.insertGoodsRelation(goodsRelation);
			
			//保存推荐商品
//			if (CommonsUtil.isNotEmpty(recgGoodsIds)) {
//				String[] recgIds = recgGoodsIds.split(",");
//				RecommendGoods recommendGoods = new RecommendGoods();
//				for (int i = 0; i < recgIds.length; i++) {
//					recommendGoods.setRecommendGoodsId(Integer.parseInt(recgIds[i]));
//					recommendGoods.setGoodsId(goodsInfo.getGoodsId());
//					recommendGoods.setCreateDate(new Date());
//			 		recommendGoodsService.insertGoodsRelation(recommendGoods);
//				}
//			}
			//保存sku商品
//			 List<GoodsSku> goodsSkus =goodsInfo.getGoodsSkus();
//			 if (null != goodsSkus && goodsSkus.size() > 0 ) {
//				for (GoodsSku goodsSku : goodsSkus) {
//					goodsSku.setGoodsId(goodsInfo.getGoodsId());
//					goodsSku.setCreateDate(new Date());
//					goodsSku.setUpdateDate(new Date());
//					goodsSku.setCreateUserId(worker.getWorker_id());
//			 		goodsSkuService.insertGoodsSkuInfo(goodsSku);
//					//保存sku关系
//					GoodsSkuRelation goodsSkuRelation =new GoodsSkuRelation();
//					goodsSkuRelation.setCreateDate(new Date());
//					goodsSkuRelation.setUpdateDate(new Date());
//					goodsSkuRelation.setGoodsId(goodsInfo.getGoodsId());
//					goodsSkuRelation.setSkuId(goodsSku.getSkuId());
//					
//					String relationIds =goodsSku.getRelationId();
//					String[] relIds = relationIds.split(",");
//					for (int a = 0; a < relIds.length; a++) {
//						goodsSkuRelation.setRelationId(Integer.parseInt(relIds[a]));
//				 	 	goodsSkuRelationService.insertGoodsRelationSkuInfo(goodsSkuRelation);
//					}
//					
//				}
//			 }
//			
			//保存商品图片
			 List<GoodsPic> goodsPics =goodsInfo.getGoodsPics();
			 if (null != goodsPics && goodsPics.size() > 0 ) {
				 
				 if (CommonsUtil.isNotEmpty(goodsPics.get(0).getPicUrl()+"")) {
					 goodsInfo.setGoodsPic(goodsPics.get(0).getPicUrl()+"");
					 goodsInfoService.insertGoodsInfo(goodsInfo);
					}
				 
				for (GoodsPic goodsPic : goodsPics) {
					if (CommonsUtil.isEmpty(goodsPic.getPicUrl()+"")) {
						continue;
					}
					goodsPic.setGoodsId(goodsInfo.getGoodsId());
					goodsPic.setCreateDate(new Date());
					goodsPic.setUpdateDate(new Date());
			 		goodsPicService.insertGoodsPic(goodsPic);
				}
			 }
		} catch (Exception e) {
			// TODO: handle exception
		}
//		 return new ModelAndView("goodsInfo/addGoodsInfo.jsp", "map" ,new Object());
		 return new ModelAndView("redirect:/goodsInfo/selectGoodsInfoList.do");

	}
	
	/**
	 * 7.下载会员文件模板
	 */
	@RequestMapping("/downloadTemp.do")
	public void downloadTemp(HttpServletRequest request,HttpServletResponse response){
	    try {
		    String fileName = "cardTemplate.xlsx";
		    String path = request.getSession().getServletContext().getRealPath("/template")+"/"+fileName;
		    path = path.replace("\\", "/");
		   	File file = new File(path);
		   	String filename = file.getName();
		   	// 取得文件的后缀名。
		   	String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();
	   		// 以流的形式下载文件。
		   	InputStream fis = new BufferedInputStream(new FileInputStream(path));
		   	byte[] buffer = new byte[fis.available()];
		   	fis.read(buffer);
		   	fis.close();
		   	// 清空response
		   	response.reset();
		   	// 设置response的Header
		   	response.addHeader("Content-Disposition", "attachment;filename=" + response.encodeURL(new String(filename.getBytes("gb2312"), "iso8859-1")));
		   	response.addHeader("Content-Length", "" + file.length());
		   	OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
//		   	response.setContentType("application/octet-stream");
		   	response.setContentType("application/vnd.ms-excel;charset=utf-8");
		   	toClient.write(buffer);
		   	toClient.flush();
		   	toClient.close();
	    } catch (IOException ex) {
            ex.printStackTrace();
        }

	}
	
	/**
	 * wxt查询商品的属性
	 */
	@RequestMapping("/getGoodsAttrList.do")
	public ModelAndView getGoodsAttrList(HttpServletResponse response,@RequestParam("goods_id")String goods_id){
		Map goods=new HashMap();
		try {
			Map categoryMap = new HashMap();
		    categoryMap.put("goods_id", goods_id);
		    goods=goodsInfoService.qyById(Integer.valueOf(goods_id));
		    String category_name="";
		    if (CommonsUtil.isNotEmpty(goods.get("level1")+"")) {
		    	category_name=category_name+goods.get("level1").toString();
		    	
		    	if (CommonsUtil.isNotEmpty(goods.get("level2")+"")) {
			    	category_name=category_name+"---"+goods.get("level2").toString();
			    	
			    	if (CommonsUtil.isNotEmpty(goods.get("level3")+"")) {
				    	category_name=category_name+"---"+goods.get("level3").toString();
					}
				}
			}
		    goods.put("category_name", category_name);
//		    List categorylist=goodsPicService.queryPics(categoryMap);
//		    goods.put("pic", categorylist);
//			list = goodsSkuService.getGoodsAttrList(categoryMap);
//			response.setContentType("text/html;charset=UTF-8");
//			out = response.getWriter();
//			JSONArray jsonArray = JSONArray.fromObject(list);
//			out.write(list == null || list.size() < 1 ? "[]" : jsonArray
//					.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("goodsInfo/goods.jsp","goods",goods);
	}
	
	@RequestMapping("/gotoUpdateGoods.do")
	public ModelAndView gotoUpdateGoods(String goodsId) {
		Map goodsInfo = goodsInfoService.qyById(Integer.valueOf(goodsId));
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("goodsInfo", goodsInfo);
		//查询map
		Map<String,Object> requestMap = new HashMap<String,Object>();
		requestMap.clear();
		requestMap.put("status", 1);
//		List languageList=languageService.queryLanguageList(requestMap);
		List channelList= channelService.queryChannelList(requestMap);
//		returnMap.put("languageList", languageList);
		returnMap.put("channelList", channelList);
		//根据id查询图片
		requestMap.clear();
		requestMap.put("goods_id", goodsId);
		List<Map> list = goodsPicService.queryPics(requestMap);
		if (list != null && list.size() != 0 ) {
			for (int i = 0; i < 3; i++) {
				returnMap.put("pic_url"+(i), list.get(i).get("pic_url"));
				returnMap.put("is_home"+(i), list.get(i).get("is_home"));
			}
		}
		
	   requestMap.clear();
	   if(goodsInfo.get("Category_id")!=null && !"".equals(goodsInfo.get("Category_id"))){
		   requestMap.put("category_id", goodsInfo.get("Category_id"));
		   requestMap.put("status", 1);
			Category category = categoryService.queryCategory(requestMap);
			if(null != category){
				String child_id = category.getParent_id();
				returnMap.put("category_id", category.getCategory_id());//三级分类
				returnMap.put("child_id", child_id);//二级分类
				requestMap.put("category_id", child_id);
				Category childCategory = categoryService.queryCategory(requestMap);
				if(null != childCategory){
					requestMap.clear();
					requestMap.put("parent_id", child_id);
					requestMap.put("status", 1);
					List categoryList = categoryService.queryCategoryList(requestMap);
					returnMap.put("categoryList", categoryList);//三级分类集合
					requestMap.put("parent_id", childCategory.getParent_id());
					List childCategoryList = categoryService.queryCategoryList(requestMap);
					returnMap.put("parent_id", childCategory.getParent_id());//一级分类
					returnMap.put("childCategoryList", childCategoryList);	//二级分类集合
				}
			}
		}
		
		//查询关联一级分类
		requestMap.clear();
		requestMap.put("rank", 1);
		requestMap.put("status", 1);
		List parentCategoryList = categoryService.queryCategoryList(requestMap);
		returnMap.put("parentCategoryList", parentCategoryList);
		//根据分类找到属性
		requestMap.clear();
		requestMap.put("category_id", goodsInfo.get("Category_id"));
		List attributeList = attributeRelationService.queryAttributeList(requestMap);
		returnMap.put("attributeList", attributeList);
		
		//查询商品的的属性值
		requestMap.clear();
		requestMap.put("goods_id", goodsId);
		List<Map> goodsAttrList =goodsSkuRelationService.getGoodsAttrList(requestMap);
		returnMap.put("goodsAttrSize", goodsAttrList.size());
		
		//返回的list
		List<Map<String, Object>> goodsAttrLists = new ArrayList<Map<String, Object>>();
		if (goodsAttrList != null && goodsAttrList.size() != 0 ) {
			for (Map goodsAttrMap : goodsAttrList) {
				//查询属性对应的所有属性值
				Map attrMap = new HashMap();
				attrMap.put("attr_id", goodsAttrMap.get("attr_id"));
				List valueList = attributeRelationService.queryAttributeValueList(attrMap);
				goodsAttrMap.put("valueList", valueList);
				
				//找到商品选择的属性
				Map valueMap = new HashMap();
				valueMap.put("attr_id", goodsAttrMap.get("attr_id"));
				valueMap.put("goods_id", goodsId);
				List myvalueList = goodsSkuRelationService.getAttrValueList(valueMap);
				goodsAttrMap.put("myvalueList", myvalueList);
				goodsAttrLists.add(goodsAttrMap);
			}
		}
		returnMap.put("goodsAttrLists", goodsAttrLists);
		
		//查询商品的管理商品
		requestMap.clear();
		requestMap.put("goods_id", goodsId);
		List<Map> recommendGoodsList =recommendGoodsService.getRecommendGoodsListById(requestMap);
		returnMap.put("recommendGoodsList", recommendGoodsList);
		
		//查询sku商品
		List<Map<String, Object>> goodsSkuList=goodsSkuService.qyById(Integer.valueOf(goodsId));
		List<Map<String, Object>> goodsSkuLists = new ArrayList<Map<String, Object>>();
		if (goodsSkuList != null && goodsSkuList.size() != 0 ) {
			for (Map goodsSkuMap : goodsSkuList) {
				Map skuMap = new HashMap();
				skuMap.put("sku_id", goodsSkuMap.get("sku_id"));
				List skuValueList = goodsSkuRelationService.getSkuValueList(skuMap);
				goodsSkuMap.put("skuValueList", skuValueList);
				goodsSkuLists.add(goodsSkuMap);
			}
		}
		
		//根据sku商品查询商品属性
		returnMap.put("goodsSkuLists", goodsSkuLists);
		return new ModelAndView("goodsInfo/updateGoodsInfo.jsp", "map", returnMap);
	}
	/**
	 * 修改商品
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/updateGoods.do")
	@ResponseBody
	public void updateGoods(HttpSession session,HttpServletRequest request,HttpServletResponse response,GoodsInfoWithBLOBs goodsInfo) throws IOException {
		WorkerInfo worker = (WorkerInfo) session.getAttribute("workerInfo");
		try {
			goodsInfo.setUpdateDate(new Date());
			goodsInfo.setCreateUserId(worker.getWorker_id());
//			goodsInfo.setStatus(1);
			goodsInfo.setGoodsCode(CommonsUtil.getPrimaryKey());
			goodsInfo.setSaleCount(0);
			goodsInfo.setDescription(goodsInfo.getAdWords());;
			
			
			
			//保存商品图片
			 List<GoodsPic> goodsPics =goodsInfo.getGoodsPics();

			 for (int i = 0; i < goodsPics.size(); i++) {
	            if (CommonsUtil.isEmpty(goodsPics.get(i).getPicUrl())) {
	            	goodsPics.remove(i);
	                i--;
	            }
			 }
			 
			 if (null != goodsPics && goodsPics.size() > 0 ) {
				 
				 if (CommonsUtil.isNotEmpty(goodsPics.get(0).getPicUrl()+"")) {
//					 String stringurl=
					 goodsInfo.setGoodsPic(goodsPics.get(0).getPicUrl()+"");
					 if (CommonsUtil.isNotEmpty(goodsInfo.getGoodsId()+"")) {
						 goodsInfoService.updateGoodsInfo(goodsInfo);
						 goodsPicService.deleteGoodsPicByGoodsId(goodsInfo.getGoodsId());
					}else {
						response(response,"-1", "商品不存在！");
						return;
					}
				}
				 
				for (GoodsPic goodsPic : goodsPics) {
					if (CommonsUtil.isEmpty(goodsPic.getPicUrl()+"")) {
						continue;
					}
					goodsPic.setGoodsId(goodsInfo.getGoodsId());
					goodsPic.setCreateDate(new Date());
					goodsPic.setUpdateDate(new Date());
			 		goodsPicService.insertGoodsPic(goodsPic);
				}
			 }
			 response(response,"OK", "操作成功！");
//			 System.out.println(response.);
		} catch (Exception e) {
			e.printStackTrace();
			response(response, "-1", "操作失败！");
		}
			
	}
	@RequestMapping("/toupdateGoods.do")
	public ModelAndView  toupdateGoods(HttpSession session,@RequestParam String goods_id,@RequestParam String url) throws IOException {
		WorkerInfo worker = (WorkerInfo) session.getAttribute("workerInfo");
		Map<String, Object> requestMap=new HashMap<String, Object>();
		Map<String, Object> returnMap=new HashMap<String, Object>();
		try {
			String urlString=url+"";
			if (CommonsUtil.isEmpty(goods_id)) {
				return new ModelAndView();
			}
			
			requestMap.clear();
			requestMap.put("rank", 1);
			requestMap.put("status", 1);
			List categoryList = categoryService.queryCategoryList(requestMap);
			returnMap.put("categoryList", categoryList);
			List<GoodsLabel> goodsLabels=goodsLabelServise.selectByMap(new HashMap());
			returnMap.put("goodsLabels", goodsLabels);
			
			requestMap.clear();
			requestMap.put("goods_id", goods_id);
			List<GoodsPic> goodsPics=goodsPicService.queryPics(requestMap);
			returnMap.put("goodsPics", goodsPics);
			returnMap.put("goodsPicSize", goodsPics.size());
			
			
			Map goodsInfo = goodsInfoService.qyById(Integer.valueOf(goods_id));
			returnMap.put("goodsInfo", goodsInfo);
			
			return new ModelAndView(urlString,"map",returnMap);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ModelAndView();
		}
	}
	
//	/**
//	 * 修改商品
//	 * 
//	 * @return
//	 * @throws IOException
//	 */
//	@RequestMapping("/updateGoods.do")
//	public String  updateGoods(HttpSession session,HttpServletRequest request,HttpServletResponse response,GoodsInfo goodsInfo,String recgGoodsIds,GoodsRelation goodsRelation) throws IOException {
//		WorkerInfo worker = (WorkerInfo) session.getAttribute("workerInfo");
//		
//		goodsInfo.setUpdateDate(new Date());
//		goodsInfo.setStatus(1);
//		//修改商品
//	 	goodsInfoService.updateGoodsInfo(goodsInfo);
//	 	
//	 	//删除商品分类
//	 	goodsRelationService.deleteGoodsRelationByGoodsId(goodsInfo.getGoodsId());
//		//保存商品分类
//		goodsRelation.setCreateDate(new Date());
//		goodsRelation.setUpdateDate(new Date());
//		goodsRelation.setGoodsId(goodsInfo.getGoodsId());
//	 	goodsRelationService.insertGoodsRelation(goodsRelation);
//		
//	 	//根据goodsId删除推荐商品
//	 	recommendGoodsService.deleteRecommendGoodsByGoodsId(goodsInfo.getGoodsId());
//		//保存推荐商品
//		if (CommonsUtil.isNotEmpty(recgGoodsIds)) {
//			String[] recgIds = recgGoodsIds.split(",");
//			RecommendGoods recommendGoods = new RecommendGoods();
//			for (int i = 0; i < recgIds.length; i++) {
//				recommendGoods.setRecommendGoodsId(Integer.parseInt(recgIds[i]));
//				recommendGoods.setGoodsId(goodsInfo.getGoodsId());
//				recommendGoods.setCreateDate(new Date());
//		 		recommendGoodsService.insertGoodsRelation(recommendGoods);
//			}
//		}
//		
//		//根据goodsId删除sku商品
//		goodsSkuService.deleteGoodsSkuByGoodsId(goodsInfo.getGoodsId());
//		//根据goodsId删除sku关系
//		goodsSkuRelationService.deleteGoodsSkuRelationByGoodsId(goodsInfo.getGoodsId());
//		//保存sku商品
//		 List<GoodsSku> goodsSkus =goodsInfo.getGoodsSkus();
//		 if (null != goodsSkus && goodsSkus.size() > 0 ) {
//			for (GoodsSku goodsSku : goodsSkus) {
//				goodsSku.setGoodsId(goodsInfo.getGoodsId());
//				goodsSku.setCreateDate(new Date());
//				goodsSku.setUpdateDate(new Date());
////				goodsSku.setCreateUserId(worker.getWorker_id());
//		 		goodsSkuService.insertGoodsSkuInfo(goodsSku);
//				//保存sku关系
//				GoodsSkuRelation goodsSkuRelation =new GoodsSkuRelation();
//				goodsSkuRelation.setCreateDate(new Date());
//				goodsSkuRelation.setUpdateDate(new Date());
//				goodsSkuRelation.setGoodsId(goodsInfo.getGoodsId());
//				goodsSkuRelation.setSkuId(goodsSku.getSkuId());
//				
////				String relationIds =goodsSku.getRelationId();
////				String[] relIds = relationIds.split(",");
////				for (int a = 0; a < relIds.length; a++) {
////					goodsSkuRelation.setRelationId(Integer.parseInt(relIds[a]));
////			 	 	goodsSkuRelationService.insertGoodsRelationSkuInfo(goodsSkuRelation);
////				}
//				
//			}
//		 }
//		
//		//根据goodsId删除商品图片
//		 goodsPicService.deleteGoodsPicByGoodsId(goodsInfo.getGoodsId());
//		//保存商品图片
//		 List<GoodsPic> goodsPics =goodsInfo.getGoodsPics();
//		 if (null != goodsPics && goodsPics.size() > 0 ) {
//			for (GoodsPic goodsPic : goodsPics) {
//				goodsPic.setGoodsId(goodsInfo.getGoodsId());
//				goodsPic.setCreateDate(new Date());
//				goodsPic.setUpdateDate(new Date());
//		 		goodsPicService.insertGoodsPic(goodsPic);
//			}
//		 }
//		 return "redirect:selectGoodsInfoList.do";
//
//	}
	
	
	/**
	 * 删除商品
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/deleteGoods.do")
	public String  deleteGoods(HttpSession session,HttpServletRequest request,HttpServletResponse response,String goodsId) throws IOException {
	  
		//删除商品
	 	goodsInfoService.deleteGoods(Integer.valueOf(goodsId));
	 	//删除商品分类
	 	goodsRelationService.deleteGoodsRelationByGoodsId(Integer.valueOf(goodsId));
	 	//根据goodsId删除推荐商品
	 	recommendGoodsService.deleteRecommendGoodsByGoodsId(Integer.valueOf(goodsId));
		//根据goodsId删除sku商品
		goodsSkuService.deleteGoodsSkuByGoodsId(Integer.valueOf(goodsId));
		//根据goodsId删除sku关系
		goodsSkuRelationService.deleteGoodsSkuRelationByGoodsId(Integer.valueOf(goodsId));
		//根据goodsId删除商品图片
		 goodsPicService.deleteGoodsPicByGoodsId(Integer.valueOf(goodsId));
		 
	     return "redirect:selectGoodsInfoList.do";

	}
	
	/**
	 * 商品上下架
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/updateGoodsStatus.do")
	public void  updateGoodsStatus(HttpSession session,HttpServletRequest request,HttpServletResponse response,String goodsId,String status) throws IOException {
		try {
			if (CommonsUtil.isEmpty(goodsId)) {
				return;
			}
			if (CommonsUtil.isEmpty(status)) {
				return;
			}
			GoodsInfo goodsInfo =goodsInfoService.selectByPrimaryKey(Integer.parseInt(goodsId));
			goodsInfo.setGoodsId(Integer.valueOf(goodsId));
			goodsInfo.setStatus(Integer.valueOf(status));
			//修改商品
			int count =goodsInfoService.updateGoodsInfo(goodsInfo);
			if (count > 0) {
				response(response, "OK", "操作成功！");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/**
	 * 查询分类是否有扩展信息
	 *(ZHZ)2017-3-30
	 * @return
	 */
	@RequestMapping("/querySkuGoodsByAttrId.do")
	public void querySkuGoodsByAttrId(HttpServletResponse response,String attrId){
		try {
				List <Map> extendInfoes = goodsSkuRelationService.querySkuGoodsByAttrId(attrId);
				//分类有扩展属性，不能删除
				if(extendInfoes.size() >0){
					response.getWriter().write("no");
				}else{
					//分类没有扩展属性，可以删除
					response.getWriter().write("ok");
				}
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	/**
	 * wxt选择商品
	 */
	@RequestMapping("/chooseGoods.do")
	public ModelAndView chooseGoods(PageInfo<Map> pageInfo,GoodsInfo goodsInfo){
		//返回结果Map
		Map<String,Object> returnMap = new HashMap<String,Object>();
		if(pageInfo == null || pageInfo.getCurrentPage() == 0){
			pageInfo = new PageInfo<Map>();
			pageInfo.setCurrentPage("1"); 
		}
		Map map = new HashMap();
		
		String goodsName = goodsInfo.getGoodsName();
		if(CommonsUtil.isNotEmpty(goodsName)){
			returnMap.put("goodsName", goodsName);
			map.put("goodsName", goodsName);
		}
		String goodsCode = goodsInfo.getGoodsCode();
		if(CommonsUtil.isNotEmpty(goodsCode)){
			returnMap.put("goodsCode", goodsCode);
			map.put("goodsCode", goodsCode);
		}
	 	pageInfo = goodsInfoService.queryGoodsListByPage(pageInfo, map);
		returnMap.put("pageInfo", pageInfo);
		return new ModelAndView("pteamBuy/chooseGoods.jsp","map",returnMap);
	}
 
}
