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
<title>商品分类管理</title>
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
</head>
<style>
.fixed-table-toolbar {
	width: 100%;
	overflow: hidden;
}
</style>
<style>
.select {
	height: 38px;
	line-height: 38px;
	border-radius: 5px;
	border: 1px solid #ddd;
	width: 180px;
	float:left
}
.col-sm-6{width:600px}
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
					<form action="/category/selectCategoryList.do" name="categoryform"
						id="categoryform" method="post" accept-charset="utf-8">
						<div class="row">
							<div class="col-md-12">
								<div class="card">
									<div class="header">
										<h4 class="title">
											<spring:message code="language.categoryallb" />
										</h4>
									</div>
									<!-- 一级分类 -->
									<div class="col-md-2" >
										<div class="form-group" >
										<select  id="typeGrand" name="parent_id" class="select" onchange="getSecondType();" style="width:95%">
											<option value="">一级分类</option>
											<c:forEach items="${map.categoryList}" var="c">
												<option value="${c.category_id}" ${map.parent_id == c.category_id?'selected':''}>
													 <c:out value="${c.category_name}"/>
												</option>
											</c:forEach>
										</select>
										</div>
									</div>
									<div class="col-md-2">
										<div class="form-group">
										<select  id="typeParent" name="child_id" class="select" onchange="getThridType();" style="width:95%">
											<option value="">二级分类</option>
										</select>
										</div>
									</div>
									<!-- <div class="col-md-2">
										<div class="form-group">
											<select id="typeThrid" name="categoryId" class="selectpicker" onchange="getAttrbuteList();">
												<option value="">三级分类</option>
											</select>
										</div>
										<span id="categoryMSG" style="color: red"></span>
									</div> -->
									<div class="col-md-2">
		                            	<div class="form-group">
		                                  <select  id="is_show" name="is_show" class="selectpicker" data-title="<spring:message code="language.categoryStatus" />" data-style="btn-default btn-block" data-menu-style="dropdown-blue">
												<option value="2" ${map.is_show == '2'?'selected':''} ><spring:message code="language.noDisplay" /></option>
												<option value="1" ${map.is_show == '1'?'selected':''} ><spring:message code="language.display" /></option>
		                                  </select>
		                                  </div>
		                            </div>
								   <div class="col-md-2">
		                                <div class="form-group">
		                                    <input type="text" placeholder="<spring:message code="language.categoryName" />" class="form-control"  id="category_name" name="category_name" 
		                                    value="${map.category_name}" size="15"/>
		                                </div>
		                            </div>
									<div class="footer">
										<button class="btn btn-info btn-fill btn-wd" type="button"
											onclick="newCategory();">
											<spring:message code="language.categoryCreation" />
										</button>
										<button class="btn btn-info btn-fill btn-wd" type="submit">
											<spring:message code="language.queryBtn" />
										</button>
										 <button class="btn btn-default btn-fill btn-wd"
											onclick="resetInfo();">
											<spring:message code="language.resetBtn" />
										</button> 
									</div>
									
									<div class="card margintop20">
										<table class="table">
											<thead>
												<th class="text-center"><spring:message
														code="language.categoryNumber" /></th>
												<th>分类图片</th>
												<th><spring:message code="language.categoryName" /></th>
												<th><spring:message code="language.categorylLevel" /></th>
												<th><spring:message	code="language.categoryParent" /></th>
												<th><spring:message code="language.categoryStatus" /></th>
												<th><spring:message code="language.createDate" /></th>
												<th><spring:message code="language.operator" /></th>
												<th data-field="actions"><spring:message
														code="language.operation" /></th>
											</thead>
											<tbody>
												<c:forEach items="${map.pageInfo.datas}" varStatus="item"
													var="m">
													<tr>
														<td class="tcenter text-center"><c:out
																value="${m.category_id}" /></td>
														<td class="tcenter">
																<img src="${m.category_pic}"  style="width:60px;"  />
															</td>
															
														<td class="tcenter"><c:out value="${m.category_name}" /></td>
														<td class="tcenter"><c:out value="${m.rank}" /></td>
														<td class="tcenter"><c:out value="${m.parent_name}" /></td>
														
														<td class="tcenter"><c:if test="${m.is_show=='2'}">
																<spring:message code="language.noDisplay" />
															</c:if> <c:if test="${m.is_show=='1'}">
																<spring:message code="language.display" />
															</c:if></td>
														<td class="tcenter"><fmt:formatDate
																value="${m.create_date}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
														<td class="tcenter"><c:out value="${m.operator}" /></td>
														<td class="tcenter" id="">
														<a	href="javascript:editCategory('${m.category_id}');"
															title="<spring:message code="language.BJ"/>"><spring:message code="language.BJ" /></a>&nbsp;&nbsp; 
														<a 	href="javascript:deleteCategory('${m.category_id}','${m.rank}');"
															title="<spring:message code="language.deleteBtn"/>"><spring:message
																	code="language.deleteBtn" /></a>&nbsp;&nbsp;</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
								<!--  end card  -->
								<div class="newpages">
									<%@include file="/page/page.jsp"%>
								</div>
							</div>
							</div>
							<!-- end col-md-12 -->
						</div>
						<!-- end row -->
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
		var $table = $('#bootstrap-table');
		function operateFormatter(value, row, index) {
			return [
				'<a rel="tooltip" title="View" class="btn btn-simple btn-info btn-icon table-action view" href="javascript:void(0)">',
				'<i class="fa fa-image"></i>',
				'</a>',
				'<a rel="tooltip" title="Edit" class="btn btn-simple btn-warning btn-icon table-action edit" href="javascript:void(0)">',
				'<i class="fa fa-edit"></i>',
				'</a>',
				'<a rel="tooltip" title="Remove" class="btn btn-simple btn-danger btn-icon table-action remove" href="javascript:void(0)">',
				'<i class="fa fa-remove"></i>',
				'</a>'
			].join('');
		}
	
		$().ready(function() {
			window.operateEvents = {
				'click .view' : function(e, value, row, index) {
					info = JSON.stringify(row);
	
					swal('You click view icon, row: ', info);
					console.log(info);
				},
				'click .edit' : function(e, value, row, index) {
					info = JSON.stringify(row);
	
					swal('You click edit icon, row: ', info);
					console.log(info);
				},
				'click .remove' : function(e, value, row, index) {
					console.log(row);
					$table.bootstrapTable('remove', {
						field : 'id',
						values : [ row.id ]
					});
				}
			};
	
			$('[rel="tooltip"]').tooltip();
	
			$(window).resize(function() {
				$table.bootstrapTable('resetView');
			});
		});
	</script>
	<script type="text/javascript">
		//重置搜索内容
		function resetInfo() {
			 $("#typeGrand").val("");
			 $("#typeParent").val("");
			 $("#three").val("");
			 $("#is_show").val("");
			 $("#category_name").val("");
		}
		
		
		// 一级业务类型级联事件
		function getSecondType(){
			
			var grandid = $("#typeGrand").val();
			$("#typeParent").html("");
			
			var url = "/category/getSecondType.do";
			var params = {
				"category_id" : grandid
			};
			var defaultText = "全部";
			var target = "#typeParent";
			if (grandid != "") {
				addOptions(url, params, defaultText, target);
			} else {
				$("#typeParent").html("<option value=''>" + defaultText
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
	 //查询属性
		function getAttrbuteList() {
			var typeThrid = $("#typeThrid").val();
		 	if(typeThrid!=null && typeThrid!=''){
				jQuery.ajax({
					url : "/attributeRelation/getAttrbuteByCateId.do",
					data : {
						"category_id" : typeThrid
					},
					type : "post",
					dataType : "json",
					success : function(data) {
						var attr_html = "";
						for (var one in data) {
							var attr_id = data[one].attr_id;
							var attr_name = data[one].attr_name;
							attr_html+='<label style="text-transform:none">';
							attr_html+='<input type="checkbox" onclick="attrCheck('+attr_id+',\''+attr_name+'\')" id="attrId'+attr_id+'" name="attr_id"   value="'+attr_id+'" />'+attr_name+'</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
						}
						attr_html+='<span id="attrMsg" style="color: red"></span>';
						$("#attr").html(attr_html);
						$("#attrdiv").show();
						$("#attrTableBody").html("");
						$("#skudiv").hide();
						$("#goods_sku").html("");
					},
				});
		 	}
		}
		
	
		
		// 级联添加业务类型select选项
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
			 
				$("#typeParent").html(options);
			});
		}
		
		
		//删除分类
		function deleteCategory(category_id,rank) {
			var content = "<spring:message code='language.deleteCategory' />？";
			swal({
				title : "<spring:message code='language.modalTitle' />?",
				text : content,
				type : "warning",
				showCancelButton : true,
				confirmButtonText : "<spring:message code='language.determineBtn' />",
				cancelButtonText : "<spring:message code='language.cancelBtn' />",
				closeOnConfirm : false,
				closeOnCancel : true
			}, function(isConfirm) {
				if (isConfirm) {
					queryCateExtendAttrIsExist(category_id,rank);
				}
			});
	
		}
	
		//删除的修改状态
		function queryCateExtendAttrIsExist(category_id,rank) {
			jQuery.ajax({
				url:"/attributeRelation/queryCateExtendAttrIsExist.do",
				data:{
					"category_id":category_id,
					"rank":rank
					},
				type:"post",
				success:function(data){
					if(data=="ok"){
						updateCategoryStatus(category_id);
					}else{
						swal("<spring:message code='language.deleteCateFailure' />!", "fail");
					}			
				},
				error:function (){
				}
			});
		}
		
	
		//删除分类
		function updateCategoryStatus(category_id) {
			jQuery.ajax({
				url : "/category/updateCategoryStatus.do",
				data : {
					"category_id" : category_id
				},
				type : "post",
				dataType : "json",
				success : function(data) {
					var code = data.code;
					if (code == "OK") {
						// 页面刷新
						swal("<spring:message code='language.success' />!", "success");
						window.location.reload();
					} else {
						swal("<spring:message code='language.deleteCategoryFailure' />!", "fail");
					}
				},
			});
		}
		
		//新建分类
		function newCategory() {
			location.href = "/category/insertCategoryPage.do";
		}
			
		//修改分类
		function editCategory(category_id) {
			location.href="/category/queryCategory.do?operation=edit&category_id=" + category_id;
		}
	
	</script>

</body>
<%-- <%-- <%@ include file="../inc/footer.html"%> --%>
</html>
