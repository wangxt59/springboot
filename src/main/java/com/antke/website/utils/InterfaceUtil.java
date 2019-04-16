package com.antke.website.utils;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;


public class InterfaceUtil {
	/**
	 * 生成日志对象
	 */
	private static Logger log = Logger.getLogger(InterfaceUtil.class);
	
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	private static Properties propertie;
	/**
	 * Description：以Map形式返回错误信息
	 * 
	 * @param code 错误码
	 * @param errorDesc 错误描述
	 * @return
	 */
	public static Map<String,String> getErrorMap(String code,String errorDesc) {
		Map<String,String> returnMap =new HashMap<String,String>();
		returnMap.put("result_code",code);
		returnMap.put("result_desc",errorDesc);
		return returnMap;
	}
	
	/**
	 * Description：根据返回类型返回不同格式的错误信息
	 * 
	 * @param returnType
	 * @param code
	 * @param errorDesc
	 * @return
	 */
	public static String getReturnErrorInfo(String returnType, String code,
			String errorDesc) {
		StringBuffer stringBuff = new StringBuffer();
		if ("1".equals(returnType)) {
			stringBuff.append("<resmap><result_code>");
			stringBuff.append(code);
			stringBuff.append("</result_code><result_desc>");
			stringBuff.append(errorDesc);
			stringBuff.append("</result_desc></resmap>");
		} else {
			stringBuff.append("{\"result_code\":\"");
			stringBuff.append(code);
			stringBuff.append("\",\"result_desc\":\"");
			stringBuff.append(errorDesc);
			stringBuff.append("\"}");
		}
		return stringBuff.toString();
	}
	/**
	 * 判断是否为空
	 * @param ke
	 * @return
	 */
	 public static boolean isEmpty(String str){
	    	if(str == null || "".equals(str.trim())){
	    		return true;
	    	}else{
	    		return false;
	    	}
	    	
	    }
	
	/**
	 * Description：根据返回类型返回不同格式的错误信息(返回给ASP的错误信息格式)
	 * 
	 * @param returnType
	 * @param code
	 * @param errorDesc
	 * @return
	 */
	public static String getErrorInfoForAsp(String returnType, String code,
			String errorDesc) {
		StringBuffer stringBuff = new StringBuffer();
		if ("1".equals(returnType)) {
			stringBuff.append("<resmap><result_code>");
			stringBuff.append(code);
			stringBuff.append("</result_code><result_desc>");
			stringBuff.append(errorDesc);
			stringBuff.append("</result_desc></resmap>");
		} else {
			stringBuff.append("{\"result_code\":\"");
			stringBuff.append(code);
			stringBuff.append("\",\"result_desc\":\"");
			stringBuff.append(errorDesc);
			stringBuff.append("\"}");
		}
		return stringBuff.toString();
	}

 /**
    * 将字符串封装成map
    * 
     * @param input
    *            字符串
    * @param protocol
    *            1-xml 2-json
    * @return map对象
    */
    @SuppressWarnings("unchecked")
    public static Map conversionMap(String input, String protocol) {
       protocol = (protocol == null || protocol.equals("")) ? "2"
              : protocol;
       if (protocol.equalsIgnoreCase("2"))// json报文
       {
           return getmapByJson(input);
       } else {
           return null;
       }
    }

    /**
     * 将json串转换成map
     * 
      * @param json
     *            json串
     * @return map
     */
     @SuppressWarnings("unchecked")
     public static HashMap getmapByJson(String json) {
        HashMap outMap = null;
        try {
            if (objectMapper == null) {
               objectMapper = new ObjectMapper();
            }
            outMap = objectMapper.readValue(json, HashMap.class);
        } catch (Exception e) {
            log.error("json串转换成map异常", e);
            return outMap;
        }
        return outMap;
     }
     
     /** *//**
      * 重载函数，得到key的值
      * @param key 取得其值的键
      * @return key的值
      */
     public static String getValue(String key){
         if(propertie.containsKey(key)) {
             String value = propertie.getProperty(key).trim();//得到某一属性的值
             return value;
         }
         else 
             return "";
     }
     
     /**
      * 将JSON字符串转成list
      * @param json 形如：[aqa,bbb,ccc]
      * @return
      */
     public static List<String> toList(String json){
         String[] arrayStr = new String[] {};// 字符数组  
         List<String> list = new ArrayList<String>();// list  
         json = json.substring(json.indexOf("[")+1);//删除多余前缀
         json = json.substring(0,json.lastIndexOf("]"));//删除多余后缀
         arrayStr = json.split(",");// 字符串转字符数组  
         list = java.util.Arrays.asList(arrayStr);// 字符数组转list  
         return list;
 	}
     
     /**
      * 去除字符串两边的双引号
      * @param OriginalStr
      * @return
      */
     public static String removeQuotes(String OriginalStr){
    	 String resultStr = null;
    	 if(null != OriginalStr && !"".equals(OriginalStr)){
    		 if(OriginalStr.startsWith("\"") && OriginalStr.endsWith("\"")){
    			 resultStr = OriginalStr.substring(1);
    			 resultStr = resultStr.substring(0, resultStr.length()-1);
    		 }else{
    			 resultStr = OriginalStr;
    		 }
    	 }
    	 return resultStr;
     }
     
     /**
      * 将JSON字符串转成list<Map>
      * @param json
      * @param keys map中包含的key值
      * @return
      */
	public static List<Map> toList4Map(String json, String[] keys) {
		List<Map> data = new ArrayList<Map>();

		List<Map<String, String>> list = null;
		JSONArray jaData = JSONArray.fromObject(json);
		list = new ArrayList<Map<String, String>>();
		Map<String, String> map = null;
		for (int j = 0; j < jaData.size(); j++) {
			JSONObject joMap = jaData.getJSONObject(j);
			map = new HashMap<String, String>();
			for (String key : keys) {
				map.put(key, joMap.getString(key));
			}
			data.add(map);
		}

		return data;
	}
     
    // 评断手机号码是否正确
 	public static boolean isMobileNum(String mobiles) {
 		Pattern p1 = Pattern
 				.compile("^((13[0-9])|(15[^4,\\D])|(18[0-3,5-9])|(17[0,7]))\\d{8}$");
 		Pattern p2 = Pattern
 				.compile("^1(3[0-9]|5[0-35-9]|8[025-9]|70|77)\\d{8}$");
 		Pattern p3 = Pattern
 				.compile("^1(34[0-8]|(3[5-9]|5[017-9]|8[278])\\d)\\d{7}$");
 		Pattern p4 = Pattern.compile("^1(3[0-2]|5[256]|8[56])\\d{8}$");
 		Pattern p5 = Pattern.compile("^1((33|53|8[09])[0-9]|349)\\d{7}$");
 		Pattern p6 = Pattern.compile("^1(7[5-9])\\d{8}$");
 		Pattern p7 = Pattern.compile("^1(8[0-9])\\d{8}$");

 		Matcher m1 = p1.matcher(mobiles);
 		Matcher m2 = p2.matcher(mobiles);
 		Matcher m3 = p3.matcher(mobiles);
 		Matcher m4 = p4.matcher(mobiles);
 		Matcher m5 = p5.matcher(mobiles);
 		Matcher m6 = p6.matcher(mobiles);
 		Matcher m7 = p7.matcher(mobiles);
 		if (m1.matches() || m2.matches() || m3.matches() || m4.matches()
 				|| m5.matches()||m6.matches()||m7.matches()) {
 			return true;
 		} else {
 			return false;
 		}
 	}
}
