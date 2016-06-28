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
	<meta name="author" content="沈旭峰" />
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
		 $(function() {$(document).ready(function() {
		/*	$(".more-con span").click(function(){     
				var s ='<div class="panel panel-default box-sdow"><div class="panel-heading">'
				+ '<h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion" href="#read10">'
				+ '&gt;全部消息。第 1 部分</a></h4></div><div id="read10" class="panel-collapse collapse">'
				+'<div class="panel-body padd-l"> Nihil anim keffiyeh helvetica, craft beer labore wes anderson'
				+'</div></div></div>'
				+'<div class="panel panel-default box-sdow"><div class="panel-heading">'
				+ '<h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion" href="#read10">'
				+ '&gt;全部消息。第 1 部分</a></h4></div><div id="read10" class="panel-collapse collapse">'
				+'<div class="panel-body padd-l"> Nihil anim keffiyeh helvetica, craft beer labore wes anderson'
				+'</div></div></div>'
				+'<div class="panel panel-default box-sdow"><div class="panel-heading">'
				+ '<h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion" href="#read10">'
				+ '&gt;全部消息。第 1 部分</a></h4></div><div id="read10" class="panel-collapse collapse">'
				+'<div class="panel-body padd-l"> Nihil anim keffiyeh helvetica, craft beer labore wes anderson'
				+'</div></div></div>'
				+'<div class="panel panel-default box-sdow"><div class="panel-heading">'
				+ '<h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion" href="#read10">'
				+ '&gt;全部消息。第 1 部分</a></h4></div><div id="read10" class="panel-collapse collapse">'
				+'<div class="panel-body padd-l"> Nihil anim keffiyeh helvetica, craft beer labore wes anderson'
				+'</div></div></div>'
				+'<div class="panel panel-default box-sdow"><div class="panel-heading">'
				+ '<h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion" href="#read10">'
				+ '&gt;全部消息。第 1 部分</a></h4></div><div id="read10" class="panel-collapse collapse">'
				+'<div class="panel-body padd-l"> Nihil anim keffiyeh helvetica, craft beer labore wes anderson'
				+'</div></div></div>'
				+'<div class="panel panel-default box-sdow"><div class="panel-heading">'
				+ '<h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion" href="#read10">'
				+ '&gt;全部消息。第 1 部分</a></h4></div><div id="read10" class="panel-collapse collapse">'
				+'<div class="panel-body padd-l"> Nihil anim keffiyeh helvetica, craft beer labore wes anderson'
				+'</div></div></div>'
				+'<div class="panel panel-default box-sdow"><div class="panel-heading">'
				+ '<h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion" href="#read10">'
				+ '&gt;全部消息。第 1 部分</a></h4></div><div id="read10" class="panel-collapse collapse">'
				+'<div class="panel-body padd-l"> Nihil anim keffiyeh helvetica, craft beer labore wes anderson'
				+'</div></div></div>'
				+'<div class="panel panel-default box-sdow"><div class="panel-heading">'
				+ '<h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion" href="#read10">'
				+ '&gt;全部消息。第 1 部分</a></h4></div><div id="read10" class="panel-collapse collapse">'
				+'<div class="panel-body padd-l"> Nihil anim keffiyeh helvetica, craft beer labore wes anderson'
				+'</div></div></div>'
				+'<div class="panel panel-default box-sdow"><div class="panel-heading">'
				+ '<h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion" href="#read10">'
				+ '&gt;全部消息。第 1 部分</a></h4></div><div id="read10" class="panel-collapse collapse">'
				+'<div class="panel-body padd-l"> Nihil anim keffiyeh helvetica, craft beer labore wes anderson'
				+'</div></div></div>'
				+'<div class="panel panel-default box-sdow"><div class="panel-heading">'
				+ '<h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion" href="#read10">'
				+ '&gt;全部消息。第 1 部分</a></h4></div><div id="read10" class="panel-collapse collapse">'
				+'<div class="panel-body padd-l"> Nihil anim keffiyeh helvetica, craft beer labore wes anderson'
				+'</div></div></div>';

				var i =$(s);
				$(i).appendTo('#accordion');
			});*/
			$(".panel-title a").click(function(){
				var messid = $(this).next().val();
				var mythis = $(this);
				var url = "quedingxiaoxiyidu";
				var args = {"messid" : messid/* ,"time" : new Date() */};
				$.post(url,args,function(data) {
					if(data == 1){
						/* alert(data); */
						/* mythis.prev().prev().removeClass("panel-heading").addClass("panel-heading bg-color"); */
						mythis.parent().parent().removeClass().addClass("panel-heading bg-color"); 
					};
				})
			});
		});
		});	
 
	</script>
</head>

<body>
	<%@ include file="header-hushi.jsp" %>
	</div>
	<div id="content" class="container" style="padding: 0 1%;">
		<div class="marg-t">
			<div class="row" style="margin: 0;">
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
<%-- 										<div id="read${messid }" class="panel-collapse collapse in"> 展开的形式--%>
										<div id="read${messid }" class="panel-collapse collapse">
											<div class="panel-body padd-l">${messtext}</div>
										</div>
									</div>
								</s:iterator>
							</div>
								<!--已读内容结束-->
							<p class="more-con">
								<span>&gt;显示更多&lt;</span>
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
								<span>&gt;显示更多&lt;</span>
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
								<span>&gt;显示更多&lt;</span>
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