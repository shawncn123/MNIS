$(function () {          //时间插件
    var opt = {};
    opt.time = {
        preset: 'time'
    };
    opt.default = {
        theme: 'android-ics light',
        display: 'modal',
        lang: 'zh',
        showNow: true,
        nowText: "今天",
        onShow: function () {
            $('.dw-persp').css('z-index', '99999');
        }
    };
    var optTime = $.extend(opt['time'], opt['default']);
    $("#appTime1").mobiscroll(optTime).time(optTime);
    $("#appTime2").mobiscroll(optTime).time(optTime);

    function current(){        //获取当前时间  -  4-29小宋增加
		var d=new Date(),str='';
		str +=d.getHours()+':';
		str +=d.getMinutes();
		return str; 
    }
	setInterval(function(){
		$(".demos input").attr('placeholder',current)
	});
    
    var height = $('#head_banner_1').height();   //模态框距离头部距离   
    $('#content').css('margin-top', height + 'px');
    $('#modal-wrap').css('margin-top', height + 'px');
    $('#temperature').on('shown.bs.modal', function () {
        $('.modal-backdrop').css('top', height + 'px')
    });

    var currObj;
    var isFirst, isLast = false;
    var isMainFirst, isMainLast = false;
    $('#jianpan').hide();
    $('#jianpan1').hide();

    //主页键盘
    $('#content input[mainpop]').focus(function () {
    	$(this).css('background-color', '#eee');
        currObj = $(this);
        $('#jianpan1').hide();
        $('#jianpan').show();
        var mainpop = $(this).attr("mainpop");
        if (mainpop) {
        	var h = $(".form-horizontal .form-group:eq(0)").height();
        	alert(h)
            var num = -((parseInt(mainpop) - 1) * h);
            if(mainpop == 2){            //低压input获取焦点时主页内容不上移  -  4-29小宋增加
                $("#content").css({
	                "position": "relative",
	                "top": 0
                });
            }else{
                $("#content").css("top", num);
            }
            isMainLast = mainpop == 6 ? true : false;
            isMainFirst = mainpop == 1 ? true : false;
        }
    });

    $('#temperature input[pop]').focus(function () {
        $(this).css('background-color', '#eee');   
        currObj = $(this);
        var popNum = $(this).attr("pop");
        if (popNum <= 2) {
            $('#jianpan').hide();
            $('#jianpan1').show();
        } else {
            $('#jianpan1').hide();
            $('#jianpan').show();
        }
        if (popNum) {
            var h = $(".form-horizontal .form-group:eq(0)").height();
            var num = -(popNum * h);
            $("#modal-wrap").css("top", num);
            isLast = popNum == 5 ? true : false;
            isFirst = popNum == 1 ? true : false;
        }
    });

    $('#temperature input[pop]').blur(function () {   //模态框失去焦点时去掉背景
        $(this).css('background-color', '#fff')
    });
    $('#content input[mainpop]').blur(function () {   //主页失去焦点时去掉背景
        $(this).css('background-color', '#fff')
    });
    
    $('.jianpan button').click(function () { //赋值
        var operation = $(this).attr("operation");
        var in_val = currObj.val();
        if (!operation) {
            var jp_val = $(this).val();
            currObj.val(in_val + jp_val);
        } else {
            switch (operation) {
                case "reduce": {   //删除input最后一个字符串
                    if (in_val.length > 0) {
                        var tempval = in_val.substring(0, (in_val.length - 1));
                        if (tempval.substring((tempval.length - 1), tempval.length) == ".") {
                            tempval = tempval.substring(0, (tempval.length - 1));
                        }
                        currObj.val(tempval);
                    }
                }
                    break;
                case "del": {    //清空input
                    currObj.val("");
                }
                    break;
                case "hide": {     //点击右下角箭头隐藏键盘
                    $('.jianpan').hide();
                    $("#modal-wrap").css("top", "0px");
                    $("#content").css("top", "0px");
                }
                    break;
            }
        }
    });

    $(".prev").click(function () {      //上一项
        if (currObj) {
            var mainpop = currObj.attr("mainpop");
            var temppop = currObj.attr("pop");

            //模态窗口
            if (temppop) {
                if (!isFirst) {
                    var $prev = currObj.parent().parent().prev().find("input");
                    if ($prev) {
                        var h = $(".form-horizontal .form-group:eq(0)").height();
                        var num = -(temppop * h);
                        $("#modal-wrap").css("top", num);
                        $($prev).focus();
                        currObj = $($prev);
                        if (temppop == 1) {
                            $("#modal-wrap").css("top", "0px");
                            isFirst = true;
                        }
                    }
                } else {
                    alert('已经是第一项');
                }
            }

            //主页处理
            if (mainpop) {
                if (!isMainFirst) {
                    var $prev = $("#content input[mainpop=" + (parseInt(mainpop) - 1) + "]");
                    if ($prev) {
                    	 $($prev).focus();
                        currObj = $($prev);
                    	var h = $(".form-horizontal .form-group:eq(0)").height();
                        var num = -((parseInt(mainpop) - 1) * h);
                        $("#content").css({
	                        "position": "relative",
	                        "top": num
                        })
                        if (mainpop == 1) {
                        	$("#content").css("top", "0px");
                            isMainFirst = true;
                        }
                        if (mainpop == 2) {      //低压input获取焦点时点击键盘的上一项按钮主页内容不上移  -  4-29小宋增加
                        	$("#content").css("top", "0px");
                            isMainFirst = true;
                        }
                    }
                } else {
                	$("#content").css({
                        "position": "relative",
                        "top": '0px'
                    });
                    alert('已经是第一项');
                }
            } 
        }
    })
    $(".next").click(function () {       //下一项
        if (currObj) {
            var mainpop = currObj.attr("mainpop");
            var temppop = currObj.attr("pop");

            //模态窗口
            if (temppop) {
                if (!isLast) {
                    var $next = currObj.parent().parent().next().find("input");
                    var temppop = $($next).attr("pop");
                    if ($next && temppop) {
                        var h = $(".form-horizontal .form-group:eq(0)").height();
                        var num = -(temppop * h);
                        $("#modal-wrap").css("top", num);
                        $($next).focus();
                        currObj = $($next);
                        if (temppop == 5) {
                            isLast = true;
                        }
                    }
                } else {
                    alert('已经是最后一项');
                }
            }

            //主页处理
            if (mainpop) {
                if (!isMainLast) {
                    var $next = $("#content input[mainpop=" + (parseInt(mainpop) + 1) + "]");
                    if ($next) {
                    	$($next).focus();
                        currObj = $($next);
                    	var h = $(".form-horizontal .form-group:eq(0)").height();
                    	var num = -(mainpop * h);                  	
                        if(mainpop == 1){        //高压input获取焦点时点击键盘的下一项按钮主页内容不下移  -  4-29小宋增加
                        	$("#content").css({
	                        	"position": "relative",
	                        	"top": 0
                        	});
                        }else{
                        	$("#content").css("top", num);
                        }
                        if (mainpop == 6) {
                            isMainLast = true;
                        }
                    }
                } else {
                    alert('已经是最后一项');
                }
            }
        }
    })
    $('.caret').click(function () {   //点击右上角图标隐藏键盘
        $('.jianpan').hide();
        $("#modal-wrap").css("top", "0px");
        $("#content").css("top", "0px");
    });
   
    $("input[nopop='true']").focus(function () {   //单独处理标注
        $('#jianpan').hide();
        $('#jianpan1').hide();
    });



    $("#quxiao").click(function () {   //点击取消隐藏键盘(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 )
		$(".jianpan").hide();
		$("#modal-wrap").css("top", "0px");
	});  
    $('#tiwen').click(function () {   //点击主页体温input隐藏键盘
        $('.jianpan').hide();
        $("#content").css("top", "0px");
    });
    
    
    
    
    
    
    
    
});