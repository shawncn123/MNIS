<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>医嘱执行分类</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="SHORTCUT ICON" href="images/favicon.ico">
<link rel="icon" href="images/favicon.ico" type="image/x-icon">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="融汇国康" />
<meta name="keywords" content="移动护理信息系统" />
<meta name="description" content="医嘱执行分类,高大上的移动护理系统。" />
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<link href="css/base.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/song.css" />
<script type="text/javascript" src="scripts/jquery-1.12.1.min.js"></script>
<script src="scripts/bootstrap.min.js" type="text/javascript"
	charset="utf-8"></script>
<script type="text/javascript" src="scripts/viewjs.js"></script>
<script src="scripts/song.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	$(function() {
		// 绑定
		$("#head_banner_1").smartFloat();
	});
</script>
</head>
<body>
	<%@ include file="header-hushi.jsp"%>
	</div>
	<div id="content" class="container" style="padding: 0;">
		<s:iterator value="#request.yizhuzxfl">
		<div class="row" style="border-bottom:1px solid #269abc;padding:3%;">
	        <div class="col-xs-12" style="text-align:center;">
	            <a href="yizhuweizhixing?vxzzxfl=${dm}" type="button" class="btn btn-primary btn-lg" style="width:50%;">${mc}</a>
	        </div>
	    </div>
	    </s:iterator>
		
		<!--导航结束-->
		<div class="clear"></div>
		<%@ include file="menu-hushi.jsp"%>
	</div>

	<!--页脚开始-->
	<%@ include file="footer.jsp" %>
	<!--页脚结束-->

</body>
</html>
