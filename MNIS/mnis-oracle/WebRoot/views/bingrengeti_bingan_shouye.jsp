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
<title>病案首页</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="沈旭峰" />
<meta name="keywords" content="移动护理信息系统" />
<meta name="description" content="病案首页,高大上的移动护理系统。" />
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<link href="css/base.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="scripts/jquery-1.12.1.min.js"></script>
<script type="text/javascript" src="scripts/viewjs.js"></script>
<script type="text/javascript">
	$(function() {
		// 绑定
		$("#head_banner_1").smartFloat();
	});
</script>
</head>
<body>
	<div id="head_banner_1" style="z-index:1000;" class="bg-info">
		<%@ include file="header.jsp"%>
	</div>
	<div id="content" class="container">
		<div class="row">
			<div class="col-xs-12"
				style="margin: 5px 0 5px 0;padding-bottom: 5px;border-bottom: #666666 1px solid;">
				<h3>基本信息</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-3">
				<span>姓名:</span>
			</div>
			<div class="col-xs-3">
				<span>${bingrgetixingxi.xm }</span>
			</div>
			<div class="col-xs-3">
				<span>性别</span>
			</div>
			<div class="col-xs-3">
				<span>${bingrgetixingxi.xb }</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-3">
				<span>年龄:</span>
			</div>
			<div class="col-xs-9">
				<span>${bingrgetixingxi.nl }</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-3">
				<span>住院号:</span>
			</div>
			<div class="col-xs-5">
				<span>${bingrgetixingxi.bah }</span>
			</div>
			<div class="col-xs-4">
				<span>第一次住院</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-3">
				<span>婚姻:</span>
			</div>
			<div class="col-xs-3">
				<span>${bingren_jbxx.hyzk}</span>
			</div>
			<div class="col-xs-3">
				<span>国籍</span>
			</div>
			<div class="col-xs-3">
				<span>${bingren_jbxx.gj}</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-3">
				<span>民族:</span>
			</div>
			<div class="col-xs-9">
				<span>${bingren_jbxx.mz}</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-3">
				<span>身份证号:</span>
			</div>
			<div class="col-xs-9">
				<span>${bingren_jbxx.sfzh}</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-3">
				<span>付款方式:</span>
			</div>
			<div class="col-xs-9">
				<span>${bingrgetixingxi.fylb }</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-3">
				<span>职业:</span>
			</div>
			<div class="col-xs-9">
				<span>${bingren_jbxx.zy}</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12"
				style="margin: 5px 0 5px 0;padding-bottom: 5px;border-bottom: #666666 1px solid;">
				<h3>诊断信息</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-3">
				<span>中医诊断:</span>
			</div>
			<div class="col-xs-9">
				<span style="color: #B70000"></span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-3">
				<span>西医诊断:</span>
			</div>
			<div class="col-xs-9">
				<span style="color: #B70000">${bingrgetixingxi.ryzd }</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12"
				style="margin: 5px 0 5px 0;padding-bottom: 5px;border-bottom: #666666 1px solid;">
				<h3>住院信息</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-3">
				<span>入院时间</span>
			</div>
			<div class="col-xs-9">
				<span>${bingrgetixingxi.ryrq }</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-3">
				<span>住院天数</span>
			</div>
			<div class="col-xs-9">
				<span>${bingrgetixingxi.zytsms }</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-3">
				<span>科室:</span>
			</div>
			<div class="col-xs-3">
				<span>${bingrgetixingxi.ksmc }</span>
			</div>
			<div class="col-xs-3">
				<span>病情:</span>
			</div>
			<div class="col-xs-3">
				<span>${bingrgetixingxi.dqbkzt }</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-3">
				<span>主治医师:</span>
			</div>
			<div class="col-xs-3">
				<span style="color: #d19c36">${bingrgetixingxi.ysxm }</span>
			</div>
			<div class="col-xs-3">
				<span>主任医师:</span>
			</div>
			<div class="col-xs-3">
				<span style="color: #d19c36">刘涛</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-3">
				<span>主院医师:</span>
			</div>
			<div class="col-xs-3">
				<span style="color: #d19c36">汤唯</span>
			</div>
			<div class="col-xs-3">
				<span>责任护士:</span>
			</div>
			<div class="col-xs-3">
				<span style="color: #d19c36">${bingrgetixingxi.hsxm }</span>
			</div>
		</div>
		
		<div class="row">
			<div class="col-xs-12"
				style="margin: 5px 0 5px 0;padding-bottom: 5px;border-bottom: #666666 1px solid;">
				<h3>联系方式</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-4">
				<span>联系人姓名:</span>
			</div>
			<div class="col-xs-8">
				<span>${bingren_jbxx.lxrxm }</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-4">
				<span>联系人电话:</span>
			</div>
			<div class="col-xs-8">
				<span>${bingren_jbxx.lxrdh }</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-4">
				<span>联系人地址:</span>
			</div>
			<div class="col-xs-8">
				<span>${bingren_jbxx.lxrdz }</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-4">
				<span>家庭电话:</span>
			</div>
			<div class="col-xs-8">
				<span>${bingren_jbxx.jtdh }</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-3">
				<span>家庭地址:</span>
			</div>
			<div class="col-xs-9">
				<span>${bingren_jbxx.jtdz }</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-3">
				<span>出生地点:</span>
			</div>
			<div class="col-xs-9">
				<span>${bingren_jbxx.csdd }</span>
			</div>
		</div>
		<!--导航结束-->
		<div class="clear"></div>

	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>
