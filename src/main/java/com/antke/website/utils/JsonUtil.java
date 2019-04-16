package com.antke.website.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonUtil{
	/** 
     * 将json字符串转为Map结构 
     * 如果json复杂，结果可能是map嵌套map 
     * @param jsonStr 入参，json格式字符串 
     * @return 返回一个map 
     */  
//    public static Map<String, Object> json2Map(String jsonStr) {  
//        Map<String, Object> map = new HashMap<String, Object>();  
//        if(jsonStr != null && !"".equals(jsonStr)){  
//            //最外层解析  
//            JSONObject json = JSONObject.fromObject(jsonStr);  
//            for (Object k : json.keySet()) {  
//                Object v = json.get(k);  
//                //如果内层还是数组的话，继续解析  
//                if (v instanceof JSONArray) {  
//                    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();  
//                    Iterator<JSONObject> it = ((JSONArray) v).iterator();  
//                    while (it.hasNext()) {  
//                        JSONObject json2 = it.next();  
//                        list.add(json2Map(json2.toString()));  
//                    }  
//                    map.put(k.toString(), list);  
//                } else {  
//                    map.put(k.toString(), v);  
//                }  
//            }  
//            return map;  
//        }else{  
//            return null;  
//        }  
//    }
    
//    public static void main(String[] args) {
//    	String jsonStr = "{'RespCode':'PC7600','MrchntTraceNo':'T20180327170955550638305'}";
//    	Map<String, Object> json2Map = json2Map(jsonStr);
//    	System.out.println(json2Map);
//    	
//    	
//	}
    
}
