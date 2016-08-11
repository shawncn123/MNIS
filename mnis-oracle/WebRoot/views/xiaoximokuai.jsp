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
	<title>消息</title>
	<base href="<%=basePath%>">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="author" content="融汇国康" />
	<meta name="keywords" content="移动护理信息系统" />
	<meta name="description" content="消息模块,高大上的移动护理系统。" />
	<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<link href="css/base.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" href="css/song.css" />
	<link rel="stylesheet" type="text/css" href="css/custom1.css"/>
	<script type="text/javascript" src="scripts/jquery-1.12.1.min.js"></script>	
	<script src="scripts/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="scripts/viewjs.js"></script>
	<script src="scripts/song.js" type="text/javascript" charset="utf-8"></script>
	<script src="scripts/zhang.js" type="text/javascript" charset="utf-8"></script>
	
	<script type="text/javascript">
	
		$(function() {
			// 绑定
			$("#head_banner_1").smartFloat();
		});
		function click_scroll(){
			var header_height = $("#head_banner_1").outerHeight(true); 
			alert("header_height:" + header_height);
			var scroll_offset = $("#pos").offset();  //得到pos这个div层的offset，包含两个值，top和left
			alert("scroll_offset:" +  scroll_offset.top);
			var move_offset = parseInt(scroll_offset.top) - parseInt(header_height);
			alert("move_offset:" +  move_offset);
		  	$("body,html").animate({
		   		//scrollTop:scroll_offset.top  //让body的scrollTop等于pos的top，就实现了滚动
		   		scrollTop:move_offset  //让body的scrollTop等于pos的top，就实现了滚动
		  	},0);
		};
		
		 $(function() {$(document).ready(function() {
			$(".panel-title a").click(function(){
				var messid = $(this).next().val();
				var mythis = $(this);
				var url = "quedingxiaoxiyidu";
				var args = {"messid" : messid/* ,"time" : new Date() */};
				$.post(url,args,function(data) {
					if(data == 1){
						mythis.parent().parent().removeClass().addClass("panel-heading bg-color"); 
					};
				})
			});
			
			$(".more-con a").click(function(){
				var vpagerows = $("#vpagerows").val();
				var vpageno = $("#mpageno").val();
				var vmessrows = $("#messallcountid").val();
				vpageno = parseInt(vpageno) + 1;
				$("#mpageno").val(vpageno);
				var dqjilushu = $("#dqjilushu").val();
				dqjilushu = parseInt(dqjilushu) + parseInt(vpagerows);
				$("#dqjilushu").val(dqjilushu);
				 
				var url = "extendmessage";
				var args = {"pageno" : vpageno,"pagerows":vpagerows/* ,"time" : new Date() */};
				$.post(url,args,function(data) {
					a = '';
					d = eval("("+ data+ ")");
					if(d!=null && d!="" ){
						for (var i = 0; i < d.length; i++) {
							if(i==0){
								a = a + '<div class="panel panel-default box-sdow" id="pos' + vpageno + '">';
							}else{
								a = a + '<div class="panel panel-default box-sdow">';
							}
							var vflag = d[i].readflag;
							if(vflag==1){
								a = a + '<div class="panel-heading bg-color">';
							}else{
								a = a + '<div class="panel-heading">';
							}
							
							a = a + '<h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion" href="#read'
							      + d[i].messid + '"><span>&gt;' + d[i].subject + '</span><span style="float:right;">'
							      + d[i].czyxm + '&nbsp;';
							
							var obj =  d[i].createrq;
							var teo = new Date(obj.time);
							var vmonth = teo.getMonth()+1;
							if(vmonth<10){
								vmonth = "0"+vmonth;
							}
							/* var vriqi = teo.getFullYear() + "-" + vmonth + "-" + teo.getDate(); */
							var vriqi = vmonth + "-" + teo.getDate();
							
							a = a + vriqi + '</span></a><input value="' + d[i].messid + '" style="display:none;"/></h4></div><div id="read'
							      + d[i].messid + '" class="panel-collapse collapse"><div class="panel-body padd-l">' 
							      + d[i].messtext + '</div></div></div>';
						}
					}
					$(a).appendTo('#accordion');
					var header_height = $("#head_banner_1").outerHeight(true); 
					var scroll_offset = $("#pos" + vpageno).offset();  //得到pos这个div层的offset，包含两个值，top和left
					var move_offset = parseInt(scroll_offset.top) - parseInt(header_height);
				  	$("body,html").animate({
				   		//scrollTop:scroll_offset.top  //让body的scrollTop等于pos的top，就实现了滚动
				   		scrollTop:move_offset  //让body的scrollTop等于pos的top，就实现了滚动
				  	},0);
					
					if(parseInt(vmessrows) > parseInt(dqjilushu)){
						$(".more-con").css('display','block');
					}else{
						$(".more-con").css('display','none');
					}
				});
			});
			
			$(".more-con1 a").click(function(){
				var vpagerows = $("#vpagerows").val();
				var vpageno = $("#mpageno1").val();
				var vmessrows1 = $("#wdmesscountid").val();
				vpageno = parseInt(vpageno) + 1;
				$("#mpageno1").val(vpageno);
				var dqjilushu1 = $("#dqjilushu1").val();
				dqjilushu1 = parseInt(dqjilushu1) + parseInt(vpagerows);
				 $("#dqjilushu1").val(dqjilushu1);
				 
				var url = "extendweidumessage";
				var args = {"pageno" : vpageno,"pagerows":vpagerows/* ,"time" : new Date() */};
				$.post(url,args,function(data) {
					a = '';
					d = eval("("+ data+ ")");
					if(d!=null && d!="" ){
						for (var i = 0; i < d.length; i++) {
							if(i==0){
								a = a + '<div class="panel panel-default box-sdow" id="wdpos' + vpageno + '">';
							}else{
								a = a + '<div class="panel panel-default box-sdow">';
							}
							a = a + '<div class="panel-heading">'
								  + '<h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion1" href="#unread-con'
								  + d[i].messid + '"><span>&gt;' + d[i].subject + '</span><span style="float:right;">'
								  + d[i].czyxm + '&nbsp;';
								  
							var obj =  d[i].createrq;
							var teo = new Date(obj.time);
							var vmonth = teo.getMonth()+1;
							if(vmonth<10){
								vmonth = "0"+vmonth;
							}
							/* var vriqi = teo.getFullYear() + "-" + vmonth + "-" + teo.getDate(); */
							var vriqi = vmonth + "-" + teo.getDate();
							
							a = a + vriqi + '</span></a></h4></div><div id="unread-con' + d[i].messid + '" class="panel-collapse collapse"><div class="panel-body">'
							      + d[i].messtext + '</div></div></div>';
						}
					}
					$(a).appendTo('#accordion1');
					var header_height = $("#head_banner_1").outerHeight(true); 
					var scroll_offset = $("#wdpos" + vpageno).offset();  //得到pos这个div层的offset，包含两个值，top和left
					var move_offset = parseInt(scroll_offset.top) - parseInt(header_height);
				  	$("body,html").animate({
				   		//scrollTop:scroll_offset.top  //让body的scrollTop等于pos的top，就实现了滚动
				   		scrollTop:move_offset  //让body的scrollTop等于pos的top，就实现了滚动
				  	},0);
					
					if(parseInt(vmessrows1) > parseInt(dqjilushu1)){
						$(".more-con1").css('display','block');
					}else{
						$(".more-con1").css('display','none');
					}
				});
			});
			
			$(".more-con2 a").click(function(){
				var vpagerows = $("#vpagerows").val();
				var vpageno = $("#mpageno2").val();
				var vmessrows2 = $("#gqwdmesscountid").val();
				vpageno = parseInt(vpageno) + 1;
				$("#mpageno2").val(vpageno);
				var dqjilushu2 = $("#dqjilushu2").val();
				dqjilushu2 = parseInt(dqjilushu2) + parseInt(vpagerows);
				 $("#dqjilushu2").val(dqjilushu2);
				 
				var url = "extendguoqiweidumessage";
				var args = {"pageno" : vpageno,"pagerows":vpagerows/* ,"time" : new Date() */};
				$.post(url,args,function(data) {
					a = '';
					d = eval("("+ data+ ")");
					if(d!=null && d!="" ){
						for (var i = 0; i < d.length; i++) {
							if(i==0){
								a = a + '<div class="panel panel-default box-sdow" id="gqwdpos' + vpageno + '">';
							}else{
								a = a + '<div class="panel panel-default box-sdow">';
							}
							
							a = a + '<div class="panel-heading">'
								  + '<h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion3" href="#over-unread-con'
								  + d[i].messid + '"><span>&gt;' + d[i].subject
								  + '</span><span style="float:right;">' + d[i].czyxm + '&nbsp;';
							
							var obj =  d[i].createrq;
							var teo = new Date(obj.time);
							var vmonth = teo.getMonth()+1;
							if(vmonth<10){
								vmonth = "0"+vmonth;
							}
							/* var vriqi = teo.getFullYear() + "-" + vmonth + "-" + teo.getDate(); */
							var vriqi = vmonth + "-" + teo.getDate();
							
							a = a + vriqi + '</span></a></h4></div><div id="over-unread-con' + d[i].messid 
							      + '" class="panel-collapse collapse"><div class="panel-body">' + d[i].messtext
							      + '</div></div></div>';
						}
					}
					$(a).appendTo('#accordion3');
					var header_height = $("#head_banner_1").outerHeight(true); 
					var scroll_offset = $("#gqwdpos" + vpageno).offset();  //得到pos这个div层的offset，包含两个值，top和left
					var move_offset = parseInt(scroll_offset.top) - parseInt(header_height);
				  	$("body,html").animate({
				   		//scrollTop:scroll_offset.top  //让body的scrollTop等于pos的top，就实现了滚动
				   		scrollTop:move_offset  //让body的scrollTop等于pos的top，就实现了滚动
				  	},0);
					
					if(parseInt(vmessrows2) > parseInt(dqjilushu2)){
						$(".more-con2").css('display','block');
					}else{
						$(".more-con2").css('display','none');
					}
				});
			});
			
			
		});
		});	
		 
		 $(function() {
			 	var vmessrows = $("#messallcountid").val();
		 		var vpagerows = $("#vpagerows").val();
				if(parseInt(vmessrows) > parseInt(vpagerows)){
					$(".more-con").css('display','block')
				}
		 });
		 $(function() {
			 	var vmessrows1 = $("#wdmesscount").val();
		 		var vpagerows = $("#vpagerows").val();
				if(parseInt(vmessrows1) > parseInt(vpagerows)){
					$(".more-con1").css('display','block')
				}
		 });
		 $(function() {
			 	var vmessrows2 = $("#gqwdmesscount").val();
		 		var vpagerows = $("#vpagerows").val();
				if(parseInt(vmessrows2) > parseInt(vpagerows)){
					$(".more-con2").css('display','block')
				}
		 });
 
	</script>
</head>

<body>
	<%@ include file="header-hushi.jsp" %>
		<div class="marg-t" style="padding: 1%;border-bottom: 1px #E0EFF5 solid;">
			<div class="row" style="margin: 0;" >
				<div class="col-xs-12" style="padding-left: 0">
					<ul class="nav nav-pills">
						<li class="active">
							<a href="#readed" data-toggle="tab">全部</a>
						</li>
						<li>
							<a href="#unread" data-toggle="tab">未读</a>
						</li>
						<li>
							<a href="#over-unread" data-toggle="tab">过期未读</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div id="content" class="container" style="padding: 0 1%;">
		<!-- 隐藏域 -->
		<input value="${messallcount }" style="display:none;" id="messallcountid">
		<input value="${wdmesscount }" style="display:none;" id="wdmesscountid">
		<input value="${gqwdmesscount }" style="display:none;" id="gqwdmesscountid">
		<input value="${pagerows }" style="display:none;" id="vpagerows"/>
		<!-- 隐藏域结束 -->
		
		<!--tab栏结束-->
		<!--tab栏内容开始-->
		
		<div class="container" style="padding: 0;">
			<div class="row padd-t" style="margin: 0;">
				<div class="col-xs-12" style="padding: 0;">
					<div class="tab-content" id="myTabContent">
						<!--已读内容开始-->
						<div class="tab-pane fade in active" id="readed">
							<div class="panel-group" id="accordion">
								<s:iterator value="#request.sysmess">
									<div class="panel panel-default box-sdow">
										<s:if test="readflag==1">
										<div class="panel-heading bg-color"><!-- 已读信息在此处添加bg-color类 -->
										</s:if><s:else>
											<div class="panel-heading"><!-- 已读信息在此处添加bg-color类 -->
										</s:else>
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion" href="#read${messid }">
												<span>&gt;${subject }</span><span style="float:right;">${czyxm }&nbsp;<s:date name="createrq" format="MM-dd"/></span>
											</a>
											<input value="${messid }" style="display:none;"/>
								      	</h4>
										</div>
										<div id="read${messid }" class="panel-collapse collapse">
											<div class="panel-body padd-l">${messtext}</div>
										</div>
									</div>
								</s:iterator>
							</div>
								<!--已读内容结束-->
							<p class="more-con">
								<a href="javascript:void(0);">&gt;显示更多&lt;</a>
								<input value="${pageno}" style="display:none;" id="mpageno"/>
								<input value="${dqjilushu}" style="display:none;" id="dqjilushu"/>
							</p>
						</div>
					
						<!--已读内容结束-->
						<!--未读内容开始-->
						<div class="tab-pane fade" id="unread">
							<div class="panel-group" id="accordion1">
								<s:iterator value="#request.sysmessweidu">
								<div class="panel panel-default box-sdow">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion1" href="#unread-con${messid }">
												<span>&gt;${subject }</span><span style="float:right;">${czyxm }&nbsp;<s:date name="createrq" format="MM-dd"/></span>
											</a>
								      	</h4>
									</div>
									<div id="unread-con${messid }" class="panel-collapse collapse">
										<div class="panel-body">
											${messtext}
										</div>
									</div>
								</div>
								</s:iterator>
							</div>
							<p class="more-con1">
								<a href="javascript:void(0);">&gt;显示更多&lt;</a>
								<input value="${pageno}" style="display:none;" id="mpageno1"/>
								<input value="${dqjilushu}" style="display:none;" id="dqjilushu1"/>
							</p>
						</div>
						<!--未读内容结束-->
						
						<!--过期未读开始-->
						<div class="tab-pane fade" id="over-unread">
							<div class="panel-group" id="accordion3">
								<s:iterator value="#request.sysmessguoqiweidu">
								<div class="panel panel-default box-sdow">
									<div class="panel-heading">
										<h4 class="panel-title">
								        	<a data-toggle="collapse" data-parent="#accordion3" href="#over-unread-con${messid }">
												<span>&gt;${subject }</span><span style="float:right;">${czyxm }&nbsp;<s:date name="createrq" format="MM-dd"/></span>
								        	</a>
								      	</h4>
									</div>
									<div id="over-unread-con${messid }" class="panel-collapse collapse">
										<div class="panel-body">
											${messtext}
										</div>
									</div>
								</div>
								</s:iterator>
							</div>
							<p class="more-con2">
								<a href="javascript:void(0);">&gt;显示更多&lt;</a>
								<input value="${pageno}" style="display:none;" id="mpageno2"/>
								<input value="${dqjilushu}" style="display:none;" id="dqjilushu2"/>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>	

		<!--导航结束-->
		<div class="clear"></div>
		<%@ include file="menu-hushi.jsp" %>
	</div>
	<!--页脚开始-->
	<%@ include file="footer.jsp"%>
	<!--页脚结束-->
</body>

</html>