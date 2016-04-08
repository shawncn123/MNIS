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
					class="img-responsive" alt="王菲">
				</a>
			</div>
			<div class="col-xs-4">
				<span><strong><s:property
							value="#session.czry.xingming" /></strong></span>
				<p class="text-left" style="margin-bottom: 5px;">妇产科二病区</p>
			</div>
			<div class="col-xs-2">
				<a href="#"> <img src="images/i-form-comment.png"
					class="img-responsive" alt="消息数">
				</a>
			</div>
			<div class="col-xs-2">
				<a href="#"> <img src="images/refresh-svg.svg"
					class="img-responsive" alt="刷新">
				</a>
			</div>
			<div class="col-xs-2">
				<a href="#"> <img src="images/icon-m-list.png"
					class="img-responsive" alt="功能">
				</a>
			</div>
		</div>
		<div class="row"
			style="border-bottom:1px solid #269abc;padding-top: 5px;">
			<div class="col-xs-3" style="padding: 0 2px;">
				<div class="dropdown">
					<button class="btn btn-default btn-sm dropdown-toggle"
						type="button" id="dropdownMenu1" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="true">
						普通病人 <span class="caret"></span>
					</button>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
						<li><a href="#">普通病人</a></li>
						<li><a href="#">会诊病人</a></li>
						<li><a href="#">家庭病人</a></li>
					</ul>
				</div>
			</div>
			<div class="col-xs-5" style="padding: 0 2px;">
				<div class="input-group input-group-sm">
					<input type="text" class="form-control" placeholder="请输入床号查找">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button">Go!</button>
					</span>
				</div>
				<!-- /input-group -->
			</div>
			<div class="col-xs-4" style="padding: 0 2px;">
				<div class="checkbox">
					<label> <input type="checkbox"> 我的病人
					</label>
				</div>
			</div>
		</div>
		<div class="row" style="border-bottom:1px solid #269abc;">
			<s:iterator value="#request.bqry">
				<a href="views/yewumokuai.jsp">
					<div class="col-xs-4" style="padding: 0 5px 0 5px;">
						<div class="panel panel-default" style="margin: 10px 0 10px 0;">
							<div class="table-responsive">
								<table class="table table-condensed">
									<tr>
										<td colspan="2" class="text-center">${zhuanghao}床</td>
										<td><img src="images/icon-add.png"
											class="img-responsive center-block" alt="${zhuanghao}床"
											style="width: 80%;"></td>
									</tr>
									<tr>
										<td rowspan="2" class="text-center"><img
											src="images/page/icon-signin.png"
											class="img-responsive center-block" alt="照片"></td>
										<td colspan="2" class="text-left">${xingming}</td>
									</tr>
									<tr>
										<td colspan="2" class="text-center">${nianling}</td>
									</tr>
									<tr>
										<td colspan="3" class="text-center">临床路径:<span
											style="color: #31b0d5">${lujing_zhuangtai}</span></td>
									</tr>
									<tr>
										<td
											style="border-right: rgba(4, 35, 11, 0.43) 1px solid; width: 30%;"><small>在院</small></td>
										<td
											style="border-right: rgba(4, 35, 11, 0.43) 1px solid;width: 30%;"></td>
										<td
											style="border-right: rgba(4, 35, 11, 0.43) 1px solid;width: 30%;"></td>
									</tr>
								</table>
							</div>
						</div>
					</div>
				</a>
			</s:iterator>
		</div>
		<div class="row">
			<div class="table-responsive" style="margin-bottom: 0px;">
				<table class="table table-condensed" style="padding: 5px;">
					<tr>
						<td><img src="images/foot_tu_1.png"
							class="img-responsive center-block" alt="病区视图"
							style="width: 30%;"></td>
						<td><img src="images/foot_tu_2.png"
							class="img-responsive center-block" alt="巡房视图"
							style="width: 30%;"></td>
						<td><img src="images/foot_tu_3.png"
							class="img-responsive center-block" alt="生命体征视图"
							style="width: 30%;"></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
