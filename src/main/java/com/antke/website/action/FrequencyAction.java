package com.antke.website.action;

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

import com.antke.power.model.bean.WorkerInfo;
import com.antke.website.model.bean.BannerInfo;
import com.antke.website.model.bean.Frequency;
import com.antke.website.model.bean.FrequencyCategoryRelation;
import com.antke.website.model.bean.FrequencyGoodsRelation;
import com.antke.website.model.bean.PageInfo;
import com.antke.website.service.IFrequencyCategoryRelationService;
import com.antke.website.service.IFrequencyGoodsRelationService;
import com.antke.website.service.IFrequencyService;
import com.antke.website.utils.CommonsUtil;
 
 
/**  
 * 描述: 
 * @Company: 博众援创 
 * @author shengtaihua 
 * @date  2018-6-5 
*/  
@Controller
@RequestMapping("/frequency/")
public class FrequencyAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	protected Logger log = Logger.getLogger(FrequencyAction.class);
	
	@Autowired
	private IFrequencyService frequencyService;
	@Autowired
	private IFrequencyCategoryRelationService frequencyCategoryRelationService;
	@Autowired
	private IFrequencyGoodsRelationService frequencyGoodsRelationService;
	
	
 
	@RequestMapping("queryFrequencyList.do")
	public ModelAndView queryFrequencyList(PageInfo pageInfo, HttpSession session,
			@RequestParam(value = "name", required = false) String name) {
		WorkerInfo worker = (WorkerInfo) session.getAttribute("workerInfo");
 
		if (worker == null) {
			return new ModelAndView("redirect:/login/workLogin.action");
		}
		// 定义返回值Map
		Map<String, Object> returnMap = new HashMap<String, Object>();
		// 定义回显Map
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 如果是初次访问或新的查询时，重置分页
			if (pageInfo == null || pageInfo.getCurrentPage() == 0) {
				pageInfo = new PageInfo<BannerInfo>();
				pageInfo.setCurrentPage("1");
			}
			// 区域的查询条件
			if (name != null && !"".equals(name.trim())) {
				map.put("name", name);
				returnMap.put("name", name);
			}
			pageInfo = frequencyService.queryFrequencyListByPages(pageInfo, map);
			returnMap.put("pageInfo", pageInfo);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("查询频道列表异常", e);
		}
		return new ModelAndView("frequency/frequencyList.jsp", "map", returnMap);
	}

 
	@RequestMapping("gotoAddFrequency.do")
	public ModelAndView gotoAddFrequency() {
		return new ModelAndView("frequency/addFrequency.jsp", "map", "");
	}
	
	 
	@RequestMapping("addFrequency.do")
	public String addFrequency(Frequency frequency,  HttpSession session) {
		// 获取商户id
		try {
			WorkerInfo worker = (WorkerInfo) session.getAttribute("workerInfo");
			String operator = worker.getWorker_name();
			frequency.setCreateUserId(operator);
			frequency.setCreateDate(new Date());
			frequency.setStatus(1);
			log.info("************添加信息************" + frequency.toString());
			frequencyService.addFrequency(frequency);
			
			if(frequency.getRelationType()==2){
				String recgCategoryIds =frequency.getRecgCategoryIds();
				//保存
				if (CommonsUtil.isNotEmpty(recgCategoryIds)) {
					String[] recgIds = recgCategoryIds.split(",");
					FrequencyCategoryRelation frequencyCategoryRelation =new FrequencyCategoryRelation();
					for (int i = 0; i < recgIds.length; i++) {
				 		frequencyCategoryRelation.setFrequencyId(frequency.getId());
						frequencyCategoryRelation.setCreateDate(new Date());
						frequencyCategoryRelation.setCategoryId(Integer.parseInt(recgIds[i]));
						frequencyCategoryRelationService.addFrequencyCategoryRelation(frequencyCategoryRelation);
					}
				}
				
			}else{
				String recgGoodsIds =frequency.getRecgGoodsIds();
				//保存
				if (CommonsUtil.isNotEmpty(recgGoodsIds)) {
					String[] goodIds = recgGoodsIds.split(",");
					FrequencyGoodsRelation frequencyGoodsRelation =new FrequencyGoodsRelation();
					for (int i = 0; i < goodIds.length; i++) {
						frequencyGoodsRelation.setFrequencyId(frequency.getId());
						frequencyGoodsRelation.setCreateDate(new Date());
						frequencyGoodsRelation.setGoodsId(Integer.parseInt(goodIds[i]));
						frequencyGoodsRelationService.addFrequencyGoodsRelation(frequencyGoodsRelation);
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("添加频道失败!");
		}

		return "redirect:queryFrequencyList.do";
	}
	
 
 
	@RequestMapping("deleteFrequency.do")
	public void deleteFrequency(Frequency frequency, HttpServletResponse response){
			frequency.setIsHomeShow(0);
			frequency.setStatus(0);
			frequency.setUpdateDate(new Date());
			int count = frequencyService.updateFrequency(frequency);
			if (count > 0) {
				response(response, "OK", "操作成功！");
			}
 
	}
	
	@RequestMapping("gotoUpdateFrequency.do")
	public ModelAndView gotoUpdateFrequency(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		Frequency info = frequencyService.qyById(map);
		if(info.getRelationType()==1){
			Frequency goodsInfo  = frequencyService.qyByGoodsId(map);
			info.setRecgGoodsIds(goodsInfo.getRecgGoodsIds());
		}else if(info.getRelationType()==2){
			Frequency categoryInfo  = frequencyService.qyByCategoryId(map);
			info.setRecgCategoryIds(categoryInfo.getRecgCategoryIds());
		}
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		map.clear();
		map.put("frequency_id", id);
		List<Map> frequencyCategoryRelationList =frequencyCategoryRelationService.getFrequencyCategoryRelationListById(map);
		returnMap.put("frequencyCategoryRelationList", frequencyCategoryRelationList);
		List<Map> frequencyGoodsRelationList =frequencyGoodsRelationService.getFrequencyGoodsRelationListById(map);
		returnMap.put("frequencyGoodsRelationList", frequencyGoodsRelationList);
				
		returnMap.put("info", info);
		return new ModelAndView("frequency/updateFrequency.jsp", "map", returnMap);
	}
	
	
	@RequestMapping("updateFrequency.do")
	public String updateFrequency(Frequency frequency) {
		frequency.setUpdateDate(new Date());
		frequencyService.updateFrequency(frequency);
		//删除
			frequencyCategoryRelationService.deleteFrequencyCategoryRelationById(frequency.getId());
			frequencyGoodsRelationService.deleteFrequencyGoodsRelationById(frequency.getId());
		if(frequency.getRelationType()==2){
			String recgCategoryIds =frequency.getRecgCategoryIds();
			//保存
			if (CommonsUtil.isNotEmpty(recgCategoryIds)) {
				String[] recgIds = recgCategoryIds.split(",");
				FrequencyCategoryRelation frequencyCategoryRelation =new FrequencyCategoryRelation();
				for (int i = 0; i < recgIds.length; i++) {
			 		frequencyCategoryRelation.setFrequencyId(frequency.getId());
					frequencyCategoryRelation.setCreateDate(new Date());
					frequencyCategoryRelation.setCategoryId(Integer.parseInt(recgIds[i]));
					frequencyCategoryRelationService.addFrequencyCategoryRelation(frequencyCategoryRelation);
				}
			}
			
		}else{
			String recgGoodsIds =frequency.getRecgGoodsIds();
			//保存
			if (CommonsUtil.isNotEmpty(recgGoodsIds)) {
				String[] goodIds = recgGoodsIds.split(",");
				FrequencyGoodsRelation frequencyGoodsRelation =new FrequencyGoodsRelation();
				for (int i = 0; i < goodIds.length; i++) {
					frequencyGoodsRelation.setFrequencyId(frequency.getId());
					frequencyGoodsRelation.setCreateDate(new Date());
					frequencyGoodsRelation.setGoodsId(Integer.parseInt(goodIds[i]));
					frequencyGoodsRelationService.addFrequencyGoodsRelation(frequencyGoodsRelation);
				}
			}
		}
		return "redirect:queryFrequencyList.do";
	}

	@RequestMapping("queryById.do")
	public ModelAndView queryById(HttpServletRequest request, String id) throws Exception {
		// 定义回显Map
		Map<String, Object> map = new HashMap<String, Object>();
		WorkerInfo workerInfo = (WorkerInfo) request.getSession().getAttribute("workerInfo");
		if (workerInfo == null) {
			return new ModelAndView("redirect:/login/workLogin.action");
		}
		if (id != null) {
			map.put("id", id);
		}
		Frequency info  = frequencyService.qyById(map);
		if(info.getRelationType()==1){
			Frequency goodsInfo  = frequencyService.qyByGoodsId(map);
			info.setRecgGoodsIds(goodsInfo.getRecgGoodsIds());
		}else if(info.getRelationType()==2){
			Frequency categoryInfo  = frequencyService.qyByCategoryId(map);
			info.setRecgCategoryIds(categoryInfo.getRecgCategoryIds());
		}
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("info", info);
		return new ModelAndView("frequency/showFrequency.jsp", "map", returnMap);
	}
	
	//显示不显示
	@RequestMapping("showFrequency.do")
	public void showBanner(Frequency frequency, HttpServletResponse response){
		   frequency.setUpdateDate(new Date());
			int count = frequencyService.updateFrequency(frequency);
			if (count > 0) {
				response(response, "OK", "操作成功！");
			}
 
	}
	
}
