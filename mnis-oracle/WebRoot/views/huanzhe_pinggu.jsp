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
<title>危险因素评估</title>
<base href="<%=basePath%>">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="SHORTCUT ICON" href="images/favicon.ico">
<link rel="icon" href="images/favicon.ico" type="image/x-icon">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="融汇国康" />
<meta name="keywords" content="移动护理信息系统" />
<meta name="description" content="医嘱本,高大上的移动护理系统。" />
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<link href="css/base.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/song.css"/>
<script type="text/javascript" src="scripts/jquery-1.12.1.min.js"></script>
<script type="text/javascript" src="scripts/viewjs.js"></script>
<script src="scripts/song.js" type="text/javascript"></script>

<link href="css/bootstrap-clockpicker.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="scripts/bootstrap-clockpicker.min.js"></script>
<link href="css/mobiscroll_002.css" rel="stylesheet" type="text/css">
<link href="css/mobiscroll_003.css" rel="stylesheet" type="text/css">
<script src="scripts/mobiscroll_002.js" type="text/javascript"></script>
<script src="scripts/mobiscroll_004.js" type="text/javascript"></script>
<script src="scripts/mobiscroll.js" type="text/javascript"></script>
<script src="scripts/mobiscroll_003.js" type="text/javascript"></script>
<script src="scripts/mobiscroll_005.js" type="text/javascript"></script>
<script src="scripts/time-shen.js" type="text/javascript"></script>
<script src="scripts/jquery.scrollTo-2.1.2.js" type="text/javascript"></script>

<script type="text/javascript">
$(function() {
	
	$('#wxyspgform').on("click",".qdclass1",function(){
		if($(this).is(':checked')){
			$(this).next().val("1");
			/* var va1 = $(this).next().val(); */ 
			}else{
				$(this).next().val("0");
			}
	});
	
});

function changeDate() {
	var vxzrq = $("#yiZhuRq").val();
	$("#messid").html("");
	$("#pgrqv").val(vxzrq);
	var url = "hzwxyspgforjquery";
	var args = {"pgrqv":vxzrq}; 
	$.post(url,args,function(data) {
		/* alert(data); */
		var a = '';
		if(data!=null && data!="" ){
			d = eval("("+ data+ ")");
			var flag =  d[0].pgdm;
			if(flag!="" && flag!=null){
				a = a + '<input value="1" style="display:none;" id="modflag" name="modflag"></input>';
				a = a + '<input value="" style="display:none;" id="pgrqv" name="pgrqv"></input>';
				for (var i = 0; i < d.length; i++) {
					a = a + '<input value="' + d[i].pgdm + '" name="pgid" style="display:none;" id="' + d[i].pgdm
						+ '"/><div class="row" style="border-bottom: #666666 1px dashed;padding-bottom: 2%;padding-top: 2%;"><div class="col-xs-8"><span style="color:5d5454;">'
						+ d[i].wxys + '</span></div><div class="col-xs-2" style="padding-right:0;"><span style="color:5d5454;">'
						+ d[i].pgfeng + '分</span></div><div class="col-xs-2" style="padding-right:0;">';
					var vqdflag = d[i].qdflag;
					if(vqdflag==1){
						a = a + '<input type="checkbox" class="qdclass1" style="width: 100%; height: 2rem;" checked=checked></input>';
					}else{
						a = a + '<input type="checkbox" class="qdclass1" style="width: 100%; height: 2rem;" ></input>';
					}
					a = a + '<input name="quedflag" value="' + d[i].qdflag +'" style="display:none;" class="qdclass"/></div></div>';
				}
			}else{
				a = a + '<input value="0" style="display:none;" id="modflag" name="modflag"></input>';
				a = a + '<input value="" style="display:none;" id="pgrqv" name="pgrqv"></input>';
				for (var i = 0; i < d.length; i++) {
					a =  a + '<input value="' + d[i].id + '" name="pgid" style="display:none;" id="' + d[i].id
						+ '"/><div class="row" style="border-bottom: #666666 1px dashed;padding-bottom: 2%;padding-top: 2%;"><div class="col-xs-8"><span style="color:5d5454;">'
						+ d[i].wxys + '</span></div><div class="col-xs-2" style="padding-right:0;"><span style="color:5d5454;">'
						+ d[i].pgfeng + '分</span></div><div class="col-xs-2" style="padding-right:0;"><input type="checkbox" class="qdclass1" style="width: 100%; height: 2rem;" ></input>'
						+ '<input name="quedflag" value="0" style="display:none;" class="qdclass"/></div></div>';
				}
			}
		}
		 $("#wxyspgform")[0].innerHTML = a; 
	});
}

function pg_submit(){
	$("#pgrqv").attr('value', $("#yiZhuRq").val());
	
	var url = "updatehzwxpg";
	var args = $('#wxyspgform').serialize();
	$.post(url,args,function(data) {
		if(data == "1"){
			$("#messid").html("保存成功！");
		}else{
			$("#messid").html("保存失败！");
		}
	});
	/* document.getElementById('wxyspgform').submit(); */
}
</script>
</head>
<body>
	<%@ include file="header-bingren.jsp"%>
		<div class="row" style="border-bottom:1px solid #269abc;padding: 5px 0 ; margin: 0;">
			<div class="col-xs-4" style="padding: 0 2px;">
				<div class="demos">
					<input value="" class="form-control" name="chajiantime" id="yiZhuRq" type="text" placeholder="" onchange="changeDate()" readonly="readonly">
				</div>
			</div>
			<div class="col-xs-4" style="padding: 0 2px;">
				<span id="messid"></span>
			</div>
			<div class="col-xs-4" style="padding: 0 2px;">
				<button class="btn btn-default" type="button" id="baocun" style="float:right;" onclick="pg_submit()">保存</button>
			</div>
			<!-- <div class="col-xs-2" style="padding: 0 2px;">
				<button class="btn btn-default" type="button" id="quxiao">取消</button>
			</div> -->
		</div>
	</div>
	<div id="content_b" class="container">
	    <form action="updatehzwxpg" id="wxyspgform">
	    	<input value="" style="display:none;" id="pgrqv" name="pgrqv"></input>
	    <s:if test="#request.wxyspgbflag==1">
	    	<input value="1" style="display:none;" id="modflag" name="modflag"></input>
	    	<s:iterator value="#request.wxyspgb"  status ="status">
				<input value="${pgdm}" name="pgid" style="display:none;" id="${pgdm}"/>
				<div class="row"
					style="border-bottom: #666666 1px dashed;padding-bottom: 2%;padding-top: 2%;">
					<div class="col-xs-8">
						<span style="color:5d5454;">${wxys }</span>
					</div>
					<div class="col-xs-2" style="padding-right:0;">
						<span style="color:5d5454;">${pgfeng }分</span>
					</div>
					<div class="col-xs-2" style="padding-right:0;">
						<s:if test="qdflag==1">
							 <input type="checkbox" class="qdclass1"
										style="width: 100%; height: 2rem;" checked=checked></input>
						</s:if>
						<s:else>
						 	<input type="checkbox" class="qdclass1"
										style="width: 100%; height: 2rem;" ></input>
						</s:else>
						 <input name="quedflag" value="${qdflag}" style="display:none;" class="qdclass"/>
					</div>
				</div>
			</s:iterator>
	    </s:if>
	    <s:else>
	    	<input value="0" style="display:none;" id="modflag" name="modflag"></input>
			<s:iterator value="#request.wxyspgb"  status ="status">
				<input value="${id}" name="pgid" style="display:none;" id="${id}"/>
				<div class="row"
					style="border-bottom: #666666 1px dashed;padding-bottom: 2%;padding-top: 2%;">
					<div class="col-xs-8">
						<span style="color:5d5454;">${wxys }</span>
					</div>
					<div class="col-xs-2" style="padding-right:0;">
						<span style="color:5d5454;">${pgfeng }分</span>
					</div>
					<div class="col-xs-2" style="padding-right:0;">
						 <input type="checkbox" class="qdclass1"
										style="width: 100%; height: 2rem;" ></input>
						 <input name="quedflag" value="0" style="display:none;" class="qdclass"/>
					</div>
				</div>
			</s:iterator>
	    </s:else>
			<div class="row" style="display:none;">
					<input type="submit" value="确定" class="btn btn-primary"></input>
			</div>
		</form>
		<div class="clear"></div>
		<%@ include file="menu-hushi.jsp" %>
	</div>
	
	<!--页脚开始-->
	<%@ include file="footer.jsp" %>
	<!--页脚结束-->
	
	<script type="text/javascript" src="scripts/bootstrap.min.js"></script>
</body>
</html>