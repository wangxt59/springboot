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
<title>商品详情</title>
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
.col-sm-2{width:45%;margin:20px}
.content{height:500px}
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
					<form action="/goodsInfo/getGoodsAttrList.do" name="categoryform"
						id="categoryform" method="post" accept-charset="utf-8">
						<div class="row">
							<div class="col-md-12">
								<div class="card">
									<div class="content">
										<legend>商品详情</legend>
										<!-- 1.商品名称 -->
										<fieldset>
										<div>
											<div class="form-group">
												<label class="col-sm-2 control-label">
												商品编码:&nbsp;&nbsp;&nbsp;<c:out value="${goods.goods_code}" /></label>
												<label class="col-sm-2 control-label">
												商品分类：&nbsp;&nbsp;&nbsp;<c:out value="${goods.category_name}" /></label>
												<label class="col-sm-2 control-label">
												商品规格:&nbsp;&nbsp;&nbsp;<c:out value="${goods.spec}" /></label>
												<label class="col-sm-2 control-label">
												商品亮点:&nbsp;&nbsp;&nbsp;<c:out value="${goods.ad_words}" /></label>
												<label class="col-sm-2 control-label">
												成本价:&nbsp;&nbsp;&nbsp;<c:out value="${goods.cost_price}" /></label>
												<label class="col-sm-2 control-label">
												市场价:&nbsp;&nbsp;&nbsp;<c:out value="${goods.market_price}" /></label>
												<label class="col-sm-2 control-label">
												会员价:&nbsp;&nbsp;&nbsp;<c:out value="${goods.vip_price}" /></label>
												<label class="col-sm-2 control-label">
												状 态:&nbsp;&nbsp;&nbsp;
												<c:if test="${goods.status=='0'}">下架</c:if>
											 	<c:if test="${goods.status=='1'}">上架</c:if>
												</label>
												<label class="col-sm-2 control-label">
												商品库存:&nbsp;&nbsp;&nbsp;<c:out value="${goods.stock}" /></label>
												<label class="col-sm-2 control-label">
												退货时效:&nbsp;&nbsp;&nbsp;<c:out value="${goods.return_time}" /></label>
												<label class="col-sm-2 control-label" style="width:100px">
												商品头图:&nbsp;&nbsp;&nbsp;
												</label><img src="${goods.goods_pic}" alt="" style="width:200px;margin-top:20px"/>
													
											</div>
											</fieldset>
											
													
									</div>	
									<div class="footer text-center">
									
										<button type="button" class="btn btn-info btn-fill btn-wd"
											 onclick="updateGoods();">
											修改</button>
										<button type="button" class="btn btn-info btn-fill btn-wd"
											id="doSubmit" onclick="selectprice();">
											查看区域价格
										</button>
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
			function updateGoods() {
				var goods_id=${goods.goods_id};
				location.href="/goodsInfo/toupdateGoods.do?goods_id="+goods_id+"&url=/goodsInfo/updateGoodsInfo.jsp";
			}
		
	
			//区域价格
			function selectprice() {
			var goods_id=${goods.goods_id};
			
				location.href = "/goodsSku/regionalPrices.do?goods_id="+goods_id+"&currentPage=1";
			}
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
