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
<script type="text/javascript">

	$(function() {$(document).ready(function() {
		$(".yzzxfl_select").click(function() {
		var vflyz = $(this).attr("value");
/* 	使用$(this).val() 回丢失前面的数字0	alert( $(this).val()); */
		var val_text = $(this).text();
		var url = "bingrYiZhuZhiXingforjquery";
		var args = {"vxzzxfl":vflyz}; 
		$.post(url,args,function(data) {
			a = '';
			if(data!=null && data!="" ){
				d = eval("("+ data+ ")");
				for (var i = 0; i < d.length; i++) {
					var obj =  d[i].rq;
					var teo = new Date(obj.time);
					var vmonth = teo.getMonth()+1;
					if(vmonth<10){
						vmonth = "0"+vmonth;
					}
					var vday =  teo.getDate();
					if(vday < 10){
						vday = "0" + vday;
					}
					var vyzrq1 = teo.getFullYear() + "-" + vmonth + "-" + vday + " 00:00:00.0";
					var vyzrq2 = teo.getFullYear() + "-" + vmonth + "-" + vday;
					var vyzrq3 = teo.getFullYear() + vmonth + vday;
					
					a = a + '<div class="row module" id="' + vyzrq3 + '-' + d[i].groupxh + '">';
						
					var tmp_yzmcs = d[i].yzmcs;
					for(var j = 0;j<tmp_yzmcs.length;j++){
							a = a + '<div class="col-xs-12" ><span>' + tmp_yzmcs[j] + '</span></div>';
						}
					
					a = a + '</div><div class="row"><div class="col-xs-12 text-right" style="margin: 10px 0 10px 0;padding-bottom: 5px;border-top: #666666 1px dashed;"></div></div><div class="row" style="border-bottom: #666666 1px dashed;padding-bottom: 5px;margin-bottom: 5px;"><div class="col-xs-7"><span>'
					+ d[i].yf2mc + '</span></div><div class="col-xs-1" style="padding:0;">';
						
					if(d[i].lsflag=='0'){
						a = a + '<span style="font-size: 18px;border-radius: 20px;border: 2px solid #0316F7;padding: 5px;color: #0316F7;">长</span>';
					}else{
						a = a + '<span style="font-size: 18px;border-radius: 20px;border: 2px solid #03BFF7;padding: 5px; color: #03BFF7;">临</span>';
					}
					
					a = a + '</div><div class="col-xs-4" style="padding: 0 0 0 1%;"><span>';
					
					a = a + vyzrq2 + '</span></div></div>';
						
					a = a + '<div class="row" style="border-bottom: 2px solid #333333;padding-bottom: 10px;margin-bottom: 10px;"><div class="col-xs-12">';
					
					var tmp_twBryzzxRemodelSubs = d[i].twBryzzxRemodelSubs;
					for(var k = 0; k < tmp_twBryzzxRemodelSubs.length; k ++){
						a = a + '<div class="btn-group" data-toggle="buttons" style="display:block;">';
						if(d[i].zxflag=='1'){
							a = a + '<button type="button" class="btn btn-primary moduleTime" data-toggle="modal" data-target="#moduleModal" disabled="disabled" style="margin:0 0 0 2%;">' 
								+ tmp_twBryzzxRemodelSubs[k].sjd + '</button>';
						}else{
							a = a + '<input value="' + d[i].groupxh
								+ '" style="display:none;"/><button type="button" class="btn btn-primary moduleTime" data-toggle="modal" data-target="#moduleModal" style="margin:0 0 0 2%;" id="'
								+ tmp_twBryzzxRemodelSubs[k].rowkey +'">'
								+ tmp_twBryzzxRemodelSubs[k].sjd + '</button><input value="yzmc_' + i 
								+ '" style="display:none;"/>';
						}
						a = a + '</div>';
					}
					a = a + '</div></div>';
				}
			}else{
				a = "无数据！";
			} 
			 $("#accordion")[0].innerHTML = a; 
			 $("#dropdownMenu1")[0].innerHTML = val_text + '<span class="caret"></span>';
			 document.getElementById("saowandai").focus();
		})
	})})});
	
	
	$(function() {
		// 绑定
		$("#head_banner_1").smartFloat();
		
		//小宋 写的模态框
		 var height = $('#head_banner_1').height();     //模态框距离头部距离
		    $('#content').css('margin-top', height + 'px');
		    $('#modal-wrap').css({   
				'position':'fixed',
				'top':height + 'px',
				'width':'95%'
			});	
		    $('#moduleModal').on('shown.bs.modal', function () {
		        $('.modal-backdrop').css('top', height + 'px');
		    });
			
			var $clickBtn;
			var zx_sjd = "";
			var yz_groupxh = "";
			/* $('.moduleTime').click(function(){  */     //点击时间按钮模态框显示主页input里的内容
			$('#content_b').on('click','.moduleTime', function(){
				$clickBtn = $(this);
				yz_groupxh = $(this).prev().val();
				var yzmc_gid = $(this).next().val();
				var html = $("#" + yzmc_gid).html();
				zx_sjd = $(this).html();
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
			
		window.onload = function() {
			document.getElementById("saowandai").focus();
		}
</script>
</head>
<body>
	<%@ include file="header-bingren.jsp"%>
		<div class="row" style="border-bottom:1px solid #269abc;padding: 5px 0 ; margin: 0;">
			<%-- <div class="col-xs-6">
				<div class="dropdown">
					<button class="btn btn-default btn-block dropdown-toggle"
						type="button" id="dropdownMenu1" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="true">全部<span class="caret"></span>
					</button>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
						<li class="yzzxfl_select" id="test" value="00" style="padding: 5%;border-bottom: 1px dashed #E6E1E1;">全部</li>
						<s:iterator value="#request.yizhuzxfl">
							<li class="yzzxfl_select" value="${dm }" style="padding: 5%;border-bottom: 1px dashed #E6E1E1;">${mc }</li>
						</s:iterator>
					</ul>
				</div>
			</div> --%>
			<div class="col-xs-4" style="padding: 0 2px;">
				<div class="dropdown" style="width: 100%">
					<button class="btn btn-default btn-block dropdown-toggle"
						type="button" id="dropdownMenu1" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="true">全部<span class="caret"></span>
					</button>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
						<li class="yzzxfl_select" id="test" value="00" style="padding: 5%;border-bottom: 1px dashed #E6E1E1;">全部</li>
						<s:iterator value="#request.yizhuzxfl">
							<li class="yzzxfl_select" value="${dm }" style="padding: 5%;border-bottom: 1px dashed #E6E1E1;">${mc }</li>
						</s:iterator>
					</ul>
				</div>
			</div>
			<div class="col-xs-4" style="padding: 0 2px;display:none;">
				<div class="demos">
					<input value="" class="form-control" name="chajiantime" id="yiZhuRq" type="text" placeholder="" onchange="">
				</div>
			</div>
			<div class="col-xs-4" style="padding: 0 2px;">
				<div class="input-group input-group-xs">
					<input type="text" class="form-control" id="saowandai" placeholder="扫描" onfocus="javascript:this.value='';" oninput="myFunction()"/>
<!-- 						placeholder="扫描" onfocus="javascript:return false;" oninput="myFunction()"/> --> 
						 
					<span class="input-group-btn" style="display:none;">
						<button class="btn btn-default" type="button" id="chacw">查</button>
					</span>
				</div>
			</div>
		</div>
	</div>
	<div id="content_b" class="container">
		<div class="panel-group" id="accordion" style="z-index:-100">
		<s:iterator value="#request.bingrGeTi_YiZhu_zhixing"  status ="status">
<%-- 			<div class="row module" id="yzmc_<s:property value="#status.index"/>"> --%>
			<div class="row module" id="<s:date name="rq" format="yyyyMMdd"/>-${groupxh}">
				<s:iterator value="yzmcs" id="mc_yz">
					<div class="col-xs-12" >
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
				<div class="col-xs-7">
					<span>${yf2mc }</span>
				</div>
				<div class="col-xs-1" style="padding:0;">
					<s:if test="lsflag==0">
						<span style="font-size: 18px;border-radius: 20px;border: 2px solid #0316F7;padding: 5px;color: #0316F7;">长</span>
					</s:if>
					<s:else>
						<span style="font-size: 18px;border-radius: 20px;border: 2px solid #03BFF7;padding: 5px; color: #03BFF7;">临</span>
					</s:else>
				</div>
				<div class="col-xs-4" style="padding: 0 0 0 1%;">
					<span><s:date name="rq" format="yyyy-MM-dd"/></span>
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
								<button type="button" class="btn btn-primary moduleTime" data-toggle="modal" data-target="#moduleModal" id="${rowkey }">${sjd}</button>
								<input value="yzmc_<s:property value="#status.index"/>" style="display:none;"/>
							</s:else>
						</div>
					</s:iterator>
				</div>
			</div>
		</s:iterator>
		</div>
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