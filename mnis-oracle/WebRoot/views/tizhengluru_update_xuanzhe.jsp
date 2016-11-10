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
<title>体征录入数据修改</title>
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

<link href="css/bootstrap-clockpicker.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="scripts/bootstrap-clockpicker.min.js"></script>
<link href="css/mobiscroll_002.css" rel="stylesheet" type="text/css">
<link href="css/mobiscroll_003.css" rel="stylesheet" type="text/css">
<script src="scripts/mobiscroll_002.js" type="text/javascript"></script>
<script src="scripts/mobiscroll_004.js" type="text/javascript"></script>
<script src="scripts/mobiscroll.js" type="text/javascript"></script>
<script src="scripts/mobiscroll_003.js" type="text/javascript"></script>
<script src="scripts/mobiscroll_005.js" type="text/javascript"></script>
<script src="scripts/time-shen.js" type="text/javascript"></script>
<script src="scripts/jquery.scrollTo-2.1.2.js" type="text/javascript"></script>

<script type="text/javascript">

		function myFunction() {
			document.getElementById("chacw").click();
		}
		
		function changeDate() {
			/* 	使用$(this).val() 回丢失前面的数字0	alert( $(this).val()); */
					var url = "twtzdata_jl";
					var vxzrq = $("#yiZhuRq").val();
					var args = {"cxRiqi":vxzrq}; 
					$.post(url,args,function(data) {
						var a = '';
						var j = 0;
						if(data!=null && data!="" && data!="[]" ){
							d = eval("("+ data+ ")");
							for (var i = 0; i < d.length; i++) {
								j=i+1;
								a = a + '<div class="row" style="border-bottom: #666666 1px dashed;padding-bottom: 1%;margin-bottom: 1%;"><div class="col-xs-4" style="padding:0;"><span >第'
									+ j
									+ '次</span></div><div class="col-xs-4" style="padding:0;"><span >'
									+ d[i]
									+ '</span></div><div class="col-xs-4" style="padding:0;"><a class="btn btn-default" href="tizheng_data_update?cxRiqi='
									+ vxzrq + '&appTime=' + d[i].substring(0,2) + '%3a' + d[i].substring(3,5) + '">修改</a></div></div>';
							}
						}else{
							a = "无数据！";
						} 
						 $("#tzdatajl")[0].innerHTML = a; 
					})
					
					var url1 = "twtzdatatw_jl";
					$.post(url1,args,function(data1) {
						var c = '';
						var cs = 0;
						if(data1!=null && data1!="" && data1!="[]" ){
							d = eval("("+ data1+ ")");
							for (var x = 0; x < d.length; x++) {
								cs=x+1;
								c = c + '<div class="row" style="border-bottom: #666666 1px dashed;padding-bottom: 1%;margin-bottom: 1%;"><div class="col-xs-4" style="padding:0;"><span >第'
									+ cs
									+ '次</span></div><div class="col-xs-4" style="padding:0;"><span >'
									+ d[x].sj
									+ '</span></div><div class="col-xs-4" style="padding:0;"><a class="btn btn-default" href="tizhengtw_data_update?jlid='
									+ d[x].jlid + '">修改</a></div></div>';
							}
						}else{
							c = "无数据！";
						} 
						 $("#tzdatatwjl")[0].innerHTML = c; 
					})
					
		}
</script>
</head>
<body>
	<%@ include file="header-bingren.jsp"%>
		<div class="row" style="border-bottom:1px solid #269abc;padding: 5px 0 ; margin: 0;">
			<div class="col-xs-4" style="padding: 0 2px;">
				<div class="demos">
					<input value="" class="form-control" name="chajiantime" id="yiZhuRq" type="text" placeholder="" onchange="changeDate()" readonly="readonly">
				</div>
			</div>
			<div class="col-xs-4" id="prompt1" style="display:none;">
		   		<span class="label label-success">成功对应病人</span>
		   	</div>
			<div class="col-xs-4" id="prompt2" style="display:none;">
		   		<span class="label label-warning">对应病人失败</span>
		   	</div>
		</div>
	</div>
	<div id="content_b" class="container">
		<div class="row"
				style="border-bottom: #666666 1px solid;padding-bottom: 5px;margin-bottom: 5px;">
				<div class="col-xs-12" style="text-align: center;">
					<span>体征录入记录</span>
				</div>
		</div>
		<div class="row"
				style="border-bottom: #666666 1px dashed;padding-bottom: 1%;margin-bottom: 1%;">
			<div class="col-xs-4" style="padding:0;">
				序号
			</div>
			<div class="col-xs-4" style="padding:0;">
				时间点
			</div>
			<div class="col-xs-4" style="padding:0;">
				操作
			</div>
		</div>
		<div id="tzdatajl">
		<s:iterator value="#request.tzdatajllist"  status ="status" id="jlsj">
			<div class="row"
				style="border-bottom: #666666 1px dashed;padding-bottom: 1%;margin-bottom: 1%;">
				<div class="col-xs-4" style="padding:0;">
					<span >第<s:property value="#status.count" />次</span>
				</div>
				<div class="col-xs-4" style="padding:0;">
					<span ><s:property value="#jlsj" /></span>
				</div>
				<div class="col-xs-4" style="padding:0;">
					<%-- ${tzdata_lr_rq} 指的是查询的日期 --%>
					<a class="btn btn-default" href="tizheng_data_update?cxRiqi=${tzdata_lr_rq}&appTime=<s:property value='#jlsj.substring(0,2)' />%3a<s:property value='#jlsj.substring(3,5)' />">修改</a>
				</div>
			</div>
		</s:iterator>
		</div>
		
		<div class="row"
				style="border-bottom: #666666 1px solid;padding-bottom: 5px;margin-bottom: 5px;">
				<div class="col-xs-12" style="text-align: center;">
					<span>体温录入记录</span>
				</div>
		</div>
		<div class="row"
				style="border-bottom: #666666 1px dashed;padding-bottom: 1%;margin-bottom: 1%;">
			<div class="col-xs-4" style="padding:0;">
				序号
			</div>
			<div class="col-xs-4" style="padding:0;">
				时间点
			</div>
			<div class="col-xs-4" style="padding:0;">
				操作
			</div>
		</div>
		<div id="tzdatatwjl">
		<s:if test="tzdatatwjllist==0">
			<div class="row"
				style="border-bottom: #666666 1px dashed;padding-bottom: 1%;margin-bottom: 1%;">
				<div class="col-xs-12" style="padding:0;">
					<span >无记录</span>
				</div>
			</div>
		</s:if><s:else>
			<s:iterator value="#request.tzdatatwjllist"  status ="statustw" id="twjlsj">
				<div class="row"
					style="border-bottom: #666666 1px dashed;padding-bottom: 1%;margin-bottom: 1%;">
					<div class="col-xs-4" style="padding:0;">
						<span >第<s:property value="#statustw.count" />次</span>
					</div>
					<div class="col-xs-4" style="padding:0;">
						<span >${sj }</span>
					</div>
					<div class="col-xs-4" style="padding:0;">
						<a class="btn btn-default" href="tizhengtw_data_update?jlid=${jlid }">修改</a>
					</div>
				</div>
			</s:iterator>
		</s:else>
		</div>
		<div class="clear"></div>
		<%@ include file="menu-hushi.jsp" %>
	</div>
	
	<!--页脚开始-->
	<%@ include file="footer.jsp" %>
	<!--页脚结束-->
		
	<script type="text/javascript" src="scripts/bootstrap.min.js"></script>
</body>
</html>