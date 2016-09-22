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
<link rel="SHORTCUT ICON" href="images/favicon.ico">
<link rel="icon" href="images/favicon.ico" type="image/x-icon">
<script type="text/javascript" src="scripts/jquery-1.12.1.min.js"></script>
<script type="text/javascript" src="scripts/viewjs.js"></script>
<script type="text/javascript">
	$(function() {
		// 绑定
		$("#head_banner_1").smartFloat();
	});
</script>
</head>
<body class="bg-info">

	<div id="head_banner_1" style="z-index:1000;" class="bg-info">
		<div class="row"
			style="border-bottom:1px solid #269abc;padding: 10px 15px 5px 15px;">
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
				<a href="#"> <img src="images/browser_48px.png"
					class="img-responsive" alt="刷新">
				</a>
			</div>
			<div class="col-xs-2">
				<a href="#"> <img src="images/android_48px.png"
					class="img-responsive" alt="功能">
				</a>
			</div>
		</div>
		<div class="row"
			style="border-bottom:1px solid #269abc;padding: 5px 15px 0 15px;">
			<div class="col-xs-3" style="padding: 0 2px;">
				<div class="dropdown">
					<button class="btn btn-default btn-sm dropdown-toggle"
						type="button" id="dropdownMenu1" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="true">
						二楼病区 <span class="caret"></span>
					</button>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
						<li><a href="#">三楼病区</a></li>
						<li><a href="#">内科病房1(借床二楼)</a></li>
						<li><a href="#">门诊楼四楼病区</a></li>
					</ul>
				</div>
			</div>
			<div class="col-xs-4" style="padding: 0 2px;">
				<div class="input-group input-group-sm">
					<input type="text" class="form-control" placeholder="请输入床号查找">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button">Go!</button>
					</span>
				</div>
				<!-- /input-group -->
			</div>
			<div class="col-xs-3" style="padding: 0 2px;">
				<div class="checkbox">
					<label> <input type="checkbox"> 我的病人
					</label>
				</div>
			</div>
			<div class="col-xs-2" style="padding: 0 2px;">
				<div class="checkbox">
					<a href="bingqbr_jianka">简卡</a>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row" style="border-bottom:1px solid #269abc;">
			<s:iterator value="#request.bqry" id="br">
				<a href="views/yewumokuai.jsp">
					<div class="col-xs-6" style="padding: 0 5px 0 5px;">
						<div class="panel panel-default" style="margin: 5px 0 5px 0;">
							<div class="table-responsive">
								<table class="table table-condensed" style="table-layout:fixed;">
									<tr>
										<td style="padding-right:0px;"><span
											style="color: ${fylbBoxcolor };background-color: ${fylbBoxcolor }">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
										<%-- <td style="padding-right:0px;padding-left:0px;">${yems}</td> --%>
										<td colspan="2" style="padding-right:0px;">${yems}&nbsp;&nbsp;${hldj }</td>
									</tr>
									<tr>
										<td style="padding-right:0px;"><h4>${chw }床</h4></td>
										<td colspan="2" style="padding-right:0px;"><h4>${xm }</h4></td>
										<!-- <td style="padding-right:0px;"></td> -->
									</tr>
									<tr>
										<td style="padding-right:0px;">${bah }</td>
										<td style="padding-right:0px;padding-left:0px;">${fylb }</td>
										<td style="padding-right:0px;">${xb }&nbsp;${nl }</td>
									</tr>
									<tr>
										<td style="padding-right:0px;">${ksmc }</td>
										<td style="padding-right:0px;padding-left:0px;"
											class="text-right">病情:</td>
										<td style="padding-right:0px;">${dqbkzt }</td>
									</tr>
									<tr>
										<td colspan="3"
											style="padding-right:0px;overflow:hidden;text-overflow:ellipsis;"
											nowrap='nowrap'>诊断：${ryzd }</td>
									</tr>
									<tr>
										<td colspan="3"
											style="padding-right:0px;overflow:hidden;text-overflow:ellipsis;"
											nowrap='nowrap'>过敏史：${gmls }</td>
									</tr>
									<tr>
										<td colspan="3"
											style="padding-right:0px;overflow:hidden;text-overflow:ellipsis;"
											nowrap='nowrap'>膳食：${shanshi }</td>
									</tr>
									<tr>
										<td style="padding-right:0px;">医生:&nbsp;${ysxm }</td>
										<td style="padding-right:0px;padding-left:0px;"
											class="text-right">护士:</td>
										<td style="padding-right:0px;">${hsxm }</td>
									</tr>
									<tr>
										<td colspan="3"
											style="padding-right:0px;overflow:hidden;text-overflow:ellipsis;"
											nowrap='nowrap'>手术：${ssms }厕所看到飞机上的快捷方式</td>
									</tr>
									<tr>
										<td style="padding-right:0px;" colspan="3"><s:property
												value="ryrq.substring(0,10)"></s:property>&nbsp;&nbsp;${zytsms }</td>

										<%-- <td colspan="2" style="padding-right:0px;">${zytsms }</td> --%>
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
	<!--页脚结束-->
	<script type="text/javascript" src="scripts/bootstrap.min.js"></script>
</body>
</html>
