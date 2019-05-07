<%@ page language="java"
	import="java.util.*"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理系统</title>
	<link href="/pages/login/css/index.css" rel="stylesheet" type="text/css" />
	<link href="/pages/login/css/base.css" rel="stylesheet" type="text/css" />
	<script language='javascript' src="/pages/login/js/main.js"></script>
	<script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="/js/highcharts.js"></script>
<style>
body {font-family:"Microsoft YaHei",微软雅黑;font-size:16px; }
</style>
</head>

<body onload="getData(${map.tradCountList},${map.orderCopuntList} ,${map.userCountList});">


<div class="indexBox clearfix">
  <ul class="aUl1">
    <li class="aLi1">
    </li>
    <li class="aLi2">
      <span class="li-span">${map.userNo }</span>
      <span>用户总数</span>
    </li>
  </ul><!-- ul-1 -->
  <ul class="aUl2">
    <li class="aLi1">
    </li>
    <li class="aLi2">
      <span class="li-span">${map.orderNo }</span>
      <span>订单总数</span>
    </li>
  </ul><!-- ul-2 -->
  <ul class="aUl3">
    <li class="aLi1">
    </li>
    <li class="aLi2">
      <span class="li-span">${map.storeCount }</span>
      <span>商家总数</span>
    </li>
  </ul><!-- ul-3 -->
  <ul class="aUl4">
    <li class="aLi1">
    </li>
    <li class="aLi2">
      <span class="li-span">${map.tradingNo }</span>
      <span>交易总额</span>
    </li>
  </ul><!-- ul-3 -->
</div><!--indexBox-->

<div class="chartWrap clearfix">
	<div class="chartLeft">
		<div id="container"></div>
    </div><!-- 左侧 -->
    <div class="chartRight">
		<div class="chartRight-n1">
			 <div id="containerright1" style="width:100%; height:180px;"></div>
    	</div><!-- 右侧1 -->
        <div class="chartRight-n2">
			 <div id="containerright2" style="width:100%; height:180px;"></div>
    	</div><!-- 右侧2 -->
    </div><!-- 右侧 -->
    
</div><!-- lineChart 折线图图表1 -->

</body>
</html>
