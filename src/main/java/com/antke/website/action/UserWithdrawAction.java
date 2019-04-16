/**
 * 
 */
package com.antke.website.action;

import java.util.Date;
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

import com.antke.power.model.bean.WorkerInfo;
import com.antke.website.model.bean.PageInfo;
import com.antke.website.model.bean.UserWithdraw;
import com.antke.website.service.IUserWithdrawService;
import com.antke.website.utils.CommonsUtil;

/**
 * 描述:
 * 
 * @Company: 博众援创
 * @author shengtaihua
 * @date 2018-10-11
 */
@Controller
@RequestMapping("/userWithdraw")
public class UserWithdrawAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(UserWithdrawAction.class);

	@Autowired
	private IUserWithdrawService userWithdrawService;

	@RequestMapping("/queryWithdrawList.do")
	public ModelAndView queryWithdrawList(PageInfo pageInfo,HttpSession session,
			@RequestParam(value = "contact", required = false) String contact,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "status", required = false) String status,
			@RequestParam(value = "trade_no", required = false) String trade_no) {
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
				pageInfo = new PageInfo<List>();
				pageInfo.setCurrentPage("1");
			}

			if (CommonsUtil.isNotEmpty(contact)) {
				map.put("contact", contact);
				returnMap.put("contact", contact);
			}
			if (CommonsUtil.isNotEmpty(status)) {
				map.put("status", status);
				returnMap.put("status", status);
			}
			if (CommonsUtil.isNotEmpty(name)) {
				map.put("name", name);
				returnMap.put("name", name);
			}
			if (CommonsUtil.isNotEmpty(trade_no)) {
				map.put("trade_no", trade_no);
				returnMap.put("trade_no", trade_no);
			}
			pageInfo = userWithdrawService.queryWithdrawListByPages(pageInfo,map);
			returnMap.put("pageInfo", pageInfo);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("查询订单列表异常", e);
		}
		return new ModelAndView("userWithdraw/userWithdrawList.jsp", "map",
				returnMap);
	}

	@RequestMapping("gotoUpdateWithdraw.do")
	public ModelAndView gotoUpdateWithdraw(String withdrawId) {
		UserWithdraw info = userWithdrawService.getWithdrawById(Integer.valueOf(withdrawId));
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("info", info);
		return new ModelAndView("userWithdraw/updateWithdraw.jsp", "map",returnMap);
	}

	@RequestMapping("updateWithdraw.do")
	public String updateWithdraw(UserWithdraw userWithdraw) {
		userWithdraw.setUpdateDate(new Date());
		userWithdrawService.updateWithdraw(userWithdraw);
		return "redirect:queryWithdrawList.do";
	}

}
