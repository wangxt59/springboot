/**
 *Copyright (C) 2009-2013 Beijing antke electronic commerce Co., LTD.All Rights Reserved.
 *
 *FileName：BaseAction.java
 *
 *Description: TODO
 *
 *History：
 *  版本号   		作者    		日期    		 简要介绍相关操作
 *  1.0       bizf          June 27, 2014           TODO
 */
package com.antke.website.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.stereotype.Controller;

import com.antke.power.model.bean.WorkerInfo;
//import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author bizf 
 *
 */
@Controller
public class BaseAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware {

	private static final long serialVersionUID = 1L;

	protected HttpServletRequest request;

	protected HttpServletResponse response;

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletResponse(HttpServletResponse resoponse) {
		this.response = resoponse;
	}

	protected void response(HttpServletResponse response, String code,
			String msg) {
		JSONObject json = new JSONObject();
		json.put("code", code);
		json.put("msg", msg);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.write(json.toString());
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected WorkerInfo getWorkerInfo() {
		WorkerInfo workerInfo = (WorkerInfo) request.getSession().getAttribute(
				"workerInfo");// 登录信息表
		return workerInfo;
	}
}
