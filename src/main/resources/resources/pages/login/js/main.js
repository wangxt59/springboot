// 生成测试用随机数据，时间固定，值不固定
	function demo_test_data(len) {
		var i;
		var ret = [[], []];
		var start_time = 1427896721;
		for (i = 0; i < len; i++) {
			var tmp_time = start_time + 300*i;
			var rand = {};
			rand.get = function (begin, end){
				return Math.floor(Math.random()*(end-begin))+begin;
			}
			var v = rand.get(200,1000)
			ret[0].push(tmp_time)
			ret[1].push(v)
		}
		return ret;
	}

	function get_interval(len) {
		var itv = Math.floor(len / 9);
		if (itv < 1) {
			return 1;
		} else {
			return itv;
		}
	}

	function format_time(time) {
		var date = new Date(time * 1000);
		var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
		var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
		var hh = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
		var mm = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
		return date.getFullYear() + "-" + month + "-" + currentDate+" "+hh + ":" + mm;
	}

function getData(tradCountList,orderCopuntList,userCountList){
	//页面请求
	$('#container').highcharts({
		chart: {
			zoomType: 'xy'
		},
		title: {
			text: '交易流水（元）',
			style: {"font-size": "16px", "font-family": "微软雅黑",},
		},
		xAxis: {
            categories: [
                '1月',
                '2月',
                '3月',
                '4月',
                '5月',
                '6月',
                '7月',
                '8月',
                '9月',
                '10月',
                '11月',
                '12月'
            ]
        },
		yAxis: { // Primary yAxis
			labels: {
				format: '',
				style: { "color": "#646464", "font-size": "14px", "font-family": "微软雅黑",},
			},
			title: {
				text: '',
				style: { "color": "#646464", "font-size": "14px", "font-family": "微软雅黑",},
			}
		},
		tooltip: {
			shared: true
		},
		 plotOptions: {
			column: {
				pointPadding: 0,
				borderWidth: 0
			}
		},
		legend: {
			layout: 'horizontal',
			align: 'left',
			x: 1500,
			verticalAlign: 'top',
			y: 0,
			floating: true,
		},
		series: [{
			name: '交易流水',
			color: '#d21838',
			type: 'column',
			data: tradCountList,
		}]
	});
	
	//local访问地域
	//页面请求
	$('#containerright1').highcharts({
		chart: {
			zoomType: 'xy'
		},
		title: {
			text: '用户数量',
			style: { "font-size": "16px", "font-family": "微软雅黑",},
		},
		xAxis: {
            categories: [
                '1月',
                '2月',
                '3月',
                '4月',
                '5月',
                '6月',
                '7月',
                '8月',
                '9月',
                '10月',
                '11月',
                '12月'
            ]
        },
		yAxis: { // Primary yAxis
			labels: {
				format: '',
				style: { "color": "#646464", "font-size": "14px", "font-family": "微软雅黑",},
			},
			title: {
				text: '',
				style: { "color": "#646464", "font-size": "14px", "font-family": "微软雅黑",},
			}
		},
		tooltip: {
			shared: true
		},
		 plotOptions: {
			column: {
				pointPadding: 0,
				borderWidth: 0
			}
		},
		legend: {
			layout: 'horizontal',
			align: 'left',
			x: 1500,
			verticalAlign: 'top',
			y: 0,
			floating: true,
		},
		series: [{
			name: '注册用户',
			color: '#d21838',
			type: 'column',
			data: userCountList,
		}]
	});
	
	//页面请求
	$('#containerright2').highcharts({
		chart: {
			zoomType: 'xy'
		},
		title: {
			text: '订单数量',
			style: {"font-size": "16px", "font-family": "微软雅黑",},
		},
		xAxis: {
            categories: [
                '1月',
                '2月',
                '3月',
                '4月',
                '5月',
                '6月',
                '7月',
                '8月',
                '9月',
                '10月',
                '11月',
                '12月'
            ]
        },
		yAxis: { // Primary yAxis
			labels: {
				format: '',
				style: { "color": "#646464", "font-size": "14px", "font-family": "微软雅黑",},
			},
			title: {
				text: '',
				style: { "color": "#646464", "font-size": "14px", "font-family": "微软雅黑",},
			}
		},
		tooltip: {
			shared: true
		},
		 plotOptions: {
			column: {
				pointPadding: 0,
				borderWidth: 0
			}
		},
		legend: {
			layout: 'horizontal',
			align: 'left',
			x: 1500,
			verticalAlign: 'top',
			y: 0,
			floating: true,
		},
		series: [{
			name: '订单量',
			color: '#d21838',
			type: 'column',
			data: orderCopuntList,
		}]
	});
	
}













