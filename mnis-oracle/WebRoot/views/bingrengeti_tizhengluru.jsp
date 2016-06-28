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
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="author" content="沈旭峰" />
		<meta name="keywords" content="移动护理信息系统" />
		<meta name="description" content="病人体征录入,高大上的移动护理系统。" />
		<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />		
		<link rel="stylesheet" type="text/css" href="css/song.css"/>
		<link href="css/base.css" rel="stylesheet" type="text/css" />
		<link href="css/bootstrap-clockpicker.min.css" rel="stylesheet" type="text/css" />
		<script src="scripts/song.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="scripts/jquery-1.12.1.min.js"></script>
		<script type="text/javascript" src="scripts/bootstrap-clockpicker.min.js"></script>
		<script type="text/javascript" src="scripts/bootstrap.min.js"></script>
		<script type="text/javascript" src="scripts/viewjs.js"></script>
		<script type="text/javascript">
			$(function() {
				$('.clockpicker').clockpicker();
			});
			$(document).ready(function() {
				$("#baocun").click(function() {
					$("#lurutime").attr('value', $("#appTime1").val());
					$("#tzform").submit();
				});
			});
			$(function() {
				$(document).ready(function() {
					$("#tw_baocun").click(function() {
							var val_twlx = $("#twlx_select").val();
							var val_wendu = $("#tw_wendu").val();
							if (val_wendu == "") {
								alert("数据不完整！");
							} else {
								var val_jwhwendu = $("#tw_jwhwendu").val();
								var val_maibo = $("#tw_maibo").val();
								var val_xinlv = $("#tw_xinlv").val();
								var val_huxi = $("#tw_huxi").val();
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
									//若	data 的返回值为1，则提示删除成功，则把当前行删除
									if (data == "0") {
										//alert("录入成功！");
										$("#quxiao").click();
										/* $("#tiwen").attr('placeholder','录入成功！').css('color','red'); */
										$("#tiwen").attr('value', '录入成功！').css('color', 'red');
										//$("#tiwen").css('color','#7478F3');
									} else {
										//若data 的返回值不是1，则提示删除失败
										alert("保存失败！");
									}
								});
								//	alert(val_time2);
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
		<link rel="stylesheet" type="text/css" href="css/song.css"/>
		<script src="scripts/song.js" type="text/javascript" charset="utf-8"></script>
	</head>

	<body>

		<div id="head_banner_1" style="z-index:2000;" class="bg-info navbar-fixed-top">
			<div class="row" style="border-bottom:1px solid #269abc;padding-top: 3px; margin: 0;">
				<div class="col-xs-6 " style="margin-left: -2%; margin-right: 2%; color: #807D7D; padding-left:13px; padding-right: 0;">
					<span><strong style="color: #272626;">${bingrgetixingxi.xm }</strong>&nbsp;${bingrgetixingxi.nl }</span>
					<p class="text-left " style="margin-bottom: 5px;">${bingrgetixingxi.chw }&nbsp;床</p>
				</div>
				<div class="col-xs-6 " style=" padding: 1% 1% 0 0;">
					<div class="table table-responsive " style="margin-bottom: 0;border: none; ">
						<table class="table table-condensed " style="background-color: #d9edf7 ">
							<tbody>
								<tr>
									<td style="border: none; width: 25%; padding: 2px;  position: relative;">
									<a href="javascript:void(0);" style="display: block;">
										<div style="position:relative; width:100%; height:100%;  left:0; top:0;">
											<img src="images/brxxxx_header_1.png" style="left:0; top:0;" height="100%" width="100%">
										</div>
										<span style="display: block; text-align: center; color: #fff; font-size: 2.2rem; z-index: 2; position: absolute; top: 12%; left: 0; width:100%; height:100%;">2</span>
									</a>
								</td>
									<td style="border: none; padding: 2px;">
										<a href="javascript:void(0); " class="text-center "> <img src="images/brxxxx_header_2.png " class="img-responsive " alt="刷新 " /> </a>
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
				<div class="col-xs-6">
					<div class="demos">
						<input value="" class="form-control" name="chajiantime" id="appTime1" type="text" placeholder="">
					</div>
				</div>
				<div class="col-xs-3"></div>
				<div class="col-xs-3">
					<a class="btn btn-default" role="button" id="baocun" style="margin-left: 20%;">保存</a>
				</div>
			</div>
		</div>

		<div id="content" class="container">

			<form class="form-horizontal" action="tizheng_luru_update" method="post" id="tzform">
				<input name="appTime" value="" style="display:none;" id="lurutime" />
				
				<s:iterator value="#request.bingr_tizheng_luruxiang" status='st'>
				<div class="form-group" style="margin-bottom: 6px;">
					<s:if test="xmid=='XY'">
						<label class="col-xs-2 control-label text-center" style="padding:2% 2% 0 2%;">${xmmc }</label>
						<div class="col-xs-3" style="padding-right: 0;">
							<input type="text" maxlength="7" readonly="readonly" mainpop="<s:property value='#st.index'/>" class="form-control"
								id="xueya" placeholder="收缩压" name="zhi1">
						</div>
						<div class="col-xs-1" style="padding:2% 0 0 2%;">/</div>
						<div class="col-xs-3" style="padding: 0;">
							<input type="text" maxlength="7" readonly="readonly" class="form-control" id="xueya" placeholder="舒张压" name="zhi2">
						</div>
						<div class="col-xs-3" style="padding:2% 0 0;">${dw}</div>
						<input name="xiangmu" style="display:none;" value="${xmid }">
						<input name="bzflag" style="display:none;" value="${bzflag}">
						<input name="biaozhu" style="display:none;" value="">
					</s:if>
					<s:elseif test="xmid=='TW'">
						<label class="col-xs-2 control-label text-center" style="padding:2% 2% 0 2%;">${xmmc}</label>
						<div class="col-xs-10">
							<input type="text" class="form-control" id="tiwen" data-backdrop="static" data-toggle="modal" readonly="readonly"
								data-target="#temperature" placeholder="${xmmc }" mainpop="<s:property value='#st.index'/>">
						</div>
						<input name="xiangmu" style="display:none;" value="${xmid }">
						<input name="zhi1" style="display:none;" value="">
						<input name="zhi2" style="display:none;" value="">
						<input name="biaozhu" style="display:none;" value="">
						<input name="bzflag" style="display:none;" value="${bzflag}">
					</s:elseif>
					<s:elseif test="bzflag==1">
						<label class="col-xs-2 control-label text-center" style="padding:2% 2% 0 2%;">${xmmc }</label>
						<div class="col-xs-3" style="padding-right: 0;">
							<input type="text" maxlength="8" class="form-control"
								readonly="readonly" mainpop="<s:property value='#st.index'/>" placeholder="${xmmc }" name="zhi1">
						</div>
						<div class="col-xs-1" style="padding:2% 0 0;">${dw}</div>
						<div class="col-xs-6" style="padding-left: 0;">
							<input type="text" maxlength="10" nopop="true" class="form-control" placeholder="标注" name="biaozhu">
						</div>
						<input name="xiangmu" style="display:none;" value="${xmid }">
						<input name="zhi2" style="display:none;" value="">
						<input name="bzflag" style="display:none;" value="${bzflag}">
					</s:elseif>
					<s:else>
						<label class="col-xs-2 control-label text-center"
							style="padding:2% 2% 0 2%;">${xmmc }</label>
						<div class="col-xs-10">
							<input type="text" readonly="readonly"
								mainpop="<s:property value='#st.index'/>" class="form-control" placeholder="${xmmc }" name="zhi1">
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
			<div class="modal-dialog" id="modal-wrap">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabel">体温录入项</h4>
					</div>
					<!-- 模态框body start-->
					<div class="modal-body">
						<form role="form" class="form-horizontal">
							<div class="form-group">
								<label class="col-xs-4 control-label text-right" style="padding:2% 2% 0 2%;">体温类型</label>
								<div class="col-xs-8">
									<select class="form-control" id="twlx_select">
										<s:iterator value="#request.tiwen_leixing" status='st'>
											<option value="${dm }">${mc }</option>
										</s:iterator>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-4 control-label text-right" style="padding:2% 2% 0 2%;">温度</label>
								<div class="col-xs-6">
									<input type="text" readonly="readonly" pop="1" class="form-control du" placeholder="温度" id="tw_wendu">
								</div>
								<div class="col-xs-2" style="padding:2% 0 0;">℃</div>
							</div>
							<div class="form-group">
								<label class="col-xs-4 control-label text-right" style="padding:2% 2% 0 2%;">降温后温度</label>
								<div class="col-xs-6">
									<input type="text" readonly="readonly" pop="2" class="form-control du" placeholder="降温后温度" id="tw_jwhwendu">
								</div>
								<div class="col-xs-2" style="padding:2% 0 0;">℃</div>
							</div>
							<div class="form-group">
								<label class="col-xs-4 control-label text-right" style="padding:2% 2% 0 2%;">脉搏</label>
								<div class="col-xs-6">
									<input type="text" readonly="readonly" pop="3" class="form-control ci" placeholder="脉搏" id="tw_maibo">
								</div>
								<div class="col-xs-2" style="padding:2% 0 0;">次</div>
							</div>
							<div class="form-group">
								<label class="col-xs-4 control-label text-right" style="padding:2% 2% 0 2%;">心率</label>
								<div class="col-xs-6">
									<input type="text" readonly="readonly" pop="4" class="form-control ci" placeholder="心率" id="tw_xinlv">
								</div>
								<div class="col-xs-2" style="padding:2% 0 0;">次</div>
							</div>
							<div class="form-group">
								<label class="col-xs-4 control-label text-right" style="padding:2% 2% 0 2%;">呼吸</label>
								<div class="col-xs-6">
									<input type="text" readonly="readonly" pop="5" class="form-control ci" placeholder="呼吸" id="tw_huxi">
								</div>
								<div class="col-xs-2" style="padding:2% 0 0;">次</div>
							</div>
							<div class="form-group">
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
							<div class="form-group">
								<label class="col-xs-4 control-label  text-right" style="padding:2% 2% 0 2%;">入出时间</label>
								<div class="col-xs-8">
									<div class="demos">
										<input value="16:43" class="form-control" name="appTime" id="appTime2" type="text">
									</div>
								</div>
							</div>
						</form>
					</div>
					<!-- 模态框body end-->
					<div class="modal-footer">
						<button type="button" class="btn pull-left btn-primary" id="tw_baocun">
						保存</button>
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
			<div class="row" style="padding:0 1%; background-color: #C2BEC0;">
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
					<button type="button" class="btn btn-info" value="/" style="color: #000;">╱</button>
				</div>
				<div style="padding:0 .5%; margin-bottom: 1.5%;">
					<button type="button" class="btn btn-info" style="color: #000;" value=".">.</button>
					<button type="button" class="btn btn-default" value="0">0</button>
					<button type="button" class="btn btn-default" value="00">00</button>
					<button type="button" class="btn btn-info" style="color: #000;" operation="hide">↖</button>
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
				<div class="col-xs-4" id="jianpan-left" style="padding:0 1% .5% 1%; background-color: #EEEEEE; ">
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
				<div class="col-xs-8" id="jianpan-right" style="padding:0 1%; background-color: #C2BEC0; ">
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
						<button type="button" class="btn btn-info" style="color: #000;">╱</button>
					</div>
					<div style="padding:0 .5%; margin-bottom: 1.5%;">
						<button type="button" class="btn btn-info" style="color: #000;" value=".">.</button>
						<button type="button" class="btn btn-default" value="0">0</button>
						<button type="button" class="btn btn-default" value="00">00</button>
						<button type="button" class="btn btn-info" style="color: #000;" operation="hide">↖</button>
					</div>
				</div>
			</div>
		</div>
		<!-- 键盘1 end-->
	</body>

</html>