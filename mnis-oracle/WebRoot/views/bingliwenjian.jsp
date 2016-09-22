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
<title>病历文件</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="SHORTCUT ICON" href="images/favicon.ico">
<link rel="icon" href="images/favicon.ico" type="image/x-icon">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="沈旭峰" />
<meta name="keywords" content="移动护理信息系统" />
<meta name="description" content="病历文件,高大上的移动护理系统。" />
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
	<div class="container">
		<div class="panel-group" id="accordion" role="tablist"
			aria-multiselectable="true" style="margin-top: 2%;">
			<div class="panel panel-default">
				<div class="panel-heading" role="tab" id="headingOne">
					<h4 class="panel-title">
						<a role="button" data-toggle="collapse" data-parent="#accordion"
							href="#collapseOne" aria-expanded="false"
							aria-controls="collapseOne"
							style="width: 100%;display: inline-block;color: yellowgreen;text-decoration: none;">
							&gt;&nbsp;住院病历 </a>
					</h4>
				</div>
				<div id="collapseOne" class="panel-collapse collapse in"
					role="tabpanel" aria-labelledby="headingOne">
					<div class="panel-body" style="padding: 5px;">
						<div class="row" style="padding-top: 2%;padding-bottom: 2%;">
							<div class="col-xs-7">
								<a href="#" style="text-decoration: none;color: #080808;">入院病历</a>
							</div>
							<div class="col-xs-5">
								<a href="#" style="text-decoration: none;color: #080808;">王菲&nbsp;2016/03/01</a>
							</div>
						</div>
						<div class="row" style="padding-top: 2%;padding-bottom: 2%;">
							<div class="col-xs-7">
								<a href="#" style="text-decoration: none;color: #080808;">病程记录(6)</a>
							</div>
							<div class="col-xs-5">
								<a href="#" style="text-decoration: none;color: #080808;">王菲&nbsp;2016/03/01</a>
							</div>
						</div>
						<div class="row" style="padding-top: 2%;padding-bottom: 2%;">
							<div class="col-xs-7">
								<a href="#" style="text-decoration: none;color: #080808;">手术记录</a>
							</div>
							<div class="col-xs-5">
								<a href="#" style="text-decoration: none;color: #080808;">王菲&nbsp;2016/03/01</a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading" role="tab" id="headingTwo">
					<h4 class="panel-title">
						<a class="collapsed" role="button" data-toggle="collapse"
							data-parent="#accordion" href="#collapseTwo"
							aria-expanded="false" aria-controls="collapseTwo"
							style="width: 100%;display: inline-block;color: yellowgreen;text-decoration: none;">
							&gt;&nbsp;疾病证明报告 </a>
					</h4>
				</div>
				<div id="collapseTwo" class="panel-collapse collapse in"
					role="tabpanel" aria-labelledby="headingTwo">
					<div class="panel-body" style="padding: 5px;">
						<div class="row" style="padding-top: 2%;padding-bottom: 2%;">
							<div class="col-xs-7">
								<a href="#" style="text-decoration: none;color: #080808;">诊断证明书一</a>
							</div>
							<div class="col-xs-5">
								<a href="#" style="text-decoration: none;color: #080808;">王菲&nbsp;2016/03/01</a>
							</div>
						</div>
						<div class="row" style="padding-top: 2%;padding-bottom: 2%;">
							<div class="col-xs-7">
								<a href="#" style="text-decoration: none;color: #080808;">诊断证明书二</a>
							</div>
							<div class="col-xs-5">
								<a href="#" style="text-decoration: none;color: #080808;">王菲&nbsp;2016/03/01</a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading" role="tab" id="headingThree">
					<h4 class="panel-title">
						<a class="collapsed" role="button" data-toggle="collapse"
							data-parent="#accordion" href="#collapseThree"
							aria-expanded="false" aria-controls="collapseThree"
							style="width: 100%;display: inline-block;color: yellowgreen;text-decoration: none;">
							&gt;&nbsp;知情文件 </a>
					</h4>
				</div>
				<div id="collapseThree" class="panel-collapse collapse in"
					role="tabpanel" aria-labelledby="headingThree">
					<div class="panel-body" style="padding: 5px;">
						<div class="row" style="padding-top: 2%;padding-bottom: 2%;">
							<div class="col-xs-7">
								<a href="#" style="text-decoration: none;color: #080808;">手术治疗同意书</a>
							</div>
							<div class="col-xs-5">
								<a href="#" style="text-decoration: none;color: #080808;">王菲&nbsp;2016/03/01</a>
							</div>
						</div>
						<div class="row" style="padding-top: 2%;padding-bottom: 2%;">
							<div class="col-xs-7">
								<a href="#" style="text-decoration: none;color: #080808;">麻醉实施同意书</a>
							</div>
							<div class="col-xs-5">
								<a href="#" style="text-decoration: none;color: #080808;">王菲&nbsp;2016/03/01</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!--导航结束-->
	<div class="clear"></div>
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
					style="bottom: 16px;left: 80px;width: 36px;height: 36px;border-radius: 36px;position: absolute;
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
