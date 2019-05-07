<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE>8鲜生</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<META content="MSHTML 6.00.6000.16674" name=GENERATOR>
<link rel="icon" href="favicon.ico" type="image/x-icon" />
<script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>

<link href="/css/bootstrap.min.css" rel="stylesheet" />
<link href="/css/light-bootstrap-dashboard.css" rel="stylesheet"/>
<link href="/css/common.css" rel="stylesheet" />
<link href="/css/font-awesome.min.css" rel="stylesheet">
<link href='/css/685fd913f1e14aebad0cc9d3713ee469.css' rel='stylesheet' type='text/css'>
<link href="/css/pe-icon-7-stroke.css" rel="stylesheet" />
<style>
   	.imglogo{
	width: 80px;
    height: 80px;
    overflow: hidden;
    border-radius: 50%;
    border: 4px solid rgba(255, 255, 255, 0.3);
    margin: 0 auto;}
</style>
<script language="javascript">
$(function(){
	createCode();
})
function loadData(error_code){
	if(error_code=="100002"){
		$("#pop").show();
   		$("#house").show();
   		$("#content1").html("用户名错误或用户状态异常！");
   		$("#bindingBut").attr("onclick","close1(3)");
	}else if(error_code=="100001"){
		$("#pop").show();
   		$("#house").show();
   		$("#content1").html("密码错误！");
   		$("#bindingBut").attr("onclick","close1(2)");
	}

}
var code; //在全局 定义验证码
function createCode()
{ //创建验证码函数
 code = "";
 var codeLength =4;//验证码的长度
 var selectChar = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z');//所有候选组成验证码的字符，当然也可以用中文的
 for(var i=0;i<codeLength;i++)
 {     
  var charIndex =Math.floor(Math.random()*36);
  code +=selectChar[charIndex];     
 }
// 设置验证码的显示样式，并显示
 document.getElementById("discode").innerHTML=code;      // 显示

   // $("#vertify").val(code);
}

function loginvertify()
{
  var password = $("#password").val();
  var loginname = $("#loginname").val();
  var vertify = $("#vertify").val();
	  if(code.toLowerCase()!=vertify.toLowerCase()){
		$("#pop").show();
   		$("#house").show();
   		$("#content1").html("验证码错误！");
   		$("#bindingBut").attr("onclick","close1(1)");
	  return;
  }
  return;
}
</script>
	</HEAD>
		<body onload="loadData('${map.error_code }');">
		
		<div class="wrapper wrapper-full-page">
    <div class="full-page login-page" data-color="azure" data-image="../images/full-screen-image-1.jpg">   
        
    <!--   you can change the color of the filter page using: data-color="blue | azure | green | orange | red | purple" -->
        <div class="content">
            <div class="container">
                <div class="row">                   
                    <div class="col-md-4 col-sm-6 col-md-offset-4 col-sm-offset-3">
                        <form action="/login/workLogin.do" class="form"   name="theForm"  method="post">
                            
                        <!--   if you want to have the card without animation please remove the ".card-hidden" class   -->
                            <div class="card card-hidden">
                            <div style="text-align:center;">
                            	 <img src="/images/default-avatar.png" class="imglogo"/>
                            </div>
                           		
                                <div class="header text-center" style="font-family:'Source Han Sans';">8鲜生管理平台</div>
                                <div class="content">
                                    <div class="form-group">
                                        <label>登录名 LoginName</label>
                                        <input type="text" id="loginName" name="loginName"  title="输入账号" maxlength="20" placeholder="用户名" class="form-control"/>
                                        <span id="content1"></span>
                                    </div>
                                    <div class="form-group">
                                        <label>密码 Password</label>
                                        <input type="password"  id="password" name="password" title="输入密码" maxlength="20" placeholder="密码" class="form-control"/>
                                        <span id="content2"></span>
                                    </div>   
                                    <!--<div class="form-group">
										<input class="form-control" type="text" value="" name=""  id="vertify" placeholder="验证码"/>
					        			<span class="left" id="discode" onClick="createCode();" ></span>
					        			<div style="clear: both;"></div>
									</div>  
                                --></div>
                                <div class="footer text-center" style="text-align:center;">
                                    <button type="button" class="btn btn-fill btn-warning btn-wd " style="background-color:#ff9510;border:none" onclick="checkinfo();">登录 Login</button>
                                </div>
                            </div>
                        </form>
                    </div>                    
                </div>
            </div>
        </div>
    	
    	<footer class="footer footer-transparent">
            <div class="container">
               
                <p class="copyright pull-right">
                    &copy; 20198 -2020 版权所有 鲜送达
                </p>
            </div>
        </footer>

    </div>                             
       
</div>	

		
	</BODY>
	<script type="text/javascript">
	
	function checkinfo(){
		var loginName = document.getElementById("loginName").value;
		var password = document.getElementById("password").value;
		var vertify = $("#vertify").val();
		if(loginName==""||loginName==null){
			$("#pop").show();
   			$("#house").show();
   			$("#content1").html("用户名不能为空！");
   			$("#bindingBut").attr("onclick","close1(0)");
			return;
		}
		if(password==""||password==null){
			$("#pop").show();
   			$("#house").show();
   			$("#content1").html("密码不能为空！");
   			$("#bindingBut").attr("onclick","close1(0)");
			return;
		}
		if(vertify==""||vertify==null){
			$("#pop").show();
   			$("#house").show();
   			$("#content1").html("验证码不能为空！");
   			$("#bindingBut").attr("onclick","close1(0)");
			return;
		}
		if(code.toLowerCase()!=vertify.toLowerCase()){
			$("#pop").show();
   			$("#house").show();
   			$("#content1").html("验证码错误！");
   			$("#bindingBut").attr("onclick","close1(1)");
			  return false;
		}
		document.theForm.submit();
   }
   
   function close1(num){
   		$("#pop").hide();
   		$("#house").hide();
   		if(num>0){
	   		$("#vertify").val("");
	   		createCode();
   		}
   		if(num>1){
   			$("#password").val("");
   		}
   		if(num>2){
   			$("#loginName").val("");
   		}
   }
   </script>
   <%String errorinfo = (String)request.getAttribute("errorinfo"); 
if(errorinfo!=null){
%>
<script language="javascript">
</script>
<%} %>

<!--   Core JS Files and PerfectScrollbar library inside jquery.ui   -->
    <script src="../js/ct/jquery.min.js" type="text/javascript"></script>
    <script src="../js/ct/jquery-ui.min.js" type="text/javascript"></script> 
	<script src="../js/ct/bootstrap.min.js" type="text/javascript"></script>
    
	<!--  Forms Validations Plugin -->
	<script src="../js/ct/jquery.validate.min.js"></script>
	
	<!--  Plugin for Date Time Picker and Full Calendar Plugin-->
	<script src="../js/ct/moment.min.js"></script>
	
    <!--  Date Time Picker Plugin is included in this js file -->
    <script src="../js/ct/bootstrap-datetimepicker.js"></script>
    
    <!--  Select Picker Plugin -->
    <script src="../js/ct/bootstrap-selectpicker.js"></script>
    
	<!--  Checkbox, Radio, Switch and Tags Input Plugins -->
	<script src="../js/ct/bootstrap-checkbox-radio-switch-tags.js"></script>
	
	<!--  Charts Plugin -->
	<script src="../js/ct/chartist.min.js"></script>

    <!--  Notifications Plugin    -->
    <script src="../js/ct/bootstrap-notify.js"></script>
    
    <!-- Sweet Alert 2 plugin -->
	<script src="../js/ct/sweetalert2.js"></script>
        
    <!-- Vector Map plugin -->
	<script src="../js/ct/jquery-jvectormap.js"></script>
	
    <!--  Google Maps Plugin    -->
    <script src="../js/ct/aa743e8f448a4792bad10d201a7080f6.js"></script>
	
	<!-- Wizard Plugin    -->
    <script src="../js/ct/jquery.bootstrap.wizard.min.js"></script>

    <!--  Datatable Plugin    -->
    <script src="../js/ct/bootstrap-table.js"></script>
    
    <!--  Full Calendar Plugin    -->
    <script src="../js/ct/fullcalendar.min.js"></script>
    
    <!-- Light Bootstrap Dashboard Core javascript and methods -->
	<script src="../js/ct/light-bootstrap-dashboard.js"></script>
	
	<!--   Sharrre Library    -->
    <script src="../js/ct/jquery.sharrre.js"></script>
	
	<!-- Light Bootstrap Dashboard DEMO methods, don't include it in your project! -->
	<script src="../js/ct/demo.js"></script>
    <script type="text/javascript">
        $().ready(function(){
            lbd.checkFullPageBackgroundImage();
            
            setTimeout(function(){
                // after 1000 ms we add the class animated to the login/register card
                $('.card').removeClass('card-hidden');
            }, 700)
        });
    </script>
    <script type="text/javascript">
	
	function checkinfo(){
		var loginName = document.getElementById("loginName").value;
		var password = document.getElementById("password").value;
		if(loginName==""||loginName==null){
   			$("#content1").html("用户名不能为空！");
			return;
		}
		if(password==""||password==null){
   			$("#content2").html("密码不能为空！");
			return;
		}
		document.theForm.submit();
   }
   
   </script>
</HTML>