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
<title>新增权限组</title>
<script language='javascript' src="/pages/power/groups/js/add.js"></script>
<script language='javascript' src="/js/jquery-1.8.3.min.js"></script>
</head>
<style>
.quanxian li ul,.quanxian{padding:0;}
.quanxian li{list-style:none;}
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
                    <form class="form-horizontal" action="/group/insertPowerGroup.do" name="form1" method="post">
                          <div class="content">
                              <legend><spring:message code="language.AddQX"/></legend>
                              <fieldset>
                                  <div class="form-group">
                                      <label class="col-sm-2 control-label"><star>*</star><spring:message code="language.QXName"/></label>
                                      <div class="col-sm-6">
                                          <input class="form-control" type="text" id="groups_name" name="groups_name" value="${powerGroup.groups_name}" required>
                                      </div>
                                      <span id="groupsNameMsg" style="color: red"></span>
                                  </div>
                              </fieldset>
                              <fieldset>
                                  <div class="form-group">
                                      <label class="col-sm-2 control-label"><star>*</star><spring:message code="language.QXMS"/></label>
                                      <div class="col-sm-6">
                                          <input class="form-control" type="text" id="groups_desc" name="groups_desc" value="${powerGroup.groups_desc}" required />
                                      </div>
                                      <span id="groupsDescMsg" style="color: red"></span>
                                  </div>
                              </fieldset>
                              <fieldset>
                                  <div class="form-group">
                                     <label class="col-sm-2 control-label"><spring:message code="language.QXZT"/></label>
                                     <div class="col-sm-10" style="margin-top: 10px">
                                          <!--<label class="checkbox checkbox-inline">
                                              <span class="icons"><span class="first-icon fa fa-square-o"></span><span class="second-icon fa fa-check-square-o"></span></span>
                                              <input type="checkbox" data-toggle="checkbox" name="status" value="1"  ${powerGroup.status ==1?'checked':'checked'}><spring:message code="language.YX"/>
                                          </label>
                                          <label class="checkbox checkbox-inline">
                                              <span class="icons"><span class="first-icon fa fa-square-o"></span><span class="second-icon fa fa-check-square-o"></span></span>
                                              <input type="checkbox" data-toggle="checkbox" name="status" value="2"  ${powerGroup.status ==0?'checked':''}><spring:message code="language.WX"/>
                                          </label>-->
                                          <label>
                                          	  <input type="radio" value="1" id="status" name="status" ${powerGroup.status ==1?'checked':'checked'} /><spring:message code="language.YX" />
                                          </label>
                                          <label>
	                                          <input type="radio" value="0" id="status" name="status" ${powerGroup.status ==0?'checked':''} /><spring:message code="language.WX" />
                                          </label>
                                     </div>
                                  </div>
                              </fieldset>
                                
                              <fieldset>
                                  <div class="form-group">
                                     <label class="col-sm-2 control-label"><spring:message code="language.PZCD"/></label>
                                     <div class="col-sm-3" style="margin-top:10px;">
                                     	  <ul class="quanxian">
                                     	  		<c:forEach items="${map.fristMuenList}" varStatus="item" var="fristMuen">
                                    	  		<li>
                                    	  		 <p class="one">
							 						 <input type="checkbox" id="menuList" name="menuList" value="<c:out value="${fristMuen.m_id}"/>"/>
							 						 <c:out value="${fristMuen.menu_name}"/><spring:message code="language.ZCD"/>
						 						 </p>
	                                    	  		<ul>
	                                    	  		<c:forEach items="${fristMuen.secondMuenList}" varStatus="item1" var="secondMuen">
			                                    	  	<li>
			                                    	  	<p class="two has">&nbsp;&nbsp;&nbsp;&nbsp;
												        <input type="checkbox" id="menuList" name="menuList" value="<c:out value="${secondMuen.m_id}"/>"/>
												        <c:out value="${secondMuen.menu_name}"/><spring:message code="language.EJCD"/></p>
			                                    	  		<ul>
			                                    	  		 <c:forEach items="${secondMuen.thirdMuenList}" varStatus="item1" var="thirdMuen">
					                                    	  	<li>
					                                    	  	 <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														        <input type="checkbox" id="menuList" name="menuList" value="<c:out value="${thirdMuen.m_id }"/>"/>
														        <c:out value="${thirdMuen.menu_name}"/></p>
					                                    	  	</li>
					                                    	  	</c:forEach> 
					                                     	 </ul>
			                                    	  	</li>
			                                    	  	</c:forEach> 
			                                     	 </ul>
                                    	  		</li>
                                    	  		</c:forEach> 
                                     	  </ul>
                                        	<%-- <c:forEach items="${map.fristMuenList}" varStatus="item" var="fristMuen">
					 						 <p>
					 						 <input type="checkbox" id="menuList" name="menuList" value="<c:out value="${fristMuen.m_id}"/>"/>
					 						 <c:out value="${fristMuen.menu_name}"/><spring:message code="language.ZCD"/></p>
													<c:forEach items="${fristMuen.secondMuenList}" varStatus="item1" var="secondMuen">
												        <p>&nbsp;&nbsp;&nbsp;&nbsp;
												        <input type="checkbox" id="menuList" name="menuList" value="<c:out value="${secondMuen.m_id}"/>"/>
												        <c:out value="${secondMuen.menu_name}"/><spring:message code="language.EJCD"/></p>
													        <c:forEach items="${secondMuen.thirdMuenList}" varStatus="item1" var="thirdMuen">
														        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														        <input type="checkbox" id="menuList" name="menuList" value="<c:out value="${thirdMuen.m_id }"/>"/>
														        <c:out value="${thirdMuen.menu_name}"/></p>
													    	</c:forEach> 
												    </c:forEach> 
											</c:forEach> --%>
                                     </div>
                                  </div>
                             </fieldset>
                          </div>
                          <div class="footer text-center">
                          	  <input type="hidden" name="list" id="list" value=""/>
                              <button type="button" class="btn btn-info btn-fill btn-wd" id="doSubmit" onclick="javascript:checkInfo();" ><spring:message code="language.TJ"/></button>
                              <button type="button" class="btn  btn-fill btn-wd" onclick="javascript:history.go(-1);" ><spring:message code="language.backBtn"/></button>
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
<script>
	var one=true;
	$(".one").on("click",function(){
		if(one){
			$(this).siblings().slideUp();
			one=false
		}else{
			$(this).siblings().slideDown();
			one=true
		}
		
	}) 
	var two=true;
	$(".two").on("click",function(){
		 if($(this).hasClass('has')){
		 	$(this).siblings().slideUp();
		 	$(this).removeClass('has')
		 }else{
		 	$(this).siblings().slideDown();
		 	$(this).addClass('has')
		 }
	})
</script>
</body>
</html>
