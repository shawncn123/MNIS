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
<title>临嘱未执行</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="沈旭峰" />
<meta name="keywords" content="移动护理信息系统" />
<meta name="description" content="病案首页,高大上的移动护理系统。" />
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<link href="css/base.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/song.css" />
<script type="text/javascript" src="scripts/jquery-1.12.1.min.js"></script>
<script src="scripts/bootstrap.min.js" type="text/javascript"
	charset="utf-8"></script>
<script type="text/javascript" src="scripts/viewjs.js"></script>
<script src="scripts/song.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	$(function() {
		// 绑定
		$("#head_banner_1").smartFloat();
	});
</script>
</head>
<body>
	<%@ include file="header-hushi.jsp"%>
	</div>
	<div id="content" class="container" style="padding: 0;">
		<div class="panel-group" id="accordion">
			<s:set var="chuangwei" value=""/>
			<s:iterator value="#request.linZhu_WeiZhiXing" status="status">
					<s:if test="#status.index==0">
					<s:set var="chuangwei" value="chw"/>
					<div class="panel panel-default">
						<div class="panel-heading" style="background-color: #AFD9EE;">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#collapse_<s:property value="#status.index"/>" style="font-size: 1.8rem;display: block; width: 100%;"> <strong style="font-size: 1.8rem;"> ${chw }床</strong>
								</a>
							</h4>
						</div>
						<div id="collapse_<s:property value="#status.index"/>" class="panel-collapse collapse in">
							<div class="panel-body" style="padding: 0 10px;">
				</s:if>
				<s:elseif test='chw!=#chuangwei'>
					<s:set var="chuangwei" value="chw"/>
						</div>
				</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading" style="background-color: #AFD9EE;">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#collapse_<s:property value="#status.index"/>" style="font-size: 1.8rem;display: block; width: 100%;"> 
									<strong style="font-size: 1.8rem;"> ${chw }床</strong>
								</a>
							</h4>
						</div>
						<div id="collapse_<s:property value="#status.index"/>" class="panel-collapse collapse in">
							<div class="panel-body" style="padding: 0 10px;">
				</s:elseif>
						<div class="row">
							<s:iterator value="yzmcs" id="mc_yz">
								<div class="col-xs-8">
									<span><s:property value="mc_yz"/></span>
								</div>
							</s:iterator>
						</div>
						<div class="row">
							<div class="col-xs-12 text-right"
									style="margin: 10px 0 10px 0;padding-bottom: 5px;border-top: #666666 1px dashed;">
							</div>
						</div>
						<div class="row"
							style="border-bottom: #666666 1px dashed;padding-bottom: 5px;margin-bottom: 5px;">
							<div class="col-xs-12">
								<span>${yf2mc }</span>
							</div>
						</div>
						<div class="row"
								style="border-bottom: 2px solid #333333;padding-bottom: 10px;margin-bottom: 10px;">
								<div class="col-xs-12">
									<s:iterator value="twBryzzxRemodelSubs" >
										<div class="btn-group" data-toggle="buttons">
											<s:if test="zxflag=='1'">
												<button type="button" class="btn btn-primary moduleTime" data-toggle="modal" data-target="#moduleModal" disabled="disabled">${sjd}</button> 
											</s:if>
											<s:else>
												<input value="${groupxh }" style="display:none;"/>
												<button type="button" class="btn btn-primary moduleTime" data-toggle="modal" data-target="#moduleModal">${sjd}</button>
												<input value="yzmc_<s:property value="#status.index"/>" style="display:none;"/>
											</s:else>
										</div>
									</s:iterator>
								</div>
							</div>	
						</div>
					</s:iterator>
					</div>
				</div>
			</div>
		</div>
		<!--导航结束-->
		<div class="clear"></div>
		<%@ include file="menu-hushi.jsp"%>
	</div>

	<!--页脚开始-->
	<%@ include file="footer.jsp" %>
	<!--页脚结束-->

</body>
</html>
