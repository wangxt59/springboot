package com.boot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.boot.config.DruidConfiguration;
import com.boot.config.Language;
import com.boot.config.PropertiesPeople;



@Controller
@RequestMapping("/")
@EnableConfigurationProperties(DruidConfiguration.class)
public class Index {
	
	@Autowired
	public PropertiesPeople PropertiesPeople;
	
	
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request,HttpSession session) {
	System.out.println("");
	System.out.println("login");
	return new ModelAndView("index.jsp");
	}
	@RequestMapping("/")
	public ModelAndView workLogin(HttpServletRequest request,HttpSession session) {
	return new ModelAndView("login.jsp");
	}
	
}
