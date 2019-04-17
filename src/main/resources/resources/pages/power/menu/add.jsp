<%@ page language="java"
	import="java.util.*,com.antke.power.model.bean.Menu,
com.antke.website.utils.CommonsUtil"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" rev="stylesheet"
			href="/css/globaladmin.css" media="all" />
 <title>系统管理</title>
 <script type="text/javascript">  </script>
		<script language='javascript' src="/js/jquery-1.7.1.js"></script>
		<script type="text/javascript" src="/js/ckeditor/ckeditor.js"></script>
		<script language='javascript' src="/website/power/menu/js/add.js"></script>
	</head>
	<body>
		<div class="umtag"> 
			当前位置：系统管理&gt;&gt; 菜单管理 &gt;&gt;新增菜单
		</div>
		<div class="tab-c">
		<div class="tab-in">
		<form action="/menu/insertMenu.do" name="form" method="post">
			<table cellspacing="0" cellpadding="0" class="tcenter">
			<tr>
					<td class="tright">
					<span>* </span>菜单名称：
					</td>
					<td class="tleft">
						<input type="text" id="menu_name" name="menu.menu_name" value="${menu.menu_name }"/>
						<span id="menu_nameMsg" style="color: red"></span>
					</td>
				</tr>
				<tr>
					<td class="tright">
					<span>* </span>菜单说明：
					</td>
					<td class="tleft">
						<textarea rows="5" cols="60" id="menu_desciption" name="menu.menu_desciption">${menu.menu_desciption }</textarea>
						<span id="menu_desciptionMsg" style="color: red"></span>
					</td>
				</tr>
				<tr>
					<td class="tright">
						状态：
					</td>
					<td class="tleft">
						<select id="status" name="powerGroup.status" style="margin-top: 10px;">
								<option value="1">有效</option>
								<option value="2">无效</option>
						</select>
						<span id="statusMsg" style="color: red"></span>
					</td>
				</tr>
				<tr>
					<td class="tright"  style="width: 40% ">
					<span>* </span>分类等级：
					</td>
					<td class="tleft">
						<input type="radio" name="rankCheck" value="1" onclick="javascript:rehidden();" checked="checked"/>一级分类
						<input type="radio" name="rankCheck" value="2" onclick="javascript:showFirstCheck();"/>二级分类
						<input type="radio" name="rankCheck" value="3" onclick="javascript:showSecondCheck();"/>三级分类
					</td>
				</tr>
				
		  		<tr id="firstCheck" style="display:none;" >
		  			<td class="tright">
					<span>* </span>一级分类：
					</td>
					<td class="tleft">
						<select id="typeGrand" name="typeGrand" style="margin-top: 10px;" onchange="getSecondType();">
							<option value="">--请选择--</option>
							<s:iterator value="menuList" status="item">
								<option value="${m_id}">
									${menu_name}
								</option>
							</s:iterator>
						</select>
						<span id="typeGrandMsg" style="color: red"></span>
					</td>
				</tr>
				
				<tr  id="secondCheck"  style="display:none;" >
					<td class="tright">
					<span>* </span>二级分类：
					</td>
					<td class="tleft">
						<select id="typeParent" name="typeParent" style="margin-top: 10px;" >
							<option value="">--请选择--</option>
						</select>
						<span id="typeParentMsg" style="color: red"></span>
					</td>
				</tr>
				
				<tr>
					<td class="tright">
					菜单URL：
					</td>
					<td class="tleft">
						<input type="text" id="url" name="menu.url" value="${menu.url }"/>
						<span id="urlMsg" style="color: red"></span>
					</td>
				</tr>
				
				
		  		<tr>
		  			<td class="tcenter" colspan="2">
						<input type="hidden" id="parent_id" value="" name="menu.parentid"/>
						<input type="hidden" id="rank" value="" name="menu.levels"/>
						<input type="button" value=" 提 交 " class="btn" 
						onclick="javascript:checkInfo();" />
						<input type="button" value=" 重 置 " class="btn" 
						onclick="javascript:resetInfo();" />
						<input type="button" value=" 返 回 " class="btn" 
						onclick="javascript:history.go(-1);" />
					</td>
		  		</tr>
			</table>
		</form>
		</div>
		</div>
	</body>
</html>

