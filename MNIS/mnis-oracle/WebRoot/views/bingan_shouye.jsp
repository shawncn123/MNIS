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
<title>病案首页</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="沈旭峰" />
<meta name="keywords" content="移动护理信息系统" />
<meta name="description" content="病案首页,高大上的移动护理系统。" />
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="scripts/jquery-1.12.1.min.js"></script>
<script src="js/common.js" type="text/javascript"></script>
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
		<div class="row">
			<div class="col-xs-12"
				style="margin: 5px 0 5px 0;padding-bottom: 5px;border-bottom: #666666 1px solid;">
				<h3>基本信息</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-3">
				<span>姓名:</span>
			</div>
			<div class="col-xs-3">
				<span>范冰冰</span>
			</div>
			<div class="col-xs-3">
				<span>性别</span>
			</div>
			<div class="col-xs-3">
				<span>女</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-3">
				<span>年龄:</span>
			</div>
			<div class="col-xs-9">
				<span>25</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-3">
				<span>住院号:</span>
			</div>
			<div class="col-xs-5">
				<span>20160000086(1)床</span>
			</div>
			<div class="col-xs-4">
				<span>第一次住院</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-3">
				<span>婚姻:</span>
			</div>
			<div class="col-xs-3">
				<span>已婚</span>
			</div>
			<div class="col-xs-3">
				<span>国籍</span>
			</div>
			<div class="col-xs-3">
				<span>中国</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-3">
				<span>民族:</span>
			</div>
			<div class="col-xs-9">
				<span>汉</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-3">
				<span>身份证号:</span>
			</div>
			<div class="col-xs-9">
				<span>110101198512012676</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-3">
				<span>付款方式:</span>
			</div>
			<div class="col-xs-9">
				<span>社会基本医疗保险</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-3">
				<span>职业:</span>
			</div>
			<div class="col-xs-9">
				<span>工人</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12"
				style="margin: 5px 0 5px 0;padding-bottom: 5px;border-bottom: #666666 1px solid;">
				<h3>诊断信息</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-3">
				<span>中医诊断:</span>
			</div>
			<div class="col-xs-9">
				<span style="color: #B70000"></span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-3">
				<span>西医诊断:</span>
			</div>
			<div class="col-xs-9">
				<span style="color: #B70000">(000.101)输卵管妊娠....</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12"
				style="margin: 5px 0 5px 0;padding-bottom: 5px;border-bottom: #666666 1px solid;">
				<h3>住院信息</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-3">
				<span>入院时间</span>
			</div>
			<div class="col-xs-9">
				<span>2016-02-28 10:42:00</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-3">
				<span>住院天数</span>
			</div>
			<div class="col-xs-9">
				<span>1557天</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-3">
				<span>科室:</span>
			</div>
			<div class="col-xs-3">
				<span>妇产二科</span>
			</div>
			<div class="col-xs-3">
				<span>病情:</span>
			</div>
			<div class="col-xs-3">
				<span>一般</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-3">
				<span>主治医师:</span>
			</div>
			<div class="col-xs-3">
				<span style="color: #d19c36">周杰伦</span>
			</div>
			<div class="col-xs-3">
				<span>主任医师:</span>
			</div>
			<div class="col-xs-3">
				<span style="color: #d19c36">刘涛</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-3">
				<span>主院医师:</span>
			</div>
			<div class="col-xs-3">
				<span style="color: #d19c36">汤唯</span>
			</div>
			<div class="col-xs-3">
				<span>责任护士:</span>
			</div>
			<div class="col-xs-3">
				<span style="color: #d19c36">杨幂</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12"
				style="margin: 5px 0 5px 0;padding-bottom: 5px;border-bottom: #666666 1px solid;">
				<h3>联系方式</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-3">
				<span>联系人姓名:</span>
			</div>
			<div class="col-xs-9">
				<span>刘诗诗</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-3">
				<span>联系人电话:</span>
			</div>
			<div class="col-xs-9">
				<span>13901396688</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-3">
				<span>联系人地址:</span>
			</div>
			<div class="col-xs-9">
				<span>北京市朝阳区花果山路水帘洞小区6号楼5单元1022房间</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-4">
				<span>家庭电话:</span>
			</div>
			<div class="col-xs-8">
				<span>0531-85326753</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-3">
				<span>家庭地址:</span>
			</div>
			<div class="col-xs-9">
				<span>北京市朝阳区花果山路水帘洞小区6号楼5单元1022房间</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-3">
				<span>出生地点:</span>
			</div>
			<div class="col-xs-9">
				<span>北京市朝阳区中日友好医院</span>
			</div>
		</div>
		<!--导航结束-->
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
</body>
</html>
