function checkInfo(){
	var login_name = $('#login_name').val();
	var password = $('#password').val();
	var rePassword = $('#rePassword').val();
	var company = $('#company').val();
	var contact = $('#contact').val();
	var phone = $('#fixed_phone').val();
	var cert_code = $('#cert_code').val();
	var qq = $('#qq').val();
	var email = $('#email').val();
	//员工编号
	var worker_code = $("#worker_code").val();
	var reg = new RegExp("^[0-9]*$");
	//验证手机号
	var regTelePhone = /^1[34578]\d{9}$/;
	//验证邮箱
	var regEmail = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
	//验证座机
	var regPhone = /^0\d{2,3}-\d{5,9}|0\d{7,12}$"/;
	//验证qq
	var regQQ = /^[1-9][0-9]{4,10}$"/;
	//验证身份证
	var regCertCode = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
	$("#login_nameMsg").html("");
	$("#passwordMsg").html("");
	$("#rePasswordMsg").html("");
	$("#companyMsg").html("");
	$('#contactMsg').html("");
	$("#worker_codeMsg").html("");
	
	var flag = false;
	if(worker_code == "" || worker_code == null){
		$("#worker_codeMsg").html("<font color='red'>编号不能为空</font>");
		return;
	}
	if(login_name == ""){
		$("#login_nameMsg").html("<font color='red'>登录名不能为空</font>");
		document.getElementById('login_name').focus();return;
	}else{
		$("#login_nameMsg").html("");
	}
	if(password == ""){
		$("#passwordMsg").html("登录密码不能为空");
		document.getElementById('password').focus();return;
	}else{
		$("#passwordMsg").html("");
	}
	if(company == ""){
		$("#companyMsg").html("请输入所属公司名称");
		document.getElementById('company').focus();return;
	}else{
		$("#companyMsg").html("");
	}
	
	if(contact == ""){
		$('#contactMsg').html("请输入手机号");
		document.getElementById("contact").focus();return;
	}else{
		$('#contactMsg').html("");
	}
	
	if(!regTelePhone.test(contact.trim())){
		$('#contactMsg').html("请输入正确的手机号");
		document.getElementById("contact").focus();return;
	}else{
		$('#contactMsg').html("");
	}
	if(phone!=null && phone != ""){
		if(!regPhone.test(phone.trim())){
			$("#phoneMsg").html("请输入正确的座机号,如：010-12345678");
			document.getElementById("fixed_phone").focus();return;
		}else{
			$("#phoneMsg").html("");
		}
	}
	if(cert_code!=null && cert_code!=""){
		if(!regCertCode.test(cert_code)){
			$("#cert_codeMsg").html("请输入正确的身份证号");
			document.getElementById("cert_code").focus();return;
		}else{
			$("#cert_codeMsg").html("");
		}
	}
//	if(qq!=null && qq!=""){
//		if(!regQQ.test(qq.trim())){
//			$("#qqMsg").html("请输入正确的QQ号");
//			document.getElementById("qq").focus();return;
//		}else{
//			$("#qqMsg").html("");
//		}
//	}
	if(email!=null && email!=""){
		if(!regEmail.test(email.trim())){
			$("#emailMsg").html("请输入正确的邮箱");
			document.getElementById("email").focus();return;
		}else{
			$("#emailMsg").html("");
		}
	}
	
	var is_checked = $("input[type='checkbox']").is(':checked');
	if(!is_checked){
		$("#checkIdMsg").html("请分配用户角色");
		return;
	}else{
		$("#checkIdMsg").html("");
	}
	if(!flag){
		$("#updateWorkerForm").submit();
		//var pram=$('#updateWorkerForm').serialize();
//		$.ajax({
//	        url: "/worker/updateWorkerInfo.do",
//	        type: "POST",
//	        dataType: "json",
//	        data:pram,
//	        async: false,
//	        success: function(data) {
//	          //console.log(data);
//			if(data=="ok")
//			{
//				window.opener.location.reload();
//				window.close();
//			}else{
//				alert("修改失败");
//			}
//	        },
//	        error: function() {
//	          alert("error");
//	        }
//	      });
	}
}

//离焦事件查询用户登录名
function checkLoginname(obj){
	var login_name = obj.value;
	if(login_name==''){
		$("#login_nameMsg").html("<font color='red'>登录名不能为空</font>");
		return;
	}
	$.post(
		"/worker/checkLoginName.do",{"login_name":login_name},function(data){
			if(data=='ok'){
				$("#login_nameMsg").html("<font color='green'>登录名可用</font>");
			}else{
				$("#login_nameMsg").html("<font color='red'>登录名已存在</font>");
				return;
			}
		}
	);
}

//离焦事件查询用户编码
function checkWorkerCode(obj){
	var worker_code = obj.value;
	if(worker_code==''){
		$("#worker_codeMsg").html("<font color='red'>编号不能为空</font>");
		return;
	}
	$.post(
		"/worker/checkWorker.do",{"worker_code":worker_code},function(data){
			if(data=='ok'){
				$("#worker_codeMsg").html("<font color='green'>用户编号可用</font>");
			}else{
				$("#worker_codeMsg").html("<font color='red'>用户编号已存在</font>");
				return;
			}
		}
	);
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

function back() {
	location.href="/worker/selectWorkerInfoList.do";
	window.close();
}