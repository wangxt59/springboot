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
<title>订单售后处理</title>
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
<script language="javascript" src="/js/layer/layer.js"></script>

</head>
<style>
.fixed-table-toolbar {
	width: 100%;
	overflow: hidden;
}
.col-sm-2{width:45%;margin:10px}
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
					<form action="/goodsInfo/selectGoodsInfoList.do" name="categoryform"
						id="categoryform" method="post" accept-charset="utf-8">
						<div class="row">
							<div class="col-md-12">
								<div class="card">
									<div class="content">
										<legend style="margin-bottom:5px"> 订单售后处理</legend>
										<!-- 1.商品名称 -->
										<fieldset>
										<div>
											<div class="form-group">
												<label class="col-sm-2 control-label">
												团购名称：&nbsp;&nbsp;&nbsp;<c:out value="${data.team_name}" /></label>
												<label class="col-sm-2 control-label">
												交易流水号：&nbsp;&nbsp;&nbsp;<c:out value="${data.pay_code}" /></label>
												<label class="col-sm-2 control-label">
												订单编号：&nbsp;&nbsp;&nbsp;<c:out value="${data.order_id}" /></label>
												<label class="col-sm-2 control-label">
												参团时间：&nbsp;&nbsp;&nbsp;<c:out value="${data.create_date}" /></label>
												<label class="col-sm-2 control-label">
												付款时间：&nbsp;&nbsp;&nbsp;<c:out value="${data.pay_time}" /></label>
												<label class="col-sm-2 control-label">
												收货时间：&nbsp;&nbsp;&nbsp;<c:out value="${data.receive_date}" /></label>
												<label class="col-sm-2 control-label">
												团长姓名： &nbsp;&nbsp;&nbsp;<c:out value="${data.nick_name}" /></label>
												<label class="col-sm-2 control-label">
												团长手机号： &nbsp;&nbsp;&nbsp;<c:out value="${data.contact}" />
												</label>
												<label class="col-sm-2 control-label">
												配送方式：&nbsp;&nbsp;&nbsp;
												<c:if test="${data.delivery_type=='1'}">自提</c:if>
											 	<c:if test="${data.delivery_type=='2'}">送货上门</c:if></label>
												<label class="col-sm-2 control-label">
												自提点名称：&nbsp;&nbsp;&nbsp;<c:out value="${data.point_name}" /></label>
												<label class="col-sm-2 control-label" >
												订单状态：&nbsp;&nbsp;&nbsp;
												<c:if test="${data.status=='1'}">待支付</c:if>
										 		<c:if test="${data.status=='2'}">已支付</c:if>
										 		<c:if test="${data.status=='3'}">待收货</c:if>
										 		<c:if test="${data.status=='4'}">已收货</c:if>
										 		<c:if test="${data.status=='5'}">支付失败</c:if>
										 		<c:if test="${data.status=='6'}">已退款</c:if>
										 		<c:if test="${data.status=='7'}">取消</c:if>
												</label>
												
												
											</div>
											</fieldset>
											
											<div style="margin-left:3.5%;margin-top:20px">售后商品</div>
											<div class="card margintop20" style="z-index:-1">
											<table class="table" style="z-index:-1">
												<thead>
													<th class="text-center">商品名称</th>
													<th class="text-center">申请类型</th>
													<th class="text-center">补发数量</th>
											    	<th class="text-center">申请原因</th>
											    	<th class="text-center">操作</th>
												</thead>
												<tbody>
													<c:forEach items="${data.list}" varStatus="item" var="m">
														<tr>
															<td class="tcenter text-center"><c:out value="${m.goods_name}" /></td>
															<td class="tcenter text-center" ><c:out value="${m.region_price}" /></td>
															<td class="tcenter text-center"><c:out value="${m.goods_num}" /></td>
															<td class="tcenter text-center"><c:out value="${m.total_money}" /></td>
															<td class="tcenter text-center">
																<c:if test="${m.id== null}">
																	<a href="javascript:getPic('${m.id}');" title="查看图片">查看图片</a>
																</c:if>
																<c:if test="${m.id!= null}"> - </c:if>
															</td>
														</tr>
													</c:forEach>
												</tbody>
												
											</table>
										</div>
											
													
									</div>	
									<div class="footer text-center">
										<!--  
										<button type="button" class="btn btn-fill btn-wd"
											onclick="goToList();">
											<spring:message code="language.backBtn" />
										</button>
										-->
										<input type="button" class="btn btn-fill btn-wd" name="Submit" onclick="javascript:history.back(-1);" value="返回">
									</div>		
								</div>
							</div>
						</div>
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
				//返回按钮
			function goToList() {
				location.href = "/goodsInfo/selectGoodsInfoList.do";
			}
	
	
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
</body>
<%-- <%-- <%@ include file="../inc/footer.html"%> --%>
</html>
