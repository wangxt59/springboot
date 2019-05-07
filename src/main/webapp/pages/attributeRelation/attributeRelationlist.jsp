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
<link rel="canonical" href="https://www.creative-tim.com/product/light-bootstrap-dashboard-pro" />
<link href="/css/bootstrap.min.css" rel="stylesheet" />
<link href="/css/light-bootstrap-dashboard.css" rel="stylesheet" />
<link href="/css/common.css" rel="stylesheet" />
<link href="/css/font-awesome.min.css" rel="stylesheet" />
<link href='/css/685fd913f1e14aebad0cc9d3713ee469.css' rel='stylesheet' type='text/css' />
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
.select{
height:38px;line-height:38px;border-radius:5px;border:1px solid #ddd;width:100%
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
					<form action="/attributeRelation/selectAttributeRelationList.do" name="categoryform"
						id="categoryform" method="post" accept-charset="utf-8">
						<div class="row">
							<div class="col-md-12">
								<div class="card">
									<div class="header">
										<h4 class="title"><spring:message code="language.attrallb"/></h4>
									</div>
									   <!-- 所属分类 -->
									   <div class="col-md-2">
			                                <div class="form-group">
			                                    <input type="text" placeholder="<spring:message code="language.attrCategory" />" class="form-control"  id="category_name" name="category_name" 
			                                    value="${map.category_name}" />
			                                </div>
			                            </div>
									   <!-- 属性名称 -->
									   <div class="col-md-2">
			                                <div class="form-group">
			                                    <input type="text" placeholder="<spring:message code="language.attrName" />" class="form-control"  id="attr_name" name="attr_name" 
			                                    value="${map.attr_name}" size="15"/>
			                                </div>
			                            </div>
										<div class="footer">
											<button class="btn btn-info btn-fill btn-wd" type="button"
												onclick="newAttr();"><spring:message code="language.attrCreation"/></button>
											<button class="btn btn-info btn-fill btn-wd" type="submit">
												<spring:message code="language.queryBtn"/></button>
											<button class="btn btn-default btn-fill btn-wd"
												onclick="resetInfo();"><spring:message code="language.resetBtn"/></button>
										</div>
										<div class="card margintop20">
											<table class="table">
												<thead>
													<th class="text-center"><spring:message code="language.attrNumber"/></th>
													<th><spring:message code="language.attrName"/></th>
													<th><spring:message code="language.attrCategory"/></th>
													<th><spring:message code="language.attrValue"/></th>
													<th><spring:message code="language.createDate"/></th>
													<th><spring:message code="language.categoryStatus"/></th>	
													<th><spring:message code="language.operator"/></th>	
													<th data-field="actions"><spring:message code="language.operation"/></th>
												</thead>
												<tbody>
													<c:forEach items="${map.pageInfo.datas}" varStatus="item" var="m">
														<tr>
															<td class="tcenter text-center"><c:out value="${item.index+1}" /></td>
															<td class="tcenter"><c:out value="${m.attr_name}" /></td>
															<td class="tcenter"><c:out value="${m.category_name}" /></td>
															<td class="tcenter"><c:out value="${m.value_name}" /></td>
															<td class="tcenter"><fmt:formatDate value="${m.create_date}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
															<td class="tcenter">
																<c:if test="${m.status=='1'}"><spring:message code="language.effective" /></c:if>
															 	<c:if test="${m.status=='2'}"><spring:message code="language.deleteBtn" /></c:if>
															</td>
															<td class="tcenter"><c:out value="${m.upload_person}" /></td>
															<td class="tcenter" id="">
															  <a href="javascript:editAttr('${m.relation_id}','${m.attr_id}','${m.value_id}');" title="<spring:message code="language.BJ"/>"><spring:message code="language.BJ"/></a>&nbsp;&nbsp;
									                          <a href="javascript:updateStatus('${m.attr_id}','2');"  title='<spring:message code="language.deleteBtn" />'><spring:message code="language.deleteBtn" /></a>&nbsp;&nbsp;
															</td>
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
			 $("#attr_name").val("");
			 $("#category_name").val("");
		}
		
		//新建属性
		function newAttr() {
			location.href = "/attributeRelation/insertAttributeRelationPage.do";
		}
		
		
		//删除 /生效
		function updateStatus(attrId,status) {
			var content;
			if (status == 2) {
				content = "<spring:message code='language.attrDel' />？";
			}
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
					querySkuGoodsByAttrId(attrId,status);
				}
			});
	
		}
	
		//删除的修改状态
		function querySkuGoodsByAttrId(attrId,status) {
			jQuery.ajax({
				url:"/goodsInfo/querySkuGoodsByAttrId.do",
				data:{"attrId":attrId},
				type:"post",
				success:function(data){
					if(data=="ok"){
						updateAttributeRelationStatus(attrId,status);
					}else{
						swal("<spring:message code='language.deleteAttrFailure' />!", "fail");
					}			
				},
				error:function (){
				}
			});
		}
		
		
		function updateAttributeRelationStatus(attrId,status){
			if(status == 2){
					location.href="/attributeRelation/deleteAttributeRelationStatus.do?attr_id="+attrId+"&status=" + status;
			}
		    if(status == 1){ 
				 location.href="/attributeRelation/updateAttributeRelationStatus.do?attr_id="+attrId+"&status=" + status;
			}
	   		
	   }
	 
		//修改属性
		function editAttr(relation_id,attr_id,value_id) {
			location.href="/attributeRelation/updateAttributeRelationPage.do?relation_id=" + relation_id+"&attr_id=" + attr_id+"&value_id=" + value_id;
		}
	
	</script>

</body>
<%-- <%-- <%@ include file="../inc/footer.html"%> --%>
</html>
