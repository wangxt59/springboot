package com.antke.website.utils;


/*
 * Copyright (C) 2009-2012 19e Inc.All Rights Reserved.		
 * 																	
 * FileName：JacksonMapper.java					
 *			
 * Description：创建ObjectMapper、XmlMapper单例类						
 * 																	
 * History：
 * 版本号		作者		日期		简要介绍相关操作
 *  1.0         duff Aug 31, 2012 Create	
 *  
 */


import org.codehaus.jackson.map.ObjectMapper;

import com.fasterxml.jackson.xml.XmlMapper;

/**
 * Jackson单例类
 * 
 * @author bizf
 */

public class JacksonMapper {
	/**
	 * 创建ObjectMapper对象
	 */
	private static final ObjectMapper object = new ObjectMapper();

	/**
	 * 创建XmlMapper对象
	 */
	private static final XmlMapper xml = new XmlMapper();

	/**
	 * 私有构造
	 */
	private JacksonMapper() {
	}

	/**
	 * 
	 * Description：返回ObjectMapper
	 * 
	 * @return
	 */
	public static ObjectMapper getObjectMapper() {
		return object;
	}

	/**
	 * 
	 * Description：返回XmlMapper
	 * 
	 * @return
	 */
	public static XmlMapper getXmlMapper() {
		return xml;
	}
}

