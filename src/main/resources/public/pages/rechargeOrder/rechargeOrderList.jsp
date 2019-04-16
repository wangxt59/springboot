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
<title>充值订单</title>
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
					<form action="/rechargeOrder/queryRechargeOrderList.do" name="rechargeOrderform"
						id="rechargeOrderform" method="post" accept-charset="utf-8">
						<div class="row">
							<div class="col-md-12">
								<div class="card">
									<div class="header">
										<h4 class="title"><spring:message code="language.rechargeOrderallb"/></h4>
									</div>
									<!-- 卡状态 -->
									<div class="content">
									    <!-- 订单号 -->
									   <div class="col-md-3">
			                                <div class="form-group">
			                                    <input type="text" placeholder="<spring:message code="language.Ordernumber" />" class="form-control"  id="order_code" name="order_code" 
			                                    value="${map.order_code}" size="15"/>
			                                </div>
			                            </div>
			                            <!-- 商品名称 -->
									   <div class="col-md-3">
			                                <div class="form-group">
			                                    <input type="text" placeholder="<spring:message code="language.goodsname" />" class="form-control"  id="product_name" name="product_name" 
			                                    value="${map.product_name}" size="15"/>
			                                </div>
			                            </div>
			                            <div class="col-md-6" style="position:relative;">
										<div class="col-md-6">
											<div class="form-group">
											<input type="text" id="create_date_start" placeholder="<spring:message code="language.startTime"/>" class="form-control" onclick= "WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" name="create_date_start" 
											value="${map.create_date_start}"  />
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
											<input type="text" id="create_date_end" placeholder="<spring:message code="language.endTime"/>" class="form-control" onclick= "WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" name="create_date_end" 
											value="${map.create_date_end}"  />
											</div>
										</div>
										<p style="position:absolute;top:15%;left: 49.5%;">--</p>
										</div>
			                           <!-- 订单状态 -->
										<div class="col-md-3">
			                            	<div class="form-group">
			                                  <select  id="status" name="status" class="selectpicker" data-title="<spring:message code="language.Orderstatus" />" data-style="btn-default btn-block" data-menu-style="dropdown-blue">
													<option value="" ${map.status == ''?'selected':''} ><spring:message code="language.all" /></option>
													<option value="1" ${map.status == '1'?'selected':''} ><spring:message code="language.Tobepaid" /></option>
													<option value="2" ${map.status == '2'?'selected':''} ><spring:message code="language.Alreadypaid" /></option>
													<option value="3" ${map.status == '3'?'selected':''} ><spring:message code="language.payFail" /></option>
			                                  </select>
			                                  </div>
			                            </div>
			                         
			                           <!-- 用户 -->
									   <div class="col-md-3">
			                                <div class="form-group">
			                                    <input type="text" placeholder="<spring:message code="language.muserID" />" class="form-control"  id="user_id" name="user_id" 
			                                    value="${map.user_id}" size="15"/>
			                                </div>
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
													<th class="text-center"><spring:message code="language.XH"/></th>
													<th><spring:message code="language.Ordernumber"/></th>
													<th><spring:message code="language.userID"/></th>
													<th><spring:message code="language.Ordertime"/></th>
											    	<th><spring:message code="language.PayTime"/></th>
													<th><spring:message code="language.cardType"/></th>
													<th><spring:message code="language.goodsCode"/></th>
													<th><spring:message code="language.goodsname"/></th>
													<th><spring:message code="language.denomination"/></th>
													<th><spring:message code="language.Totalorder"/></th>
												    <th><spring:message code="language.region"/></th>
											    	<th><spring:message code="language.cardOperator"/></th>
													<th><spring:message code="language.Orderstatus"/></th>
													<th data-field="actions"><spring:message code="language.operation"/></th>
												</thead>
												<tbody>
													<c:forEach items="${map.pageInfo.datas}" varStatus="item" var="m">
														<tr>
															<td class="tcenter text-center"><c:out value="${m.id}" /></td>
															<td class="tcenter"><c:out value="${m.order_code}" /></td>
															<td class="tcenter"><c:out value="${m.user_id}" /></td>
															<td class="tcenter"><fmt:formatDate value="${m.create_date}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
															<td class="tcenter"><fmt:formatDate value="${m.pay_time}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
															<td class="tcenter">
															 	<c:if test="${m.pay_type=='1'}"><spring:message code="language.wxPayment" /></c:if>
															</td>
															<td class="tcenter"><c:out value="${m.product_code}" /></td>
															<td class="tcenter"><c:out value="${m.product_name}" /></td>
															<td class="tcenter"><c:out value="${m.face_value}" /></td>
															<td class="tcenter"><c:out value="${m.total}" /></td>	
															<td class="tcenter"><c:out value="${m.province}" /></td>	
															<td class="tcenter"><c:out value="${m.operator}" /></td>
															<td class="tcenter">
															 	<c:if test="${m.status=='1'}"><spring:message code="language.Tobepaid" /></c:if>
														    	<c:if test="${m.status=='2'}"><spring:message code="language.Alreadypaid" /></c:if>
														    	<c:if test="${m.status=='3'}"><spring:message code="language.payFail" /></c:if>
															</td>
															<td class="tcenter" id="">
															  <a href="javascript:editRechargeOrder(${m.id});" title="<spring:message code="language.changeOrderStatus"/>"><spring:message code="language.changeOrderStatus"/></a>&nbsp;&nbsp;
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
			 $("#product_name").val("");
			 $("#user_id").val("");
			 $("#order_code").val("");
			 $("#status").val("");
			 $("#create_date_start").val("");
			 $("#create_date_end").val("");
		}
		
		//修改商品
		function editRechargeOrder(id) {
			location.href = "/rechargeOrder/gotoUpdateRechargeOrder.do?id="+id;
		}
		
 
	</script>

</body>
<%-- <%-- <%@ include file="../inc/footer.html"%> --%>
</html>
