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
<title>移动护理信息系统-体温单</title>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="沈旭峰" />
<meta name="keywords" content="移动护理信息系统" />
<meta name="description" content="体温单,高大上的移动护理系统。" />
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="SHORTCUT ICON" href="images/favicon.ico">
<link rel="icon" href="images/favicon.ico" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="css/song.css"/>
<link href="css/custom1.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/mobiscroll.css" />
<link rel="stylesheet" href="css/mobiscroll_002.css" />
<link rel="stylesheet" href="css/mobiscroll_003.css" />
<link href="css/base.css" rel="stylesheet" type="text/css" />
<link href="css/login-song.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="scripts/jquery-1.12.1.min.js"></script>
<script src="scripts/common.js" type="text/javascript"></script>
<script src="scripts/mobiscroll_002.js"></script>
<script src="scripts/mobiscroll_003.js"></script>
<script src="scripts/mobiscroll_004.js"></script>
<script src="scripts/mobiscroll_005.js"></script>
<script src="scripts/mobiscroll.js"></script>
<script src="scripts/timerpicker.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="scripts/viewjs.js"></script>
<script src="scripts/song.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		// 绑定
		$("#head_banner_1").smartFloat();
	});
	$(function() {$(document).ready(function() {
		
		$("#tiwen_shijianduan").change(function() {
			var shijian = $(this).val();
			var url = "tiWenDan_insert";
			var args = {"datestring":shijian};
			$.post(url,args,function(data) {
				if(data=="insertfail"){
					$("#tupian").html("<p>程序数据处理错误</p>");
				}
			});
		});
		
		$("#chaxun_queding").click(function(){
			$("#tupian").html("<p>请稍候......</p>");
			var test = $("#tiwen_shijianduan").val();
		/* 	alert(test); */
			var url = "tiWenDan_file_get";
			var args = {"datestring":test};
			$.post(url,args,function(data) {
			/* alert(data); */
			/* console.log(data); */
			if(data=="nodate"){
				$("#tupian").html("<p>请先选择日期</p>");
			}else if(data!="fail"){
				var b= data.indexOf('twdimage');
				var d=data.substr(b);
				$("#tupian").html("<img src="+ d + " class=\"img-responsive center-block\" id=\"tiwenid\"/>");
/* 				$("#tiwenid").attr("src",d); */
			}else{
				$("#tupian").html("<p>体温单查询失败！</p>");
			}
		});
	})})})
</script>
</head>
<body>
	<%@ include file="header-bingren.jsp"%>
		<div class="row">
			<div class="col-xs-8" style="padding-top: .5%;">
				<select class="form-control" id="tiwen_shijianduan">
					<option value="" style="display: none">查询日期</option>
					<s:iterator value="#request.BingrenTiWenJiLu_shijianduan">
						<option value="<s:date name="date1" format="yyyy.MM.dd"/>"><s:date name="date1" format="yyyy.MM.dd"/>-<s:date name="date2" format="yyyy.MM.dd"/></option>
					</s:iterator>
					<!-- <option value="2016.01.01">2016.01.01-2016.01.08</option> -->
				</select>
			</div>
			<div class="col-xs-4 pull-right">
				<a class="btn btn-default" href="javascript:void(0)" role="button" id="chaxun_queding">确定</a>
				<!-- <a class="btn btn-default" href="tiWenDan_create" role="button" id="test_chaxun_queding">test</a> -->
			</div>
		</div>
	</div>
	<!-- 5-3小宋添加  新加图片背景  start-->
	<div
		style="background: url(images/content_bj.png); width: 100%; height: 100%;">
		<div id="content" class="container" style="width: 90%;">
			<div style="margin-top: 4%;" id="tupian">
				<!-- <img src="images/tiwendan_Demo.jpg" class="img-responsive center-block" /> -->
				<img src="twdimage/1408672415.jpg" class="img-responsive center-block" id="tiwenid"/>
				注：这是一张图片
			</div>
		</div>
		<%@ include file="menu-hushi.jsp" %>
	</div>
	<!-- 5-3小宋添加  新加图片背景  end-->


	<!--导航结束-->
	<div class="clear"></div>
	<!--页脚开始-->
	<%@ include file="footer.jsp"%>
	<!--页脚结束-->
	<script type="text/javascript" src="scripts/bootstrap.min.js"></script>
</body>
</html>