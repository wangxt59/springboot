function addRight() {
	var sel_source = document.getElementById("multiSelectListbox1");
	var sel_dest = document.getElementById("multiSelectListbox2");
	if (sel_source.options.length == 0)
		return;
	for (var i = 0; i < sel_source.options.length; i++) {
		if (sel_source.options[i].selected) {
			var e = sel_source.options[i];
			var SelectedText = e.text;
			var SelectedValue = e.value;
			sel_dest.options.add(new Option(SelectedText, SelectedValue));
			sel_source.remove(i);
			i--;
		}
	}
	return false;
}

function addLeft() {
	var sel_source = document.getElementById("multiSelectListbox2");
	var sel_dest = document.getElementById("multiSelectListbox1");
	if (sel_source.options.length == 0)
		return;
	for (var i = 0; i < sel_source.options.length; i++) {
		if (sel_source.options[i].selected) {
			var e = sel_source.options[i];
			var SelectedText = e.text;
			var SelectedValue = e.value;
			sel_dest.options.add(new Option(SelectedText, SelectedValue));
			sel_source.remove(i);
			i--;
		}
	}
	return false;
}


Array.prototype.in_array = function(e) {
	for (i = 0; i < this.length; i++) {
		if (this[i] == e)
			return true;
	}
	return false;
}

function submitFun(){
	var role_name = $("#role_name").val();
	var discribe = $("#discribe").val();
	if(role_name==null || role_name == ''){
		$("#role_nameMsg").html("角色名称不能为空！");
		return;
	}else{
		$("#role_nameMsg").html("");
	}
	if(discribe==null || discribe == ''){
		$("#discribeMsg").html("角色说明不能为空！");
		return;
	}else{
		$("#discribeMsg").html("");
	}
	$('#selectedPgroup').val('');
	var sel_source = document.getElementById("multiSelectListbox2");
	if (sel_source.options.length > 0) {
		var temp = '';
		for (var i = 0; i < sel_source.options.length; i++) {
			var e = sel_source.options[i];
			temp += e.value + '#';
		}
		$('#selectedPgroup').val(temp.substring(0, temp.length - 1));
	}
	document.form1.submit();
}

function returnWelcome(){
	$.loadingOn();
	var flag = window.confirm("您确定要放弃么？");
	if (flag) {
		window.parent.backMenu();
	}
	$.loadingOff();
}


function submitAddFun(){
	var role_name = $("#role_name").val();
	var discribe = $("#discribe").val();
	if(role_name==null || role_name == ''){
		$("#role_nameMsg").html("角色名称不能为空！");
		return;
	}else{
		$("#role_nameMsg").html("");
	}
	if(discribe==null || discribe == ''){
		$("#discribeMsg").html("角色说明不能为空！");
		return;
	}else{
		$("#discribeMsg").html("");
	}
	$('#selectedPgroup').val('');
	var sel_source = document.getElementById("multiSelectListbox2");
	if (sel_source.options.length > 0) {
		var temp = '';
		for (var i = 0; i < sel_source.options.length; i++) {
			var e = sel_source.options[i];
			temp += e.value + '#';
		}
		$('#selectedPgroup').val(temp.substring(0, temp.length - 1));
	}
	document.form1.submit();
}

