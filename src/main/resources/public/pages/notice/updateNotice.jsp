<%@ page language="java"
	import="java.util.*,com.antke.website.utils.CommonsUtil"
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
<title>添加公告</title> 
<script type="text/javascript" src="/js/ueditor1.4.3.3/ueditor.config.js"></script>
<script type="text/javascript" src="/js/ueditor1.4.3.3/ueditor.all.js"></script>
<script language='javascript' src="/js/jquery-1.8.3.min.js"></script>
<script language="javascript" src="/js/My97DatePicker/WdatePicker.js"></script>
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
								<form class="form-horizontal" id="updateNoticeFrom"
									action="/notice/updateNotice.do" name="updateNoticeFrom"
									method="post" enctype="multipart/form-data">
									<div class="content">
										<legend><spring:message code="language.noticeEdit"/></legend>
										<!-- 1.名称 -->
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"><star>*</star>
												<spring:message code="language.noticeName"/>:</label>
												<div class="col-sm-6">
													<input type="hidden" id='id' name='id' value='${map.info.id}'>
													<input class="form-control" value='${map.info.title}' id="title" name="title" placeholder="名称 :" required>
												</div>
												<span id="nameMsg" style="color: red"></span>
											</div>
										</fieldset>
										  <!-- 3.语言 -->
										 <%-- <fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"><star>*</star>
												<spring:message code="language.language"/>:</label>
												<div class="col-sm-6">
													<select id="languageId" name="languageId" class="form-control"  data-title="<spring:message code="language.language" />">
													  <option value=""><spring:message code="language.language" /></option>
														<c:forEach items="${map.languageList}" var="l">
															<option value="${l.id}" ${map.info.languageId == l.id?'selected':''}>${l.name}</option>
														</c:forEach>
													</select>
												</div>
											<span id="languageMSG" style="color: red"></span>
											</div>
										</fieldset> --%>
										 <!-- 4.渠道 -->
										 <%-- <fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"><star>*</star>
												<spring:message code="language.channel"/>:</label>
												<div class="col-sm-6">
													<select id="channelId" name="channelId" class="form-control" data-title="<spring:message code="language.channel" />">
													  <option value=""><spring:message code="language.channel"/></option>
														<c:forEach items="${map.channelList}" var="cl">
															<option value="${cl.id}" ${map.info.channelId == cl.id?'selected':''}>${cl.name}</option>
														</c:forEach>
													</select>
												</div>
											<span id="channelMSG" style="color: red"></span>
											</div>
										</fieldset>--%>
										
										<!-- 状态-->
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"><star></star>
												<spring:message code="language.noticeStatus"/>:</label>
												<div class="col-sm-6">
													<select class="form-control" id="status" name="status">
												    	<option value="1" ${map.info.status == '1'?'selected':''}><spring:message code="language.display" /></option>
														<option value="0" ${map.info.status == '0'?'selected':''} ><spring:message code="language.noDisplay" /></option>
													</select>
												</div>
												<span id="statusMsg" style="color: red"></span>
											</div>
										</fieldset> 
										
											<!-- 公告内容-->
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"><star>*</star>
												<spring:message code="language.noticeContent"/>
													:</label>
												<div class="col-sm-6">
												    <textarea id="ta_ckeditor" name="content" class="ckeditor" cols="20"  style="overflow:auto">
													 ${map.info.content}
													</textarea>
												</div>
												<span id="contentMsg" style="color: red"></span>
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
	
	
	$(function(){
		var ue = UE.getEditor("ta_ckeditor"); 
		UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
		UE.Editor.prototype.getActionUrl = function(action){
	    	//调用自己写的Controller
	    	if(action == 'uploadimage' || action == 'uploadfile'){
	    		return "/imageUpload/upload.do"; //自己controller的action
	    	}else if(action == "uploadvideo"){
	    		return "";//自己controller的action
	    	}else{
	    		return this._bkGetActionUrl.call(this,action);//百度编辑器默认的action
	    	}
	    }
	});
	
		function checkInfo() {
			var title = $("#title").val();
			var content =UE.getEditor("ta_ckeditor").getContent(); 
			var status = $("#status").val();
			
			$("#nameMsg").html("");
			$("#contentMsg").html("");
			$("#statusMsg").html("");
			
			if (title == "") {
				$("#nameMsg").html("请输入公告名称");
				return;
			}
			
			if (content == "") {
				$("#contentMsg").html("请输入公告内容");
				return;
			}
			if (status == "") {
				$("#statusMsg").html("请选择状态");
				return;
			}
			
			var params = {}
			params.title = title;
			params.content = content;
			params.status = status;
			params.id =  $("#id").val();
			$.ajax({
				url : "/notice/updateNotice.do",
				data : params,
				type : "post",
				success : function(data) {
					window.location.href="/notice/queryNoticeList.do";
				},
			});
		}
		
		//返回按钮跳转到区域列表
			function goToList() {
				location.href = "/notice/queryNoticeList.do";
			}
	</script>

</body>
</html>