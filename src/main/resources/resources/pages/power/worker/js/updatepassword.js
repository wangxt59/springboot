
$(document).ready(
		function()
		{
			var message = $("#message").val()
			if(message == "true")
			{
			}
		}
		)

function resetInfo(){
	document.forms[0].reset();
	
	var password = document.getElementById("password");
	resetBySuffix(password);
	var rePassword = document.getElementById("rePassword");
	resetBySuffix(rePassword);
	
	document.getElementById("doSubmit").disabled = false;
}
//	动态拼接警示语
function resetBySuffix(obj){
	if(obj != null){
		var tempId = obj.id;
		tempId += "Msg";
		document.getElementById(tempId).innerHTML = "";
	}else{
		return;
	}
}

function textpassword()
{
	var oldpassword = $("#oldpassword").val();

	 $.ajax({
         type: "POST",
         dataType: "json",
         url:"/workermanage/queryUserInfo.do?oldpassword=" +oldpassword,
         success: function(data)
         {
            if(!data.success)
            {
            	$("#oldpasswordMsg").html("原始登录密码错误，请重新填写");
            	document.getElementById('oldpassword').focus();return;
            }
            if(data.success)
            {
               	$("#oldpasswordMsg").html("");
            }
        
         }
	 });


}
function checkInfo(){
	var password = $('#password').val();
	var rePassword = $('#rePassword').val();
	var oldpassword = $("#oldpassword").val();

	var reg = new RegExp("^[0-9]*$");
	$("#passwordMsg").html("");
	$("#rePasswordMsg").html("");

	if(oldpassword == ""){
		$("#oldpasswordMsg").html("原始密码不能为空");
		document.getElementById('passwordMsg').focus();return;
	}
	
	if(password == ""){
		$("#passwordMsg").html("登录密码不能为空");
		document.getElementById('password').focus();return;
	}
	if(password.length > 32){
		$("#passwordMsg").html("登录密码必须为1~32个字符");
		document.getElementById('password').focus();return;
	}
	if(rePassword == ""){
		$("#rePasswordMsg").html("请再次输入登录密码");
		document.getElementById('rePassword').focus();return;
	}
	if(rePassword.length > 32){
		$("#rePasswordMsg").html("登录密码必须为1~32个字符");
		document.getElementById('rePassword').focus();return;
	}
	if(password != rePassword){
		$("#passwordMsg").html("两次密码不一致，请重新输入");
		$('#rePassword').val("");$('#password').val("");
		document.getElementById('password').focus();
		return false;
	}
	
	if( password == oldpassword){
		$("#passwordMsg").html("新密码与原密码一致，请重新填写");
    	document.getElementById('newpassword').focus();
    	return false;
	}
	
	var flag =  checkPasswords(password,rePassword,oldpassword);
	
	if(flag){
		$.ajax({
			type: "POST",
			dataType: "json",
			url:"/workermanage/queryUserInfo.do?oldpassword=" +oldpassword,
			async: false,
			success: function(data)
			{
				var b = data.success;
				if(b){
					$("#oldpasswordMsg").html("");
					document.form1.submit();
				}
				
				if(!b)
				{
					$("#oldpasswordMsg").html("原始登录密码错误，请重新填写");
					document.getElementById('oldpassword').focus();
					return;
				}
				
			}
		});
	}
	
}
//其他选项校验数字
function validateNum(obj){
	var submit = document.getElementById("doSubmit");
	//定义正则表达式部分
	var reg = new RegExp("^[0-9]*$");  
	//动态获取警示语id
	var msg = obj.id;
	msg += "Msg";
	if(!reg.test(obj.value)){
		document.getElementById(msg).innerHTML = "请输入数字";
		obj.focus();
		submit.disabled = true;
	}else{
		document.getElementById(msg).innerHTML = "";
		submit.disabled = false;
	}
}

function checkPasswords(password,rePassword,oldpassword){
	
	
	if(oldpassword == ""){
		return false;
	}
	
	if(password == ""){
		return false;
	}
	if(password.length > 32){
		return false;
	}
	if(rePassword == ""){
		return false;
	}
	if(rePassword.length > 32){
		return false;
	}
	if(password != rePassword){
		return false;
	}
	
	if( password == oldpassword){
    	return false;
	}
	
	return true;
}
