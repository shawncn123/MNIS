$(function() {          //时间插件
	var currYear = (new Date()).getFullYear();
    var opt = {};
    opt.date = {preset : 'date'};
    opt.datetime = {preset : 'datetime'};
    opt.time = {preset: 'time'};
    opt.default = {
        theme: 'android-ics light',
        display: 'modal',
        lang: 'zh',
        dateFormat: 'yyyy-mm-dd',
        showNow: true,
        nowText: "今天",
        startYear: currYear - 50,
        endYear: currYear + 10,
        onShow: function () {
            $('.dw-persp').css('z-index', '99999');
        }
    };
    var optTime = $.extend(opt['date'], opt['default']);
//    $("#appTime1").mobiscroll(optTime).time(optTime);
    $("#yiZhuRq").mobiscroll(optTime);

    function current(){        //时间插件 获取当前日期
		var dt = new Date()
		var y = dt.getFullYear(); 
		var m = dt.getMonth()+1; 
		var d = dt.getDate();
		str=y+'-'+(m<10 ? "0"+ m : m)+'-'+(d<10 ? "0" + d : d);
		return str; 
    }
	setInterval(function(){
		$("#yiZhuRq").attr('value',current)
	});
    
});