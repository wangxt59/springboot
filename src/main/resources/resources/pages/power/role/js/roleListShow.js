$(function() {
			initScreen('00020101');
		})

function init() {

}
// 查询按钮
function searchRoleList(){
		var sett = new $.Settings();
		sett.finish = function(cmd, error) {
			if (!error) {
				if ($('#tr_num').length == 0) {
					$('#null_message').show();
					$('#page').hide();
					$('#showlist').hide();
				} else {
					$('#null_message').hide();
					$('#page').show();
					$('#showlist').show();
				}
			}
		}
		$('#showlist').paging('1', sett);

}
// 自动提示查询
function autoPoint() {
	var settings = new $.Settings();
	settings.item = function(row, i, max) {
		return row.ROLE_NAME;
	};
	settings.result = function(row) {
		return row.ROLE_NAME;
	};
	$('#queryKey').auto('2', '00020101', settings);
}

// 删除按钮
function toDel(f_name) {
	$.loadingOn();
	var settings13 = new $.Settings();
	settings13.finish = function() {
		$.loadingOff();
		$('#showlist').paging('1');
	};
	$.del(4, f_name, settings13);
	$.loadingOff();
}

// 修改按钮
function toModify(f_id) {
	$('#value').val(f_id);
    var param =  f_id;
    var settings = new $.Settings();
    settings.data = param;
    $.sync('5',settings);
}
