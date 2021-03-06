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
<title>添加分类</title> <script language='javascript' src="js/edit.js"></script>
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
								<form class="form-horizontal" id="updateCategoryFrom"
									action="/category/updateCategory.do" name="updateCategoryFrom"
									method="post" enctype="multipart/form-data">
									<div class="content">
										<legend><spring:message code="language.categoryCreation"/></legend>
										<!-- 1.分类名称 -->
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"><star>*</star>
												<spring:message code="language.categoryName"/>:</label>
												<div class="col-sm-6">
												    <input type="hidden" id='category_id' name='category_id' value='${map.category.category_id}'>
													<input class="form-control" id="category_name" name="category_name" value='${map.category.category_name}' placeholder="名称 :" required>
												</div>
												<span id="category_nameMsg" style="color: red"></span>
											</div>
										</fieldset>
										 
										<!-- 3.图片 -->
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"><star>*</star>
												<spring:message code="language.bannerPic"/>:</label>
												<div class="col-sm-6">
													<input data-options="prompt:'Choose a file...'" type="file"
														id='file' name="file"
														onchange="ajaxFileUploadMY('file',1)"/> 
													<input id="category_pic" type="hidden" name="category_pic" value="${map.category.category_pic}" />
													<img src="${map.category.category_pic}" id="category_pica" style="width:100px" />
												</div>
												<span id="category_picMsg" style="color: red"></span>
											</div>
										</fieldset>
										
									 <!-- 4.一级分类 -->
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"><star></star>
												<spring:message code="language.firstCategory"/>:</label>
												<div class="col-sm-6">
													<select class="form-control" id="parent_id" name="parent_id" onchange="getSecondType()">
												    	<option value="">无</option>
														<c:forEach items="${map.categoryList}" varStatus="item" var="c">
															<c:if test="${map.category.rank==1}">
																<option value="${c.category_id}">${c.category_name}</option>
															</c:if>
															<c:if test="${map.category.rank==2}">
																<option value="${c.category_id}" ${map.category.parent_id == c.category_id?'selected':''}>${c.category_name}</option>
															</c:if>
															<c:if test="${map.category.rank==3}">
																<option value="${c.category_id}" ${map.secondCategory.parent_id == c.category_id?'selected':''}>${c.category_name}</option>
															</c:if>
														</c:forEach>
													</select>
												</div>
												<span id="showMsg" style="color: red"></span>
											</div>
										</fieldset>
										<!-- 5.二级分类 -->
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"> 
												<spring:message code="language.secondCategory"/>:</label>
												<div class="col-sm-6">
													<select class="form-control" id="second_id" name="second_id" >
														<option value="">无</option>
														<c:forEach items="${map.secondCategoryList}" varStatus="item" var="s">
															<c:if test="${map.category.rank==2}">
																<option value="${s.category_id}">${s.category_name}</option>
															</c:if>
															<c:if test="${map.category.rank==3}">
																<option value="${s.category_id}" ${s.category_id == map.category.parent_id?'selected':''}>${s.category_name}</option>
															</c:if>
														</c:forEach>
													</select>
												</div>
												<span id="show2Msg" style="color: red"></span>
											</div>
										</fieldset>
										<!-- 6.是否显示 -->
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"><star></star>
												<spring:message code="language.categoryStatus"/>:</label>
												<div class="col-sm-6">
													<select class="form-control" id="is_show" name="is_show">
												    	<option value="1"><spring:message code="language.display" /></option>
														<option value="2"><spring:message code="language.noDisplay" /></option>
													</select>
												</div>
												<span id="showMsg" style="color: red"></span>
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
	
	function getSecondType(){
		
		var grandid = $('#parent_id').val();
		$('#second_id').empty();
		$("#second_id").prepend("<option value=''>--请选择--</option>");
		$("#second_id").val('');
		//var url = "/data/selectCategoryList.do";
		var url = "/category/getSecondType.do";
		var params = {
			//"categoryParentno" : grandid
				"category_id":grandid
		};
		var defaultText = "--请选择--";
		var target = "#second_id";
		if (grandid != "") {
			addOptions(url, params, defaultText, target);
		} else {
			$(target).html("<option value=''>" + defaultText
					+ "</option>");
		}
	}
	//级联添加业务类型select选项
	var addOptions = function(url, params, defaultText, target) {
		$.getJSON(url, params, function(list) {
			var options = "";
			options = "<option value=''>" + defaultText + "</option>";
			if (list != "[]" && typeof list != "undefined") {
				for (var i = 0; i < list.length; i++) {
					options += "<option value='" + list[i].category_id + "'>"
							+ list[i].category_name + "</option>";
				}
			}
			$(target).html(options);
		});
	}
	
		function checkInfo() {
			var category_name = $("#category_name").val();
			var category_pic = $("#category_pic").val();
			
			$("#category_nameMsg").html("");
			$("#category_picMsg").html("");
			
			if (category_name == "") {
				$("#category_nameMsg").html("请输入分类名称");
				return;
			}
			if (category_pic == "") {
				$("#category_picMsg").html("请选择图片");
				return;
			}
			document.updateCategoryFrom.submit();
			 
		}
		
		//返回按钮跳转到区域列表
			function goToList() {
				location.href = "/category/selectCategoryList.do";
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
			                	 $("#category_pic").val(data.image_url);
			                	  $("#category_pica").attr("src",data.image_url);
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