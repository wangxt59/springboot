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
<title>自提点详情</title>
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

.select {
	height: 38px;
	line-height: 38px;
	border-radius: 5px;
	border: 1px solid #ddd;
	width: 100%
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
					<form action="/deliveryPoint/getseMePointById.action"
						name="categoryform" id="categoryform" method="post"
						accept-charset="utf-8">
						<div class="row">
							<div class="col-md-12">
								<div class="card">
									<div class="content">
										<legend>自提点详情</legend>
										<!-- 1.商品名称 -->
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label">
													自提点名称:&nbsp;&nbsp;&nbsp;<c:out
														value="${map.seMePoint.point_name}" />
												</label> <label class="col-sm-2 control-label">
													自提点地点：&nbsp;&nbsp;&nbsp;<c:out
														value="${map.seMePoint.address}" />
												</label> <label class="col-sm-2 control-label">
													自提点经度:&nbsp;&nbsp;&nbsp;<c:out
														value="${map.seMePoint.longitude}" />
												</label> <label class="col-sm-2 control-label">
													自提点纬度:&nbsp;&nbsp;&nbsp;<c:out
														value="${map.seMePoint.latitude}" />
												</label> <label class="col-sm-2 control-label">
													手机号:&nbsp;&nbsp;&nbsp;<c:out
														value="${map.seMePoint.contact}" />
												</label> <label class="col-sm-2 control-label">
													团长真实姓名:&nbsp;&nbsp;&nbsp;<c:out
														value="${map.seMePoint.real_name}" />
												</label> <label class="col-sm-2 control-label">
													团长微信昵称:&nbsp;&nbsp;&nbsp;<c:out
														value="${map.seMePoint.nick_name}" />
												</label>
												<c:if test="${map.seMePoint.status == 0}">
													<label class="col-sm-2 control-label"> 状
														态:&nbsp;&nbsp;&nbsp;<c:out value="已删除" />
													</label>
												</c:if>

												<c:if test="${map.seMePoint.status == 1}">
													<label class="col-sm-2 control-label"> 状
														态:&nbsp;&nbsp;&nbsp;<c:out value="使用中" />
													</label>
												</c:if>
												<c:if test="${map.seMePoint.status == 2}">
													<label class="col-sm-2 control-label"> 状
														态:&nbsp;&nbsp;&nbsp;<c:out value="审核中" />
													</label>
												</c:if>
												<c:if test="${map.seMePoint.status == 3}">
													<label class="col-sm-2 control-label"> 状
														态:&nbsp;&nbsp;&nbsp;<c:out value="审核失败" />
													</label>
												</c:if>
												<c:if
													test="${map.seMePoint.refuse_reason != null && map.seMePoint.refuse_reason != ''}">
													<label class="col-sm-2 control-label">
														拒绝理由:&nbsp;&nbsp;&nbsp; <c:out
															value="${map.seMePoint.refuse_reason}" />
													</label>
												</c:if>
											</div>
										</fieldset>
									</div>
									<div class="footer text-center">
										<c:if test="${map.seMePoint.status == 2}">
											<button type="button" class="btn btn-info btn-fill btn-wd"
												data-toggle="modal" data-target="#myModal">通过</button>
											<button type="button" class="btn btn-info btn-fill btn-wd"
												id="doSubmit" onclick="refusePoint();">拒绝</button>
										</c:if>
										<input type="button" class="btn btn-fill btn-wd" name="Submit"
											onclick="javascript:history.back(-1);" value="返回">
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
							<button type="button" onclick="setPass(${map.seMePoint.id},${map.seMePoint.user_id})"
								class="btn btn-success btn-fill">确定</button>
							<button type="button" class="btn btn-default btn-simple"
								data-dismiss="modal">关闭</button>
						</div>
					</div>
				</div>
			</div>
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
								onclick="saveRefuse(${map.seMePoint.id},${map.seMePoint.user_id})">确定</button>
							<button type="button" style="margin: 10px;"
								class="btn btn-default btn-fill btn-wd" onclick="closeModal()">关闭</button>
						</div>
					</div>
				</div>
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
	function refusePoint() {
		$("#modal").css("display", "block");
	}
	
	function setPass(id,userid){
		var status = 1;
		var refuse_reason = "";
		saveReason(id,userid,status,refuse_reason);
	}
	
	function saveRefuse(id,user_id){
		var status = 3;
		var refuse_reason = $("#reasonText").val();
		if (refuse_reason == "" || refuse_reason == null) {
			$("#reasonMsg").html("请输入驳回理由");
			return;
		}
		saveReason(id,user_id,status,refuse_reason);
	}
	
	function saveReason(id,user_id,status,refuse_reason) {
		$("#modal").css("display", "none");
		$.ajax({
			type : "GET",
			url : "/deliveryPoint/saveReasonById.action",
			data : {
				id:id,
				refuse_reason:refuse_reason,
				status:status,
				user_id:user_id
			},
			dataType : "json",
			success : function(data) {
				if(data == 1){
					location.href = "/deliveryPoint/seMePointList.do";
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
