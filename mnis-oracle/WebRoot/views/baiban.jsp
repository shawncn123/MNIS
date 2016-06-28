<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>

<head>
	<meta charset="UTF-8">
	<title>护士工作提醒</title>
	<base href="<%=basePath%>">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="author" content="沈旭峰" />
	<meta name="keywords" content="移动护理信息系统" />
	<meta name="description" content="护士工作提醒,高大上的移动护理系统。" />
	<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<link href="css/base.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" href="css/song.css" />
	<script type="text/javascript" src="scripts/jquery-1.12.1.min.js"></script>	
	<script src="scripts/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="scripts/viewjs.js"></script>
	<script src="scripts/song.js" type="text/javascript" charset="utf-8"></script>
	
	<script type="text/javascript">
		$(function() {
			// 绑定
			$("#head_banner_1").smartFloat();
			
			/* $('.rightCon_1').text('新生儿总数 病人总数 测血压 测血糖 心电监测');   //模拟
			$('.rightCon_2').text('测血压 测血糖 心电监测'); */
		});
	</script>
</head>

<body>
	<%@ include file="header-hushi.jsp" %>
	</div>
	<div id="content" class="container">
		<ul id="myTab" class="nav nav-pills" style="margin-top: 10px;">
		   <li class="active"><a href="#home" data-toggle="tab">项目</a></li>
		   <li><a href="#ios" data-toggle="tab">床位</a></li>
		</ul>
		<div id="myTabContent" class="tab-content">
		   <div class="tab-pane fade in active" id="home">
		      <form class="form-horizontal" role="form" style="margin-top: 10px;">
		      <s:if test="#request.czybbtxs!=null">
		      	<s:iterator value="#request.czybbtxs" status ="status">
		      		<div class="form-group">
				      <label for="" class="col-xs-3 control-label leftBar">
				      	<s:property value="#request.czybbtxs[#status.index].substring(0,#request.czybbtxs[#status.index].indexOf(':')+1)"/>
				      </label>
				      <%-- <label for="" class="col-xs-3 control-label leftBar"><s:property value="#request.czybbtxs"/></label> --%>
				      <div class="col-xs-9 " style="padding-left: 5px; padding-right: 5px;" >
				         <div class="rightCon rightCon_1">	<s:property value="#request.czybbtxs[#status.index].substring(#request.czybbtxs[#status.index].indexOf(':')+1)"/></div>
				      </div>
				   </div>
		      		<%-- <div class="col-xs-9 " style="padding-left: 5px; padding-right: 5px;" >
				         <div class="rightCon rightCon_1">${czybbtxs}</div>
				      </div> --%>
		      	</s:iterator>
		      </s:if><s:else>
		      	<p>无相关数据</p>
		      </s:else>
				 <!-- <div class="form-group">
				      <label for="" class="col-xs-3 control-label leftBar">病人总数</label>
				      <div class="col-xs-9 " style="padding-left: 5px; padding-right: 5px;" >
				         <div class="rightCon rightCon_1"></div>
				      </div>
				   </div>
				 <div class="form-group">
				      <label for="" class="col-xs-3 control-label leftBar">婴儿总数</label>
				      <div class="col-xs-9 " style="padding-left: 5px; padding-right: 5px;" >
				         <div class="rightCon rightCon_2"></div>
				      </div>
				   </div>
				 <div class="form-group">
				      <label for="" class="col-xs-3 control-label leftBar">入&nbsp;&nbsp;&nbsp;院</label>
				      <div class="col-xs-9 " style="padding-left: 5px; padding-right: 5px;" >
				         <div class="rightCon rightCon_3"></div>
				      </div>
				   </div>
				 <div class="form-group">
				      <label for="" class="col-xs-3 control-label leftBar">出&nbsp;&nbsp;&nbsp;院</label>
				      <div class="col-xs-9 " style="padding-left: 5px; padding-right: 5px;" >
				         <div class="rightCon rightCon_4"></div>
				      </div>
				   </div>
				   <div class="form-group">
				      <label for="" class="col-xs-3 control-label leftBar">测&nbsp;血&nbsp;压</label>
				      <div class="col-xs-9 " style="padding-left: 5px; padding-right: 5px;" >
				         <div class="rightCon rightCon_5"></div>
				      </div>
				   </div>
				   <div class="form-group">
				      <label for="" class="col-xs-3 control-label leftBar">彩&nbsp;&nbsp;&nbsp;超</label>
				      <div class="col-xs-9 " style="padding-left: 5px; padding-right: 5px;" >
				         <div class="rightCon rightCon_6"></div>
				      </div>
				   </div>
				   <div class="form-group">
				      <label for="" class="col-xs-3 control-label leftBar">心电监测</label>
				      <div class="col-xs-9 " style="padding-left: 5px; padding-right: 5px;" >
				         <div class="rightCon rightCon_7"></div>
				      </div>
				   </div>
				   <div class="form-group">
				      <label for="" class="col-xs-3 control-label leftBar">手术患者</label>
				      <div class="col-xs-9 " style="padding-left: 5px; padding-right: 5px;" >
				         <div class="rightCon rightCon_8"></div>
				      </div>
				   </div>
				   <div class="form-group">
				      <label for="" class="col-xs-3 control-label leftBar">入&nbsp;产&nbsp;房</label>
				      <div class="col-xs-9 " style="padding-left: 5px; padding-right: 5px;" >
				         <div class="rightCon rightCon_9"></div>
				      </div>
				   </div>
				   <div class="form-group">
				      <label for="" class="col-xs-3 control-label leftBar">观&nbsp;&nbsp;&nbsp;血</label>
				      <div class="col-xs-9 " style="padding-left: 5px; padding-right: 5px;" >
				         <div class="rightCon rightCon_10"></div>
				      </div>
				   </div>
				   <div class="form-group">
				      <label for="" class="col-xs-3 control-label leftBar">尿&nbsp;常&nbsp;规</label>
				      <div class="col-xs-9 " style="padding-left: 5px; padding-right: 5px;" >
				         <div class="rightCon rightCon_11"></div>
				      </div>
				   </div>
				   <div class="form-group">
				      <label for="" class="col-xs-3 control-label leftBar">测&nbsp;血&nbsp;糖</label>
				      <div class="col-xs-9 " style="padding-left: 5px; padding-right: 5px;" >
				         <div class="rightCon rightCon_12"></div>
				      </div>
				   </div> -->
				</form>
		   </div>
		
		   <div class="tab-pane fade" id="ios">
		        <form class="form-horizontal" role="form" style="margin-top: 10px;">
		        	<s:if test="#request.chwbbtxs!=null">
		      	<s:iterator value="#request.chwbbtxs" status ="status">
		      		<div class="form-group">
				      <label for="" class="col-xs-3 control-label leftBar">
				      	<s:property value="#request.chwbbtxs[#status.index].substring(0,#request.chwbbtxs[#status.index].indexOf(':')+1)"/>
				      </label>
				      <div class="col-xs-9 " style="padding-left: 5px; padding-right: 5px;" >
				         <div class="rightCon rightCon_1">	<s:property value="#request.chwbbtxs[#status.index].substring(#request.chwbbtxs[#status.index].indexOf(':')+1)"/></div>
				      </div>
				   </div>
		      	</s:iterator>
		      </s:if><s:else>
		      	<p>无相关数据</p>
		      </s:else>
				    <div class="form-group">
				        <label for="" class="col-xs-2 control-label leftBar">5&nbsp;&nbsp;床</label>
				        <div class="col-xs-10 " style="padding-left: 5px; padding-right: 5px;" >
				            <div class="rightCon rightCon_13"></div>
				        </div>
				    </div>
				    <div class="form-group">
				        <label for="" class="col-xs-2 control-label leftBar">8&nbsp;&nbsp;床</label>
				        <div class="col-xs-10 " style="padding-left: 5px; padding-right: 5px;" >
				            <div class="rightCon rightCon_14"></div>
				        </div>
				    </div>
				    <div class="form-group">
				        <label for="" class="col-xs-2 control-label leftBar">9&nbsp;&nbsp;床</label>
				        <div class="col-xs-10 " style="padding-left: 5px; padding-right: 5px;" >
				            <div class="rightCon rightCon_15"></div>
				        </div>
				    </div>
				    <div class="form-group">
				        <label for="" class="col-xs-2 control-label leftBar">15&nbsp;床</label>
				        <div class="col-xs-10 " style="padding-left: 5px; padding-right: 5px;" >
				            <div class="rightCon rightCon_16"></div>
				        </div>
				    </div>
				    <div class="form-group">
				        <label for="" class="col-xs-2 control-label leftBar">23&nbsp;床</label>
				        <div class="col-xs-10 " style="padding-left: 5px; padding-right: 5px;" >
				            <div class="rightCon rightCon_17"></div>
				        </div>
				    </div>
				    <div class="form-group">
				        <label for="" class="col-xs-2 control-label leftBar">16&nbsp;床</label>
				        <div class="col-xs-10 " style="padding-left: 5px; padding-right: 5px;" >
				            <div class="rightCon rightCon_18"></div>
				        </div>
				    </div>
				    <div class="form-group">
				        <label for="" class="col-xs-2 control-label leftBar">19&nbsp;床</label>
				        <div class="col-xs-10 " style="padding-left: 5px; padding-right: 5px;" >
				            <div class="rightCon rightCon_19"></div>
				        </div>
				    </div>
				    <div class="form-group">
				        <label for="" class="col-xs-2 control-label leftBar">30&nbsp;床</label>
				        <div class="col-xs-10 " style="padding-left: 5px; padding-right: 5px;" >
				            <div class="rightCon rightCon_20"></div>
				        </div>
				    </div>
				    <div class="form-group">
				        <label for="" class="col-xs-2 control-label leftBar">22&nbsp;床</label>
				        <div class="col-xs-10 " style="padding-left: 5px; padding-right: 5px;" >
				            <div class="rightCon rightCon_21"></div>
				        </div>
				    </div>
				</form>
		   </div>

		</div>
		<!--导航结束-->
		<div class="clear"></div>
		<%@ include file="menu-hushi.jsp" %>
	</div>
	<!--页脚开始-->
		<%@ include file="footer.jsp" %>
	<!--页脚结束-->
</body>
</html>