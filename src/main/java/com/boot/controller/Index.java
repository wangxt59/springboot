package com.boot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/index")
public class Index {
	
	@RequestMapping("/login")
	public ModelAndView workLogin(HttpServletRequest request,HttpSession session) {
	System.out.println("");
	System.out.println("login");
	System.out.println("");
	return new ModelAndView("/index.html");
	}
	
}
