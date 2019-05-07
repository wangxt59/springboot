/**
 * 
 */
package com.website.action;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.website.bean.AccountInfo;
import com.website.bean.PageInfo;
import com.website.bean.UserInfo;
import com.website.service.IAccountInfoService;
import com.website.service.IUserInfoService;

import net.sf.json.JSONArray;

/**  
 * 描述: 
 * @Company: 博众援创 
 * @author shengtaihua 
 * @date  2018-10-11 
 */
@Controller
@RequestMapping("/userInfo")
public class UserInfoAction extends BaseAction{
 
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(UserInfoAction.class);
	
	@Autowired
	private IUserInfoService userInfoService;
	
	@Autowired
	private IAccountInfoService accountInfoService;
	
		@RequestMapping("/queryUserInfoList.do")
		public ModelAndView queryUserInfoList(PageInfo pageInfo, HttpSession session,
				@RequestParam(value = "id", required = false) String id,
				@RequestParam(value = "real_name", required = false) String real_name,
				@RequestParam(value = "contact", required = false) String contact,
				@RequestParam(value = "direct_name", required = false) String direct_name,
				@RequestParam(value = "indirect_name", required = false) String indirect_name) {
			WorkerInfo worker = (WorkerInfo) session.getAttribute("workerInfo");
			if (worker == null) {
				return new ModelAndView("redirect:/login/workLogin.do");
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
				if (real_name != null && !"".equals(real_name.trim())) {
					map.put("real_name", real_name);
					returnMap.put("real_name", real_name);
				}
				if (contact != null && !"".equals(contact.trim())) {
					map.put("contact", contact);
					returnMap.put("contact", contact);
				}
				
				if (indirect_name != null && !"".equals(indirect_name.trim())) {
					map.put("indirect_name", indirect_name);
					returnMap.put("indirect_name", indirect_name);
				}
				if (direct_name != null && !"".equals(direct_name.trim())) {
					map.put("direct_name", direct_name);
					returnMap.put("direct_name", direct_name);
				}
				
				pageInfo = userInfoService.queryUserInfoListByPages(pageInfo, map);
				List datas = pageInfo.getDatas();
				if(datas==null || datas.size()==0){
					pageInfo = userInfoService.queryUserInfoList(pageInfo, map);
				}
				returnMap.put("pageInfo", pageInfo);
			} catch (Exception e) {
				e.printStackTrace();
				log.error("查询订单列表异常", e);
			}
			return new ModelAndView("userInfo/userInfoList.jsp", "map", returnMap);
		}
		
		@RequestMapping("/queryTeamerInfoList.do")
		public ModelAndView queryTeamerInfoList(PageInfo pageInfo, HttpSession session,
				@RequestParam(value = "id", required = false) String id,
				@RequestParam(value = "real_name", required = false) String real_name,
				@RequestParam(value = "contact", required = false) String contact,
				@RequestParam(value = "direct_name", required = false) String direct_name,
				@RequestParam(value = "indirect_name", required = false) String indirect_name) {
			WorkerInfo worker = (WorkerInfo) session.getAttribute("workerInfo");
			if (worker == null) {
				return new ModelAndView("redirect:/login/workLogin.do");
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
				if (real_name != null && !"".equals(real_name.trim())) {
					map.put("real_name", real_name);
					returnMap.put("real_name", real_name);
				}
				if (contact != null && !"".equals(contact.trim())) {
					map.put("contact", contact);
					returnMap.put("contact", contact);
				}
				
				if (indirect_name != null && !"".equals(indirect_name.trim())) {
					map.put("indirect_name", indirect_name);
					returnMap.put("indirect_name", indirect_name);
				}
				if (direct_name != null && !"".equals(direct_name.trim())) {
					map.put("direct_name", direct_name);
					returnMap.put("direct_name", direct_name);
				}
				map.put("role", 1);
				pageInfo = userInfoService.queryUserInfoListByPages(pageInfo, map);
				List datas = pageInfo.getDatas();
				if(datas==null || datas.size()==0){
					pageInfo = userInfoService.queryUserInfoList(pageInfo, map);
				}
				returnMap.put("pageInfo", pageInfo);
			} catch (Exception e) {
				e.printStackTrace();
				log.error("查询订单列表异常", e);
			}
			return new ModelAndView("userInfo/teamerInfoList.jsp", "map", returnMap);
		}
		
		@RequestMapping("/updateUserStatus.do")
		public void  updateUserStatus(HttpSession session,HttpServletRequest request,HttpServletResponse response,String id,String status) throws IOException {
			UserInfo userInfo =new UserInfo();
			userInfo.setId(Integer.valueOf(id));
			userInfo.setStatus(Integer.valueOf(status));
			//修改商品
			int count =userInfoService.updateUserInfo(userInfo);
			if (count > 0) {
				response(response, "OK", "操作成功！");
			}
		}
		
	
		/**
		 * 查询用户账户信息
		 * @return
		 */
		@RequestMapping("/queryAccountInfo.do")
		public ModelAndView queryAccountInfo(Model model,
				@RequestParam("user_id")String user_id){
			//返回结果Map
			Map<String,Object> returnMap = new HashMap<String,Object>();
			
			AccountInfo accountInfo = accountInfoService.getAccountInfoByUserId(user_id);
			returnMap.put("accountInfo", accountInfo);
			return new ModelAndView("userInfo/accountInfo.jsp","map",returnMap);
		}
		
		/**
		 * 获取分类相关父类信息
		 */
		@RequestMapping("/queryUserInfo.do")
		public void queryUserInfo(HttpServletResponse response,@RequestParam("contact")String contact){
			PrintWriter out = null;
			try {
				Map resultMap = new HashMap();
				Map reqMap = new HashMap();
				reqMap.put("contact", contact);
				UserInfo userInfo = userInfoService.queryUserInfo(reqMap);
				if(userInfo!=null){
					String userId = ""+userInfo.getId();
					AccountInfo accountInfo = accountInfoService.getAccountInfoByUserId(userId);
					resultMap.put("result_code", "0");
					resultMap.put("accountId", accountInfo.getAccountId());
//					resultMap.put("coinBalance", accountInfo.getCoinBalance());
//					resultMap.put("salableQuota", accountInfo.getSalableQuota());
				}else{
					resultMap.put("result_code", "-1");
				}
				
				response.setContentType("text/html;charset=UTF-8");
				out = response.getWriter();
				JSONArray jsonArray = JSONArray.fromObject(resultMap);
				out.write(jsonArray.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				if(out != null){
					out.flush();
					out.close();
				}
			}
		}

}
