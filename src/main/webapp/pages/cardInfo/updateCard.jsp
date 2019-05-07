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
<title>修改卡</title> <script language='javascript' src="js/edit.js"></script>
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
								<form class="form-horizontal" id="updateCardFrom"
									action="/cardInfo/updateCard.do" name="updateCardFrom"
									method="post" enctype="multipart/form-data">
									<div class="content">
										<legend><spring:message code="language.CardEdit"/></legend>
										<!-- 1.卡号 -->
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"><star>*</star>
												<spring:message code="language.cardNum"/>:</label>
												<div class="col-sm-6">
													<input type="hidden" id='cardId' name='cardId' value='${map.info.cardId}'>
													<input class="form-control" id="cardNum" name="cardNum" value='${map.info.cardNum}'  required>
												</div>
												<span id="cardNumMsg" style="color: red"></span>
											</div>
										</fieldset>
									 <!-- 卡密 -->
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"><star>*</star>
												<spring:message code="language.carmine"/>:</label>
												<div class="col-sm-6">
													<input class="form-control" id="carmine"  value='${map.info.carmine}' name="carmine" required>
												</div>
												<span id="carmineMsg" style="color: red"></span>
											</div>
										</fieldset>
									 
										<!-- 卡状态 -->
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"><star></star>
												<spring:message code="language.status"/>:</label>
												<div class="col-sm-6">
													<select class="form-control" id="status" name="status">
														<option value="0" ${map.info.status ==0?'checked':''}><spring:message code="language.unsold"/></option>
														<option value="1"  ${map.info.status ==1?'checked':''}><spring:message code="language.sold" /></option>
												 		<option value="2"  ${map.info.status ==2?'checked':''}><spring:message code="language.extracted" /></option>
													</select>
												</div>
												<span id="statusMsg" style="color: red"></span>
											</div>
										</fieldset>
									</div>

									<div class="footer text-center">
										<button type="button" class="btn btn-info btn-fill btn-wd"
											id="doSubmit" onclick="checkInfo();"><spring:message code="language.determineBtn"/></button>
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
		function checkInfo() {
			var cardNum = $("#cardNum").val();
			var carmine = $("#carmine").val();
			var status = $("#status").val();
			
			$("#cardNumMsg").html("");
			$("#carmineMsg").html("");
			$("#statusMsg").html("");
			
			if (cardNum == "") {
				$("#cardNumMsg").html("请输入卡号");
				return;
			}
			if (carmine == "") {
				$("#carmineMsg").html("请输入卡密");
				return;
			}
			if (status == "") {
				$("#statusMsg").html("请选择卡状态");
				return;
			}
			var params = {}
	 
			params.cardId =  $("#cardId").val();
			params.cardNum = cardNum;
			params.carmine = carmine;
			params.status = status;
			$.ajax({
				url : "/cardInfo/updateCard.do",
				data : params,
				type : "post",
				success : function(data) {
					window.location.href="/cardInfo/queryCardList.do";
				},
			});
		}
		
		//返回列表
			function goToList() {
				location.href = "/cardInfo/queryCardList.do";
			}
	 
	</script>

</body>
</html>