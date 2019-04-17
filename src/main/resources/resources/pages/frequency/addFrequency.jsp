<%@ page language="java"
	import="java.util.*,com.antke.website.utils.CommonsUtil"
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
<link href='/css/685fd913f1e14aebad0cc9d3713ee469.css' rel='stylesheet' type='text/css'>		
<link href="/css/pe-icon-7-stroke.css" rel="stylesheet" />
<title>添加频道</title> <script language='javascript' src="js/edit.js"></script>
<script type="text/javascript" src="/js/ueditor1.4.3.3/ueditor.config.js"></script>
<script type="text/javascript" src="/js/ueditor1.4.3.3/ueditor.all.js"></script>
<script language='javascript' src="/js/jquery-1.8.3.min.js"></script>
<script language="javascript" src="/js/My97DatePicker/WdatePicker.js"></script>
<script language="javascript" src="/js/layer/layer.js"></script>
</head>
<style>
 
.list-border{height:70px;border:1px solid #a0a0a0 ;border-radius:5px;display:block;padding:10px;}
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
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<form class="form-horizontal" id="addFrequencyFrom"
									action="/frequency/addFrequency.do" name="addFrequencyFrom"
									method="post" enctype="multipart/form-data">
									<div class="content">
										<legend><spring:message code="language.frequencyCreation"/></legend>
										<!-- 1.名称 -->
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"><star>*</star>
												<spring:message code="language.frequencyName"/>:</label>
												<div class="col-sm-6">
													<input class="form-control" id="name"
														name="name" placeholder="名称 :" required>
												</div>
												<span id="nameMsg" style="color: red"></span>
											</div>
										</fieldset>
										
										<!-- 3.图片 -->
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"><star>*</star>
												<spring:message code="language.bannerPic"/>:</label>
												<div class="col-sm-6">
													<input data-options="prompt:'Choose a file...'" type="file"
														id='file' name="file"
														onchange="ajaxFileUploadMY('file',1)"/> 
													<input id="picUrl" type="hidden" name="picUrl" />
													<img src="" id="picUrla" style="width:100px" />
												</div>
												<span id="picUrlMsg" style="color: red"></span>
											</div>
										</fieldset>
									 
										<!-- 6.是否显示 -->
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"><star></star>
												<spring:message code="language.bannerStatus"/>:</label>
												<div class="col-sm-6">
													<select class="form-control" id="isHomeShow" name="isHomeShow">
												    	<option value="1"><spring:message code="language.display" /></option>
														<option value="0"><spring:message code="language.noDisplay" /></option>
													</select>
												</div>
												<span id="isHomeShowMsg" style="color: red"></span>
											</div>
										</fieldset>
										
										<!-- 关联类型  -->
										 <fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"><star></star>
												<spring:message code="language.relationType"/>:</label>
												<div class="col-sm-6" style="margin-top:9px">
													<input type="radio" value="2" checked="checked" onclick="showCategorys();" id="relationType" name="relationType"/><spring:message code="language.relationCategory" />
													<input type="radio" value="1" id="relationType" onclick="showGoods();" name="relationType"/><spring:message code="language.relationGoods" />
												 </div>
											<span id="isHomeMSG" style="color: red"></span>
											</div>
										</fieldset>
										
									 <fieldset id="showCategorysDiv">
		                                  <div class="form-group">
		                                      <label class="col-sm-2 control-label"><spring:message code="language.selectCategory" />:</label>
		                                      <div class="col-sm-6">
		                                      		<div  class="list-border" id="categorys"></div>
		                                      </div>
		                                      <button type="button" class="btn btn-info btn-fill" onclick="selectCategory();"><spring:message code="language.selectCategory" /></button>
		                                  </div>
		                              </fieldset>
		                               <input type="hidden" name="recgCategoryIds" id="recgCategoryIds" value=""/>
		                               
		                                <fieldset id="showGoodsDiv" style="display:none">
		                                  <div class="form-group">
		                                      <label class="col-sm-2 control-label"><spring:message code="language.relateRecommendGoods" />:</label>
		                                      <div class="col-sm-6">
		                                      		<div  class="list-border" id="goods">
						                              
		                                      		</div>
		                                      </div>
		                                      <button type="button" class="btn btn-info btn-fill" onclick="selectGoods();"><spring:message code="language.selectGoods" /></button>
		                                  </div>
		                              </fieldset>
									    <input type="hidden" name="recgGoodsIds" id="recgGoodsIds" value=""/>

									<div class="footer text-center">
										<button type="button" class="btn btn-info btn-fill btn-wd"
											id="doSubmit" onclick="checkInfo();"><spring:message code="language.determineBtn"/></button>
										<button type="button" class="btn btn-fill btn-wd" onclick="goToList();"><spring:message code="language.backBtn"/></button>
									</div>

								</form>
							</div>
							<!--  end card  -->
						</div>
						<!-- end col-md-12 -->
					</div>
					<!-- end row -->
				</div>

			</div>
			<!-- 内容table结束 -->

			<!-- 底部开始 -->
			<jsp:include page="/pages/inc/footer.jsp"></jsp:include>
			<!-- 底部结束 -->
		</div>
	</div>

	<script type="text/javascript">
		function checkInfo() {
			var name = $("#name").val();
			var picUrl = $("#picUrl").val();
			
			$("#nameMsg").html("");
			$("#imgUrlMsg").html("");
			
			if (name == "") {
				$("#nameMsg").html("请输入频道名称");
				return;
			}
			if (picUrl == "") {
				$("#picUrlMsg").html("请选择图片");
				return;
			}
			 
			$.ajax({
				url : "/frequency/addFrequency.do",
				data :  $("#addFrequencyFrom").serialize(),
				type : "post",
				success : function(data) {
					window.location.href="/frequency/queryFrequencyList.do";
				},
			});
		}
		
		//返回按钮
			function goToList() {
				location.href = "/frequency/queryFrequencyList.do";
			}
		//上传图片
			function ajaxFileUploadMY(divID,type)  
			{   
				if(divID == null){
					divID = "file";
				}
			   $.ajaxFileUpload({  
			             url:"/fileUpload/fileUpload.action",             //需要链接到服务器地址  
			             secureuri:false,  
			             dataType: "multipart/form-data", 
			             fileElementId: divID,                         //文件选择框的id属性  
			             dataType: "json",                                     //服务器返回的格式，可以是json  
			             success: function (data, status)             //相当于java中try语句块的用法  
			             {     
			                if(data.image_url!=null){
			                	 $("#picUrl").val(data.image_url);
			                	  $("#picUrla").attr("src",data.image_url);
			                    }
			                 },  
			                 error: function (data, status, e){  
			             }  
			           }  
			         );  
			} 
		
			//选择商品
			function selectCategory(){
				$.ajax({
					url:"/category/selectCategory.do",
					data:{},
					type:"post",
					dataType:"json",
					success:function(data){
						console.log(data);
						console.log(data.categoryList.length);
						data =data.categoryList;
						console.log(data);
						
						var html = "";
						var tr_html = "";
						for(var i=0;i<data.length;i++){
							tr_html+='<tr id=tr_'+data[i].category_id+'>';
								var chk_html = "";
								console.log("===============");
								console.log(data[i].category_id)
								
								var ids = document.getElementById("recgCategoryIds").value;
								var arr = ids.split(",");
								     for(n=0;n<arr.length;n++){
								     	if(data[i].category_id==arr[n]){
											chk_html+='<td><input type="checkbox" name="category_id" id="category_id" checked value="'+data[i].category_id+'"></td>';
								     	}
								     }
								
								if(chk_html==""){
									tr_html+='<td><input type="checkbox" name="category_id" id="category_id" value="'+data[i].category_id+'"></td>';
								}else{
									tr_html+=chk_html;
								}
								tr_html+='<td>'+data[i].category_name+'</td>';
							    tr_html+='</tr>';
						}
						html+='<div id="ddd">';
						html+='<table id="bootstrap-table" class="table">';
		                html+='            <thead>';
		                html+='           	    <th><input type="checkbox" id="checkall" name="checkall" onclick="checkAll(checkall)" /><spring:message code="language.allselect" /></th>'
		                html+='          	    <th><spring:message code="language.categoryName"/></th>';
		                html+='            </thead>';
						html+='<tbody>';
						html+=tr_html;
						html+='</tbody>';
		                html+='</table>';
		                html+='</div>';
		                
						var index = layer.open({
						  title:"选择推荐分类",
						  type: 1,
						  skin: 'layui-layer-rim', //加上边框
						  area: ['600px', '400px'], //宽高
						  content: html,
						  btn:"确定",
						  yes:function(){
						  		var tr_str = "";
						  		var categorys_str = "";
						  		$("input[name='category_id']:checked").each(function(){
						  			var coupId = $(this).val();
						  			for(var i=0;i<data.length;i++){
						  				var cpId = data[i].category_id;
						  				if(cpId==coupId){
						  					categorys_str +=	data[i].category_id+",";
						  					tr_str+='<span>'+data[i].category_name+'</span>&nbsp;&nbsp;';
						  					break;
						  				}
						  			}
						  		});
						  		$("#categorys").empty();
						  		$("#recgCategoryIds").empty();
						  		$("#categorys").html(tr_str);
						  		$("#recgCategoryIds").val(categorys_str.substring(0,categorys_str.length-1));
						  		layer.close(index);
						  }
						});
						
						
						
					}
				});
			}
			
			//全选商品
			function checkAll(checkall) {
				arr = document.getElementsByName("category_id");
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
			//选择商品
			function selectGoods(){
				$.ajax({
					url:"/goodsInfo/selectGoods.do",
					data:{},
					type:"post",
					dataType:"json",
					success:function(data){
						console.log(data);
						console.log(data.allGoodsList.length);
						data =data.allGoodsList;
						console.log(data);
						
						var html = "";
						var tr_html = "";
						for(var i=0;i<data.length;i++){
							tr_html+='<tr id=tr_'+data[i].goodsId+'>';
								var chk_html = "";
								console.log("===============");
								console.log(data[i].goodsId)
								
								var ids = document.getElementById("recgGoodsIds").value;
								var arr = ids.split(",");
								     for(n=0;n<arr.length;n++){
								     	if(data[i].goodsId==arr[n]){
											chk_html+='<td><input type="checkbox" name="goodsId" id="goodsId" checked value="'+data[i].goodsId+'"></td>';
								     	}
								     }
								
								if(chk_html==""){
									tr_html+='<td><input type="checkbox" name="goodsId" id="goodsId" value="'+data[i].goodsId+'"></td>';
								}else{
									tr_html+=chk_html;
								}
								tr_html+='<td>'+data[i].goodsCode+'</td>';
								tr_html+='<td>'+data[i].goodsName+'</td>';
								tr_html+='<td>'+data[i].allName+'</td>';
								tr_html+='<td>'+data[i].languageName+'</td>';
								tr_html+='<td>'+data[i].channelName+'</td>';
								if(data[i].cardType==1){
									tr_html+='<td><spring:message code="language.entityCard"/></td>';
								}else{
									tr_html+='<td><spring:message code="language.virtualCard"/></td>';
								}
								tr_html+='<td>'+data[i].minPrice+'-'+data[i].maxPrice+'</td>';
								
								if(data[i].status==1){
									tr_html+='<td><spring:message code="language.shelves"/></td>';
								}else{
									tr_html+='<td><spring:message code="language.downshelves"/></td>';
								}
								tr_html+='<td>'+data[i].workerName+'</td>';
							    tr_html+='</tr>';
						}
						html+='<input type="text" placeholder="<spring:message code="language.goodsname" />" id="goodName" name="goodName"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
						html+='<input type="text" placeholder="<spring:message code="language.goodsCode" />" id="goodCode" name="goodCode"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
						html+='<input type="button" value="<spring:message code="language.queryBtn" />" onclick="selectGoodsBymz();"/>';
						html+='<div id="ddd">';
						html+='<table id="bootstrap-table" class="table">';
		                html+='            <thead>';
		                html+='           	    <th><input type="checkbox" id="checkall" name="checkall" onclick="checkGoodsAll(checkall)" /><spring:message code="language.allselect" /></th>'
		                html+='           	    <th><spring:message code="language.goodsCode"/></th>';
		                html+='          	    <th><spring:message code="language.goodsname"/></th>';
		                html+='          	    <th><spring:message code="language.categoryName"/></th>';
		                html+='          	    <th><spring:message code="language.language"/></th>';
		                html+='          	    <th><spring:message code="language.channel"/></th>';
		                html+='           	    <th><spring:message code="language.cardType"/></th>';
		                html+='       	        <th><spring:message code="language.goodsPrice"/></th>';
			            html+='      	        <th><spring:message code="language.status"/></th>';
			            html+='      	        <th><spring:message code="language.operator"/></th>';
		                html+='            </thead>';
						html+='<tbody>';
						html+=tr_html;
						html+='</tbody>';
		                html+='</table>';
		                html+='</div>';
		                
						var index = layer.open({
						  title:"选择推荐商品",
						  type: 1,
						  skin: 'layui-layer-rim', //加上边框
						  area: ['1200px', '700px'], //宽高
						  content: html,
						  btn:"确定",
						  yes:function(){
						  		var tr_str = "";
						  		var goods_str = "";
						  		$("input[name='goodsId']:checked").each(function(){
						  			var coupId = $(this).val();
						  			for(var i=0;i<data.length;i++){
						  				var cpId = data[i].goodsId;
						  				if(cpId==coupId){
						  					goods_str +=	data[i].goodsId+",";
						  					tr_str+='<span>'+data[i].goodsName+'</span>&nbsp;&nbsp;';
						  					break;
						  				}
						  			}
						  		});
						  		$("#goods").empty();
						  		$("#recgGoodsIds").empty();
						  		$("#goods").html(tr_str);
						  		$("#recgGoodsIds").val(goods_str.substring(0,goods_str.length-1));
						  		layer.close(index);
						  }
						});
						
						
						
					}
				});
			}
			//选择优惠券是的查询
			function selectGoodsBymz(){
				 
				$("#ddd").empty();
				var goodName = $("#goodName").val();
				var goodCode = $("#goodCode").val();
			 
				$.ajax({
					url:"/goodsInfo/selectGoods.do",
					data:{
						goodsName : goodName,
						goodsCode : goodCode
						},
					type:"post",
					dataType:"json",
					success:function(data){
						console.log(data);
						console.log(data.allGoodsList.length);
						data =data.allGoodsList;
						console.log(data);
						
						var html = "";
						var tr_html = "";
						for(var i=0;i<data.length;i++){
							tr_html+='<tr id=tr_'+data[i].goodsId+'>';
								var chk_html = "";
								console.log("===============");
								console.log(data[i].goodsId)
								

								var ids = document.getElementById("recgGoodsIds").value;
								var arr = ids.split(",");
							     for(n=0;n<arr.length;n++){
							     	if(data[i].goodsId==arr[n]){
										chk_html+='<td><input type="checkbox" name="goodsId" id="goodsId" checked value="'+data[i].goodsId+'"></td>';
							     	}
							     }
								     
								if(chk_html==""){
									tr_html+='<td><input type="checkbox" name="goodsId" id="goodsId" value="'+data[i].goodsId+'"></td>';
								}else{
									tr_html+=chk_html;
								}
								tr_html+='<td>'+data[i].goodsCode+'</td>';
								tr_html+='<td>'+data[i].goodsName+'</td>';
								tr_html+='<td>'+data[i].allName+'</td>';
								tr_html+='<td>'+data[i].languageName+'</td>';
								tr_html+='<td>'+data[i].channelName+'</td>';
								if(data[i].cardType==1){
									tr_html+='<td><spring:message code="language.entityCard"/></td>';
								}else{
									tr_html+='<td><spring:message code="language.virtualCard"/></td>';
								}
								tr_html+='<td>'+data[i].minPrice+'-'+data[i].maxPrice+'</td>';
								
								if(data[i].status==1){
									tr_html+='<td><spring:message code="language.shelves"/></td>';
								}else{
									tr_html+='<td><spring:message code="language.downshelves"/></td>';
								}
								tr_html+='<td>'+data[i].workerName+'</td>';
							    tr_html+='</tr>';
						}
						
						html+='<table id="bootstrap-table" class="table">';
		                html+='            <thead>';
		                html+='           	     <th><input type="checkbox" id="checkall" name="checkall" onclick="checkGoodsAll(checkall)" /><spring:message code="language.allselect" /></th>'
		                html+='           	    <th><spring:message code="language.goodsCode"/></th>';
		                html+='          	    <th><spring:message code="language.goodsname"/></th>';
		                html+='          	    <th><spring:message code="language.categoryName"/></th>';
		                html+='          	    <th><spring:message code="language.language"/></th>';
		                html+='          	    <th><spring:message code="language.channel"/></th>';
		                html+='           	    <th><spring:message code="language.cardType"/></th>';
		                html+='       	        <th><spring:message code="language.goodsPrice"/></th>';
			            html+='      	        <th><spring:message code="language.status"/></th>';
			            html+='      	        <th><spring:message code="language.operator"/></th>';
		                html+='            </thead>';
						html+='<tbody>';
						html+=tr_html;
						html+='</tbody>';
		                html+='</table>';
		                $("#ddd").append(html);
					}
				});
			}
			
			//全选商品
			function checkGoodsAll(checkall) {
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
			function showCategorys(){
				$("#showCategorysDiv").show();
				$("#showGoodsDiv").hide();
				$("#goods").html("");
				$("#recgGoodsIds").val("");
			}
			
			function showGoods(){
				$("#showGoodsDiv").show();
				$("#showCategorysDiv").hide();
				$("#categorys").html("");
				$("#recgCategoryIds").val("");
			}
	</script>

</body>
</html>