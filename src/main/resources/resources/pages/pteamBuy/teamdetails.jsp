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
<title>查看团购</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/bootstrap.min.css" rel="stylesheet" />
<link href="/css/light-bootstrap-dashboard.css" rel="stylesheet" />
<link href="/css/common.css" rel="stylesheet" />
<link href="/css/font-awesome.min.css" rel="stylesheet">
<link href='/css/685fd913f1e14aebad0cc9d3713ee469.css' rel='stylesheet' type='text/css'>		
<link href="/css/pe-icon-7-stroke.css" rel="stylesheet" />

<script language='javascript' src="js/edit.js"></script>
<script type="text/javascript"	src="/js/ueditor1.4.3.3/ueditor.config.js"></script>
<script type="text/javascript" src="/js/ueditor1.4.3.3/ueditor.all.js"></script>
<script type="text/javascript" charset="utf-8"	src="/js/ueditor2/lang/zh-cn/zh-cn.js"></script>
<script language='javascript' src="/js/jquery-1.8.3.min.js"></script>
<script language='javascript' src="/js/ajaxfileupload.js"></script>
<script language="javascript" src="/js/My97DatePicker/WdatePicker.js"></script>
<script language="javascript" src="/js/layer/layer.js"></script>
<script type="text/javascript" src="/js/json/json-minified.js"></script>
<script type="text/javascript">
var cityIds = [];
var cityNames = [];
var goodslist="";
</script>
		
</head>
<style>
.fixed-table-toolbar {
	width: 100%;
	overflow: hidden;
}

.first {
	display: flex;
	align-items: center;
}

#modal {
	position: fixed;
	top: 0;
	z-index: 999;
	margin: 0 555px;
	display: none;
}

#image {
	display: none;
}

#images {
	display: none;
}

#videoFile {
	display: none;
}

.select {
	height: 38px;
	line-height: 38px;
	border-radius: 5px;
	border: 1px solid #ddd;
	width: 100%
}

#alertMsg {
	display: none;
}

#zoning {
	position: fixed;
	top: 0;
	z-index: 999;
	margin: 0 555px;
	display: none;
}

.provincesList {
	list-style: none;
	float: left;
	margin-left: 5px;
	margin-top: 10px;
	margin-bottom: 10px;
}

.pbox {
	list-style: none;
	float: left;
	margin-left: 5px;
	margin-top: 28px;
}

.provincesa {
	background: #23ccef;
	color: #fff;
	padding: 6px 5px;
}

.img_area {
	width: 30px;
	height: 30px;
}
.col-sm-6{
width: 50%;
    margin-bottom: 16px;
}
.col-sm-2{
margin-top: 10px;
text-align: right;
    font-size: 16px;
} 
 .col-sm-3{

margin-bottom: 16px;
}   
       
</style>
<body>

	<div class="wrapper">
		<!-- 左侧导航栏开始 -->
		<jsp:include page="/pages/inc/nav.jsp"></jsp:include>
		<!-- 左侧导航栏结束 -->
		<div class="main-panel" data-ps-id="fabe6d0c-fb7a-4814-760e-94b6d796f92a">
			<!-- 头部开始 -->
			<jsp:include page="/pages/inc/header.jsp"></jsp:include>
			<!-- 头部结束 -->
			<!-- 内容table开始 -->
			<div class="content">
				<div class="container-fluid">
					<form action="/platTeam/creatPlatTeam.do" name="categoryform"
						id="categoryform" method="post" accept-charset="utf-8">
						<div class="row">
							<div class="col-md-12">
								<div class="card">
									<div class="content">
										<legend>查看团购信息</legend>
										<!-- *团购名称 -->
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"><star>*</star>团购名称:</label>
												<div class="col-sm-6">
													${map.platTeam.teamName}
												</div>
												<span id="teamNameMsg" style="color: red"></span>
											</div>
										</fieldset>
										
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"><star>*</star>文字说明:</label>
												<div class="col-sm-6">
													<textarea id="ta_ckeditor" name="teamDescMsg" class="ckeditor" cols="40"  style="overflow:auto">
													${map.detailsMap.detailsType1}
													</textarea>
												</div>
												<span id="teamDescMsg" style="color: red"></span>
											</div>
										</fieldset>
										
										<c:if test="${map.detailsMap.detailsType2!=null}">
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"><star>*</star>单图:</label>
												<div class="col-sm-3">
													<img src="${map.detailsMap.detailsType2}"	id="imgUrla" style="width: 100px;"/>
												</div>
											</div>
										</fieldset>
										</c:if>
										<c:if test="${map.detailsMap.detailsType4!=null}">
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"><star>*</star>视频:</label>
												<div class="col-sm-3">
													<video width="1120" height="540" controls="controls" id="video" preload="auto"     >
    													<source src="${map.detailsMap.detailsType4}"   type="video/mp4">
													</source>
													</video>
													
												</div>
											</div>
										</fieldset>
										</c:if>
										<c:if test="${map.morePicList!=null}">
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"></label>
												<div class="col-sm-6">
													<div id="tu">
													 	<c:forEach items="${map.pageInfo.datas}" varStatus="item" var="pic">
														<img src="${pic.description}"  style="width:100px" />
														</c:forEach>
													</div>
												</div>
											</div>
										</fieldset>
										
										</c:if>
										
										<!-- 团购时间： -->
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"><star>*</star>
													团购时间:</label>
												<div class="col-md-3">
													<div class="form-group">
														<fmt:formatDate value="${map.platTeam.startTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/>
													</div>
												</div>
												<div class="col-md-3" >
													<div class="form-group">
														<fmt:formatDate value="${map.platTeam.endTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/>
													</div>
												</div>
											</div>
											<span id="timeDescMsg" style="color: red"></span>
										</fieldset>
										
										<!-- 物流方式： -->
										
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"><star>*</star>物流方式:</label>
												<div class="col-sm-6">
														<c:if test="${map.platTeam.logisticsType == 1}">团长自提</c:if>
														<c:if test="${map.platTeam.logisticsType == 2}">平台配送</c:if>
												</div>
												
												<!-- <div class="col-sm-6">
													<input type="radio" value="1" id="logistics_type"
														name="logistics_type" />加运费 <input type="radio"
														style="margin-left: 70px" value="2" id="logistics_type"
														name="logistics_type" />订单满 <input type="text"
														id="logistics_type" class="input-group-addon"
														name="logistics_type"
														style="width: 80px; border: 1px solid" />免运费
												</div> -->
												
												<span id="logisticsTypeMsg" style="color: red"></span>
											</div>
										</fieldset>
										

										<!--客服电话：-->
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"><star>*</star>客服电话:</label>
												<div class="col-sm-6">
													${map.platTeam.contact}
												</div>
												<span id="phoneMSG" style="color: red"></span>
											</div>
										</fieldset>
										

										<!--选择区域-->
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"><star>*</star>
													团购地点：</label>
												<div class="col-sm-6">
													<ul id="citysList">
														<c:forEach items="${map.regionList}" varStatus="item" var="region">
															<li class='provincesList' >
															<button class='btn btn-round btn-wd' >${region.region_name}</button>
															</li>
														</c:forEach>
													</ul>
												</div>
											</div>
										</fieldset>

										<fieldset>
											<div>
												<div class="card margintop20">
													<table class="table">
														<thead>
															<th class="text-center">商品ID</th>
															<th class="text-center">商品图片</th>
															<th class="text-center">商品名称</th>
															<th class="text-center">规格</th>
															<th class="text-center">标签</th>
															<th class="text-center">市场价</th>
															<th class="text-center">区域价</th>
															<th class="text-center">库存</th>
															<th class="text-center">VIP价</th>
															<%-- <th data-field="actions" class="text-center text-center"><spring:message
																	code="language.operation" /></th> --%>
														</thead>
														<tbody id="team">
														
														<c:forEach items="${map.PlatTeamRegionList}" varStatus="item"
														var="m">
														<tr>
															<td class='tcenter text-center'>${m.goodsId} </td>
															<td class='tcenter text-center'>
															<img src="${m.goodsPic} " alt="" width="60px;"/>
															</td>
															<td class='tcenter text-center'>${m.goodsName} </td>
															<td class='tcenter text-center'></td>
															<td class='tcenter text-center'></td>
															<td class='tcenter text-center'>${m.marketPrice} </td>
															<td class='tcenter text-center'>${m.regionPrice} </td>
															<td class='tcenter text-center'>${m.stock} </td>
															<td class='tcenter text-center'>${m.vipPrice} </td>
														</tr>
														
														<script type="text/javascript">
															goodslist+=${m.goodsId}+",";
														</script>
														
														</c:forEach>
														</tbody>
														<input type="hidden" id="goodsStr" name="goodsStr" value="" />
													</table>
												</div>

											</div>
											<span id="goodsMSG" style="color: red"></span>
										</fieldset>


										<!-- --------------------------- -->
									</div>
									<div class="footer text-center">
										<input type="button" class="btn btn-fill btn-wd" name="Submit"
											onclick="javascript:history.back(-1);" value="返回">
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

	<!-- 模态框（Modal） -->
	<div id="modal">
		<div class="modal-dialog" style="width: 1000px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true"></button>
					<h4 class="modal-title" id="myModalLabel">选择商品</h4>
				</div>
				<div class="modal-body"
					style="width: 1000px; height: 800px; text-align: center;">
					<!-- 内容table开始 -->
					<div class="content">
						<div class="container-fluid">
							<div class="row">
								<div class="col-md-12">
									<div class="card">
										<!-- 商品名称 -->
										<div class="col-md-2" style="width: 250px;">
											<div class="">
												<input type="text"
													placeholder="<spring:message code="language.goodsname" />"
													class="form-control" style="width: 190px" id="goodsName"
													name="goodsName" value="" />
											</div>
										</div>

										<!-- 商品编号 -->
										<div class="col-md-2" style="width: 250px;">
											<div class="form-group">
												<input type="text"
													placeholder="<spring:message code="language.goodsCode" />"
													class="form-control" style="width: 190px" id="goodsCode"
													name="goodsCode" value="" />
											</div>
										</div>

										<div class="footer">
											<a class="btn btn-info btn-fill btn-wd" onclick="queren();">确认商品</a>
											<button class="btn btn-info btn-fill btn-wd" type="button"
												onclick="getGood();">查询</button>
											<button type="button" class="btn btn-info btn-fill btn-wd"
											id="closeModal">关闭</button>
										</div>
										<div class="card margintop20">
											<table class="table" id="querentable">
												<thead>
													<th class="text-center"><input type="checkbox"
														id="all" />全选</th>
													<th class="text-center"><spring:message
															code="language.goodsCode" /></th>
													<th class="text-center">商品图片</th>
													<th class="text-center"><spring:message
															code="language.goodsname" /></th>
													
													<th class="text-center">规格</th>
													<th class="text-center">商品标签</th>
													<th class="text-center">成本价(元)</th>
													<th class="text-center">市场价(元)</th>
													
													<!-- <th class="text-center">会员折扣</th> -->
													<th class="text-center">库存</th>
													<th class="text-center">会员价(元)</th>
													<%-- <th data-field="actions" class="text-center text-center"><spring:message
															code="language.operation" /></th> --%>
												</thead>
												<tbody id="text">

												</tbody>
											</table>
										</div>
										<%-- <div class="newpages">
											<%@include file="/page/page.jsp"%>
										</div> --%>
									</div>
								</div>
							</div>
							<!-- end col-md-12 -->
						</div>
						<!-- end row -->
					</div>
				</div>
				<!-- 内容table结束 -->
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->

	<div class="alert alert-warning" id="alertMsg"
		style="width: 200px; height: 200px">
		<a href="#" class="close" data-dismiss="alert"> &times; </a> <strong>警告！</strong>发布失败
	</div>

	<!-- 区划 -->
	<div id="zoning">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true"></button>
					<h4 class="modal-title" id="myMolLabel">选择团购区域</h4>
				</div>
				<div class="modal-body"height: 600px">
					<div>
						<!-- <button type="button" class="close" data-dismiss="modal"
						aria-hidden="true" onclick="getProvinces()">添加省份</button> -->
						<!-- <p style="color: blue">添加省份</p> -->
						<!-- onclick="getProvinces()" -->
						<div>
							<ul id="provincesTab"></ul>
						</div>
						<div style="clear: both;"></div>
						<div>
							<h6>
								选择城市
								</h>
								<ul id="citysTab"></ul>
						</div>
						<div style="clear: both;"></div>
						<!-- <div>
							<h6>
								添加对应县
								</h>
								<ul id="countysTab"></ul>
						</div> -->
					</div>

				</div>
				<div class="modal-foot"
					style="width: 850px; height: 100px; text-align: center;">
					
					<button type="button" class="btn btn-info btn-fill btn-wd" id=""
						onclick="saveZoning()">确认</button>
						
					<button type="button" class="btn btn-info btn-fill btn-wd"
						id="closeZoning">关闭</button>
					
				</div>
			</div>
		</div>
	</div>

	<%-- 	<!-- 右侧设置开始 -->
	<jsp:include page="/pages/inc/setting.jsp"></jsp:include>
	<!-- 右侧设置结束 --> --%>
	<script type="text/javascript">
		var goodName = "";
		var goodsCode = "";
		
		var imgsUrl = [];
		function getProvinces() {
			$.ajax({
				type : "GET",
				url : "/genArea/getArea.do",
				dataType : "json",
				success : function(data) {
					var html = '';
					for (var i = 0; i < data.length; i++) {
						html += "<li class='provincesList'>"
								+ "<button class='btn btn-round btn-wd' onclick='getCitys("
								+ data[i].AREA_NO + ")'>" + data[i].AREA_NAME
								+ "</button>"/* +"<a><input type='hidden' id = 'area_no' value = "+data[i].AREA_NO+"/></a>" */
								/* + '<a><input type="checkbox" onchange="setCitys('
								+ data[i].AREA_NO + ',\''
								+ data[i].AREA_NAME + '\')" /></a>' */
								+ "</li>"

					}
					$("#provincesTab").html(html);
				}
			});
		}

		function getCitys(parentId) {
			$.ajax({
						type : "GET",
						url : "/genArea/getArea.do?parentId=" + parentId,
						dataType : "json",
						success : function(data) {
							var html = '';
							for (var i = 0; i < data.length; i++) {
								html += "<li class='provincesList' >"
										+ "<button class='btn btn-simple btn-wd' onclick='getCountys("
										+ data[i].AREA_NO
										+ ")'>"
										+ data[i].AREA_NAME
										+ "</button>"
										+ "<a><input type='checkbox' id = 'cityBox'/></a>"
										+ "<a><input type='hidden' id = 'area_no' value = "+data[i].AREA_NO+"></a>"
										+ "</li>"
							}
							$("#citysTab").html(html);
						}
					});
		}

		/* function getCountys(parentId) {
			$
					.ajax({
						type : "GET",
						url : "/genArea/getArea.do?parentId=" + parentId,
						dataType : "json",
						success : function(data) {
							var html = '';
							for (var i = 0; i < data.length; i++) {
								html += "<li class='provincesList' >"
										+ "<a class='provincesa' onclick='getCountys("
										+ data[i].AREA_NO
										+ ")'>"
										+ data[i].AREA_NAME
										+ "</a>"
										+ '<a><input type="checkbox" onchange="setCitys('
										+ data[i].AREA_NO + ',\''
										+ data[i].AREA_NAME + '\')" /></a>'
										+ "</li>"
							}
							$("#countysTab").html(html);
						}
					});
		} */

		/* function setCitys(cityId, cityName) {
			cityIds.push(cityId);
			cityNames.push(cityName);
		} */
		
		function initCityList(city,cityId){
			cityNames.push(city);
			cityIds.push(cityId);
		}
		function saveZoning() {
			var tb = document.getElementById('citysTab');
			obj = document.getElementById("cityBox");
			var rows = tb.children.length;
			var city = '';
			var cityId = '';
			for (var i = 0; i < rows; i++) {
				if (tb.childNodes[i].childNodes[1].firstChild.checked) {
					city = tb.childNodes[i].innerText;
					cityId = tb.childNodes[i].childNodes[2].firstChild.value;
					cityNames.push(city);
					cityIds.push(cityId);
				}
			}
			cityNames = getret(cityNames);
			cityIds = getret(cityIds);
			showCitys();
		}
		function getret(arr) {
			var ret = [];
			for (var i = 0; i < arr.length; i++) {
				if (arr.indexOf(arr[i]) == i) {
					ret.push(arr[i]);
				}
			}
			return ret;
		};

		function showCitys() {
			var html = '';
			for (var i = 0; i < cityNames.length; i++) {
				html += "<li class='provincesList' >"
						+ "<button class='btn btn-round btn-wd' >"
						+ cityNames[i]
						+ "</button>"
						+ '<a><i class ="pe-7s-close-circle" onclick = "removeCity('
						+ cityIds[i] + ',\'' + cityNames[i] + '\')"></i></a>'
						+ "</li>"
			}
			$("#citysList").html(html);
			$("#zoning").css("display", "none");
		}

		function removeCity(cityId, cityName) {
			removeArr(cityId, cityName);
			showCitys();
		}

		function removeArr(id, name) {
			var index = getIndex(id, cityIds);
			if (index > -1) {
				cityIds.splice(index, 1);
			}
			var index1 = getIndex(name, cityNames);
			if (index1 > -1) {
				cityNames.splice(index, 1);
			}
		}

		function getIndex(id, arr) {
			for (var i = 0; i < arr.length; i++) {
				if (arr[i] == id) {
					return i;
				}
			}
			return -1;
		}

		$(function() {
			var ue = UE.getEditor("ta_ckeditor");
			UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
			UE.Editor.prototype.getActionUrl = function(action) {
				//调用自己写的Controller
				if (action == 'uploadimage' || action == 'uploadfile') {
					return "/imageUpload/upload.do"; //自己controller的action
				} else if (action == "uploadvideo") {
					return ""; //自己controller的action
				} else {
					return this._bkGetActionUrl.call(this, action); //百度编辑器默认的action
				}
			}
		});

		function onSelectChange(obj, toSelId) {
			setSelect(obj.value, toSelId);
		}

		//区域价格
		function regionalPrices(goodsId) {
			location.href = "/goodsSku/addRegionalPrices.do?goods_id="
					+ goodsId;
		}
	</script>
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
					'<i class="fa fa-remove"></i>', '</a>' ].join('');
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
			$("#descImage").on("click", function() {
				$("#image").css("display", "block");
			})
			$("#descImages").on("click", function() {
				$("#images").css("display", "block");
			})
			$("#descVideo").on("click", function() {
				$("#videoFile").css("display", "block");
			})
			$("#goodModal").on("click", function() {
				$("#modal").css("display", "block");
			})
			$("#cityModal").on("click", function() {
				$("#zoning").css("display", "block");
			})
			$("#closeZoning").on("click", function() {
				$("#zoning").css("display", "none");
			})
			$("#closeModal").on("click", function() {
				$("#modal").css("display", "none");
			})

		});

		//区域价格
		function selectprice() {
			location.href = "/pages/teamBuy/MyJsp.jsp";
		}
		//选择商品弹窗
		function getGoods() {
			goodsInfoList();
		}

		//点击查询
		function getGood() {
			goodName = $("#goodsName").val();
			goodsCode = $("#goodsCode").val();
			//location.href = "/goodsInfo/getGoodsInfoList.do?goodsName="+goodName+"&goodsCode="+goodsCode; 
			goodsInfoList();

		}
		//商品列表
		function goodsInfoList() {
			var currentPage = $("#currentPage").val();
			$
					.ajax({
						type : "GET",
						url : "/goodsInfo/getGoodsInfoList.do?goodsName="
								+ goodName + "&goodsCode=" + goodsCode,
						dataType : "json",
						success : function(data) {
							var html = '';
							var datatext = data.pageInfo.datas;
							for (var i = 0; i < datatext.length; i++) {
							debugger
								var stock = datatext[i].stock;
								
								if(stock == undefined){
									stock = "不限";
								}
								html += "<tr>"
										+ "<td class='tcenter text-center'>"
										+ "<input type='checkbox' class='all' name='all' value='' />"
										+ "</td>"
								html += "<td class='tcenter text-center'>"
										+ datatext[i].goods_id + "</td>"
								html += "<td class='tcenter text-center'>"
										+ "<img src='"+datatext[i].goods_pic + "' style = 'width:60px;'></img></td>"
								html += "<td class='tcenter text-center'>"
										+ datatext[i].goods_name + "</td>"
								html += "<td class='tcenter text-center'>"
										+ datatext[i].spec + "</td>"
								html += "<td class='tcenter text-center'>"
										+ datatext[i].label_name + "</td>"
								html += "<td class='tcenter text-center'>"
										+ datatext[i].cost_price + "</td>"
								html += "<td class='tcenter text-center'>"
										+ datatext[i].market_price + "</td>"
								html += "<td class='tcenter text-center'>"
										+ stock + "</td>"
								html += "<td class='tcenter text-center'>" + ""
										+ "</td>"
								/* html += "<td class='tcenter text-center'>"
										+ "<a onclick='selectgood("
										+ datatext[i].goods_id + ")'>查看详情</a></td>" */
								html += "</tr>"
							}
							$("#text").html(html);
						}
					});
		}

		function selectgood(goodsId) {
			window.open("/goodsInfo/getGoodsAttrList.do?goods_id=" + goodsId);
		}

		var goods = [];
		function queren() {
		debugger
			var goodIds = [];
			if (goods.length != 0) {
				for (var i = 0; i < goods.length; i++) {
					goodIds.push(goods[i].goods_id);
				}
			}
			var tb = document.getElementById('querentable');
			obj = document.getElementsByName("all");
			var rows = tb.rows;
			for (var i = 0; i < rows.length; i++) {
				if (rows[i].cells[0].childNodes[0].checked) {
					var map = {};
					map.goods_code = rows[i].cells[1].innerHTML;
					map.goods_pic = rows[i].cells[2].innerHTML;
					map.goods_name = rows[i].cells[3].innerHTML;
					map.spec = rows[i].cells[4].innerHTML;
					map.label_name = rows[i].cells[5].innerHTML;
					
					map.cost_price = rows[i].cells[6].innerHTML;
					map.market_price = rows[i].cells[7].innerHTML;
					map.stock = rows[i].cells[8].innerHTML;
					map.vip_price = rows[i].cells[9].innerHTML;
					
					var index = getIndex(rows[i].cells[1].innerHTML, goodIds);
					if (index > -1) {
					} else {
						goods.push(map);
					}
				}
			}
			$("#modal").css("display", "none");
			getParam();
		}
		
		

		function getParam() {
			var tb = document.getElementById('team');
			var html = "";
			//$("#team").html("");
			var goodsStr = "";
			for (var i = 0; i < goods.length; i++) {
				html += "<tr>"
				html += "<td class='tcenter text-center'>"
						+ goods[i].goods_id + "</td>"
				html += "<td class='tcenter text-center'>"
						+ goods[i].goods_pic
				html += "<td class='tcenter text-center'>"
						+ goods[i].goods_name + "</td>"
				html += "<td class='tcenter text-center'>" + goods[i].spec
						+ "</td>"
				html += "<td class='tcenter text-center'>"
						+ goods[i].label_name + "</td>"
				
				html += "<td class='tcenter text-center'>"
						+ goods[i].cost_price + "</td>"
				html += "<td class='tcenter text-center'>"
						+ goods[i].market_price + "</td>"
				html += "<td class='tcenter text-center'>" + goods[i].stock
						+ "</td>"
				html += "<td class='tcenter text-center'>" + "" + "</td>"
				/* html += "<td class='tcenter text-center'>"
						+ "<a onclick='selectgood(" + goods[i].goods_id
						+ ")'>查看详情</a>" + "</td>" + "</tr>"; */
				html +="</tr>";
				goodsStr += goods[i].goods_id + ",";
			}
			$("#goodsStr").val(goodsStr);
			$("#team").prepend(html);
		}

		function savePlat() {
			var region_type = 3;
			debugger
			/* var province = $("#province").val();
			var city = $("#city").val();
			if (city == '' || city == undefined || city == null) {
				if (province == '' || province == undefined || province == null) {
					region_type = 1
				}
			}
			if (city == '' || city == undefined || city == null) {
				if (!province == '' || !province == null) {
					region_type = 2
				}
			}
			if (!city == '' || !city == null) {
				region_type = 3
			} */
			var team_name = $("#team_name").val();
			var pteamId = $("#pteamId").val();
			var teamDescMsg = UE.getEditor('ta_ckeditor').getContent();
			var imgUrl = $("#imgUrl").val();
			var videoUrl = $("#videoUrl").val();
			var startTime = $("#startTime").val();
			var endTime = $("#endTime").val();
			var goodsStr = $("#goodsStr").val();
			var contact = $("#contact").val();
			var logistics_type = $('input[name="logistics_type"]:checked').val();
			if (team_name == "" || team_name == null) {
				$("#teamNameMsg").html("请输入团购名称");
				return;
			}
			if (teamDescMsg == "" || teamDescMsg == null) {
				$("#teamDescMsg").html("请检查团购详情是否已包含文字介绍，图片，多图以及视频介绍");
				return;
			}
			/* if (imgUrl == "" || imgUrl == null) {
				$("#teamDescMsg").html("请检查团购详情是否已包含文字介绍，图片，多图以及视频介绍");
				return;
			}
			if (imgsUrl.length <= 0) {
				$("#teamDescMsg").html("请检查团购详情是否已包含文字介绍，图片，多图以及视频介绍");
				return;
			} */
			if (startTime == "" || startTime == null) {
				$("#timeDescMsg").html("请填写团购开始时间");
				return;
			}
			if (endTime == "" || endTime == null) {
				$("#timeDescMsg").html("请填写团购结束时间");
				return;
			}
			
			if (logistics_type == "" || logistics_type == null || logistics_type == "undefined") {
				$("#logisticsTypeMsg").html("请选择物流方式");
				return;
			}
			
			
			if (cityIds == "" || cityIds == null) {
				$("#cityMSG").html("请选择团购区域");
				return;
			}
			if (contact == "" || contact == null) {
				$("#phoneMSG").html("请填写客服电话");
				return;
			}
			if (goodsStr == "" || goodsStr == null) {
				$("#goodsMSG").html("请选择要团购的商品");
				return;
			}
			var datastr = {
				region_type : region_type,
				team_code : $("#team_code").val(),
				team_name : team_name,
				pteamId : pteamId,
				imgUrl : imgUrl,
				imgsUrl : imgsUrl.toString(),
				videoUrl : videoUrl,
				startTime : startTime,
				endTime : endTime,
				logistics_type : $("#logistics_type").val(),
				contact : contact,
				province : $("#province").val(),
				cityIds : cityIds.toString(),
				cityNames : cityNames.toString(),
				district1 : $("#district1").val(),
				teamDescMsg : teamDescMsg,
				goodsStr : goodsStr,
			};
			
			jQuery.ajax({
				url : "/platTeam/updatePlatTeam.do",
				data :datastr,
				type : "post",
				dataType : "json",
				success : function(data) {
				var code = data.code;
					if (code == "0") {
						// 页面刷新
						swal(data.msg, "success");
						location.href="/platTeam/platTeamList.do";
					} else {
						swal(data.msg, "fail");
					}
				},
			});
			
			
		}
		function getImage(image, type) {
			ajaxFileUploadMY(image, type);

		}
		function getImages(images, type) {
			ajaxFileUploadMY1(images, type)
		}
		var num=0
		function ajaxFileUploadMY1(divID, type) {
			if (divID == null) {
				divID = "file";
			}
			$.ajaxFileUpload({
				url : "/fileUpload/imgsUpload.action", //需要链接到服务器地址
				secureuri : false,
				dataType : 'multipart/form-data',
				fileElementId : divID, //文件选择框的id属性
				dataType : 'json', //服务器返回的格式，可以是json
				success : function(data, status) //相当于java中try语句块的用法
				{
					//newpic();
					num++;
					var images_url = data.image_url;
					var imagesFlag= "pic_url"+num;
					var htm =  '<input id="'+imagesFlag+'" type="hidden" name="teamPics['+num+'].picUrl" class="'+imagesFlag+'"/>'
					+ '<img src="'+images_url+'" id="'+imagesFlag+'"  style="width:100px" class="'+imagesFlag+'"/>'
					+ '<i class ="pe-7s-close-circle '+imagesFlag+'"  id="'+imagesFlag+'" onclick = remove(\''+imagesFlag+'\') ></i>';
					
					aa = document.getElementById("tu");
					$("#tu").prepend(htm);								
														
					
				},
				error : function(data, status, e) {
				}
			});
		}
		
		
		function getVideo(video, type) {
			ajaxFileUploadMY2(video, type)
		}
		//上传图片
		function ajaxFileUploadMY(divID, type) {
			if (divID == null) {
				divID = "file";
			}
			$.ajaxFileUpload({
				url : "/fileUpload/fileUpload.action", //需要链接到服务器地址  
				secureuri : false,
				dataType : "multipart/form-data",
				fileElementId : divID, //文件选择框的id属性  
				dataType : "json", //服务器返回的格式，可以是json  
				success : function(data, status) //相当于java中try语句块的用法 
				{
					if (data.image_url != null) {
						$("#imgUrl").val(data.image_url);
						$("#imgUrla").attr("src", data.image_url);
					}
				},
				error : function(data, status, e) {
				}
			});
		}

		function ajaxFileUploadMY2(divID, type) {
			if (divID == null) {
				divID = "viveo";
			}
			$.ajaxFileUpload({
				url : "/fileUpload/videoUpload.action", //需要链接到服务器地址  
				secureuri : false,
				dataType : "multipart/form-data",
				fileElementId : divID, //文件选择框的id属性  
				dataType : "json", //服务器返回的格式，可以是json  
				success : function(data, status) //相当于java中try语句块的用法 
				{
					if (data.image_url != null) {
						$("#videoUrl").val(data.image_url);
						$("#videoUrla").attr("src", data.image_url);
					}
				},
				error : function(data, status, e) {
				}
			});
		}

		var num1 = 0;
		// newNode.innerHTML = '我是子元素append'
		function newpic() {
			num++;
			var divid = "pic" + num;
			var inpid = "imgs" + num;
			var pic_url = "pic_urla" + num;
			var sas = document.getElementById("imgs" + (num - 1));
			sas.style.display = "none";
			var htm = '';
			var htm = '<div class="form-group " style="width:100px;float:left;margin-right:30px" id="'+divid+'">\n'
					+ '                <input data-options="prompt:\'Choose a file...\'" type="file"\n'
					+ '                       id=\''
					+ inpid
					+ '\' name="imgs"\n'
					+ '                       onchange="getImages(\''
					+ inpid
					+ '\','
				
					+ ')"/>\n'
					+ '                <input id="pic_url'+num+'" type="hidden" name="teamPics['+num+'].picUrl" />\n'
					+ '                <img src="" id="'+pic_url+'"  style="width:100px" />\n'
					+ '                <div id="pic_div1" style="display:block;">\n'
					+ '                    <input id="isHome1" name="teamPics[1].isHome"  type="hidden" value="1" />\n'
					+ '                    <a type="button"  onclick="remove(\''
					+ divid
					+ '\');" id="delete'
					
					+ '" style="display:none;">删除</a>\n'
					+ '                </div>\n' + '         </div>';
			var newNode = document.createElement("div");
			newNode.innerHTML = htm;
			aa = document.getElementById("tu");
			// alert(aa);
			aa.append(htm);
		}
		function remove(picid) {
			for (i = 0; i < imgsUrl.length; i++) {
				var map = imgsUrl[i];
				if (picid == map.name) {
					imgsUrl.splice(i, 1);
				}
			}
			$("."+picid).remove();
		}

		function closeVideoDiv() {
			$("#videoFile").css("display", "none");
		}
		function closeImgsDiv() {
			$("#images").css("display", "none");
		}
		function closeImgDiv() {
			$("#image").css("display", "none");
		}
	</script>
</body>
<%-- <%-- <%@ include file="../inc/footer.html"%> --%>
</html>