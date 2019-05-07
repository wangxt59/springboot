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
<title>商品管理</title>
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
.btn{margin-bottom:10px}
.form-group{display:inline}
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
									<div class="header">
										<h4 class="title"><spring:message code="language.goodsallb"/></h4>
									</div>
										<!-- url -->
		     							<input id="url" name="url" value="goodsInfo/goodsInfoList.jsp" type="hidden">
									    <!-- 一级分类 -->
										<div class="col-md-2">
			                            	<div class="form-group">
			                                  <select  id="typeGrand" name="parent_id" onchange="getSecondType();"  class="select">
			                                      <option value="" ${map.parent_id == ''?'selected':''} ><spring:message code="language.firstCategory" /></option>
													<c:forEach items="${map.categoryList}" var="c">
														<option value="${c.category_id}" ${map.parent_id == c.category_id?'selected':''}>
															 <c:out value="${c.category_name}"/>
														</option>
													</c:forEach>
			                                  </select>
			                                  </div>
			                            </div>
			                            <!-- 二级分类 -->
										<div class="col-md-2">
			                            	<div class="form-group">
			                                  <select  id="typeParent" name="child_id"  class="select" onchange="getThridType();"  >
			                                      <option value="" ${map.child_id == ''?'selected':''} ><spring:message code="language.secondCategory" /></option>
													<c:forEach items="${map.childList}" var="ch">
														<option value="${ch.category_id}" ${map.child_id == ch.category_id?'selected':''}>
															${ch.category_name}
														</option>
												    </c:forEach>
			                                  </select>
			                                  </div>
			                            </div>
			                              <!-- 三级分类 -->
										<div class="col-md-2">
			                            	<div class="form-group">
			                                  <select  id="typeThrid" name="category_id"  class="select"  >
			                                      <option value="" ${map.category_id == ''?'selected':''} ><spring:message code="language.thirdCategory" /></option>
													<c:forEach items="${map.thildList}" var="ca">
															<option value="${ca.category_id}" ${map.category_id == ca.category_id?'selected':''}>
																 <c:out value="${ca.category_name}"/>
															</option>
														</c:forEach>
			                                  </select>
			                                  </div>
			                            </div>
	                                   <!-- 商品状态  -->
										<div class="col-md-2">
			                            	<div class="form-group">
			                                  <select  id="status" name="status" class="selectpicker" data-title="<spring:message code="language.goodsStatus" />" data-style="btn-default btn-block" data-menu-style="dropdown-blue">
													<option value="0" ${map.status == '0'?'selected':''} ><spring:message code="language.downshelves" /></option>
													<option value="1" ${map.status == '1'?'selected':''} ><spring:message code="language.shelves" /></option>
			                                  </select>
			                                  </div>
			                            </div>
			                           
			                            
									   <!-- 商品名称 -->
									   <div class="col-md-2">
			                                <div class="form-group">
			                                    <input type="text" placeholder="<spring:message code="language.goodsname" />" class="form-control"  id="goodsName" name="goodsName" 
			                                    value="${map.goodsName}" />
			                                </div>
			                            </div>
			                           <!-- 商品编号 -->
									   <div class="col-md-2">
			                                <div class="form-group">
			                                    <input type="text" placeholder="<spring:message code="language.goodsCode" />" class="form-control"  id="goodsCode" name="goodsCode" 
			                                    value="${map.goodsCode}" />
			                                </div>
			                            </div>
			                            
										<div style="width:500px;float:right;margin-top: 10px" class="footer" >
									    	<!-- <button class="btn btn-info btn-fill btn-wd" type="button"
												onclick="downloadTemp();"><spring:message code="language.exportCard"/></button>
											 -->
											 	<!-- <button class="btn btn-default btn-fill btn-wd"
												onclick="resetInfo();">重置</button> -->
											
											<button class="btn btn-info btn-fill btn-wd" type="button"
												onclick="newGoods();"><spring:message code="language.goodsCreation"/></button>
											<button class="btn btn-info btn-fill btn-wd" type="button"
											onclick="category();">商品分类</button>
											<button class="btn btn-info btn-fill btn-wd" type="submit">
											<spring:message code="language.queryBtn"/></button>
										</div>
										
										<div class=" margintop20" >
											<table class="table card">
												<thead>
													<th class="text-center"><spring:message code="language.goodsCode"/></th>
													<th class="text-center"><spring:message code="language.goodsname"/></th>
													<th class="text-center">规格</th>
													<th class="text-center">成本价(元)</th>
													<th class="text-center">市场价(元)</th>
													<th class="text-center">会员价(元)</th>
													<th class="text-center">会员折扣</th>
													<th class="text-center">状 态</th>
													<th data-field="actions" class="text-center text-center"><spring:message code="language.operation"/></th>
												</thead>
												<tbody>
													<c:forEach items="${map.pageInfo.datas}" varStatus="item" var="m">
														<tr>
															<td class="tcenter text-center"><c:out value="${m.goodsCode}" /></td>
															<td class="tcenter text-center"><c:out value="${m.goodsName}" /></td>
															<td class="tcenter text-center"><c:out value="${m.spec}" /></td>
															<td class="tcenter text-center"><c:out value="${m.costPrice}" /></td>
															<td class="tcenter text-center"><c:out value="${m.marketPrice}" /></td>
															<td class="tcenter text-center"><c:out value="${m.cost_price}" /></td>
															<td class="tcenter text-center"><c:out value="${m.cost_price}" /></td>
															<td class="tcenter text-center">
																<c:if test="${m.status=='0'}"><spring:message code="language.downshelves" /></c:if>
															 	<c:if test="${m.status=='1'}"><spring:message code="language.shelves" /></c:if>
															</td>
															<!--  
															<td class="tcenter">
																<c:if test="${m.rank=='1'}"><spring:message code="language.oneStar" /></c:if>
															 	<c:if test="${m.rank=='2'}"><spring:message code="language.twoStar" /></c:if>
															 	<c:if test="${m.rank=='3'}"><spring:message code="language.threeStar" /></c:if>
															</td>

																
															
															-->
															<td class="tcenter text-center" id="">
															  <c:if test="${m.status==0}">
																<a href="javascript:updateGoods('${m.goodsId}', 1);" title="<spring:message code="language.shelves" />"><spring:message code="language.shelves" /></a>&nbsp;&nbsp;
															  </c:if>
															  <c:if test="${m.status==1}">
																 <a href="javascript:updateGoods('${m.goodsId}', 0);" title="<spring:message code="language.downshelves" />"><spring:message code="language.downshelves" /></a>&nbsp;&nbsp;
															  </c:if>
																<a href="javascript:detailsGoods('${m.goodsId}');" title="查看">查看</a>&nbsp;&nbsp;
															  	<a href="javascript:regionalPrices('${m.goodsId}','-1');" title="设置区域价格">设置区域价格</a>&nbsp;&nbsp;
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
			 $("#typeGrand").val("");
			 $("#typeParent").val("");
			 $("#typeThrid").val("");
			 $("#status").val("");
			 $("#languageId").val("");
			 $("#channelId").val("");
			 $("#goodsName").val("");
			 $("#goodsCode").val("");
		}
		
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
		 	var defaultText = "请选择二级分类";
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
		 	var defaultText = "请选择三级分类";
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
		
		
	 
		function downloadTemp(){
			location.href="/goodsInfo/downloadTemp.do";
		}
		
		//选择商品
		function importCard(goodsId){
			$.ajax({
				url:"/goodsInfo/getGoodsAttrList.do",
				data:{
					"goods_id":goodsId
				},
				type:"post",
				dataType:"json",
				success:function(data){
					var html = "";
					var tr_html = "";
					tr_html+="<select id='skuId' name='skuId' class='select' >";
					if (data != "[]" && typeof data != "undefined") {
			 			for (var i = 0; i < data.length; i++) {
								 tr_html+="<option value="+data[i].sku_id+">"+data[i].allName+"</option>"
			 			}
			 		}
					tr_html+="</select>"
					
					html+="<form class='form-horizontal' id='importCardFrom' action='/cardInfo/importCard.do' name='importCardFrom' method='post' enctype='multipart/form-data'>";
				    html+="<div class='content'>";
					html+="<fieldset><div class='form-group' style='width:800px;margin-left:20px'><label class='col-sm-2 control-label'>";
					html+="<spring:message code='language.selectGoodsAttribute'/>:</label>";
					html+="<div class='col-sm-4'>";
					html+=tr_html;
				    html+="</div>";
				    html+="</div></fieldset>";
				    
				    html+="<fieldset><div class='form-group' style='width:800px;margin-left:20px'><label class='col-sm-2 control-label'>";
					html+="<spring:message code='language.import'/>:</label>";
					html+="<div class='col-sm-4'>";
					html+="<input id='upfile' type='file' name='file' onchange='getFilename(this)' value='<spring:message code='language.uploadFile' />'/>";
					html+="<input type='hidden' id='filename' name='filename'/>";
				    html+="</div>";
				    html+="</div></fieldset>";
				    html+="</div>";
				    html+="</form>";
					var index = layer.open({
						  title:"导入卡密信息",
						  type: 1,
						  skin: 'layui-layer-rim', //加上边框
						  area: ['900px', '300px'], //宽高
						  content: html,
						  btn:"确定",
						  yes:function(){
								document.importCardFrom.submit();
						  		layer.close(index);
						  }
						});
				}
			})
		}
		
		function getFilename(obj){
			$("#filename").attr("value", obj.files[0].name);
		}
		//新建商品
		function newGoods() {
			//location.href = "/goodsInfo/addGoodsInfo.do";
			location.href = "/goodsInfo/insertGoodsInfoPage.do";
		}
		//商品分类
		function category() {
			//location.href = "/goodsInfo/addGoodsInfo.do";
			location.href = "/category/selectCategoryList.do";
		}
		//修改商品
		function updateGoods1(goodsId) {
			location.href = "/goodsInfo/gotoUpdateGoods.do?goodsId="+goodsId;
		}
			//查看商品
		function detailsGoods(goodsId) {
			location.href = "/goodsInfo/getGoodsAttrList.do?goods_id="+goodsId;
		}
		//区域价格
		function regionalPrices(goodsId) {
			location.href = "/goodsSku/addRegionalPrices.do?goods_id="+goodsId;
		}
		//上下架
		function updateGoods(goodsId,status) {
			if (status==1) {
				var text="是否确定上架？";
			}else if (status==0) {
				var text="是否确定下架？";
			}
			swal({
                //title: "操作提示",      //弹出框的title
                text: text,   //弹出框里面的提示文本
                type: "warning",        //弹出框类型
                showCancelButton: true, //是否显示取消按钮
                confirmButtonColor: "#DD6B55",//确定按钮颜色
                cancelButtonText: "取消",//取消按钮文本
                confirmButtonText: "确定",//确定按钮上面的文档
                closeOnConfirm: true
            }, function () {
            	jQuery.ajax({
    				url : "/goodsInfo/updateGoodsStatus.do",
    				data : {
    					"status": status,
    					"goodsId":goodsId
    				},
    				type : "post",
    				dataType : "json",
    				success : function(data) {
    					var code = data.code;
    					if (code == "OK") {
    						// 页面刷新
    						//swal("<spring:message code='language.success' />!", "success");
    						 window.location.reload(); 
    						
    					} else {
    						swal("<spring:message code='language.deleteFailure' />!", "fail");
    					}
    				},
    			});
            });
	            
			/* jQuery.ajax({
				url : "/goodsInfo/updateGoodsStatus.do",
				data : {
					"status": status,
					"goodsId":goodsId
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
			}); */
		}
	</script>

</body>
<%-- <%-- <%@ include file="../inc/footer.html"%> --%>
</html>
