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
	<base href="<%=basePath%>">
	<meta charset="UTF-8">
	<title>修改密码</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="SHORTCUT ICON" href="images/favicon.ico">
	<link rel="icon" href="images/favicon.ico" type="image/x-icon">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="author" content="融汇国康" />
	<meta name="keywords" content="移动护理信息系统" />
	<meta name="description" content="修改密码,高大上的移动护理系统。" />
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
			$("#success").hide();
		});
	</script>
	<script type="text/javascript">
		String.prototype.trim=function() {
    		return this.replace(/(^\s*)|(\s*$)/g,'');
		};
		$(function() {$(document).ready(function() {
			 $("#oldPassword").focus(function(){
				$("#prompt1").hide();
				$("#prompt2").hide();
				$("#success").hide();
			});
			$("#newPassword").focus(function(){
				$("#prompt1").hide();
				$("#prompt2").hide();
				$("#success").hide();
			});
			$("#confirmPassword").focus(function(){
				$("#prompt1").hide();
				$("#prompt2").hide();
				$("#success").hide();
			});
			
			$("#queding").click(function() {
				var val_oldpass = $("#oldPassword").val();
				var val_newpass = $("#newPassword").val();
				val_oldpass = val_oldpass.trim();
				val_newpass = val_newpass.trim();
				
				if (val_oldpass == "" || val_newpass=="") {
						$('#prompt1').show();
				} else {
					var url = "mimamodify";
					var args = {
						"voldpass": val_oldpass,
						"vnewpass": val_newpass,
						};
					$.post(url, args, function(data) {
						if (data == "0") {
							$('#prompt1').hide();
							$('#prompt2').hide();
							$('#success').show();
							}else if(data == "2"){
								$('#success').hide();
								$('#prompt2').hide();
								$('#prompt1').show();
							}else if(data == "3"){
								self.location = "views/login.jsp";
							}else{
								alert("密码修改失败，请稍候再试。");
							}
						});
					};
				});
			}); 
		});
	</script>
</head>

<body>
	<%@ include file="header-hushi.jsp" %>
	</div>
	<div id="content" class="container">
		<form class="form-horizontal" role="form" style="margin-top: 20px;">
			<div class="form-group">
		      <label for="oldPassword" class="col-xs-4 control-label text-right" style="font-weight: normal; padding-right: 0;">当前密码:</label>
		      <div class="col-xs-8">
		         <input type="password" class="form-control" id="oldPassword" placeholder="6-16个字符" required="required" name="voldpass">
		      </div>
		   	</div>
		   	<div class="row" id="prompt1" style=" text-align: right; margin-top: -10px; margin-bottom: 10px;">
		   		<i style="display: inline-block; width: 14px; height: 14px; vertical-align: middle; background: url(images/icon.png) no-repeat left; background-size: 100%;"></i><span style="padding-left: 5px; margin-right: 14px; font-size: 12px; color: #f9590d;">密码输入错误</span>
		   	</div>
		   	<div class="form-group">
		      <label for="newPassword" class="col-xs-4 control-label text-right" style="font-weight: normal; padding-right: 0;">新密码:</label>
		      <div class="col-xs-8">
		         <input type="password" class="form-control" id="newPassword" placeholder="6-16个字符" required="required" name="vnewpass">
		      </div>
		   	</div>
		   	<div class="form-group">
		      <label for="confirmPassword" class="col-xs-4 control-label text-right" style="font-weight: normal; padding-right: 0;">确认密码:</label>
		      <div class="col-xs-8">
		         <input type="password" class="form-control" id="confirmPassword" placeholder="6-16个字符" required="required">
		      </div>
		   	</div>
		  	<div class="row" id="prompt2" style=" text-align: right; margin-top: -10px; margin-bottom: 10px;">
		   		<i style="display: inline-block; width: 14px; height: 14px; vertical-align: middle; background: url(images/icon.png) no-repeat left; background-size: 100%;"></i><span style="padding-left: 5px; margin-right: 14px; font-size: 12px; color: #f9590d;">两次输入的密码不一致</span>
		   	</div>
		</form>
			<div style="padding: 20px;">
				<!-- <a href="javascript:void(0)"> -->
					<button type="button" class="btn btn-block btn-primary" id="queding">确定</button>
				<!-- </a> -->
			</div>
			<div id="success" style="margin: 20px; padding: 20px 0; text-align: center; border: 1px solid #ccc; background: #D8EEEE;">
			    <i style=" display: inline-block; width: 20px; height: 20px; padding-right: 5px; line-height: 20px; border-radius: 50%; background: #0663A2; color: #fff; font-size: 16px; margin-right: 5px;">√</i><span style="color: #0663A2">密码修改成功</span>
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