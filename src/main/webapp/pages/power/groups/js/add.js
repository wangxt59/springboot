function resetInfo(){
	document.forms[0].reset();
	$("#groupsNameMsg").html("");
	$("#groupsDescMsg").html("");
}
function checkInfo(){
	var groups_name = $('#groups_name').val();
	var groups_desc = $('#groups_desc').val();
	$("#groupsNameMsg").html("");
	$("#groupsDescMsg").html("");
	
	if(groups_name == "" || groups_name.length > 15){
		$("#groupsNameMsg").html("请输入小于15字的权限组名称");
		document.getElementById('groups_name').focus();return;
	}
	if(groups_desc == "" || groups_desc.length > 50){
		$('#groupsDescMsg').html("请输入小于50字的权限组描述");
		document.getElementById("groups_desc").focus();return;
	}
	
	checked();
	
	document.form1.submit();
}
//判断name=menuList 被选中的复选框 
function checked () {
	obj = document.getElementsByName("menuList");
    check_val = [];
    check_name=[];
    for(k in obj){
        if(obj[k].checked)
            check_val.push(obj[k].value);
    }
    $("#list").val(check_val);
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


