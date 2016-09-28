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
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="SHORTCUT ICON" href="images/favicon.ico">
<link rel="icon" href="images/favicon.ico" type="image/x-icon">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="沈旭峰" />
<meta name="keywords" content="移动护理信息系统" />
<meta name="description" content="医嘱本,高大上的移动护理系统。" />
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<link href="css/base.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/song.css"/>
<script type="text/javascript" src="scripts/jquery-1.12.1.min.js"></script>
<script type="text/javascript" src="scripts/viewjs.js"></script>
<script src="scripts/song.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		// 绑定
		$("#head_banner_1").smartFloat();
		
		var vfl =  "<s:property value='#request.fl' />";
		if(vfl==1){
			$("#dLabel").html('长期<span class="caret"></span>');
		}
		if(vfl==2){
			$("#dLabel").html('临时<span class="caret"></span>');
		}
		if(vfl==3){
			$("#dLabel").html('药品<span class="caret"></span>');
		}
		if(vfl==4){
			$("#dLabel").html('诊疗项目<span class="caret"></span>');
		}
		if(vfl==5){
			$("#dLabel").html('材料<span class="caret"></span>');
		}
		if(vfl==6){
			$("#dLabel").html('有效<span class="caret"></span>');
		}
		if(vfl==7){
			$("#dLabel").html('停止<span class="caret"></span>');
		}
	});
</script>
</head>
<body>
	<%@ include file="header-bingren.jsp"%>
		<div class="row" style="border-bottom:1px solid #269abc;padding: 1%;margin:0;">
			<div class="col-xs-12" style="padding: 1%;background-color: white;width: 50%;text-align:center;">
				<div class="dropdown">
					<a id="dLabel" data-target="#" href="javascript:void(0);"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false"> 全部 <span class="caret"></span>
					</a>
					<ul class="dropdown-menu" aria-labelledby="dLabel">
						<li><a href="bingrGeTi_YiZhuBen">全部</a></li>
						<li><a href="bingrGeTi_YiZhuBen_fenlei?fl=1">长期</a></li>
						<li><a href="bingrGeTi_YiZhuBen_fenlei?fl=2">临时</a></li>
						<li><a href="bingrGeTi_YiZhuBen_fenlei?fl=3">药品</a></li>
						<li><a href="bingrGeTi_YiZhuBen_fenlei?fl=4">诊疗项目</a></li>
						<li><a href="bingrGeTi_YiZhuBen_fenlei?fl=5">材料</a></li>
						<li><a href="bingrGeTi_YiZhuBen_fenlei?fl=6">有效</a></li>
						<li><a href="bingrGeTi_YiZhuBen_fenlei?fl=7">停止</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div id="content" class="container">
		<s:iterator value="#request.bingrGeTi_YiZhu">
			<div class="row">
				<s:iterator value="vwBryzRemodelSubs">
					<div class="col-xs-8">
						<span>${resulttext}&nbsp;${yzmc }</span>
					</div>
					<div class="col-xs-4">
						<span>${dcyl}</span>
					</div>
				</s:iterator>
			</div>
			<div class="row">
				<div class="col-xs-12 text-right"
					style="margin: 10px 0 10px 0;padding-bottom: 5px;border-top: #666666 1px dashed;">
					<%-- <span style="color: #6daced">TID</span> --%>
				</div>
			</div>
			<div class="row"
				style="border-bottom: 2px solid #333333;padding-bottom: 10px;margin-bottom: 10px;">
				<div class="col-xs-2 text-center">
					<div class="row">
						<div class="col-xs-12">
							<s:if test="lsflag==0">
								<span
									style="font-size: 18px;border-radius: 20px;border: 2px solid #0316F7;padding: 5px;
		            color: #0316F7;">长</span>
							</s:if>
							<s:else>
								<span
									style="font-size: 18px;border-radius: 20px;border: 2px solid #03BFF7;padding: 5px;
		            color: #03BFF7;">临</span>
							</s:else>

						</div>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<s:if test="yzzt=='停止'">
								<span
									style="font-size: 18px;border-radius: 20px;border: 2px solid #F71903;padding: 5px;
			            color: #F71903;">停</span>
							</s:if>

							<s:if test="yzzt=='作废'">
								<span
									style="font-size: 18px;border-radius: 20px;border: 2px solid #131211;padding: 5px;
			            color: #131211;">废</span>
							</s:if>
							<s:if test="yzzt=='校对'">
								<span
									style="font-size: 18px;border-radius: 20px;border: 2px solid #F18111;padding: 5px;
			            color: #F18111;">校</span>
							</s:if>
						</div>
					</div>


				</div>
				<div class="col-xs-10">
					<div class="row">
						<div class="col-xs-8">
							<span>${yf1mc }</span>
						</div>
						<div class="col-xs-4">
							<span>${yf2mc }</span>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-4">
							<span>开嘱时间:</span>
						</div>
						<div class="col-xs-8">
							<%-- <span>${kstime}</span> --%>
							<span><s:date name="kstime" format="yyyy-MM-dd HH:mm:ss" /></span>
						</div>
					</div>
					<s:if test="tztime!=null">
						<div class="row">
							<div class="col-xs-4">
								<span>停嘱时间:</span>
							</div>
							<div class="col-xs-8">
								<span><s:date name="tztime" format="yyyy-MM-dd HH:mm:ss" /></span>
								<%-- <span>${tztime }</span> --%>
							</div>
						</div>
					</s:if>
					<s:if test="yszt!=null">
						<div class="row">
							<div class="col-xs-4">
								<span>医生嘱托:</span>
							</div>
							<div class="col-xs-8">
								<span>${yszt}</span>
							</div>
						</div>
					</s:if>
				</div>
			</div>
		</s:iterator>
		<div class="clear"></div>
		<%@ include file="menu-hushi.jsp" %>
	</div>
	<%@ include file="footer.jsp"%>
	<script type="text/javascript" src="scripts/bootstrap.min.js"></script>
</body>
</html>