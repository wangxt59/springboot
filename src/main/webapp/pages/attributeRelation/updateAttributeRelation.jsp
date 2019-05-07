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
<title>修改分类</title> <script language='javascript' src="js/edit.js"></script>
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
								<form class="form-horizontal" id="updateAttributeFrom"
									action="/attributeRelation/updateAttributeRelation.do" name="updateAttributeFrom"
									method="post" enctype="multipart/form-data">
									<div class="content">
										<legend><spring:message code="language.attrEdit"/></legend>
										<!-- 1.分类名称 -->
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"><star>*</star>
												<spring:message code="language.attrName"/>:</label>
												<div class="col-sm-6">
													<input type="hidden" value="${map.value_id_Str}" id="value_id_Str" name="value_id_Str"/>
			          								<input type="hidden" value="${map.attr_id}" id="attr_id" name="attr_id" />
													<input class="form-control" id="attr_name" name="attr_name" value="${map.attribute.attr_name}" placeholder="名称 :" required>
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
														<c:forEach items="${map.parentCategoryList}" var="p">
															<option value="${p.category_id}" ${map.parent_id == p.category_id?'selected':''}>
																 <c:out value="${p.category_name}"/>
															</option>
														</c:forEach>
													</select>
													<select  id="typeParent" name="child_id" class="select" onchange="getThridType();">
														<option value="">全部</option>
														<c:forEach items="${map.childCategoryList}" var="c">
															<option value="${c.category_id}" ${map.child_id == c.category_id?'selected':''}>
																 <c:out value="${c.category_name}"/>
															</option>
														</c:forEach>
													</select>
													<select id="typeThrid" name="category_id" class="select">
														<option value="">全部</option>
														<c:forEach items="${map.categoryList}" var="ca">
															<option value="${ca.category_id}" ${map.category_id == ca.category_id?'selected':''}>
																 <c:out value="${ca.category_name}"/>
															</option>
														</c:forEach>
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
														<input type="hidden" id='str1' name='value_name' value=''/>
														<c:forEach items="${map.attributeValueList}" varStatus="item" var="c">
													    	<input id="a${c.value_id}" class="del" type="button" onclick="delText('${c.value_id}','${c.relation_id}')"  style="position: absolute; left: 210px; margin-top:5px;font-size:14px; text-decoration: none; z-index: 1" value="X"/>
															<input class="select" id="${c.value_id}"  style="position: relative"  name="value_name_str" type="text" value="${c.value_name}"/>
															<br />
														</c:forEach>
														 <input type="hidden" id='str2' name='value_name_new' value=''/>
													     <input type="button" id = "append"  style="float: right;margin-top: -34px;margin-right: 480px;" value=" + "/>
 					
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
		    $("#left").append(" <input type='text' id='value_name_new_str' name='value_name_new_str' value='' class='select'/>"
		    		+"<span id='value_name_newMSG' style='color: red'></span><br/>");
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
			var attr_name = jQuery('#attr_name').val();
			var value_name = jQuery('#value_name').val();
			jQuery("#attr_nameMsg").html("");
			jQuery("#value_nameMSG").html("");
			var parent_id = $("#typeGrand").val();
			var child_id = $("#typeParent").val();
			var category_id = $("#typeThrid").val();
			
			if(attr_name == ""){
				jQuery('#attr_nameMsg').html("请输入属性名称");
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
			if(value_name == ""){
				jQuery('#value_nameMSG').html("请输入属性值");
				document.getElementById("value_name").focus();return;
			}
			var str = list("value_name_str");
			jQuery("#str1").val(str);
			var str = list("value_name_new_str");
			jQuery("#str2").val(str);
			document.updateAttributeFrom.submit();
		}
		var  list = function(name){
			var array = new Array();
			var str = "";
			array = document.getElementsByName("" + name);
			for(var i = 0;i < array.length;i++){
				str += array[i].value + ",";
			}
			str = str.substring(0,str.length-1);
			return str;
		}

	 
	//删除属性值
	 function delText(value_id,relation_id){
	 	 $.ajax({
	          url: "/attributeRelation/delAttribute.do?value_id="+value_id+"&relation_id="+relation_id,
	          type: "POST",
	          dataType: "json",
	          async: false,
	          success: function(data) {
        		var code = data.code;
				if (code == "OK") {
	 		    	$("#"+value_id).remove();
	 		    	$("#a"+value_id).remove();
	 		    }
	          },
	          error: function() {
	          }
	        });	
	 }
		
		//返回按钮跳转到区域列表
			function goToList() {
				location.href = "/attributeRelation/selectAttributeRelationList.do";
			}
	 
	</script>

</body>
</html>