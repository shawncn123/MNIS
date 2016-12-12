<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>医嘱未执行</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="SHORTCUT ICON" href="images/favicon.ico">
<link rel="icon" href="images/favicon.ico" type="image/x-icon">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="融汇国康" />
<meta name="keywords" content="移动护理信息系统" />
<meta name="description" content="病案首页,高大上的移动护理系统。" />
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<link href="css/base.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/song.css" />
<script type="text/javascript" src="scripts/jquery-1.12.1.min.js"></script>

<script type="text/javascript" src="scripts/viewjs.js"></script>
<script src="scripts/song.js" type="text/javascript"></script>

<link href="css/bootstrap-clockpicker.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="scripts/bootstrap-clockpicker.min.js"></script>
<link href="css/mobiscroll_002.css" rel="stylesheet" type="text/css">
<link href="css/mobiscroll_003.css" rel="stylesheet" type="text/css">
<script src="scripts/mobiscroll_002.js" type="text/javascript"></script>
<script src="scripts/mobiscroll_004.js" type="text/javascript"></script>
<script src="scripts/mobiscroll.js" type="text/javascript"></script>
<script src="scripts/mobiscroll_003.js" type="text/javascript"></script>
<script src="scripts/mobiscroll_005.js" type="text/javascript"></script>
<script src="scripts/time-shen.js" type="text/javascript"></script>
<script src="scripts/jquery.scrollTo-2.1.2.js" type="text/javascript"></script>

<script type="text/javascript">
	
	$(function() {$(document).ready(function() {
		/* 分类查询 */
	$(".yzzxfl_select").click(function() {
		 $("#accordion")[0].innerHTML = "<p>正在加载......</p>"; 
		var vflyz = $(this).attr("value");
/* 	使用$(this).val() 回丢失前面的数字0	alert( $(this).val()); */
		var val_text = $(this).text();
		var url = "yizhuweizhixingforjquery";
		var vxzrq = $("#yiZhuRq").val();
		var args = {"vxzzxfl":vflyz,"vxzrq":vxzrq}; 
		$.post(url,args,function(data) {
			var a = '';
			var chuangwei="";
			if(data!=null && data!="" ){
				d = eval("("+ data+ ")");
				for (var i = 0; i < d.length; i++) {
					var obj =  d[i].rq;
					var teo = new Date(obj.time);
					var vmonth = teo.getMonth()+1;
					if(vmonth<10){
						vmonth = "0"+vmonth;
					}
					var vday =  teo.getDate();
					if(vday < 10){
						vday = "0" + vday;
					}
					var vyzrq1 = teo.getFullYear() + "-" + vmonth + "-" + vday + " 00:00:00.0";
					var vyzrq2 = teo.getFullYear() + "-" + vmonth + "-" + vday;
					var vyzrq3 = teo.getFullYear() + vmonth + vday;
					
					if(i==0){
						chuangwei=d[i].chw;
						a = a +'<div class="panel panel-default" style="z-index:-100" id="' + d[i].key1 + '-' 
							+ d[i].key2 + '-' + d[i].yebh + '_maodian' 
							+ '"><div class="panel-heading" style="background-color: #C1BFBF;">'
							+ '<h4 class="panel-title"> <a data-toggle="collapse" data-parent="#accordion" href="#collapse_0'
							+ ' style="display: block;width: 100%;"><strong class="brName" style="font-size: 1.8rem;">'
							+ d[i].chw + '床&nbsp;'+d[i].xm+'&nbsp;'+d[i].xb+'&nbsp;'+d[i].nl+'&nbsp;'+d[i].bah+'</strong><input value="' + d[i].key1 + '-' 
							+ d[i].key2 + '-' + d[i].yebh + '" style="display:none;" id="' + d[i].key1 + '-' 
							+ d[i].key2 + '-' + d[i].yebh
							+ '" /><span class="label label-success" style="margin: 0 0 0 50%;visibility: hidden;" id="mes'
							+ d[i].key1 + '-' + d[i].key2 + '-' + d[i].yebh + '">成功对应病人</span></a></h4></div><div id="collapse_0" class="panel-collapse collapse in">'
							+ '<div class="panel-body" style="padding:0 10px 10px 10px;">';
					}else if(chuangwei!=d[i].chw){
						chuangwei=d[i].chw;
						a = a + '</div></div></div><div class="panel panel-default" id="' + d[i].key1 + '-' 
							+ d[i].key2 + '-' + d[i].yebh + '_maodian'
							+ '"><div class="panel-heading" style="background-color: #C1BFBF;">'
							+ '<h4 class="panel-title"> <a data-toggle="collapse" data-parent="#accordion" href="#collapse_' + i 
							+ '"  style="display: block;width: 100%;"><strong class="brName" style="font-size: 1.8rem;">'
							+ d[i].chw + '床&nbsp;'+d[i].xm+'&nbsp;'+d[i].xb+'&nbsp;'+d[i].nl+'&nbsp;'+d[i].bah+'</strong><input value="' + d[i].key1 + '-' 
							+ d[i].key2 + '-' + d[i].yebh + '" style="display:none;" id="' + d[i].key1 + '-' 
							+ d[i].key2 + '-' + d[i].yebh
							+ '" /><span class="label label-success" style="margin: 0 0 0 50%;visibility: hidden;" id="mes'
							+ d[i].key1 + '-' + d[i].key2 + '-' + d[i].yebh + '">成功对应病人</span></a></h4></div><div id="collapse_' + i 
							+ '" class="panel-collapse collapse in"><div class="panel-body" style="padding:0 10px 10px 10px;">';
					}
					a = a + '<div class="row ' + d[i].rowkey + '" style="margin: 2% 0 0 0;padding: 2% 4%;border: 2px solid #C1D7F9;border-radius: 5px;" id="'
						+ vyzrq3 + "-" + d[i].groupxh
						+ '"><div class="row module" id="yzmc_' + i + '">';
						
					var tmp_yzmcs = d[i].yzmcs;
					for(var j = 0;j<tmp_yzmcs.length;j++){
							a = a + '<div class="col-xs-12"><span>' + tmp_yzmcs[j] + '</span></div>'
						}
					a = a + '</div><div class="row"><div class="col-xs-12 text-right" style="margin: 10px 0 10px 0;padding-bottom: 5px;border-top: #666666 1px dashed;">'
						+ '</div></div><div class="row" style="border-bottom: #666666 1px dashed;padding-bottom: 5px;margin-bottom: 5px;">'
						+ '<div class="col-xs-7"><span>' + d[i].yf2mc + '</span></div><div class="col-xs-1" style="padding:0;">';
						
					if(d[i].lsflag=='0'){
						a = a + '<span style="font-size: 18px;border-radius: 20px;border: 2px solid #0316F7;padding: 5px;color: #0316F7;">长</span>';
					}else{
						a = a + '<span style="font-size: 18px;border-radius: 20px;border: 2px solid #03BFF7;padding: 5px; color: #03BFF7;">临</span>';
					}
					a = a + '</div><div class="col-xs-4" style="padding: 0 0 0 1%;"><span>';
					a = a + vyzrq2 + '</span></div></div>';
					a = a + '<div class="row" style="padding-bottom: 1%;"><div class="col-xs-12">';
					a = a + '<div class="btn-group" data-toggle="buttons" style="width:100%;"><input value="'
						+ d[i].groupxh + '" style="display:none;" id="' + d[i].rowkey + '_groupxh"/>';;
					
					if(d[i].zxflag=='1'){
						if(d[i].zxfldm=='01'){
							a = a + '<span style="float:left;" id="' + d[i].rowkey + '_sjd">' + d[i].sjd + '</span>';
							if(d[i].syflag=='1'){
								a = a + '<button type="button" class="btn btn-success zxTime" data-toggle="modal" data-target="#moduleModal" id="'
								 + d[i].rowkey + '_1" style="color:#FFFFFF;margin-left: 6%;margin-right: 3%;background-color:#5cb85c;border-color:#4cae4c;">扎 针</button>'
								 + '<button type="button" class="btn btn-success zxTime" data-toggle="modal" data-target="#moduleModal" id="'
								 + d[i].rowkey + '_2" style="color:#FFFFFF;margin-left: 3%;margin-right: 3%;" disabled="disabled">换 液</button>';
							}
							if(d[i].syflag=='2'){
								a = a + '<button type="button" class="btn btn-success zxTime" data-toggle="modal" data-target="#moduleModal" id="'
								 + d[i].rowkey + '_1" style="color:#FFFFFF;margin-left: 6%;margin-right: 3%;" disabled="disabled">扎 针</button>'
								 + '<button type="button" class="btn btn-success zxTime" data-toggle="modal" data-target="#moduleModal" id="'
								 + d[i].rowkey + '_2" style="color:#FFFFFF;margin-left: 3%;margin-right: 3%;background-color:#5cb85c;border-color:#4cae4c;">换 液</button>';
							}
							if(d[i].czfl=='0'){
								a = a + '<button type="button" class="btn btn-success zxTime" data-toggle="modal" data-target="#moduleModal" id="'
								  + d[i].rowkey + '_3" style="color:#FFFFFF;margin-left: 3%;margin-right: 3%;background-color:#5cb85c;border-color:#4cae4c;">拔 针</button>';
							}else{
								a = a + '<button type="button" class="btn btn-primary moduleTime" data-toggle="modal" data-target="#moduleModal" id="'
								+ d[i].rowkey + '_3" style="color:#FFFFFF;margin-left: 3%;margin-right: 3%;">拔 针</button>'
							}
						}else{
							a = a + '<button type="button" class="btn btn-success zxTime" data-toggle="modal" data-target="#moduleModal" id="'
							+ d[i].rowkey + '_0" style="color:#FFFFFF;background-color:#5cb85c;border-color:#4cae4c;">'+ d[i].sjd + '</button>';
						}
					}else{
						if(d[i].zxfldm=='01'){
							a = a + '<span style="float:left;" id="' + d[i].rowkey + '_sjd">' + d[i].sjd + '</span>'
							+ '<button type="button" class="btn btn-primary moduleTime" data-toggle="modal" data-target="#moduleModal" id="'
							+ d[i].rowkey + '_1" style="color:#FFFFFF;margin-left: 6%;margin-right: 3%;">扎 针</button>'
							+ '<button type="button" class="btn btn-primary moduleTime" data-toggle="modal" data-target="#moduleModal" id="'
							+ d[i].rowkey + '_2" style="color:#FFFFFF;margin-left: 3%;margin-right: 3%;">换 液</button>'
							+ '<button type="button" class="btn btn-primary moduleTime" data-toggle="modal" data-target="#moduleModal" id="'
							+ d[i].rowkey + '_3" style="color:#FFFFFF;margin-left: 3%;margin-right: 3%;" disabled="disabled">拔 针</button>';
						}else{
							a = a + '<button type="button" class="btn btn-primary moduleTime" data-toggle="modal" data-target="#moduleModal" id="'
							+ d[i].rowkey + '_0" style="color:#FFFFFF;">' + d[i].sjd + '</button>';
						}
					}
					a = a + '<input value="yzmc_'+ i + '" style="display:none;" id="' + d[i].rowkey + '_html">'
						+ '<input value="' + vyzrq1 + '" style="display:none;" id="' + d[i].rowkey + '_rq"/><input value="'
						+ d[i].crlflag + '" style="display:none;" id="' + d[i].rowkey + '_crlflag"/><input value="'
						+ d[i].crl + '" style="display:none;" id="' + d[i].rowkey + '_crl"/></div>';
					a = a + '</div></div></div>';
				}
				a = a + '</div></div></div>';
			}else{
				a = "无数据！";
			} 
			 $("#accordion")[0].innerHTML = a; 
			 $("#dropdownMenu1")[0].innerHTML = val_text + '<span class="caret"></span>';
			 $("#saowandai").val("");
			 document.getElementById("saowandai").focus();
			 $(".label-success").hide();
		})
	})})});
	
	$(function() {
		// 绑定
		$("#head_banner_1").smartFloat();	
		
		 var vkey = "";
		 var height = $('#head_banner_1').height();     //模态框距离头部距离
		 
		// 扫描筛选病人信息
		$('#chacw').click(function() { //点击‘查’按钮
			
			var val = $('#saowandai').val(); //获取扫腕带的值
			var lxflag = val.substr(0,1);
			
			if(lxflag=="B" || lxflag=="b"){
				$(".panel-default").css("background-color","#FFF");
				$(".row").css("border-color","#C1D7F9");
				$(".moduleTime").css("color","#FFFFFF");
				/* $(".label-success").hide(); */
				$(".label-success").css("visibility","hidden");
				vkey = val.substr(1);
				val = val.substr(1);
				val = val + "_maodian";
				var s = document.getElementById(val);
				if(!s){
					document.getElementById("chatAudio").play();
					alert("没有对应的病人记录！");
					$("#saowandai").val("");
					document.getElementById("saowandai").focus();
				}else{
					$("#"+val).css("background-color","#CAECEB");
					/* $("#mes"+vkey).show(); */
					$(".label-success").css("visibility","visible");
					var scroll_offset = $("#"+val).offset().top - height - height;
					$("html,body").animate({scrollTop:scroll_offset},120);
					$("#saowandai").val("");
					document.getElementById("saowandai").focus();
				}
			}else if(lxflag=="P" || lxflag=="p"){
				
				$(".row").css("border-color","#C1D7F9");
				$(".moduleTime").css("color","#FFFFFF");
				
				//example: p20160913-30383236-20:00_37458438-1-0
				//取时间点的id
				var vsjd_id = val.substr(1,val.indexOf("_")-1);  //20160913-30383236-20:00
				vsjd_id = vsjd_id.replace(":","q");				 //20160913-30383236-20q00
				var pkey_str = val.substr(val.indexOf("_")+1);   //37458438-1-0
				var yo = document.getElementsByClassName(vsjd_id);
				//判断是否是该病人
				if(pkey_str==vkey){
					if(!yo || yo.length<1){
						document.getElementById("chatAudio").play();
						alert("没有对应的用药医嘱！");
						$("#saowandai").val("");
						document.getElementById("saowandai").focus();
					}else{
						$("." + vsjd_id).css("border-color","#EF9C04");
						var yomove_offset = $("." + vsjd_id).offset().top - height - height;
						$("html,body").animate({scrollTop:yomove_offset},120);
						$("#saowandai").val("");
						document.getElementById("saowandai").focus();
					}
					
				}else{
					document.getElementById("chatAudio").play();
					$(".row").css("border-color","#C1D7F9");
					$(".moduleTime").css("color","#FFFFFF");
					alert("不是选中病人用药医嘱");
					$("#saowandai").val("");
					document.getElementById("saowandai").focus();
				}
			}else{
				document.getElementById("chatAudio").play();
				$(".panel-default").css("background-color","#FFF");
				$(".row").css("border-color","#C1D7F9");
				$(".moduleTime").css("color","#FFFFFF");
				$(".label-success").hide();
				alert("不是相关标签");
				$("#saowandai").val("");
				document.getElementById("saowandai").focus();
			}
		});
		
		//20160909 by shen 写的模态框
		
		$('#modal-wrap').css({   
				'position':'fixed',
				'top':height + 'px',
				'width':'95%'
		});	
		$('#moduleModal').on('shown.bs.modal', function () {
		    $('.modal-backdrop').css('top', height + 'px');
		});
		
		var $clickBtn;
		var zx_sjd = "";
		var yz_groupxh = "";
		var vrq = "";
		var vcrlflag = "";
		var vrowkey = "";
		
	 	$('#accordion').on('click','.moduleTime', function(){
	 		$clickBtn = $(this);
	 		var vrowkey_val = $(this).attr("id");
	 		vrowkey = vrowkey_val.substr(0,vrowkey_val.indexOf("_"));
	 		var vsyflag = vrowkey_val.substr(vrowkey_val.indexOf("_")+1,vrowkey_val.indexOf("_")+2);
	 		$("#syflag").val(vsyflag);/* 给弹出的模态框 input 赋值 */
			yz_groupxh = $("#" + vrowkey + "_groupxh").val();
			var yzmc_gid = $("#" + vrowkey + "_html").val();
			vrq = $("#" + vrowkey + "_rq").val();
			vcrlflag = $("#" + vrowkey + "_crlflag").val();
			var vcrl = $("#" + vrowkey + "_crl").val();
			var html = $("#" + yzmc_gid).html();
			zx_sjd = $("#" + vrowkey + "_sjd").html();  
			if(vcrlflag=="0" || vsyflag=="3"){
				$("#mcrlmess").hide();
				$("#mcrlbody").hide();
			}
			if(vcrlflag=="1" && vsyflag!="3"){
				$("#mcrlvalue").val(vcrl);
				$("#mcrlmess").show();
				$("#mcrlbody").show();
			}
			$("#infocontent").html(html);	
			var sss = '<button type="button" class="btn pull-left btn-primary" id="ensure">确定</button><button type="button" id="quxiao" class="btn btn-default" data-dismiss="modal">退出</button>';
			$("#modfooter").html(sss);
     	});
	 	
	 	$('#accordion').on('click','.zxTime', function(){
	 		$clickBtn = $(this);
	 		var vrowkey_val = $(this).attr("id");
	 		vrowkey = vrowkey_val.substr(0,vrowkey_val.indexOf("_"));
	 		var vsyflag = vrowkey_val.substr(vrowkey_val.indexOf("_")+1,vrowkey_val.indexOf("_")+2);
	 		$("#syflag").val(vsyflag);/* 给弹出的模态框 input 赋值 */
			yz_groupxh = $("#" + vrowkey + "_groupxh").val();
			var yzmc_gid = $("#" + vrowkey + "_html").val();
			vrq = $("#" + vrowkey + "_rq").val();
			vcrlflag = $("#" + vrowkey + "_crlflag").val();
			vcrl = $("#" + vrowkey + "_crl").val();
			var html = $("#" + yzmc_gid).html();
			zx_sjd = $("#" + vrowkey + "_sjd").html();
			html = "取消执行<br/><br/>" + html;
			html = html + "<br/><br/>" + "取消说明:";
			$("#mcrlmess").hide();
			$("#mcrlbody").hide();
			$("#infocontent").html(html);	
			var sss = '<button type="button" class="btn pull-left btn-primary" id="ensure_cancel">确定取消</button><button type="button" id="quxiao" class="btn btn-default" data-dismiss="modal">退出</button>'
			$("#modfooter").html(sss);	 		
     	});
	 	
	 	$('#modfooter').on('click','#ensure', function(){
			var yz_zxms = $("#textcontent").val();
			var url = "bingrGeTi_YiZhuZhiXing_baocun";
			var xzcrlflag = "0";
			var xzxflag = "1";
			var vcrl = 0;
			var syflag = $("#syflag").val();
			if(vcrlflag=="1"){
				xzcrlflag = $('input[name="quedflag"]:checked').attr("value");
				if(xzcrlflag=="1"){
					/* vcrl = $("#mcrlvalue").attr("value"); */
					vcrl = $("#mcrlvalue").val();
				}else{
					xzcrlflag = "0";
					vcrl = 0;
				}
			}
			var args = {"vsjd" : zx_sjd,"groupxh":yz_groupxh,"zxms":yz_zxms,"vrq":vrq,"vcrlflag":xzcrlflag,"vcrl":vcrl,"vzxflag":xzxflag,"syflag":syflag,"rowkey":vrowkey};
			$.post(url,args,function(data){
				if(data == "0"){
					if(syflag=="0" || syflag=="3"){
						$('#textcontent').val('');     //隐藏模态框时textarea值清空
						$('#moduleModal').modal('hide'); //隐藏模态窗口
						/* $clickBtn.attr('disabled','disabled'); */
						$clickBtn.attr("class","btn btn-primary zxTime");
						$clickBtn.css('background-color','#5cb85c'); 
						$clickBtn.css('border-color','#4cae4c'); 
					}else{
						$('#textcontent').val('');     //隐藏模态框时textarea值清空
						$('#moduleModal').modal('hide'); //隐藏模态窗口
						if(syflag=="1"){
							$clickBtn.attr("class","btn btn-primary zxTime");
							$clickBtn.css('background-color','#5cb85c'); 
							$clickBtn.css('border-color','#4cae4c'); 
							$("#" + vrowkey + "_2").attr('disabled','disabled');
						}
						if(syflag=="2"){
							$clickBtn.attr("class","btn btn-primary zxTime");
							$clickBtn.css('background-color','#5cb85c'); 
							$clickBtn.css('border-color','#4cae4c'); 
							$("#" + vrowkey + "_1").attr('disabled',true);
						}
						$("#" + vrowkey + "_3").attr('disabled',false);
					}
				}else{
				//若data 的返回值不是1，则提示删除失败
					alert("数据保存失败！");							
				}
			});	
		});
	 	
		// $('#ensure_cancel').click(function(){ 
			//点击模态框确定按钮后主页时间按钮禁用
		$('#modfooter').on('click','#ensure_cancel', function(){
			var yz_zxms = $("#textcontent").val();
			var url = "bingrGeTi_YiZhuZhiXing_baocun";
			var xzcrlflag = "0";
			var xzxflag = "0";
			var vcrl = 0;
			var syflag = $("#syflag").val();
			var args = {"vsjd" : zx_sjd,"groupxh":yz_groupxh,"zxms":yz_zxms,"vrq":vrq,"vcrlflag":xzcrlflag,"vcrl":vcrl,"vzxflag":xzxflag,"syflag":syflag,"rowkey":vrowkey};
			$.post(url,args,function(data){
				if(data == "0"){
					if(syflag=="0" || syflag=="3"){
						$('#textcontent').val('');     //隐藏模态框时textarea值清空
						$('#moduleModal').modal('hide'); //隐藏模态窗口
						$clickBtn.attr("class","btn btn-primary moduleTime"); 
						$clickBtn.css('background-color','#428bca'); 
						$clickBtn.css('border-color','#357ebd'); 
					}else{
						$('#textcontent').val('');     //隐藏模态框时textarea值清空
						$('#moduleModal').modal('hide'); //隐藏模态窗口
						$clickBtn.attr("class","btn btn-primary moduleTime"); 
						$clickBtn.css('background-color','#428bca'); 
						$clickBtn.css('border-color','#357ebd'); 
						$("#" + vrowkey + "_1").attr('disabled',false);
						$("#" + vrowkey + "_2").attr('disabled',false);
						$("#" + vrowkey + "_3").attr('disabled',true);
					}					
				}else{
				//若data 的返回值不是1，则提示删除失败
					alert("数据保存失败！");							
				}
			});	
		});
	 	
	});
	
	
	function myFunction() {
		document.getElementById("chacw").click();
	}
		
	function changeDate() {
		 $("#accordion")[0].innerHTML = "<p>正在加载......</p>"; 
		var vflyz = "00";
/* 	使用$(this).val() 回丢失前面的数字0	alert( $(this).val()); */
		var val_text = "全部";
		var url = "yizhuweizhixingforjquery";
		var vxzrq = $("#yiZhuRq").val();
		var args = {"vxzzxfl":vflyz,"vxzrq":vxzrq}; 
		$.post(url,args,function(data) {
			var a = '';
			var chuangwei="";
			if(data!=null && data!="" ){
				d = eval("("+ data+ ")");
				for (var i = 0; i < d.length; i++) {
					var obj =  d[i].rq;
					var teo = new Date(obj.time);
					var vmonth = teo.getMonth()+1;
					if(vmonth<10){
						vmonth = "0"+vmonth;
					}
					var vday =  teo.getDate();
					if(vday < 10){
						vday = "0" + vday;
					}
					var vyzrq1 = teo.getFullYear() + "-" + vmonth + "-" + vday + " 00:00:00.0";
					var vyzrq2 = teo.getFullYear() + "-" + vmonth + "-" + vday;
					var vyzrq3 = teo.getFullYear() + vmonth + vday;
					
					if(i==0){
						chuangwei=d[i].chw;
						a = a +'<div class="panel panel-default" style="z-index:-100" id="' + d[i].key1 + '-' 
							+ d[i].key2 + '-' + d[i].yebh + '_maodian' 
							+ '"><div class="panel-heading" style="background-color: #C1BFBF;">'
							+ '<h4 class="panel-title"> <a data-toggle="collapse" data-parent="#accordion" href="#collapse_0'
							+ ' style="display: block;width: 100%;"><strong class="brName" style="font-size: 1.8rem;">'
							+ d[i].chw + '床&nbsp;'+d[i].xm+'&nbsp;'+d[i].xb+'&nbsp;'+d[i].nl+'&nbsp;'+d[i].bah+'</strong><input value="' + d[i].key1 + '-' 
							+ d[i].key2 + '-' + d[i].yebh + '" style="display:none;" id="' + d[i].key1 + '-' 
							+ d[i].key2 + '-' + d[i].yebh
							+ '" /><span class="label label-success" style="margin: 0 0 0 50%;visibility:hidden" id="mes'
							+ d[i].key1 + '-' + d[i].key2 + '-' + d[i].yebh + '">成功对应病人</span></a></h4></div><div id="collapse_0" class="panel-collapse collapse in">'
							+ '<div class="panel-body" style="padding:0 10px 10px 10px;">';
					}else if(chuangwei!=d[i].chw){
						chuangwei=d[i].chw;
						a = a + '</div></div></div><div class="panel panel-default" id="' + d[i].key1 + '-' 
							+ d[i].key2 + '-' + d[i].yebh + '_maodian'
							+ '"><div class="panel-heading" style="background-color: #C1BFBF;">'
							+ '<h4 class="panel-title"> <a data-toggle="collapse" data-parent="#accordion" href="#collapse_' + i 
							+ '"  style="display: block;width: 100%;"><strong class="brName" style="font-size: 1.8rem;">'
							+ d[i].chw + '床&nbsp;'+d[i].xm+'&nbsp;'+d[i].xb+'&nbsp;'+d[i].nl+'&nbsp;'+d[i].bah+'</strong><input value="' + d[i].key1 + '-' 
							+ d[i].key2 + '-' + d[i].yebh + '" style="display:none;" id="' + d[i].key1 + '-' 
							+ d[i].key2 + '-' + d[i].yebh
							+ '" /><span class="label label-success" style="margin: 0 0 0 50%;visibility: hidden;" id="mes'
							+ d[i].key1 + '-' + d[i].key2 + '-' + d[i].yebh + '">成功对应病人</span></a></h4></div><div id="collapse_' + i 
							+ '" class="panel-collapse collapse in"><div class="panel-body" style="padding:0 10px 10px 10px;">'
					}
					
					a = a + '<div class="row ' + d[i].rowkey + '" style="margin: 2% 0 0 0;padding: 2% 4%;border: 2px solid #C1D7F9;border-radius: 5px;" id="'
						+ vyzrq3 + "-" + d[i].groupxh
						+ '"><div class="row module" id="yzmc_' + i + '">';
						
					var tmp_yzmcs = d[i].yzmcs;
					for(var j = 0;j<tmp_yzmcs.length;j++){
							a = a + '<div class="col-xs-12"><span>' + tmp_yzmcs[j] + '</span></div>'
						}
					a = a + '</div><div class="row"><div class="col-xs-12 text-right" style="margin: 10px 0 10px 0;padding-bottom: 5px;border-top: #666666 1px dashed;">'
						+ '</div></div><div class="row" style="border-bottom: #666666 1px dashed;padding-bottom: 5px;margin-bottom: 5px;">'
						+ '<div class="col-xs-7"><span>' + d[i].yf2mc + '</span></div><div class="col-xs-1" style="padding:0;">';
						
					if(d[i].lsflag=='0'){
						a = a + '<span style="font-size: 18px;border-radius: 20px;border: 2px solid #0316F7;padding: 5px;color: #0316F7;">长</span>';
					}else{
						a = a + '<span style="font-size: 18px;border-radius: 20px;border: 2px solid #03BFF7;padding: 5px; color: #03BFF7;">临</span>';
					}
					
					a = a + '</div><div class="col-xs-4" style="padding: 0 0 0 1%;"><span>';
					
					a = a + vyzrq2 + '</span></div></div>';
						
					a = a + '<div class="row" style="padding-bottom: 1%;"><div class="col-xs-12">';
					a = a + '<div class="btn-group" data-toggle="buttons" style="width:100%;"><input value="'
						+ d[i].groupxh + '" style="display:none;" id="' + d[i].rowkey + '_groupxh"/>';
					
					if(d[i].zxflag=='1'){
						if(d[i].zxfldm=='01'){
							a = a + '<span style="float:left;" id="' + d[i].rowkey + '_sjd">' + d[i].sjd + '</span>';
							if(d[i].syflag=='1'){
								a = a + '<button type="button" class="btn btn-success zxTime" data-toggle="modal" data-target="#moduleModal" id="'
								 + d[i].rowkey + '_1" style="color:#FFFFFF;margin-left: 6%;margin-right: 3%;background-color:#5cb85c;border-color:#4cae4c;">扎 针</button>'
								 + '<button type="button" class="btn btn-success zxTime" data-toggle="modal" data-target="#moduleModal" id="'
								 + d[i].rowkey + '_2" style="color:#FFFFFF;margin-left: 3%;margin-right: 3%;" disabled="disabled">换 液</button>';
							}
							if(d[i].syflag=='2'){
								a = a + '<button type="button" class="btn btn-success zxTime" data-toggle="modal" data-target="#moduleModal" id="'
								 + d[i].rowkey + '_1" style="color:#FFFFFF;margin-left: 6%;margin-right: 3%;" disabled="disabled">扎 针</button>'
								 + '<button type="button" class="btn btn-success zxTime" data-toggle="modal" data-target="#moduleModal" id="'
								 + d[i].rowkey + '_2" style="color:#FFFFFF;margin-left: 3%;margin-right: 3%;background-color:#5cb85c;border-color:#4cae4c;">换 液</button>';
							}
							if(d[i].czfl=='0'){
								a = a + '<button type="button" class="btn btn-success zxTime" data-toggle="modal" data-target="#moduleModal" id="'
								  + d[i].rowkey + '_3" style="color:#FFFFFF;margin-left: 3%;margin-right: 3%;background-color:#5cb85c;border-color:#4cae4c;">拔 针</button>';
							}else{
								a = a + '<button type="button" class="btn btn-primary moduleTime" data-toggle="modal" data-target="#moduleModal" id="'
								+ d[i].rowkey + '_3" style="color:#FFFFFF;margin-left: 3%;margin-right: 3%;">拔 针</button>'
							}
						}else{
							a = a + '<button type="button" class="btn btn-success zxTime" data-toggle="modal" data-target="#moduleModal" id="'
							+ d[i].rowkey + '_0" style="color:#FFFFFF;background-color:#5cb85c;border-color:#4cae4c;">'+ d[i].sjd + '</button>';
						}
					}else{
						if(d[i].zxfldm=='01'){
							a = a + '<span style="float:left;" id="' + d[i].rowkey + '_sjd">' + d[i].sjd + '</span>'
							+ '<button type="button" class="btn btn-primary moduleTime" data-toggle="modal" data-target="#moduleModal" id="'
							+ d[i].rowkey + '_1" style="color:#FFFFFF;margin-left: 6%;margin-right: 3%;">扎 针</button>'
							+ '<button type="button" class="btn btn-primary moduleTime" data-toggle="modal" data-target="#moduleModal" id="'
							+ d[i].rowkey + '_2" style="color:#FFFFFF;margin-left: 3%;margin-right: 3%;">换 液</button>'
							+ '<button type="button" class="btn btn-primary moduleTime" data-toggle="modal" data-target="#moduleModal" id="'
							+ d[i].rowkey + '_3" style="color:#FFFFFF;margin-left: 3%;margin-right: 3%;" disabled="disabled">拔 针</button>';
						}else{
							a = a + '<button type="button" class="btn btn-primary moduleTime" data-toggle="modal" data-target="#moduleModal" id="'
							+ d[i].rowkey + '_0" style="color:#FFFFFF;">' + d[i].sjd + '</button>';
						}
					}
					a = a + '<input value="yzmc_'+ i + '" style="display:none;" id="' + d[i].rowkey + '_html">'
						+ '<input value="' + vyzrq1 + '" style="display:none;" id="' + d[i].rowkey + '_rq"/><input value="'
						+ d[i].crlflag + '" style="display:none;" id="' + d[i].rowkey + '_crlflag"/><input value="'
						+ d[i].crl + '" style="display:none;" id="' + d[i].rowkey + '_crl"/></div>';
					a = a + '</div></div></div>';
				}
				a = a + '</div></div></div>';
			}else{
				a = "无数据！";
			} 
			 $("#accordion")[0].innerHTML = a; 
			 $("#dropdownMenu1")[0].innerHTML = val_text + '<span class="caret"></span>';
			 $("#saowandai").val("");
			 document.getElementById("saowandai").focus();
			 $(".label-success").hide();
		})
	}
	window.onload = function() {
		$(".label-success").hide();
		document.getElementById("saowandai").focus();
	}
</script>
</head>

<body>
	<audio id="chatAudio"><source src="images/ydhl_error_001.wav" type="audio/wav"></audio>
	<%@ include file="header-hushi.jsp"%>
		<div class="row" style="border-bottom:1px solid #269abc;padding: 5px 0 ; margin: 0;">
			<div class="col-xs-4" style="padding: 0 2px;">
				<div class="dropdown" style="width: 100%">
					<button class="btn btn-default btn-block dropdown-toggle"
						type="button" id="dropdownMenu1" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="true">全部<span class="caret"></span>
					</button>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
						<li class="yzzxfl_select" id="test" value="00" style="padding: 5%;border-bottom: 1px dashed #E6E1E1;">全部</li>
						<s:iterator value="#request.yizhuzxfl">
							<li class="yzzxfl_select" value="${dm }" style="padding: 5%;border-bottom: 1px dashed #E6E1E1;">${mc }</li>
						</s:iterator>
					</ul>
				</div>
			</div>
			<div class="col-xs-4" style="padding: 0 2px;">
				<div class="demos">
					<input value="" class="form-control" name="chajiantime" id="yiZhuRq" type="text" placeholder="" onchange="changeDate()" readonly="readonly">
				</div>
			</div>
			
			<div class="col-xs-4" style="padding: 0 2px;">
				<div class="input-group input-group-xs">
					<input type="text" class="form-control" id="saowandai"
						placeholder="扫描" onfocus="javascript:this.value='';" oninput="myFunction()" /> 
					<span class="input-group-btn" style="display:none;">
						<button class="btn btn-default" type="button" id="chacw">查</button>
					</span>
				</div>
			</div>
		</div>
	</div>
	
	<div id="content" class="container" style="padding: 0;">
		<div class="panel-group" id="accordion" style="z-index:-100">
			<s:set var="chuangwei" value="" />
			<s:iterator value="#request.yizhu_weizhixing" status="status">
				<s:if test="#status.index==0">
					<s:set var="chuangwei" value="chw"/>
					<div class="panel panel-default"  style="z-index:-100" id="${key1 }-${key2}-${yebh}_maodian">
						<div class="panel-heading" style="background-color: #C1BFBF;">
							<h4 class="panel-title"> 
								<a data-toggle="collapse" data-parent="#accordion" 
									href="#collapse_<s:property value="#status.index"/>" style="display: block;width: 100%;">
				         			<strong class="brName" style="font-size: 1.8rem;">${chw}床&nbsp;${xm }&nbsp;${xb }&nbsp;${nl }&nbsp;${bah } </strong>
				         			<input value="${key1 }-${key2}-${yebh}" style="display:none;" id="${key1 }-${key2}-${yebh}" />
				         			<span class="label label-success" style="margin: 0 0 0 50%;visibility:hidden" id="mes${key1 }-${key2}-${yebh}">成功对应病人</span>
			        			</a>
			      			</h4>
						</div>
						<div id="collapse_<s:property value="#status.index"/>" class="panel-collapse collapse in">
							<div class="panel-body" style="padding:0 10px 10px 10px;">
				</s:if>
				<s:elseif test='chw!=#chuangwei'>
					<s:set var="chuangwei" value="chw"/>
							</div>
						</div>
					</div>
					<div class="panel panel-default" id="${key1 }-${key2}-${yebh}_maodian">
						<div class="panel-heading" style="background-color: #C1BFBF;">
							<h4 class="panel-title"> 
								<a data-toggle="collapse" data-parent="#accordion" href="#collapse_<s:property value="#status.index"/>"  style="display: block;width: 100%;">
				         			<strong class="brName" style="font-size: 1.8rem;">${chw}床&nbsp;${xm }&nbsp;${xb }&nbsp;${nl }&nbsp;${bah } </strong>
				         			<input value="${key1 }-${key2}-${yebh}" style="display:none;" id="${key1 }-${key2}-${yebh}" />
				         			<span class="label label-success" style="margin: 0 0 0 50%;visibility: hidden;" id="mes${key1 }-${key2}-${yebh}">成功对应病人</span>
			        			</a>
			      			</h4>
						</div>
						<div id="collapse_<s:property value="#status.index"/>" class="panel-collapse collapse in">
							<div class="panel-body" style="padding:0 10px 10px 10px;">
				</s:elseif>
						<div class="row ${rowkey}" style="margin: 2% 0 0 0;padding: 2% 4%;border: 2px solid #C1D7F9;border-radius: 5px;" id="<s:date name="rq" format="yyyyMMdd"/>-${groupxh}">
							<div class="row module" id="yzmc_<s:property value="#status.index"/>">
								<s:iterator value="yzmcs" id="mc_yz">
									<div class="col-xs-12">
										<span><s:property value="mc_yz"/></span>
									</div>
								</s:iterator>
							</div>
							<div class="row">
								<div class="col-xs-12 text-right"
									style="margin: 10px 0 10px 0;padding-bottom: 5px;border-top: #666666 1px dashed;">
								</div>
							</div>
							<div class="row"
								style="border-bottom: #666666 1px dashed;padding-bottom: 5px;margin-bottom: 5px;">
								<div class="col-xs-7">
									<span>${yf2mc }</span>
								</div>
								<div class="col-xs-1" style="padding:0;">
								<s:if test="lsflag==0">
									<span style="font-size: 18px;border-radius: 20px;border: 2px solid #0316F7;padding: 5px;color: #0316F7;">长</span>
								</s:if>
								<s:else>
									<span style="font-size: 18px;border-radius: 20px;border: 2px solid #03BFF7;padding: 5px; color: #03BFF7;">临</span>
								</s:else>
								</div>
								<div class="col-xs-4" style="padding: 0 0 0 1%;">
									<span><s:date name="rq" format="yyyy-MM-dd"/></span>
								</div>
							</div>
							<div class="row" style="padding-bottom: 1%;">
								<div class="col-xs-12">
									<div class="btn-group" data-toggle="buttons" style="width:100%;">
										<input value="${groupxh }" style="display:none;" id="${rowkey }_groupxh"/>
										<s:if test="zxflag==1">
											<s:if test="zxfldm==01">
												<span style="float:left;" id="${rowkey }_sjd">${sjd }</span> 
												<s:if test="syflag==1">   <!-- 判断已执行扎针 -->
													<button type="button" class="btn btn-success zxTime" data-toggle="modal" 
													data-target="#moduleModal" id="${rowkey }_1" style="color:#FFFFFF;margin-left: 6%;margin-right: 3%;background-color:#5cb85c;border-color:#4cae4c;">扎 针</button>
													<button type="button" class="btn btn-success zxTime" data-toggle="modal" 
													data-target="#moduleModal" id="${rowkey }_2" style="color:#FFFFFF;margin-left: 3%;margin-right: 3%;" disabled="disabled">换 液</button>
												</s:if>
												<s:if test="syflag==2">   <!-- 判断已执行换液 -->
													<button type="button" class="btn btn-success zxTime" data-toggle="modal" 
													data-target="#moduleModal" id="${rowkey }_1" style="color:#FFFFFF;margin-left: 6%;margin-right: 3%;" disabled="disabled">扎 针</button>
													<button type="button" class="btn btn-success zxTime" data-toggle="modal" 
													data-target="#moduleModal" id="${rowkey }_2" style="color:#FFFFFF;margin-left: 3%;margin-right: 3%;background-color:#5cb85c;border-color:#4cae4c;">换 液</button>
												</s:if>
												<s:if test="czfl==0">   <!-- 已执行拔针 -->
													<button type="button" class="btn btn-success zxTime" data-toggle="modal" 
														data-target="#moduleModal" id="${rowkey }_3" style="color:#FFFFFF;margin-left: 3%;margin-right: 3%;background-color:#5cb85c;border-color:#4cae4c;">拔 针</button>
												</s:if>
												<s:else>
													<button type="button" class="btn btn-primary moduleTime" data-toggle="modal" 
													data-target="#moduleModal" id="${rowkey }_3" style="color:#FFFFFF;margin-left: 3%;margin-right: 3%;">拔 针</button>
												</s:else>
											</s:if>
											<s:else>
												<button type="button" class="btn btn-success zxTime" data-toggle="modal" data-target="#moduleModal" id="${rowkey }_0" style="color:#FFFFFF;background-color:#5cb85c;border-color:#4cae4c;">${sjd}</button>
											</s:else>
										</s:if>
										<s:else>
											<s:if test="zxfldm==01">
												<span style="float:left;" id="${rowkey }_sjd">${sjd }</span> 
												<button type="button" class="btn btn-primary moduleTime" data-toggle="modal" 
													data-target="#moduleModal" id="${rowkey }_1" style="color:#FFFFFF;margin-left: 6%;margin-right: 3%;">扎 针</button>
												<button type="button" class="btn btn-primary moduleTime" data-toggle="modal" 
													data-target="#moduleModal" id="${rowkey }_2" style="color:#FFFFFF;margin-left: 3%;margin-right: 3%;">换 液</button>
												<button type="button" class="btn btn-primary moduleTime" data-toggle="modal" 
													data-target="#moduleModal" id="${rowkey }_3" style="color:#FFFFFF;margin-left: 3%;margin-right: 3%;" disabled="disabled">拔 针</button>
											</s:if>
											<s:else>
												<button type="button" class="btn btn-primary moduleTime" data-toggle="modal" data-target="#moduleModal" id="${rowkey }_0" style="color:#FFFFFF;">${sjd}</button>
											</s:else>
										</s:else>
										<input value="yzmc_<s:property value="#status.index"/>" style="display:none;" id="${rowkey }_html"/>
										<input value="${rq}" style="display:none;" id="${rowkey }_rq"/>
										<input value="${crlflag}" style="display:none;" id="${rowkey }_crlflag"/>
										<input value="${crl}" style="display:none;" id="${rowkey }_crl"/>
									</div>
								</div>
							</div>	
						</div>
			</s:iterator>
						</div>
					</div>
				</div>
		</div>
		<!--导航结束-->
		<div class="clear"></div>
		<%@ include file="menu-hushi.jsp"%>
	</div>
	<!--页脚开始-->
	<%@ include file="footer.jsp"%>
	<!--页脚结束-->
	
	<!-- 20160909 by shen 模态框（Modal）start -->
		<div class="modal fade" id="moduleModal" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" id="modal-wrap">
				<div class="modal-content">
					<!-- <div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel"></h4>
					</div> -->
					<div class="modal-body" style="padding-bottom: 2%;padding-top: 2%;">
						<div id="infocontent"></div>
						
						<div class="row" style="padding: 3%;display: block;" id="mcrlmess">
							<form>
							<div class="col-xs-2" style="padding: 0;">                       
								<input type="radio" class="qdclass1" name="quedflag" value="1"
									style="display: block; margin-left: 3px; margin-top: 2px; width: 2rem; height: 2rem;" checked="checked"></input>
								<!-- <input name="quedflag" value="1" style="display:none;" class="qdclass"/> -->
							</div>
							<div class="col-xs-4" style="padding: 0;">                       
								<span>记入出量</span>
							</div>
							<div class="col-xs-2" style="padding: 0;">                       
								<input type="radio" class="qdclass1" name="quedflag" value="0" 
									style="display: block; margin-left: 3px; margin-top: 2px; width: 2rem; height: 2rem;" ></input>
								<!-- <input name="quedflag" value="0" style="display:none;" class="qdclass"/> -->
							</div>
							<div class="col-xs-4" style="padding: 0;">                       
								<span>不记入出量</span>
							</div>
							</form>
						</div>
						<div class="row" style="padding: 3% 5% 2% 5%;display: block;" id="mcrlbody">
							<div class="col-xs-3" style="padding: 0;">                       
								<span>值：</span>
							</div>
							<div class="col-xs-9" style="padding: 0;" >                       
								<input type="text" value="" style="border: 1px solid #ccc;" id="mcrlvalue"></input>
							</div>
						</div>
						<textarea id="textcontent" class="form-control" maxlength="50" rows="3" style="padding: 0;"></textarea>
					</div>
					<input type="text" value="0" style="display:none;" id="syflag"></input>
					<div class="modal-footer" id="modfooter"  style="margin-top: 0;padding-top: 2%;">
						<button type="button" class="btn pull-left btn-primary" id="ensure">
							确定
						</button>
						<button type="button" id="quxiao" class="btn btn-default" data-dismiss="modal">
							退出
						</button>
					</div>
				</div>
			</div>
		</div>
		<!-- 模态框（Modal）end -->
		<script src="scripts/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>