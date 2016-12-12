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
		<base href="<%=basePath%>">
		<title>体温录入数据修改</title>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="SHORTCUT ICON" href="images/favicon.ico">
		<link rel="icon" href="images/favicon.ico" type="image/x-icon">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="author" content="融汇国康" />
		<meta name="keywords" content="移动护理信息系统" />
		<meta name="description" content="病人体征录入,高大上的移动护理系统。" />
		<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />		
		<link rel="stylesheet" type="text/css" href="css/song.css"/>
		<link href="css/base.css" rel="stylesheet" type="text/css" />
		<link href="css/bootstrap-clockpicker.min.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="scripts/jquery-1.12.1.min.js"></script>
		<script src="scripts/song.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="scripts/bootstrap-clockpicker.min.js"></script>
		<script type="text/javascript" src="scripts/bootstrap.min.js"></script>
		<script type="text/javascript" src="scripts/viewjs.js"></script>
		<script type="text/javascript">	
			String.prototype.trim=function() {
	    		return this.replace(/(^\s*)|(\s*$)/g,'');
			};
			$(function(){
				var url = "weiduxiaoxishu";
				$.post(url,function(data) {
					if(data!=""){
						$("#xxshu").text(data+"");
					};		
				});
			});
		</script>
		
		<script type="text/javascript">
			$(function() {
				// 绑定
				$("#head_banner_1").smartFloat();	
				
				$('.clockpicker').clockpicker();
				
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

				$("#appTime1").attr('value',$("#sjvalue").val())
				
			});
			
			$(document).ready(function() {
				$("#baocun").click(function() {
					$("#sjvalue").attr('value', $("#appTime1").val());
					var url = "tizhengtw_data_modi";
					var args = $('#temperature').serialize();
					$.post(url,args,function(data) {
						if(data=="0"){
							$("#tip").html("修改成功！");
							$("#baocun").attr("disabled","true");
							$("#content").css("top","0px");
							$("#jianpan1").hide();
							$("#jianpan").hide();
						}else{
							$("#tip").css('color','#FF0000');
							$("#tip").html("修改失败！");
						}
					});
				});
			});
		</script>
		
		<link href="css/mobiscroll_002.css" rel="stylesheet" type="text/css">
		<link href="css/mobiscroll_003.css" rel="stylesheet" type="text/css">
		<script src="scripts/mobiscroll_002.js" type="text/javascript"></script>
		<script src="scripts/mobiscroll_004.js" type="text/javascript"></script>
		<script src="scripts/mobiscroll.js" type="text/javascript"></script>
		<script src="scripts/mobiscroll_003.js" type="text/javascript"></script>
		<script src="scripts/mobiscroll_005.js" type="text/javascript"></script>
		<script src="scripts/index-song-shen.js" type="text/javascript"></script>
	</head>
	<body>
		<div id="head_banner_1" style="z-index:2000;" class="bg-info navbar-fixed-top">
			<div class="row" style="border-bottom:1px solid #269abc;padding-top: 3px; margin: 0;">
				<s:if test="#session.bingrgetixingxi_yinger!=null">
					<div class="col-xs-3 " style="margin-left: -2%; color: #807D7D; padding-left:13px; padding-right: 0;">
						<strong style="color: #272626;">${bingrgetixingxi.xm }</strong>
						<p class="text-left " style="margin-bottom: 0; ">${bingrgetixingxi.chw }床&nbsp;${bingrgetixingxi.nl }</p>
					</div>
					<div class="col-xs-3" style="margin: 0 1%; padding: 0 0; font-size: 14px; color: #428CF7; line-height: 40px; ">
					${bingrgetixingxi_yinger.yexm }
					</div>
				</s:if>
				<s:else>
					<div class="col-xs-6" style="margin-left: -2%; color: #807D7D; padding-left:13px; padding-right: 0;">
						<strong style="color: #272626;">${bingrgetixingxi.xm }</strong>
						<p class="text-left " style="margin-bottom: 0; ">${bingrgetixingxi.chw }床&nbsp;${bingrgetixingxi.nl }</p>
					</div>
				</s:else>
				<div class="col-xs-6 " style=" padding: 0 1% 0 0;">
					<div class="table table-responsive " style="margin-bottom: 0;border: none; ">
						<table class="table table-condensed " style="background-color: #d9edf7 ">
							<tbody>
								<tr>
									<td style="border: none; width: 25%; padding: 2px;  position: relative;">
										<a href="mymessage?pageno=1" style="display: block;">
											<span style="display: block;text-align: center;color: #fff;font-size: 2rem;position: absolute;left: 0;width: 90%;height: 90%;border-radius: 60%;background-color: green;padding-top: 10%;" id="xxshu"></span>
										</a>
									</td>
									<td style="border: none; padding: 2px;">
										<a href="${action_name }" class="text-center "> <img src="images/brxxxx_header_2.png " class="img-responsive " alt="刷新 " /> </a>
									</td>
									<td style="border: none; padding: 2px;">
										<a href="bingqbr_bysessionbingqid" class="text-center "> <img src="images/brxxxx_header_3.png " class="img-responsive " alt="病人列表 " /> </a>
									</td>
									<td style="border: none; padding: 2px;">
										<a href="bingreng_yewumokuai?v_key1=${bingrgetixingxi.key1 }&v_key2=${bingrgetixingxi.key2}" class="text-center"> <img src="images/brxxxx_header_4.png" class="img-responsive" alt="业务模块">
										</a>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-4">
					<!-- <div class="demos">
						<input value="" class="form-control" name="chajiantime" id="appTime1" type="text" placeholder="">
					</div> -->
				</div>
				<div class="col-xs-4 text-center" id="tip" style="margin-top: 2%; color: #2196F3;font-size: 14px;"></div>
				<div class="col-xs-4" style="float:right;" id="bcdiv">
					<button class="btn btn-default" role="button" id="baocun" style="margin-left: 10%;">修改保存</button>
				</div>
			</div>
		</div>

		<div id="content" class="container">

			<form role="form" class="form-horizontal" id="temperature">
				<input value="<s:property value='#request.twtzdatatw_xiansi.jlid'/>" style="display:none;" name="jlid">
				<div class="form-group" style="margin-bottom: 1%;margin-top: 1%;">
					<label class="col-xs-4 control-label text-right" style="padding:2% 2% 0 2%;">时间</label>
					<div class="col-xs-8">
						<input value="" class="form-control" name="v_time1" id="appTime1" type="text" placeholder=""
							style="background-color: #aba9a9;color: white;">
					</div>
					<input value="<s:property value='#request.twtzdatatw_xiansi.sj'/>" style="display:none;" id="sjvalue">
				</div>
			
				<div class="form-group" style="margin-bottom: 1%;">
					<label class="col-xs-4 control-label text-right" style="padding:2% 2% 0 2%;">体温类型</label>
					<div class="col-xs-8">
						<s:set value="#request.twtzdatatw_xiansi.twLx" name="twlxcheck"></s:set>
						<select class="form-control" id="twlx_select" name="v_twlx">
							<s:iterator value="#request.tiwen_leixing" status='st'>
								<s:if test="dm==#twlxcheck">
									<option value="${dm }" selected = "selected">${mc }</option>
								</s:if>
								<s:else>
									<option value="${dm }" >${mc }</option>
								</s:else>
							</s:iterator>
						</select>
					</div>
				</div>
				<div class="form-group" style="margin-bottom: 1%;">
					<label class="col-xs-4 control-label text-right" style="padding:2% 2% 0 2%;">温度</label>
					<div class="col-xs-6">
						<input type="text" readonly="readonly" 
							pop="1" class="form-control du" id="tw_wendu" value="<s:property value='#request.twtzdatatw_xiansi.twTw' />" name="v_wendu">
					</div>
					<div class="col-xs-2" style="padding:2% 0 0;">℃</div>
				</div>
				<div class="form-group" style="margin-bottom: 1%;">
					<label class="col-xs-4 control-label text-right" style="padding:2% 2% 0 2%;">降温后温度</label>
					<div class="col-xs-6">
						<input type="text" readonly="readonly" 
							pop="2" class="form-control du" id="tw_jwhwendu" value="<s:property value='#request.twtzdatatw_xiansi.twTwJwh' />" name="v_jwhwendu">
					</div>
					<div class="col-xs-2" style="padding:2% 0 0;">℃</div>
				</div>
				<div class="form-group" style="margin-bottom: 1%;">
					<label class="col-xs-4 control-label text-right" style="padding:2% 2% 0 2%;">脉搏</label>
					<div class="col-xs-6">
						<input type="text" readonly="readonly" 
							pop="3" class="form-control ci" id="tw_maibo" value="<s:property value='#request.twtzdatatw_xiansi.twMb' />" name="v_maibo">
					</div>
					<div class="col-xs-2" style="padding:2% 0 0;">次</div>
				</div>
				<div class="form-group" style="margin-bottom: 1%;">
					<label class="col-xs-4 control-label text-right" style="padding:2% 2% 0 2%;">心率</label>
					<div class="col-xs-6">
						<input type="text" readonly="readonly" 
							pop="4" class="form-control ci" id="tw_xinlv" value="<s:property value='#request.twtzdatatw_xiansi.twXl' />" name="v_xinlv">
					</div>
					<div class="col-xs-2" style="padding:2% 0 0;">次</div>
				</div>
				<div class="form-group" style="margin-bottom: 1%;">
					<label class="col-xs-4 control-label text-right" style="padding:2% 2% 0 2%;">呼吸</label>
					<div class="col-xs-6">
						<input type="text" readonly="readonly" 
							pop="5" class="form-control ci" id="tw_huxi" value="<s:property value='#request.twtzdatatw_xiansi.twHx' />" name="v_huxi">
					</div>
					<div class="col-xs-2" style="padding:2% 0 0;">次</div>
				</div>
				<div class="form-group" style="margin-bottom: 1%;">
					<label class="col-xs-4 control-label text-right" style="padding:2% 2% 0 2%;">入出标注</label>
					<div class="col-xs-8">
						<s:set value="#request.twtzdatatw_xiansi.twRcbz" name="twRcbzcheck"></s:set>
						<select class="form-control" id="tw_rcbz" name="v_rcbz" >
							<option value="0">无</option>
							<s:iterator value="#request.tiwen_rcbz" status='st'>
								<s:if test="dm==#twRcbzcheck">
									<option value="${dm }" selected = "selected">${mc }</option>
								</s:if>
								<s:else>
									<option value="${dm }" >${mc }</option>
								</s:else>
							</s:iterator>
						</select>
					</div>
				</div>
				<div class="form-group" style="margin-bottom: 1%;">
					<label class="col-xs-4 control-label  text-right" style="padding:2% 2% 0 2%;">入出时间</label>
					<div class="col-xs-8">
						<div class="demos">
							<input value="<s:property value='#request.twtzdatatw_xiansi.twRcsj' />" class="form-control" name="v_time2" id="appTime2" type="text">
						</div>
					</div>
				</div>
			</form>
			<!--导航结束-->
			<div class="clear"></div>
			<%@ include file="menu-hushi.jsp" %> 
		</div>
		<!--页脚开始-->
		<%@ include file="footer.jsp" %>
		<!--页脚结束-->

		<!-- 键盘 start-->
		<div class="container navbar-fixed-bottom jianpan" id="jianpan">           
			<div class="row bg-primary">
				<div class="col-xs-5 text-left" style="padding: 1% 0 0 2.5%;">
					<a href="javascript:void(0)" style="color: #000;">数字</a>
				</div>
				<div class="col-xs-3 text-center prev" style="padding: 1% 0;">
					<a href="javascript:void(0)" style="color: #fff;">上一项</a>
				</div>
				<div class="col-xs-3 text-center next" style="padding: 1% 0;">
					<a href="javascript:void(0)" style="color: #fff;">下一项</a>
				</div>
				<div class="col-xs-1" class="caret" style="padding: 1% 0;text-align: center;">
					<a href="javascript:void(0)" class="caret" style="color: #fff;"></a>
				</div>
			</div>
							
			<!--7.13修改（431行添加id、448和454行添加class和修改文字）-->
			<div class="row" style="padding:0 1%; background-color: #C2BEC0;" id="number">    
				<div style="padding:0 .5%;">
					<button type="button" class="btn btn-default" value="1">1</button>
					<button type="button" class="btn btn-default" value="2">2</button>
					<button type="button" class="btn btn-default" value="3">3</button>
					<button type="button" class="btn btn-info" style="color: #000;" operation="reduce">←</button>
				</div>
				<div style="padding:0 .5%;">
					<button type="button" class="btn btn-default" value="4">4</button>
					<button type="button" class="btn btn-default" value="5">5</button>
					<button type="button" class="btn btn-default" value="6">6</button>
					<button type="button" id="del" class="btn btn-info" style="color: #000;" operation="del">Del</button>
				</div>
				<div style="padding:0 .5%;">
					<button type="button" class="btn btn-default" value="7">7</button>
					<button type="button" class="btn btn-default" value="8">8</button>
					<button type="button" class="btn btn-default" value="9">9</button>
					<button type="button" class="btn btn-info numberBtn" style="color: #000;">数字</button>
				</div>
				<div style="padding:0 .5%; margin-bottom: 1.5%;">
					<button type="button" class="btn btn-info" style="color: #000;" value=".">.</button>
					<button type="button" class="btn btn-default" value="0">0</button>
					<button type="button" class="btn btn-default" value="00">00</button>
					<button type="button" class="btn btn-info characterBtn" style="color: #000;">字符</button>
				</div>
			</div>
			
			<!--7.13增加（特殊字符键盘）-->
			<div class="row" style="padding:0 1%; background-color: #C2BEC0;" id="character">
				<div style="padding:0 .5%;">
					<button type="button" class="btn btn-default" value="※ ">※</button>
					<button type="button" class="btn btn-default" value="☆">☆</button>
					<button type="button" class="btn btn-default" value="g">g</button>
					<button type="button" class="btn btn-info" style="color: #000;" operation="reduce">←</button>
				</div>
				<div style="padding:0 .5%;">
					<button type="button" class="btn btn-default" value="R">R</button>
					<button type="button" class="btn btn-default" value="C">C</button>
					<button type="button" class="btn btn-default" value="C＋">C＋</button>
					<button type="button" id="del" class="btn btn-info" style="color: #000;" operation="del">Del</button>
				</div>
				<div style="padding:0 .5%;">
					<button type="button" class="btn btn-default" value="/E">/E</button>
					<button type="button" class="btn btn-default" value="0/E">0/E</button>
					<button type="button" class="btn btn-default" value="1/E">1/E</button>
					<button type="button" class="btn btn-info numberBtn" style="color: #000;">数字</button>
				</div>
				<div style="padding:0 .5%; margin-bottom: 1.5%;">
					<button type="button" class="btn btn-info" style="color: #000;" value="卧床">卧床</button>
					<button type="button" class="btn btn-default" value="0">0</button>
					<button type="button" class="btn btn-default" value="/">/</button>
					<button type="button" class="btn btn-info characterBtn" style="color: #000;">字符</button>
				</div>
			</div>
		</div>
		<!-- 键盘 end-->
		<!-- 键盘1 start-->
		<div class="container navbar-fixed-bottom jianpan" id="jianpan1">
			<div class="row bg-primary">
				<div class="col-xs-2 text-left" style="padding: 1% 0 0 2.5%;">
					<a href="javascript:void(0)" style="color: #000;">数字</a>
				</div>
				<div class="col-xs-3 text-left" style="padding: 1% 0 0 2.5%;">
					<a href="javascript:void(0)" style="color: #fff;">快速</a>
				</div>
				<div class="col-xs-3 text-center prev" style="padding: 1% 0; ">
					<a href="javascript:void(0)" style="color: #fff;">上一项</a>
				</div>
				<div class="col-xs-2 text-center next" style="padding: 1% 0; ">
					<a href="javascript:void(0)" style="color: #fff;">下一项</a>
				</div>
				<div class="col-xs-2 text-center" style="padding: 1% 0; text-align: center;">
					<a href="javascript:void(0)" class="caret" style="color: #fff;"></a>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-4" id="jianpan-left" style="padding:0 1% .5% 1%; background-color: #EEE; ">
					<div style="padding:0 .5%;">
						<button type="button" class="btn btn-default" value="35.">35.</button>
						<button type="button" class="btn btn-default" value="36.">36.</button>
					</div>
					<div style="padding:0 .5%;">
						<button type="button" class="btn btn-default" value="37.">37.</button>
						<button type="button" class="btn btn-default" value="38.">38.</button>
					</div>
					<div style="padding:0 .5%;">
						<button type="button" class="btn btn-default" value="39.">39.</button>
						<button type="button" class="btn btn-default" value="40.">40.</button>
					</div>
					<div style="padding:0 .5%; margin-bottom: 1.5%;">
						<button type="button" class="btn btn-default" value="41.">41.</button>
						<button type="button" class="btn btn-default" value="42.">42.</button>
					</div>
				</div>
				<!--7.13修改（543和549行添加class和修改文字）-->
				<div class="col-xs-8" id="jianpan-right1" style="padding:0 1%; background-color: #C2BEC0; ">
					<div style="padding:0 .5%;">
						<button type="button" class="btn btn-default" value="1">1</button>
						<button type="button" class="btn btn-default" value="2">2</button>
						<button type="button" class="btn btn-default" value="3">3</button>
						<button type="button" class="btn btn-info" style="color: #000;" operation="reduce">←</button>
					</div>
					<div style="padding:0 .5%;">
						<button type="button" class="btn btn-default" value="4">4</button>
						<button type="button" class="btn btn-default" value="5">5</button>
						<button type="button" class="btn btn-default" value="6">6</button>
						<button type="button" class="btn btn-info" style="color: #000;" operation="del">Del</button>
					</div>
					<div style="padding:0 .5%;">
						<button type="button" class="btn btn-default" value="7">7</button>
						<button type="button" class="btn btn-default" value="8">8</button>
						<button type="button" class="btn btn-default" value="9">9</button>
						<button type="button" class="btn btn-info numberBtn1" style="color: #000;">数字</button>
					</div>
					<div style="padding:0 .5%; margin-bottom: 1.5%;">
						<button type="button" class="btn btn-info" style="color: #000;" value=".">.</button>
						<button type="button" class="btn btn-default" value="0">0</button>
						<button type="button" class="btn btn-default" value="00">00</button>
						<button type="button" class="btn btn-info characterBtn1" style="color: #000;">字符</button>
					</div>
				</div>
				<!--7.13增加（特殊字符键盘）-->
				<div class="col-xs-8" id="jianpan-right2" style="padding:0 1%; background-color: #C2BEC0; ">
					<div style="padding:0 .5%;">
						<button type="button" class="btn btn-default" value="1">※</button>
						<button type="button" class="btn btn-default" value="☆">☆</button>
						<button type="button" class="btn btn-default" value="g">g</button>
						<button type="button" class="btn btn-info" style="color: #000;" operation="reduce">←</button>
					</div>
					<div style="padding:0 .5%;">
						<button type="button" class="btn btn-default" value="R">R</button>
						<button type="button" class="btn btn-default" value="C">C</button>
						<button type="button" class="btn btn-default" value="C＋">C＋</button>
						<button type="button" class="btn btn-info" style="color: #000;" operation="del">Del</button>
					</div>
					<div style="padding:0 .5%;">
						<button type="button" class="btn btn-default" value="/E">/E</button>
						<button type="button" class="btn btn-default" value="0/E">0/E</button>
						<button type="button" class="btn btn-default" value="1/E">1/E</button>
						<button type="button" class="btn btn-info numberBtn1" style="color: #000;">数字</button>
					</div>
					<div style="padding:0 .5%; margin-bottom: 1.5%;">
						<button type="button" class="btn btn-info" style="color: #000;" value="卧床">卧床</button>
						<button type="button" class="btn btn-default" value="0">0</button>
						<button type="button" class="btn btn-default" value="/">/</button>
						<button type="button" class="btn btn-info characterBtn1" style="color: #000;">字符</button>
					</div>
				</div>
			</div>
		</div>
		<!-- 键盘1 end-->
	</body>

</html>