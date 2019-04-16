<%@ page language="java"
	import="java.util.*,com.antke.website.utils.CommonsUtil"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>粉丝管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="canonical" href="https://www.creative-tim.com/product/light-bootstrap-dashboard-pro" />
<link href="/css/bootstrap.min.css" rel="stylesheet" />
<link href="/css/light-bootstrap-dashboard.css" rel="stylesheet" />
<link href="/css/common.css" rel="stylesheet" />
<link href="/css/font-awesome.min.css" rel="stylesheet" />
<link href='/css/685fd913f1e14aebad0cc9d3713ee469.css' rel='stylesheet' type='text/css' />
<link href="/css/pe-icon-7-stroke.css" rel="stylesheet" />
<script language='javascript' src="/js/jquery-1.8.3.min.js"></script>
<script language="javascript" src="/js/My97DatePicker/WdatePicker.js"></script>
</head>
<style>
.fixed-table-toolbar {
	width: 100%;
	overflow: hidden;
}
</style>
<body onload="opener.location.reload()">

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
					<form action="/userfans/getUserFans.do" name="userform"
						id="userform" method="post" accept-charset="utf-8">
						<div class="row">
							<div class="col-md-12">
								<div class="card">
									<div class="header">
										<h4 class="title">粉丝管理</h4>
									</div>
								 
									<div class="content">
			                           <!-- 用户 -->
			                            <div class="col-md-3">
			                                 <div class="form-group">
			                                    <input type="text" placeholder="团长昵称" class="form-control"  id="nick_name" name="nick_name" 
			                                    value="${map.param.nick_name}" size="15"/>
			                                </div>
			                            </div>
			                            <div class="col-md-3">
			                                 <div class="form-group">
			                                    <input type="text" placeholder="粉丝昵称" class="form-control"  id="user_name" name="user_name" 
			                                    value="${map.param.user_name}" size="15"/>
			                                </div>
			                            </div>
			                            	                            <div class="col-md-3">
			                                 <div class="form-group">
			                                    <input type="text" placeholder="团长电话" class="form-control"  id="contact" name="contact" 
			                                    value="${map.param.contact}" size="15"/>
			                                </div>
			                            </div>
										<div class="footer">
											<button class="btn btn-info btn-fill btn-wd" type="submit">
												<spring:message code="language.queryBtn"/></button>
											<button class="btn btn-default btn-fill btn-wd"
												onclick="resetInfo();"><spring:message code="language.resetBtn"/></button>
										</div>
										<div class="card margintop20">
											<table class="table">
												<thead>
													<th>用户名称（昵称）</th>
													<th>用户头像</th>
													<th>团长昵称</th>
													<th>团长真实姓名</th>
													<th>团长头像</th>
													<th>团长电话</th>
													<th>关注时间</th>
												</thead>
												<tbody>
													<c:forEach items="${map.pageInfo.datas}" varStatus="item" var="m">
														<tr>
															<td class="tcenter"><c:out value="${m.user_name}" /></td>
															<td class="tcenter"><img src="${m.fansHeader}" alt="" style="width: 30px; "/></td>
															<td class="tcenter"><c:out value="${m.nick_name}" /></td>
															<td class="tcenter"><c:out value="${m.real_name}" /></td>
															<td class="tcenter"><img src="${m.userHeader}" alt="" style="width: 30px; "/></td>
															<td class="tcenter"><c:out value="${m.contact}" /></td>
															<td class="tcenter"><c:out value="${m.create_date}" /></td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</div>
									<!--  end card  -->
									<div class="newpages">
										<%@include file="/page/page.jsp"%>
									</div>
								</div>
							</div>
							<!-- end col-md-12 -->
						</div>
						<!-- end row -->
					</form>

				</div>
			</div>
			<!-- 内容table结束 -->
			<!-- 底部开始 -->
			<jsp:include page="/pages/inc/footer.jsp"></jsp:include>
			<!-- 底部结束 -->
		</div>
	</div>

	<%-- 	<!-- 右侧设置开始 -->
	<jsp:include page="/pages/inc/setting.jsp"></jsp:include>
	<!-- 右侧设置结束 --> --%>
	<script type="text/javascript">
		function updateStatus(id,status) {
			jQuery.ajax({
				url : "/userInfo/updateUserStatus.do",
				data : {
					"status": status,
					"id":id
				},
				type : "post",
				dataType : "json",
				success : function(data) {
					var code = data.code;
					if (code == "OK") {
						// 页面刷新
						swal("<spring:message code='language.success' />!", "success");
						window.location.reload();
					} else {
						swal("<spring:message code='language.deleteFailure' />!", "fail");
					}
				},
			});
		}
 
	</script>

</body>
<%-- <%-- <%@ include file="../inc/footer.html"%> --%>
</html>
