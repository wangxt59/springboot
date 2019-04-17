<%@ page language="java"
	import="java.util.*,com.antke.power.model.bean.WorkerInfo,com.antke.website.utils.CommonsUtil"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <link rel="stylesheet" rev="stylesheet" href="/css/globaladmin.css" media="all" />
 <title>系统管理</title>
<script language='javascript' src="/js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="/js/ckeditor/ckeditor.js"></script>
<script language='javascript' src="js/updatepassword.js"></script>
 <script type="text/javascript">
	function checkPassword(type) {
		var oldpassword = $("#oldpassword").val();// 旧的登录密码
		var newpassword = $("#password").val();// 新的登陆密码
		var rePassword = $("#rePassword").val();// 重复密码、
		/* var pattern=/\s+/g;
		 if(pattern.test(newpassword)){
			$("#passwordMsg").html("密码不允许有空格，请重新填写");
        	document.getElementById('newpassword').focus();return;
		}  */
		if(type == 1){
			// 校验操作 1 2
			if(oldpassword == newpassword){
				$("#passwordMsg").html('<spring:message code="language.yanpsd" />');
            	document.getElementById('newpassword').focus();return;
			}
		}
		if(type == 2) {
			// 校验操作  3 2 1 
			if(newpassword != rePassword){
				$("#rePasswordMsg").html('<spring:message code="language.yancpsd" />');
            	//document.getElementById('rePassword').focus();
            	return false;
			}
		}
	} 
</script> 	
	
</head>
	<body>
	    <input type="hidden" id="message"  value="<%=request.getAttribute("msge")%>"/>
		<div class="umtag"> 
			<spring:message code="language.nowaddress" />：<spring:message code="language.title" /> >> <spring:message code="language.workertitle" /> >> <spring:message code="language.editpsdTitle" />
		</div>
		<div class="tab-c">
		<div class="tab-in">
		<form action="/workermanage/updatePassword.do" name="form1"
			method="post">
			<table cellspacing="0" cellpadding="0" class="tcenter">
				<tr>
					<td class="tright"  style="width: 40%">
						<span>* </span><spring:message code="language.oldloginpsd" />：
					</td>
					<td class="tleft">
						<input type="password" id="oldpassword" name="oldpassword" value="" onblur="textpassword()" />
						<span id="oldpasswordMsg" style="color: red"></span>
					</td>
				</tr>
				
				<tr>
					<td class="tright"  style="width: 40%">
						<span>* </span><spring:message code="language.newloginpsd" />：
					</td>
					<td class="tleft">
						<input type="password" id="password" onblur="checkPassword(1)" name="worker.password" value="" />
						<span id="passwordMsg" style="color: red"></span>
					</td>
				</tr>
				<tr>
					<td class="tright"  style="width: 40%">
						<span>* </span><spring:message code="language.pwaginpsd" />：
					</td>
					<td class="tleft">
						<input type="password" id="rePassword" onblur="checkPassword(2)"  value="" />
						<span id="rePasswordMsg" style="color: red"></span>
					</td>
				</tr>
				
		  		<tr>
		  			<td class="tright">
					</td>
					<td class="tleft">
						<input type="button" id="doSubmit" value=" <spring:message code="language.determineBtn" /> " class="btn" 
						onclick="javascript:checkInfo();" />
						<input type="button" value=" <spring:message code="language.resetBtn" /> " class="btn" 
						onclick="javascript:resetInfo();" />
						<input type="button" value=" <spring:message code="language.backBtn" />" class="btn" 
						onclick="javascript:history.go(-1);" />
					</td>
		  		</tr>
			</table>
		</form>
		</div>
		</div>
	</body>
	<%@ include file="/pages/inc/footer.html"%>
</html>
