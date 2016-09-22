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
<!--<meta charset="UTF-8">-->
<!--<meta name="viewport" content="width=device-width,initial-scale=1">-->
<title>检查报告</title>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="融汇国康" />
<meta name="keywords" content="移动护理信息系统" />
<meta name="description" content="检查报告,高大上的移动护理系统。" />
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="SHORTCUT ICON" href="images/favicon.ico">
<link rel="icon" href="images/favicon.ico" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="css/song.css" />
<link href="css/custom1.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/mobiscroll.css" />
<link rel="stylesheet" href="css/mobiscroll_002.css" />
<link rel="stylesheet" href="css/mobiscroll_003.css" />
<link href="css/base.css" rel="stylesheet" type="text/css" />
<link href="css/custom1.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="scripts/jquery-1.12.1.min.js"></script>
<script src="scripts/mobiscroll_002.js"></script>
<script src="scripts/mobiscroll_003.js"></script>
<script src="scripts/mobiscroll_004.js"></script>
<script src="scripts/mobiscroll_005.js"></script>
<script src="scripts/mobiscroll.js"></script>
<script src="scripts/timerpicker.js" type="text/javascript"></script>
<script type="text/javascript" src="scripts/viewjs.js"></script>
<script type="text/javascript" src="scripts/song.js"></script>
<script type="text/javascript">
	$(function() {
		// 绑定
		$("#head_banner_1").smartFloat();
	});
	function wjzflselcet() {
		document.getElementById("wjzsz").submit();
	};
	function changeDate() {
		/* alert($("#appDate1").val());
		var vcxrq = "2016-03-11"; */
		var vcxrq = $("#appDate1").val();
		var vwjbz = $("#wjbzselect").val();
		var url = "getJianChaByRiQi";
		var args = {"vsqrq" : vcxrq,"vwjbz":vwjbz/* ,"time" : new Date() */};
		$.post(url,args,function(data) {
			a = '';
			d = eval("("+ data+ ")");
			if(d!=null && d!="" ){
				for (var i = 0; i < d.length; i++) {
					a = a + '<div class="row" style="padding-top: 2%;padding-bottom: 2%;border-bottom: 1px dashed;">'
						+ '<div class="col-xs-7" style="padding: 0 1% 0 1%;"><a href="javascript:void(0)" '
						+ 'style="text-decoration: none;color: #080808;"><span style="color: #ADD1F7">&gt;</span>&nbsp;'
						+ d[i].yzmc + '&nbsp;&nbsp;' + d[i].jcbwmc + '</a></div><div class="col-xs-5" '
						+ 'style="padding: 0 1% 0 1%;"><a href="javascript:void(0)" style="text-decoration: none;color: #080808;">'
						+ d[i].sqysxm + '&nbsp;';
						
						var obj =  d[i].sqrq;
						var teo = new Date(obj.time);
						var vmonth = teo.getMonth()+1;
						if(vmonth<10){
							vmonth = "0"+vmonth;
						}
						var vsqrq = teo.getFullYear() + "-" + vmonth + "-" + teo.getDate();
						
						a = a + vsqrq + '</a></div></div>';
						<%-- a = a + "<%@ include file='menu-hushi.jsp' %>"; --%>
				}
			}else{
				a = "无数据！";
			}
			$("#jianchacontainer")[0].innerHTML = a;
		});
	};
</script>
</head>
<body>
	<%@ include file="header-bingren.jsp"%>
			<div class="row marg-l" style="margin:0 -4px;">
				<div class="col-xs-5" style="margin-bottom: -10px; margin-top: 2px;">
					<div class="row">
						<div class="col-xs-10" style="padding-left: 5px;">
						<form action="chajianchadata" method="post" id="wjzsz">
							<div class="form-group">
								<select name="vwjbz" id="wjbzselect" class="form-control" onchange="wjzflselcet()">
									<s:if test='vwjbz=="2"||vwjbz==null'>
									<option value="2" selected>全部检查</option>
									<option value="1">危急值</option>
									</s:if>
									<s:else>
									<option value="2" >全部检查</option>
									<option value="1" selected>危急值</option>
									</s:else>
								</select>
							</div>
						</form>
						</div>
					</div>
				</div>
				<div class="col-xs-2"></div>
				<div class="col-xs-5" style="padding: 0; margin: 0;">
					<div class="demos">
						<input value="" placeholder="" class="form-control" readonly="readonly" name="appDateTime" id="appDate1" 
						type="text" onchange="changeDate()">
					</div>
				</div>
			</div>
	</div>
	<div class="container">
		<div  id="jianchacontainer">
		<s:iterator value="#request.bingrgeti_jiancha">
			<div class="row" style="padding-top: 2%;padding-bottom: 2%;border-bottom: 1px dashed;">
				<div class="col-xs-7" style="padding: 0 1% 0 1%;">
					<a href="javascript:void(0)" style="text-decoration: none;color: #080808;"><span
						style="color: #ADD1F7">&gt;</span>&nbsp;${yzmc }&nbsp;&nbsp;${jcbwmc}</a>
				</div>
				<div class="col-xs-5"  style="padding: 0 1% 0 1%;">
					<a href="javascript:void(0)" style="text-decoration: none;color: #080808;">${sqysxm }&nbsp;<s:date
							name="sqrq" format="yyyy-MM-dd"></s:date>
					</a>
				</div>
			</div>
		</s:iterator>
		</div>
		<%@ include file="menu-hushi.jsp" %>
	</div>

	<!--导航结束-->
	<div class="clear"></div>
	<!--页脚开始-->
	<%@ include file="footer.jsp"%>
	<!--页脚结束-->
	<script type="text/javascript" src="scripts/bootstrap.min.js"></script>
</body>
</html>