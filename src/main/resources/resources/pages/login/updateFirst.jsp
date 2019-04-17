<%@ page language="java"
	import="java.util.*"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" rev="stylesheet"
			href="/style/admin/globaladmin.css" media="all" />
		<title>用户分配</title>
	</head>
	<body>
		<div class="umtag">
			<h2>
				<font color="red">由于您第一次使用该系统，请修改您的使用密码</font>
			</h2>
		</div>
		<div class="tab-c">
			<div class="tab-in">
			<form action="/musermanage/updatefirst.do" name="form1" method="post">
				<table cellspacing="0" cellpadding="0" style="width: 60%">
					<tr>
						<td class="tright">
						</td>
						<td>
					
							</td>
					</tr>
					<tr>
						<td class="tright">
							员工权限：
						</td>
						<td>
						</td>
					</tr>
					<tr>
						<td class="tright">
							用户名：
						</td>
						<td>
						</td>
					</tr>
					<tr>
						<td  class="tright">
							原密码：
						</td>
						<td>
								<input type="password" id="oldpassword" name="oldpassword" value="" />
						</td>
					</tr>
					<tr>
						<td class="tright">
							新密码：
						</td>
						<td>
							<input type="password" id="password" name="password" />
						</td>
					</tr>
					<tr>
						<td class="tright">
							确认密码：
						</td>
						<td>
							<input type="password" id="password2" name="password2" />
						</td>
					</tr>
					<tr>
						<td colspan="4" class="tcenter">
							<input type="submit" value="提 交" class="btn"  onclick="return checkinfo();"/>
							<input type="reset" value="重 置" class="btn" />
							<input type="button" value="返 回" class="btn"
								onclick="javascript:history.go(-1);" />
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<script type="text/javascript">
	function checkinfo(){
	var oldpassword = document.getElementById("oldpassword").value;
	var password = document.getElementById("password").value;
	var password2 = document.getElementById("password2").value;
	
	if(oldpassword==""||oldpassword==null){
		alert("原密码不能为空！");
		return false;
	}else if(password==""||password==null){
		alert("新密码不能为空！");
		return false;
	}else if(password2==""||password2==null){
		alert("确认密码不能为空！");
		return false;
	}else if(password!=password2){
		alert("新密码和确认密码不一致！");
		return false;
	}else{
		if(confirm("是否确认修改？")){
		alert("修改成功");
		return true; 
		}else{
		return false;
		}
	}
	}
   </script>
</body>
</html>
