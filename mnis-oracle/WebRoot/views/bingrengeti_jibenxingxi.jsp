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
<title>病人基本信息</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="SHORTCUT ICON" href="images/favicon.ico">
<link rel="icon" href="images/favicon.ico" type="image/x-icon">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="沈旭峰" />
<meta name="keywords" content="移动护理信息系统" />
<meta name="description" content="病人基本信息,高大上的移动护理系统。" />
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<link href="css/base.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/song.css"/>
<script type="text/javascript" src="scripts/jquery-1.12.1.min.js"></script>
<script type="text/javascript" src="scripts/viewjs.js"></script>
<script src="scripts/song.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		// 绑定
		$("#head_banner_1").smartFloat();
	});
</script>
</head>
<body>
	<%@ include file="header-bingren.jsp"%>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-xs-12"
				style="margin: 5px 0 5px 0;padding-bottom: 5px;border-bottom: #666666 1px solid;">
				<h3>基本信息</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-4">
				<span>住院号:</span>
			</div>
			<div class="col-xs-8">
				<span>${bingren_jbxx.bah }</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-4">
				<span>入院日期:</span>
			</div>
			<div class="col-xs-8">
				<span> <s:property value="#request.bingren_jbxx.ryrq.substring(0,10)"/></span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-4">
				<span>病人类型:</span>
			</div>
			<div class="col-xs-8">
				<span>--</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-4">
				<span>付款方式:</span>
			</div>
			<div class="col-xs-8">
				<span>${bingren_jbxx.fylb }</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12"
				style="margin: 5px 0 5px 0;padding-bottom: 5px;border-bottom: #666666 1px solid;">
				<h3>住院信息</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-4">
				<span>诊断:</span>
			</div>
			<div class="col-xs-8">
				<span style="color: #B70000">${bingrgetixingxi.ryzd }</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-4">
				<span>医生</span>
			</div>
			<div class="col-xs-8">${bingren_jbxx.ysxm }</div>
		</div>
		<div class="row">
			<div class="col-xs-4">
				<span>护士</span>
			</div>
			<div class="col-xs-8">
				<span style="color: #c7254e">${bingren_jbxx.hsxm }</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-4">
				<span>过敏史</span>
			</div>
			<div class="col-xs-8">
				<span style="color: #d19c36">${bingrgetixingxi.gmls }</span>
			</div>
		</div>
		<!-- <div class="row">
			<div class="col-xs-4"></div>
			<div class="col-xs-8">
				<span style="color: #d19c36">注射用头孢硫脒</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-4"></div>
			<div class="col-xs-8">
				<span style="color: #d19c36">注射用头孢西丁纳</span>
			</div>
		</div> -->
		<div class="row">
			<div class="col-xs-12"
				style="margin: 5px 0 5px 0;padding-bottom: 5px;border-bottom: #666666 1px solid;">
				<h3>费用一览 无数据</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-4">
				<span>预交费用:</span>
			</div>
			<div class="col-xs-8">
				<span>--</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-4">
				<span>未结费用:</span>
			</div>
			<div class="col-xs-8">
				<span>--</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-4">
				<span>担保金额:</span>
			</div>
			<div class="col-xs-8">
				<span>--</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-4">
				<span>余额:</span>
			</div>
			<div class="col-xs-8">
				<span>--</span>
			</div>
		</div>
		
		<!--导航结束-->
		<div class="clear"></div>
		<%@ include file="menu-hushi.jsp" %>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>
