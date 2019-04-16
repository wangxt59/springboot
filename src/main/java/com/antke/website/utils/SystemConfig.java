package com.antke.website.utils;

import java.net.URISyntaxException;
import java.util.Properties;

import org.apache.log4j.Logger;


public class SystemConfig {
	/**
	 * 生成日志对象
	 */
	private static Logger logger = Logger.getLogger(SystemConfig.class);
	private static final String configPath = "systemconfig.properties"; // 配置文件src下的路径

	private static SystemConfig inst;

	public static SystemConfig getInstance() {
		if (inst == null) {
			inst = new SystemConfig();
		}
		return inst;
	}

	/***************************************************************************
	 * 读取system配置文件
	 * 
	 */
	public void loadConfig() throws Exception{
		// 获取src根路径
		String configRootPath = "";
		try {
			configRootPath = SystemConfig.class.getClassLoader()
					.getResource("").toURI().getPath();
		} catch (URISyntaxException e) {
			logger.info("获取工程src路径异常，异常信息:", e);
		}
		String systemFile = configRootPath + configPath;

		logger.info("读取system配置文件开始,文件路径为：" + systemFile);
		Properties systemProperties = PropertiesFileUtil
				.setConfigResource(systemFile);
		
 
		Constants.SEND_FROM = systemProperties.getProperty("send_from");
		Constants.EMAIL_HOST = systemProperties.getProperty("email_host");
		Constants.EMAIL_USER = systemProperties.getProperty("email_user");
		Constants.EMAIL_PASSWORD = systemProperties.getProperty("email_password");
		Constants.SEND_DATA_PROJECT_ID = systemProperties.getProperty("send_data_project_id");
		Constants.SEND_DATA_ADMIN_EMAIL = systemProperties.getProperty("send_data_admin_email");
		
	}
	
	public static  String getProperty(String name ){
		Properties systemProperties = PropertiesFileUtil .setConfigResource(name);
		return systemProperties.getProperty(name);
	}
}
