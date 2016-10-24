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
		<title>体征录入</title>
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
				$('.clockpicker').clockpicker();
			});
			$(document).ready(function() {
				$("#baocun").click(function() {
					$("#lurutime").attr('value', $("#appTime1").val());
					var luruone = $("input:eq(2)").val();  /* 取第三个input的value值 前两个是时间input 第二个是隐藏的input */
					var luruone = luruone.trim();
					if(luruone!=""){
						var url = "tizheng_luru_update";
						var args = $('#tzform').serialize();
						$.post(url,args,function(data) {
							if(data=="0"){
								$("#tip").html("保存成功！");
								$("#baocun").attr("disabled","true");
								$("#content").css("top","0px");
								$("#jianpan1").hide();
								$("#jianpan").hide();
							}else{
								$("#tip").css('color','#FF0000');
								$("#tip").html("保存失败！");
							}
						});
					}else{
						$("#tip").css('color','#FF9800');
						$("#tip").html("没有数据！");
					}
				});
			});
			
			$(function() {
				$(document).ready(function() {
					$("#tw_baocun").click(function() {
							var val_twlx = $("#twlx_select").val();
							var val_wendu = $("#tw_wendu").val();
							var val_jwhwendu = $("#tw_jwhwendu").val();
							var val_maibo = $("#tw_maibo").val();
							var val_xinlv = $("#tw_xinlv").val();
							var val_huxi = $("#tw_huxi").val();
							if (val_wendu == ""||val_jwhwendu==""||val_maibo==""||val_xinlv==""||val_huxi=="") {
								alert("数据不完整！");
							} else {
								var val_rcbz = $("#tw_rcbz").val();
								var val_time2 = $("#appTime2").val();
								var val_time1 = $("#appTime1").val();
								var url = "tizheng_luru_tiwen";
								var args = {
									"v_twlx": val_twlx,
									"v_wendu": val_wendu,
									"v_jwhwendu": val_jwhwendu,
									"v_maibo": val_maibo,
									"v_xinlv": val_xinlv,
									"v_huxi": val_huxi,
									"v_rcbz": val_rcbz,
									"v_time2": val_time2,
									"v_time1": val_time1
								};
								$.post(url, args, function(data) {
									if (data == "0") {
										$("#quxiao").click();
										$("#tiwen").attr('value', '录入成功！').css('color', 'red');
									} else {
										//若data 的返回值不是1，则提示删除失败
										alert("保存失败！");
									}
								});
							}
						})
				})
			});
		</script>
		<link href="css/mobiscroll_002.css" rel="stylesheet" type="text/css">
		<link href="css/mobiscroll_003.css" rel="stylesheet" type="text/css">
		<script src="scripts/mobiscroll_002.js" type="text/javascript"></script>
		<script src="scripts/mobiscroll_004.js" type="text/javascript"></script>
		<script src="scripts/mobiscroll.js" type="text/javascript"></script>
		<script src="scripts/mobiscroll_003.js" type="text/javascript"></script>
		<script src="scripts/mobiscroll_005.js" type="text/javascript"></script>
		<script src="scripts/index-song.js" type="text/javascript"></script>
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
				<div class="col-xs-5">
					<div class="demos">
						<input value="" class="form-control" name="chajiantime" id="appTime1" type="text" placeholder="">
					</div>
				</div>
				<div class="col-xs-4 text-center" id="tip" style="margin-top: 2%; color: #2196F3;font-size: 14px;"></div>
				<div class="col-xs-3" style="float:right;" id="bcdiv">
					<button class="btn btn-default" role="button" id="baocun" style="margin-left: 20%;">保存</button>
				</div>
			</div>
		</div>

		<div id="content" class="container">

			<form class="form-horizontal" action="" method="post" id="tzform">
				<input name="appTime" value="" style="display:none;" id="lurutime" />
				<s:set name="popcount" value="1"></s:set>
				<s:iterator value="#request.bingr_tizheng_luruxiang" status='st'>
				<div class="form-group" style="margin-bottom: 1%; margin-top: 1%;">
					<s:if test="xmid=='XY'">
						<small class="col-xs-2 control-label text-center" style="padding:2% 0 0 0;">${xmmc }</small>
						<div class="col-xs-3" style="padding-right: 0;">
							<input type="text" maxlength="7" readonly="readonly" mainpop="<s:property value='#popcount'/>" class="form-control"
								id="xueya" placeholder="收缩压" name="zhi1" style="padding: 2%;">
								<s:set name="popcount" value="#popcount+1"></s:set>
						</div>
						<div class="col-xs-1" style="padding:2% 0 0 3%;">/</div>
						<div class="col-xs-3" style="padding: 0;">
							<input type="text" maxlength="7" readonly="readonly" class="form-control" mainpop="<s:property value='#popcount'/>" class="form-control" id="xueya2" placeholder="舒张压" name="zhi2" style="padding: 2%;">
							<s:set name="popcount" value="#popcount+1"></s:set>
						</div>
						<div class="col-xs-3" style="padding:2% 0 0 2%;">${dw}</div>
						<input name="xiangmu" style="display:none;" value="${xmid }">
						<input name="bzflag" style="display:none;" value="${bzflag}">
						<input name="biaozhu" style="display:none;" value="">
					</s:if>
					<s:elseif test="xmid=='TW'">
						<small class="col-xs-2 control-label text-center" style="padding:2% 0 0 0;">${xmmc}</small>
						<div class="col-xs-10">
							<input type="text" class="form-control" id="tiwen" data-backdrop="static" data-toggle="modal" readonly="readonly"
								data-target="#temperature" placeholder="${xmmc }" style="padding: 2%;">
						</div>
						<input name="xiangmu" style="display:none;" value="${xmid }">
						<input name="zhi1" style="display:none;" value="">
						<input name="zhi2" style="display:none;" value="">
						<input name="biaozhu" style="display:none;" value="">
						<input name="bzflag" style="display:none;" value="${bzflag}">
					</s:elseif>
					<s:elseif test="bzflag==1">
						<small class="col-xs-2 control-label text-center" style="padding:2% 0 0 0;">${xmmc }</small>
						<div class="col-xs-3" style="padding-right: 0;">
							<input type="text" maxlength="8" class="form-control"
								readonly="readonly" mainpop="<s:property value='#popcount'/>" placeholder="${xmmc }" name="zhi1" style="padding: 2%;">
								<s:set name="popcount" value="#popcount+1"></s:set>
						</div>
						<div class="col-xs-1" style="padding:2% 0 0 2%;">${dw}</div>
						<div class="col-xs-6" style="padding-left: 0;">
							<input type="text" maxlength="10" nopop="true" class="form-control" placeholder="标注" name="biaozhu" style="padding: 2%;">
						</div>
						<input name="xiangmu" style="display:none;" value="${xmid }">
						<input name="zhi2" style="display:none;" value="">
						<input name="bzflag" style="display:none;" value="${bzflag}">
					</s:elseif>
					<s:else>
						<small class="col-xs-2 control-label text-center"
							style="padding:2% 0 0 0;">${xmmc }</small>
						<div class="col-xs-10">
							<input type="text" readonly="readonly"
								mainpop="<s:property value='#popcount'/>" class="form-control" placeholder="${xmmc }" name="zhi1" style="padding: 2%;">
								<s:set name="popcount" value="#popcount+1"></s:set>
						</div>
						<input name="xiangmu" style="display:none;" value="${xmid }">
						<input name="zhi2" style="display:none;" value="">
						<input name="biaozhu" style="display:none;" value="">
						<input name="bzflag" style="display:none;" value="${bzflag}">
					</s:else>
				</div>
				</s:iterator>
			</form>
			<!--导航结束-->
			<div class="clear"></div>
			<%@ include file="menu-hushi.jsp" %> 
		</div>
		<!--页脚开始-->
		<%@ include file="footer.jsp" %>
		<!--页脚结束-->

		<!--页脚结束-->
		<!--新加模态框 start-->
		<div class="modal fade" id="temperature" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" id="modal-wrap" style="width:88%">
				<div class="modal-content">
					<div class="modal-header" style="padding:2%;">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabel">体温录入项</h4>
					</div>
					<!-- 模态框body start-->
					<div class="modal-body" style="padding:2%;">
						<form role="form" class="form-horizontal">
							<div class="form-group" style="margin-bottom: 2%;">
								<label class="col-xs-4 control-label text-right" style="padding:2% 2% 0 2%;">体温类型</label>
								<div class="col-xs-8">
									<select class="form-control" id="twlx_select">
										<s:iterator value="#request.tiwen_leixing" status='st'>
											<option value="${dm }">${mc }</option>
										</s:iterator>
									</select>
								</div>
							</div>
							<div class="form-group" style="margin-bottom: 2%;">
								<label class="col-xs-4 control-label text-right" style="padding:2% 2% 0 2%;">温度</label>
								<div class="col-xs-6">
									<input type="text" readonly="readonly" pop="1" class="form-control du" placeholder="温度" id="tw_wendu">
								</div>
								<div class="col-xs-2" style="padding:2% 0 0;">℃</div>
							</div>
							<div class="form-group" style="margin-bottom: 2%;">
								<label class="col-xs-4 control-label text-right" style="padding:2% 2% 0 2%;">降温后温度</label>
								<div class="col-xs-6">
									<input type="text" readonly="readonly" pop="2" class="form-control du" placeholder="降温后温度" id="tw_jwhwendu">
								</div>
								<div class="col-xs-2" style="padding:2% 0 0;">℃</div>
							</div>
							<div class="form-group" style="margin-bottom: 2%;">
								<label class="col-xs-4 control-label text-right" style="padding:2% 2% 0 2%;">脉搏</label>
								<div class="col-xs-6">
									<input type="text" readonly="readonly" pop="3" class="form-control ci" placeholder="脉搏" id="tw_maibo">
								</div>
								<div class="col-xs-2" style="padding:2% 0 0;">次</div>
							</div>
							<div class="form-group" style="margin-bottom: 2%;">
								<label class="col-xs-4 control-label text-right" style="padding:2% 2% 0 2%;">心率</label>
								<div class="col-xs-6">
									<input type="text" readonly="readonly" pop="4" class="form-control ci" placeholder="心率" id="tw_xinlv">
								</div>
								<div class="col-xs-2" style="padding:2% 0 0;">次</div>
							</div>
							<div class="form-group" style="margin-bottom: 2%;">
								<label class="col-xs-4 control-label text-right" style="padding:2% 2% 0 2%;">呼吸</label>
								<div class="col-xs-6">
									<input type="text" readonly="readonly" pop="5" class="form-control ci" placeholder="呼吸" id="tw_huxi">
								</div>
								<div class="col-xs-2" style="padding:2% 0 0;">次</div>
							</div>
							<div class="form-group" style="margin-bottom: 2%;">
								<label class="col-xs-4 control-label text-right" style="padding:2% 2% 0 2%;">入出标注</label>
								<div class="col-xs-8">
									<select class="form-control" id="tw_rcbz">
										<option value="0">无</option>
										<s:iterator value="#request.tiwen_rcbz" status='st'>
											<option value="${dm }">${mc }</option>
										</s:iterator>
									</select>
								</div>
							</div>
							<div class="form-group" style="margin-bottom: 2%;">
								<label class="col-xs-4 control-label  text-right" style="padding:2% 2% 0 2%;">入出时间</label>
								<div class="col-xs-8">
									<div class="demos">
										<input value="" class="form-control" name="appTime" id="appTime2" type="text">
									</div>
								</div>
							</div>
						</form>
					</div>
					<!-- 模态框body end-->
					<div class="modal-footer">
						<button type="button" class="btn pull-left btn-primary" id="tw_baocun">保存</button>
						<button type="button" id="quxiao" class="btn btn-default" data-dismiss="modal">取消</button>
					</div>
				</div>
			</div>
		</div>
		<!-- 模态框 end-->
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
				<div class="col-xs-1" class="caret" style="padding: 1% 0;">
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
				<div class="col-xs-2 text-center" style="padding: 1% 0; ">
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