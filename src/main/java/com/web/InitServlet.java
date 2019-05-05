package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.power.bean.WorkerInfo;
import com.website.utils.FileUtil;
import com.website.utils.SystemConfig;

@WebServlet(name = "InitServlet", urlPatterns = {"/initServlet"})
public class InitServlet extends HttpServlet implements Filter{
	private static final Logger logger = Logger.getLogger(InitServlet.class);
	public static Map<String, String> exclusiveUrlMap = new HashMap<String, String>();
	/**
	 * Constructor of the object.
	 */
	public InitServlet() {
		super();
		// 登录  
		exclusiveUrlMap.put("/pages/login.jsp", "1");//登录页面
		exclusiveUrlMap.put("//pages/login.jsp", "1");//登录页面
		exclusiveUrlMap.put("/login/workLogin.action", "1");//登录请求
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			logger.info("------------初始化properties配置文件--------------");
			SystemConfig.getInstance().loadConfig();
//			String file = config.getInitParameter("configfile");
			
			String configRootPath = configRootPath = SystemConfig.class.getClassLoader()
						.getResource("").toURI().getPath();
//			FileUtil.setConfigResource(configRootPath+file);
			FileUtil.setConfigResource(configRootPath);
		} catch (Exception e) {
			logger.error("初始化properties文件异常,异常信息:", e);
		}
		logger.info("------------初始化properties配置文件完成--------------");
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		HttpSession session = ((HttpServletRequest) request).getSession();
		// 从session中获取登录用户
		WorkerInfo workerInfo = (WorkerInfo) session.getAttribute("workerInfo");
		String path = request.getServletPath();	
		if(null!=workerInfo&&!"".equals(workerInfo)){
			chain.doFilter(arg0,arg1);
		}else {
			if (exclusiveUrlMap.containsKey(path)) {
			chain.doFilter(arg0,arg1);
			}else {
				response.sendRedirect("/pages/login.jsp");
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
