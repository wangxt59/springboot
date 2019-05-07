<%@ page language="java"
	import="java.util.*,com.website.utils.CommonsUtil"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>
设置区域价格
</title>
<base href="<%=basePath%>">
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
<script type="text/javascript" src="<%=path %>/js/jquery/jquery-1.7.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/json/json-minified.js"></script>

</head>
<style>
.fixed-table-toolbar {
	width: 100%;
	overflow: hidden;
}
.col-sm-2{width:100%;margin:3px}
.jiage{width:20%;float:left}
.area{position:relative;
width:100%;} 
#zoning {
	position: fixed;
	top: 0;
	z-index: 999;
	display: none;
	margin: 5% 10%;
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
	background: #ccc;
	color: #fff;
	padding: 6px 5px;
}
.wxt{
    min-width:20px;
}
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
				<form action="/goodsSku/addgoodsSku.do" name="categoryform"
					id="categoryform" method="post" accept-charset="utf-8">
					<div class="row">
						<div class="col-md-12">
							<div class="card" >
								<div class="content">
									<legend>设置区域价格</legend>
									<!-- 1.商品名称 -->
									<fieldset>
										<div class="form-group" >
											<label class="col-sm-2 control-label " >
											商品名称:&nbsp;&nbsp;&nbsp;<c:out value="${map.goods_name}" /></label>
											<label class="col-sm-2 control-label" >
											商品分类：&nbsp;&nbsp;&nbsp;<c:out value="${map.category_name}" /></label>
											<label class="col-sm-2 control-label" >
											商品规格:&nbsp;&nbsp;&nbsp;<c:out value="${map.spec}" /></label>
											<label class="col-sm-2 control-label jiage" >
											成本价:&nbsp;&nbsp;&nbsp;<c:out value="${map.cost_price}" /></label>
											<label class="col-sm-2 control-label jiage" >
											市场价:&nbsp;&nbsp;&nbsp;<c:out value="${map.market_price}" /></label>
											<input id="stockinp" name="stockinp" value="${map.stock}" type="hidden"/>
											<label class="col-sm-2 control-label " >
											设置区域售价：（不设置区域售价地区按市场价销售）</label>
											<div class="col-sm-2 control-label " >
												<div  class=" control-label area" style="color: #888888;">常用省份：</div>
												<div  id="provincesTab1" class="area">
													<li class="provincesList" onclick="getCitys(110000,'北京市');"><a  class="wxt btn btn-round btn-wd ">北京市</a><a><input type="hidden" id="area_no" value="110000"></a></li>
													<li class="provincesList" onclick="getCitys(120000,'天津市');"><a class="wxt btn btn-round btn-wd">天津市</a><a><input type="hidden" id="area_no" value="120000"></a></li>
													<li class="provincesList" onclick="getCitys(130000,'河北省');"><a class="wxt btn btn-round btn-wd">河北省</a><a><input type="hidden" id="area_no" value="130000"></a></li>
													<li class="provincesList" onclick="getCitys(140000,'山西省');"><a class="wxt btn btn-round btn-wd">山西省</a><a><input type="hidden" id="area_no" value="140000"></a></li>
												</div>
												<div style="margin:5px;padding:5px">
													<a class="area" style="margin:5px;padding:5px"  onclick="getProvinces();" >添加省份</a>
												</div>
											</div>	
											<br />
									
											<!-- 000000000000000000000000 -->
											<!-- 区划 -->
											<div id="zoning">
												<div class="modal-dialog" >
													<div class="modal-content">
														<div class="modal-header">
															<button type="button" class="close" data-dismiss="modal"
																aria-hidden="true"></button>
														</div>
														<div class="modal-body"  >
															<div>
																<p style="color: blue">添加省份</p>
																<div>
																	<ul id="provincesTab"></ul>
																</div>
																<div style="clear: both;"></div>
																<div style="clear: both;"></div>
															</div>
										
														</div>
														<div class="modal-foot"
															style="width: 850px; height: 100px; text-align: center;">
															<button type="button" class="btn btn-info btn-fill btn-wd" 
																onclick="saveProvince()">确认</button>
															<button type="button" class="btn btn-info btn-fill btn-wd"
																id="closeZoning">关闭</button>
															
														</div>
													</div>
												</div>
											</div>
											
											<!--000000000000000000000000000000000  -->
											<div class="  " >
												<label style="color: #888888;font-weight:10;" class="col-sm-2 control-label ">选择地区：</label>
												<div id="citysTab" style="width:600px;margin-left:20px"></div>
											</div>
											
											<div class="col-sm-2  " style="margin-left:600px">
												<input type="button" class="btn btn-info btn-fill btn-wd" 
												id="doSubmit" onclick="showtable();" value="添加价格">
											</div>
											<div class="col-sm-2 control-label " style="font-size:16px;">
											<label class="col-sm-2 control-label" style="color: #888888;font-weight:10;">
											设置价格：</label>
											<div id="eee"></div>
											<table id="table" class="table" border="1" cellspacing="0" 
												bordercolor="#000000"  style="margin-bottom:30px">
											    <thead>
													<th class="text-center">设置省份</th>
													<th class="text-center">设置城市</th>
													<th class="text-center">分配库存</th>
													<th class="text-center">团长返利%</th>
													<th class="text-center">区域售价</th>
													<th data-field="actions" class="text-center text-center">操作</th>
												</thead>
										    <table>
											</div>
											<div class="footer text-center">
												<button type="button" class="btn btn-info btn-fill btn-wd"
													id="doSubmit" onclick="checkInfo();">保存设置</button>
												<input type="button" class="btn btn-fill btn-wd" name="Submit" onclick="javascript:history.back(-1);" value="返回">
											</div>
											
										</div>
									</fieldset>
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
</body>
<%-- <%-- <%@ include file="../inc/footer.html"%> --%>
<script type="text/javascript">
	function getProvinces() {
		$.ajax({
			type : "GET",
			url : "/genArea/getArea.do",
			dataType : "json",
			success : function(data) {
				var html = '';
				for (var i = 0; i < data.length; i++) {
					html += "<li class='provincesList'>"
							+ "<a class='wxt btn btn-round btn-wd ' >" + data[i].AREA_NAME
							+ "</a>" +"<a><input type='hidden' id = 'area_no' value ='"+data[i].AREA_NO+"'/></a>"
							 + '<a><input type="checkbox"  /></a>' 
							+ "</li>"
	
				}
				$("#provincesTab").html(html);
				$("#zoning").css("display", "block");
				//$("#provincesTab").style.display="";
			}
		});
	}
	function saveProvince() {
		var tb = document.getElementById('provincesTab');
		var rows = tb.children.length;
		var html = '';
		for (var i = 0; i < rows; i++) {
			if (tb.childNodes[i].childNodes[2].firstChild.checked) {
				var provincesid=tb.childNodes[i].childNodes[1].firstChild.value;
				var provincesname=tb.childNodes[i].childNodes[0].innerHTML;
				html += '<li class="provincesList" onclick="getCitys(' +provincesid+ ",'" +provincesname+ "');"+ '">';
				html+=tb.childNodes[i].childNodes[0].outerHTML;
				html+=tb.childNodes[i].childNodes[1].outerHTML;
				html+= "</li>";
				}
				
			}
		$("#zoning").css("display", "none");
		$("#provincesTab1").html(html);
		$("#provincesTab1").css("display", "");
		
	}
	var pid="";
	var pname="";
	function getCitys(parentId,parentName) {
		pid=parentId;
		pname=parentName;
		
		$.ajax({
			type : "GET",
			url : "/genArea/getArea.do?parentId=" + parentId,
			dataType : "json",
			success : function(data) {
				
				var html = '';
				for (var i = 0; i < data.length; i++) {
					html += "<li class='provincesList' name='areachild'>"
							+ "<a class='wxt btn btn-round btn-wd ' >"
							+ data[i].AREA_NAME
							+ "</a>"
							+ "<a><input type='checkbox' id = 'cityBox'/></a>"
							+ "<a><input type='hidden' id = 'area_no' value = "+data[i].AREA_NO+"></a>"
							+ "</li>"
				}
				$("#citysTab").html(html);
			}
		});
	}
	
	var arr=[];
	function showtable() {
        w=document.getElementsByName("areachild")
        for (j=0;j<w.length;j++){
        	var state=true;
		    if(w[j].childNodes[1].childNodes[0].checked){
		    
		    cityname=w[j].childNodes[0].innerHTML;//市名
		    cityid=w[j].childNodes[2].childNodes[0].value;
			
		   	
	                for(i=0;i<arr.length;i++){
	                	if(arr[i]==cityname){
	                	state=false;
	                	break;
	                	}
	                }
	          //alert(state);
              if(state==false){
              continue;
              }
              arr.push(cityname);
              //d=w[j].nextSibling.nodeValue;
              var table = $("#table");
              table.append("<tr><td style='display: none'>"+cityid+"</td><td class='tcenter text-center'>"+pname+"</td><td class='tcenter text-center'>"
              +cityname+"</td><td name='stock1' class='tcenter text-center'><input value='${map.stock}' type='text' name='stock'></td><td name='rebate_ratio1' class='tcenter text-center'><input value='${map.rebateRatio}' type='text' name='rebateRatio'></td><td name='region_price1' class='tcenter text-center'><input value='${map.regionPrice}' type='text' name='regionPrice'></td><td class='tcenter text-center'><a name='remove'   onclick='mydelete(this);'>删除</a></td></tr>");
            }
        }
        
    }
	
	
	$().ready(function() {	
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

	});
	
	
	function show1(data){
		var arr = jsonParse(data);
		var  html='';
		for(var o in arr){
			 html+= '<input type="checkbox" >';
			 html+=arr[o].AREA_NAME;
			//op.text=arr[o].name;//这一句在ie下不起作用，用下面这一句或者innerHTML
		}
	    document.getElementById("ddd").innerHTML=html;
    }
	
	
	function show(data){
	    
	    var obj = document.getElementById("province"); //定位id

		var index = obj.selectedIndex; // 选中索引
		
		var text = obj.options[index].text; // 选中文本
		
		var value = obj.options[index].value; // 选中值
		alert(data.value);
		var  html='';
			// html+='<input type="radio" valve="110000" name="area" onclick="showchild(110000);"/>北京'+    
					//'<input type="radio" valve="120000" name="area" onclick="showchild(120000);"/>河北 '+
				//	'<input type="radio" valve="130000" name="area" onclick="showchild(130000);"/>天津'+
				//	'<input type="radio" valve="140000" name="area" onclick="showchild(140000);"/>山西';
			 html+= '<input type="radio" valve="'+data.value+'" name="area" onclick="showchild('+data.value+');"/>';
			
			 html+=text;
	    document.getElementById("ddd").innerHTML=html;
    }
	
	
	function slect() {
        var html='';
        y=document.getElementsByName("inp")
        for (j=0;j<y.length;j++){
            if(y[j].checked==true){

                a=y[j].value;
                b=y[j].nextSibling.nodeValue;
                y[j].nextElementSibling;
                html+=a+b;
            }

        }
        document.getElementById("eee").innerHTML=html;
    }
    function fun1(data) {
    	var arr = jsonParse(data);
        var html='';
        for (i=0;i<arr.length;i++){
            html+=' <input type="checkbox" value="'+arr[i].AREA_NO+'" name="areachild" onclick="showname()" >';
            html+=arr[i].AREA_NAME;
        }
        document.getElementById("ccc").innerHTML=html;
    }
	
    	function mydelete(obj){
                var tr=obj.parentNode.parentNode;
                var tbody=tr.parentNode;
                //alert(tr.childNodes[2].innerHTML);
                tbody.removeChild(tr);
                for (var i = 0; i < arr.length; i++) {
					if (arr[i]==tr.childNodes[2].innerHTML) {
						delete arr[i];
					} 
				}
                       
        }
    	
    	
		function checkInfo(){
			var stock =document.getElementsByName('stock');
			var rebateRatio =document.getElementsByName('rebateRatio');
			var regionPrice =document.getElementsByName('regionPrice');
			var stockTotle=document.getElementById('stockinp').value;
			var stockNum=0;
			for(i=0;i<stock.length;i++){
				
	    		if(stock[i].value==null||stock[i].value==""){
	    			alert("请设置库存");
	    			return;
	    		}
	    		stockNum=stockNum+parseInt(stock[i].value);
	    		if (stockNum>stockTotle&&stockTotle!="") {
	    			alert("库存超过库存总数");
	    			stockNum-=stock[i].value;
	    			return;
				}
	    		if(rebateRatio[i].value==null||rebateRatio[i].value==""){
	    			alert("请设置团长返利");
	    			return;
	    		}
	    		if(regionPrice[i].value==null||regionPrice[i].value==""){
	    			alert("请设置区域售价");
	    			return;
	    		}
	    		
    		}
			var tr;
			var dataArray = [];
			var num=table.rows.length;
			var goods_id="${map.goods_id}";
			var market_price="${map.market_price}";
			var rebate_type="${map.rebate_type}";
			var rebate_amount="${map.rebate_amount}";
			var region_type="${map.region_type}"; 
			for(var i=1;i<num;i++){
				tr = table.rows[i];
				regionId=tr.childNodes[0].innerHTML.replace(/(^\s*)|(\s*$)/g, "");
				province = tr.childNodes[1].innerHTML.replace(/(^\s*)|(\s*$)/g, "");
				regionName = tr.childNodes[2].innerHTML.replace(/(^\s*)|(\s*$)/g, "");
				stock = tr.cells[3].getElementsByTagName("input")[0].value;
				rebateRatio = tr.cells[4].getElementsByTagName("input")[0].value;
				regionPrice = tr.cells[5].getElementsByTagName("input")[0].value;
				var datatem={"goodsId":goods_id,"marketPrice":market_price,
				"regionType":region_type,
				"regionId":regionId,"province":province,"regionName":regionName,
				"stock":stock,"rebateRatio":rebateRatio,"regionPrice":regionPrice};
				//将table表对象转换成数组装成json放在数组里
				dataArray.push(datatem);
			}
			var aa=JSON.stringify(dataArray);
			//alert(aa);
			$.ajax({
				url : "/goodsSku/addgoodsSku.do",
				dataType:"json",      
            	contentType:"application/json", 
				data : JSON.stringify(dataArray),
				type : "post",
				success : function(data) {
					window.location.href="/goodsSku/regionalPrices.do?goods_id="+goods_id;
				},
			});
			
			
		} 
</script>
</html>
