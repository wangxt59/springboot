<%@ page language="java"
	import="java.util.*,com.website.utils.CommonsUtil"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/bootstrap.min.css" rel="stylesheet" />
<link href="/css/light-bootstrap-dashboard.css" rel="stylesheet" />
<link href="/css/common.css" rel="stylesheet" />
<link href="/css/font-awesome.min.css" rel="stylesheet">
<link href='/css/685fd913f1e14aebad0cc9d3713ee469.css' rel='stylesheet' type='text/css'>		
<link href="/css/pe-icon-7-stroke.css" rel="stylesheet" />
<title>编辑提现状态</title> 
<script src="/js/ckeditor/ckeditor.js" type="text/javascript"></script>
<script src="/js/ckfinder/ckfinder.js" type="text/javascript"></script>
<script language="JavaScript" src="/js/WdatePicker.js"></script>
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
								<form class="form-horizontal" id="updateWithdrawFrom"
									action="/userWithdraw/updateWithdraw.do" name="updateWithdrawFrom"
									method="post" enctype="multipart/form-data">
									<div class="content">
										<legend><spring:message code="language.changeWithdrawStatus"/></legend>
										
										<!-- 流水编号 -->
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"><star>*</star>
												<spring:message code="language.withdrawNumber"/>:</label>
												<div class="col-sm-6">
													<input type="hidden" id='withdrawId' name='withdrawId' value='${map.info.withdrawId}'>
													<input class="form-control" id="tradeNo" readonly="readonly" name="tradeNo" value='${map.info.tradeNo}'  required>
												</div>
												<span id="tradeNoMsg" style="color: red"></span>
											</div>
										</fieldset>
										
										<!-- 用户 -->
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"><star>*</star>
												<spring:message code="language.userID"/>:</label>
												<div class="col-sm-6">
													<input class="form-control" id="userId" readonly="readonly" name="userId" value='${map.info.userId}'  required>
												</div>
												<span id="userIDMsg" style="color: red"></span>
											</div>
										</fieldset>
										
										<!-- 提现金额 -->
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"><star>*</star>
												<spring:message code="language.withdrawTotal"/>:</label>
												<div class="col-sm-6">
													<input class="form-control" id="total" readonly="readonly" name="total" value='${map.info.total}'  required>
												</div>
												<span id="totalMsg" style="color: red"></span>
											</div>
										</fieldset>
													
										<!-- 银行名称 -->
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"><star>*</star>
												<spring:message code="language.bankName"/>:</label>
												<div class="col-sm-6">
													<input class="form-control" id="bankName" readonly="readonly" name="bankName" value='${map.info.bankName}'  required>
												</div>
												<span id="bankNameMsg" style="color: red"></span>
											</div>
										</fieldset>
										
										<!-- 卡号-->
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"><star>*</star>
												<spring:message code="language.cartNum"/>:</label>
												<div class="col-sm-6">
													<input class="form-control" id="cartNum" readonly="readonly" name="cartNum" value='${map.info.cartNum}'  required>
												</div>
												<span id="cartNumMsg" style="color: red"></span>
											</div>
										</fieldset>
										<!-- 持卡人-->
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"><star>*</star>
												<spring:message code="language.withdrawUserName"/>:</label>
												<div class="col-sm-6">
													<input class="form-control" id="name" readonly="readonly" name="name" value='${map.info.name}'  required>
												</div>
												<span id="nameMsg" style="color: red"></span>
											</div>
										</fieldset>
										
										<!-- 到账金额 -->
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"><star>*</star>
												<spring:message code="language.realTotal"/>:</label>
												<div class="col-sm-6">
													<input class="form-control" id="realTotal" readonly="readonly" name="realTotal" value='${map.info.realTotal}'  required>
												</div>
												<span id="realTotalMsg" style="color: red"></span>
											</div>
										</fieldset>
										
										<!-- 提现状态 -->
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"><star></star>
												<spring:message code="language.withdrawStatus"/>:</label>
												<div class="col-sm-6">
													<select class="form-control" id="status" name="status">
														<option value="1" ${map.info.status == '1'?'selected':''} ><spring:message code="language.inWithdraw" /></option>
														<option value="2" ${map.info.status == '2'?'selected':''} ><spring:message code="language.withdrawSuccess" /></option>
														<option value="3" ${map.info.status == '3'?'selected':''} ><spring:message code="language.withdrawFailure" /></option>
													</select>
												</div>
												<span id="statusMsg" style="color: red"></span>
											</div>
										</fieldset>
									</div>

									<div class="footer text-center">
										<button type="button" class="btn btn-info btn-fill btn-wd"
											id="doSubmit" onclick="updateWithdraw();"><spring:message code="language.determineBtn"/></button>
										<button type="button" class="btn btn-fill btn-wd" onclick="goToList();"><spring:message code="language.backBtn"/></button>
									</div>

								</form>
							</div>
							<!--  end card  -->
						</div>
						<!-- end col-md-12 -->
					</div>
					<!-- end row -->
				</div>

			</div>
			<!-- 内容table结束 -->

			<!-- 底部开始 -->
			<jsp:include page="/pages/inc/footer.jsp"></jsp:include>
			<!-- 底部结束 -->
		</div>
	</div>

	<script type="text/javascript">
		function updateWithdraw() {
			var status = $("#status").val();
			$("#statusMsg").html("");
			
			if (status == "") {
				$("#statusMsg").html("请选择提现状态");
				return;
			}
			var params = {}
			params.withdrawId =  $("#withdrawId").val();
			params.status = status;
			$.ajax({
				url : "/userWithdraw/updateWithdraw.do",
				data : params,
				type : "post",
				success : function(data) {
					window.location.href="/userWithdraw/queryWithdrawList.do";
				},
			});
		}
		
		//返回列表
			function goToList() {
				location.href = "/userWithdraw/queryWithdrawList.do";
			}
	 
	</script>

</body>
</html>