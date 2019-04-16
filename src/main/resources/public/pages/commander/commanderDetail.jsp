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
<title>团长详情</title>
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
#modal {
	position: fixed;
	top: 0;
	z-index: 999;
	margin: 200px 555px;
	display: none;
}

.fixed-table-toolbar {
	width: 100%;
	overflow: hidden;
}

.col-sm-2 {
	width: 45%;
	margin: 20px
}

.content {
	height: 500px
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
					<form action="/commander/getCommanderById.action"
						name="categoryform" id="categoryform" method="post"
						accept-charset="utf-8">
						<div class="row">
							<div class="col-md-12">
								<div class="card">
									<div class="content">
										<legend>团长详情</legend>
										<!-- 1.商品名称 -->
										<fieldset>
											<div>
												<div class="form-group">
													<label class="col-sm-2 control-label">
														申请时间:&nbsp;&nbsp;&nbsp;<c:out
															value="${map.commander.apply_date}" />
													</label> <label class="col-sm-2 control-label">
														团长编码：&nbsp;&nbsp;&nbsp;<c:out
															value="${map.commander.user_code}" />
													</label> <label class="col-sm-2 control-label">
														真实姓名:&nbsp;&nbsp;&nbsp;<c:out
															value="${map.commander.real_name}" />
													</label> <label class="col-sm-2 control-label">
														微信名称:&nbsp;&nbsp;&nbsp;<c:out
															value="${map.commander.nick_name}" />
													</label> <label class="col-sm-2 control-label">
														手机号:&nbsp;&nbsp;&nbsp;<c:out
															value="${map.commander.contact}" />
													</label> <label class="col-sm-2 control-label">
														身份证号:&nbsp;&nbsp;&nbsp;<c:out
															value="${map.commander.id_card_no}" />
													</label> <label class="col-sm-2 control-label">
														小区地址:&nbsp;&nbsp;&nbsp;<c:out
															value="${map.commander.address}" />
													</label> <label class="col-sm-2 control-label">
														群人数:&nbsp;&nbsp;&nbsp;<c:out
															value="${map.commander.group_num}" />
													</label> <label class="col-sm-2 control-label">
														自提点:&nbsp;&nbsp;&nbsp;<c:out
															value="${map.commander.point_name}" />
													</label> <label class="col-sm-2 control-label">
														申请理由:&nbsp;&nbsp;&nbsp;<c:out
															value="${map.commander.apply_reason}" />
													</label>
													<c:if test="${map.commander.status == 1}">
														<label class="col-sm-2 control-label"> 状
															态:&nbsp;&nbsp;&nbsp;<c:out value="待审核" />
														</label>
													</c:if>
													<c:if test="${map.commander.status == 2}">
														<label class="col-sm-2 control-label"> 状
															态:&nbsp;&nbsp;&nbsp;<c:out value="已通过" />
														</label>
													</c:if>
													<c:if test="${map.commander.status == 3}">
														<label class="col-sm-2 control-label"> 状
															态:&nbsp;&nbsp;&nbsp;<c:out value="已驳回" />
														</label>
													</c:if>
													<c:if test="${map.commander.status == 4}">
														<label class="col-sm-2 control-label"> 状
															态:&nbsp;&nbsp;&nbsp;<c:out value="已取消" />
														</label>
													</c:if>
													<label class="col-sm-2 control-label" style="width: 100px">
														身份证照片:&nbsp;&nbsp;&nbsp; </label><img
														src="${map.commander.id_card_front}" alt=""
														style="width: 250px; height: 150px; margin-top: 20px" />
													<img src="${map.commander.id_card_back}" alt=""
														style="width: 250px; height: 150px; margin-top: 20px" />
													<c:if
														test="${map.commander.refuse_reason != null && map.commander.refuse_reason != ''}">
														<label class="col-sm-2 control-label">
															拒绝理由:&nbsp;&nbsp;&nbsp; <c:out
																value="${map.commander.refuse_reason}" />
														</label>
													</c:if>
												</div>
										</fieldset>


									</div>
									<%-- id ${map.commander.apply_id} --%>
									<div class="footer text-center">
										<c:if test="${map.commander.status == '1'}">
											<button type="button" class="btn btn-info btn-fill btn-wd"
												data-toggle="modal" data-target="#myModal">通过</button>
											<button type="button" class="btn btn-info btn-fill btn-wd"
												id="doSubmit" onclick="setStatus();">拒绝</button>
										</c:if>
										<input type="button" class="btn btn-fill btn-wd" name="Submit"
											onclick="javascript:history.back(-1);" value="返回"/>
									</div>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>

			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">审核提示</h4>
						</div>
						<div class="modal-body">
							<h5>
								确定审核通过吗？
								</h4>
						</div>
						<div class="modal-footer">
							<button type="button"
								onclick="setPass(${map.commander.apply_id},${map.commander.user_id})"
								class="btn btn-success btn-fill">确定</button>
							<button type="button" class="btn btn-default btn-simple"
								data-dismiss="modal">关闭</button>
						</div>
					</div>
				</div>
			</div>

			<!-- 内容table结束 -->
			<div id="modal">
				<div class="modal-dialog" style="width: 500px;">
					<div class="modal-content" style="width: 500px; height: 400px">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true"></button>
							<h4 class="modal-title" id="myModalLabel">拒绝理由</h4>
						</div>
						<div class="modal-body"
							style="width: 480px; height: 300px; text-align: center;">
							<!-- 内容table开始 -->
							<div align="center">
								<textarea rows="10" cols="50" id="reasonText"></textarea>
							</div>
							<span id="reasonMsg" style="color: red"></span>
							<button type="button" style="margin: 10px"
								class="btn btn-info btn-fill btn-wd"
								onclick="saveRefuse(${map.commander.apply_id},${map.commander.user_id})">确定</button>
							<button type="button" style="margin: 10px;"
								class="btn btn-default btn-fill btn-wd" onclick="closeModal()">关闭</button>
						</div>
						<!-- 内容table结束 -->
					</div>
				</div>
				<!-- /.modal-content -->
			</div>

			<div id="alertMsg" class="alert alert-warning"
				style="width: 200px; height: 200px; position: fixed; top: 0; z-index: 999; margin: 200px 555px; text-align: center; display: none">
				<a href="#" class="close" data-dismiss="alert"> &times; </a> <strong>警告！</strong>审核失败!
			</div>

			<!-- 底部开始 -->
			<jsp:include page="/pages/inc/footer.jsp"></jsp:include>
			<!-- 底部结束 -->
		</div>
	</div>
	<%-- 	<!-- 右侧设置开始 -->
	<jsp:include page="/pages/inc/setting.jsp"></jsp:include>
	<!-- 右侧设置结束 --> --%>
	<script type="text/javascript">
		function setStatus() {
			$("#modal").css("display", "block");
		}
		
		function setPass(apply_id,user_id){
			var status = 2;
			var refuse_reason = "";
			saveReason(apply_id,user_id,status,refuse_reason);
		}
		
		function saveRefuse(apply_id,user_id){
			var status = 3;
			var refuse_reason = $("#reasonText").val();
			if (refuse_reason == "" || refuse_reason == null) {
				$("#reasonMsg").html("请输入驳回理由");
				return;
			}
			saveReason(apply_id,user_id,status,refuse_reason);
		}
		
		function saveReason(apply_id,user_id,status,refuse_reason) {
			$("#modal").css("display", "none");
			$.ajax({
				type : "GET",
				url : "/commander/saveReasonById.action",
				data : {
					apply_id:apply_id,
					refuse_reason:refuse_reason,
					status:status,
					user_id:user_id
				},
				dataType : "json",
				success : function(data) {
					if(data == 1){
						location.href = "/commander/commanderList.do";
					}else{
						$("#alertMsg").css("display", "block");
					}
				}
			});
		}
		function closeModal(apply_id) {
			$("#modal").css("display", "none");
		}
	</script>
</body>
<%-- <%-- <%@ include file="../inc/footer.html"%> --%>
</html>
