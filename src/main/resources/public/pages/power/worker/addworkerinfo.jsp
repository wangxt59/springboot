<%@ page language="java"
	import="java.util.*,com.antke.website.utils.CommonsUtil"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>系统管理</title> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/bootstrap.min.css" rel="stylesheet" />
<link href="/css/light-bootstrap-dashboard.css" rel="stylesheet" />
<link href="/css/common.css" rel="stylesheet" />
<link href="/css/font-awesome.min.css" rel="stylesheet"/>
<link href='/css/685fd913f1e14aebad0cc9d3713ee469.css' rel='stylesheet' type='text/css'/>
<link href="/css/pe-icon-7-stroke.css" rel="stylesheet" />
<script src="/js/ckeditor/ckeditor.js" type="text/javascript"></script>
<script src="/js/ckfinder/ckfinder.js" type="text/javascript"></script>
<script language="JavaScript" src="/js/WdatePicker.js"></script>
<!--<script src="http://libs.baidu.com/jquery/1.8.3/jquery.min.js"></script>
--><script type="text/javascript" src="/js/ckeditor/ckeditor.js"></script>
<script language='javascript' src="/pages/power/worker/js/addworkerinfo.js"></script>
<script src="/js/validate.js" type="text/javascript"></script>
<script language='javascript' src="/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
    $(function(){
    $("input[type='checkbox']").click(function() {
        var flag = $(this).prop("checked"); //先记录下点击后应该的状态
        $("input[type='checkbox']").prop("checked", false);
        $(this).prop("checked", flag);
    });
});
</script>

</head>
<body>
<div class="wrapper">
    <!-- 左侧导航栏开始 -->
<jsp:include page="/pages/inc/nav.jsp"></jsp:include>
  <!-- 左侧导航栏结束 -->
<div class="main-panel" data-ps-id="fabe6d0c-fb7a-4814-760e-94b6d796f92a">
     <!-- 头部开始 -->
<jsp:include page="/pages/inc/header.jsp"></jsp:include>
<!-- 头部结束 -->
		<!-- 内容table开始 -->
		<div class="content">
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-12">
						<div class="card">
						<form class="form-horizontal" id="addWorkerForm" action="/worker/insertWorkerInfo.do" name="addWorkerForm" method="post" enctype="multipart/form-data">
								<div class="content">
									<legend><spring:message code="language.addworker" /></legend>
									<!-- 0.商户编号：-->
									<!--<c:if test="${map.login_name=='admin'}">
									<fieldset>
										<div class="form-group">
										    <label class="col-sm-2 control-label"><star>*</star><spring:message code="language.merchantsnum" /></label>
										    <div class="col-sm-6">
											<input class="form-control" type="text" name="chant_id" id="chant_id"  placeholder="<spring:message code="language.pwmerchantsnum" />"/>
										    </div>
										    <span id="worker_codeMsg" style="color: red"></span>
										</div>
									</fieldset>
									</c:if>
										
									--><!-- 1.员工编号：-->
									<fieldset>
										<div class="form-group">
										    <label class="col-sm-2 control-label"><star>*</star><spring:message code="language.workrnum" /></label>
										    <div class="col-sm-6">
											<input class="form-control" type="text" name="worker_code" id="worker_code"  placeholder="<spring:message code="language.pwworkrnum" />"/>
										    </div>
										    <span id="worker_codeMsg" style="color: red"></span>
										</div>
									</fieldset>
									
									<!-- 2.员工姓名 -->
									<fieldset>
										<div class="form-group">
										    <label class="col-sm-2 control-label"><star>*</star><spring:message code="language.workername" /></label>
										    <div class="col-sm-6">
											<input class="form-control" id="worker_name" name="worker_name" placeholder="<spring:message code="language.pwworkername" />" required/>
										    </div>
										    <span id="worker_nameMsg" style="color: red"></span>
										</div>
									</fieldset>
									
									<!-- 3.登录名 -->
									<fieldset>
										<div class="form-group">
										    <label class="col-sm-2 control-label"><star>*</star><spring:message code="language.loginname" /></label>
										    <div class="col-sm-6">
												<input class="form-control" type="text" name="login_name" id="login_name" placeholder="<spring:message code="language.pwloginname" />" onblur="checkLoginname(this)"/>	
										    </div>
										    <span id="login_nameMsg" style="color: red"></span>
										</div>
									</fieldset>
									<!-- 4.登录密码 -->
									
									<fieldset>
										<div class="form-group">
										    <label class="col-sm-2 control-label"><star>*</star><spring:message code="language.loginpsd" /></label>
										    <div class="col-sm-6">
											<input type="password" class="form-control" id="password" name="password" placeholder="<spring:message code="language.pwloginpsd" />" required/>
										    </div>
										    <span id="passwordMsg" style="color: red"></span>
										</div>
									</fieldset>
									<!-- 5.确认密码 -->
									
									<fieldset>
										<div class="form-group">
										    <label class="col-sm-2 control-label"><star>*</star><spring:message code="language.confirepsd" /></label>
										    <div class="col-sm-6">
											<input type="password" class="form-control" id="rePassword" name="rePassword" placeholder="<spring:message code="language.pwconfirepsd" />" required/>
										    </div>
										    <span id="rePasswordMsg" style="color: red"></span>
										</div>
									</fieldset>
									<!-- 6.职位 -->
									
									<fieldset>
										<div class="form-group">
										    <label class="col-sm-2 control-label"><star></star><spring:message code="language.job" /></label>
										    <div class="col-sm-6">
											<input class="form-control" id="professional" name="professional" maxlenght='50' placeholder="<spring:message code="language.pwjob" />" required/>
										    </div>
										</div>
									</fieldset>
									<!-- 7.手机号 -->
									<fieldset>
										<div class="form-group">
										    <label class="col-sm-2 control-label"><star>*</star><spring:message code="language.wphone" /></label>
										    <div class="col-sm-6">
											<input class="form-control" id="contact" name="contact" maxlenght='50' placeholder="<spring:message code="language.pwphone" />" required/>
										    </div>
										    <span id="contactMsg" style="color: red"></span>
										</div>
									</fieldset>
									
									<!-- 8.座机 -->
									<fieldset>
										<div class="form-group">
										    <label class="col-sm-2 control-label"><star></star><spring:message code="language.landline" /></label>
										    <div class="col-sm-6">
											<input class="form-control" id="fixed_phone" name="fixed_phone" maxlenght='50' placeholder="<spring:message code="language.pwlandline" />" required/>
										    </div>
										    <span id="phoneMsg" style="color: red"></span>
										</div>
									</fieldset>
									<!-- 9.身份证号 -->
									<fieldset>
										<div class="form-group">
										    <label class="col-sm-2 control-label"><star></star><spring:message code="language.cdnum" /></label>
										    <div class="col-sm-6">
											<input class="form-control" id="cert_code" name="cert_code" maxlenght='50' placeholder="<spring:message code="language.pwcdnum" />" required/>
										    </div>
										    <span id="cert_codeMsg" style="color: red"></span>
										</div>
									</fieldset>
									<!-- 10.QQ -->
									<fieldset>
										<div class="form-group">
										    <label class="col-sm-2 control-label"><star></star>QQ</label>
										    <div class="col-sm-6">
											<input class="form-control" id="qq" name="qq" maxlenght='50' placeholder="<spring:message code="language.pwQQnum" />" required/>
										    </div>
										    <span id="qqMsg" style="color: red"></span>
										</div>
									</fieldset>
									<!-- 11.Email地址 -->
									<fieldset>
										<div class="form-group">
										    <label class="col-sm-2 control-label"><star></star><spring:message code="language.emailaddress" /></label>
										    <div class="col-sm-6">
											<input class="form-control" id="email" name="email" maxlenght='50' placeholder="<spring:message code="language.pwemailaddress" />" required/>
										    </div>
										    <span id="emailMsg" style="color: red"></span>
										</div>
									</fieldset>
									<!-- 12.用户角色 -->
									<fieldset>
										<div class="form-group">
										    <label class="col-sm-2 control-label"><star>*</star><spring:message code="language.userrole" /></label>
										    <div class="col-sm-6" style="margin-top:10px;">
										  
									 	    	<c:forEach items="${map.rolesList}" var="roles">
													<p>
															<input type="checkbox" name="rolesIdList" value="${roles.role_id}"/>${roles.role_name}&nbsp;&nbsp;&nbsp;
													</p>
												</c:forEach>
											 
										    </div>
										    <span id="checkIdMsg" style="color: red"></span> 
										</div>
									</fieldset>
								</div>
								
								<div class="footer text-center">
								    <button type="button" class="btn btn-info btn-fill btn-wd" id="doSubmit" onclick="javascript:checkInfo();" ><spring:message code="language.determineBtn" /></button>
								    <button type="reset" class="btn btn-info btn-fill btn-wd" ><spring:message code="language.resetBtn" /></button>
								    <button type="button" class="btn  btn-fill btn-wd" onclick="javascript:history.go(-1);" ><spring:message code="language.backBtn" /></button>
								</div>

							</form> 
						</div>
						<!--  end card  -->
					</div>
					<!-- end col-md-12 -->
				</div>
				<!-- end row -->
			</div>

		</div>
		<!-- 内容table结束 -->

		<!-- 底部开始 -->
		<jsp:include page="/pages/inc/footer.jsp"></jsp:include>
		<!-- 底部结束 -->
	</div>
</div>

</body>

</html>