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
<title>移动护理信息系统-登录</title>
<link rel="stylesheet" href="css/bootstrap.min.css">

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta name="author" content="沈旭峰" />
<meta name="keywords" content="移动护理信息系统" />
<meta name="description" content="用户登录,高大上的移动护理系统。" />
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/login-song.css" />
</head>
<body>
	<%
		if ((String) request.getAttribute("login_check") == "1") {
	%>
	<script>
		alert("用户名或密码错误！");
	</script>
	<%
		}
	%>
	<div id="login-content" class="container">
		<h1 class="form-heading text-center">移动护理信息系统</h1>
		<form class="form-horizontal" action="login" method="post">
			<div class="form-group login">
				<span class="col-xs-1 glyphicon glyphicon-user"
					style="padding: 4% 0 0 3%;"></span>
				<div class="col-xs-11">
					<input type="text" class="form-control" placeholder="用户名"
						name="yonghu_name" id="yonghu_name">
				</div>
			</div>
			<div class="form-group login">
				<span class="col-xs-1 glyphicon glyphicon-lock"
					style="padding: 4% 0 0 3%;"></span>
				<div class="col-xs-11">
					<input type="password" class="form-control" placeholder="密码"
						name="mima" id="mima">
				</div>
			</div>
			<div style="margin-top: 40px;">
				<button class="btn btn-block btn-primary" type="submit" id="login">登录</button>
			</div>
		</form>

	</div>
	<div id="login-footer" class="text-center container">
		移动护理信息系统 Beta1.0 <br>北京融汇国康医疗科技有限公司
	</div>
</body>
</html>
