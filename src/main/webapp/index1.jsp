<%@ page language="java" contentType="text/html; charset=GB18030" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>省市区三级联动下拉菜单</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="<%=path %>/js/jquery/jquery-1.7.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/json/json-minified.js"></script>
  </head>
  
  <body>
  省份：
    <select name="province" id="province" onchange="onSelectChange(this,'city');">
    	
    </select>
    <br/>
  城市：
  <select name="city" id="city" onchange="onSelectChange(this,'district');">
  	<option value="">请选择</option>
  </select>
  <br/>
  区(县)：
  <select name="district" id="district">
  	<option value="">请选择</option>
  </select>
  <spring:message code="language.goodsallb"/></h4>
  </body>
</html>
