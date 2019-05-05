package com.website.utils;

import java.util.concurrent.ConcurrentHashMap;

public class SysConstants {
	
	/**
	 * 地区信息
	 */
	public static ConcurrentHashMap<String, String> areaMap = new ConcurrentHashMap<String, String>();

	/**
	 * 系统默认的编码格式
	 */
	public static final String DEFAULT_ENCODE = "UTF-8";
	
	public static final String IMAGES_URL = "ImagesUpload\\upload";
	
	public static final String IMAGESSERVICE_URL = "ImagesService\\upload";
	
    public static final String JSON_TYPE = "JSON";
}
