<%@ page language="java"
	import="java.util.*"
	pageEncoding="UTF-8"%>
	
	<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
<style type="text/css">
body { margin:0px; background:#d21838; font-size:12px; }
div { margin:0px; padding:0px; }
.system_logo { width:160px; height:60px; float:left; text-align:left; margin-top:5px; margin-left:5px; background:url(/images/logo.png);}
#tabs {
  float:left;
  /*width:auto;*/
  width:1000px;
  line-height:normal;
  }
#tabs ul {
  margin:0;
  padding:39px 10px 0 0px !important;
  *padding:40px 10px 0 0px !important;
  padding:40px 10px 0 0px;
  list-style:none;
  }
#tabs li {
  display:inline;
  margin:0;
  padding:0;
  }
#tabs a {
  float:left;
  background:url("/images/tableft6.gif") no-repeat left top;
  margin:0;
  padding:0 0 0 4px;
  text-decoration:none;
  font-family:"Microsoft YaHei",微软雅黑;
  }
#tabs a span {
  float:left;
  display:block;
  background:url("/images/tabright6.gif") no-repeat right top;
  padding:8px 20px;
  margin-right:4px;
  color:#E9F4FF;
  font-size: 15px;
  }
/* Commented Backslash Hack hides rule from IE5-Mac \*/
#tabs a span {float:none;}
/* End IE5-Mac hack */
#tabs a:hover span {
  color:#fffdfd;
  }
#tabs a:hover,#tabs a.cur {
  background-position:0% -42px;
  }
#tabs a:hover span ,#tabs a.cur span{
  background-position:100% -42px;
  color:#222;
  }
</style>

<script type="text/javascript">
function switchSysBar(){
     if (1 == window.status){
		  window.status = 0;
          switchPoint.innerHTML = '<img src="/images/left.gif">';
          document.all("frmTitle").style.display="none"
     }
     else{
		  window.status = 1;
          switchPoint.innerHTML = '<img src="/images/right.gif">';
          document.all("frmTitle").style.display=""
     }
}
//导航栏 --添加样式
$(function(){
	$('#menu a').click( function(){
		$(this).addClass('cur').parent().siblings().children().removeClass('cur');
	})
})

</script>
</head>
<body>
<div class="menu">
	<div class="system_logo"></div>
	<div id="tabs">
		<ul id="menu">
		<%List topMenuList = (List)session.getAttribute("topMenuList"); 
		System.out.println("size="+topMenuList.size());
			if(topMenuList!=null && topMenuList.size()>0){
				for(int i=0;i<topMenuList.size();i++){
				Map topMap = (Map)topMenuList.get(i);
		%>
		<li><a href="javascript:void(0);" onclick="parent.frmleft.showChildMenu('<%=topMap.get("menu_id") %>');" target="frmright"><span><%=topMap.get("menu_name") %></span></a></li>
		<%}} %>
			<%--<li><a href="javascript:void(0);" onclick="parent.frmleft.disp(2);" target="frmright"><span>案例管理</span></a></li>
			<li><a href="javascript:void(0);" onclick="parent.frmleft.disp(3);" target="frmright"><span>订单管理</span></a></li>
			<li><a href="javascript:void(0);" onclick="parent.frmleft.disp(4);" target="frmright"><span>市场管理</span></a></li>
			<li><a href="javascript:void(0);" onclick="parent.frmleft.disp(1);" target="frmright"><span>会员管理</span></a></li>
			<li><a href="javascript:void(0);" onclick="parent.frmleft.disp(5);" target="frmright"><span>财务管理</span></a></li>
			<li><a href="javascript:void(0);" onclick="parent.frmleft.disp(0);" target="frmright"><span>系统管理</span></a>--%></li>
		</ul>

	</div>
</div>
<script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
</body>
</html>