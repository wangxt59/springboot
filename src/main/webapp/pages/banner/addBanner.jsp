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
<title>添加banner</title> <script language='javascript' src="js/edit.js"></script>
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
								<form class="form-horizontal" id="addBannerFrom"
									action="/banner/addBanner.do" name="addBannerFrom"
									method="post" enctype="multipart/form-data">
									<div class="content">
										<legend><spring:message code="language.bannerCreation"/></legend>
										<!-- 1.名称 -->
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"><star>*</star>
												<spring:message code="language.bannerName"/>:</label>
												<div class="col-sm-6">
													<input class="form-control" id="name"
														name="name" placeholder="名称 :" required>
												</div>
												<span id="nameMsg" style="color: red"></span>
											</div>
										</fieldset>
										<!-- 2.展位 -->
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"><star></star>
												<spring:message code="language.bannerPosition"/>:</label>
												<div class="col-sm-6">
													<select class="form-control" id="position" name="position">
														<option value="1"><spring:message code="language.homePage" /></option>
													</select>
												</div>
												<span id="positionMsg" style="color: red"></span>
											</div>
										</fieldset>
										
										<!-- 3.banner图片 -->
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"><star>*</star>
												<spring:message code="language.bannerPic"/>:</label>
												<div class="col-sm-6">
													<input data-options="prompt:'Choose a file...'" type="file"
														id='file' name="file"
														onchange="ajaxFileUploadMY('file',1)"/> 
													<input id="imgUrl" type="hidden" name="imgUrl" />
													<img src="" id="imgUrla" style="width:100px" />
												</div>
												<span id="imgUrlMsg" style="color: red"></span>
											</div>
										</fieldset>
										
									 <!-- 4.轮播顺序 -->
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"><star>*</star>
												<spring:message code="language.bannerOrder"/>:</label>
												<div class="col-sm-6">
													<input class="form-control" id="sort"
														name="sort" placeholder="轮播顺序 :" required>
												</div>
												<span id="sortMsg" style="color: red"></span>
											</div>
										</fieldset>
										<!-- 5.链接 -->
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"> 
												<spring:message code="language.bannerLink"/>:</label>
												<div class="col-sm-6">
													<input class="form-control" id="url"
														name="url" placeholder="链接地址 :" required>
												</div>
												<span id="urlMsg" style="color: red"></span>
											</div>
										</fieldset>
										<!-- 6.是否显示 -->
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"><star></star>
												<spring:message code="language.bannerStatus"/>:</label>
												<div class="col-sm-6">
													<select class="form-control" id="isDisplay" name="isDisplay">
												    	<option value="1"><spring:message code="language.display" /></option>
														<option value="0"><spring:message code="language.noDisplay" /></option>
													</select>
												</div>
												<span id="urlMsg" style="color: red"></span>
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
			var name = $("#name").val();
			var sort = $("#sort").val();
			var imgUrl = $("#imgUrl").val();
			
			$("#nameMsg").html("");
			$("#sortMsg").html("");
			$("#imgUrlMsg").html("");
			
			if (name == "") {
				$("#nameMsg").html("请输入banner名称");
				return;
			}
			if (imgUrl == "") {
				$("#imgUrlMsg").html("请选择图片");
				return;
			}
			if (sort == "") {
				$("#sortMsg").html("请输入轮播顺序");
				return;
			}
			var params = {}
	 
			params.name = name;
			params.position =  $("#position").val();
			params.sort = sort;
			params.imgUrl = imgUrl;
			params.url =  $("#url").val();
			params.isDisplay =  $("#isDisplay").val();
			$.ajax({
				url : "/banner/addBanner.do",
				data : params,
				type : "post",
				success : function(data) {
					window.location.href="/banner/queryBannerList.do";
				},
			});
		}
		
		//返回按钮跳转到区域列表
			function goToList() {
				location.href = "/banner/queryBannerList.do";
			}
		//上传图片
			function ajaxFileUploadMY(divID,type)  
			{   
				if(divID == null){
					divID = "file";
				}
			   $.ajaxFileUpload({  
			             url:"/fileUpload/fileUpload.action",             //需要链接到服务器地址  
			             secureuri:false,  
			             dataType: "multipart/form-data", 
			             fileElementId: divID,                         //文件选择框的id属性  
			             dataType: "json",                                     //服务器返回的格式，可以是json  
			             success: function (data, status)             //相当于java中try语句块的用法  
			             {     
			                if(data.image_url!=null){
			                	 $("#imgUrl").val(data.image_url);
			                	  $("#imgUrla").attr("src",data.image_url);
			                    }
			                 },  
			                 error: function (data, status, e){  
			             }  
			           }  
			         );  
			} 
	</script>

</body>
</html>