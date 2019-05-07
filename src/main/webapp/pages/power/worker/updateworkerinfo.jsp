<%@ page language="java"
	import="java.util.*,com.website.utils.CommonsUtil"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/bootstrap.min.css" rel="stylesheet" />
<link href="/css/light-bootstrap-dashboard.css" rel="stylesheet"/>
<link href="/css/common.css" rel="stylesheet" />
<link href="/css/font-awesome.min.css" rel="stylesheet"/>
<link href='/css/685fd913f1e14aebad0cc9d3713ee469.css' rel='stylesheet' type='text/css'/>
<link href="/css/pe-icon-7-stroke.css" rel="stylesheet" />
 <title>系统管理</title>
<script language='javascript' src="/js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="/js/ckeditor/ckeditor.js"></script>
<script language='javascript' src="/pages/power/worker/js/updateworkerinfo.js"></script>
</head>
<style>
.list-border{height:70px;border:1px solid #a0a0a0 ;border-radius:5px;display:block;padding:10px;}
</style>
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
                      <form id="updateWorkerForm" class="form-horizontal" action="/worker/updateWorkerInfo.do" name="updateWorkerForm" method="post">
					<input type="hidden" name="worker_id" value="${map.worker.worker_id}"/>
                          <div class="content">
                              <legend><spring:message code="language.editworkerim" /></legend>
                              <fieldset>
                                  <div class="form-group">
                                      <label class="col-sm-2 control-label"><spring:message code="language.merchantsnum" /></label>
                                      <div class="col-sm-6">
                                          <input class="form-control" type="text" name="worker_code" id="worker_code" value="${map.worker.worker_code }" readonly>
                                      </div>
                                  </div>
                              </fieldset>

                              <fieldset>
                                  <div class="form-group">
                                      <label class="col-sm-2 control-label"><star>*</star><spring:message code="language.workername" /></label>
                                      <div class="col-sm-6">
                                          <input class="form-control" type="text" name="worker_name" id="worker_name" value="${map.worker.worker_name }" required aria-required="true">
                                      </div>
                                  </div>
                              </fieldset>

                              <fieldset>
                                  <div class="form-group">
                                      <label class="col-sm-2 control-label"><star>*</star><spring:message code="language.loginname" /></label>
                                      <div class="col-sm-6">
                                          <input class="form-control" type="text" name="login_name" id="login_name" value="${map.worker.login_name}" required number="true">
                                      </div>
                                  </div>
                              </fieldset>

                              <%--<fieldset>
                                  <div class="form-group">
                                      <label class="col-sm-2 control-label"><star>*</star>登录密码</label>
                                      <div class="col-sm-6">
                                          <input class="form-control" type="password" name="password" id="password" value="${map.worker.password}" required aria-required="true">
                                      </div>
                                  </div>
                              </fieldset>--%>

						<fieldset>
                                  <div class="form-group">
                                      <label class="col-sm-2 control-label"><spring:message code="language.company" /></label>
                                      <div class="col-sm-6">
                                          <input class="form-control" type="text" name="company" id="company" value="${map.worker.company}" aria-required="true"/>
                                      </div>
                                  </div>
                              </fieldset>
                              
                              <fieldset>
                                  <div class="form-group">
                                      <label class="col-sm-2 control-label"><star>*</star><spring:message code="language.wphone" /></label>
                                      <div class="col-sm-6">
                                          <input class="form-control" type="text" name="contact" id="contact" value="${map.worker.contact}" required number="true"/>
                                      </div>
                                  </div>
                              </fieldset>
                              
                              <fieldset>
                                  <div class="form-group">
                                      <label class="col-sm-2 control-label"><spring:message code="language.landline" /></label>
                                      <div class="col-sm-6">
                                          <input class="form-control" type="text" name="fixed_phone" id="fixed_phone" value="${map.worker.fixed_phone}" number="true"/>
                                      </div>
                                  </div>
                              </fieldset>
                              
                              <fieldset>
                                  <div class="form-group">
                                      <label class="col-sm-2 control-label"><spring:message code="language.cdnum" /></label>
                                      <div class="col-sm-6">
                                          <input class="form-control" type="text" name="cert_code" id="cert_code" value="${map.worker.cert_code}" number="true">
                                      </div>
                                  </div>
                              </fieldset>
                              <fieldset>
                                  <div class="form-group">
                                      <label class="col-sm-2 control-label"><spring:message code="language.emailaddress" /></label>
                                      <div class="col-sm-6">
                                          <input class="form-control valid" type="text" name="email" value="${map.worker.email}" email="true">
                                      </div>
                                  </div>
                              </fieldset>
                                
                              <fieldset>
                                <div class="form-group">
								    <label class="col-sm-2 control-label"><star>*</star><spring:message code="language.userrole" /></label>
								    <div class="col-sm-6" style="margin-top:10px;">
								   
								    	<c:forEach items="${map.rolesList}" var="roles">
											<p>
													<input type="radio" id="rolesIdList" name="rolesIdList" value="${roles.role_id}"
			                            				<c:if test="${map.ruMaping.r_id == roles.role_id}"> checked="checked"</c:if>
													/>${roles.role_name}&nbsp;&nbsp;&nbsp;
											</p>
										</c:forEach>
								 
										<!--<c:forEach items="${map.rolesList}" var="roles">
											<p>
												<input type="checkbox" name="rolesIdList" value="${roles.role_id}"/>${roles.role_name}&nbsp;&nbsp;&nbsp;
											</p>
										</c:forEach>-->
								    </div>
								    <span id="checkIdMsg" style="color: red"></span> 
								</div>
                             </fieldset>
				
                          </div>
                          <div class="footer text-center">
                              <button type="submit" class="btn btn-info btn-fill btn-wd"><spring:message code="language.determineBtn" /></button>
                              <button type="button" class="btn  btn-fill btn-wd" onclick="javascript:history.go(-1);"><spring:message code="language.backBtn" /></button>
                          </div>
                      </form>
                  </div>
            </div> <!-- end col-md-12 -->
        </div> <!-- end row -->
    </div>
</div>
<!-- 内容table结束 -->
<!-- 底部开始 -->
<jsp:include page="/pages/inc/footer.jsp"></jsp:include>
<!-- 底部结束 -->
</div>
</div>
</body>
<script type="text/javascript">
	function selectCabinet(){
		var worker_id = document.getElementById("worker_id").value;
		//alert(worker_id);
		location.href="queryAllCabinets.do?worker_id=" + worker_id;
	}
</script>
</html>

