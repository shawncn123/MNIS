  $(function () {
							var currYear = (new Date()).getFullYear();	
							var opt={};
							opt.date = {preset : 'date'};
							opt.datetime = {preset : 'datetime'};
							opt.time = {preset : 'time'};
							opt.default = {
								theme: 'android-ics light', //鐨偆鏍峰紡
						        display: 'modal', //鏄剧ず鏂瑰紡 
						        mode: 'scroller', //鏃ユ湡閫夋嫨妯″紡
								dateFormat: 'yyyy-mm-dd',
								lang: 'zh',
								showNow: true,
								nowText: "今天",
						        startYear: currYear - 10, //寮€濮嬪勾浠�
						        endYear: currYear + 10 //缁撴潫骞翠唤
							};
						  	$("#appDate").mobiscroll($.extend(opt['date'], opt['default']));
						  	var optDateTime = $.extend(opt['datetime'], opt['default']);
						  	var optTime = $.extend(opt['time'], opt['default']);
						    $("#appDateTime").mobiscroll(optDateTime).datetime(optDateTime);
						    $("#appTime").mobiscroll(optTime).time(optTime);
				        });
				        
$(function () {
							var currYear = (new Date()).getFullYear();	
							var opt={};
							opt.date = {preset : 'date'};
							opt.datetime = {preset : 'datetime'};
							opt.time = {preset : 'time'};
							opt.default = {
								theme: 'android-ics light', //鐨偆鏍峰紡
						        display: 'modal', //鏄剧ず鏂瑰紡 
						        mode: 'scroller', //鏃ユ湡閫夋嫨妯″紡
								dateFormat: 'yyyy-mm-dd',
								lang: 'zh',
								showNow: true,
								nowText: "今天",
						        startYear: currYear - 10, //寮€濮嬪勾浠�
						        endYear: currYear + 10 //缁撴潫骞翠唤
							};
						  	$("#appDate1").mobiscroll($.extend(opt['date'], opt['default']));
						  	var optDateTime = $.extend(opt['datetime'], opt['default']);
						  	var optTime = $.extend(opt['time'], opt['default']);
						    $("#appDateTime1").mobiscroll(optDateTime).datetime(optDateTime);
						    $("#appTime").mobiscroll(optTime).time(optTime);
				        });