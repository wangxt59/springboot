package com.website.utils;


/**
 * 权限
 * @author bizf
 *
 */
public class RolerUtil {
	
	
	public static String getRolerName(String _code){
		
		String rolerName = "";
		 String[] rolerArray = _code.split(",");
		 for(int i=0;i<rolerArray.length;i++){
			 rolerName = rolerName+" "+getRolerNameByRolerCode(rolerArray[i]);
		 }
		 return rolerName;
		
	}
	 public static String getRolerNameByRolerCode(String _code) {
		 
		 if (_code == null || "".equals(_code) || "null".equals(_code)) {
				return "";
			}else if ("1001".equals(_code)) {
				return "超级管理员";
			}else if ("1002".equals(_code)) {
				return "财务人员";
			}else if ("1003".equals(_code)) {
				return "资讯管理员";
			}else if ("1004".equals(_code)) {
				return "物业管理员";
			}else{
				return "";
			}
	    }
}
