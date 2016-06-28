<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="zh_cn">
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>我的病人列表</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/caidan.css"/>
<link href="css/base.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/song.css"/>
<script type="text/javascript" src="scripts/jquery-1.12.1.min.js"></script>
<script type="text/javascript" src="scripts/viewjs.js"></script>
<script src="scripts/song.js" type="text/javascript"></script>

<script type="text/javascript">
	$(function() {
		// 绑定
		$("#head_banner_1").smartFloat();
	});
	
	$('#sideWrap').hide();        //菜单
	$('#sideBtn').click(function(){
		$('#sideWrap').show();
		$('#sideMenu').show();
	});	
	$('#sideWrap').click(function(e){    //点击菜单以外的地方隐藏菜单
		var $tar = $(e.target);
		if(!$tar.is('#sideMenu')){
			$(this).hide();
		}
	});
	
	/* function myFunction() {
	 
	    document.getElementById("chacw").click();
	}
	window.onload = function()
	{
		document.getElementById("saowandai").focus();
	}
 */
</script>
</head>
<body class="bg-info">
	<%@ include file="header-hushi.jsp" %>
	</div>
	<div class="container">
		<div class="row" style="border-bottom:1px solid #269abc;" id="brlb">
			<s:iterator value="#request.bqry">
				<a href="bingreng_yewumokuai?v_key1=${key1 }&v_key2=${key2}">
					<div class="col-xs-6" style="padding: 0 5px 0 5px;">
						<div class="panel panel-default" style="margin: 5px 0 5px 0;">
							<div class="table-responsive">
								<table class="table table-condensed">
									<tr>
										<td class="text-center"><span
											style="color: ${fylbBoxcolor };background-color: ${fylbBoxcolor }">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
											&nbsp;&nbsp;${yems}</td>
										<td class="text-center">${hldj }</td>
									</tr>
									<tr>
										<td class="text-center"><h4>${chw }床</h4></td>
										<td class="text-left"><h4>${xm }</h4></td>
									</tr>
									<tr>
										<td class="text-center">${bah }</td>
										<td class="text-center">${fylb }&nbsp;${xb }&nbsp;${nl }</td>
									</tr>
								</table>
							</div>
						</div>
					</div>
				</a>
			</s:iterator>
		</div>
		<%@ include file="menu-hushi.jsp" %>
	</div>
	<%@ include file="footer.jsp"%>
	
	<!-- 模态框（Modal）start -->
		<div class="modal fade" id="informationModal" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" id="modal-wrap">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">病人信息</h4>
					</div>
					<div class="modal-body" id="modal_prxx">
						<p>姓名：<strong style="font-size: 20px;"></strong></p>						
						<p>床位号：<strong style="font-size: 20px;"></strong></p>
						<p>性别：<strong style="font-size: 20px;"></strong></p>
						<p>年龄：<strong style="font-size: 20px;"></strong></p>
					</div>
					<div class="modal-footer" id="motal_f">
						<button type="button" class="btn pull-left btn-primary">
							确定
						</button>
						<button type="button" id="quxiao" class="btn btn-default" data-dismiss="modal">
							取消
						</button>
					</div>
				</div>
			</div>
		</div>
		<!-- 模态框（Modal）end -->		
	
	<script type="text/javascript" src="scripts/bootstrap.min.js"></script>
</body>
</html>
