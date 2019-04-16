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
<title>团购列表</title>
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
<script language="javascript" src="/js/layer/layer.js"></script>
<style>
.fixed-table-toolbar {
	width: 100%;
	overflow: hidden;
}

.select {
	height: 38px;
	line-height: 38px;
	border-radius: 5px;
	border: 1px solid #ddd;
	width: 100%
}

#excalFile {
	position: fixed;
	top: 0;
	z-index: 999;
	margin: 300px 500px;
	background: white;
	display: none;
	border:1px solid black
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
					<form action="/platTeam/platTeamList.do" name="categoryform"
						id="categoryform" method="post" accept-charset="utf-8">
						<div class="row">
							<div class="col-md-12">
								<div class="card">
									<div class="content">
										<legend>团购列表</legend>
										<!-- --------------------------------------- -->
										<!-- 商品名称 -->
										<div class="col-md-2" style="float:left;padding-right:0px">
											<input type="text" placeholder="团购名称" class="form-control"
												id="team_name" name="team_name" value="${map.team_name}" />
										</div>
										<!-- 团购编号 -->
										<div class="col-md-2" style="float:left;padding-right:0px">
											<input type="text" placeholder="团购编号" class="form-control"
												id="team_code" name="team_code" value="${map.team_code}" />
										</div>

										<!-- 时间-->
										<div class="col-md-2">
											<div class="form-group">
											<input type="text" value="${map.start_time}" id="start_time" name="start_time" placeholder="团开始时间" class="form-control" onclick= "WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});"  
											 />
											</div>
										</div>
										
										<div class="col-md-2" >
											<div class="form-group">
											<input type="text" value="${map.end_time}" id="end_time" name="end_time" placeholder="团结束时间" class="form-control" onclick= "WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});"  
											  />
											</div>
										</div>
										<div class="footer">
											<button class="btn btn-info btn-fill btn-wd" type="button"
												onclick="creatTeamBuy();">发布团购</button>
											<button class="btn btn-info btn-fill btn-wd" type="submit">查询</button>
										</div>
										
										
										<!-- 列表 -->
										<div class="card margintop20">
											<table class="table">
												<thead>
													<th class="text-center">团购编码</th>
													<th class="text-center">团购名称</th>
													<th class="text-center">开团时间</th>
													<th class="text-center">结束时间</th>
													
													<th class="text-center">开团区域</th>
													<th class="text-center">物流方式</th>
													<th class="text-center">客服电话</th>
													<th data-field="actions" class="text-center text-center">操作</th>
												</thead>
												<tbody>
													<c:forEach items="${map.pageInfo.datas}" varStatus="item"
														var="m">
														<tr>
															<td class="tcenter text-center"><c:out
																	value="${m.team_code}" /></td>
															<td class="tcenter text-center"><c:out
																	value="${m.team_name}" /></td>
															<td class="tcenter text-center"><fmt:formatDate
																	value="${m.start_time}" pattern="yyyy/MM/dd HH:MM:SS" />
															</td>
															<td class="tcenter text-center"><fmt:formatDate
																	value="${m.end_time}" pattern="yyyy/MM/dd HH:MM:SS" />
															</td>
															<td class="tcenter text-center"><c:out
																	value="${m.region_name}" /></td>
															<td class="tcenter text-center"><c:if
																	test="${m.logistics_type=='1'}">自提</c:if> <c:if
																	test="${m.logistics_type=='2'}">团长送货</c:if> <c:if
																	test="${m.logistics_type=='3'}">同时支持</c:if></td>
															<td class="tcenter text-center"><c:out
																	value="${m.contact}" /></td>

															<td class="tcenter text-center">
																<a href="/platTeam/queryPlatTeam.do?pteamId=${m.pteam_id}&queryType=1" title="查看">查看</a>&nbsp;&nbsp;
																<a href="/platTeam/queryPlatTeam.do?pteamId=${m.pteam_id}" title="编辑">编辑</a>&nbsp;&nbsp;
																<a href="javascript:uploadPlateam('${m.pteam_id}');" title="上传">上传</a>&nbsp;&nbsp;
																<a href="javascript:downloadPlateam('${m.pteam_id}');" title="下载">下载</a>&nbsp;&nbsp;
															</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
										<!--  -->

										<div class="newpages">
											<%@include file="/page/page.jsp"%>
										</div>


										<!-- --------------------------------------- -->
									</div>

								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div id="excalFile" class="modal-dialog" style="">
				<div style="margin: 120px 180px;">
					<input id="plateamId" type="hidden" name="plateamId" />
					<input data-options="prompt:'Choose a file...'" type="file"
						id="excal" name="file" onchange="ajaxFileUpload('excal',1)" /> 
					<input id="fileUrl" type="hidden" name="excalUrl" /> 
					<button type="button" class="btn btn-info btn-fill btn-wd"
															onclick="closeExcal()" style="margin-bottom: 10px;"
															id="">关闭</button>
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
		function creatTeamBuy() {
			location.href = "/pages/pteamBuy/creatTeamBuy.jsp"
	
		}
		function uploadPlateam(plateamId) {
			$("#excalFile").css("display", "block");
			$("#plateamId").val(plateamId);
		}
		function downloadPlateam(plateamId) {
		
		 window.location.href="/platTeam/downloadPlateam.do?plateamId=" + plateamId;
		 
		}
		//上传excal表
		function ajaxFileUpload(divID, type) {
			if (divID == null) {
				divID = "file";
			}
			var plaTeamId = $("#plateamId").val();
			$.ajaxFileUpload({
				url : "/platTeam/export.action?plaTeamId=" + plaTeamId, //需要链接到服务器地址  
				secureuri : false,
				dataType : "multipart/form-data",
				fileElementId : divID, //文件选择框的id属性  
				dataType : "json", //服务器返回的格式，可以是json  
				success : function(data, status) {//相当于java中try语句块的用法  
					var code =data.code;
					if (code == "0") {
						// 页面刷新
						swal(data.msg, "success");
						closeExcal();
						location.href="/platTeam/platTeamList.do";
					} else {
						swal(data.msg, "fail");
					}
				},
				error : function(data, status, e) {}
			}
			);
		}
		function closeExcal(){
			$("#excalFile").css("display", "none");		
		}
	</script>
</body>
<%-- <%-- <%@ include file="../inc/footer.html"%> --%>
</html>
