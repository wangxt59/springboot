
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
	//var regQQ = /^[1-9]\d{4,10}$"/;
	var regQQ = /^[1-9][0-9]{4,9}$/;
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
	if(worker_code!=""){
		jQuery.ajax({
			url:"/worker/checkWorker.do",
			data:{"worker_code":worker_code},
			type:"post",
			async: false,
			success:function(data){
				if(data=="no"){
					$("#worker_codeMsg").html("<font color='red'>用户编号已经存在</font>");
					flag = true;
					return;
				}else{
					$("#worker_codeMsg").html("<font color='green'>用户编号可用</font>");
				}
			}
		});
	}
	if(login_name == ""){
		$("#login_nameMsg").html("<font color='red'>登录名不能为空</font>");
		document.getElementById('login_name').focus();return;
	}else{
		jQuery.ajax({
			url:"/worker/checkLoginName.do",
			data:{"login_name":login_name},
			type:"post",
			async: false,
			success:function(data){
				if(data=='ok'){
					$("#login_nameMsg").html("<font color='green'>登录名可用</font>");
				}else{
					$("#login_nameMsg").html("<font color='red'>登录名已存在</font>");
					flag = true;
					return;
				}
			}
		});
	}
	if(password == ""){
		$("#passwordMsg").html("登录密码不能为空");
		document.getElementById('password').focus();return;
	}else{
		$("#passwordMsg").html("");
	}
	if(rePassword == ""){
		$("#rePasswordMsg").html("请再次输入登录密码");
		document.getElementById('rePassword').focus();return;
	}else{
		$("#rePasswordMsg").html("");
	}
	if(password != rePassword){
		$("#passwordMsg").html("两次密码不一致，请重新输入");
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
	}
	if (contact != "") {
		$.ajax({
			url : "/worker/checkTelehphone.do",
			data : {
				contact : contact
			},
			type:"post",
			async: false,
			success : function(data) {
				if (data == "no") {
					$("#contactMsg").html("员工手机号已存在");//<spring:message code='language.remindContactExist'/>
					document.getElementById("contact").value="";
					flag = true;
					return;
				} else {
					$("#contactMsg").html("<font color='green'>员工手机号可以使用</font>");//<spring:message code='language.remindContactUse'/>
				}

			},
		});
	}
	//校验新增员工手机号是否重复 start 2018-4-11 16:45:32
	
	//校验新增员工手机号是否重复 end
	if(!regTelePhone.test(contact.trim())){
		$('#contactMsg').html("请输入正确的手机号");
		document.getElementById("contact").focus();return;
	}
//	else{
//		$('#contactMsg').html("");
//	}
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
	}//else{
//		$("#cert_codeMsg").html("请输入身份证号");
//	}
	
	if(qq!=null && qq!=""){
		if(!regQQ.test(qq)){
			//$("#qqMsg").html("");
			$("#qqMsg").html("请输入正确的QQ号");
			document.getElementById("qq").focus();return;
		}else {
			$("#qqMsg").html("");
		}
	}//else{
//		$("#qqMsg").html("请输入QQ号");
//		document.getElementById('qq').focus();return;
//	}
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
	}//else{
//		$("#emailMsg").html("请输入邮箱");
//		document.getElementById('email').focus();return;
//	}
	
	var is_checked = $("input[type='checkbox']").is(':checked');
	if(!is_checked){
		$("#checkIdMsg").html("请分配用户角色");
		return;
	}else{
		$("#checkIdMsg").html("");
	}
	
	if(!flag){
		//$("#addWorkerForm").submit();
		document.addWorkerForm.submit();
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

function loadUserCode(){
	var user_code = GetUserNum();
	 $.post(
				"/worker/checkWorker.do",{"worker_code":user_code},function(data){
					if(data=='ok'){
						//可用
						 $(".reg-change").append(user_code);
						 document.getElementById("worker_code").value=user_code;
					}else{
						//不可用
						loadUserCode();
					}
				}
			);
}

function GetUserNum()
{   
	var num="A"; 
	for(var i=0;i<6;i++) 
	{ 
		num+=Math.floor(Math.random()*10); 
	} 
	return num;
} 