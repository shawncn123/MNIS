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
<title>压疮评估及预防</title>
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
	// 绑定
	$("#head_banner_1").smartFloat();
})

function changeDate() {
	var vxzrq = $("#yiZhuRq").val();
	$("#messid").html("");
	var url = "pinggudataforjquery";
	var args = {"pgrq":vxzrq,"bbfl":2}; 
	$.post(url,args,function(data) {
		var a = '';
		var zmkmc = 'test';
		if(data!=null && data!="" ){
			d = eval("("+ data+ ")");
			var flag =  d[0].tyflag;
			if(flag ==1){
				$("#baocunbutton")[0].innerHTML = '<button class="btn btn-default" type="button" id="baocun" style="float:right;" onclick="pg_submit_update()">修改保存</button>';
			}else{
				$("#baocunbutton")[0].innerHTML = '<button class="btn btn-default" type="button" id="baocun" style="float:right;" onclick="pg_submit()">保存</button>';
			}
			a = a + '<input name="pgrq" value="' + vxzrq + '" style="display:none;" id="pgrqv" />';
			for (var i = 0; i < d.length; i++) {
				if(i==0){
					a = a + '<input value="' + d[0].bbfl + '" style="display:none;" name="bbfl"/>';
				}
				var vrowkey="";
				var vzdata_1="";
				var vzdata_2="";
				var vzdata_3="";
				var vzdata_4="";
				var vzdata_5="";
				if(typeof(d[i].zddata_1)!="undefined"){
					vzdata_1 = d[i].zddata_1;
				}
				if(typeof(d[i].zddata_2)!="undefined"){
					vzdata_2 = d[i].zddata_2;
				}
				if(typeof(d[i].zddata_3)!="undefined"){
					vzdata_3 = d[i].zddata_3;
				}
				if(typeof(d[i].zddata_4)!="undefined"){
					vzdata_4 = d[i].zddata_4;
				}
				if(typeof(d[i].zddata_5)!="undefined"){
					vzdata_5 = d[i].zddata_5;
				}
				if(typeof(d[i].rowkey)!="undefined"){
					vrowkey=d[i].rowkey;
				}
				a =  a + '<input value="' + vrowkey + '" style="display:none;" name="rowkey"/>';
				if(zmkmc != d[i].zimokuai){
					a = a + '<h4 style="color: #a5a2a2;margin-bottom: 0;margin-top: 0;padding: 10px;border-top: 1px solid;">'
					 + d[i].zimokuai + '</h4>';
					zmkmc = d[i].zimokuai;
				}
				
				a = a + '<div class="row" style="border-top: 1px dashed #9fa2a2;padding: 5px 0; margin: 0;"><input value="'
					+ d[i].xmid + '" name="xmid" style="display:none;"/>';
				if(d[i].zdtype==1){
					a = a + '<div class="col-xs-4" style="margin-bottom:1%"><span style="float:right;">'
						+ d[i].xmmc + ':</span></div><div class="col-xs-4" style="padding: 0 1%;">'
						+ '<select class="form-control" name="neirong1">';
					for(var j=0; j<d[i].liststr.length;j++){
						if(vzdata_1 == d[i].liststr[j].keyValue){
							a = a + '<option value="' + d[i].liststr[j].keyValue + '" selected="selected">' + d[i].liststr[j].keyName + '</option>';
						}else{
							a = a + '<option value="' + d[i].liststr[j].keyValue + '">' + d[i].liststr[j].keyName + '</option>';
						}
					}	
				}
				if(d[i].zdtype==2){
					a = a + '<div class="col-xs-4" style="margin-bottom:1%"><span style="float:right;">'
						+ d[i].xmmc + ':</span></div>';
					if(d[i].length > 20){
						a = a + '<div class="col-xs-8" style="margin-bottom: 1%;margin-top:1%;"><textarea id="textcontent" class="form-control" maxlength="50" rows="3" name="neirong1" value="'
						 + vzdata_1 + '">' + vzdata_1 + '</textarea></div>';
					}else{
						if(d[i].dw==null || d[i].dw==''){
							a = a + '<div class="col-xs-8" style="margin-bottom: 1%;margin-top:1%;"><input value="'
								+ vzdata_1 + '" style="width: 100%;border:0; border-bottom:1px solid #000; text-align:center;" name="neirong1"/></div>';
						}else{
							a = a + '<div class="col-xs-4" style="margin-bottom: 1%;margin-top:1%;"><input value="'
								+ vzdata_1 + '" style="width: 100%;border:0; border-bottom:1px solid #000; text-align:center;" name="neirong1"/></div>'
								+ '<div class="col-xs-4" style="margin-bottom:1%"><span style="float:left;">'
								+ d[i].dw + '</span></div>';
						}
					}
				}
				if(d[i].zdtype==3){
					a = a + '<div class="col-xs-10"><span style="color:5d5454;">' + d[i].xmmc + '</span></div><div class="col-xs-2" style="padding-right:0;">';
					if(d[i].zddata_1==1){
						a = a + '<input type="checkbox" class="qdclass1" style="width: 100%; height: 2rem;" checked="checked"></input>'
							+ '<input name="neirong1" value="1" style="display:none;" class="qdclass"/>';
					}else{
						a = a + '<input type="checkbox" class="qdclass1" style="width: 100%; height: 2rem;"></input>'
						+ '<input name="neirong1" value="" style="display:none;" class="qdclass"/>';
					}
					a = a + '</div>';
				}
				a = a + '</div>';
				
				if(d[i].zdtype1==1 || d[i].zdtype1==2){
					a = a + '<div class="row" style="margin-top:1%;">';
					if(d[i].subname1!='' && d[i].subname1!=null){
						a = a + '<div class="col-xs-4" style="margin-top:1%;"><span style="float:right;color:#788082;">'
							+ d[i].subname1 + ':</span></div>';
					}else{
						a = a + '<div class="col-xs-4"><span></span></div>';
					}
					if(d[i].zdtype1==1){
						a = a + '<div class="col-xs-4" style="padding: 0 2px;"><select class="form-control" name="neirong2">';
						for(var k=0;j<d[i].liststr1.length;k++){
							if(vzdata_2 == d[i].liststr1[k].keyValue){
								a = a + '<option value="' + d[i].liststr1[k].keyValue + '" selected="selected">' + d[i].liststr1[k].keyName + '</option>';
							}else{
								a = a + '<option value="' + d[i].liststr1[k].keyValue + '">' + d[i].liststr1[k].keyName + '</option>';
							}
								
						}
						a = a + '</select></div>';
					}
					if(d[i].zdtype1==2){
						if(d[i].dw1==null || d[i].dw1==''){
							a = a + '<div class="col-xs-8" style="margin-bottom: 1%;margin-top:1%;"><input value="'
							 + vzdata_2 + '" style="width: 100%;border:0; border-bottom:1px solid #000; text-align:center;" name="neirong2"/></div>';
						}else{
							a = a + '<div class="col-xs-4" style="margin-bottom: 1%;margin-top:1%;"><input value="'
							+ vzdata_2 + '" style="width: 100%;border:0; border-bottom:1px solid #000; text-align:center;" name="neirong2"/></div>'
							+ '<div class="col-xs-4" style="margin-bottom:1%"><span style="float:left;">'
							+ d[i].dw1 + '</span></div>';
						}
					}
					a = a + '</div>';
				}else{
					a = a + '<input value="" name="neirong2" style="display:none;"/>';
				}
				
				if(d[i].zdtype2==1 || d[i].zdtype2==2){
					a = a + '<div class="row" style="margin-top:1%;">';
					if(d[i].subname2!='' && d[i].subname2!=null){
						a = a + '<div class="col-xs-4" style="margin-top:1%;"><span style="float:right;color:#788082;">'
							+ d[i].subname2 + ':</span></div>';
					}else{
						a = a + '<div class="col-xs-4"><span></span></div>';
					}
					if(d[i].zdtype2==1){
						a = a + '<div class="col-xs-4" style="padding: 0 2px;"><select class="form-control" name="neirong3">';
						for(var l=0;l<d[i].liststr2.length;l++){
							if(vzdata_3 == d[i].liststr2[l].keyValue){
								a = a + '<option value="' + d[i].liststr2[l].keyValue + '" selected="selected">' + d[i].liststr2[l].keyName + '</option>';
							}else{
								a = a + '<option value="' + d[i].liststr2[l].keyValue + '">' + d[i].liststr2[l].keyName + '</option>';
							}
								
						}
						a = a + '</select></div>';
					}
					if(d[i].zdtype2==2){
						if(d[i].dw2==null || d[i].dw2==''){
							a = a + '<div class="col-xs-8" style="margin-bottom: 1%;margin-top:1%;"><input value="'
							 + vzdata_3 + '" style="width: 100%;border:0; border-bottom:1px solid #000; text-align:center;" name="neirong3"/></div>';
						}else{
							a = a + '<div class="col-xs-4" style="margin-bottom: 1%;margin-top:1%;"><input value="'
							+ vzdata_3 + '" style="width: 100%;border:0; border-bottom:1px solid #000; text-align:center;" name="neirong3"/></div>'
							+ '<div class="col-xs-4" style="margin-bottom:1%"><span style="float:left;">'
							+ d[i].dw2 + '</span></div>';
						}
					}
					a = a + '</div>';
				}else{
					a = a + '<input value="" name="neirong3" style="display:none;"/>';
				}
				
				if(d[i].zdtype3==1 || d[i].zdtype3==2){
					a = a + '<div class="row" style="margin-top:1%;">';
					if(d[i].subname3!='' && d[i].subname3!=null){
						a = a + '<div class="col-xs-4" style="margin-top:1%;"><span style="float:right;color:#788082;">'
							+ d[i].subname3 + ':</span></div>';
					}else{
						a = a + '<div class="col-xs-4"><span></span></div>';
					}
					if(d[i].zdtype3==1){
						a = a + '<div class="col-xs-4" style="padding: 0 2px;"><select class="form-control" name="neirong4">';
						for(var m=0;m<d[i].liststr3.length;m++){
							if(vzdata_4 == d[i].liststr3[m].keyValue){
								a = a + '<option value="' + d[i].liststr3[m].keyValue + '" selected="selected">' + d[i].liststr3[m].keyName + '</option>';
							}else{
								a = a + '<option value="' + d[i].liststr3[m].keyValue + '">' + d[i].liststr3[m].keyName + '</option>';
							}
								
						}
						a = a + '</select></div>';
					}
					if(d[i].zdtype3==2){
						if(d[i].dw2==null || d[i].dw2==''){
							a = a + '<div class="col-xs-8" style="margin-bottom: 1%;margin-top:1%;"><input value="'
							 + vzdata_4 + '" style="width: 100%;border:0; border-bottom:1px solid #000; text-align:center;" name="neirong4"/></div>';
						}else{
							a = a + '<div class="col-xs-4" style="margin-bottom: 1%;margin-top:1%;"><input value="'
							+ vzdata_4 + '" style="width: 100%;border:0; border-bottom:1px solid #000; text-align:center;" name="neirong4"/></div>'
							+ '<div class="col-xs-4" style="margin-bottom:1%"><span style="float:left;">'
							+ d[i].dw3 + '</span></div>';
						}
					}
					a = a + '</div>';
				}else{
					a = a + '<input value="" name="neirong4" style="display:none;"/>';
				}

				if(d[i].zdtype4==1 || d[i].zdtype4==2){
					a = a + '<div class="row" style="margin-top:1%;">';
					if(d[i].subname4!='' && d[i].subname4!=null){
						a = a + '<div class="col-xs-4" style="margin-top:1%;"><span style="float:right;color:#788082;">'
							+ d[i].subname4 + ':</span></div>';
					}else{
						a = a + '<div class="col-xs-4"><span></span></div>';
					}
					if(d[i].zdtype4==1){
						a = a + '<div class="col-xs-4" style="padding: 0 2px;"><select class="form-control" name="neirong5">';
						for(var n=0;n<d[i].liststr4.length;n++){
							if(vzdata_5 == d[i].liststr4[n].keyValue){
								a = a + '<option value="' + d[i].liststr4[n].keyValue + '" selected="selected">' + d[i].liststr4[n].keyName + '</option>';
							}else{
								a = a + '<option value="' + d[i].liststr4[n].keyValue + '">' + d[i].liststr4[n].keyName + '</option>';
							}
								
						}
						a = a + '</select></div>';
					}
					if(d[i].zdtype4==2){
						if(d[i].dw2==null || d[i].dw2==''){
							a = a + '<div class="col-xs-8" style="margin-bottom: 1%;margin-top:1%;"><input value="'
							 + vzdata_5 + '" style="width: 100%;border:0; border-bottom:1px solid #000; text-align:center;" name="neirong5"/></div>';
						}else{
							a = a + '<div class="col-xs-4" style="margin-bottom: 1%;margin-top:1%;"><input value="'
							+ vzdata_5 + '" style="width: 100%;border:0; border-bottom:1px solid #000; text-align:center;" name="neirong5"/></div>'
							+ '<div class="col-xs-4" style="margin-bottom:1%"><span style="float:left;">'
							+ d[i].dw4 + '</span></div>';
						}
					}
					a = a + '</div>';
				}else{
					a = a + '<input value="" name="neirong5" style="display:none;"/>';
				}
			}
			a = a + '<div class="row" style="display:none;"><input type="submit" value="确定" class="btn btn-primary"></input></div>';
		}
		else{
			a = a + '<p>查询数据错误</p>';
		}
		a = a.replace("undefined","");  
		$("#hulipgpgform")[0].innerHTML = a; 
	});
}

$(function() {
	$('#hulipgpgform').on("click",".qdclass1",function(){
		if($(this).is(':checked')){
			$(this).next().val("1");
			/* var va1 = $(this).next().val(); */ 
			}else{
				$(this).next().val("0");
			}
	});
	
});

function pg_submit(){
	$("#pgrqv").attr('value', $("#yiZhuRq").val());
	var url = "savehulipinggujilu";
	var args = $('#hulipgpgform').serialize();
	$.post(url,args,function(data) {
		if(data == "1"){
			$("#messid").html("保存成功！");
			$("#baocun").attr("disabled","true");
		}else{
			$("#messid").html("保存失败！");
		}
	});
}
function pg_submit_update(){
	$("#pgrqv").attr('value', $("#yiZhuRq").val());
	var url = "updatehulipinggujilu";
	var args = $('#hulipgpgform').serialize();
	$.post(url,args,function(data) {
		if(data == "1"){
			$("#messid").html("修改成功！");
			$("#baocun").attr("disabled","true");
		}else{
			$("#messid").html("修改失败！");
		}
	});
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
			<%-- <div class="col-xs-4" style="padding: 0 2px;">
				<span id=""></span>
			</div> --%>
			<div class="col-xs-4" style="padding: 0 2px;">
				<span id="messid"></span>
			</div>
			
			<div class="col-xs-4" style="padding: 0 2px; float:right;" id="baocunbutton">
				<s:set var="dtflag" value="#request.hulipinggu_data[0].tyflag"></s:set>
				<s:if test="#dtflag==1">
					<button class="btn btn-default" type="button" id="baocun" style="float:right;" onclick="pg_submit_update()">修改保存</button>
				</s:if>
				<s:else>
					<button class="btn btn-default" type="button" id="baocun" style="float:right;" onclick="pg_submit()">保存</button>
				</s:else>
			</div>
		</div>
	</div>
	<div id="content_b" class="container" style="padding-left:0;padding-right:0;">
	    <form action="" id="hulipgpgform">
	    	<input name="pgrq" value="" style="display:none;" id="pgrqv" />
	    	<s:set name="zmkmc" value="'test'"></s:set>
	    	<s:iterator value="#request.hulipinggu_data" status="status">
	    		<s:if test="#status.index==0">
	    			<input value="${bbfl}" style="display:none;" name="bbfl"/>
	    		</s:if>
	    		<input value="${rowkey}" style="display:none;" name="rowkey"/>
	    		<s:if test="#zmkmc!=zimokuai">
	    			<h4 style="color: #a5a2a2;margin-bottom: 0;margin-top: 0;padding: 10px;border-top: 1px solid;">${zimokuai}</h4>
	    			<s:set name="zmkmc" value="zimokuai"></s:set>
	    		</s:if>
		    	<div class="row" style="border-top: 1px dashed #9fa2a2;padding: 5px 0; margin: 0;">
		    		<input value="${xmid }" name="xmid" style="display:none;"/>
					<s:if test="zdtype==1">
						<div class="col-xs-4" style="margin-bottom:1%">
							<span style="float:right;">${xmmc }:</span>
						</div>
						<div class="col-xs-4" style="padding: 0 1%;">
							<select class="form-control" name="neirong1" value="${zddata_1 }">
								<s:iterator value="liststr" status='st'>
									<s:if test="zddata_1==keyValue">
										<option value="${keyValue }" selected="selected">${keyName }</option>
									</s:if>
									<s:else>
										<option value="${keyValue }">${keyName }</option>
									</s:else>
								</s:iterator>
							</select>
						</div>
					</s:if>
					<s:if test="zdtype==2">
						<div class="col-xs-4" style="margin-bottom:1%">
							<span style="float:right;">${xmmc }:</span>
						</div>
						<s:if test="length > 20">
							<div class="col-xs-8" style="margin-bottom: 1%;margin-top:1%;">
								<textarea id="textcontent" class="form-control" maxlength="50" rows="3" name="neirong1" value="${zddata_1 }">${zddata_1 }</textarea>
							</div>
						</s:if>
						<s:else>
							<s:if test="dw==null || dw==''">
								<div class="col-xs-8" style="margin-bottom: 1%;margin-top:1%;">
									<input value="${zddata_1 }" style="width: 100%;border:0; border-bottom:1px solid #000; text-align:center;" name="neirong1"/>
								</div>
							</s:if>
							<s:else>
								<div class="col-xs-4" style="margin-bottom: 1%;margin-top:1%;">
									<input value="${zddata_1 }" style="width: 100%;border:0; border-bottom:1px solid #000; text-align:center;" name="neirong1"/>
								</div>
								<div class="col-xs-4" style="margin-bottom:1%">
									<span style="float:left;">${dw }</span>
								</div>
							</s:else>
						</s:else>
					</s:if>
					<s:if test="zdtype==3">
						<div class="col-xs-10">
							<span style="color:5d5454;">${xmmc }</span>
						</div>
						<div class="col-xs-2" style="padding-right:0;">
							<s:if test="zddata_1==1">
								<input type="checkbox" class="qdclass1"
											style="width: 100%; height: 2rem;" checked="checked"></input>
							 	<input name="neirong1" value="1" style="display:none;" class="qdclass"/>
							</s:if>
							<s:else>
								<input type="checkbox" class="qdclass1"
											style="width: 100%; height: 2rem;" ></input>
							 	<input name="neirong1" value="" style="display:none;" class="qdclass"/>
							</s:else>
						</div>
					</s:if>
				</div>	
				<s:if test="zdtype1==1 || zdtype1==2">
			    	<div class="row" style="margin-top:1%;">
			    		<s:if test="subname1!='' && subname1!=null">
							<div class="col-xs-4" style="margin-top:1%;">
								<span style="float:right;color:#788082;">${subname1 }:</span>
							</div>
			    		</s:if>
			    		<s:else>
			    			<div class="col-xs-4">
								<span></span>
							</div>
			    		</s:else>
						<s:if test="zdtype1==1">
							<div class="col-xs-4" style="padding: 0 2px;">
								<select class="form-control" name="neirong2">
									<s:iterator value="liststr1" status='st'>
										<s:if test="zddata_2==keyValue">
											<option value="${keyValue }" selected="selected">${keyName }</option>
										</s:if>
										<s:else>
											<option value="${keyValue }">${keyName }</option>
										</s:else>
									</s:iterator>
								</select>
							</div>
						</s:if>
						<s:if test="zdtype1==2">
							<s:if test="dw1==null || dw1==''">
								<div class="col-xs-8" style="margin-bottom: 1%;margin-top:1%;">
									<input value="${zddata_2 }" style="width: 100%;border:0; border-bottom:1px solid #000; text-align:center;" name="neirong2"/>
								</div>
							</s:if>
							<s:else>
								<div class="col-xs-4" style="margin-bottom: 1%;margin-top:1%;">
									<input value="${zddata_2 }" style="width: 100%;border:0; border-bottom:1px solid #000; text-align:center;" name="neirong2"/>
								</div>
								<div class="col-xs-4" style="margin-bottom:1%">
									<span style="float:left;">${dw1 }</span>
								</div>
							</s:else>
						</s:if>
					</div>	
				</s:if>
				<s:else>
						<input value="" name="neirong2" style="display:none;"/>
				</s:else>
				<s:if test="zdtype2==1 || zdtype2==2">
			    	<div class="row" style="margin-top:1%;">
			    		<s:if test="subname2!='' && subname2!=null">
							<div class="col-xs-4" style="margin-top:1%;">
								<span style="float:right;color:#788082;">${subname2 }:</span>
							</div>
			    		</s:if>
			    		<s:else>
			    			<div class="col-xs-4">
								<span></span>
							</div>
			    		</s:else>
						<s:if test="zdtype2==1">
							<div class="col-xs-4" style="padding: 0 2px;">
								<select class="form-control" name="neirong3">
									<s:iterator value="liststr2" status='st'>
										<s:if test="zddata_3==keyValue">
											<option value="${keyValue }" selected="selected">${keyName }</option>
										</s:if>
										<s:else>
											<option value="${keyValue }">${keyName }</option>
										</s:else>
									</s:iterator>
								</select>
							</div>
						</s:if>
						<s:if test="zdtype2==2">
							<s:if test="dw2==null || dw2==''">
								<div class="col-xs-8" style="margin-bottom: 1%;">
									<input value="${zddata_3 }" style="width: 100%;border:0; border-bottom:1px solid #000; text-align:center;" name="neirong3"/>
								</div>
							</s:if>
							<s:else>
								<div class="col-xs-4" style="margin-bottom: 1%;">
									<input value="${zddata_3 }" style="width: 100%;border:0; border-bottom:1px solid #000; text-align:center;" name="neirong3"/>
								</div>
								<div class="col-xs-4" style="margin-bottom:1%">
									<span style="float:left;">${dw2 }</span>
								</div>
							</s:else>
						</s:if>
					</div>	
				</s:if>
				<s:else>
						<input value="" name="neirong3" style="display:none;"/>
				</s:else>
				<s:if test="zdtype3==1 || zdtype3==2">
			    	<div class="row" style="margin-top:1%;">
			    		<s:if test="subname3!='' && subname3!=null">
							<div class="col-xs-4" style="margin-top:1%;">
								<span style="float:right;color:#788082;">${subname3 }:</span>
							</div>
			    		</s:if>
			    		<s:else>
			    			<div class="col-xs-4">
								<span></span>
							</div>
			    		</s:else>
						<s:if test="zdtype3==1">
							<div class="col-xs-4" style="padding: 0 2px;">
								<select class="form-control" name="neirong4">
									<s:iterator value="liststr3" status='st'>
										<s:if test="zddata_4==keyValue">
											<option value="${keyValue }" selected="selected">${keyName }</option>
										</s:if>
										<s:else>
											<option value="${keyValue }">${keyName }</option>
										</s:else>
									</s:iterator>
								</select>
							</div>
						</s:if>
						<s:if test="zdtype3==2">
							<s:if test="dw3==null || dw3==''">
								<div class="col-xs-8" style="margin-bottom: 1%;">
									<input value="${zddata_4 }" style="width: 100%;border:0; border-bottom:1px solid #000; text-align:center;" name="neirong4"/>
								</div>
							</s:if>
							<s:else>
								<div class="col-xs-4" style="margin-bottom: 1%;">
									<input value="${zddata_4 }" style="width: 100%;border:0; border-bottom:1px solid #000; text-align:center;" name="neirong4"/>
								</div>
								<div class="col-xs-4" style="margin-bottom:1%">
									<span style="float:left;">${dw3 }</span>
								</div>
							</s:else>
						</s:if>
					</div>	
				</s:if>
				<s:else>
						<input value="" name="neirong4" style="display:none;"/>
				</s:else>
				
				<s:if test="zdtype4==1 || zdtype4==2">
			    	<div class="row" style="margin-top:1%;">
			    		<s:if test="subname4!='' && subname4!=null">
							<div class="col-xs-4" style="margin-top:1%;">
								<span style="float:right;color:#788082;">${subname4 }:</span>
							</div>
			    		</s:if>
			    		<s:else>
			    			<div class="col-xs-4">
								<span></span>
							</div>
			    		</s:else>
						<s:if test="zdtype4==1">
							<div class="col-xs-4" style="padding: 0 2px;">
								<select class="form-control"  name="neirong5">
									<s:iterator value="liststr4" status='st'>
										<s:if test="zddata_5==keyValue">
											<option value="${keyValue }" selected="selected">${keyName }</option>
										</s:if>
										<s:else>
											<option value="${keyValue }">${keyName }</option>
										</s:else>
									</s:iterator>
								</select>
							</div>
						</s:if>
						<s:if test="zdtype4==2">
							<s:if test="dw4==null || dw4==''">
								<div class="col-xs-8" style="margin-bottom: 1%;">
									<input value="${zddata_5 }" style="width: 100%;border:0; border-bottom:1px solid #000; text-align:center;" name="neirong5"/>
								</div>
							</s:if>
							<s:else>
								<div class="col-xs-4" style="margin-bottom: 1%;">
									<input value="${zddata_5 }" style="width: 100%;border:0; border-bottom:1px solid #000; text-align:center;" name="neirong5"/>
								</div>
								<div class="col-xs-4" style="margin-bottom:1%">
									<span style="float:left;">${dw4 }</span>
								</div>
							</s:else>
						</s:if>
					</div>	
				</s:if>
				<s:else>
						<input value="" name="neirong5" style="display:none;"/>
				</s:else>
	    	</s:iterator>
	    
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