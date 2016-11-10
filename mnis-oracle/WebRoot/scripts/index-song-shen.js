$(function() {          //时间插件
    
    var height = $('#head_banner_1').height();   //模态框距离头部距离   
	$('#content').css('margin-top', height + 'px');
    $('#modal-wrap').css({   
		'position':'fixed',
		'top':height + 'px'		
	});	
    
    $('#temperature').on('shown.bs.modal', function () {
        $('.modal-backdrop').css('top', height + 'px')
    });

    var currObj;
    var isFirst, isLast = false;
    var isMainFirst, isMainLast = false;
    $('#jianpan').hide();
    $('#jianpan1').hide();


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
            var num = -(popNum * h) + 20;
//            $("#modal-wrap").css("top", num);
            var count = $('#temperature input[pop]').length;    
            isLast = popNum == count ? true : false;    
            isFirst = popNum == 1 ? true : false;
        }
    });


    $('#temperature input[pop]').blur(function () {   //模态框失去焦点时去掉背景
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
                        $($prev).focus();
                        currObj = $($prev);
                        if (temppop == 1) {
                            isFirst = true;
                        }
                    }
                } else {
                    $('.prev:eq(1) a').html('第一项');     //6.27修改
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
        }
    })
    $('.caret').click(function () {   //点击右上角图标隐藏键盘
    	$('#modal-wrap').css('top', '82px');  //恢复模态框位置
        $('.jianpan').hide();
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