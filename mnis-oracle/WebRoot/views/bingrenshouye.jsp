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
<title>病人相关业务</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="沈旭峰" />
<meta name="keywords" content="移动护理信息系统" />
<meta name="description" content="业务模块,高大上的移动护理系统。" />
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<link href="css/base.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/song.css" />
<script type="text/javascript" src="scripts/jquery-1.12.1.min.js"></script>
<script src="scripts/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<script src="scripts/viewjs.js" type="text/javascript" charset="utf-8"></script>
<script src="scripts/song.js" type="text/javascript" charset="utf-8"></script>	
<!-- <link href="css/style.css" rel="stylesheet" type="text/css" />
<script src="js/common.js" type="text/javascript"></script> -->
</head>
<body>
	<div id="header">
		<div class="row"
			style="border-bottom:1px solid #269abc;padding-top: 3px;">
			<div class="col-xs-2">
				<a href="javascript:void(0)"> <img src="images/icon-m-man-active.png"
					class="img-responsive" alt="${bingrgetixingxi.xm }">
				</a>
			</div>
			<div class="col-xs-4">
				<span><strong>${bingrgetixingxi.xm }&nbsp;${bingrgetixingxi.chw }&nbsp;床</strong></span>
				<p class="text-left" style="margin-bottom: 5px;">${bingrgetixingxi.nl }</p>
			</div>
			<div class="col-xs-6 bg-info">
				<div class="table table-responsive"
					style="margin-bottom: 0;border: none;">
					<table class="table table-condensed"
						style="background-color: #d9edf7">
						<tr>
							<td><a href="javascript:void(0)" class="text-center"> <img
									src="images/brxxxx_header_1.png" class="img-responsive"
									alt="消息数">
							</a></td>
							<td><a href="javascript:void(0)" class="text-center"> <img
									src="images/brxxxx_header_2.png" class="img-responsive"
									alt="刷新">
							</a></td>
							<td><a href="bingqbr_bysessionbingqid" class="text-center"> <img
									src="images/brxxxx_header_3.png" class="img-responsive"
									alt="病人列表">
							</a></td>
							<td><a href="javascript:void(0)" class="text-center"> <img
									src="images/brxxxx_header_4.png" class="img-responsive"
									alt="消息数">
							</a></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div id="content">
		<!--导航开始-->
		<ul class="channellist clearfix">
			<li>
				<a href="bingrengeti_jibenxingxi">
					<div class="ChannelIcon">
						<img src="images/about.jpg" />
					</div>
					<div class="ChannelName">病人信息</div>
			</a></li>
			<li>
			<a href="bingrengeti_bingan_shouye">
					<div class="ChannelIcon">
						<img src="images/news.jpg" />
					</div>
					<div class="ChannelName">病案首页</div>
			</a></li>
			<li>
			<a href="bingrGeTi_YiZhuBen">
					<div class="ChannelIcon">
						<img src="images/Product.jpg" />
					</div>
					<div class="ChannelName">医嘱本</div>
			</a></li>
			<li><a href="tizhengluru?v_key1=${bingrgetixingxi.key1}&v_key2=${bingrgetixingxi.key2}">
					<div class="ChannelIcon">
						<img src="images/mokuai_2.jpg" />
					</div>
					<div class="ChannelName">体征录入</div>
			</a></li>
			<li>
			<a href="bingrGeTi_JianYan">
					<div class="ChannelIcon">
						<img src="images/1408672469.jpg" />
					</div>
					<div class="ChannelName">检验报告</div>
			</a></li>
			<li><a href="bingrGeTi_JianCha">
					<div class="ChannelIcon">
						<img src="images/1408672443.jpg" />
					</div>
					<div class="ChannelName">检查报告</div>
			</a></li>
			<li><a href="bingrGeTi_YiZhuZhiXing">
					<div class="ChannelIcon">
						<img src="images/1409023367.jpg" />
					</div>
					<div class="ChannelName">医嘱执行</div>
			</a></li>
			<li><a href="bingrgeti_TiWenDan">
					<div class="ChannelIcon">
						<img src="images/1408672427.jpg" />
					</div>
					<div class="ChannelName">体温单</div>
			</a></li>
			 <li><a href="views/linchuanglujing.jsp">
					<div class="ChannelIcon">
						<img src="images/1409023353.jpg" />
					</div>
					<div class="ChannelName">临床路径</div>
			</a></li>
			<!--<li><a href="views/hulibingli.jsp">
					<div class="ChannelIcon">
						<img src="images/1408672415.jpg" />
					</div>
					<div class="ChannelName">护理病历</div>
			</a></li>
			
			<li><a href="views/bingliwenjian.jsp">
					<div class="ChannelIcon">
						<img src="images/1408672456.jpg" />
					</div>
					<div class="ChannelName">病历文件</div>
			</a></li> -->
			<li>
				<a href="xuanjiaolist">
					<div class="ChannelIcon">
						<img src="images/about.jpg" />
					</div>
					<div class="ChannelName">宣教</div>
				</a>
			</li>
			<li><a href="javascript:void(0)">
					<div class="ChannelIcon">
						<img src="images/mokuai_4.jpg" />
					</div>
					<div class="ChannelName">Help帮助</div>
			</a></li>
		</ul>
		<%@ include file="menu-hushi.jsp" %>
		<div class="clear"></div>
	</div>
	
	<!--页脚开始-->
	<%@ include file="footer.jsp" %>
	<!--页脚结束-->
</body>
</html>
