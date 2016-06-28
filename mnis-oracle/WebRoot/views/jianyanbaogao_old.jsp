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
<title>检验报告</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="沈旭峰" />
<meta name="keywords" content="移动护理信息系统" />
<meta name="description" content="检验报告,高大上的移动护理系统。" />
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<link href="css/base.css" rel="stylesheet" type="text/css" />
<link href="css/custom1.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/mobiscroll.css" />
<link rel="stylesheet" href="css/mobiscroll_002.css" />
<link rel="stylesheet" href="css/mobiscroll_003.css" />
<script type="text/javascript" src="scripts/jquery-1.12.1.min.js"></script>
<script type="text/javascript"
	src="scripts/bootstrap-clockpicker.min.js"></script>
<%-- <script type="text/javascript" src="scripts/bootstrap.min.js"></script> --%>
<%-- <script type="text/javascript">
	$(function() {
		$('.clockpicker').clockpicker();
	})
</script> --%>
<%-- <script src="js/common.js" type="text/javascript"></script> --%>
<script src="js/mobiscroll_002.js"></script>
<script src="js/mobiscroll_003.js"></script>
<script src="js/mobiscroll_004.js"></script>
<script src="js/mobiscroll_005.js"></script>
<script src="js/mobiscroll.js"></script>
<script src="js/timerpicker.js" type="text/javascript" charset="utf-8"></script>
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
		<%@ include file="header-bingren.jsp"%>
		<div class="container">
			<div class="row">
				<div class="col-xs-5">
					<div class="row">
						<div class="col-xs-10">
							<form action="">
								<div class="form-group">
									<select name="" id="" class="form-control">
										<option value="">医生姓名</option>
										<option value="">刘德华</option>
										<option value="">林青霞</option>
										<option value="">张曼玉</option>
									</select>
								</div>
							</form>
						</div>
						<div class="col-xs-1 bor-r">
							<div class="icon_pic mar-l"></div>
						</div>
					</div>
				</div>
				<div class="col-xs-7">
					<div class="row">
						<div class="col-xs-4 padd-r">
							<div class="content">
								<div class="demos">
									<input value="" placeholder="开始日期" class="form-control padd-r"
										readonly="readonly" name="appDateTime" id="appDate"
										type="text">
								</div>
							</div>
						</div>
						<div class="col-xs-1">
							<p class="p-divider">—</p>
						</div>
						<div class="col-xs-4 padd-r">
							<div class="content">
								<div class="demos">
									<input value="" placeholder="结束日期" class="form-control padd-r"
										readonly="readonly" name="appDateTime" id="appDate1"
										type="text">
								</div>
							</div>
						</div>
						<div class="col-xs-1 bor-r">
							<div class="icon_pic"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="container">
		<s:iterator value="#request.bingrgeti_huayan">
			<div class="row" style="padding-top: 2%;padding-bottom: 2%;">
				<div class="col-xs-7">
					<a href="javascript:void(0)" style="text-decoration: none;color: #080808;"><s:if
							test="zxflag=='0'">
							<span style="color: #ADD1F7">&gt;</span>
						</s:if> <s:else>
							<span style="color: #F71903">&gt;</span>
						</s:else>&nbsp;${bbmc}&nbsp;${xmms }</a>
				</div>
				<div class="col-xs-5" style="padding-left: 5px;padding-right: 0px;">
					<a href="javascript:void(0)" style="text-decoration: none;color: #080808;">${sqysxm }&nbsp;<s:date
							name="sqrq" format="yyyy-MM-dd"></s:date></a>
				</div>
			</div>
		</s:iterator>
	</div>

	<!--导航结束-->
	<div class="clear"></div>
	<!--页脚开始-->
	<%@ include file="footer.jsp"%>
	<!--页脚结束-->
	<script type="text/javascript" src="scripts/bootstrap.min.js"></script>
</body>
</html>