$(function() {          //时间插件
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

    function current(){        //时间插件 获取当前时间  -  4-29小宋增加
		var d = new Date()
		var h = d.getHours(); 
		var m = d.getMinutes(); 
		str=(h<10 ? "0"+ h : h)+':'+(m<10 ? "0" + m : m);
		return str; 
    }
	setInterval(function(){
		$("#appTime1").attr('value',current)
	});
	setInterval(function(){
		$("#appTime2").attr('value',current)
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
            var num = -((parseInt(mainpop)) * (h - 15));
            if(mainpop<6){          //6.27修改
            	num = 0;
            }
            $("#content").css({
	            "position": "relative",
	             "top": num
            });
            var count = $('#content input[mainpop]').length;   
            isMainLast = mainpop == count ? true : false;     
            isMainFirst = mainpop == 1 ? true : false;
        }
    });
	//体温模态键盘
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
            var count = $('#temperature input[pop]').length;    
            isLast = popNum == count ? true : false;    
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
//              case "hide": {     //点击右下角箭头隐藏键盘
//                  $('.jianpan').hide();
//                  $("#modal-wrap").css("top", "0px");
//                  $("#content").css("top", "0px");
//              }
//                  break;
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
                	$('.prev:eq(1) a').html('上一项');      //6.27修改
                	$('.next:eq(0) a').html("下一项");       //6.27修改
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
                    $('.prev:eq(1) a').html('第一项');     //6.27修改
                }
            }

            //主页处理
            if (mainpop) {
                if (!isMainFirst) {
                	$('.prev:eq(0) a').html('上一项');
                	$('.next:eq(0) a').html("下一项");
                    var $prev = $("#content input[mainpop=" + (parseInt(mainpop) - 1) + "]");
                    if ($prev) {
                    	 $($prev).focus();
                        currObj = $($prev);
                    	var h = $(".form-horizontal .form-group:eq(0)").height();
                        var num = -((parseInt(mainpop) - 1) * (h - 20)); 
                        if(mainpop<5){        //6.27修改
                        	num = 0;  
                        }
                        $("#content").css({
	                        "position": "relative",
	                        "top": num
                        })
                    }
                } else {
                	$("#content").css({
                        "position": "relative",
                        "top": '0px'
                    });
                    $('.prev:eq(0) a').html('第一项');      //6.27修改
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
                	$('.next:eq(1) a').html("下一项");       //6.27修改
                	$('.prev:eq(1) a').html('上一项'); 
                    var $next = currObj.parent().parent().next().find("input");
                    var temppop = $($next).attr("pop");
                    if ($next && temppop) {
                        var h = $(".form-horizontal .form-group:eq(0)").height();
                        var num = -(temppop * h);
                        $("#modal-wrap").css("top", num);
                        $($next).focus();
                        currObj = $($next);
                        if (temppop == 5) {            //6.27修改
                            isLast = true;
                        }
                    }
                } else {
                	$('.next:eq(0) a').html("最后一项");         //6.27修改
                }
            }

            //主页处理
            if (mainpop) {
                if (!isMainLast) {
                	$('.prev:eq(0) a').html('上一项');       //6.27修改
                	$('.next:eq(0) a').html("下一项");
                    var $next = $("#content input[mainpop=" + (parseInt(mainpop) + 1) + "]");
                    if ($next && $next.length>0) {
                    	$($next).focus();
                        currObj = $($next);
                    	var h = $(".form-horizontal .form-group:eq(0)").height();
                    	var num = -(mainpop * (h-15));
                    	if (mainpop == 1) {
                        	$("#content").css({
		                        "position": "relative",
		                        "top": 0
                        	});
                        }else{
                        	 $("#content").css({
		                        "position": "relative",
		                        "top": num
                       		});
                        }                                            
                    }else{
                    	$('.next:eq(0) a').html("最后一项");
                    }
                } else {
                	$('.next:eq(0) a').html("最后一项");
                }
            }
        }
    })
    $('.caret').click(function () {   //点击右上角图标隐藏键盘
        $('.jianpan').hide();
        $("#modal-wrap").css("top", "0px");
        $("#content").css("top", "0px");
        $('#character').hide();     //7.13增加
        $('#number').show();        
        $('#jianpan-right2').hide(); 
        $('#jianpan-right1').show(); 
    });
   
    $("input[nopop='true']").focus(function () {   //单独处理标注
        $('#jianpan').hide();
        $('#jianpan1').hide();
    });

    $("#quxiao").click(function () {   //点击取消隐藏键盘(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                )
		$(".jianpan").hide();
		$("#modal-wrap").css("top", "0px");
	});  
    $('#tiwen').click(function () {  
        $('.prev:eq(0) a').html('上一项');
        $('.next:eq(0) a').html('下一项');
        $('.jianpan').hide();
        $("#content").css("top", "0px");
        $('#character').hide();     //7.13增加
        $('#number').show();       
    });
    
    $('#character').hide();        //7.13增加（主页键盘）
    $('.numberBtn').click(function(){
    	$('#character').hide();
    	$('#number').show();
    });
    $('.characterBtn').click(function(){
    	$('#number').hide();
    	$('#character').show();   	
    });
    
    $('#jianpan-right2').hide();        //7.13增加（体温键盘）
    $('.numberBtn1').click(function(){
    	$('#jianpan-right2').hide();
    	$('#jianpan-right1').show();
    });
    $('.characterBtn1').click(function(){
    	$('#jianpan-right1').hide();
    	$('#jianpan-right2').show();   	
    });
});