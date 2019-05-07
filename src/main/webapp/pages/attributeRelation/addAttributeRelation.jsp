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
<style>
.select{
height:38px;line-height:38px;border-radius:5px;border:1px solid #12101066;width:200px;
}
</style>
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
								<form class="form-horizontal" id="addAttributeFrom"
									action="/attributeRelation/insertAttributeRelation.do" name="addAttributeFrom"
									method="post" enctype="multipart/form-data">
									<div class="content">
										<legend><spring:message code="language.attrCreation"/></legend>
										<!-- 1.分类名称 -->
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"><star>*</star>
												<spring:message code="language.attrName"/>:</label>
												<div class="col-sm-6">
													<input class="form-control" id="attr_name" name="attr_name" placeholder="名称 :" required>
												</div>
												<span id="attr_nameMSG" style="color: red"></span>
											</div>
										</fieldset>
						 
										
									 <!-- 4.所属分类 -->
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"><star>*</star>
												<spring:message code="language.attrCategory"/>:</label>
												<div class="col-sm-6">
													<select id="typeGrand" name="parent_id" class="select" onchange="getSecondType();">
														<option value="">全部</option>
														<c:forEach items="${map.categoryList}" var="c">
															<option value="${c.category_id}" ${map.parent_id == c.category_id?'selected':''}>
																 <c:out value="${c.category_name}"/>
															</option>
														</c:forEach>
													</select>
													<select  id="typeParent" name="child_id" class="select" onchange="getThridType();">
														<option value="">全部</option>
													</select>
													<select id="typeThrid" name="category_id" class="select">
														<option value="">全部</option>
													</select>
												</div>
											<span id="categoryMSG" style="color: red"></span>
											</div>
										</fieldset>
								 
										<!-- 6.属性值 -->
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"><star>*</star>
												<spring:message code="language.attrValue"/>:</label>
												<div class="col-sm-6" >
													 <input class="select" type="text" id="array" name="array" value="" maxlength="10"/>
												     <input type="button" id = "append" value=" + "/>
												</div>
												<span id="value_nameMSG" style="color: red"></span> 
											</div>
										</fieldset>
										
										<!-- 6.属性值 -->
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"><star></star></label>
												<div class="col-sm-6" id="left" >
												</div>
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
	
	 $(document).ready(function(){
		  $("#append").click(function(){
		    $("#left").append(" <input type='text' id='array' name='array' value='' class='select' maxlength='6'/>"
		    		+"<span id='value_nameMSG' style='color: red'></span><br/>");
		  });
		});
	
	//一级业务类型级联事件
	 function getSecondType(){
	 	var grandid = $('#typeGrand').val();
	 	$('#typeParent').empty();
	 	$("#typeParent").prepend("<option value=''>全部</option>");
	 	
	 	$('#typeThrid').empty();
	 	$("#typeThrid").prepend("<option value=''>全部</option>");
	 	var url = "/category/getSecondType.do";
	 	var params = {
	 		"category_id" : grandid
	 	};
	 	var defaultText = "全部";
	 	var target = "#typeParent";
	 	if (grandid != "") {
	 		addCategoryOptions(url, params, defaultText, target);
	 	} else {
	 		$(target).html("<option value=''>" + defaultText
	 				+ "</option>");
	 	}
	 }

	 //添加三级
	 function getThridType(){
	 	var url = "/category/getSecondType.do";
	 	var secondid = $('#typeParent').val();
	 	$('#typeThrid').empty();
	 	//$("#typeThrid").prepend("<option value=''>全部</option>");
	 	var target = "#typeThrid";
	 	var defaultText = "全部";
	 	if(secondid!=null && secondid!=''){
	 		var params = {
	 				"category_id" : secondid
	 			};
	 		addCategoryOptions(url, params, defaultText, target);
	 	} else {
	 		$(target).html("<option value=''>" + defaultText
	 				+ "</option>");
	 	}
	 }
	 //级联添加业务类型select选项
	 var addCategoryOptions = function(url, params, defaultText, target) {
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
 
	 function checkInfo(){
			var attr_name = jQuery("#attr_name").val();
			var array = jQuery("#array").val();
			var parent_id = $("#typeGrand").val();
			var child_id = $("#typeParent").val();
			var category_id = $("#typeThrid").val();
			
			jQuery("#attr_nameMSG").html("");
			jQuery("#value_nameMSG").html("");

			if(attr_name == ""){
				jQuery("#attr_nameMSG").html("请输入属性名称");
				document.getElementById("attr_name").focus();return;
			}
			if(parent_id == ""){
				$("#categoryMSG").html("请选择一级分类");return;
			}
			if(child_id == ""){
				$("#categoryMSG").html("请选择二级分类");return;
			}
			if(category_id == ""){
				$("#categoryMSG").html("请选择三级分类");return;
			}
			if(array == ""){
				jQuery("#value_nameMSG").html("请输入属性值");
				document.getElementById("array").focus();return;
			}
			document.addAttributeFrom.submit();
		}
		
		//返回按钮跳转到区域列表
			function goToList() {
				location.href = "/attributeRelation/selectAttributeRelationList.do";
			}
	 
	</script>

</body>
</html>