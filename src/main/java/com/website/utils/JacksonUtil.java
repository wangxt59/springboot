package com.website.utils;

import java.io.IOException;
import java.io.StringWriter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.map.ObjectMapper;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.xml.XmlMapper;

/**
 * jackson使用工具类
 * 
 * @author bizf
 */

public class JacksonUtil {
	/**
	 * 生成日志对象
	 */
	private static Log log = LogFactory.getLog(JacksonUtil.class);

	/**
	 * Description：将Object转为xml
	 * 
	 * @param object
	 * @param rootName
	 * @return
	 */
	public static String toXml(Object object, String rootName) {

		try {
			// 将object转为xml
			XmlMapper xml = JacksonMapper.getXmlMapper();
			// String xmlStr = xml.writeValueAsString(object);
			StringWriter sw = new StringWriter();
			xml.writeValue(sw, object);
			String xmlStr = sw.toString();
			String xmlHeader = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
			//
			String mapClassName = object.getClass().getSimpleName();
			String beginStr = "<" + mapClassName + " xmlns=\"\">";
			String endStr = "</" + mapClassName + ">";
			int beginNum = beginStr.length();
			int endNum = xmlStr.indexOf(endStr);
			String subStr = xmlStr.substring(beginNum, endNum);
			StringBuffer sb = new StringBuffer();
			sb.append(xmlHeader).append("<" + rootName + ">").append(subStr)
					.append("</" + rootName + ">");
			return sb.toString();

		} catch (JsonGenerationException e) {
			log.error("jackson转换错误，异常信息:", e);
		} catch (JsonMappingException e) {
			log.error("jackson转换错误，异常信息:", e);
		} catch (IOException e) {
			log.error("jackson转换错误，异常信息:", e);
		}

		return "";
	}
	public static String toXml(Object object) {

		try {
			 String rootName = "root";
			// 将object转为xml
			XmlMapper xml = JacksonMapper.getXmlMapper();
			// String xmlStr = xml.writeValueAsString(object);
			StringWriter sw = new StringWriter();
			xml.writeValue(sw, object);
			String xmlStr = sw.toString();
			String xmlHeader = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
			//
			String mapClassName = object.getClass().getSimpleName();
			String beginStr = "<" + mapClassName + " xmlns=\"\">";
			String endStr = "</" + mapClassName + ">";
			int beginNum = beginStr.length();
			int endNum = xmlStr.indexOf(endStr);
			String subStr = xmlStr.substring(beginNum, endNum);
			StringBuffer sb = new StringBuffer();
			sb.append(xmlHeader).append("<" + rootName + ">").append(subStr)
					.append("</" + rootName + ">");
			return sb.toString();

		} catch (JsonGenerationException e) {
			log.error("jackson转换错误，异常信息:", e);
		} catch (JsonMappingException e) {
			log.error("jackson转换错误，异常信息:", e);
		} catch (IOException e) {
			log.error("jackson转换错误，异常信息:", e);
		}

		return "";
	}
	/**
	 * Description：将Object转为json
	 * 
	 * @param object
	 * @return
	 */
	public static String toJson(Object object) {
		try {
			ObjectMapper mapper = JacksonMapper.getObjectMapper();
			return mapper.writeValueAsString(object);
		} catch (com.fasterxml.jackson.core.JsonGenerationException e) {
			log.error("jackson转换错误，异常信息:", e);
		} catch (com.fasterxml.jackson.databind.JsonMappingException e) {
			log.error("jackson转换错误，异常信息:", e);
		} catch (IOException e) {
			log.error("jackson转换错误，异常信息:", e);
		}
		return "";
	}

	public static String convertData(Object object, String type) {
		String str = "";
		if (type.equalsIgnoreCase("2")) {
			str = toJson(object);
		} else {
			str = toXml(object, "response");
		}

		return str;
	}
}

