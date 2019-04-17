<%@ page language="java"
	import="java.util.*"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<TITLE>myspace</TITLE>
<script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
<style type="text/css">
body { margin:0px; background:transparent; overflow:hidden;}
.left_color { text-align:right; }
.left_color a {font-family:"Microsoft YaHei",微软雅黑;text-decoration: none; border-bottom:1px solid #ebedef; border-left:3px solid #fff; font-size:14px; display:block !important; display:inline; width:150px !important; text-align:center;height:40px; line-height:40px;}
.left_color a:hover,
.left_color a.cur{ background:#f3f3f3;color:#d21838; border-left-color:#d21838;}
img { float:none; vertical-align:middle;}
hr { width:100%; text-align:left; size:0; height:0px; border-top:1px solid #d21838;}
</style>
<script type="text/javascript">
function showChildMenu(n){
		$("#div0>div").hide();
		document.getElementById("left"+n).style.display="";
	}
	$(function(){
	$('.left_color a').click( function(){
		$(this).addClass('cur').siblings().removeClass('cur');
	})
})
</script>
</head>
<BODY>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td valign="top" class="left_color" id="menubar">
	   	<div id="div0">
	   	<% List childMenuList = (List)session.getAttribute("childMenuList"); 
			if(childMenuList!=null && childMenuList.size()>0){
				String temp_id="";
				for(int i=0;i<childMenuList.size();i++){
				Map childMap = (Map)childMenuList.get(i);
				String tm_id = (String)childMap.get("tm_id");
				if(i==0){
					temp_id = tm_id;
					%>		
				<div id="left<%=temp_id%>" style="display:''"> 
				<a href="<%=childMap.get("url") %>" target="frmright" alt=""><%=childMap.get("menu_name") %></a>
				<%}else{
					if(temp_id==tm_id){	 %>
					<a href="<%=childMap.get("url") %>" target="frmright" alt=""><%=childMap.get("menu_name") %></a>
					<%}else{
						temp_id = tm_id;
					%>
					</div>
					<div id="left<%=temp_id%>" style="display:none"> 
					<a href="<%=childMap.get("url") %>" target="frmright" alt=""><%=childMap.get("menu_name") %></a>
					<%}	%>
			<%} %>	
		<%}} %>
		</div>
	</td>
 </tr>
</table>
</body>
</html>