<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<title>登录</title>
<link rel="stylesheet" href="css/bootstrap.min.css">

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="scripts/jquery-1.12.1.min.js"></script>
</head>

<body class="bg-info">
	<div class="container" style="margin-top: 10px;">
		<form action="login" method="post">
			<div class="form-group">
				<label for="exampleInputEmail1">用户名:</label> <input
					class="form-control" name="yonghu_name" id="yonghu_name"
					placeholder="User Name">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">密码</label> <input type="password"
					class="form-control" name="mima" id="mima" placeholder="Password">
			</div>
			<button type="submit" class="btn btn-default" id="login">登录</button>
			<button type="reset" class="btn btn-default" id="cancel">取消</button>
		</form>
	</div>
	<br>
	<br>
	<br>
<!-- 	<a href="mnis-test">test</a> -->
	<script type="text/javascript" src="scripts/bootstrap.min.js"></script>
</body>

</html>
