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
<title>患者相关业务</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="SHORTCUT ICON" href="images/favicon.ico">
<link rel="icon" href="images/favicon.ico" type="image/x-icon">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="融汇国康" />
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
<script type="text/javascript">	
	$(function(){
		var url = "weiduxiaoxishu";
		$.post(url,function(data) {
			if(data!="" && data!="error"){
				$("#xxshu").text(data+"");
			}else{
				self.location = "views/login.jsp";
			};
		});
	});
</script>
<script type="text/javascript">
	$(function() {
		// 绑定
		$("#head_banner_1").smartFloat();
	});
</script>
</head>
<body>
	<div id="head_banner_1" style="z-index:1000;" class="bg-info">
		<div class="row" style="border-bottom:1px solid #269abc;padding-top: 3px; margin: 0;">
			<s:if test="#request.bingrenyexx!=null && #request.bingrenyexx.size()>0">
			<!-- 包含婴儿信息的 -->
			<div class="col-xs-3 " style="padding-right: 0; padding-left: 10px; margin-left: -2%; color: #807D7D; ">
				<strong style="color: #272626; ">${bingrgetixingxi.xm }</strong>
				<p class="text-left " style="margin-bottom: 0; ">${bingrgetixingxi.chw }床&nbsp;${bingrgetixingxi.nl }</p>
			</div>
			<div class="col-xs-4" style="margin: 0 1%; padding: 0;">
				<select class="form-control" style="padding: 0; margin-top: 8%;">
					<s:iterator value="#request.bingrenyexx">
						<option value="${yebh}">${xm}</option>
					</s:iterator>
				</select>
			</div>
			<div class="col-xs-5 " style=" padding: 0 1% 0 0;">
				<div class="table table-responsive " style="margin-bottom: 0;border: none; ">
					<table class="table table-condensed " style="background-color: #d9edf7 ">
						<tbody>
							<tr>
								<td style="border: none; width: 34%; padding: 3px; position: relative;">
									<a href="mymessage?pageno=1" style="display: block;">
										<img style="width: 100%; height: 100%;"  src="images/brxxxx_header_1.png"/>
										<span style="display: block; text-align: center; color: #fff; font-size: 2rem; z-index: 2; position: absolute; top: 10PX; left: 0; width:100%; height:100%;"></span>
									</a>
								</td>
								<td style="border: none; padding: 3px;">
									<a href="bingreng_yewumokuai?v_key1=${v_key1}&v_key2=${v_key2}" class="text-center "> <img src="images/brxxxx_header_2.png " class="img-responsive " alt="刷新 " /> </a>
								</td>
								<td style="border: none; padding: 3px;">
									<a href="bingqbr_bysessionbingqid" class="text-center "> <img src="images/brxxxx_header_3.png " class="img-responsive " alt="病人列表 " /> </a>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			</s:if><s:else>
			<!-- 不包含婴儿信息的 -->
			<div class="col-xs-7 " style="padding-right: 0; margin-left: -2%; color: #807D7D; ">
				<strong style="color: #272626; ">${bingrgetixingxi.xm }</strong>
				<p class="text-left" style="margin-bottom: 0;">${bingrgetixingxi.chw }床&nbsp;${bingrgetixingxi.nl }</p>
			</div>
			<div class="col-xs-5 " style=" padding: 0 1% 0 0;">
				<div class="table table-responsive " style="margin-bottom: 0;border: none; ">
					<table class="table table-condensed " style="background-color: #d9edf7 ">
						<tbody>
							<tr>
								<td style="border: none; width: 34%; padding: 3px; position: relative;">
									<a href="mymessage?pageno=1" style="display: block;">
										<img style="width: 100%; height: 100%;"  src="images/brxxxx_header_1.png"/>
										<span style="display: block; text-align: center; color: #fff; font-size: 2rem; z-index: 2; position: absolute; top: 10PX; left: 0; width:100%; height:100%;" id="xxshu"></span>
									</a>
								</td>
								<td style="border: none; padding: 3px;">
									<a href="bingreng_yewumokuai?v_key1=${v_key1}&v_key2=${v_key2}" class="text-center "> <img src="images/brxxxx_header_2.png " class="img-responsive " alt="刷新 " /> </a>
								</td>
								<td style="border: none; padding: 3px;">
									<a href="bingqbr_bysessionbingqid" class="text-center "> <img src="images/brxxxx_header_3.png " class="img-responsive " alt="病人列表 " /> </a>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			</s:else>
		</div>
	</div>
	<div id="content">
		<!--导航开始-->
		<ul class="channellist clearfix">
			<li>
				<a href="bingrGeTi_YiZhuBen">
						<div class="ChannelIcon">
							<img src="images/Product.jpg" />
						</div>
						<div class="ChannelName">医嘱本</div>
				</a>
			</li>
			<li>
				<a href="tizhengluru?v_key1=${bingrgetixingxi.key1}&v_key2=${bingrgetixingxi.key2}">
					<div class="ChannelIcon">
						<img src="images/mokuai_2.jpg" />
					</div>
					<div class="ChannelName">体征录入</div>
				</a>
			</li>
			<li>
				<a href="bingrGeTi_YiZhuZhiXing">
					<div class="ChannelIcon">
						<img src="images/1409023367.jpg" />
					</div>
					<div class="ChannelName">医嘱执行</div>
				</a>
			</li>
			<li>
				<a href="views/tizhengluru_update">
					<div class="ChannelIcon">
						<img src="images/1408672415.jpg" />
					</div>
					<div class="ChannelName">体征录入修改</div>
				</a>
			</li>
			<li>
				<a href="bingrGeTi_JianYan">
					<div class="ChannelIcon">
						<img src="images/1408672469.jpg" />
					</div>
					<div class="ChannelName">检验报告</div>
				</a>
			</li>
			<li>
				<a href="bingrGeTi_JianCha">
					<div class="ChannelIcon">
						<img src="images/1408672443.jpg" />
					</div>
					<div class="ChannelName">检查报告</div>
				</a>
			</li>
			<li>
				<a href="bingrengeti_jibenxingxi">
					<div class="ChannelIcon">
						<img src="images/about.jpg" />
					</div>
					<div class="ChannelName">病人信息</div>
				</a>
			</li>
			<li>
				<a href="bingrengeti_bingan_shouye">
					<div class="ChannelIcon">
						<img src="images/news.jpg" />
					</div>
					<div class="ChannelName">病案首页</div>
				</a>
			</li>
			<li>
				<a href="xuanjiaolist">
					<div class="ChannelIcon">
						<img src="images/mokuai_4.jpg" />
					</div>
					<div class="ChannelName">宣教</div>
				</a>
			</li>
			<li>
				<a href="bingrgeti_TiWenDan">
					<div class="ChannelIcon">
						<img src="images/1408672427.jpg" />
					</div>
					<div class="ChannelName">体温单</div>
				</a>
			</li>
			<!--  <li><a href="views/linchuanglujing.jsp">
					<div class="ChannelIcon">
						<img src="images/1409023353.jpg" />
					</div>
					<div class="ChannelName">临床路径</div>
			</a></li> -->
			
			<!--
			<li><a href="views/bingliwenjian.jsp">
					<div class="ChannelIcon">
						<img src="images/1408672456.jpg" />
					</div>
					<div class="ChannelName">病历文件</div>
			</a></li> -->
			
		<!-- 	<li><a href="hzwxpg">
					<div class="ChannelIcon">
						<img src="images/1408672415.jpg" />
					</div>
					<div class="ChannelName">危险评估</div>
			</a></li> -->
			
			<li><a href="views/hulibingli.jsp">
					<div class="ChannelIcon">
						<img src="images/1408672456.jpg" />
					</div>
					<div class="ChannelName">护理评估</div>
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
