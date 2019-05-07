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
								<form class="form-horizontal" id="addGoodsInfoFrom"
									action="/goodsInfo/insertGoods.do" name="addGoodsInfoFrom"
									method="post" enctype="multipart/form-data">
									<div class="content">
										<legend>
											<spring:message code="language.goodsCreation" />
										</legend>
										<!-- 1.商品名称 -->
										<fieldset>
											<div class="col-sm-6 form-group first">
												<label class="col-sm-2 control-label"><star>*</star>
													商品名称:</label>
												<div class="col-sm-6">
													<input class="form-control" id="goodsName" name="goodsName"
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
														<option value="">全部</option>
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
														<option value="">全部</option>
													</select> 
													</div>
													<div class="  select1">
													<select id="typeThrid" name="categoryId" class="select"
														>
														<option value="" name="category_name">全部</option>
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
													<input class="form-control" id="spec" name="spec"
														placeholder="公斤等:" required>
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
													<input class="form-control" id="adWords" name="adWords"
														placeholder="请描述商品亮点（不超过20个字）" required>
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
													<input onchange="costPriceClick();" type="number" class="form-control" id="costPrice" name="costPrice" placeholder="元">
												</div>
												<span id="costPriceMSG" style="color: red"></span>
											</div>
										</fieldset>
										
										<fieldset>
											<div class="col-sm-6 form-group first" >
												<label class="col-sm-2 control-label" ><star>*</star>
												市场价 :</label>
												<div class="col-sm-6 " >
													<input onchange="marketPriceClick();" type="number" class="form-control" id="marketPrice" name="marketPrice" placeholder="元">
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
													<input onchange="zhekouClick();" type="number" class="form-control" id="vipPrice" name="vipPrice" placeholder="元">
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
														checked="checked" />上架 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
													<input type="radio" value="0" id="notShow" name="status" />下架
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
													<input type="radio" value="1" id="nStock" name="stockType" checked="checked"/>不限库存
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			                                        <input type="radio" value="2" id="yStock" name="stockType" />共享库存
			                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			                                        <input type="number"  onchange="stockClick();" value="" id="Stock" name="stock" placeholder="请设置库存总数"/>
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
														<input type="radio"  id="isNew"  value="${c.labelId}"  name="labelId"/>${c.labelName}
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
													<input type="radio" value="1" id="return1" name="returnType" checked="checked"/>不允许退货
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			                                        <input type="radio" value="0" id="return2" name="returnType"/>不限制退货
			                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			                                        <input type="radio" value="2" id="return3" name="returnType"/>截单前
			                                        <input type="number"  onchange="returnChange()" id="returnText" name="returnTime" value="" style="width:80px"/>小时可退
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
															<div>
																<div class="form-group  " id="pic0"
																	style="float: left; margin-right: 30px">
																	<input data-options="prompt:'Choose a file...'"
																		type="file" id='file0' name="file"
																		onchange="ajaxFileUploadMY('file0',0)" /> <input
																		id="pic_url0" type="hidden" name="goodsPics[0].picUrl" />
																	<img src="" id="pic_urla0" style="width: 100px" />
																	<div id="pic_div0" style="display: block;">
																		<input id="isHome0" name="goodsPics[0].isHome"
																			type="hidden" value="0" /> <a type="button"
																			onclick="remove('pic0');" id="delete0"
																			style="display: none;">删除</a>
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
													<textarea id="commitment" name="commitment" cols="30" rows="10" style="width:510px;height:100px;" placeholder="请输入售后承诺（不超过200个字）"/></textarea>
												</div>
											</div>
										</fieldset>

										<div class="footer text-center">
											<button type="button" class="btn btn-info btn-fill btn-wd"
												id="doSubmit" onclick="checkInfo();">确定</button>

											<button type="button" class="btn btn-fill btn-wd"
												onclick="goToList();">返回</button>
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
			location.href = "/goodsInfo/selectGoodsInfoList.do";
		}
		<!--
		//添加属性
		function attrCheck(attr_id, attr_name) {

			var len = $("input[name='attr_id']:checked").length
			if (len > 2) {
				$("#attrId" + attr_id).prop("checked", false);
				alert("只能选择两个属性");
				return;
			}

			if (document.getElementById("attrId" + attr_id).checked == true) {

				jQuery
						.ajax({
							url : "/attributeRelation/getAttrValueById.do",
							data : {
								"attr_id" : attr_id
							},
							type : "post",
							dataType : "json",
							success : function(data) {
								var html = "";
								html += "<tbody id='table"+attr_id+"'><tr>"
								html += "<td class='tcenter'><span class='numberClass'>"
										+ attr_name + ":</span></td>"
								for ( var one in data) {
									var value_id = data[one].value_id;
									var value_name = data[one].value_name;
									var relation_id = data[one].relation_id;
									html += "<td><label style='text-transform:none'>";
									html += "<input type='checkbox' id='valueId"+value_id+"' name='value_id"+attr_id+"'   value='"+relation_id+","+value_name+"' />"
											+ value_name
											+ "</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>";
								}
								html += "</tr></tbody>";
								$("#attrTableBody").append(html);
								$("#skudiv").show();
							},
						});
			} else {
				$("#table" + attr_id).remove();
				var len = $("input[name='attr_id']:checked").length;
				if (len == 0) {
					$("#skudiv").hide();
				}

			}

		}

		// 生成商品的sku属性
		function generate_sku() {
			var attrArray = $("input[name='attr_id']:checked");
			var attrSum = attrArray.length;
			var n = 0;
			if (attrSum == 1) {
				var _tr = "<thead><th>主商品</th><th colspan='1' width='50px' >属性</th><th>原价</th><th>售价</th><th>库存</th><th>物流费用</th><th>承担方</th><th>状态</th><th data-field='actions'><spring:message code='language.operation'/></th></thead><tbody>";

				//如果只选择了一个
				var attrList = document.getElementsByName("value_id"
						+ attrArray[0].value);
				var attrSize = $("input[name='value_id" + attrArray[0].value
						+ "']:checked").length;
				if (attrSize == 0) {
					alert("必须至少选择一个属性");
					return;
				}

				for (i = 0; i < attrList.length; i++) {
					if (attrList[i].checked == true
							&& attrList[i].disabled == false) {
						var attrListAttr = attrList[i].value.split(",");
						var sizeAttrVal = attrListAttr[1];
						var sizeAttrId = attrListAttr[0];
						_tr = _tr
								+ "<tr><td> <input type='radio' style='width: 50px;' value='0' onclick='isMainAdio("
								+ n
								+ ")'   name='goodsSkus["
								+ n
								+ "].isMain'/></td>"
								+ "<td width='50px' >"
								+ sizeAttrVal
								+ "<input type='hidden' name='goodsSkus[" + n + "].relationId' value='"
								+ sizeAttrId
								+ "'/></td>"
								+ "<td><input type='text' class='validateNum' name='goodsSkus[" + n + "].price' value='' style='width: 40px;' maxlength='9'/></td>"
								+ "<td><input type='text' class='validateNum' name='goodsSkus[" + n + "].salePrice' value='' style='width: 40px;' maxlength='9'/></td>"
								+ "<td><input type='text' class='validateNum' name='goodsSkus[" + n + "].stock' value='' style='width: 40px;' maxlength='9'/></td>"
								+ "<td><input type='text' class='validateNum' name='goodsSkus[" + n + "].logistics' value='' style='width: 40px;' maxlength='9'/></td>"
								+ "<td><select id='recipient' name='goodsSkus[" + n + "].recipient'><option value='1'>卖家</option>	<option value='2'>买家</option></select></td>"
								+ "<td><input  type='hidden' class='validateNum' name='goodsSkus[" + n + "].status' value='1' style='width: 40px;' /><span  name='goodsSkus[" + n + "].statusName'>上架</span></td>"
								+ "<td onclick='changeStatus("
								+ n
								+ ")'><input type='button'  id='goodsSkus[" + n + "].button' value='下架'/></td></tr>"
						n++;
					}
				}
			} else {
				var _tr = "<thead><th>主商品</th><th colspan='2'>属性</th><th>原价</th><th>售价</th><th>库存</th><th>物流费用</th><th>承担方</th><th>状态</th><th data-field='actions'><spring:message code='language.operation'/></th></thead><tbody>";
				var sizeAttr = document.getElementsByName("value_id"
						+ attrArray[0].value);
				var colourAttr = document.getElementsByName("value_id"
						+ attrArray[1].value);
				var colourAttrArray = colourAttr.length;
				var sizeAttrArray = sizeAttr.length;

				var sizeAttrSize = $("input[name='value_id"
						+ attrArray[0].value + "']:checked").length;
				var colourAttrSize = $("input[name='value_id"
						+ attrArray[1].value + "']:checked").length;

				if (sizeAttrSize == 0 || colourAttrSize == 0) {
					alert("必须至少选择一个属性");
					return;
				}
				var count = 0;
				for (i = 0; i < sizeAttrArray; i++) {
					if (sizeAttr[i].checked == true
							&& sizeAttr[i].disabled == false) {
						for (j = 0; j < colourAttrArray; j++) {
							if (colourAttr[j].checked == true
									&& colourAttr[j].disabled == false) {
								count++;
								var arrSizeAttr = sizeAttr[i].value.split(",");
								var sizeAttrVal = arrSizeAttr[1];
								var sizeAttrId = arrSizeAttr[0];
								var arrColourAttr = colourAttr[j].value
										.split(",");
								var colourAttrVal = arrColourAttr[1];
								var colourAttrId = arrColourAttr[0];
								_tr = _tr
										+ "<tr><td> <input type='radio'style='width: 50px;' value='0' onclick='isMainAdio("
										+ n
										+ ")' name='goodsSkus["
										+ n
										+ "].isMain'/></td>"
										+ "<td><input type='text' value='"
										+ sizeAttrVal
										+ "' style='width: 50px;' readonly='readonly'/><input type='hidden' name='goodsSkus[" + n + "].relationId' value='"
										+ sizeAttrId
										+ "'/></td>"
										+ "<td><input type='text' value='"
										+ colourAttrVal
										+ "' style='width: 50px;' readonly='readonly'/><input type='hidden' name='goodsSkus[" + n + "].relationId' value='"
										+ colourAttrId
										+ "'/></td>"
										+ "<td><input type='text' class='validateNum' name='goodsSkus[" + n + "].price' value='' style='width: 40px;' maxlength='9'/></td>"
										+ "<td><input type='text' class='validateNum' name='goodsSkus[" + n + "].salePrice' value='' style='width: 40px;' maxlength='9'/></td>"
										+ "<td><input type='text' class='validateNum' name='goodsSkus[" + n + "].stock' value='' style='width: 40px;' maxlength='9'/></td>"
										+ "<td><input type='text' class='validateNum' name='goodsSkus[" + n + "].logistics' value='' style='width: 40px;' maxlength='9'/></td>"
										+ "<td><select id='recipient' name='goodsSkus[" + n + "].recipient'><option value='1'>卖家</option>	<option value='2'>买家</option></select></td>"
										+ "<td><input  type='hidden' class='validateNum' name='goodsSkus[" + n + "].status' value='1' style='width: 40px;' /><span  name='goodsSkus[" + n + "].statusName'>上架</span></td>"
										+ "<td onclick='changeStatus("
										+ n
										+ ")'><input type='button'  id='goodsSkus[" + n + "].button' value='下架'/></td></tr>"
								n++;
							}
						}
					}
				}

			}
			_tr += "</tbody>";
			$("#goods_sku").html(_tr);
		}
		-->
		// 修改上下级状态
		function changeStatus(n) {
			var isMainAdio = $("input[name='goodsSkus[" + n + "].isMain']")
					.val();
			if (isMainAdio == 0) {
				var status = $("input[name='goodsSkus[" + n + "].status']")
						.val();
				if (status == 1) {
					$("input[name='goodsSkus[" + n + "].status']").val(0);//设置为下价
					$("span[name='goodsSkus[" + n + "].statusName']")
							.html("下架");
					document.getElementById("goodsSkus[" + n + "].button").value = "上架";
				} else if (status == 0) {
					$("input[name='goodsSkus[" + n + "].status']").val(1);//设置为下价
					$("span[name='goodsSkus[" + n + "].statusName']")
							.html("上架");
					document.getElementById("goodsSkus[" + n + "].button").value = "下架";
				}

			} else {
				alert("主商品不能设置为下架");
			}
		}

		// 是否主商品
		function isMainAdio(n) {
			$("#goods_sku input:radio").prop('checked', false);
			$("#goods_sku input:radio").val(0);
			var isMainAdio = $("input[name='goodsSkus[" + n + "].isMain']")
					.val();
			if (isMainAdio == 0) {
				$("input[name='goodsSkus[" + n + "].isMain']").val(1);
				$("input[name='goodsSkus[" + n + "].isMain']").prop('checked',
						true);
				$("input[name='goodsSkus[" + n + "].status']").val(1);//设置为下价
				$("span[name='goodsSkus[" + n + "].statusName']").html("上架");
				document.getElementById("goodsSkus[" + n + "].button").value = "下架";
			}
		}

		//选择商品
		function selectGoods() {
			$
					.ajax({
						url : "/goodsInfo/selectGoods.do",
						data : {},
						type : "post",
						dataType : "json",
						success : function(data) {
							console.log(data);
							console.log(data.allGoodsList.length);
							data = data.allGoodsList;
							console.log(data);

							var html = "";
							var tr_html = "";
							for (var i = 0; i < data.length; i++) {
								tr_html += '<tr id=tr_'+data[i].goodsId+'>';
								var chk_html = "";
								console.log("===============");
								console.log(data[i].goodsId)

								var ids = document
										.getElementById("recgGoodsIds").value;
								var arr = ids.split(",");
								for (n = 0; n < arr.length; n++) {
									if (data[i].goodsId == arr[n]) {
										chk_html += '<td><input type="checkbox" name="goodsId" id="goodsId" checked value="'+data[i].goodsId+'"></td>';
									}
								}

								if (chk_html == "") {
									tr_html += '<td><input type="checkbox" name="goodsId" id="goodsId" value="'+data[i].goodsId+'"></td>';
								} else {
									tr_html += chk_html;
								}
								tr_html += '<td>' + data[i].goodsCode + '</td>';
								tr_html += '<td>' + data[i].goodsName + '</td>';
								tr_html += '<td>' + data[i].allName + '</td>';
								tr_html += '<td>' + data[i].languageName
										+ '</td>';
								tr_html += '<td>' + data[i].channelName
										+ '</td>';
								if (data[i].cardType == 1) {
									tr_html += '<td><spring:message code="language.entityCard"/></td>';
								} else {
									tr_html += '<td><spring:message code="language.virtualCard"/></td>';
								}
								tr_html += '<td>' + data[i].minPrice + '-'
										+ data[i].maxPrice + '</td>';

								if (data[i].status == 1) {
									tr_html += '<td><spring:message code="language.shelves"/></td>';
								} else {
									tr_html += '<td><spring:message code="language.downshelves"/></td>';
								}
								tr_html += '<td>' + data[i].workerName
										+ '</td>';
								tr_html += '</tr>';
							}
							html += '<input type="text" placeholder="<spring:message code="language.goodsname" />" id="goodName" name="goodName"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
							html += '<input type="text" placeholder="<spring:message code="language.goodsCode" />" id="goodCode" name="goodCode"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
							html += '<input type="button" value="<spring:message code="language.queryBtn" />" onclick="selectGoodsBymz();"/>';
							html += '<div id="ddd">';
							html += '<table id="bootstrap-table" class="table">';
							html += '            <thead>';
							html += '           	    <th><input type="checkbox" id="checkall" name="checkall" onclick="checkAll(checkall)" /><spring:message code="language.allselect" /></th>'
							html += '           	    <th><spring:message code="language.goodsCode"/></th>';
							html += '          	    <th><spring:message code="language.goodsname"/></th>';
							html += '          	    <th><spring:message code="language.categoryName"/></th>';
							html += '          	    <th><spring:message code="language.language"/></th>';
							html += '          	    <th><spring:message code="language.channel"/></th>';
							html += '           	    <th><spring:message code="language.cardType"/></th>';
							html += '       	        <th><spring:message code="language.goodsPrice"/></th>';
							html += '      	        <th><spring:message code="language.status"/></th>';
							html += '      	        <th><spring:message code="language.operator"/></th>';
							html += '            </thead>';
							html += '<tbody>';
							html += tr_html;
							html += '</tbody>';
							html += '</table>';
							html += '</div>';

							var index = layer
									.open({
										title : "选择推荐商品",
										type : 1,
										skin : 'layui-layer-rim', //加上边框
										area : [ '1200px', '700px' ], //宽高
										content : html,
										btn : "确定",
										yes : function() {
											var tr_str = "";
											var goods_str = "";
											$("input[name='goodsId']:checked")
													.each(
															function() {
																var coupId = $(
																		this)
																		.val();
																for (var i = 0; i < data.length; i++) {
																	var cpId = data[i].goodsId;
																	if (cpId == coupId) {
																		goods_str += data[i].goodsId
																				+ ",";
																		tr_str += '<span>'
																				+ data[i].goodsName
																				+ '</span>&nbsp;&nbsp;';
																		break;
																	}
																}
															});
											$("#goods").empty();
											$("#recgGoodsIds").empty();
											$("#goods").html(tr_str);
											$("#recgGoodsIds")
													.val(
															goods_str
																	.substring(
																			0,
																			goods_str.length - 1));
											layer.close(index);
										}
									});

						}
					});
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

		//全选商品
		function checkAll(checkall) {
			arr = document.getElementsByName("goodsId");
			if (checkall.checked == true) {
				for (i = 0; i < arr.length; i++) {

					arr[i].checked = true;
				}
			} else {
				for (i = 0; i < arr.length; i++) {
					if ((arr[i]).checked == false) {
						arr[i].checked = true;
					} else {
						arr[i].checked = false;
					}
				}
			}
		}

		//选择优惠券是的查询
		function selectGoodsBymz() {

			$("#ddd").empty();
			var goodName = $("#goodName").val();
			var goodCode = $("#goodCode").val();

			$
					.ajax({
						url : "/goodsInfo/selectGoods.do",
						data : {
							goodsName : goodName,
							goodsCode : goodCode
						},
						type : "post",
						dataType : "json",
						success : function(data) {
							console.log(data);
							console.log(data.allGoodsList.length);
							data = data.allGoodsList;
							console.log(data);

							var html = "";
							var tr_html = "";
							for (var i = 0; i < data.length; i++) {
								tr_html += '<tr id=tr_'+data[i].goodsId+'>';
								var chk_html = "";
								console.log("===============");
								console.log(data[i].goodsId)

								var ids = document
										.getElementById("recgGoodsIds").value;
								var arr = ids.split(",");
								for (n = 0; n < arr.length; n++) {
									if (data[i].goodsId == arr[n]) {
										chk_html += '<td><input type="checkbox" name="goodsId" id="goodsId" checked value="'+data[i].goodsId+'"></td>';
									}
								}

								if (chk_html == "") {
									tr_html += '<td><input type="checkbox" name="goodsId" id="goodsId" value="'+data[i].goodsId+'"></td>';
								} else {
									tr_html += chk_html;
								}
								tr_html += '<td>' + data[i].goodsCode + '</td>';
								tr_html += '<td>' + data[i].goodsName + '</td>';
								tr_html += '<td>' + data[i].allName + '</td>';
								tr_html += '<td>' + data[i].languageName
										+ '</td>';
								tr_html += '<td>' + data[i].channelName
										+ '</td>';
								if (data[i].cardType == 1) {
									tr_html += '<td><spring:message code="language.entityCard"/></td>';
								} else {
									tr_html += '<td><spring:message code="language.virtualCard"/></td>';
								}
								tr_html += '<td>' + data[i].minPrice + '-'
										+ data[i].maxPrice + '</td>';

								if (data[i].status == 1) {
									tr_html += '<td><spring:message code="language.shelves"/></td>';
								} else {
									tr_html += '<td><spring:message code="language.downshelves"/></td>';
								}
								tr_html += '<td>' + data[i].workerName
										+ '</td>';
								tr_html += '</tr>';
							}

							html += '<table id="bootstrap-table" class="table">';
							html += '            <thead>';
							html += '           	     <th><input type="checkbox" id="checkall" name="checkall" onclick="checkAll(checkall)" /><spring:message code="language.allselect" /></th>'
							html += '           	    <th><spring:message code="language.goodsCode"/></th>';
							html += '          	    <th><spring:message code="language.goodsname"/></th>';
							html += '          	    <th><spring:message code="language.categoryName"/></th>';
							html += '          	    <th><spring:message code="language.language"/></th>';
							html += '          	    <th><spring:message code="language.channel"/></th>';
							html += '           	    <th><spring:message code="language.cardType"/></th>';
							html += '       	        <th><spring:message code="language.goodsPrice"/></th>';
							html += '      	        <th><spring:message code="language.status"/></th>';
							html += '      	        <th><spring:message code="language.operator"/></th>';
							html += '            </thead>';
							html += '<tbody>';
							html += tr_html;
							html += '</tbody>';
							html += '</table>';
							$("#ddd").append(html);
						}
					});
		}

		function checkInfo() {

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
			for (i = 0; i < arr.length; i++) {
				var map = arr[i];
				if (i == 1) {
					pic_url1 = map.url;
				}
				if (i == 0) {
					pic_url0 = map.url;
				}
				if (i == 2) {
					pic_url2 = map.url;
				}
			}

			//var pic_url1 = $("#pic_url1").val();
			//var pic_url2 = $("#pic_url2").val();
			//var pic_url0 = $("#pic_url0").val();
			var typeThrid = $("#typeThrid").val();
			var returnType = $("#returnType").val();
			$("#goodsNameMSG").html("");
			$("#goodsSpecMSG").html("");
			$("#adWordsMSG").html("");
			$("#costPriceMSG").html("");
			$("#marketPriceMSG").html("");
			$("#vipPriceMSG").html("");
			
			$("#statusMSG").html("");
			$("#returnTimeMSG").html("");
			$("#pic_urlMSG").html("");
			$("#categoryMSG").html("");
			$("#returnTypeMSG").html("");
			$("#returnTimeMSG").html("");
			if (goodsName == "") {
				$("#goodsNameMSG").html("请输入商品名称");
				return;
			}
			if (spec == "") {
				$("#goodsSpecMSG").html("请输入规格");
				return;
			}
			if (adWords == "") {
				$("#adWordsMSG").html("请输入商品亮点");
				return;
			}

			if (costPrice == ""||costPrice<=0) {
				$("#costPriceMSG").html("请输入成本价");
				return;
			}
			if (marketPrice == ""||marketPrice<=0) {
				$("#marketPriceMSG").html("请输入市场价");
				return;
			}
/* 			if (vipPrice==0) {
				$("#vipPriceMSG").html("请输入市场价");
				return;
			} */
			
			if (status == "") {
				$("#statusMSG").html("请选择状态");
				return;
			}
			if ( returnTime== 0) {
				$("#returnTypeMSG").html("请选择退货时效");
				return;
			}

			if (pic_url1 == "" && pic_url2 == "" && pic_url0 == "") {
				$("#pic_urlMSG").html("请选择图片");
				return;
			}

			$.ajax({
				url : "/goodsInfo/insertGoods.do",
				data : $("#addGoodsInfoFrom").serialize(),
				type : "post",
				success : function(data) {
					window.location.href = "/goodsInfo/selectGoodsInfoList.do";
				},
			});
		}
	</script>


</body>
</html>