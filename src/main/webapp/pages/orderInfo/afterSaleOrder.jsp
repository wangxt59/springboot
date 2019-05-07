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
<title>售后订单列表</title>
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
					<form action="/orderInfo/afterSaleOrder.do" name="orderform"
						id="orderform" method="post" accept-charset="utf-8">
						<div class="row">
							<div class="col-md-12">
								<div class="card" id="card">
									<div class="header">
										<h4 class="title">售后订单列表</h4>
									</div>
								
									<div class="content" style="overflow:visible;position:relative; z-index:999;">
									    <!-- 订单号 -->
									   <div class="col-md-3" style="width:14%;margin-right:0px;padding:5px">
			                                <div class="form-group" >
			                                    <input type="text" value="${map.request.order_code}" placeholder="请输入订单编号" class="form-control"  id="order_code" name="order_code" 
			                                     size="15"/>
			                                </div>
			                            </div>
			                           <!-- 用户 -->
									   <div class="col-md-3" style="width:15%;padding:5px">
			                                <div class="form-group">
			                                    <input type="text" value="${map.request.user_name}" placeholder="请输入下单用户名" class="form-control"  id="user_name" name="user_name" 
			                                     size="15"/>
			                                </div>
			                            </div>
			                            <!-- 团购名称 -->
									   <div class="col-md-3" style="width:13.5%;padding:5px">
			                                <div class="form-group">
			                                    <input type="text" placeholder="请输入团购名称" class="form-control"  id="team_name" name="team_name"  value="${map.request.team_name}"
			                                     size="15"/>
			                                </div>
			                            </div>
			                            <!-- 订单状态 -->
										<div class="col-md-3" style="width:12%;padding:5px;" >
			                            	<div class="form-group" style="overflow:visible;">
			                                  <select   id="status" name="status" class="selectpicker" data-title="<spring:message code="language.Orderstatus" />" >
													<option value="1"  ${map.request.status == '1'?'selected':''}>待支付</option>
													<option value="2"  ${map.request.status == '2'?'selected':''}>已支付</option>
													<option value="3" ${map.request.status == '3'?'selected':''}>待收货</option>
													<option value="4" ${map.request.status == '4'?'selected':''}>已收货</option>
													<option value="5" ${map.request.status == '5'?'selected':''}>支付失败</option>
													<option value="6" ${map.request.status == '6'?'selected':''}>已退款</option>
													<option value="7" ${map.request.status == '7'?'selected':''}>取消</option>
			                                  </select>
			                                  </div>
			                            </div>
				                        <!-- 配送方式 -->
										   <div class="col-md-2" style="width:11%;padding:5px" >
				                                <div class="form-group">
				                                   <select   id="delivery_type" name="delivery_type" class="selectpicker" data-title="配送方式" data-style="btn-default btn-block" data-menu-style="dropdown-blue">
													<option value="1" ${map.request.delivery_type == '1'?'selected':''}>自提</option>
													<option value="2" ${map.request.delivery_type == '2'?'selected':''}>送货上门</option>
			                                  </select>
				                                </div>
				                            </div>
				                            
			                            <div class="col-md-6" style="position:relative;width:34.5%;padding:5px">
										<div class="col-md-6">
											<div class="form-group">
											<input type="text" value="${map.request.satrt_date}" id="satrt_date" name="satrt_date" placeholder="订单开始时间" class="form-control" onclick= "WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});"  
											 />
											</div>
										</div>
										<div class="col-md-6" >
											<div class="form-group">
											<input type="text" value="${map.request.end_date}" id="end_date" name="end_date" placeholder="订单结束时间" class="form-control" onclick= "WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});"  
											  />
											</div>
										</div>
										<p style="position:absolute;top:15%;left: 49.5%;">--</p>
										</div>
										
										</div>
										<div class="footer" id="sta" style="z-index:-1">
											<button class="btn btn-info btn-fill btn-wd" type="submit" style="z-index:-1">
												<spring:message code="language.queryBtn"/></button>
										</div>
										<div class="card margintop20" style="z-index:-1">
											<table class="table" style="z-index:-1">
												<thead>
													<th class="text-center">订单编号</th>
													<th class="text-center">团长</th>
											    	<th class="text-center">下单用户</th>
													<th class="text-center">售后类型</th>
													<th class="text-center">售后商品</th>
													<th class="text-center">申请数量</th>
													<th class="text-center">支付金额</th>
													<th class="text-center">退款金额</th>
													<th class="text-center">订单状态</th>
													<th class="text-center">申请时间</th>
													<th class="text-center">操作</th>
												</thead>
												<tbody>
													<c:forEach items="${map.pageInfo.datas}" varStatus="item" var="m">
														<tr>
															<td class="tcenter text-center"><c:out value="${m.order_id}" /></td>
															<td class="tcenter text-center" ><c:out value="${m.nick_name}" /></td>
															<td class="tcenter text-center"><c:out value="${m.user_name}" /></td>
															<td class="tcenter text-center">退款</td>
															<td class="tcenter text-center"><c:out value="${m.goods_name}"/></td>
															<td class="tcenter text-center"><c:out value="${m.goods_num}" /></td>
															<td class="tcenter text-center"><c:out value="${m.goods_total}" /></td>
															<td class="tcenter text-center"><c:out value="${m.total_money}"/></td>
															<td class="tcenter text-center"><c:out value="待处理"/></td>
															<td class="tcenter text-center"><fmt:formatDate value="${m.create_date}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
															<td class="tcenter text-center">
															<a href="javascript:orderdetails('${m.id}');" title="售后处理">售后处理</a>
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
/* 		function resetInfo() {
			 $("#card_type").val("");
			 $("#user_id").val("");
			 $("#flow_no").val("");
			 $("#status").val("");
			 $("#create_date_start").val("");
			 $("#create_date_end").val(""); 
		}
		 */
		 function  orderdetails(id){
			 location.href = "/orderInfo/refundOrderDetails.do?id="+id;
		 }
	</script>

</body>
<%-- <%-- <%@ include file="../inc/footer.html"%> --%>
</html>
