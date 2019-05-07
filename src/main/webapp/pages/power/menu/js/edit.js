$(function(){
	var attrstr = $("#attrstr").val();
	var array = attrstr.split(",");
	for ( var int = 0; int < array.length; int++) {
		var array_element = array[int];
		$("input[name='attr_name'][value='"+array_element+"']").attr("checked", true);
	}
	var institution_idExample = $('#institution_idExample').val();
	if(institution_idExample == null || institution_idExample == ''){
		document.getElementById("categoryChecked").style.display="none";
	}
//	var parent_id = $('#parent_id').val();
//	var rank = $("#rank").val();
//	$("input[name='category.rank'][value='"+rank+"']").click();
//	if("2" == rank){
//		$("#typeGrand").val(parent_id);
//	}else if("3" == rank){
//		var firstCategoryId = $("#firstCategoryId").val();
//		$("#typeGrand").val(firstCategoryId);
//	}
});
var chengeRank=false;
function changeCategory(){
	chengeRank = true;
	document.getElementById("categoryChecked").style.display = "";
	document.getElementById("categoryExample").style.display = "none";
}

function resetInfo(){
	document.forms[0].reset();
	rehidden();initRadio();
	document.forms[0].reset();
	$('#batch_nameMsg').html("");
	$('#typeGrandMsg').html("");
	$('#typeParentMsg').html("");
	
	var institution_idExample = $('#institution_idExample').val();
	if(institution_idExample == null || institution_idExample == ''){
		document.getElementById("categoryChecked").style.display="none";
		document.getElementById("categoryExample").style.display="";
	}
	
//	operateAll(false);
}
//显示一级分类下拉框
function showFirstCheck(){
	rehidden();
	document.getElementById("firstCheck").style.display="";
	$("#typeGrand").val("");
}

//显示二级分类下拉框
function showSecondCheck(){
	rehidden();
	document.getElementById("firstCheck").style.display="";
	document.getElementById("secondCheck").style.display="";
	//重置二级分类下拉框
	$('#typeParent').empty();
	$("#typeParent").prepend("<option value='-1'>--请选择--</option>");
	$("#typeParent").val('-1');
	//重置一级分类下拉框
	$("#typeGrand").val("");
}

//单选框重置   
function initRadio(){  
	var obj = document.getElementsByName("batchInfo.level");  
		for (var i = 0; i < obj.length; i++){   
			obj[i].checked = false;  
		}  
		obj[0].checked = true; 
}  
//重新隐藏
function rehidden(){
	document.getElementById("firstCheck").style.display="none";
	document.getElementById("secondCheck").style.display="none";
}
// 一级业务类型级联事件
function getSecondType(){
	
	var grandid = $('#typeGrand').val();
	$('#typeParent').empty();
	$("#typeParent").prepend("<option value='-1'>--请选择--</option>");
	$("#typeParent").val('-1');
	$('#businessType').empty();
	$("#businessType")
			.prepend("<option value='-1'>--请选择--</option>");
	$("#businessType").val('-1');
	var url = "/menu/getChildMenu.do";
	var params = {
		"parentid" : grandid
	};
	var defaultText = "--请选择--";
	var target = "#typeParent";
	if (grandid != "") {
		addOptions(url, params, defaultText, target);
	} else {
		$(target).html("<option value='-1'>" + defaultText
				+ "</option>");
	}
}

			
// 级联添加业务类型select选项
var addOptions = function(url, params, defaultText, target) {
	$.getJSON(url, params, function(list) {
		var options = "";
		options = "<option value='-1'>" + defaultText + "</option>";
		if (list != "[]" && typeof list != "undefined") {
			for (var i = 0; i < list.length; i++) {
				options += "<option value='" + list[i].m_id + "'>"
						+ list[i].menu_name + "</option>";
			}
		}
		$(target).html(options);
	});
}

function checkInfo(){
	var menu_name = $('#menu_name').val();
	var typeGrand = $('#typeGrand').val();
	var typeParent = $('#typeParent').val();
	var menu_desciption = $('#menu_desciption').val();
//	var url = $('#url').val();
	var isSel=false;
	
	$('#menu_nameMsg').html("");
	$('#menu_desciptionMsg').html("");
	$('#typeParentMsg').html("");
	$('#urlMsg').html("");
//	$('#sort_orderMsg').html("");
	
	if(menu_name == null ||menu_name == ""|| menu_name.length > 8){
		$('#menu_nameMsg').html("请输入小于8个字的菜单名称");
		document.getElementById('menu_name').focus();
		return;
	}
	if(menu_desciption == null ||menu_desciption == ""|| menu_desciption.length > 50){
		$('#menu_desciptionMsg').html("请输入小于50个字的菜单说明");
		document.getElementById('menu_desciption').focus();
		return;
	}
	if(url == null ||url == ""){
		$('#urlMsg').html("请输入菜单URL");
		document.getElementById('url').focus();
		return;
	}
//	var Expression=/http(s)?:\/\/([\w-]+\.)+[\w-]+(\/[\w- .\/?%&=]*)?/;
//	var objExp=new RegExp(Expression);
//	if(objExp.test(url)==false){
//		$('#urlMsg').html("请输入正确URL");
//		document.getElementById('url').focus();
//		return;
//	}
	if(typeGrand != "" && typeGrand != "-1"){
		if(typeParent != "" && typeParent != "-1"){
			parent_id = typeParent;
		}else{
			parent_id = typeGrand;
		}
	}else{
		parent_id = "-1";
	}

	
	if(chengeRank){
		$('#parent_id').val(parent_id);//将parent_id置入后台
		$('#rank').val($("input:checked").val());//将rank置入后台
	}
	
	document.forms[0].submit();
}