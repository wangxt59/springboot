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
<title>团长审核列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="canonical"
	href="https://www.creative-tim.com/product/light-bootstrap-dashboard-pro" />
<link href="/css/bootstrap.min.css" rel="stylesheet" />
<link href="/css/light-bootstrap-dashboard.css" rel="stylesheet" />
<link href="/css/common.css" rel="stylesheet" />
<link href="/css/font-awesome.min.css" rel="stylesheet" />
<link href='/css/685fd913f1e14aebad0cc9d3713ee469.css' rel='stylesheet'
	type='text/css' />
<link href="/css/pe-icon-7-stroke.css" rel="stylesheet" />
<script language='javascript' src="/js/jquery-1.8.3.min.js"></script>
<script language="javascript" src="/js/My97DatePicker/WdatePicker.js"></script>
<script language="javascript" src="/js/layer/layer.js"></script>

</head>
<style>
.fixed-table-toolbar {
	width: 100%;
	overflow: hidden;
}

.content {
	height: 650px
}
</style>
<style>
.select {
	height: 38px;
	line-height: 38px;
	border-radius: 5px;
	border: 1px solid #ddd;
	width: 100%
}

.first {
	display: flex;
	align-items: center;
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
					<form action="/commander/commanderList.do"
						name="categoryform" id="categoryform" method="post"
						accept-charset="utf-8">
						<div class="row">
							<div class="col-md-12">
								<div class="card">
									<div class="content">
										<legend>团长审核列表</legend>
										<!-- --------------------------------------- -->
										<!-- 真实姓名 -->
										<div class="col-md-2 first" style="width: 90%">
											<input type="text" style="width: 20%; margin-right: 1%"
												placeholder="请输入团长真实名称" class="form-control " id="real_name"
												name="real_name" value="${map.real_name}" />
											<!-- 手机号 -->
											<input type="text" style="width: 20%; margin-right: 1%"
												placeholder="请输入手机号" class="form-control " id="contact"
												name="contact" value="${map.contact}" />
											<!-- 请选择团购状态 -->
											<div style="width: 15%">
												<select name="status" id="status" class="selectpicker">
													<option value="" ${map.status == ''?'selected':''}>选择申请状态</option>
													<option value="1" ${map.status == '1'?'selected':''}>待审核</option>
													<option value="2" ${map.status == '2'?'selected':''}>已通过</option>
													<option value="3" ${map.status == '3'?'selected':''}>已驳回</option>
													<option value="4" ${map.status == '4'?'selected':''}>已取消</option>
												</select>												
											</div>
										</div>


										<!-- 查询 -->
										<button type="submit" class="btn btn-info btn-fill "
											id="doSubmit" onclick="selectCommander();">查询</button>
										<!-- 列表 -->
										<div class="card margintop20">
											<table class="table">
												<thead>
													<th class="text-center">微信名称</th>
													<th class="text-center">真实姓名</th>
													<th class="text-center">手机号</th>
													<th class="text-center">群人数</th>
													<th class="text-center">自提点</th>
													<th class="text-center">申请时间</th>
													<th class="text-center">申请理由</th>
													<th class="text-center">状态</th>
													<th data-field="actions" class="text-center text-center">操作</th>
												</thead>
												<tbody id="table">
													<c:forEach items="${map.pageInfo.datas}" varStatus="item" var="m">
														<tr>
															<td class="tcenter text-center"><c:out value="${m.nick_name}" /></td>
															<td class="tcenter text-center"><c:out value="${m.real_name}" /></td>
															<td class="tcenter text-center"><c:out value="${m.contact}" /></td>
															<td class="tcenter text-center"><c:out value="${m.group_num}" /></td>
															<td class="tcenter text-center"><c:out value="${m.point_name}" /></td>
															<td class="tcenter text-center"><c:out value="${m.apply_date}" /></td>
															<td class="tcenter text-center"><c:out value="${m.apply_reason}" /></td>
															<td class="tcenter text-center">
															<c:if test="${m.status == 1}">
																<c:out value="待审核" />
															</c:if>	
															<c:if test="${m.status == 2}">
																<c:out value="已通过" />
															</c:if>	
															<c:if test="${m.status == 3}">
																<c:out value="已驳回" />
															</c:if>	
															<c:if test="${m.status == 4}">
																<c:out value="已取消" />
															</c:if>	
															</td>
															<c:if test="${m.status != 1}">
																<td class='tcenter text-center'>
																	<a href="javascript:detailsGoods('${m.apply_id}');" title="查看">查看</a>
																</td>
															</c:if>	
															<c:if test="${m.status == 1}">
																<td class='tcenter text-center'>
																	<a href="javascript:detailsGoods('${m.apply_id}');" title="审核">审核</a>
																</td>
															</c:if>	
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
										<div class="newpages">
											<%@include file="/page/page.jsp"%>
										</div>
										<!--  -->

									</div>
								</div>
							</div>
						</div>
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
		/* var real_name = "";
		var contact = "";
		var city = "";
		var status = "";

		$(function() {
			getCommanderList();
		});

		function selectCommander() {
			getCommanderList();
		}

		function getCommanderList() {
			var real_name = $("#real_name").val();
			var contact = $("#contact").val();
			var city = $("#city").val();
			var status = $("#status").val();
			$.ajax({
				type : "GET",
				url : "/commander/commanderList.do?real_name=" + real_name
						+ "&contact=" + contact + "&city=" + city + "&status="
						+ status + "&currentPage" +currentPage,
				dataType : "json",
				success : function(data) {
					var html = '';
					var datatext = data.map.pageInfo.datas;
					for (var i = 0; i < datatext.length; i++) {
						html += "<tr>" + "<td class='tcenter text-center'>"
								+ datatext[i].nick_name + "</td>"
						html += "<td class='tcenter text-center'>"
								+ datatext[i].real_name + "</td>"
						html += "<td class='tcenter text-center'>"
								+ datatext[i].contact + "</td>"
						html += "<td class='tcenter text-center'>"
								+ datatext[i].group_num + "</td>"
						html += "<td class='tcenter text-center'>"
								+ datatext[i].point_name + "</td>"
						html += "<td class='tcenter text-center'>"
								+ datatext[i].apply_reason + "</td>"
						html += "<td class='tcenter text-center'>"
								+ datatext[i].status + "</td>"
						html += "<td class='tcenter text-center'>"
								+ "<a href='javascript:detailsGoods("
								+ datatext[i].id + ");' title='查看'>查看</a>"
								+ "</td>" + "</tr>"
					}
					$("#table").html(html);

				}
			});
		} */

		//查看团长
		function detailsGoods(commanderId) {
			location.href = "/commander/getCommanderById.action?id="
					+ commanderId;
		}
	</script>



</body>
<%-- <%-- <%@ include file="../inc/footer.html"%> --%>
</html>
