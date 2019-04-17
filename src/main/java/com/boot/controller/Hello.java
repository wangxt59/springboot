package com.boot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.embedded.DataSourceFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.config.Mysql;
import com.boot.config.PropertiesPeople;
import com.boot.config.YmlPeople;

@RestController
//@ConfigurationProperties(value = "classpath:myconfig.properties")
public class Hello {

//	@Value("${system.user.name}")
//	String name;
//	@Value("${people.name}")
//	String peoplename;
	
	@Autowired
	public PropertiesPeople Ppeople;
	@Autowired
	public YmlPeople Ypeople;
	@Autowired
	public Mysql mysql;

    @RequestMapping("/hello")
    @ResponseBody
    public List<Map> hello(HttpServletRequest request) {
    	Map<String, Object> map=new HashMap<String, Object>();
    	List<Map> list=new ArrayList<Map>();
    	map.put("Ypeople", Ypeople);
    	
//    	map.put("peoplename", peoplename);
    	map.put("Ppeople", Ppeople);
    	map.put("path", request.getParameter("url"));
    	list.add(map);
    	System.out.println(list.toString());
        return list;
    }
    @RequestMapping(value="/mysql")
    @ResponseBody
    public Map<String, Object> mysql(HttpServletRequest request) {
    	Map<String, Object> map=new HashMap<String, Object>();
    	map.put("Ypeople", Ypeople);
    	
//    	map.put("peoplename", peoplename);
    	map.put("Ppeople", Ppeople);
    	map.put("mysql", mysql);
    	map.put("path", request.getParameter("url"));
        return map;
    }

}
