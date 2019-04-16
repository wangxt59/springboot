package com.boot.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.PropertiesPeople;
import com.boot.entity.YmlPeople;

@RequestMapping("/")
@RestController
@ConfigurationProperties(value = "classpath:myconfig.properties")
public class Hello {

	@Value("${system.user.name}")
	String name;
	@Value("${people.name}")
	String peoplename;
	
	@Autowired
	public PropertiesPeople Ppeople;
	@Autowired
	public YmlPeople Ypeople;

    @RequestMapping("/hello")
    @ResponseBody
    public Map<String, Object> hello(HttpServletRequest request) {
    	Map<String, Object> map=new HashMap<String, Object>();
//    	map.put("portString", portString);
    	map.put("Ypeople", Ypeople);
    	
    	map.put("peoplename", peoplename);
    	map.put("Ppeople", Ppeople);
    	map.put("path", request.getParameter("url"));
        return map;
    }

}
