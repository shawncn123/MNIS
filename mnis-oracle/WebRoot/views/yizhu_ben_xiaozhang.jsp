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
<title>医嘱本</title>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="沈旭峰" />
<meta name="keywords" content="移动护理信息系统" />
<meta name="description" content="医嘱本,高大上的移动护理系统。" />
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="SHORTCUT ICON" href="images/favicon.ico">
<link rel="icon" href="images/favicon.ico" type="image/x-icon">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/custom.css" />
<script type="text/javascript" src="scripts/jquery-1.12.1.min.js"></script>
</head>
<body>
	<div id="header">
		<%-- <div class="row"
			style="border-bottom:1px solid #269abc;padding-top: 3px;">
			<div class="col-xs-2">
				<a href="#"> <img src="images/icon-m-man-active.png"
					class="img-responsive" alt="${bingrgetixingxi.xm }">
				</a>
			</div>
			<div class="col-xs-4">
				<span><strong>${bingrgetixingxi.xm }&nbsp;${bingrgetixingxi.chw }&nbsp;床</strong></span>
				<p class="text-left" style="margin-bottom: 5px;">${bingrgetixingxi.nl }&nbsp;岁</p>
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
							<td><a href="bingqbr_bysessionbingqid" class="text-center"> <img
									src="images/brxxxx_header_3.png" class="img-responsive"
									alt="病人列表">
							</a></td>
							<td><a href="bingreng_yewumokuai?v_key1=${bingrgetixingxi.key1 }&v_key2=${bingrgetixingxi.key2}" class="text-center"> <img
									src="images/brxxxx_header_4.png" class="img-responsive"
									alt="业务模块">
							</a></td>
						</tr>
					</table>
				</div>
			</div>
		</div> --%>
		<div class="header">
			<div class="section">
				<div class="man"></div>
			</div>
			<div class="section">
				<p>
					<span><strong>${bingrgetixingxi.xm }&nbsp;${bingrgetixingxi.chw }&nbsp;床</strong></span>
				</p>
				<p>30&nbsp;岁</p>
			</div>
			<div class="section">
				<ul>
					<li><a href="#" class="pic1"></a></li>
					<li><a href="#" class="pic2"></a></li>
					<li><a href="bingqbr_bysessionbingqid" class="pic3"></a></li>
					<li><a href="bingreng_yewumokuai?v_key1=${bingrgetixingxi.key1 }&v_key2=${bingrgetixingxi.key2}" class="pic4"></a></li>
				</ul>
			</div>
		</div>
	</div>
	<div id="content" class="container">
		<div class="sel">
			<div class="sec">
				<form action="#">
					<div class="form-group">

						<select class="form-control">
							<option>状态</option>
							<option>全部</option>
							<option>有效</option>
							<option>停止</option>
						</select>
					</div>
				</form>
			</div>
			<div class="sec">
				<form action="#">
					<div class="form-group">

						<select class="form-control">
							<option>标志</option>
							<option>全部</option>
							<option>长期</option>
							<option>临时</option>
						</select>
					</div>
				</form>
			</div>
			<div class="sec">
				<form action="#">
					<div class="form-group">

						<select class="form-control">
							<option>来源</option>
							<option>全部</option>
							<option>药品</option>
							<option>治疗</option>
						</select>
					</div>
				</form>
			</div>
			<div class="sec">
				<form action="#">
					<div class="form-group">

						<select class="form-control">
							<option>类别</option>
							<option>全部</option>
							<option>卫材</option>
							<option>西成药</option>
							<option>中成药</option>
							<option>中草药</option>
							<option>配方</option>
							<option>检查</option>
							<option>检验</option>
							<option>治疗</option>
							<option>手术</option>
							<option>麻醉</option>
							<option>护理</option>
							<option>膳食</option>
							<option>输血</option>
							<option>输氧</option>
							<option>材料</option>
							<option>其它</option>
						</select>

					</div>
				</form>
			</div>
		</div>
		<div class="container">
			<s:iterator value="#request.bingrGeTi_YiZhu">
				<div class="row">
					<div class="col-xs-12 bor-ra .order-c1">
						<s:iterator value="vwBryzRemodelSubs">
							<div class="row">
								<span>${yzmc }</span>
							</div>
							<div class="col-xs-5">
								<span>${dcyl}</span>
							</div>
						</s:iterator>
						<div class="row">
							<div class="col-xs-12 text-right"
								style="margin: 10px 0 10px 0;padding-bottom: 5px;border-top: #666666 1px dashed;">
								<span style="color: #6daced">TID</span>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-2 text-center">
								<span
									style="font-size: 18px;border-radius: 20px;border: 2px solid #388AF1;padding: 5px;
            				color: #388AF1;">普</span>
							</div>
							<div class="col-xs-10">
								<div class="row">
									<div class="col-xs-12 ">
										<span>${yf1mc }</span>
									</div>
									<div class="row">
										<div class="col-xs-4">
											<span>开嘱时间:</span>
										</div>
										<div class="col-xs-8">
											<span>${kstime}</span>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</s:iterator>
			

		</div>
		<div class="row">
			<div class="col-xs-5">
				<span>a-抗干扰素注射液</span>
			</div>
			<div class="col-xs-5">
				<span>100万U*1支</span>
			</div>
			<div class="col-xs-2" style="padding: 0 5px;">
				<span>12&nbsp;万u</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12 text-right"
				style="margin: 10px 0 10px 0;padding-bottom: 5px;border-top: #666666 1px dashed;">
				<span style="color: #6daced">TID</span>
			</div>
		</div>
		<div class="row"
			style="border-bottom: 2px solid #333333;padding-bottom: 10px;margin-bottom: 10px;">
			<div class="col-xs-2 text-center">
				<span
					style="font-size: 18px;border-radius: 20px;border: 2px solid #388AF1;padding: 5px;
            color: #388AF1;">普</span>
			</div>
			<div class="col-xs-10">
				<div class="row">
					<div class="col-xs-12">
						<span>口服</span>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-4">
						<span>开嘱时间:</span>
					</div>
					<div class="col-xs-8">
						<span>2016-03-02 10:20:00</span>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-5">
				<span>0.9%氯化钠注射液</span>
			</div>
			<div class="col-xs-5">
				<span>500ml/每瓶(外用)</span>
			</div>
			<div class="col-xs-2">
				<span>5.5&nbsp;ml</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12 text-right"
				style="margin: 10px 0 10px 0;padding-bottom: 5px;border-top: #666666 1px dashed;">
				<span style="color: #6daced">TID</span>
			</div>
		</div>
		<div class="row"
			style="border-bottom: 2px solid #333333;padding-bottom: 10px;margin-bottom: 10px;">
			<div class="col-xs-2 text-center">
				<span
					style="font-size: 18px;border-radius: 20px;border: 2px solid #388AF1;padding: 5px;
            color: #388AF1;">普</span>
			</div>
			<div class="col-xs-10">
				<div class="row">
					<div class="col-xs-12">
						<span>口服</span>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-4">
						<span>开嘱时间:</span>
					</div>
					<div class="col-xs-8">
						<span>2016-03-02 21:50:00</span>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-5">
				<span>0.9%氯化钠注射液</span>
			</div>
			<div class="col-xs-5">
				<span>10ml*5支/盒</span>
			</div>
			<div class="col-xs-2">
				<span>50&nbsp;ml</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12 text-right"
				style="margin: 10px 0 10px 0;padding-bottom: 5px;border-top: #666666 1px dashed;">
				<span style="color: #6daced">TID</span>
			</div>
		</div>
		<div class="row"
			style="border-bottom: 2px solid #333333;padding-bottom: 10px;margin-bottom: 10px;">
			<div class="col-xs-2 text-center">
				<span
					style="font-size: 18px;border-radius: 20px;border: 2px solid #388AF1;padding: 5px;
            color: #388AF1;">普</span>
			</div>
			<div class="col-xs-10">
				<div class="row">
					<div class="col-xs-12">
						<span>口服</span>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-4">
						<span>开嘱时间:</span>
					</div>
					<div class="col-xs-8">
						<span>2016-03-03 09:00:00</span>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-5">
				<span>阿昔洛韦片</span>
			</div>
			<div class="col-xs-5">
				<span>0.1g*24/盒</span>
			</div>
			<div class="col-xs-2">
				<span>1&nbsp;g</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12 text-right"
				style="margin: 10px 0 10px 0;padding-bottom: 5px;border-top: #666666 1px dashed;">
				<span style="color: #6daced">TID</span>
			</div>
		</div>
		<div class="row"
			style="border-bottom: 2px solid #333333;padding-bottom: 10px;margin-bottom: 10px;">
			<div class="col-xs-2 text-center">
				<span
					style="font-size: 18px;border-radius: 20px;border: 2px solid #388AF1;padding: 5px;
            color: #388AF1;">普</span>
			</div>
			<div class="col-xs-10">
				<div class="row">
					<div class="col-xs-12">
						<span>口服</span>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-4">
						<span>开嘱时间:</span>
					</div>
					<div class="col-xs-8">
						<span>2016-03-01 09:30:00</span>
					</div>
				</div>
			</div>
		</div>

		<div class="clear"></div>

	</div>
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
					style="bottom: 60px;left: 16px;width: 36px;height: 36px;border-radius: 36px;position: absolute;
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
	<script type="text/javascript" src="scripts/bootstrap.min.js"></script>
</body>
</html>