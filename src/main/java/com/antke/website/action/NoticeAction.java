package com.antke.website.action;

import java.io.IOException;
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
import com.antke.website.model.bean.Notice;
import com.antke.website.model.bean.PageInfo;
import com.antke.website.model.bean.UserInfo;
import com.antke.website.service.IChannelService;
import com.antke.website.service.ILanguageService;
import com.antke.website.service.INoticeService;
 
 
/**  
 * 描述: 
 * @Company: 博众援创 
 * @author shengtaihua 
 * @date  2018-6-5 
*/  
@Controller
@RequestMapping("/notice/")
public class NoticeAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	protected Logger log = Logger.getLogger(NoticeAction.class);
	
	@Autowired
	private INoticeService noticeService;
	@Autowired
	private ILanguageService languageService;
	@Autowired
	private IChannelService channelService;
 
 
	@RequestMapping("queryNoticeList.do")
	public ModelAndView queryNoticeList(PageInfo pageInfo, HttpSession session,
			@RequestParam(value = "status", required = false) String status) {
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
				pageInfo = new PageInfo<Notice>();
				pageInfo.setCurrentPage("1");
			}
			// 区域的查询条件
			if (status != null && !"".equals(status.trim())) {
				map.put("status", status);
				returnMap.put("status", status);
			}
			pageInfo = noticeService.queryNoticeListByPages(pageInfo, map);
			returnMap.put("pageInfo", pageInfo);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("查询公告列表异常", e);
		}
		return new ModelAndView("notice/noticeList.jsp", "map", returnMap);
	}

 
	@RequestMapping("gotoAddNotice.do")
	public ModelAndView gotoAddNotice() {
		//查询map
//		Map<String,Object> requestMap = new HashMap<String,Object>();
//		//返回结果Map
		Map<String,Object> returnMap = new HashMap<String,Object>();
//		requestMap.clear();
//		requestMap.put("status", 1);
//		List languageList=languageService.queryLanguageList(requestMap);
//		List channelList= channelService.queryChannelList(requestMap);
//		returnMap.put("languageList", languageList);
//		returnMap.put("channelList", channelList);
		
		return new ModelAndView("notice/addNotice.jsp", "map", returnMap);
	}
	
	 
	@RequestMapping("addNotice.do")
	public String addNotice(Notice notice,  HttpSession session) {
		// 获取商户id
		try {
			WorkerInfo worker = (WorkerInfo) session.getAttribute("workerInfo");
			String operator = worker.getWorker_name();
			notice.setCreateUserId(operator);
			notice.setCreateDate(new Date());
			notice.setUpdateDate(new Date());
			log.info("************添加信息************" + notice.toString());
			noticeService.addNotice(notice);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("添加公告失败!");
		}

		return "redirect:queryNoticeList.do";
	}
	
 
	
	@RequestMapping("gotoUpdateNotice.do")
	public ModelAndView gotoUpdateNotice(String id) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String,Object> requestMap = new HashMap<String,Object>();
//		requestMap.clear();
//		requestMap.put("status", 1);
//		List languageList=languageService.queryLanguageList(requestMap);
//		List channelList= channelService.queryChannelList(requestMap);
//		returnMap.put("languageList", languageList);
//		returnMap.put("channelList", channelList);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		Notice info = noticeService.qyById(map);
		
		returnMap.put("info", info);
		return new ModelAndView("notice/updateNotice.jsp", "map", returnMap);
	}
	
	
	@RequestMapping("updateNotice.do")
	public String updateNotice(Notice notice) {
		notice.setUpdateDate(new Date());
		noticeService.updateNotice(notice);
		return "redirect:queryNoticeList.do";
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
		Notice info  = noticeService.qyById(map);
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("info", info);
		return new ModelAndView("notice/showNotice.jsp", "map", returnMap);
	}
	
	//显示不显示
	@RequestMapping("updateNoticeStatus.do")
	public void updateNoticeStatus(String id,String status, HttpServletResponse response){
	    	Notice notice =new Notice();
	    	notice.setId(Integer.valueOf(id));
	    	notice.setStatus(Integer.valueOf(status));
			notice.setUpdateDate(new Date());
			int count = noticeService.updateNotice(notice);
			if (count > 0) {
				response(response, "OK", "操作成功！");
			}
 
	}

 
	
}
