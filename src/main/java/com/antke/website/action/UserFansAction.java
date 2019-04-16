package com.antke.website.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.antke.website.model.bean.PageInfo;
import com.antke.website.service.IUserFansService;

@Controller
@RequestMapping("/userfans")
public class UserFansAction extends BaseAction{
	
	@Autowired
	IUserFansService userFansService;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(UserFansAction.class);
	/**
	 *  团长粉丝列表
	 * 
	 * @return
	 */
	@RequestMapping("/getUserFans.do")
	public ModelAndView getUserFans(PageInfo pageInfo, HttpSession session,@RequestParam Map<String, Object> param) {
		// 定义返回值Map
		Map<String, Object> returnMap = new HashMap<String, Object>();
		// 定义回显Map
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 如果是初次访问或新的查询时，重置分页
			if (pageInfo == null || pageInfo.getCurrentPage() == 0) {
				pageInfo = new PageInfo<List>();
				pageInfo.setCurrentPage("1");
			}
			pageInfo = userFansService.selectFansList(pageInfo,param);
			returnMap.put("pageInfo", pageInfo);
			returnMap.put("param", param);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("查询订单列表异常", e);
		}
		return new ModelAndView("/userFans/userFansList.jsp", "map", returnMap);
	}

	
}
