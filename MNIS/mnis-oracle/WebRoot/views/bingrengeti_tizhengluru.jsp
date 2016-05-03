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
<title>病人体征录入</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="沈旭峰" />
<meta name="keywords" content="移动护理信息系统" />
<meta name="description" content="病人体征录入,高大上的移动护理系统。" />
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<link href="css/base.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap-clockpicker.min.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="scripts/jquery-1.12.1.min.js"></script>
<script type="text/javascript"
	src="scripts/bootstrap-clockpicker.min.js"></script>
<script type="text/javascript" src="scripts/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('.clockpicker').clockpicker();
	})
</script>
<!--新加样式start-->
<link href="css/mobiscroll_002.css" rel="stylesheet" type="text/css">
<link href="css/mobiscroll_003.css" rel="stylesheet" type="text/css">
<!--新加样式end-->
<script src="js/common.js" type="text/javascript"></script>
<!--新加js start-->
<script src="js/mobiscroll_002.js" type="text/javascript"></script>
<script src="js/mobiscroll_004.js" type="text/javascript"></script>
<script src="js/mobiscroll.js" type="text/javascript"></script>
<script src="js/mobiscroll_003.js" type="text/javascript"></script>
<script src="js/mobiscroll_005.js" type="text/javascript"></script>
<script src="js/index-song.js" type="text/javascript"></script>
<!--新加js end-->
</head>
<body>
	<div id="head_banner_1" style="z-index:99998;"
		class="bg-info navbar-fixed-top">
		<div class="row"
			style="border-bottom:1px solid #269abc;padding-top: 3px;">
			<div class="col-xs-2" style="padding-right: 2%;">
				<a href="#"> <img src="images/icon-m-man-active.png"
					class="img-responsive" alt="${bingrgetixingxi.xm }">
				</a>
			</div>
			<div class="col-xs-4" style="padding-left: 2%;padding-right: 2%;color: #807D7D;">
				<span><strong style="color: #272626;">${bingrgetixingxi.xm }</strong>&nbsp;${bingrgetixingxi.chw }&nbsp;床</span>
				<p class="text-left" style="margin-bottom: 5px;">${bingrgetixingxi.nl }</p>
			</div>
			<div class="col-xs-6" style="padding-left: 2%;">
				<div class="table table-responsive"
					style="margin-bottom: 0;border: none;">
					<table class="table table-condensed"
						style="background-color: #d9edf7">
						<tr>
							<td><a href="#" class="text-center"> <img
									src="images/brxxxx_header_1.png" class="img-responsive"
									alt="消息数">
							</a></td>
							<td><a href="tizhengluru?v_key1=${bingrgetixingxi.key1}&v_key2=${bingrgetixingxi.key2}" class="text-center"> <img
									src="images/brxxxx_header_2.png" class="img-responsive"
									alt="刷新">
							</a></td>
							<td><a href="bingqbr_bysessionbingqid" class="text-center">
									<img src="images/brxxxx_header_3.png" class="img-responsive"
									alt="病人列表">
							</a></td>
							<td><a
								href="bingreng_yewumokuai?v_key1=${bingrgetixingxi.key1 }&v_key2=${bingrgetixingxi.key2}"
								class="text-center"> <img src="images/brxxxx_header_4.png"
									class="img-responsive" alt="业务模块">
							</a></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		
		<div class="row" style="border-bottom: 1px solid #666;">
			<div class="col-xs-6">
				<div class="demos">
					<input value="请选择录入时间" class="form-control" name="appTime"
						id="appTime1" type="text">
				</div>
			</div>
			<div class="col-xs-3"></div>
			<div class="col-xs-3">
				<a class="btn btn-default" href="#" role="button">保存</a>
			</div>
		</div>
	</div>

	<div id="content" class="container">
		<form class="form-horizontal">
			<div class="form-group">
				<label for="xueya" class="col-xs-2 control-label text-center"
					style="padding:2% 2% 0 2%;">血压</label>
				<div class="col-xs-10">
					<input type="text" maxlength="7" readonly="readonly" mainpop="1"
						class="form-control" id="xueya" placeholder="高压/低压（mmHg）">
				</div>
			</div>
			<div class="form-group">
				<label for="ruliang" class="col-xs-2 control-label text-center"
					style="padding:2% 2% 0 2%;">入量</label>
				<div class="col-xs-4" style="padding-right: 0;">
					<input type="text" maxlength="8" class="form-control"
						readonly="readonly" mainpop="2" placeholder="入量ml">
				</div>
				<div class="col-xs-6" style="padding-left: 0;">
					<input type="text" maxlength="10" nopop="true" class="form-control"
						placeholder="（标注）长度≤10">
				</div>
			</div>
			<div class="form-group">
				<label class="col-xs-2 control-label text-center"
					style="padding:2% 2% 0 2%;">出量</label>
				<div class="col-xs-4" style="padding-right: 0;">
					<input type="text" readonly="readonly" mainpop="3" maxlength="8"
						class="form-control" placeholder="出量ml">
				</div>
				<div class="col-xs-6" style="padding-left: 0;">
					<input type="text" maxlength="10" nopop="true" class="form-control"
						placeholder="（标注）长度≤10">
				</div>
			</div>
			<div class="form-group">
				<label class="col-xs-2 control-label text-center"
					style="padding:2% 2% 0 2%;">体温</label>
				<div class="col-xs-10">
					<input type="text" class="form-control" id="tiwen"
						data-backdrop="static" data-toggle="modal" readonly="readonly"
						data-target="#temperature" placeholder="体温">
				</div>
			</div>
			<div class="form-group">
				<label class="col-xs-2 control-label text-center"
					style="padding:2% 2% 0 2%;">测试</label>
				<div class="col-xs-10">
					<input type="text" readonly="readonly" mainpop="4"
						class="form-control" placeholder="测试">
				</div>
			</div>
			<div class="form-group">
				<label class="col-xs-2 control-label text-center"
					style="padding:2% 2% 0 2%;">引流</label>
				<div class="col-xs-10">
					<input type="text" readonly="readonly" mainpop="5"
						class="form-control" placeholder="引流">
				</div>
			</div>
		</form>


        <p>-------------------------------------------</p>
		<form class="form-horizontal">
			<s:iterator value="#request.bingr_tizheng_luruxiang">
				<div class="form-group">
					<label class="col-xs-3 control-label text-right"
						style="padding:2% 2% 0 2%;">${xmmc }</label>
					<div class="col-xs-9">
						<input type="text" class="form-control" placeholder="${xmmc }"
							id="${xmid }">
					</div>
				</div>
			</s:iterator>
		</form>

		<!--导航结束-->
		<div class="clear"></div>

	</div>
	<!--页脚开始-->
	<%@ include file="footer.jsp"%>
	<!--页脚结束-->
	<!--新加模态框 start-->
	<div class="modal fade" id="temperature" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" id="modal-wrap">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">体温录入项</h4>
				</div>
				<!-- 模态框body start-->
				<div class="modal-body">
					<form role="form" class="form-horizontal">
						<div class="form-group">
							<label class="col-xs-4 control-label text-right"
								style="padding:2% 2% 0 2%;">体温类型</label>
							<div class="col-xs-8">
								<select class="form-control">
									<option>腋温</option>
									<option>口温</option>
									<option>肛温</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-4 control-label text-right"
								style="padding:2% 2% 0 2%;">温度</label>
							<div class="col-xs-8">
								<input type="text" readonly="readonly" pop="1"
									class="form-control du" placeholder="请输入温度℃">
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-4 control-label text-right"
								style="padding:2% 2% 0 2%;">降温后温度</label>
							<div class="col-xs-8">
								<input type="text" readonly="readonly" pop="2"
									class="form-control du" placeholder="请输入降温后温度℃">
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-4 control-label text-right"
								style="padding:2% 2% 0 2%;">脉搏</label>
							<div class="col-xs-8">
								<input type="text" readonly="readonly" pop="3"
									class="form-control ci" placeholder="请输入脉搏">
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-4 control-label text-right"
								style="padding:2% 2% 0 2%;">心率</label>
							<div class="col-xs-8">
								<input type="text" readonly="readonly" pop="4"
									class="form-control ci" placeholder="请输入心率（次）">
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-4 control-label text-right"
								style="padding:2% 2% 0 2%;">呼吸</label>
							<div class="col-xs-8">
								<input type="text" readonly="readonly" pop="5"
									class="form-control ci" placeholder="请输入呼吸（次）">
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-4 control-label text-right"
								style="padding:2% 2% 0 2%;">入出标注</label>
							<div class="col-xs-8">
								<select class="form-control">
									<option>入院</option>
									<option>转入</option>
									<option>手术</option>
									<option>分娩</option>
									<option>外出</option>
									<option>出院</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-4 control-label  text-right"
								style="padding:2% 2% 0 2%;">入出时间</label>
							<div class="col-xs-8">
								<div class="demos">
									<input value="16:43" class="form-control" name="appTime"
										id="appTime2" type="text">
								</div>
							</div>
						</div>
					</form>
				</div>
				<!-- 模态框body end-->
				<div class="modal-footer">
					<button type="button" class="btn pull-left btn-primary">
						确定</button>
					<button type="button" id="quxiao" class="btn btn-default"
						data-dismiss="modal">取消</button>
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
				<a href="javascript:void(0)" class="white">上一项</a>
			</div>
			<div class="col-xs-3 text-center next" style="padding: 1% 0;">
				<a href="javascript:void(0)" class="white">下一项</a>
			</div>
			<div class="col-xs-1" class="caret" style="padding: 1% 0;">
				<a href="javascript:void(0)" class="caret white"></a>
			</div>
		</div>
		<div class="row" style="padding:0 1%; background-color: #C2BEC0;">
			<div style="padding:0 .5%;">
				<button type="button" class="btn btn-default" value="1">1</button>
				<button type="button" class="btn btn-default" value="2">2</button>
				<button type="button" class="btn btn-default" value="3">3</button>
				<button type="button" class="btn btn-info black" operation="reduce">←</button>
			</div>
			<div style="padding:0 .5%;">
				<button type="button" class="btn btn-default" value="4">4</button>
				<button type="button" class="btn btn-default" value="5">5</button>
				<button type="button" class="btn btn-default" value="6">6</button>
				<button type="button" id="del" class="btn btn-info black"
					operation="del">Del</button>
			</div>
			<div style="padding:0 .5%;">
				<button type="button" class="btn btn-default" value="7">7</button>
				<button type="button" class="btn btn-default" value="8">8</button>
				<button type="button" class="btn btn-default" value="9">9</button>
				<button type="button" class="btn btn-info black" value="/">╱</button>
			</div>
			<div style="padding:0 .5%; margin-bottom: 1.5%;">
				<button type="button" class="btn btn-info black" value=".">.</button>
				<button type="button" class="btn btn-default" value="0">0</button>
				<button type="button" class="btn btn-default" value="00">00</button>
				<button type="button" class="btn btn-info black" operation="hide">↖</button>
			</div>
		</div>
	</div>
	<!-- 键盘 end-->
	<!-- 键盘1 start-->
	<div class="container navbar-fixed-bottom jianpan" id="jianpan1">
		<div class="row bg-primary">
			<div class="col-xs-2 text-left" style="padding: 1% 0 0 2.5%;">
				<a href="javascript:void(0)" class="white">数字</a>
			</div>
			<div class="col-xs-3 text-left" style="padding: 1% 0 0 2.5%;">
				<a href="javascript:void(0)" class="black">快速</a>
			</div>
			<div class="col-xs-3 text-center prev" style="padding: 1% 0; ">
				<a href="javascript:void(0)" class="white">上一项</a>
			</div>
			<div class="col-xs-2 text-center next" style="padding: 1% 0; ">
				<a href="javascript:void(0)" class="white">下一项</a>
			</div>
			<div class="col-xs-2 text-center" style="padding: 1% 0; ">
				<a href="javascript:void(0)" class="caret white"></a>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-4" id="jianpan-left"
				style="padding:0 1% .5% 1%; background-color: #EEEEEE; ">
				<div style="padding:0 .5%;">
					<button type="button" class="btn btn-default" value="35">35</button>
					<button type="button" class="btn btn-default" value="36">36</button>
				</div>
				<div style="padding:0 .5%;">
					<button type="button" class="btn btn-default" value="37">37</button>
					<button type="button" class="btn btn-default" value="38">38</button>
				</div>
				<div style="padding:0 .5%;">
					<button type="button" class="btn btn-default" value="39">39</button>
					<button type="button" class="btn btn-default" value="40">40</button>
				</div>
				<div style="padding:0 .5%; margin-bottom: 1.5%;">
					<button type="button" class="btn btn-default" value="41">41</button>
					<button type="button" class="btn btn-default" value="42">42</button>
				</div>
			</div>
			<div class="col-xs-8" id="jianpan-right"
				style="padding:0 1%; background-color: #C2BEC0; ">
				<div style="padding:0 .5%;">
					<button type="button" class="btn btn-default" value="1">1</button>
					<button type="button" class="btn btn-default" value="2">2</button>
					<button type="button" class="btn btn-default" value="3">3</button>
					<button type="button" class="btn btn-info black" operation="reduce">←</button>
				</div>
				<div style="padding:0 .5%;">
					<button type="button" class="btn btn-default" value="4">4</button>
					<button type="button" class="btn btn-default" value="5">5</button>
					<button type="button" class="btn btn-default" value="6">6</button>
					<button type="button" class="btn btn-info black" operation="del">Del</button>
				</div>
				<div style="padding:0 .5%;">
					<button type="button" class="btn btn-default" value="7">7</button>
					<button type="button" class="btn btn-default" value="8">8</button>
					<button type="button" class="btn btn-default" value="9">9</button>
					<button type="button" class="btn btn-info black">╱</button>
				</div>
				<div style="padding:0 .5%; margin-bottom: 1.5%;">
					<button type="button" class="btn btn-info black" value=".">.</button>
					<button type="button" class="btn btn-default" value="0">0</button>
					<button type="button" class="btn btn-default" value="00">00</button>
					<button type="button" class="btn btn-info black" operation="hide">↖</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 键盘1 end-->
</body>
</html>