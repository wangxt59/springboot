<%@ page language="java"
	import="java.util.*,com.antke.website.utils.CommonsUtil"
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
<title>修改员工角色</title>
<script type="text/javascript" src="/pages/power/role/js/roleCreate.js"></script>
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
                    <form class="form-horizontal" action="/role/updateRole.do" name="form1" method="post">
                        <div class="content">
                            <legend><spring:message code="language.editWorkerRole" /></legend>
                            <fieldset>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label"><star>*</star><spring:message code="language.rolename" /></label>
                                    <div class="col-sm-6">
                                        <input class="form-control" type="text" id="role_name" name="role_name" value="${map.roleInfo.role_name}" required>
                                    </div>
                                </div>
                            </fieldset>
                            <fieldset>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label"><star>*</star><spring:message code="language.roleint" /></label>
                                    <div class="col-sm-6">
                                        <input class="form-control" type="text" id="discribe" name="discribe" value="${map.roleInfo.discribe}" required />
                                    </div>
                                </div>
                            </fieldset>
                            <fieldset>
                                <div class="form-group">
                                   <label class="col-sm-2 control-label"><spring:message code="language.status" /></label>
                                   <div class="col-sm-10" style="margin-top: 10px">
                                        <label><!--  class="checkbox checkbox-inline" -->
                                            <!--<input type="checkbox" data-toggle="checkbox" name="status_flg" value="1"  ${map.roleInfo.status_flg ==1?'checked':''}><spring:message code="language.effective" />
	                                        --><input type="radio" value="1" id="status_flg" name="status_flg" ${map.roleInfo.status_flg ==1?'checked':''} /><spring:message code="language.effective" />
                                        </label>
                                        <label><!--  class="checkbox checkbox-inline" -->
                                            <!--<input type="checkbox" data-toggle="checkbox" name="status_flg" value="0"  ${map.roleInfo.status_flg ==0?'checked':''}><spring:message code="language.noeffective" />
	                                        --><input type="radio" value="0" id="status_flg" name="status_flg" ${map.roleInfo.status_flg ==0?'checked':''} /><spring:message code="language.noeffective" />
                                        </label>
                                   </div>
                                </div>
                            </fieldset>
                              
                            <fieldset>
                                <div class="form-group">
                                   <label class="col-sm-2 control-label"><spring:message code="language.rolepermissions" /></label>
                                   <div class="col-sm-3" style="margin-top: 10px">
                                      	<spring:message code="language.yeselectrole" />
                                   </div>
                                   <div class="col-sm-3" style="margin-top: 10px">
                                      	<spring:message code="language.noselectrole" />
                                   </div>
                                </div>
                                <div class="form-group">
                                   <label class="col-sm-2 control-label"></label>
                                   <div class="col-sm-3">
                                     <select multiple="multiple" class="form-control" style="height:300px" size="13" name="multiSelectListbox1" id="multiSelectListbox1">
									<c:forEach items="${map.newGroupList}" varStatus="item" var="m">
										<option value="${m.pgroup_id}" >${m.groups_name}</option>
									</c:forEach>
								</select>
								<button type="button" class="btn btn-wd btn-success" onclick="addRight()" style="float: right;margin-top: 10px;">
                                          <span class="btn-label">
                                              <i class="fa fa-arrow-right"></i>
                                          </span>
                                          	<spring:message code="language.addBtn" />
                                      </button>
                                   </div>
                                   <div class="col-sm-3">
                                     	<select multiple="multiple" class="form-control" style="height:300px" size="13" name="multiSelectListbox2" id="multiSelectListbox2">
									<c:forEach items="${map.oldGroupList}" varStatus="item" var="m">
										<option value="${m.pgroup_id}"  >${m.groups_name}</option>
									</c:forEach>
								</select>
								<button type="button" class="btn btn-wd btn-danger" onclick="addLeft()" style="margin-top: 10px;">
                                          <span class="btn-label">
                                              <i class="fa fa-arrow-left"></i>
                                          </span>
                                          	<spring:message code="language.deleteBtn" />
                                      </button>
                                   </div>
                                </div>
                           </fieldset>
                        </div>
                        <div class="footer text-center">
	                        <input type="hidden" id="role_id" name="role_id" value="${map.roleInfo.role_id}" />
							<input type="hidden" name="selectedPgroup" id="selectedPgroup" />
                            <button type="button" class="btn btn-info btn-fill btn-wd" id="doSubmit" onclick="javascript:submitAddFun();" ><spring:message code="language.determineBtn" /></button>
                            <button type="button" class="btn btn-fill btn-wd" onclick="javascript:history.go(-1);" ><spring:message code="language.backBtn" /></button>
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
</html>
