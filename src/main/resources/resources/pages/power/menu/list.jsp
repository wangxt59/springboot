<%@ page language="java"
	import="java.util.*,com.antke.website.utils.CommonsUtil"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" rev="stylesheet" href="/css/globaladmin.css" media="all" />
<script language='javascript' src="/js/jquery-1.8.3.min.js"></script>
<link href="/treetable/css/jquery.treeTable.css" rel="stylesheet" type="text/css"/>
<script src="/treetable/javascripts/jquery.js" type="text/javascript"></script>
<script src="/treetable/javascripts/jquery.treeTable.js" type="text/javascript"></script>
<link href="/css/layer.css" rel="stylesheet">
<link href="/css/popup.css" rel="stylesheet">
 <script type="text/javascript"><!--

 function filltr(apendtotable,ddataitem){
     if(ddataitem.parent==null){
    	  var str = "<tr id='node-"+ddataitem.id+"'><td>"+ddataitem.name+"<主菜单></td><td>";
    	  str = str+ "<a href='/menu/queryMenu.do?menu.m_id="+ddataitem.id+"'>编辑</a>&nbsp;&nbsp;";
          str = str+ "<a href='#' onclick=\"deleteStatus("+"'"+ddataitem.id+"'"+")\">删除</a>";
         $("tbody",apendtotable).append(str+"</td></tr>");
     }else{
    	 var rank =ddataitem.rank ;
    	 
         var str = "<tr id='node-"+ddataitem.id+"'";
         str = str+" class='child-of-node-"+ddataitem.parent+"' ";
         if(rank==2){
        	 str = str+ " ><td>"+ddataitem.name+"<二级菜单></td><td>";
         }else if(rank==3){
        	 str = str+ " ><td>"+ddataitem.name+"</td><td>";
          }
         str = str+ "<a href='/menu/queryMenu.do?menu.m_id="+ddataitem.id+"'>编辑</a>&nbsp;&nbsp;";
         str = str+ "<a href='#' onclick=\"deleteStatus("+"'"+ddataitem.id+"'"+")\">删除</a>";
    	 $("#node-"+ddataitem.parent,apendtotable).after(str+"</td></tr>");
     }
 }
 function getData(){
	//用于构建动态表格的数据集
	 var datastore=eval('${menuInfo }');
	 for(var i=0;i<datastore.length;i++){
		 	filltr($("#tree_table2"),datastore[i]);
	}
	 $("#tree_table2").treeTable({expandable:true,clickableNodeNames:true,childPrefix:'child-of-',treeColumn:0});//treeColumn：0表示表格第二列显示树形结构。但是会影响此表单之后的树形表单显示

	 
	  

 }

 //function updateStatus(m_id){
	//	if(confirm( "确认删除该菜单吗？ ")){
		//	location.href="/menu/updateMenuStatus.do?menu.m_id=" + m_id+"&menu.status=0";
		//}
		
//}
function deleteStatus(m_id){
	$(".popup").show();
	$(".addhousepp").show();
	//$("#deleteBut").attr("onclick","updateStatus('"+m_id+"')");
	$('#deleteBut').bind("click", function(){
		$(".popup").hide();
		$(".addhousepp").hide();
		location.href="/menu/updateMenuStatus.do?menu.m_id=" + m_id+"&menu.status=0";
	});
}
function cancel(){
	$(".popup").hide();
	$(".addhousepp").hide();
}
 </script>

<title>系统管理</title>
	</head>
	<body onload="getData();">
	<div class="umtag">当前位置：系统管理 >> 菜单管理 >> 菜单列表</div>
	   <div class="tab-c">
	   <div class="tab-in">
	  <form action="/menu/selectMenuList.do" name="form1" method="post">
	  <div class="tab-c">
		<table cellspacing="0" cellpadding="0"  >
			<tr>
				<td class="tcenter" style="width: 50%">
					菜单名称：<input type="text" id="menu_name" name="menu.menu_name" value="${menu.menu_name}"/>
				</td>
				<td class="tleft">
        			<input name="button" type="submit" class="btn" value=" 查 询 " />
        			<input name="button" type="button" class="btn" value="新增菜单" onclick="location.href='/menu/insertMenuPage.do'"/>
        		</td>
			</tr>
		</table>
		</div>
<div class="tab-c">
  <div class="tabs">
	<table id="tree_table2" width="300px">
	<thead><tr><th style="width: 40%;">名称</th><th width="50px">操作</th></tr></thead>
		<tbody>
		</tbody>
	</table>
	
   </div>
   </div>
   </form>
   </div>
   </div>
    <div class="popup"></div>
		<div class="addhousepp" style="height: 150px; width: 350px; top: -143px;">
			<div class="pptitle" style="color: black">
				提醒
				<a class="ppclose" style="color: gray;font-size: 5px" onclick="cancel()">关闭</a>
			</div>
			<div class="ppcontent">
					<p id="" style="text-align: center;">确定要删除菜单么</p>
				<div class="btn-group">
					<input type="button" class="btn btn-primary" id="deleteBut" value="确定" />
					<input type="button" onclick="cancel()" class="btn btn-primary" id="cancel" value="取消"/>
				</div>
			</div>
		</div>
</body>
</html>
