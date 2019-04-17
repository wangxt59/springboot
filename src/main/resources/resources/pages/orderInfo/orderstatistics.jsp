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
<title>交易订单统计</title>
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
					<form action="/orderInfo/orderStatisticsList.do" name="orderform"
						id="orderform" method="post" accept-charset="utf-8">
						<div class="row">
							<div class="col-md-12">
								<div class="card">
									<div class="header">
										<h4 class="title">交易订单统计</h4>
									</div>
									<!-- 卡状态 -->
									<div class="content">
									    <!-- 订单号 -->
									   <div class="col-md-3">
			                                <div class="form-group">
			                                    <input type="text" placeholder="用户姓名" class="form-control"  id="real_name" name="real_name" 
			                                    value="${map.real_name}" size="15"/>
			                                </div>
			                            </div>
			                            <div class="col-md-6" style="position:relative;">
										<div class="col-md-6">
											<div class="form-group">
											<input type="text" id="create_date_start" placeholder="交易开始时间" class="form-control" onclick= "WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" name="create_date_start" 
											value="${map.create_date_start}"  />
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
											<input type="text" id="create_date_end" placeholder="交易结束时间" class="form-control" onclick= "WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" name="create_date_end" 
											value="${map.create_date_end}"  />
											</div>
										</div>
										<p style="position:absolute;top:15%;left: 49.5%;">--</p>
										</div>
			                      
										<div class="footer">
											<button class="btn btn-info btn-fill btn-wd" type="submit">
												<spring:message code="language.queryBtn"/></button>
											<button class="btn btn-default btn-fill btn-wd"
												onclick="resetInfo();"><spring:message code="language.resetBtn"/></button>
										</div>
										<div class="card margintop20">
											<table class="table">
												<thead>
													<th class="text-center">用户名称</th>
													<th class="text-center">联系方式</th>
													<th class="text-center">买币总计</th>
											    	<th class="text-center">买入单总数</th>
													<th class="text-center">卖币总计</th>
													<th class="text-center">卖出单总数</th>
													<th class="text-center">交易时间</th>
												</thead>
												<tbody>
													<c:forEach items="${map.pageInfo.datas}" varStatus="item" var="m">
														<tr>
															<td class="tcenter text-center"><c:out value="${m.real_name}" /></td>
															<td class="tcenter text-center"><c:out value="${m.contact}" /></td>
															<td class="tcenter text-center"><c:out value="${m.buyer_sum}" /></td>
															<td class="tcenter text-center"><c:out value="${m.buyer_count}" /></td>
															<td class="tcenter text-center"><c:out value="${m.seller_sum}" /></td>
															<td class="tcenter text-center"><c:out value="${m.seller_count}" /></td>
															<td class="tcenter text-center"><fmt:formatDate value="${m.trade_date}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
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
			 $("#card_type").val("");
			 $("#user_id").val("");
			 $("#flow_no").val("");
			 $("#status").val("");
			 $("#create_date_start").val("");
			 $("#create_date_end").val("");
		}
		 

		//修改商品
		function editOrder(orderId) {
			location.href = "/orderInfo/gotoUpdateOrder.do?orderId="+orderId;
		}
		
	 
	</script>

</body>
<%-- <%-- <%@ include file="../inc/footer.html"%> --%>
</html>
