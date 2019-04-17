<%@ page language="java"
	import="java.util.*"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" rev="stylesheet"
			href="/css/globaladmin.css" media="all" />
		<title>500错误页面</title>
		<script language='javascript' src="/js/jquery-1.7.1.js"></script>
		<script type="text/javascript" src="/js/ckeditor/ckeditor.js"></script>
		<script language='javascript' src="/js/addinformation.js"></script>
	</head>
	<body>
		<div align="center" >
		<p>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
	    		<font color="red" size="5">
	    			<b>
		    			<%=request.getAttribute("msg") %>
	    			</b>
	    		</font>
	    	<br/>
	    	<br/>
	    	<br/>
		</p>														 
	    	<input type="button" class="btn" value=" 返 回 " onclick="javascript:history.go(-1);"/>
		</div>
  	</body>
</html>
