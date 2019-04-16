package com.antke.website.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
 
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesFileUtil {

	/**
	 * 日志输出对象
	 */
	private static final Logger logger = Logger
			.getLogger(PropertiesFileUtil.class);

	private static Properties propertie;

	private static FileInputStream inputFile;

	/**
	 * 初始化Configuration类
	 */
	private PropertiesFileUtil() {
		propertie = new Properties();
	}

	public static Properties setConfigResource(String filePath) {
		propertie = new Properties();
		try {
			inputFile = new FileInputStream(filePath);
			propertie.load(inputFile);
			inputFile.close();
		}catch (FileNotFoundException ex) {
			logger.info("读取属性文件" + filePath + "--->失败！- 原因：文件路径错误或者文件不存在");
			ex.printStackTrace();
			System.exit(0);
		}catch (IOException ex) {
			logger.info("装载文件" + filePath + "--->失败!");
			ex.printStackTrace();
			System.exit(0);
		}
		return propertie;
	}

	/**
	 * 清除properties文件中所有的key和其值
	 */
	private void clear() {
		propertie.clear();
	}
}
