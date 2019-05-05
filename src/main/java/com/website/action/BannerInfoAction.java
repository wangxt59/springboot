package com.website.action;

import java.util.Date;
import java.util.HashMap;
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
import com.website.bean.BannerInfo;
import com.website.bean.PageInfo;
import com.website.service.IBannerInfoService;
 
 
/**  
 * 描述: 
 * @Company: 博众援创 
 * @author shengtaihua 
 * @date  2018-6-5 
*/  
@Controller
@RequestMapping("/banner/")
public class BannerInfoAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	protected Logger log = Logger.getLogger(BannerInfoAction.class);
	
	@Autowired
	private IBannerInfoService bannerInfoService;
 
	
 
	@RequestMapping("queryBannerList.do")
	public ModelAndView queryBannerList(PageInfo pageInfo, HttpSession session,
			@RequestParam(value = "isDisplay", required = false) String isDisplay) {
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
			if (isDisplay != null && !"".equals(isDisplay.trim())) {
				map.put("isDisplay", isDisplay);
				returnMap.put("isDisplay", isDisplay);
			}
			 
			map.put("isDelete", "0");
			pageInfo = bannerInfoService.queryBannerListByPages(pageInfo, map);
			returnMap.put("pageInfo", pageInfo);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("查询商圈列表异常", e);
		}
		return new ModelAndView("banner/bannerList.jsp", "map", returnMap);
	}

 
	@RequestMapping("gotoAddBanner.do")
	public ModelAndView gotoAddBanner() {
		return new ModelAndView("banner/addBanner.jsp", "map", "");
	}
	
	 
	@RequestMapping("addBanner.do")
	public String addBanner(BannerInfo bannerInfo,  HttpSession session) {
		// 获取商户id
		try {
			WorkerInfo worker = (WorkerInfo) session.getAttribute("workerInfo");
			String operator = worker.getWorker_name();
			bannerInfo.setCreateUser(operator);
			bannerInfo.setCreateDate(new Date());
			bannerInfo.setIsDelete(1);
			log.info("************添加信息************" + bannerInfo.toString());
			bannerInfoService.addBannerInfo(bannerInfo);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("添加banner失败!");
		}

		return "redirect:queryBannerList.do";
	}
	
 
 
	@RequestMapping("deleteBanner.do")
	public void deleteBusinessCircle(BannerInfo bannerInfo, HttpServletResponse response){
			bannerInfo.setIsDelete(0);
			bannerInfo.setIsDisplay(0);
			bannerInfo.setUpdateDate(new Date());
			int count = bannerInfoService.updateBannerInfo(bannerInfo);
			if (count > 0) {
				response(response, "OK", "操作成功！");
			}
 
	}
	
	@RequestMapping("gotoUpdateBanner.do")
	public ModelAndView gotoUpdateBanner(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		BannerInfo info = bannerInfoService.qyById(map);
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("info", info);
		return new ModelAndView("banner/updateBanner.jsp", "map", returnMap);
	}
	
	
	@RequestMapping("updateBanner.do")
	public String updateBanner(BannerInfo bannerInfo) {
		bannerInfo.setUpdateDate(new Date());
		bannerInfoService.updateBannerInfo(bannerInfo);
		return "redirect:queryBannerList.do";
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
		BannerInfo info  = bannerInfoService.qyById(map);
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("info", info);
		return new ModelAndView("banner/showBanner.jsp", "map", returnMap);
	}
	
	//显示不显示
	@RequestMapping("showBanner.do")
	public void showBanner(BannerInfo bannerInfo, HttpServletResponse response){
			bannerInfo.setUpdateDate(new Date());
			int count = bannerInfoService.updateBannerInfo(bannerInfo);
			if (count > 0) {
				response(response, "OK", "操作成功！");
			}
 
	}
	
}
