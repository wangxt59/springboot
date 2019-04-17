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
<title>权限管理</title>
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
                    <form class="form-horizontal" action="/group/updatePowerGroup.do" name="form1" method="post">
                          <div class="content">
                              <legend><spring:message code="language.BJQX"/></legend>
                              <fieldset>
                                  <div class="form-group">
                                      <label class="col-sm-2 control-label"><star>*</star><spring:message code="language.QXName"/></label>
                                      <div class="col-sm-6">
                                          <input class="form-control" type="text" id="groups_name" name="groups_name" value="${map.powerGroup.groups_name}" required>
                                      </div>
                                      <span id="groupsNameMsg" style="color: red"></span>
                                  </div>
                              </fieldset>
                              <fieldset>
                                  <div class="form-group">
                                      <label class="col-sm-2 control-label"><star>*</star><spring:message code="language.QXMS"/></label>
                                      <div class="col-sm-6">
                                          <input class="form-control" type="text" id="groups_desc" name="groups_desc" value="${map.powerGroup.groups_desc}" required />
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
                                              <input type="checkbox" data-toggle="checkbox" name="status" value="1"  ${map.powerGroup.status =='1'?'checked':''}><spring:message code="language.YX"/>
                                          </label>
                                          <label class="checkbox checkbox-inline">
                                              <span class="icons"><span class="first-icon fa fa-square-o"></span><span class="second-icon fa fa-check-square-o"></span></span>
                                              <input type="checkbox" data-toggle="checkbox" name="status" value="2"  ${map.powerGroup.status =='2'?'checked':''}><spring:message code="language.WX"/>
                                          </label>-->
                                          <label>
                                          	  <input type="radio" value="1" id="status" name="status" value="1" ${map.powerGroup.status =='1'?'checked':''} /><spring:message code="language.YX" />
                                          </label>
                                          <label>
	                                          <input type="radio" value="2" id="status" name="status" value="2" ${map.powerGroup.status =='2'?'checked':''} /><spring:message code="language.WX" />
                                          </label>
                                     </div>
                                  </div>
                              </fieldset>
                                
                              <fieldset>
                                  <div class="form-group">
                                     <label class="col-sm-2 control-label"><spring:message code="language.PZCD"/></label>
                                     <div class="col-sm-3" style="margin-top:10px;">
                                    <%--  <c:forEach items="${map.fristMuenList}" varStatus="item" var="fristMuen"> --%>
                                        <ul class="quanxian">
                                        	<c:forEach items="${map.fristMuenList}" varStatus="item" var="fristMuen">
                                        	<li>
                                        		 <p class="one">
							 						 <c:choose>
							 						 <c:when test="${fristMuen.check==1}">
							 						 	<input type="checkbox" id="menuList" name="menuList" value="<c:out value="${fristMuen.m_id }"/> " checked/>
							 						 	<c:out value="${fristMuen.menu_name}"/><spring:message code="language.ZCD"/>
												      </c:when>
												      <c:otherwise>
												      	<input type="checkbox" id="menuList" name="menuList" value="<c:out value="${fristMuen.m_id}"/>"/>
							 							<c:out value="${fristMuen.menu_name}"/><spring:message code="language.ZCD"/>
												      </c:otherwise>
												      </c:choose>
						 						 </p>
                                        		<ul>
                                        			<c:forEach items="${fristMuen.secondMuenList}" varStatus="item1" var="secondMuen">
                                        			<li>
	                                        			 <p class="two has">&nbsp;&nbsp;&nbsp;&nbsp;
													        <c:choose>
						 						            <c:when test="${secondMuen.check==1}">
													        	<input type="checkbox" id="menuList" name="menuList" value="<c:out value="${secondMuen.m_id }"/>" checked/>
													        	<c:out value="${secondMuen.menu_name}"/><spring:message code="language.EJCD"/>
													     	</c:when>
													     	<c:otherwise>
													      		<input type="checkbox" id="menuList" name="menuList" value="<c:out value="${secondMuen.m_id}"/>"/>
															    <c:out value="${secondMuen.menu_name}"/><spring:message code="language.EJCD"/>
													        </c:otherwise>
													     	</c:choose>
											        	</p>
											        	<ul>
											        	<c:forEach items="${secondMuen.thirdMuenList}" varStatus="item1" var="thirdMuen">
											        		<li class="three">
														        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														         <c:choose>
					 						                   <c:when  test="${thirdMuen.check==1}">
														        	<input type="checkbox" id="menuList" name="menuList" value="<c:out value="${thirdMuen.m_id}"/>" checked/>
														       		<c:out value="${thirdMuen.menu_name}"/>
														      	</c:when>
														      	<c:otherwise>
														      		<input type="checkbox" id="menuList" name="menuList" value="<c:out value="${thirdMuen.m_id}"/>"/>
														        	<c:out value="${thirdMuen.menu_name}"/>
														     	 </c:otherwise>
														     	 </c:choose>
														        </p>
											        		</li>
											        		</c:forEach> 
											        	</ul>
                                        			</li>
                                        			</c:forEach> 
                                        		</ul>
                                        	</li>
                                        	</c:forEach> 
                                        </ul>
				 						<%--  <p>
				 						 <c:choose>
				 						 <c:when test="${fristMuen.check==1}">
				 						 	<input type="checkbox" id="menuList" name="menuList" value="<c:out value="${fristMuen.m_id }"/> " checked/>
				 						 	<c:out value="${fristMuen.menu_name}"/><spring:message code="language.ZCD"/>
									      </c:when>
									      <c:otherwise>
									      	<input type="checkbox" id="menuList" name="menuList" value="<c:out value="${fristMuen.m_id}"/>"/>
				 							<c:out value="${fristMuen.menu_name}"/><spring:message code="language.ZCD"/>
									      </c:otherwise>
									      </c:choose>
				 						 </p> --%>
										<%-- <c:forEach items="${fristMuen.secondMuenList}" varStatus="item1" var="secondMuen">
									        <p>&nbsp;&nbsp;&nbsp;&nbsp;
									        <c:choose>
		 						            <c:when test="${secondMuen.check==1}">
									        	<input type="checkbox" id="menuList" name="menuList" value="<c:out value="${secondMuen.m_id }"/>" checked/>
									        	<c:out value="${secondMuen.menu_name}"/><spring:message code="language.EJCD"/>
									     	</c:when>
									     	<c:otherwise>
									      		<input type="checkbox" id="menuList" name="menuList" value="<c:out value="${secondMuen.m_id}"/>"/>
											    <c:out value="${secondMuen.menu_name}"/><spring:message code="language.EJCD"/>
									        </c:otherwise>
									      </c:choose>
							        		</p> --%>
									        <%-- <c:forEach items="${secondMuen.thirdMuenList}" varStatus="item1" var="thirdMuen">
										        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										         <c:choose>
	 						                   <c:when  test="${thirdMuen.check==1}">
										        	<input type="checkbox" id="menuList" name="menuList" value="<c:out value="${thirdMuen.m_id}"/>" checked/>
										       		<c:out value="${thirdMuen.menu_name}"/>
										      	</c:when>
										      	<c:otherwise>
										      		<input type="checkbox" id="menuList" name="menuList" value="<c:out value="${thirdMuen.m_id}"/>"/>
										        	<c:out value="${thirdMuen.menu_name}"/>
										     	 </c:otherwise>
										     	 </c:choose>
										        </p> --%>
								    <%-- 	</c:forEach> 
								    </c:forEach> 
									</c:forEach> --%>
                                     </div>
                                  </div>
                             </fieldset>
                          </div>
                          <div class="footer text-center">
                          	  <input type="hidden" name="list" id="list" value=""/>
                          	  <input type="hidden" id="pgroup_id" name="pgroup_id" value="${map.powerGroup.pgroup_id}" />
                              <button class="btn btn-info btn-fill btn-wd" onclick="javascript:checkInfo();" ><spring:message code="language.TJ"/></button>
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
	/* var status=true;
	function one(obj){
		
		if(status){
			$(obj).siblings().slideUp();
			status=false;
		}else{
			$(obj).siblings().slideDown();
			status=true;
		}
		
	} */
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
