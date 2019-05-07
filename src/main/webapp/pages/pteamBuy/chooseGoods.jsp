<%@ page language="java"
	import="java.util.*,com.website.utils.CommonsUtil"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>选择商品</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="canonical"
	href="https://www.creative-tim.com/product/light-bootstrap-dashboard-pro" />
<link href="/css/bootstrap.min.css" rel="stylesheet" />
<link href="/css/light-bootstrap-dashboard.css" rel="stylesheet" />
<script language='javascript' src="/js/jquery-1.8.3.min.js"></script>
<script src="/js/bootstrap-fileinput-master/js/fileinput.js"
	type="text/javascript"></script>
	<link href="/js/bootstrap-fileinput-master/css/fileinput.css"
	media="all" rel="stylesheet" type="text/css" />
 <script src="/js/bootstrap-fileinput-master/js/locales/zh.js"
	 type="text/javascript"></script>
</head>
<style>
</style>
<body>
	<div class="form-group " style="width:100px;float:left;margin-right:30px" id="pic1">
                <input data-options="prompt:'Choose a file...'" type="file"
                       id='imgs1' name="imgs"
                       onchange="getImages('imgs1',1)"/>
                <input id="pic_url1" type="hidden" name="teamPics[1].picUrl" />
                <img src="" id="pic_urla1"  style="width:100px" />
                <div id="pic_div1" style="display:block;">
                    <input id="isHome1" name="teamPics[1].isHome"  type="hidden" value="1" />
                    <a type="button"  onclick="remove('pic1');" id="delete1" style="display:none;">删除</a>
                </div>
    </div>
</body>
<%-- <%-- <%@ include file="../inc/footer.html"%> --%>
</html>
