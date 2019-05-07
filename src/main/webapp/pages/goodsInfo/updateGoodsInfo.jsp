<%@ page language="java"
	import="java.util.*,com.website.utils.CommonsUtil"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/bootstrap.min.css" rel="stylesheet" />
<link href="/css/light-bootstrap-dashboard.css" rel="stylesheet" />
<link href="/css/common.css" rel="stylesheet" />
<link href="/css/font-awesome.min.css" rel="stylesheet">
	<link href='/css/685fd913f1e14aebad0cc9d3713ee469.css' rel='stylesheet'
		type='text/css'>
		<link href="/css/pe-icon-7-stroke.css" rel="stylesheet" />
		<title>编辑商品</title> <script language='javascript' src="js/edit.js"></script>
		<script type="text/javascript"
			src="/js/ueditor1.4.3.3/ueditor.config.js"></script>
		<script type="text/javascript" src="/js/ueditor1.4.3.3/ueditor.all.js"></script>
		<script language='javascript' src="/js/jquery-1.8.3.min.js"></script>
		<script language="javascript" src="/js/My97DatePicker/WdatePicker.js"></script>
		<script language="javascript" src="/js/layer/layer.js"></script>
</head>
<style>
.select {
	height: 38px;
	line-height: 38px;
	border-radius: 5px;
	border: 1px solid #12101066;
	width: 200px;
}

.list-border {
	height: 70px;
	border: 1px solid #a0a0a0;
	border-radius: 5px;
	display: block;
	padding: 10px;
}

.line {
	width: 180px;
	float: left
}

.select1{
width:180px;
float:left
}
.select{
width:160px	;
}

.form-control{
	width: 250px;
	margin-left: 6%
}
.control-label{
width: 90px;
}
</style>
<body>
	<div class="wrapper">
		<!-- 左侧导航栏开始 -->
		<jsp:include page="/pages/inc/nav.jsp"></jsp:include>
		<!-- 左侧导航栏结束 -->
		<div class="main-panel"
			data-ps-id="fabe6d0c-fb7a-4814-760e-94b6d796f92a">
			<!-- 头部开始 -->
			<jsp:include page="/pages/inc/header.jsp"></jsp:include>
			<!-- 头部结束 -->
			<!-- 内容table开始 -->
			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<form class="form-horizontal" id="updateGoodsInfoFrom"
									action="/goodsInfo/updateGoods.do" name="updateGoodsInfoFrom"
									method="post" enctype="multipart/form-data">
									<div class="content">
										<legend>
											修改商品
										</legend>
										<!-- 1.商品名称 -->
										<fieldset>
											<div class="col-sm-6 form-group first">
												<label class="col-sm-2 control-label"><star>*</star>
													商品名称:</label>
												<div class="col-sm-6">
													<input value="${map.goodsInfo.goods_name}" class="form-control" id="goodsName" name="goodsName"
														placeholder="请输入商品名称（不超过15个字）" required>
												</div>
												<span id="goodsNameMSG" style="color: red"></span>
											</div>
										</fieldset>

										<!-- 商品分类 -->
										<fieldset>
											<div class="col-sm-6 form-group first" style="width:90%">
												<label class="col-sm-2 control-label"> 商品分类:</label>
												<div class="col-sm-6" style="width:700px;margin-left:1.50%">
													<div class="  select1">
													<select id="typeGrand" name="parent_id" class="select" 
														onchange="getSecondType();">
														<option value="">${map.goodsInfo.level1}</option>
														<c:forEach items="${map.categoryList}" var="c">
															<option value="${c.category_id}"
																${map.parent_id == c.category_id?'selected':''}>
																<c:out value="${c.category_name}" />
															</option>
														</c:forEach>
													</select> 
													</div>
													<div class="  select1">
													<select id="typeParent" name="child_id" class="select" 
														onchange="getThridType();">
														<option value="">${map.goodsInfo.level2}</option>
													</select> 
													</div>
													<div class="  select1">
													<select id="typeThrid" name="categoryId" class="select">
														<option value="" name="category_name">${map.goodsInfo.level3}</option>
													</select>
													</div>
												</div>
											</div>
										</fieldset>

										<!--*商品规格-->
										<fieldset>
											<div class="col-sm-6 form-group first">
												<label class="col-sm-2 control-label"><star>*</star>商品规格:</label>
												<div class="col-sm-6">
													<input value="${map.goodsInfo.spec}" class="form-control" id="spec" name="spec"
														placeholder="公斤等:" required />
												</div>
												<span id="goodsSpecMSG" style="color: red"></span>
											</div>
										</fieldset>

										<!-- 商品亮点-->
										<fieldset>
											<div class="col-sm-6 form-group first">
												<label class="col-sm-2 control-label"><star>*</star>
													商品亮点:</label>
												<div class="col-sm-6">
													<input value="${map.goodsInfo.description}" class="form-control" id="adWords" name="adWords"
														placeholder="请描述商品亮点（不超过20个字）" required />
												</div>
												<span id="adWordsMSG" style="color: red"></span>
											</div>
										 </fieldset>
										  <!-- 简单描述-->
										<!--<fieldset>
											<div class="col-sm-6 form-group first">
												<label class="col-sm-2 control-label"><star>*</star>
													简单描述:</label>
												<div class="col-sm-6">
													<input class="form-control" id="adWords" name="adWords"
														placeholder="请简单描述（不超过20个字）" required>
												</div>
												<span id="adWordsMSG" style="color: red"></span>
											</div>
										 </fieldset> -->
										 <!-- 成本价 -->
										<fieldset>
											<div class="col-sm-6 form-group first" >
												<label class="col-sm-2 control-label" ><star>*</star>
												成本价:</label>
												<div class="col-sm-6 " >
													<input value="${map.goodsInfo.cost_price}" onchange="costPriceClick();" type="number" class="form-control" id="costPrice" name="costPrice" placeholder="元">
												</div>
												<span id="costPriceMSG" style="color: red"></span>
											</div>
										</fieldset>
										
										<fieldset>
											<div class="col-sm-6 form-group first" >
												<label class="col-sm-2 control-label" ><star>*</star>
												市场价 :</label>
												<div class="col-sm-6 " >
													<input value="${map.goodsInfo.market_price}" onchange="marketPriceClick();" type="number" class="form-control" id="marketPrice" name="marketPrice" placeholder="元">
												</div>
												<span 	id="marketPriceMSG" style="color: red"></span>
											</div>
										 </fieldset>
										 <!-- 会员 -->
										 <fieldset>
										    <div class="col-sm-6 form-group first" >
												<label class="col-sm-2 control-label" >
												会员价 :</label>
												<div class="col-sm-6 " >
													<input value="${map.goodsInfo.vip_price}" onchange="zhekouClick();" type="number" class="form-control" id="vipPrice" name="vipPrice" placeholder="元">
												</div>
												<span 	id="vipPriceMSG" style="color: red"></span>
											</div>
										</fieldset>
										<!-- 上下架  -->
										<fieldset>
											<div class="col-sm-6 form-group first">
												<label class="col-sm-2 control-label"><star>*</star>
													状态:</label>
												<div class="col-sm-6" style="margin-top: 9px;margin-left:20px">
													<input type="radio" value="1" id="isShow" name="status"
													<c:if test="${map.goodsInfo.status==1}">checked="checked"</c:if>	/>上架 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
													<input <c:if test="${map.goodsInfo.status==0}">checked="checked"</c:if> type="radio" value="0" id="notShow" name="status" />下架
												</div>
												<span id="statusMSG" style="color: red"></span>
											</div>
										</fieldset>
										 <!--商品库存 -->
										 <fieldset>
											<div class="col-sm-6 form-group " style="width:800px">
												<label class="col-sm-2 control-label" >
												商品库存:</label>
												<div class="col-sm-6" style="margin-top:9px;margin-left:18px">
													<input <c:if test="${map.goodsInfo.stock_type==1}">checked="checked"</c:if> type="radio" value="1" id="nStock" name="stockType" checked="checked"/>不限库存
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			                                        <input <c:if test="${map.goodsInfo.stock_type==2}">checked="checked"</c:if> type="radio" value="2" id="yStock" name="stockType" />共享库存
			                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			                                        <input <c:if test="${map.goodsInfo.stock_type==2}">value="${map.goodsInfo.stock}"</c:if> type="number"  onchange="stockClick();"  id="Stock" name="stock"/>
												</div>
											</div>
										</fieldset>
										<!--商品标签 -->
										 <fieldset>
											<div class="col-sm-6 form-group" style="width:80%">
												<label class="col-sm-2 control-label" >
												商品标签:</label>
												<div class="col-sm-6" style="margin-top:9px;margin-left:18px">
													<c:forEach items="${map.goodsLabels}" var="c">
														<input <c:if test="${map.goodsInfo.label_id==c.labelId}">checked="checked" </c:if> 
														type="radio"  id="isNew"  value="${c.labelId}"  name="labelId"/>${c.labelName}
														&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													</c:forEach>
												</div>
											</div>
										</fieldset>
										<!--退货时效 -->
										 <fieldset>
											<div class="col-sm-6 form-group"  style="width:900px">
												<label class="col-sm-2 control-label" >*
												退货时效:</label>
												<div class="col-sm-6" style="margin-top:9px;margin-left:18px">
													<input <c:if test="${map.goodsInfo.return_type==1}">checked="checked" </c:if> type="radio" value="1" id="return1" name="returnType" checked="checked"/>不允许退货
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			                                        <input <c:if test="${map.goodsInfo.return_type==0}">checked="checked" </c:if> type="radio" value="0" id="return2" name="returnType"/>不限制退货
			                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			                                        <input <c:if test="${map.goodsInfo.return_type==2}">checked="checked" </c:if> type="radio" value="2" id="return3" name="returnType"/>截单前
			                                        <input type="number"  onchange="returnChange()" id="returnText" name="returnTime" <c:if test="${map.goodsInfo.return_type==2}">value="${map.goodsInfo.return_time}"</c:if> style="width:80px"/>小时可退
												</div>
												<span id="returnTypeMSG" style="color: red"></span>
											</div>
										</fieldset>
										<fieldset></fieldset>
										<!-- 7.图片 -->
										<fieldset>
											<div class="col-sm-6 form-group first">
												<label class="col-sm-2 control-label"><star>*</star>
													<spring:message code="language.bannerPic" />:</label>
												<div class="" style="margin-left:18px">
													<div class="col-md-12" style="margin-top: -23px;width:900px">
														<div id="tu" class=""
															style="margin-left:100px; margin-right: 30px;">
															<!--  -->
															<c:forEach items="${map.goodsPics}" var="c" varStatus="i" begin="0" end="${map.goodsPicSize}">
																<c:if test="${c.picUrl!=''}"> 
																	<div>
																		<div class="form-group  " id="pic100"
																			style="float: left; margin-right: 30px">
																			<img src="${c.pic_url}" id="pic_urla100" style="width: 100px" />
																			<input id="pic_url100" type="hidden" name="goodsPics[${i.count}].picUrl" value="${c.pic_url}" />
																			<div id="pic_div100" style="display: block;">
																				<a type="button" 	onclick="remove('pic100');" id="delete100" >删除</a>
																			</div>
																		</div>
																	</div>
																</c:if>
															</c:forEach>
															<!--  -->
															<div>
																<div class="form-group  " id="pic0"
																	style="float: left; margin-right: 30px">
																	<input data-options="prompt:'Choose a file...'"
																		type="file" id='file0' name="file"
																		onchange="ajaxFileUploadMY('file0',0)" /> 
																	<input id="pic_url0" type="hidden" name="goodsPics[0].picUrl" /> 
																	<img src="" id="pic_urla0" style="width: 100px" />
																	<div id="pic_div0" style="display: block;">
																		<!-- <input id="isHome0" name="goodsPics[0].isHome" type="hidden" value="0" />  -->
																		<a type="button"  onclick="remove('pic0');" id="delete0" 	style="display: none;">删除</a>
																	</div>
																</div>
															</div>
														</div>
														<span id="pic_urlMSG" style="color: red"></span>
													</div>
												</div>
										</fieldset>



										<!-- 商品详情
										<fieldset>
											<div class="col-sm-6 form-group first">
												<label class="col-sm-2 control-label"><star></star>
													<spring:message code="language.goodsDetails" />:</label>
												<div class="col-sm-6" style="width: 600px">
													<textarea id="ta_ckeditor" name="goodsDesc"
														class="ckeditor" cols="20" style="overflow: auto">
													</textarea>
												</div>
												<span id="goodsDescMsg" style="color: red"></span>
											</div>
										</fieldset>
										 -->
										<!--售后承诺 -->
										 <fieldset>
											<div class="col-sm-6 form-group first">
												<label class="col-sm-2 control-label" >
												售后承诺:</label>
												<div class="col-sm-6" style="margin-top:9px;;margin-left:18px">
			                                        <!-- <input type="text"  value="" id="isHomeShow" name="commitment"  size="200" style="width:510px;height:100px;" placeholder="请输入售后承诺（不超过200个字）"/> -->
													<textarea  id="commitment" name="commitment" cols="30" rows="10" style="width:510px;height:100px;" />${map.goodsInfo.commitment}</textarea>
												</div>
											</div>
										</fieldset>

										<div class="footer text-center">
											<button type="button" class="btn btn-info btn-fill btn-wd"
												id="doSubmit" onclick="checkInfo();">确定</button>

											<button type="button" class="btn btn-fill btn-wd"
												onclick="goToList();">返回</button>
										</div>
										<div>
											<input type="hidden" value="${map.goodsInfo.goods_id}" name="goodsId" id="goodsId"/>
										</div>
								</form>
							</div>
							<!--  end card  -->
						</div>
						<!-- end col-md-12 -->
					</div>
					<!-- end row -->
				</div>
				<div id="tu"></div>
			</div>
			<!-- 内容table结束 -->

			<!-- 底部开始 -->
			<jsp:include page="/pages/inc/footer.jsp"></jsp:include>
			<!-- 底部结束 -->
		</div>
	</div>

	<script type="text/javascript">
		var num = 0;
		// newNode.innerHTML = '我是子元素append'
		function newpic() {
			num++;
			var divid = "pic" + num;
			var inpid = "file" + num;
			var pic_url = "pic_urla" + num;
			var sas = document.getElementById("file" + (num - 1));

			sas.style.display = "none";
			var htm = '';
			var htm = '<div class="form-group " style="float:left;margin-right:30px" id="'+divid+'"  style="width:100px">\n'
					+ '                <input data-options="prompt:\'Choose a file...\'" type="file"\n'
					+ '                       id=\''
					+ inpid
					+ '\' name="file"\n'
					+ '                       onchange="ajaxFileUploadMY(\''
					+ inpid
					+ '\','
					+ num
					+ ')"/>\n'
					+ '                <input id="pic_url'+num+'" type="hidden" name="goodsPics['+num+'].picUrl" />\n'
					+ '                <img src="" id="'+pic_url+'"  style="width:100px" />\n'
					+ '                <div id="pic_div1" style="display:show;">\n'
					+ '                    <input id="isHome1" name="goodsPics[1].isHome"  type="hidden" value="1" />\n'
					+ '                    <a type="button"  onclick="remove(\''
					+ divid
					+ '\');" id="delete'
					+ num
					+ '" style="display:none;">删除</a>\n'
					+ '                </div>\n' + '            </div>';
			var newNode = document.createElement("div");
			newNode.innerHTML = htm;
			aa = document.getElementById("tu");
			// alert(aa);
			aa.append(newNode);
		}
		function remove(picid) {
			for (i = 0; i < arr.length; i++) {
				var map = arr[i];
				if (picid == map.name) {
					arr.splice(i, 1);
				}
			}
			document.getElementById(picid).remove();
		}
		var arr = [];
		function ajaxFileUploadMY(divID, type) {
			if (divID == null) {
				divID = "file";
			}
			$.ajaxFileUpload({
				url : "/fileUpload/fileUpload.action", //需要链接到服务器地址
				secureuri : false,
				dataType : 'multipart/form-data',
				fileElementId : divID, //文件选择框的id属性
				dataType : 'json', //服务器返回的格式，可以是json
				success : function(data, status) //相当于java中try语句块的用法
				{
					console.log(data);
					console.log(data.image_url);
					newpic();
					if (data.image_url != null) {
						$("#pic_url" + type).val(data.image_url);
						$("#pic_urla" + type).attr("src", data.image_url);
						$("#delete" + type).show();
						var imgname = "pic" + type;
						var img = {
							"name" : imgname,
							"url" : data.image_url
						};
						arr.push(img);
						$("#pic_urlMSG").html("");
						$("#pic_div" + type).show();
						for (i = 0; i < arr.length; i++) {
							var map = arr[i];
						}
					}
				},
				error : function(data, status, e) {
				}
			});
			
		}

		$(function() {
			var ue = UE.getEditor("ta_ckeditor");
			UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
			UE.Editor.prototype.getActionUrl = function(action) {
				//调用自己写的Controller
				if (action == 'uploadimage' || action == 'uploadfile') {
					return "/imageUpload/upload.do"; //自己controller的action
				} else if (action == "uploadvideo") {
					return "";//自己controller的action
				} else {
					return this._bkGetActionUrl.call(this, action);//百度编辑器默认的action
				}
			}
		});

		function ajaxFileUploadMY1(divID, type) {
			if (divID == null) {
				divID = "file";
			}
			$.ajaxFileUpload({
				url : "/fileUpload/fileUpload.action", //需要链接到服务器地址  
				secureuri : false,
				dataType : 'multipart/form-data',
				fileElementId : divID, //文件选择框的id属性  
				dataType : 'json', //服务器返回的格式，可以是json  
				success : function(data, status) //相当于java中try语句块的用法  
				{
					if (data.image_url != null) {
						$("#pic_url" + type).val(data.image_url);
						$("#pic_urla" + type).attr("src", data.image_url);
						$("#pic_div" + type).show();
					}
				},
				error : function(data, status, e) {
				}
			});
		}

		$(document)
				.ready(
						function() {
							$("#append")
									.click(
											function() {
												$("#left")
														.append(
																" <input type='text' id='array' name='array' value='' class='select' maxlength='6'/>"
																		+ "<span id='value_nameMSG' style='color: red'></span><br/>");
											});
						});

		//一级业务类型级联事件
		function getSecondType() {
			var grandid = $('#typeGrand').val();
			$('#typeParent').empty();
			$("#typeParent").prepend("<option value=''>全部</option>");

			$('#typeThrid').empty();
			$("#typeThrid").prepend("<option value=''>全部</option>");
			var url = "/category/getSecondType.do";
			var params = {
				"category_id" : grandid
			};
			var defaultText = "全部";
			var target = "#typeParent";
			if (grandid != "") {
				addCategoryOptions(url, params, defaultText, target);
			} else {
				$(target).html("<option value=''>" + defaultText + "</option>");
			}
		}

		//添加三级
		function getThridType() {
			var url = "/category/getSecondType.do";
			var secondid = $('#typeParent').val();
			$('#typeThrid').empty();
			//$("#typeThrid").prepend("<option value=''>全部</option>");
			var target = "#typeThrid";
			var defaultText = "全部";
			if (secondid != null && secondid != '') {
				var params = {
					"category_id" : secondid
				};
				addCategoryOptions(url, params, defaultText, target);
			} else {
				$(target).html("<option value=''>" + defaultText + "</option>");
			}
		}
		//级联添加业务类型select选项
		var addCategoryOptions = function(url, params, defaultText, target) {
			$
					.getJSON(
							url,
							params,
							function(list) {
								var options = "";
								options = "<option value=''>" + defaultText
										+ "</option>";
								if (list != "[]" && typeof list != "undefined") {
									for (var i = 0; i < list.length; i++) {
										options += "<option value='" + list[i].category_id + "'>"
												+ list[i].category_name
												+ "</option>";
									}
								}
								$(target).html(options);
							});
		}
		var addOptions1 = function(url, params, defaultText, target) {
			$
					.getJSON(
							url,
							params,
							function(list) {
								var options = "";
								options = "<option value=''>" + defaultText
										+ "</option>";
								if (list != "[]" && typeof list != "undefined") {
									for (var i = 0; i < list.length; i++) {
										options += "<option value='" + list[i].category_id + "'>"
												+ list[i].category_name
												+ "</option>";
									}
								}

								$("#three").html(options);
							});
		}

		//查询属性
		function getAttrbuteList() {
			var typeThrid = $("#typeThrid").val();
			if (typeThrid != null && typeThrid != '') {
				jQuery
						.ajax({
							url : "/attributeRelation/getAttrbuteByCateId.do",
							data : {
								"category_id" : typeThrid,
							},
							type : "post",
							dataType : "json",
							success : function(data) {
								var attr_html = "";
								for ( var one in data) {
									var attr_id = data[one].attr_id;
									var attr_name = data[one].attr_name;
									attr_html += '<label style="text-transform:none">';
									attr_html += '<input type="checkbox" onclick="attrCheck('
											+ attr_id
											+ ',\''
											+ attr_name
											+ '\')" id="attrId'
											+ attr_id
											+ '" name="attr_id"   value="'
											+ attr_id
											+ '" />'
											+ attr_name
											+ '</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
								}
								attr_html += '<span id="attrMsg" style="color: red"></span>';
								$("#attr").html(attr_html);
								$("#attrdiv").show();
								$("#attrTableBody").html("");
								$("#skudiv").hide();
								$("#goods_sku").html("");
							},
						});
			}
		}

		//返回按钮跳转到区域列表
		function goToList() {
			location.href = "/goodsInfo/getGoodsAttrList.do?goods_id="+${map.goodsInfo.goods_id};
		}

		//输入框点击动作
		function stockClick() {
			if (document.getElementById("Stock").value!=null) {
				document.getElementById("yStock").checked=true;
			}
			if(document.getElementById("Stock").value < 0){ 
				document.getElementById("Stock").value = 0 ;
			} 
		}
		function labelClick() {
			if (document.getElementById("isText").value!=null) {
				document.getElementById("isMy").checked=true;
			}
		}
		function returnChange() {
			if (document.getElementById("returnText").value!=null) {
				document.getElementById("return3").checked=true;
			}
			if(document.getElementById("returnText").value < 0){ 
				document.getElementById("returnText").value = 0 ;
			}
		}
		function marketPriceClick() {
			if(document.getElementById("marketPrice").value < 0){ 
				document.getElementById("marketPrice").value = 0 ;
			}
		}
		function costPriceClick() {
			if(document.getElementById("costPrice").value < 0){ 
				document.getElementById("costPrice").value = 0 ;
			}
		}
		function zhekouClick() {
			/* if (document.getElementById("zhekou").value!=null) {
				document.getElementById("zhekouRadio").checked=true;
				document.getElementById("huiyuanpice").value="";
			} */
			if(document.getElementById("vipPrice").value < 0){ 
				document.getElementById("vipPrice").value = 0 ;
			}
		} 
		/* function huiyuanpiceClick() {
			if (document.getElementById("huiyuanpice").value!=null) {
				document.getElementById("huiyuanpiceRadio").checked=true;
				document.getElementById("zhekou").value="";
			}
			if(document.getElementById("huiyuanpice").value < 0){ 
				document.getElementById("huiyuanpice").value = 0 ;
			 }
		}*/
		
		
		// 设置为主图
		function setHome(a) {
			var isHome = $("#isHome" + a).val();
			//设置为主图
			if (isHome == 0) {
				for (j = 1; j < 4; j++) {
					if (a == j) {
						$("#isHome" + a).val(1);
						$("#pic_button" + a).html("主图");
					} else {
						$("#isHome" + j).val(0);
						$("#pic_button" + j).html("设为主图");
					}
				}
			}
		}


		function checkInfo() {
			var goodsId = $("#goodsId").val();
		 	var goodsName = $("#goodsName").val();
			var spec = $("#spec").val();
			var adWords = $("#adWords").val();
			var costPrice = $("#costPrice").val();
			var marketPrice = $("#marketPrice").val();
			var vipPrice=$("#vipPrice").val();
			var status = $("#status").val();
			var returnTime = $("#returnTime").val();
			var pic_url0 = "";
			var pic_url1 = "";
			var pic_url2 = "";
		 	var typeThrid = $("#typeThrid").val();
			var returnType = $("#returnType").val();
			$.ajax({
				url : "/goodsInfo/updateGoods.do",
				data : $("#updateGoodsInfoFrom").serialize(),
				type : "post",
				dataType : "json",
				success : function(data) {
					if (data.code == "OK") {
						swal({
							  text: "修改成功!",
							  //confirmButtonText: "确认",
							},
							function(){
								window.location.href = "/goodsInfo/getGoodsAttrList.do?goods_id="+goodsId;
							});
						
					} else {
						swal("失败", "fail");
					}
					
				},
			});
		}
	</script>


</body>
</html>