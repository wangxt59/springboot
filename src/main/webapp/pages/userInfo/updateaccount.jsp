<%@ page language="java"
	import="java.util.*,com.website.utils.CommonsUtil"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>账户管理</title>
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
<body>

	<div class="wrapper">
		<!-- 左侧导航栏开始 -->
		<!-- 左侧导航栏结束 -->
		<div class="main-panel">
			<!-- 头部开始 -->
			<!-- 头部结束 -->
			<!-- 内容table开始 -->
			<div class="content">
				<div class="container-fluid">
					<form action="/userInfo/queryUserInfo.do" name="userform"
						id="userform" method="post" accept-charset="utf-8">
						<div class="row">
							<div class="col-md-12">
								<div class="card">
									<div class="header">
										<h4 class="title"><spring:message code="language.userallb"/></h4>
									</div>
								 
									<div class="content">
									   <div class="col-md-3">
			                                <div class="form-group">
			                                    <input type="text" placeholder="联系方式" class="form-control"  id="contact" name="contact" 
			                                    value="" size="15"/>
			                                </div>
			                            </div>
			                            
										<div class="footer">
											<button class="btn btn-info btn-fill btn-wd" type="button" onclick="selectUserInfo();">查询</button>
										</div>
										
										<div class="card margintop20">
											<table class="table">
												<thead>
													<th>真实姓名</th>
													<th><spring:message code="language.wphone"/></th>
													<th>可售余额</th>
													<th>可售额度</th>
												</thead>
												<tbody>
													<tr>
														<td class="tcenter" id="realname"></td>
														<td class="tcenter" id="contact"></td>
														<td class="tcenter" id="coinBalance"></td>
														<td class="tcenter" id="salableQuota"></td>
													</tr>
												</tbody>
											</table>
										</div>
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
		</div>
	</div>
	<!-- 右侧设置结束 --> --%>
	<script type="text/javascript">
	
	function selectUserInfo(){
		var contact = $("#contact").val();
		alert(contact);
		jQuery.ajax({
				url : "/userInfo/queryUserInfo.do",
				data : {
					"contact":contact
				},
				type : "post",
				dataType : "json",
				success : function(data) {
					var code = data.result_code;
					if (code == "0") {
						$("#realname").html(data.realname);
						$("#contact").html(data.contact);
						$("#coinBalance").html(data.coinBalance);
						$("#salableQuota").html(data.salableQuota);		
					} else {
						alert("未找到用户");
					}
				},
			});
			
	}
	
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
 
 	function queryAccount(user_id) {
			location.href="/userInfo/queryAccountInfo.do?user_id=" + user_id;
		}
		
	</script>

</body>
<%-- <%-- <%@ include file="../inc/footer.html"%> --%>
</html>
