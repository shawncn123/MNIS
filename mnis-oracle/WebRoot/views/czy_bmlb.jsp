<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="zh_cn">
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>用户列表</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script type="text/javascript" src="scripts/jquery-1.12.1.min.js"></script>
</head>
<body class="bg-info">
	<div class="container">
		<div class="row"
			style="border-bottom:1px solid #269abc;padding-top: 10px;">
			<div class="col-xs-2">
				<a href="#"> <img src="images/icon-m-man-active.png"
					class="img-responsive" alt="<s:property value="#session.czry.xingming" />">
				</a>
			</div>
			<div class="col-xs-3">
				<span><strong><s:property value="#session.czry.xingming" /></strong></span>
				<p class="text-left" style="margin-bottom: 5px;"></p>
			</div>
			<div class="col-xs-7">
				<h4 style="margin-top=:0">部门选择</h4>
			</div>
		</div>
		<div class="row" style="margin-top: 10px;">
			<div class="col-xs-12">
				<div class="list-group">
					<s:iterator value="#request.czybumeng">
<%-- 					<a href="#" class="list-group-item active"> ${bumeng_name} </a> --%> 
					<a href="mnisbr-getbqry?keshi_id=${bumeng_id}" class="list-group-item"> ${bumeng_name} </a> 
					</s:iterator>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
