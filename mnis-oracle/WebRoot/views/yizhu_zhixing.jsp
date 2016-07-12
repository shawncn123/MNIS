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
<title>医嘱执行</title>
<base href="<%=basePath%>">
<link rel="stylesheet" href="css/bootstrap.min.css">
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
		
		//小宋 写的模态框
		 var height = $('#head_banner_1').height();     //模态框距离头部距离
		    $('#content').css('margin-top', height + 'px');
		    $('#modal-wrap').css('margin-top', height + 'px');
		    $('#moduleModal').on('shown.bs.modal', function () {
		        $('.modal-backdrop').css('top', height + 'px');
		    });
			
			var $clickBtn;
			var zx_sjd = "";
			var yz_groupxh = "";
			$('.moduleTime').click(function(){      //点击时间按钮模态框显示主页input里的内容
				$clickBtn = $(this);
				/* var html = $(this).prev().html(); */
				yz_groupxh = $(this).prev().val();
				var yzmc_gid = $(this).next().val();
				var html = $("#" + yzmc_gid).html();
				zx_sjd = $(this).html();
				/* alert(zx_sjd); */
				/* $("#myModalLabel").html("<span>"+zx_sjd+"</span>"); */
				$("#infocontent").html(html);
			});
		        
			$('#ensure').click(function(){ //点击模态框确定按钮后主页时间按钮禁用
				
				var yz_zxms = $("#textcontent").val();
				var url = "bingrGeTi_YiZhuZhiXing_baocun";
				var args = {"vsjd" : zx_sjd,"groupxh":yz_groupxh,"zxms":yz_zxms};
				$.post(url,args,function(data){
					if(data == "0"){
						$('#textcontent').val('');     //隐藏模态框时textarea值清空
						$('#moduleModal').modal('hide'); //隐藏模态窗口
						$clickBtn.attr('disabled','disabled');
					}else{
					//若data 的返回值不是1，则提示删除失败
						alert("数据保存失败！");							
					}
				});	
			});
		});
</script>
</head>
<body>
	<%-- <div id="head_banner_1" style="z-index:1000;" class="bg-info">
		<%@ include file="header.jsp"%> --%>
	<%@ include file="header-bingren.jsp"%>
	</div>
	<div id="content_b" class="container">
		<div class="row">
			<div class="col-xs-12"
				style="margin: 5px 0 5px 0;padding-bottom: 5px;border-bottom: #666666 1px solid;">
				<div class="dropdown">
					<a id="dLabel" data-target="#" href="http://example.com"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false"> 全部 <span class="caret"></span>
					</a>
					<ul class="dropdown-menu" aria-labelledby="dLabel">
						<li><a href="javascript:void(0)">药品</a></li>
						<li><a href="javascript:void(0)">检验采集</a></li>
						<li><a href="javascript:void(0)">其他</a></li>
					</ul>
				</div>
			</div>
		</div>
		<s:iterator value="#request.bingrGeTi_YiZhu_zhixing"  status ="status">
			<div class="row module" id="yzmc_<s:property value="#status.index"/>">
				<s:iterator value="yzmcs" id="mc_yz">
					<div class="col-xs-8">
						<span><s:property value="mc_yz"/></span>
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
								<%-- <label class="btn btn-primary active"> <input
									type="checkbox" autocomplete="off" checked/> ${sjd}</label> --%>
								<button type="button" class="btn btn-primary moduleTime" data-toggle="modal" data-target="#moduleModal" disabled="disabled">${sjd}</button> 
							</s:if>
							<s:else>
								<%-- <label class="btn btn-primary"> <input
									type="checkbox" autocomplete="off" onclick="javascript:alert('test')"/> ${sjd}</label> --%>
								<input value="${groupxh }" style="display:none;"/>
								<button type="button" class="btn btn-primary moduleTime" data-toggle="modal" data-target="#moduleModal">${sjd}</button>
								<input value="yzmc_<s:property value="#status.index"/>" style="display:none;"/>
							</s:else>
						</div>
					</s:iterator>
				</div>
			</div>
		</s:iterator>
		<div class="clear"></div>
		<%@ include file="menu-hushi.jsp" %>
	</div>
	
	<!--页脚开始-->
	<%@ include file="footer.jsp" %>
	<!--页脚结束-->
	
	<!-- 20160510 by 小宋 模态框（Modal）start -->
		<div class="modal fade" id="moduleModal" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" id="modal-wrap">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel"></h4>
					</div>
					<div class="modal-body">
						<div id="infocontent"></div>
						<textarea id="textcontent" class="form-control" maxlength="50" rows="3"></textarea>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn pull-left btn-primary" id="ensure">
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