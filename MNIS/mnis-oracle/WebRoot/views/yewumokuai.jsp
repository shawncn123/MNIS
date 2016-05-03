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
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="scripts/jquery-1.12.1.min.js"></script>
<script src="js/common.js" type="text/javascript"></script>
</head>
<body>
	<%-- <%
		String key1 =  request.getParameter("bingren_key1");
		String key2 =  request.getParameter("bingren_key2");
		String xingm =  request.getParameter("bingren_name");
		String chuangw =  request.getParameter("bingren_cw");
		String niann =  request.getParameter("bingren_nl");
		String bingqid =  request.getParameter("bingren_bq");
	%> --%>
	<div id="header">
		<div class="row"
			style="border-bottom:1px solid #269abc;padding-top: 3px;">
			<div class="col-xs-2">
				<a href="#"> <img src="images/icon-m-man-active.png"
					class="img-responsive" alt="范冰冰">
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
							<td><a href="" class="text-center"> <img
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
		<ul class="channellist">
			<li><a href="bingrengeti_jibenxingxi?v_key1=${bingrgetixingxi.key1}&v_key2=${bingrgetixingxi.key2}">
					<div class="ChannelIcon">
						<img src="images/about.jpg" />
					</div>
					<div class="ChannelName">病人信息</div>
			</a></li>
			<li><a href="bingrengeti_bingan_shouye?v_key1=${bingrgetixingxi.key1}&v_key2=${bingrgetixingxi.key2}">
					<div class="ChannelIcon">
						<img src="images/news.jpg" />
					</div>
					<div class="ChannelName">病案首页</div>
			</a></li>
			<li><a href="bingrGeTi_YiZhuBen?v_key1=${bingrgetixingxi.key1}&v_key2=${bingrgetixingxi.key2}&v_yebh=0">
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
			<li><a href="bingrGeTi_JianYan?v_key1=${bingrgetixingxi.key1}&v_key2=${bingrgetixingxi.key2}&v_yebh=0">
					<div class="ChannelIcon">
						<img src="images/1408672469.jpg" />
					</div>
					<div class="ChannelName">检验报告</div>
			</a></li>
			<li><a href="views/jianchabaogao.jsp">
					<div class="ChannelIcon">
						<img src="images/1408672443.jpg" />
					</div>
					<div class="ChannelName">检查报告</div>
			</a></li>
			<li><a href="views/linchuanglujing.jsp">
					<div class="ChannelIcon">
						<img src="images/1409023353.jpg" />
					</div>
					<div class="ChannelName">临床路径</div>
			</a></li>
			<li><a href="views/hulibingli.jsp">
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
			</a></li>
			
			<li><a href="Merchants.html">
					<div class="ChannelIcon">
						<img src="images/1408672427.jpg" />
					</div>
					<div class="ChannelName">输液巡视</div>
			</a></li>
			<li><a href="Recruitment.html">
					<div class="ChannelIcon">
						<img src="images/1409023367.jpg" />
					</div>
					<div class="ChannelName">医嘱执行</div>
			</a></li>
<%-- 			<li><a href="tizhengluru?v_key1=${bingrgetixingxi.key1}&v_key2=${bingrgetixingxi.key2}&v_bqid=<% out.print(bingqid); %>"> --%>
			
			<li><a href="Contact.html">
					<div class="ChannelIcon">
						<img src="images/mokuai_4.jpg" />
					</div>
					<div class="ChannelName">Help帮助</div>
			</a></li>
		</ul>
		<!--导航结束-->
		<div class="clear"></div>

	</div>
	<!--页脚开始-->
	<div id="footer">
		<!--&lt;!&ndash; 微信分享导引 开始&ndash;&gt;-->
		<!--<script>        function openGuide() {-->
		<!--document.getElementById('guide').style.display = 'block';-->
		<!--}-->

		<!--function closeGuide() {-->
		<!--document.getElementById('guide').style.display = '';-->
		<!--}-->

		<!--</script>-->
		<!--<div id="guide" onclick="closeGuide()">-->
		<!--<img src="images/guide.png"/>-->
		<!--</div>-->
		<!--&lt;!&ndash; 微信分享导引 结束&ndash;&gt;-->
		<!--&lt;!&ndash;快捷按钮 开始&ndash;&gt;-->
		<!--<div class="plug-div">-->
		<!--<div class="plug-phone">-->
		<!--<div class="plug-menu themeStyle">-->
		<!--<span class="close"></span>-->
		<!--</div>-->
		<!--<div class="themeStyle plug-btn plug-btn1 close">-->
		<!--<a href="/"><span style="background-image: url(ky_img/home.png);"></span></a>-->
		<!--</div>-->
		<!--<div class="themeStyle plug-btn plug-btn2 close">-->
		<!--<a href="Contact.html"><span style="background-image: url(ky_img/tel.png);"></span></a>-->
		<!--</div>-->
		<!--<div class="themeStyle plug-btn plug-btn3 close">-->
		<!--<a href="About.html"><span style="background-image: url(ky_img/aboutus.png);"></span></a>-->
		<!--</div>-->
		<!--<div class="themeStyle plug-btn plug-btn4 close">-->
		<!--<a href="Message.html"><span style="background-image: url(ky_img/guestbook.png);"></span></a>-->
		<!--</div>-->
		<!--<div class="plug-btn plug-btn5 close"></div>-->
		<!--</div>-->
		<!--</div>-->
		<!--&lt;!&ndash;快捷按钮 结束&ndash;&gt;-->
		<div class="plug-div">
			<div class="plug-phone">
				<div class="plug-menu themeStyle">
					<!--<a class="ui-btn-back" href="javascript:history.go(-1)"></a>-->
					<a
						style="top: 0px;left: 0px;background: url(ky_img/back.png) no-repeat center center;
                    background-size: 24px auto;display: block;position: absolute;width: 50px;
                    height: 44px;text-indent: -9999px;margin: -5px;padding: 0;"
						href="javascript:history.go(-1)"></a>
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
