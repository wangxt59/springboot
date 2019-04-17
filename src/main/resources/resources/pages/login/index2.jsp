<%@ page language="java"
	import="java.util.*,com.antke.power.model.bean.WorkerInfo"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>总后台管理中心</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="Text/Javascript" language="JavaScript">
<!--

if (window.top != window) {
	window.top.location.href = document.location.href;
}

//-->
</script>
<!--<frameset rows="68,*" framespacing="0" border="0" id="frame-all">
			<frame src="index.php?act=top" id="header-frame" name="header-frame" frameborder="no" scrolling="no"></frame>
			<frameset cols="200, *" framespacing="0" border="0" id="frame-body">
				<frame src="index.php?act=menu" id="menu-frame" name="menu_frame" frameborder="no" scrolling="yes"></frame>
				<frame src="index.php?act=main" id="main-frame" name="main_frame" frameborder="no" scrolling="yes"></frame>
			</frameset>
			<noframes>
			</noframes>
			<frameset rows="0, 0" framespacing="0" border="0">
				<frame src="" id="hidd-frame" name="hidd-frame" frameborder="no" scrolling="no"></frame>
			</frameset>
		</frameset>-->
</head>
<body>
	<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>总后台管理中心</title>
<meta name="robots" content="noindex, nofollow">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/general.css" rel="stylesheet" type="text/css" />
<link href="/css/main.css" rel="stylesheet" type="text/css" />
<script language="JavaScript">
<!--
// 这里把JS用到的所有语言都赋值到这里
			var process_request = "正在处理您的请求...";
			var todolist_caption = "记事本";
			var todolist_autosave = "自动保存";
			var todolist_save = "保存";
			var todolist_clear = "清除";
			var todolist_confirm_save = "是否将更改保存到记事本？";
			var todolist_confirm_clear = "是否清空内容？";
			var expand_all = "展开";
			var collapse_all = "闭合";
			var shop_name_not_null = "商店名称不能为空";
			var good_name_not_null = "商品名称不能为空";
			var good_category_not_null = "商品分类不能为空";
			var good_number_not_number = "商品数量不是数值";
			var good_price_not_number = "商品价格不是数值";
			//-->
</script>
</head>
<body>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="/css/general.css" rel="stylesheet" type="text/css" />
	<link href="/css/top_new.css" rel="stylesheet" type="text/css" />
	<link href="/css/font-awesome.min.css" rel="stylesheet" />
	<script type="text/javascript">
		//帮助系统调用
		function web_address() {
			var ne_add = parent.document.getElementById('main-frame');
			var ne_list = ne_add.contentWindow.document.getElementById('search_id').innerHTML;
			ne_list.replace('-', '');
			var arr = ne_list.split('-');
			window.open('help.php?al=' + arr[arr.length - 1], '_blank');
		}
		//授权检测回调处理
		function start_sendmail_Response(result) {
			// 运行正常
			if (result.error == 0) {
				var str = '';
				if (result['content']['auth_str']) {
					str = '<a href="javascript:void(0);" target="_blank">' + result['content']['auth_str'];
					if (result['content']['auth_type']) {
						str += '[' + result['content']['auth_type'] + ']';
					}
					str += '</a> ';
				}
				document.getElementById('license-div').innerHTML = str;
			}
		}
		function modalDialog(url, name, width, height) {
			if (width == undefined) {
				width = 400;
			}
			if (height == undefined) {
				height = 300;
			}
			if (window.showModalDialog) {
				window.showModalDialog(url, name, 'dialogWidth=' + (width) + 'px; dialogHeight=' + (height + 5) + 'px; status=off');
			} else {
				x = (window.screen.width - width) / 2;
				y = (window.screen.height - height) / 2;
	
				window.open(url, name, 'height=' + height + ', width=' + width + ', left=' + x + ', top=' + y + ', toolbar=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, modal=yes');
			}
		}
		function ShowToDoList() {
			try {
				var mainFrame = window.top.frames['main_frame'];
				mainFrame.window.showTodoList(adminId);
			} catch (ex) {}
		}
		var adminId = "";
	</script>
	<script>
	/* $(document).ready(function(){
		var time = null;
		$(".menu-button").hover(function(){
			clearTimeout(time);
			k = $(this).attr("key");
			$(this).addClass("on").siblings().removeClass("on");
			time = setTimeout(function(){
				$(".dropdown").show();
				$("#" + k).siblings().hide();
				$("#" + k).show();
				$(".main").addClass("fuzzy");
			},300);
		});
		$(".menu-button-wu").hover(function(){
			clearTimeout(time);
			$(this).addClass("on").siblings().removeClass("on");
			time = setTimeout(function(){
				$(".dropdown").hide();
			},300);
		});
		$(".submenu").mouseleave(function(){
			clearTimeout(time);
			$(".dropdown").hide();
			$(".menu-button").removeClass("on");
			$(".menu-button-wu").removeClass("on");
			$(".main").removeClass("fuzzy");
		});
		$(".individual-list").hover(function(){
			isOut = false;
		},function(){
			isOut = true;
		});
		$(document).click(function(){
			if(isOut == true){
				$(".individual-menu").hide();
			}else{
				$(".individual-menu").toggle();
			}
		});
	}); */
	</script>
	<%@ include file="../inc/header.jsp"%>
	<div class="main">
		<h1>
			<span class="action-span1"> <a href="/pages/login/index.jsp">
					总后台管理中心 </a>
			</span>
			<div style="clear:both"></div>
		</h1>
		<!-- star 升级 -->
		<div class="menu-div">
			<ul>
				<li class="menu-1"><a href="/pages/goods/add.jsp"><i
						class="fa-4x icon-1"><img src="/images/icon11.png" /></i> <span
						class="title">添加商品</span></a></li>
				<li class="menu-2"><a href="/goods/list.do"> <i
						class="fa fa-4x icon-2"><img src="/images/icon12.png" /></i> <span
						class="title">商品列表</span></a></li>
				<li class="menu-3"><a href="/order/list.do"> <i
						class="fa fa-4x icon-3"><img src="/images/icon13.png" /></i> <span
						class="title">商家订单</span></a></li>
				<li class="menu-4"><a href="/user/list.do"> <i
						class="fa fa-4x icon-4"><img src="/images/icon14.png" /></i> <span
						class="title">会员列表</span></a></li>
				<li class="menu-4"><a href="/depot_info/list.do"> <i
						class="fa fa-4x icon-2"><img src="/images/icon12.png" /></i> <span
						class="title">前置仓列表</span></a></li>
				<li class="menu-4"><a href="/cabinet_info/list.do"> <i
						class="fa fa-4x icon-3"><img src="/images/icon12.png" /></i> <span
						class="title">货柜列表</span></a></li>
				<li class="menu-1"><a href="/chant/add.jsp"><i
						class="fa-4x icon-1"><img src="/images/icon11.png" /></i> <span
						class="title">添加商户</span></a></li>
				<li class="menu-2"><a href="/chant/queryChantList.do"> <i
						class="fa fa-4x icon-2"><img src="/images/icon12.png" /></i> <span
						class="title">商户列表</span></a></li>

			</ul>
		</div>
		<div style="height:0px;line-height:0px;clear:both"></div>
		<br />
	</div>
	<script type="text/javascript" src='/js/echarts-all.js'></script>
	<script>
		var froms_chart = echarts.init(document.getElementById('froms_chart_div'));
		froms_chart.setOption({
			"tooltip" : {
				"trigger" : "item",
				"formatter" : "{a} <br\/>{b} : {c} ({d}%)"
			},
			"legend" : {
				"orient" : "vertical",
				"x" : "left",
				"y" : "20",
				"data" : null
			},
			"toolbox" : {
				"show" : true,
				"feature" : {
					"magicType" : {
						"show" : true,
						"type" : [ "pie", "funnel" ]
					},
					"restore" : {
						"show" : true
					},
					"saveAsImage" : {
						"show" : true
					}
				}
			},
			"calculabe" : true,
			"series" : [ {
				"type" : "pie",
				"radius" : "55%",
				"center" : [ "50%", "60%" ],
				"data" : []
			} ]
		});
		var order_chart = echarts.init(document.getElementById('order_chart_div'));
		order_chart.setOption({
			"tooltip" : {
				"trigger" : "axis"
			},
			"legend" : {
				"data" : []
			},
			"toolbox" : {
				"show" : true,
				"x" : "right",
				"feature" : {
					"magicType" : {
						"show" : true,
						"type" : [ "line", "bar" ]
					},
					"restore" : {
						"show" : true
					},
					"saveAsImage" : {
						"show" : true
					}
				}
			},
			"calculable" : true,
			"xAxis" : {
				"type" : "category",
				"boundryGap" : false,
				"data" : [ 1, 2 ]
			},
			"yAxis" : {
				"type" : "value",
				"axisLabel" : {
					"formatter" : "{value}\u4e2a"
				}
			},
			"series" : [ {
				"name" : "\u8ba2\u5355\u4e2a\u6570",
				"type" : "line",
				"data" : [ 0, 0 ],
				"markPoint" : {
					"data" : [ {
						"type" : "max",
						"name" : "\u6700\u5927\u503c"
					}, {
						"type" : "min",
						"name" : "\u6700\u5c0f\u503c"
					} ]
				},
				"markLine" : {
					"data" : [ {
						"type" : "average",
						"name" : "\u5e73\u5747\u503c"
					} ]
				}
			} ]
		});
		var sales_chart = echarts.init(document.getElementById('sales_chart_div'));
		sales_chart.setOption({
			"tooltip" : {
				"trigger" : "axis"
			},
			"toolbox" : {
				"show" : true,
				"x" : "right",
				"feature" : {
					"magicType" : {
						"show" : true,
						"type" : [ "line", "bar" ]
					},
					"restore" : {
						"show" : true
					},
					"saveAsImage" : {
						"show" : true
					}
				}
			},
			"calculable" : true,
			"xAxis" : {
				"type" : "category",
				"boundryGap" : false,
				"data" : [ 1, 2 ]
			},
			"yAxis" : {
				"type" : "value",
				"axisLabel" : {
					"formatter" : "{value}\u5143"
				}
			},
			"series" : [ {
				"name" : "\u9500\u552e\u989d",
				"type" : "line",
				"data" : [ 0, 0 ],
				"markPoint" : {
					"data" : [ {
						"type" : "max",
						"name" : "\u6700\u5927\u503c"
					}, {
						"type" : "min",
						"name" : "\u6700\u5c0f\u503c"
					} ]
				},
				"markLine" : {
					"data" : [ {
						"type" : "average",
						"name" : "\u5e73\u5747\u503c"
					} ]
				}
			} ]
		});
	</script>
	<!-- end 升级 -->

	<script type="text/javascript" src="/js/utils.js"></script>
	<script type="Text/Javascript" language="JavaScript">
	<!--
	onload = function()
	{
	  /* 检查订单 */
	  startCheckOrder();
	}
	Ajax.call('index.php?is_ajax=1&act=main_api','', start_api, 'GET', 'JSON');
	function start_api(result)
	{
    	document.getElementById("php_ver").innerHTML = result.php_ver;
		document.getElementById("mysql_ver").innerHTML = result.mysql_ver;
		document.getElementById("ver").innerHTML = result.ver;
		document.getElementById("pro_ver").innerHTML = result['version']['ver'];
		document.getElementById("charset").innerHTML = result.charset;
		apilist = document.getElementById("lilist").innerHTML;
		document.getElementById("lilist").innerHTML = apilist;
		if (document.getElementById("Marquee") != null) {
			var Mar = document.getElementById("Marquee");
			lis = Mar.getElementsByTagName('div');
			if (lis.length > 1) {
				api_styel();
			}
		}
    }
    function api_styel()
    {
    	if (document.getElementById("Marquee") != null) {
			var Mar = document.getElementById("Marquee");
			if (Browser.isIE) {
				Mar.style.height = "52px";
			} else {
				Mar.style.height = "36px";
			}
			var child_div = Mar.getElementsByTagName("div");
			var picH = 16; //移动高度
			var scrollstep = 2; //移动步幅,越大越快
			var scrolltime = 30; //移动频度(毫秒)越大越慢
			var stoptime = 4000; //间断时间(毫秒)
			var tmpH = 0;
			function start() {
				if (tmpH < picH) {
					tmpH += scrollstep;
					if (tmpH > picH) tmpH = picH;
					Mar.scrollTop = tmpH;
					setTimeout(start, scrolltime);
				} else {
					tmpH = 0;
					Mar.appendChild(child_div[0]);
					Mar.scrollTop = 0;
					setTimeout(start, stoptime);
				}
			}
			setTimeout(start, stoptime);
    	}
    }
//-->
</script>

	</div>
	<%@ include file="../inc/footer.html"%>
	<!-- 新订单提示信息 -->
	<div id="popMsg">
		<table cellspacing="0" cellpadding="0" width="100%" bgcolor="#cfdef4"
			border="0">
			<tr>
				<td style="color: #0f2c8c" width="30" height="24"></td>
				<td
					style="font-weight: normal; color: #1f336b; padding-top: 4px;padding-left: 4px"
					valign="center" width="100%">新订单通知</td>
				<td style="padding-top: 2px;padding-right:2px" valign="center"
					align="right" width="19"><span title="关闭"
					style="cursor: hand;cursor:pointer;color:red;font-size:12px;font-weight:bold;margin-right:4px;"
					onclick="Message.close()">×</span> <!-- <img title=关闭 style="cursor: hand" onclick=closediv() hspace=3 src="msgclose.jpg"> --></td>
			</tr>
			<tr>
				<td style="padding-right: 1px; padding-bottom: 1px" colspan="3"
					height="70">
					<div id="popMsgContent">
						<p>
							您有 <strong style="color:#ff0000" id="spanNewOrder">1</strong>
							个新订单以及 <strong style="color:#ff0000" id="spanNewPaid">0</strong>
							个新付款的订单
						</p>
						<p align="center" style="word-break:break-all">
							<a href="order.php?act=list"><span style="color:#ff0000">点击查看新订单</span></a>
						</p>
					</div>
				</td>
			</tr>
		</table>
	</div>
	<!--
<embed src="images/online.wav" width="0" height="0" autostart="false" name="msgBeep" id="msgBeep" enablejavascript="true"/>
-->

	<script language="JavaScript">
		document.onmousemove = function(e) {
			var obj = Utils.srcElement(e);
			if (typeof (obj.onclick) == 'function' && obj.onclick.toString().indexOf('listTable.edit') != -1) {
				obj.title = '点击修改内容';
				obj.style.cssText = 'background: #278296;';
				obj.onmouseout = function(e) {
					this.style.cssText = '';
				}
			} else if (typeof (obj.href) != 'undefined' && obj.href.indexOf('listTable.sort') != -1) {
				obj.title = '点击对列表排序';
			}
		}
	
	
	
		var MyTodolist;
		function showTodoList(adminid) {
			if (!MyTodolist) {
				var global = $import("../js/global.js", "js");
				global.onload = global.onreadystatechange = function() {
					if (this.readyState && this.readyState == "loading") return;
					var md5 = $import("js/md5.js", "js");
					md5.onload = md5.onreadystatechange = function() {
						if (this.readyState && this.readyState == "loading") return;
						var todolist = $import("js/todolist.js", "js");
						todolist.onload = todolist.onreadystatechange = function() {
							if (this.readyState && this.readyState == "loading") return;
							MyTodolist = new Todolist();
							MyTodolist.show();
						}
					}
				}
			} else {
				if (MyTodolist.visibility) {
					MyTodolist.hide();
				} else {
					MyTodolist.show();
				}
			}
		}
	
		if (Browser.isIE) {
			onscroll = function() {
				//document.getElementById('calculator').style.top = document.body.scrollTop;
				document.getElementById('popMsg').style.top = (document.body.scrollTop + document.body.clientHeight - document.getElementById('popMsg').offsetHeight) + "px";
			}
		}
	
		if (document.getElementById("listDiv")) {
			document.getElementById("listDiv").onmouseover = function(e) {
				obj = Utils.srcElement(e);
	
				if (obj) {
					if (obj.parentNode.tagName.toLowerCase() == "tr")
						row = obj.parentNode;
					else if (obj.parentNode.parentNode.tagName.toLowerCase() == "tr")
						row = obj.parentNode.parentNode;
					else return;
	
					for (i = 0; i < row.cells.length; i++) {
						if (row.cells[i].tagName != "TH")
							row.cells[i].style.backgroundColor = '#F4FAFB';
					}
				}
	
			}
	
			document.getElementById("listDiv").onmouseout = function(e) {
				obj = Utils.srcElement(e);
	
				if (obj) {
					if (obj.parentNode.tagName.toLowerCase() == "tr")
						row = obj.parentNode;
					else if (obj.parentNode.parentNode.tagName.toLowerCase() == "tr")
						row = obj.parentNode.parentNode;
					else return;
	
					for (i = 0; i < row.cells.length; i++) {
						if (row.cells[i].tagName != "TH")
							row.cells[i].style.backgroundColor = '#FFF';
					}
				}
			}
	
			document.getElementById("listDiv").onclick = function(e) {
				var obj = Utils.srcElement(e);
	
				if (obj.tagName == "INPUT" && obj.type == "checkbox") {
					if (!document.forms['listForm']) {
						return;
					}
					var nodes = document.forms['listForm'].elements;
					var checked = false;
	
					for (i = 0; i < nodes.length; i++) {
						if (nodes[i].checked) {
							checked = true;
							break;
						}
					}
	
					if (document.getElementById("btnSubmit")) {
						document.getElementById("btnSubmit").disabled = !checked;
					}
					for (i = 1; i <= 10; i++) {
						if (document.getElementById("btnSubmit" + i)) {
							document.getElementById("btnSubmit" + i).disabled = !checked;
						}
					}
				}
			}
	
		}
	
		//
	
		/* $(function(){
			//异步加载数据
			//订单数据
			$.post(
				"/order/queryOrderCount.do",{"search_day":0},function(data){
					//今日销售总额
					$("#todayTotalTrading").html(data.todayTotalTrading);
					//平台销售总额
					$("#totalTrading").html(data.totalTrading);
					//今日订单数
					$("#todayTotalCount").html(data.todayOrderCount);
					//总订单数
					$("#totalCount").html(data.orderTotalCount);
					//待发货订单数
					$("#waitingSend").html(data.waitingSendCount+"/"+data.orderTotalCount)
					$("#waitingSendBar").css("width",data.waitingSendCountBar);
					//待支付订单数
					$("#waitingPay").html(data.waitingPayCount+"/"+data.orderTotalCount);
					$("#waitingPayBar").css("width",data.waitingPayCountBar);
					//待确认订单数
					$("#waitingConfirm").html(data.waitingConfirmCount+"/"+data.orderTotalCount);
					$("#waitingConfirmBar").css("width",data.waitingConfirmCountBar);
					//已成交订单数
					$("#concluded").html(data.concludedCount+"/"+data.orderTotalCount);
					$("#concludedBar").css("width",data.concludedCountBar);
					//已发货订单数
					$("#haveSend").html(data.haveSendCount+"/"+data.orderTotalCount);
					$("#haveSendBar").css("width",data.haveSendCountBar);
					//退款申请
					$("#applyRefund").html(data.applyRefundCount+"/"+data.totalRefundCount);
					$("#applyRefundBar").css("width",data.applyRefundBar);
				}
			);
			//会员数据
			$.post(
				"/user/queryUserCount.do",{"search_day":0},function(data){
					//今日注册会员数
					$("#todayUserCount").html(data.todayUserCount);
					//平台总注册会员数
					$("#userCount").html(data.userCount);
				}
			);
			//店铺数据
			$.post(
				"/store/queryStoreCount.do",{"search_day":0},function(data){
					//今日入驻店铺数
					$("#todayStoreCount").html(data.newStoreCount);
					$("#storeCount").html(data.totalStoreCount);
					//待审核/店铺总数
					var str = '<a href="/store/selectStoreList.do?status=0" title="待审核店铺" style="color:#fa841e; text-decoration:none">'+data.waitAuditingCount+'</a>&nbsp;/&nbsp;'+data.totalStoreCount;
					$("#waitAuditingCount").html(str);
				}
			);
			//积分数据
			$.post(
				"/integral/queryIntegralSum.do",{"search_day":0},function(data){
					//今日可用积分、待用积分、红积分、多功能积分收支统计
					$("#todayUsableIncome").html(data.todayUsableIncome);
					$("#todayUsableOutcome").html(data.todayUsableOutcome);
					$("#todayFreezeIncome").html(data.todayFreezeIncome);
					$("#todayFreezeOutcome").html(data.todayFreezeOutcome);
					$("#todayRedIncome").html(data.todayRedIncome);
					$("#todayRedOutcome").html(data.todayRedOutcome);
					$("#todayMulIncome").html(data.todayMulIncome);
					$("#todayMulOutcome").html(data.todayMulOutcome);
					//平台可用积分、待用积分、红积分、多功能积分总收支统计
					$("#usableIncome").html(data.usableIncome);
					$("#usableOutcome").html(data.usableOutcome);
					$("#freezeIncome").html(data.freezeIncome);
					$("#freezeOutcome").html(data.freezeOutcome);
					$("#redIncome").html(data.redIncome);
					$("#redOutcome").html(data.redOutcome);
					$("#mulIncome").html(data.mulIncome);
					$("#mulOutcome").html(data.mulOutcome);
				}
			);
		}); */
	</script>
</body>
</html>
</body>
</html>