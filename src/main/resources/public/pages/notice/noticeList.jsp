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
<title>公告列表</title>
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
					<form action="/notice/queryNoticeList.do" name="noticeform"
						id="noticeform" method="post" accept-charset="utf-8">
						<div class="row">
							<div class="col-md-12">
								<div class="card">
									<div class="header">
										<h4 class="title"><spring:message code="language.noticeallb"/></h4>
									</div>
									<!-- 是否显示 -->
									<div class="content">
										<div class="col-md-2">
			                            	<div class="form-group">
			                                  <select  id="status" name="status" class="selectpicker" data-title="<spring:message code="language.noticeStatus" />" data-style="btn-default btn-block" data-menu-style="dropdown-blue">
			                                      <option value="" ${map.status == ''?'selected':''} ><spring:message code="language.all" /></option>
													<option value="0" ${map.status == '0'?'selected':''} ><spring:message code="language.noDisplay" /></option>
													<option value="1" ${map.status == '1'?'selected':''} ><spring:message code="language.display" /></option>
			                                  </select>
			                                  </div>
			                            </div>
									 
										<div class="footer">
											<button class="btn btn-info btn-fill btn-wd" type="button"
												onclick="newBanner();"><spring:message code="language.noticeCreation"/></button>
											<button class="btn btn-info btn-fill btn-wd" type="submit">
												<spring:message code="language.queryBtn"/></button>
											<button class="btn btn-default btn-fill btn-wd"
												onclick="resetInfo();"><spring:message code="language.resetBtn"/></button>
										</div>
										<div class="card margintop20">
											<table class="table">
												<thead>
													<th class="text-center"><spring:message code="language.noticeNumber"/></th>
													<th><spring:message code="language.noticeName"/></th>
													<%-- <th><spring:message code="language.noticeContent"/></th> --%>
													<th><spring:message code="language.noticeStatus"/></th>
													<th><spring:message code="language.createDate"/></th>
													<th><spring:message code="language.operator"/></th>
													<th data-field="actions"><spring:message code="language.operation"/></th>
												</thead>
												<tbody>
													<c:forEach items="${map.pageInfo.datas}" varStatus="item" var="m">
														<tr>
															<td class="tcenter text-center"><c:out value="${m.id}" /></td>
															<td class="tcenter"><c:out value="${m.title}" /></td>
															<%-- <td class="tcenter"><c:out value="${m.content}" /></td> --%>
															<td class="tcenter">
																<c:if test="${m.status=='0'}"><spring:message code="language.noDisplay" /></c:if>
															 	<c:if test="${m.status=='1'}"><spring:message code="language.display" /></c:if>
															</td>
															<td class="tcenter"><fmt:formatDate value="${m.createDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
															<td class="tcenter"><c:out value="${m.createUserId}" /></td>
															<td class="tcenter" id="">
															  <a href="javascript:editNotice(${m.id});" title="<spring:message code="language.BJ"/>"><spring:message code="language.BJ"/></a>&nbsp;&nbsp;
								
								                              <c:if test="${m.status=='0'}">
															     <a href="javascript:updateStatus('${m.id}','1');" title="<spring:message code="language.edit"/>"><spring:message code="language.display"/></a>&nbsp;&nbsp;
															  </c:if>
															   <c:if test="${m.status=='1'}">
															     <a href="javascript:updateStatus('${m.id}','0');" title="<spring:message code="language.edit"/>"><spring:message code="language.noDisplay"/></a>&nbsp;&nbsp;
															  </c:if>
															  
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
			 $("#isDisplay").val("");
		}
		
		//新建公告
		function newBanner() {
			location.href = "/notice/gotoAddNotice.do";
		}
		
		//显示不显示
		function updateStatus(id,status) {
			jQuery.ajax({
				url : "/notice/updateNoticeStatus.do",
				data : {
					"status": status,
					"id":id
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
						swal("<spring:message code='language.deleteFailure' />!", "fail");
					}
				},
			});
		}
 
		//修改公告
		function editNotice(id) {
			location.href = "/notice/gotoUpdateNotice.do?id="+id;
		}
	</script>

</body>
<%-- <%-- <%@ include file="../inc/footer.html"%> --%>
</html>
