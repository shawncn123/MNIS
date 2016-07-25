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
<title>宣教</title>
<base href="<%=basePath%>">
<link rel="stylesheet" href="css/bootstrap.min.css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="沈旭峰" />
<meta name="keywords" content="移动护理信息系统" />
<meta name="description" content="宣教,高大上的移动护理系统。" />
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<link href="css/base.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/song.css" />
<link rel="stylesheet" type="text/css" href="css/custom1.css" />
<script type="text/javascript" src="scripts/jquery-1.12.1.min.js"></script>
<script type="text/javascript" src="scripts/viewjs.js"></script>
<script src="scripts/song.js" type="text/javascript" charset="utf-8"></script>
<script src="scripts/bootstrap.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="scripts/zhang.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	$(function() {
		// 绑定
		$("#head_banner_1").smartFloat();
	});
	
	$(function() {$(document).ready(function() {
		$(".btn-info").click(function() {
		/* 	$(this).removeClass("btn-info").addClass("btn-default");
			$(this).html("已宣教"); */
			var mythis = $(this);
			var vdmz = $(this).next().val();
			 /* alert(vdmz);  */
			var url = "xuanjiaoqueding";
			var args = {"xjdmid" : vdmz };
			$.post(url,args,function(data) {
				if(data == 1){
					/* alert(data); */
					mythis.removeClass("btn-info").addClass("btn-default");
					mythis.html("已宣教");
				};
			});
		});
	});
	});
</script>
</head>

<body>
	<%@ include file="header-bingren.jsp"%>
	<div class="row" style="margin: 0;">
		<div class="col-xs-4" style="padding-left: 0;">
			<div class="dropdown">
				<button class="btn btn-primary" id="dropdownMenu1"
					data-toggle="dropdown">
					<span id="btn-text">全部宣教</span> <span class="caret"></span>
				</button>
				<ul class="dropdown-menu" id="drop_m"
					aria-labelledby="dropdownMenu1">
					<li><a href="javascript:void(0)" id="op1">全部宣教</a></li>
					<s:iterator value="#request.xuanjiaofl">
						<li><a href="javascript:void(0)" id="op${dm }">${mc }</a></li>
					</s:iterator>
				</ul>
			</div>
		</div>
		<div class="col-xs-2"></div>
		<!-- <div class="col-xs-3 col-xs-offset-5" style="padding-right: 0; padding-left: 6%;">
					<button type="button" id="butto" class="btn btn-primary">确定</button>
				</div> -->
	</div>
	</div>
	<!--查询结束-->
	<div class="container" id="content">
		<div class="row propaganda">
			<div class="col-xs-12" style="padding-left: 10px; padding-right: 10px; margin-top: 10px;">
				<div class="panel-group" id="panel_gp">
					<s:iterator value="#request.brxuanjiaonr">
						<div class="panel panel-default box-sdow">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion" href="#collapse${fldm }"> 
										<strong>${flmc }</strong>
									</a>
								</h4>
							</div>
							<div id="collapse${fldm }" class="panel-collapse collapse in">
								<div class="panel-body">
									<s:iterator value="xuanJiaoBingRenNeiRongSubs">
										<div>
											<p>${mc }</p>
											<p>${xjnr }</p>
											<s:if test="yjflag==1">
												<button class="btn btn-default pull-right">已宣教</button>
											</s:if>
											<s:else>
												<button class="btn btn-info pull-right">确定</button>
												<input value="${dm }" style="display:none;"/>
											</s:else>
											<div class="clearfix"></div>
											<div class="divider"></div>
										</div>
									</s:iterator>
								</div>
							</div>
						</div>
					</s:iterator>
				</div>
			</div>
		</div>

		<!--导航结束-->
		<div class="clear "></div>
		<%@ include file="menu-hushi.jsp" %>

	</div>
	<!--页脚开始-->
	<%@ include file="footer.jsp" %>

	<!--页脚结束-->
</body>

</html>