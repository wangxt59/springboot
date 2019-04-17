<%@ page language="java"
	import="java.util.*,com.antke.power.model.bean.WorkerInfo"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="zxx">
<head>
<title><spring:message code="language.welcome"/></title>
<!-- custom-theme -->
<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />
<meta name="keywords" content="">

    <meta name="description" content="">
 <!-- Bootstrap core CSS     -->
    <link href="/css/bootstrap.min.css" rel="stylesheet" />

    <!--  Light Bootstrap Dashboard core CSS    -->
    <link href="/css/light-bootstrap-dashboard.css" rel="stylesheet"/>

    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="/css/common.css" rel="stylesheet" />


    <!--     Fonts and icons     -->
    <link href="/css/font-awesome.min.css" rel="stylesheet">
    <link href='/css/685fd913f1e14aebad0cc9d3713ee469.css' rel='stylesheet' type='text/css'>
    <link href="/css/pe-icon-7-stroke.css" rel="stylesheet" />
</head>
<body>

<div class="wrapper">
    
	<%@ include file="../inc/nav.jsp"%>

    <div class="main-panel">
 <%@ include file="../inc/header.jsp"%>
        <div class="content">
        	<div style="text-align: center;font-size: 32px;margin-top: 60px;"><spring:message code="language.welcome"/></div>
        	<div style="text-align: center;margin-top: 60px;"><%--<img src="/images/logo.png" width="300px"/>--%></div>
        </div>

<%@ include file="../inc/footer.jsp"%>
        
    </div>
</div>
<%--设置--%>
<%@ include file="../inc/setting.jsp"%>


</body>
    <script>
        $().ready(function(){
            demo.initFullCalendar();
        });
    </script>


</html>