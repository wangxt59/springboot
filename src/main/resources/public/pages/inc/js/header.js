	//帮助系统调用
	function web_address() {
		var ne_add = parent.document.getElementById('main-frame');
		var ne_list = ne_add.contentWindow.document.getElementById('search_id').innerHTML;
		ne_list.replace('-', '');
		var arr = ne_list.split('-');
		window.open('help.php?al='+arr[arr.length - 1],'_blank');
	}
	//授权检测回调处理
	function start_sendmail_Response(result) {
		// 运行正常
		if (result.error == 0) {
		    var str = '';
			if (result['content']['auth_str'])
			{
				str = '<a href="javascript:void(0);" target="_blank">' + result['content']['auth_str'];
				if (result['content']['auth_type'])
				{
					str += '[' + result['content']['auth_type'] + ']';
				}
				str += '</a> ';
			}
			document.getElementById('license-div').innerHTML = str;
		}
	}
	function modalDialog(url, name, width, height) {
		if (width == undefined) {
			width = 400;
		}
		if (height == undefined) {
			height = 300;
		}
		if (window.showModalDialog) {
			window.showModalDialog(url, name, 'dialogWidth=' + (width) + 'px; dialogHeight=' + (height + 5) + 'px; status=off');
		} else {
			x = (window.screen.width - width) / 2;
			y = (window.screen.height - height) / 2;

			window.open(url, name, 'height=' + height + ', width=' + width + ', left=' + x + ', top=' + y + ', toolbar=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, modal=yes');
		}
	}
	var adminId = "";
	function ShowToDoList()
	{
		try {
			var mainFrame = window.top.frames['main_frame'];
			mainFrame.window.showTodoList(adminId);
		}
		catch(ex) {

		}
	}
	
	var isOut =true;
	$(document).ready(function(){
		var time = null;
		$(".menu-button").hover(function(){
			clearTimeout(time);
			k = $(this).attr("key");
			$(this).addClass("on").siblings().removeClass("on");
			time = setTimeout(function(){
				$(".dropdown").show();
				$("#" + k).siblings().hide();
				$("#" + k).show();
				$(".main").addClass("fuzzy");
			},300);
		});
		$(".menu-button-wu").hover(function(){
			clearTimeout(time);
			$(this).addClass("on").siblings().removeClass("on");
			time = setTimeout(function(){
				$(".dropdown").hide();
			},300);
		});
		$(".submenu").mouseleave(function(){
			clearTimeout(time);
			$(".dropdown").hide();
			$(".menu-button").removeClass("on");
			$(".menu-button-wu").removeClass("on");
			$(".main").removeClass("fuzzy");
		});
		$(".individual-list").hover(function(){
			isOut = false;
		},function(){
			isOut = true;
		});
		$(document).click(function(){
			if(isOut == true){
				$(".individual-menu").hide();
			}else{
				$(".individual-menu").toggle();
			}
		});
	});
