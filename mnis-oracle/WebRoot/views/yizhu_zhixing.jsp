<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<title>医嘱执行</title>
<base href="<%=basePath%>">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="SHORTCUT ICON" href="images/favicon.ico">
<link rel="icon" href="images/favicon.ico" type="image/x-icon">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="沈旭峰" />
<meta name="keywords" content="移动护理信息系统" />
<meta name="description" content="医嘱本,高大上的移动护理系统。" />
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<link href="css/base.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/song.css"/>
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
		$(".yzzxfl_select").click(function() {
		var vflyz = $(this).attr("value");
/* 	使用$(this).val() 回丢失前面的数字0	alert( $(this).val()); */
		var val_text = $(this).text();
		var url = "bingrYiZhuZhiXingforjquery";
		var vxzrq = $("#yiZhuRq").val();
		var args = {"vxzzxfl":vflyz,"vxzrq":vxzrq}; 
		/* var args = {"vxzzxfl":vflyz};  */
		$.post(url,args,function(data) {
			var a = '';
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
					
					/* a = a + '<div class="row module" id="' + vyzrq3 + '-' + d[i].groupxh + '">'; */
					a = a + '<div class="row module ' + d[i].groupxh + '" id="yzmc_' + i + '">';
						
					var tmp_yzmcs = d[i].yzmcs;
					for(var j = 0;j<tmp_yzmcs.length;j++){
							a = a + '<div class="col-xs-12" ><span>' + tmp_yzmcs[j] + '</span></div>';
						}
					
					a = a + '</div><div class="row"><div class="col-xs-12 text-right" style="margin: 10px 0 10px 0;padding-bottom: 5px;border-top: #666666 1px dashed;"></div></div><div class="row" style="border-bottom: #666666 1px dashed;padding-bottom: 5px;margin-bottom: 5px;"><div class="col-xs-7"><span>'
					+ d[i].yf2mc + '</span></div><div class="col-xs-1" style="padding:0;">';
						
					if(d[i].lsflag=='0'){
						a = a + '<span style="font-size: 18px;border-radius: 20px;border: 2px solid #0316F7;padding: 5px;color: #0316F7;">长</span>';
					}else{
						a = a + '<span style="font-size: 18px;border-radius: 20px;border: 2px solid #03BFF7;padding: 5px; color: #03BFF7;">临</span>';
					}
					
					a = a + '</div><div class="col-xs-4" style="padding: 0 0 0 1%;"><span>';
					
					a = a + vyzrq2 + '</span></div></div>';
						
					a = a + '<div class="row" style="border-bottom: 2px solid #333333;padding-bottom: 10px;margin-bottom: 10px;"><div class="col-xs-12">';
					
					var tmp_twBryzzxRemodelSubs = d[i].twBryzzxRemodelSubs;
					for(var k = 0; k < tmp_twBryzzxRemodelSubs.length; k ++){
						a = a + '<div class="btn-group" data-toggle="buttons" style="display:block;">';
						a = a + '<input value="' + d[i].groupxh + '" style="display:none;"/>';
						if(tmp_twBryzzxRemodelSubs[k].zxflag==1){
							a = a + '<button type="button" class="btn btn-success zxTime" data-toggle="modal" data-target="#moduleModal" style="margin:0 0 0 2%;" id="' 
								+ tmp_twBryzzxRemodelSubs[k].rowkey +'">'
								+ tmp_twBryzzxRemodelSubs[k].sjd + '</button>';
						}else{
							a = a + '<button type="button" class="btn btn-primary moduleTime" data-toggle="modal" data-target="#moduleModal" style="margin:0 0 0 2%;" id="'
								+ tmp_twBryzzxRemodelSubs[k].rowkey +'">'
								+ tmp_twBryzzxRemodelSubs[k].sjd + '</button>';
						}
						a = a + '<input value="yzmc_' + i + '" style="display:none;"/>';
						
						a = a + '<input value="' + vyzrq1 + '" style="display:none;"/>';
						a = a + '<input value="' + tmp_twBryzzxRemodelSubs[k].crlflag + '" style="display:none;"/>';
						a = a + '<input value="' + tmp_twBryzzxRemodelSubs[k].crl + '" style="display:none;"/>';
						a = a + '</div>';
					}
					a = a + '</div></div>';
				}
			}else{
				a = "无数据！";
			} 
			 $("#accordion")[0].innerHTML = a; 
			 $("#dropdownMenu1")[0].innerHTML = val_text + '<span class="caret"></span>';
			 document.getElementById("saowandai").focus();
		})
	})})});
	
	
	$(function() {
		
		$("#prompt3").hide();
		$("#prompt4").hide();
		
		// 绑定
		$("#head_banner_1").smartFloat();
		
		//小宋 写的模态框
		 var height = $('#head_banner_1').height();     //模态框距离头部距离
		    $('#content').css('margin-top', height + 'px');
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
			var vcrlflag = "";
			
			$('#content_b').on('click','.moduleTime', function(){
				$clickBtn = $(this);
				yz_groupxh = $(this).prev().val();
				var yzmc_gid = $(this).next().val();
				vrq = $(this).next().next().val();
				vcrlflag = $(this).next().next().next().val();
				vcrl = $(this).next().next().next().next().val();
				var html = $("#" + yzmc_gid).html();
				zx_sjd = $(this).html();
				if(vcrlflag=="0"){
					$("#mcrlmess").hide();
					$("#mcrlbody").hide();
				}
				if(vcrlflag=="1"){
					$("#mcrlvalue").val(vcrl);
					$("#mcrlmess").show();
					$("#mcrlbody").show();
				}
				$("#infocontent").html(html);
				var sss = '<button type="button" class="btn pull-left btn-primary" id="ensure">确定</button><button type="button" id="quxiao" class="btn btn-default" data-dismiss="modal">退出</button>';
				$("#modfooter").html(sss);
			});
			
			$('#content_b').on('click','.zxTime', function(){
		 		$clickBtn = $(this);
				yz_groupxh = $(this).prev().val();
				var yzmc_gid = $(this).next().val();
				vrq = $(this).next().next().val();
				vcrlflag = $(this).next().next().next().val();
				vcrl = $(this).next().next().next().next().val();
				var html = $("#" + yzmc_gid).html();
				html = "取消执行<br/><br/>" + html;
				html = html + "<br/><br/>" + "取消说明:";
				zx_sjd = $(this).html();
				$("#mcrlmess").hide();
				$("#mcrlbody").hide();
				$("#infocontent").html(html);	
				var sss = '<button type="button" class="btn pull-left btn-primary" id="ensure_cancel">确定取消</button><button type="button" id="quxiao" class="btn btn-default" data-dismiss="modal">退出</button>'
				$("#modfooter").html(sss);	 		
	     	});
		        
			/* $('#ensure').click(function(){ */ //点击模态框确定按钮后主页时间按钮禁用
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
				var args = {"vsjd" : zx_sjd,"groupxh":yz_groupxh,"zxms":yz_zxms,"vrq":vrq,"vcrlflag":xzcrlflag,"vcrl":vcrl,"vzxflag":xzxflag,"syflag":syflag};
				$.post(url,args,function(data){
					if(data == "0"){
						$('#textcontent').val('');     //隐藏模态框时textarea值清空
						$('#moduleModal').modal('hide'); //隐藏模态窗口
						$clickBtn.attr("class","btn btn-primary zxTime");
						$clickBtn.css('background-color','#5cb85c'); 
						$clickBtn.css('border-color','#4cae4c'); 
					}else{
					//若data 的返回值不是1，则提示删除失败
						alert("数据保存失败！");							
					}
				});	
			});
			
			$('#modfooter').on('click','#ensure_cancel', function(){
				var yz_zxms = $("#textcontent").val();
				var url = "bingrGeTi_YiZhuZhiXing_baocun";
				var xzcrlflag = "0";
				var xzxflag = "0";
				var vcrl = 0;
				var syflag = $("#syflag").val();
				var args = {"vsjd" : zx_sjd,"groupxh":yz_groupxh,"zxms":yz_zxms,"vrq":vrq,"vcrlflag":xzcrlflag,"vcrl":vcrl,"vzxflag":xzxflag,"syflag":syflag};
				$.post(url,args,function(data){
					if(data == "0"){
						$('#textcontent').val('');     //隐藏模态框时textarea值清空
						$('#moduleModal').modal('hide'); //隐藏模态窗口
						/* $clickBtn.attr('disabled','disabled'); */
						$clickBtn.attr("class","btn btn-primary moduleTime"); 
						$clickBtn.css('background-color','#428bca'); 
						$clickBtn.css('border-color','#357ebd'); 
						/* var sss = '<button type="button" class="btn pull-left btn-primary" id="ensure">确定</button><button type="button" id="quxiao" class="btn btn-default" data-dismiss="modal">退出</button>';
						$("#modfooter").html(sss); */
					}else{
					//若data 的返回值不是1，则提示删除失败
						alert("数据保存失败！");							
					}
				});	
			});
			
			// 扫描筛选病人信息
			$('#chacw').click(function() { //点击‘查’按钮
				$(".module").css("color","#000");
				$(".moduleTime").css("color","#FFF");
				var val = $('#saowandai').val(); //获取扫腕带的值
				var lxflag = val.substr(0,1);
				if(lxflag=="b"){
					var vkey1 = "<s:property value='#session.bingrgetixingxi.key1' />";
					var vkey2 = "<s:property value='#session.bingrgetixingxi.key2' />";
					var vyebh = "<s:property value='#session.bingrgetixingxi_yinger.yebh' />";
					if(vyebh==""){
						vyebh="0";
					}
					
					var vkey1_s = val.substr(1,val.indexOf("-")-1);
					val = val.substr(1);
					val = val.substr(val.indexOf("-")+1);
					var vkey2_s = val.substr(0,val.indexOf("-"));
					val = val.substr(val.indexOf("-")+1);
					var vyebh_s = val.substr(0);
					
					if(vkey1==vkey1_s && vkey2==vkey2_s && vyebh==vyebh_s){
						$('#prompt1').show();
						$('#prompt2').hide();
						$('#prompt3').hide();
						$('#prompt4').hide();
						$("#saowandai").val("");
						document.getElementById("saowandai").focus();
					}else{
						$('#prompt1').hide();
						$('#prompt2').show();
						$('#prompt3').hide();
						$('#prompt4').hide();
						$("#saowandai").val("");
						document.getElementById("saowandai").focus();
					}
				}else if(lxflag=="P" || lxflag=="p"){
					//取时间点的id
					var vsjd_id = val.substr(1,val.indexOf("_")-1);
					vsjd_id = vsjd_id.replace(":","q");
					var pkey_str = val.substr(val.indexOf("_")+1);
					//取一组药的id
					var gy = val.substr(1,val.indexOf("-"));			//20160913
					var gyo = val.substr(val.indexOf("-")+1);			//30383236-20:00_37458438-1-0
					//注释改成按组序号定位
					/* gy = gy + gyo.substr(0,gyo.indexOf("-")); */		//20160913-30383236
					/* var yo = document.getElementById(gy); */   
					var vgroupxh = gyo.substr(0,gyo.indexOf("-"));
					
					var yo = document.getElementsByClassName(vgroupxh);
					//判断是否是包含该组groupxh的医嘱
					if(!yo || yo.length<1){
						$('#prompt1').hide();
						$('#prompt2').hide();
						$('#prompt3').show();		//无对应医嘱
						$('#prompt4').hide();
						$("#saowandai").val("");
						document.getElementById("saowandai").focus();
					}else{
						/* $("#" + gy).css("color","#EF9C04"); 
 						var yosjd = document.getElementById(vsjd_id);
						if(!yogroup){
							$('#prompt1').hide();
							$('#prompt2').hide();
							$('#prompt3').hide();
							$('#prompt4').show();
							$("#saowandai").val("");
							document.getElementById("saowandai").focus();
						}else{
							$("#" + vsjd_id).css("color","#FFFF00");
							var yomove_offset = $("#"+gy).offset().top - height - height;
							$("html,body").animate({scrollTop:yomove_offset},120);
							$('#prompt1').hide();
							$('#prompt2').hide();
							$('#prompt3').hide();
							$('#prompt4').hide();
							$("#saowandai").val("");
							document.getElementById("saowandai").focus();
						} */
						$("." + vgroupxh).css("color","#EF9C04")
						var yomove_offset = $("." + vgroupxh).offset().top - height - height;
						$("html,body").animate({scrollTop:yomove_offset},120);
						$('#prompt1').hide();
						$('#prompt2').hide();
						$('#prompt3').hide();
						$('#prompt4').hide();
						$("#saowandai").val("");
						document.getElementById("saowandai").focus();
					}
				}else{
					$('#prompt1').hide();
					$('#prompt2').hide();
					$('#prompt3').hide();
					$('#prompt4').hide();
					alert("不是相关标签");
					$("#saowandai").val("");
					document.getElementById("saowandai").focus();
				}
			});
			
		});
			
		function myFunction() {
			document.getElementById("chacw").click();
		}
		
		window.onload = function() {
			document.getElementById("saowandai").focus();
		}
		
		function changeDate() {
			var vflyz = "00";
			/* 	使用$(this).val() 回丢失前面的数字0	alert( $(this).val()); */
					var val_text = "全部";
					var url = "bingrYiZhuZhiXingforjquery";
					var vxzrq = $("#yiZhuRq").val();
					var args = {"vxzzxfl":vflyz,"vxzrq":vxzrq}; 
					/* var args = {"vxzzxfl":vflyz};  */
					$.post(url,args,function(data) {
						var a = '';
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
								
								/* a = a + '<div class="row module" id="' + vyzrq3 + '-' + d[i].groupxh + '">'; */
								a = a + '<div class="row module ' + d[i].groupxh + '" id="yzmc_' + i + '">';
									
								var tmp_yzmcs = d[i].yzmcs;
								for(var j = 0;j<tmp_yzmcs.length;j++){
										a = a + '<div class="col-xs-12" ><span>' + tmp_yzmcs[j] + '</span></div>';
									}
								
								a = a + '</div><div class="row"><div class="col-xs-12 text-right" style="margin: 10px 0 10px 0;padding-bottom: 5px;border-top: #666666 1px dashed;"></div></div><div class="row" style="border-bottom: #666666 1px dashed;padding-bottom: 5px;margin-bottom: 5px;"><div class="col-xs-7"><span>'
								+ d[i].yf2mc + '</span></div><div class="col-xs-1" style="padding:0;">';
									
								if(d[i].lsflag=='0'){
									a = a + '<span style="font-size: 18px;border-radius: 20px;border: 2px solid #0316F7;padding: 5px;color: #0316F7;">长</span>';
								}else{
									a = a + '<span style="font-size: 18px;border-radius: 20px;border: 2px solid #03BFF7;padding: 5px; color: #03BFF7;">临</span>';
								}
								
								a = a + '</div><div class="col-xs-4" style="padding: 0 0 0 1%;"><span>';
								
								a = a + vyzrq2 + '</span></div></div>';
									
								a = a + '<div class="row" style="border-bottom: 2px solid #333333;padding-bottom: 10px;margin-bottom: 10px;"><div class="col-xs-12">';
								
								var tmp_twBryzzxRemodelSubs = d[i].twBryzzxRemodelSubs;
								for(var k = 0; k < tmp_twBryzzxRemodelSubs.length; k ++){
									a = a + '<div class="btn-group" data-toggle="buttons" style="display:block;">';
									a = a + '<input value="' + d[i].groupxh + '" style="display:none;"/>';
									if(tmp_twBryzzxRemodelSubs[k].zxflag==1){
										a = a + '<button type="button" class="btn btn-success zxTime" data-toggle="modal" data-target="#moduleModal" style="margin:0 0 0 2%;" id="' 
											+ tmp_twBryzzxRemodelSubs[k].rowkey +'">'
											+ tmp_twBryzzxRemodelSubs[k].sjd + '</button>';
									}else{
										a = a + '<button type="button" class="btn btn-primary moduleTime" data-toggle="modal" data-target="#moduleModal" style="margin:0 0 0 2%;" id="'
											+ tmp_twBryzzxRemodelSubs[k].rowkey +'">'
											+ tmp_twBryzzxRemodelSubs[k].sjd + '</button>';
									}
									a = a + '<input value="yzmc_' + i + '" style="display:none;"/>';
									
									a = a + '<input value="' + vyzrq1 + '" style="display:none;"/>';
									a = a + '<input value="' + tmp_twBryzzxRemodelSubs[k].crlflag + '" style="display:none;"/>';
									a = a + '<input value="' + tmp_twBryzzxRemodelSubs[k].crl + '" style="display:none;"/>';
									a = a + '</div>';
								}
								a = a + '</div></div>';
							}
						}else{
							a = "无数据！";
						} 
						 $("#accordion")[0].innerHTML = a; 
						 $("#dropdownMenu1")[0].innerHTML = val_text + '<span class="caret"></span>';
						 document.getElementById("saowandai").focus();
					})
		}
</script>
</head>
<body>
	<%@ include file="header-bingren.jsp"%>
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
					<input type="text" class="form-control" id="saowandai" placeholder="扫描" onfocus="javascript:this.value='';" oninput="myFunction()"/>
<!-- 						placeholder="扫描" onfocus="javascript:return false;" oninput="myFunction()"/> --> 
					<span class="input-group-btn" style="display:none;">
						<button class="btn btn-default" type="button" id="chacw">查</button>
					</span>
				</div>
			</div>
			<div class="col-xs-4" id="prompt1" style="display:none;">
		   		<%-- <span style="padding-left: 5px; margin-right: 14px; font-size: 12px; color: #f9590d;">对应扫描病人</span> --%>
		   		<span class="label label-success">成功对应病人</span>
		   	</div>
			<div class="col-xs-4" id="prompt2" style="display:none;">
		   		<%-- <span style="padding-left: 5px; margin-right: 14px; font-size: 12px; color: #f9590d;">对应扫描病人</span> --%>
		   		<span class="label label-warning">对应病人失败</span>
		   	</div>
			<div class="col-xs-4" id="prompt3" style="display:none;">
		   		<%-- <span style="padding-left: 5px; margin-right: 14px; font-size: 12px; color: #f9590d;">对应扫描病人</span> --%>
		   		<span class="label label-danger">无对应医嘱</span>
		   	</div>
			<div class="col-xs-4" id="prompt4" style="display:none;">
		   		<%-- <span style="padding-left: 5px; margin-right: 14px; font-size: 12px; color: #f9590d;">对应扫描病人</span> --%>
		   		<span class="label label-danger">无对应时间点</span>
		   	</div>
		</div>
	</div>
	<div id="content_b" class="container">
		<div class="panel-group" id="accordion" style="z-index:-100">
		<s:iterator value="#request.bingrGeTi_YiZhu_zhixing"  status ="status">
<%-- 			<div class="row module" id="yzmc_<s:property value="#status.index"/>"> 
			<div class="row module ${groupxh}" id="<s:date name="rq" format="yyyyMMdd"/>-${groupxh}"> --%>
			<div class="row module ${groupxh}" id="yzmc_<s:property value="#status.index"/>">
				<s:iterator value="yzmcs" id="mc_yz">
					<div class="col-xs-12" >
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
			<div class="row"
				style="border-bottom: 2px solid #333333;padding-bottom: 10px;margin-bottom: 10px;">
				<div class="col-xs-12">
					<s:iterator value="twBryzzxRemodelSubs" >
						<div class="btn-group" data-toggle="buttons">
							<input value="${groupxh }" style="display:none;"/>
							<s:if test="zxflag==1">
								<button type="button" class="btn btn-success zxTime" data-toggle="modal" data-target="#moduleModal" id="${rowkey }">${sjd}</button> 
							</s:if>
							<s:else>
								<button type="button" class="btn btn-primary moduleTime" data-toggle="modal" data-target="#moduleModal" id="${rowkey }">${sjd}</button>
							</s:else>
							<input value="yzmc_<s:property value="#status.index"/>" style="display:none;"/>
							<input value="${rq}" style="display:none;"/>
							<input value="${crlflag}" style="display:none;"/>
							<input value="${crl}" style="display:none;"/>
						</div>
					</s:iterator>
				</div>
			</div>
		</s:iterator>
		</div>
		<div class="clear"></div>
		<%@ include file="menu-hushi.jsp" %>
	</div>
	
	<!--页脚开始-->
	<%@ include file="footer.jsp" %>
	<!--页脚结束-->
	
	<!-- 20160926 by shen 模态框（Modal）start -->
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
					<div class="modal-footer" id="modfooter" style="margin-top: 0;padding-top: 2%;">
						<button type="button" class="btn pull-left btn-primary" id="ensure">
							确定
						</button>
						<button type="button" id="quxiao" class="btn btn-default" data-dismiss="modal">
							取消
						</button>
					</div>
				</div>
			</div>
		</div>
		<!-- 模态框（Modal）end -->
		
	<script type="text/javascript" src="scripts/bootstrap.min.js"></script>
</body>
</html>