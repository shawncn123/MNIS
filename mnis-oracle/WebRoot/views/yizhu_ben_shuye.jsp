<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<!--<meta charset="UTF-8">-->
<!--<meta name="viewport" content="width=device-width,initial-scale=1">-->
<title>医嘱本</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="沈旭峰" />
<meta name="keywords" content="移动护理信息系统" />
<meta name="description" content="医嘱本,高大上的移动护理系统。" />
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="scripts/jquery-1.12.1.min.js"></script>
<script src="scripts/common.js" type="text/javascript"></script>
</head>
<body>
	<div id="header">
		<div class="row"
			style="border-bottom:1px solid #269abc;padding-top: 3px;">
			<div class="col-xs-2">
				<a href="#"> <img src="images/icon-m-man-active.png"
					class="img-responsive" alt="范冰冰">
				</a>
			</div>
			<div class="col-xs-4">
				<span><strong>范冰冰&nbsp;5&nbsp;床</strong></span>
				<p class="text-left" style="margin-bottom: 5px;">30&nbsp;岁</p>
			</div>
			<div class="col-xs-6 bg-info">
				<div class="table table-responsive"
					style="margin-bottom: 0;border: none;">
					<table class="table table-condensed"
						style="background-color: #d9edf7">
						<tr>
							<td><a href="#" class="text-center"> <img
									src="images/brxxxx_header_1.png" class="img-responsive"
									alt="消息数">
							</a></td>
							<td><a href="#" class="text-center"> <img
									src="images/brxxxx_header_2.png" class="img-responsive"
									alt="刷新">
							</a></td>
							<td><a href="views/bingrenlb.jsp" class="text-center"> <img
									src="images/brxxxx_header_3.png" class="img-responsive"
									alt="功能">
							</a></td>
							<td><a href="#" class="text-center"> <img
									src="images/brxxxx_header_4.png" class="img-responsive"
									alt="消息数">
							</a></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div id="content" class="container">
		<div class="row">
			<div class="col-xs-12"
				style="margin: 5px 0 5px 0;padding-bottom: 5px;border-bottom: #666666 1px solid;">
				<div class="dropdown">
					<a id="dLabel" data-target="#" href="javascript:void(0);"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false"> 全部 <span class="caret"></span>
					</a>
				<!-- 	<ul class="dropdown-menu" aria-labelledby="dLabel">
						<li><a href="#">输液本</a></li>
						<li><a href="#">治疗本</a></li>
						<li><a href="views/yizhu_ben_fuyao.jsp">服药本</a></li>
						<li><a href="#">临嘱本</a></li>
						<li><a href="#">膳食本</a></li>
						<li><a href="#">新开</a></li>
						<li><a href="#">新停</a></li>
						<li><a href="#">全部</a></li>
					</ul> -->
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-9">
				<span>10%&nbsp;葡萄糖注射液</span>
			</div>
			<div class="col-xs-3">
				<span>500&nbsp;ml</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-9">
				<span>注射用卡洛磺钠</span>
			</div>
			<div class="col-xs-3">
				<span>40&nbsp;mg</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12 text-right"
				style="margin: 10px 0 10px 0;padding-bottom: 5px;border-top: #666666 1px dashed;">
				<span style="color: #6daced">QD</span>
			</div>
		</div>
		<div class="row"
			style="border-bottom: 2px solid #333333;padding-bottom: 10px;margin-bottom: 10px;">
			<div class="col-xs-2 text-center">
				<span
					style="font-size: 18px;border-radius: 20px;border: 2px solid #38F1C6;padding: 5px;
            color: #38F1C6;">补</span>
			</div>
			<div class="col-xs-10">
				<div class="row">
					<div class="col-xs-12">
						<span>静脉滴注</span>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-4">
						<span>开嘱时间:</span>
					</div>
					<div class="col-xs-8">
						<span>2016-02-28 08:00:00</span>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-5">
				<span>50%&nbsp;葡萄糖注射液</span>
			</div>
			<div class="col-xs-5">
				<span>10g:20ml*5支/盒</span>
			</div>
			<div class="col-xs-2">
				<span>10&nbsp;ml</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12 text-right"
				style="margin: 10px 0 10px 0;padding-bottom: 5px;border-top: #666666 1px dashed;">
				<span style="color: #6daced">BID</span>
			</div>
		</div>
		<div class="row"
			style="border-bottom: 2px solid #333333;padding-bottom: 10px;margin-bottom: 10px;">
			<div class="col-xs-2 text-center">
				<span
					style="font-size: 18px;border-radius: 20px;border: 2px solid #388AF1;padding: 5px;
            color: #388AF1;">普</span>
			</div>
			<div class="col-xs-10">
				<div class="row">
					<div class="col-xs-12">
						<span>静脉滴注</span>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-4">
						<span>开嘱时间:</span>
					</div>
					<div class="col-xs-8">
						<span>2016-03-11 15:30:00</span>
					</div>
				</div>
			</div>
		</div>
		<div class="clear"></div>

	</div>
	<!--页脚开始-->
	<div id="footer">
		<div class="plug-div">
			<div class="plug-phone">
				<div class="plug-menu themeStyle">
					<!--<a class="ui-btn-back" href="javascript:history.go(-1)"></a>-->
					<a
						style="top: 0;left: 0;background: url(ky_img/back.png) no-repeat center center;
                    background-size: 24px auto;display: block;position: absolute;width: 50px;
                    height: 44px;text-indent: -9999px;margin: -5px;padding: 0;"
						href="javascript:history.go(-1)"></a>
					<!--<div class="themeStyle plug-btn plug-btn1 open">-->
					<!--<a href="/"><span style="background-image: url(ky_img/home.png);"></span></a>-->
					<!--</div>-->

				</div>
				<div
					style="bottom: 60px;left: 16px;width: 36px;height: 36px;border-radius: 36px;position: absolute;
            z-index: 999;background: #DE270B;">
					<a href="views/yewumokuai.jsp"> <span
						style="background-image: url(ky_img/home.png);
                display: block;width: 28px;height: 28px;background-size: 28px 28px;text-indent: -999px;
                position: absolute;top: 50%;left: 50%;margin-top: -14px;margin-left: -14px;overflow: hidden;"></span>
					</a>
				</div>
			</div>
		</div>
		<div class="copyright">
			这里是底部信息<br>声明：目前是测试版本,图标含义与业务功能模块可能不匹配。
		</div>
	</div>
	<!--页脚结束-->
	<script type="text/javascript" src="scripts/bootstrap.min.js"></script>
</body>
</html>
