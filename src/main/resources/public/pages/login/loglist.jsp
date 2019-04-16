<%@ page language="java"
	import="java.util.*,com.antke.website.utils.CommonsUtil"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>用户登录日志</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="canonical" href="https://www.creative-tim.com/product/light-bootstrap-dashboard-pro"/>
<link href="/css/bootstrap.min.css" rel="stylesheet" />
<link href="/css/light-bootstrap-dashboard.css" rel="stylesheet"/>
<link href="/css/common.css" rel="stylesheet" />
<link href="/css/font-awesome.min.css" rel="stylesheet"/>
<link href='/css/685fd913f1e14aebad0cc9d3713ee469.css' rel='stylesheet' type='text/css'/>
<link href="/css/pe-icon-7-stroke.css" rel="stylesheet" />
<script language='javascript' src="/js/jquery-1.8.3.min.js"></script>
<script language="javascript" src="/js/My97DatePicker/WdatePicker.js"></script>
</head>
<style>
.select{
height:38px;line-height:38px;border-radius:5px;border:1px solid #ddd;width:100%
}
</style>
	<body>
<div class="wrapper">
    <!-- 左侧导航栏开始 -->
   <jsp:include page="/pages/inc/nav.jsp"></jsp:include>
   <!-- 左侧导航栏结束 -->
   <div class="main-panel">
      <!-- 头部开始 -->
      <jsp:include page="/pages/inc/header.jsp"></jsp:include>
	<!-- 头部结束 -->
      <!-- 内容table开始 -->
       <div class="content">
           <div class="container-fluid">
			<form action="/login/list.do" name="logform" id="logform" method="post" accept-charset="utf-8">
               <div class="row">
                   <div class="col-md-12">
                       <div class="card">
                       	<div class="header">
                               <h4 class="title"><spring:message code="language.loginLog"/></h4>
                           </div>
						<div class="content">
						<div class="row">
                            <div class="col-md-2 ">
								<div class="form-group">
									<input type="text" placeholder="<spring:message code="language.inputWorkerID"/>" class="form-control"
										id="worker_id" name="worker_id" value="${map.worker_id}"
										size="11"/>
								</div>
							</div>
                            <div style="position:relative;display:inline-block;padding:0;" class="col-md-4">
								<div class="col-md-6">
									<div class="form-group">
										<input type="text" id="create_date_start" placeholder="<spring:message code="language.startTime"/>" 
											class="form-control" onclick= "WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" name="create_date_start" 
										value="${map.create_date_start}"  />
									</div>
								</div>
							
							<div class="col-md-6">
								<div class="form-group">
									<input type="text" id="create_date_end" placeholder="<spring:message code="language.endTime"/>" 
											class="form-control" onclick= "WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" name="create_date_end" 
									value="${map.create_date_end}"  />
									</div>
								</div>
								<p style="position:absolute;top:15%;left:49.5%">--</p>
							</div>
							  <div class="footer padding0 col-md-2">
							 	<div class="col-md-12 allFooter">
	                            	<button class="btn btn-info btn-fill" type="button" onclick="checkData();" ><spring:message code="language.queryBtn"/></button>
	                           		<button class="btn btn-default btn-fill" onclick="resetInfo();" ><spring:message code="language.resetBtn"/></button>
	                            </div> 
						    </div>
                          
						    </div>
						    <div class="card margintop20">
                       <table id="bootstrap-table" class="table">
                           <tr>
                            <th><spring:message code="language.mxu"/></th>
					        <th><spring:message code="language.WorkerID"/></th><!-- 用户ID -->
							<th><spring:message code="language.WorkerRole"/></th><!-- 用户角色 -->
							<th><spring:message code="language.loginTime"/></th><!-- 登入时间 -->
							<th><spring:message code="language.logoutTime"/></th><!-- 登出时间 -->
					        <th><spring:message code="language.loginIP" /></th><!-- 登录IP -->
							<th data-field="actions" ><spring:message code="language.operation" /></th><!-- 操作 -->
                               <tbody>
									<c:forEach items="${map.pageInfo.datas}" var="l" varStatus="log">
										 <tr>
				                            <td>${log.index + 1}</td>
									        <td><c:out value="${l.workerId}"/></td>
									        <td>
												<c:if test="${l.role==0}"><spring:message code="language.admin" /></font> </c:if>
												<c:if test="${l.role==1}"><spring:message code="language.chantManager" /></font> </c:if>
												<c:if test="${l.role==2}"><spring:message code="language.chantServer" /></font> </c:if>
												<c:if test="${l.role==4}"><spring:message code="language.dianzhang" /></font> </c:if>
											</td>
									        <td>
									       		<fmt:formatDate value="${l.createDate}" pattern="yyyy-MM-dd HH:mm:ss" />
									        </td>
									        <td>
									        	<fmt:formatDate value="${l.updateDate}" pattern="yyyy-MM-dd HH:mm:ss" />
									        </td>
									        <td><c:out value="${l.loginIp}"/></td> 
									        <td>
												<a href="/login/queryLoginLogDetail.do?id=${l.id}" title="<spring:message code="language.lookdetails" />"><spring:message code="language.lookdetails" /></a>&nbsp;&nbsp;
											</td>
								        </tr>
							        </c:forEach>	
                               </tbody>
                           </table>
                       </div><!--  end card  -->
                	</div>            
                     <div class="newpages">
			        	<%@include file="/page/page.jsp" %>
			         </div>
                </div>
           </div> <!-- end col-md-12 -->
       </div> <!-- end row -->
		</form>
			
           </div>

       </div>
       <!-- 内容table结束 -->
       
       <!-- 底部开始 -->
	 <jsp:include page="/pages/inc/footer.jsp"></jsp:include>
	<!-- 底部结束 -->
    </div>
</div>

 <!-- 右侧设置开始 -->
 <jsp:include page="/pages/inc/setting.jsp"></jsp:include>
<!-- 右侧设置结束 -->	

<script type="text/javascript">
	//表单提交搜索
	function checkData(){
		var create_date_start = $("#create_date_start").val();
		var create_date_end = $("#create_date_end").val();
		if(create_date_start > create_date_end){
			alert("开始时间不能大于结束时间");
			return;
		}
		document.logform.submit();
	}
	
	//重置搜索内容
	function resetInfo() {
		$("input[type=text]").val("");
	}
	
</script>

</body>
</html>
