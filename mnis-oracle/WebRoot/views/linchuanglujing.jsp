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
<title>临床路径</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="SHORTCUT ICON" href="images/favicon.ico">
<link rel="icon" href="images/favicon.ico" type="image/x-icon">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="沈旭峰" />
<meta name="keywords" content="移动护理信息系统" />
<meta name="description" content="临床路径,高大上的移动护理系统。" />
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="scripts/jquery-1.12.1.min.js"></script>
<script src="scripts/common.js" type="text/javascript"></script>
</head>
<body>
	<div id="header">
		<div class="row"
			style="border-bottom:1px solid #269abc;padding-top: 3px;">
			<div class="col-xs-2">
				<a href="#"> <img src="images/icon-m-man-active.png"
					class="img-responsive" alt="范冰冰">
				</a>
			</div>
			<div class="col-xs-4">
				<span><strong>范冰冰&nbsp;5&nbsp;床</strong></span>
				<p class="text-left" style="margin-bottom: 5px;">30&nbsp;岁</p>
			</div>
			<div class="col-xs-6 bg-info">
				<div class="table table-responsive"
					style="margin-bottom: 0;border: none;">
					<table class="table table-condensed"
						style="background-color: #d9edf7">
						<tr>
							<td><a href="#" class="text-center"> <img
									src="images/brxxxx_header_1.png" class="img-responsive"
									alt="消息数">
							</a></td>
							<td><a href="#" class="text-center"> <img
									src="images/brxxxx_header_2.png" class="img-responsive"
									alt="刷新">
							</a></td>
							<td><a href="views/bingrenlb.jsp" class="text-center"> <img
									src="images/brxxxx_header_3.png" class="img-responsive"
									alt="功能">
							</a></td>
							<td><a href="#" class="text-center"> <img
									src="images/brxxxx_header_4.png" class="img-responsive"
									alt="消息数">
							</a></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div id="content" class="container">
		<div class="row" style="margin: 5px 0;">
			<div class="col-xs-8" style="padding: 0 5px;">
				<span style="font-size: 14px;">输卵管妊娠临床路径(执行中,&nbsp;30%)</span>
			</div>
			<div class="col-xs-4" style="padding: 0 5px;">
				<span style="font-size: 14px;">标准住院日:&nbsp;10</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<div id="carousel-example-generic" class="carousel slide"
					data-ride="carousel" data-interval="false">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#carousel-example-generic" data-slide-to="0"
							class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1"></li>
						<li data-target="#carousel-example-generic" data-slide-to="2"></li>
					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner" role="listbox">
						<div class="item active">
							<div class="row">
								<div class="col-xs-12 text-center" style="margin: 2% 0;">
									<h4 style="color: #4162EF;">住院第一天(住院日)</h4>
								</div>
							</div>
							<div class="row bg-info">
								<div class="col-xs-3 text-center" style="margin: 2% 0;">
									<h4 style="color: #4162EF;">第1天</h4>
								</div>
								<div class="col-xs-6 text-center" style="margin: 2% 0;">
									<h4 style="color: #4162EF;">2016-02-28</h4>
								</div>
								<div class="col-xs-3 text-center" style="margin: 2% 0;">
									<h4 style="color: #4162EF;">星期一</h4>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="panel-group" id="accordion" role="tablist"
										aria-multiselectable="true">
										<div class="panel panel-default">
											<div class="panel-heading" role="tab" id="headingOne">
												<h4 class="panel-title">
													<a role="button" data-toggle="collapse"
														data-parent="#accordion" href="#collapseOne"
														aria-expanded="false" aria-controls="collapseOne"
														style="width: 100%;display: inline-block;"> 主要护理工作 </a>
												</h4>
											</div>
											<div id="collapseOne" class="panel-collapse collapse"
												role="tabpanel" aria-labelledby="headingOne">
												<div class="panel-body" style="padding: 5px;">
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<!--<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#testmodal">-->
															<!--入院宣教-->
															<!--</button>-->
															<!--<div style="height: 0;padding-bottom: 100%;">-->
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 入院宣教 </a>
															<!--</div>-->
														</div>
													</div>
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 介绍病房环境设施和设备 </a>
														</div>
													</div>
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 入院护理评估 </a>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="panel panel-default">
											<div class="panel-heading" role="tab" id="headingTwo">
												<h4 class="panel-title">
													<a class="collapsed" role="button" data-toggle="collapse"
														data-parent="#accordion" href="#collapseTwo"
														aria-expanded="false" aria-controls="collapseTwo"
														style="width: 100%;display: inline-block;"> 重点医嘱 </a>
												</h4>
											</div>
											<div id="collapseTwo" class="panel-collapse collapse"
												role="tabpanel" aria-labelledby="headingTwo">
												<div class="panel-body" style="padding: 5px;">
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<!--<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#testmodal">-->
															<!--入院宣教-->
															<!--</button>-->
															<!--<div style="height: 0;padding-bottom: 100%;">-->
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 检查血压、血氧饱和度 </a>
															<!--</div>-->
														</div>
													</div>
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 观察腹痛、阴道流血情况 </a>
														</div>
													</div>
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 留置导尿 </a>
														</div>
													</div>
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 临时医嘱 </a>
														</div>
													</div>
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 急查血细胞分析全套 </a>
														</div>
													</div>
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 急诊术前特检 </a>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="panel panel-default">
											<div class="panel-heading" role="tab" id="headingThree">
												<h4 class="panel-title">
													<a class="collapsed" role="button" data-toggle="collapse"
														data-parent="#accordion" href="#collapseThree"
														aria-expanded="false" aria-controls="collapseThree"
														style="width: 100%;display: inline-block;"> 主要诊疗工作 </a>
												</h4>
											</div>
											<div id="collapseThree" class="panel-collapse collapse"
												role="tabpanel" aria-labelledby="headingThree">
												<div class="panel-body" style="padding: 5px;">
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 询问病史及体格检查 </a>
														</div>
													</div>
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 完成病历书写 </a>
														</div>
													</div>
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 开检查单 </a>
														</div>
													</div>
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 上级医师查房 </a>
														</div>
													</div>
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 完成术前准备与术前评估 </a>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="row">
								<div class="col-xs-12 text-center" style="margin: 2% 0;">
									<h4 style="color: #4162EF;">住院第二天(手术日)</h4>
								</div>
							</div>
							<div class="row bg-info">
								<div class="col-xs-3 text-center" style="margin: 2% 0;">
									<h4 style="color: #4162EF;">第二天</h4>
								</div>
								<div class="col-xs-6 text-center" style="margin: 2% 0;">
									<h4 style="color: #4162EF;">2016-03-01</h4>
								</div>
								<div class="col-xs-3 text-center" style="margin: 2% 0;">
									<h4 style="color: #4162EF;">星期二</h4>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="panel-group" id="accordion-2" role="tablist"
										aria-multiselectable="true">
										<div class="panel panel-default">
											<div class="panel-heading" role="tab" id="headingOne-2">
												<h4 class="panel-title">
													<a role="button" data-toggle="collapse"
														data-parent="#accordion-2" href="#collapseOne-2"
														aria-expanded="false" aria-controls="collapseOne-2"
														style="width: 100%;display: inline-block;"> 主要护理工作 </a>
												</h4>
											</div>
											<div id="collapseOne-2" class="panel-collapse collapse"
												role="tabpanel" aria-labelledby="headingOne-2">
												<div class="panel-body" style="padding: 5px;">
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 为新生儿注射卡介苗及乙肝育苗 </a>
															<!--</div>-->
														</div>
													</div>
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 随时观察产妇情况 </a>
														</div>
													</div>
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 帮助产妇早开奶丶、早吸吮 </a>
														</div>
													</div>
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 术后心里护理及生活护理 </a>
														</div>
													</div>
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 健康教育包括饮食等指导产妇术后活动 </a>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="panel panel-default">
											<div class="panel-heading" role="tab" id="headingTwo-2">
												<h4 class="panel-title">
													<a class="collapsed" role="button" data-toggle="collapse"
														data-parent="#accordion-2" href="#collapseTwo-2"
														aria-expanded="false" aria-controls="collapseTwo-2"
														style="width: 100%;display: inline-block;"> 重点医嘱 </a>
												</h4>
											</div>
											<div id="collapseTwo-2" class="panel-collapse collapse"
												role="tabpanel" aria-labelledby="headingTwo-2">
												<div class="panel-body" style="padding: 5px;">
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<!--<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#testmodal">-->
															<!--入院宣教-->
															<!--</button>-->
															<!--<div style="height: 0;padding-bottom: 100%;">-->
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 检查血压、血氧饱和度 </a>
															<!--</div>-->
														</div>
													</div>
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 观察腹痛、阴道流血情况 </a>
														</div>
													</div>
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 留置导尿 </a>
														</div>
													</div>
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 临时医嘱 </a>
														</div>
													</div>
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 急查血细胞分析全套 </a>
														</div>
													</div>
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 急诊术前特检 </a>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="panel panel-default">
											<div class="panel-heading" role="tab" id="headingThree-2">
												<h4 class="panel-title">
													<a class="collapsed" role="button" data-toggle="collapse"
														data-parent="#accordion-2" href="#collapseThree-2"
														aria-expanded="false" aria-controls="collapseThree-2"
														style="width: 100%;display: inline-block;"> 主要诊疗工作 </a>
												</h4>
											</div>
											<div id="collapseThree-2" class="panel-collapse collapse"
												role="tabpanel" aria-labelledby="headingThree-2">
												<div class="panel-body" style="padding: 5px;">
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 询问病史及体格检查 </a>
														</div>
													</div>
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 完成病历书写 </a>
														</div>
													</div>
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 开检查单 </a>
														</div>
													</div>
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 上级医师查房 </a>
														</div>
													</div>
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 完成术前准备与术前评估 </a>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="row">
								<div class="col-xs-12 text-center" style="margin: 2% 0;">
									<h4 style="color: #4162EF;">住院第三-四天</h4>
								</div>
							</div>
							<div class="row bg-info">
								<div class="col-xs-3 text-center" style="margin: 2% 0;">
									<h4 style="color: #4162EF;">第三天</h4>
								</div>
								<div class="col-xs-6 text-center" style="margin: 2% 0;">
									<h4 style="color: #4162EF;">2016-03-02</h4>
								</div>
								<div class="col-xs-3 text-center" style="margin: 2% 0;">
									<h4 style="color: #4162EF;">星期三</h4>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="panel-group" id="accordion-3" role="tablist"
										aria-multiselectable="true">
										<div class="panel panel-default">
											<div class="panel-heading" role="tab" id="headingOne-3">
												<h4 class="panel-title">
													<a role="button" data-toggle="collapse"
														data-parent="#accordion-3" href="#collapseOne-3"
														aria-expanded="false" aria-controls="collapseOne-3"
														style="width: 100%;display: inline-block;"> 主要护理工作 </a>
												</h4>
											</div>
											<div id="collapseOne-3" class="panel-collapse collapse"
												role="tabpanel" aria-labelledby="headingOne-3">
												<div class="panel-body" style="padding: 5px;">
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<!--<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#testmodal">-->
															<!--入院宣教-->
															<!--</button>-->
															<!--<div style="height: 0;padding-bottom: 100%;">-->
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 入院宣教 </a>
															<!--</div>-->
														</div>
													</div>
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 介绍病房环境设施和设备 </a>
														</div>
													</div>
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 入院护理评估 </a>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="panel panel-default">
											<div class="panel-heading" role="tab" id="headingTwo-3">
												<h4 class="panel-title">
													<a class="collapsed" role="button" data-toggle="collapse"
														data-parent="#accordion-3" href="#collapseTwo-3"
														aria-expanded="false" aria-controls="collapseTwo-3"
														style="width: 100%;display: inline-block;"> 重点医嘱 </a>
												</h4>
											</div>
											<div id="collapseTwo-3" class="panel-collapse collapse"
												role="tabpanel" aria-labelledby="headingTwo-3">
												<div class="panel-body" style="padding: 5px;">
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<!--<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#testmodal">-->
															<!--入院宣教-->
															<!--</button>-->
															<!--<div style="height: 0;padding-bottom: 100%;">-->
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 检查血压、血氧饱和度 </a>
															<!--</div>-->
														</div>
													</div>
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 观察腹痛、阴道流血情况 </a>
														</div>
													</div>
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 留置导尿 </a>
														</div>
													</div>
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 临时医嘱 </a>
														</div>
													</div>
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 急查血细胞分析全套 </a>
														</div>
													</div>
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 急诊术前特检 </a>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="panel panel-default">
											<div class="panel-heading" role="tab" id="headingThree-3">
												<h4 class="panel-title">
													<a class="collapsed" role="button" data-toggle="collapse"
														data-parent="#accordion-3" href="#collapseThree-3"
														aria-expanded="false" aria-controls="collapseThree-3"
														style="width: 100%;display: inline-block;"> 主要诊疗工作 </a>
												</h4>
											</div>
											<div id="collapseThree-3" class="panel-collapse collapse"
												role="tabpanel" aria-labelledby="headingThree-3">
												<div class="panel-body" style="padding: 5px;">
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 询问病史及体格检查 </a>
														</div>
													</div>
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 完成病历书写 </a>
														</div>
													</div>
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 开检查单 </a>
														</div>
													</div>
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 上级医师查房 </a>
														</div>
													</div>
													<div class="row">
														<div class="col-xs-2">
															<img src="images/friend.png">
														</div>
														<div class="col-xs-10" style="margin: 1% 0;">
															<a role="button" data-toggle="modal"
																data-target="#testmodal"> 完成术前准备与术前评估 </a>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						其他内容
					</div>
					<!-- Controls -->
					<!--<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">-->
					<!--<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>-->
					<!--<span class="sr-only">Previous</span>-->
					<!--</a>-->
					<!--<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">-->
					<!--<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>-->
					<!--<span class="sr-only">Next</span>-->
					<!--</a>-->
					<a class="left carousel-control" href="#carousel-example-generic"
						role="button" data-slide="prev"> <img
						src="images/icon-arrow-left.png"
						class="img-responsive center-block"
						style="position: absolute;top: 30%;"> <span class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#carousel-example-generic"
						role="button" data-slide="next"> <img
						src="images/icon-arrow-right.png"
						class="img-responsive center-block"
						style="position: absolute;top: 30%;"> <span class="sr-only">Next</span>
					</a>
				</div>
				<!--<div class="clearfix"></div>-->
			</div>
		</div>
		<div style="height: 354px;"></div>
	</div>
	<div class="container"
		style="bottom: 60px;left: 16px;position: fixed;
            z-index: 100;background: #EEE;">
		<div class="row">
			<div class="col-xs-12">
				<div class="row"
					style="margin: 2% 0;border-bottom: dashed 1px #23527c;padding-bottom: 2%;">
					<div class="col-xs-12">
						<h3 style="color: #0093DD;">评估情况:</h3>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-4">
						<span>评估人:</span>
					</div>
					<div class="col-xs-8">
						<span>刘诗诗</span>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-4">
						<span>评估结果:</span>
					</div>
					<div class="col-xs-8">
						<span>正常</span>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12">
						<span>评估说明:</span>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12">医嘱啊,医嘱,你像看得见的房子,摸不着的房价,揪着老百姓的心啊!
						医嘱啊,医嘱,你像看得见的蓝天,摸不着的草地,系跘着驿动的心啊!</div>
				</div>
			</div>
		</div>
	</div>
	<!--导航结束-->
	<div class="clear"></div>
	<!--页脚开始-->
	<div id="footer">
		<div class="plug-div">
			<div class="plug-phone">
				<div class="plug-menu themeStyle">
					<!--<a class="ui-btn-back" href="javascript:history.go(-1)"></a>-->
					<a
						style="top: 0;left: 0;background: url(ky_img/back.png) no-repeat center center;
                    background-size: 24px auto;display: block;position: absolute;width: 50px;
                    height: 44px;text-indent: -9999px;margin: -5px;padding: 0;"
						href="javascript:history.go(-1)"></a>
					<!--<div class="themeStyle plug-btn plug-btn1 open">-->
					<!--<a href="/"><span style="background-image: url(ky_img/home.png);"></span></a>-->
					<!--</div>-->

				</div>
				<div
					style="bottom: 16px;left: 80px;width: 36px;height: 36px;border-radius: 36px;position: absolute;
            z-index: 999;background: #DE270B;">
					<a href="views/yewumokuai.jsp"> <span
						style="background-image: url(ky_img/home.png);
                display: block;width: 28px;height: 28px;background-size: 28px 28px;text-indent: -999px;
                position: absolute;top: 50%;left: 50%;margin-top: -14px;margin-left: -14px;overflow: hidden;"></span>
					</a>
				</div>
			</div>
		</div>
		<div class="copyright">
			这里是底部信息<br>声明：目前是测试版本,图标含义与业务功能模块可能不匹配。
		</div>
	</div>
	<!--页脚结束-->
	<!-- modal-dailog -->
	<div class="modal fade" role="dialog"
		aria-labelledby="gridSystemModalLabel" id="testmodal">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="gridSystemModalLabel">检查血压、血氧饱和度</h4>
				</div>
				<div class="modal-body">
					<div class="container-fluid">
						<div class="row">
							<div class="col-xs-4">执行人:</div>
							<div class="col-xs-8">王菲</div>
						</div>
						<div class="row">
							<div class="col-xs-4">执行结果:</div>
							<div class="col-xs-8">已执行</div>
						</div>
						<div class="row">
							<div class="col-xs-4">执行时间:</div>
							<div class="col-xs-8">2016-03-01 15:18:00</div>
						</div>
						<div class="row">
							<div class="col-xs-4">执行说明:</div>
							<div class="col-xs-8">说点什么好呢?</div>
						</div>
						<div class="row"
							style="margin: 2% 0;border-bottom: dashed 1px #23527c;padding-bottom: 2%;">
							<div class="col-xs-12">
								<h3 style="color: #0093DD;">医嘱摘要:</h3>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12">医嘱啊,医嘱,你像看得见,摸不着的狂草,揪着病人的心啊!
								医嘱啊,医嘱,你像看得见,摸不着的狂草,揪着病人的心啊! 医嘱啊,医嘱,你像看得见,摸不着的狂草,揪着病人的心啊!</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary">修改保存</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	<script type="text/javascript" src="scripts/bootstrap.min.js"></script>
</body>
</html>