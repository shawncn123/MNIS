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
<title>入院护理评估(一般资料)</title>
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
<script src="scripts/jquery.scrollTo-2.1.2.js" type="text/javascript"></script>

<script type="text/javascript">

$(function(){
	var currYear = (new Date()).getFullYear();	
	var opt={};
	opt.date = {preset : 'date'};
	opt.datetime = {preset : 'datetime'};
	opt.time = {preset : 'time'};
	opt.default = {
		theme: 'android-ics light', //皮肤样式
        display: 'modal', //显示方式 
        mode: 'scroller', //日期选择模式
		dateFormat: 'yyyy-mm-dd',
		lang: 'zh',
		showNow: true,
		nowText: "今天",
        startYear: currYear - 10, //开始年份
        endYear: currYear + 80 //结束年份
	};
    var optDateTime = $.extend(opt['datetime'], opt['default']);
    $("#yiZhuRq").mobiscroll(optDateTime).datetime(optDateTime);//年月日时分型

    function current(){        //时间插件 获取当前日期
		var dt = new Date()
		var y = dt.getFullYear(); 
		var m = dt.getMonth()+1; 
		var d = dt.getDate();
		var h = dt.getHours();
		var mm = dt.getMinutes();
		str=y+'-'+(m<10 ? "0"+ m : m)+'-'+(d<10 ? "0" + d : d) + " " + h + ":" + mm;
		
		return str; 
    }
/* 	setInterval(function(){
		$("#yiZhuRq").attr('value',current)
	}); */
 });

/* function changeDate() {
	var vxzrq = $("#yiZhuRq").val();
	$("#messid").html("");
	$("#pgrqv").val(vxzrq);
	var url = "hzwxyspgforjquery";
	var args = {"pgrqv":vxzrq}; 
	$.post(url,args,function(data) {
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
} */

function pg_submit(){
	/* $("#pgrqv").attr('value', $("#yiZhuRq").val()); */
	
	var url = "updatehlpgyibanziliao";
	var args = $('#hulipgyibanform').serialize();
	$.post(url,args,function(data) {
		if(data == "1"){
			$("#messid").html("保存成功！");
		}else{
			$("#messid").html("保存失败！");
		}
	});
}
</script>
</head>
<body>
	<%@ include file="header-bingren.jsp"%>
		<div class="row" style="border-bottom:1px solid #269abc;padding: 5px 0 ; margin: 0;">
			<!-- <div class="col-xs-4" style="padding: 0 2px;">
				<div class="demos">
					<input value="" class="form-control" name="chajiantime" id="yiZhuRq" type="text" placeholder="" onchange="changeDate()" readonly="readonly">
				</div>
			</div> -->
			<div class="col-xs-4" style="padding: 0 2px;">
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
	    <form action="" id="hulipgyibanform">
	    	<input value="${bingren_hulipinggu.bah }" name="bah" style="width:100%;display:none;"/>
	    	<input value="${bingren_hulipinggu.bq }" name="bq" style="width:100%;display:none;"/>
	    	<input value="${bingren_hulipinggu.rowkey }" name="rowkey" style="width:100%;display:none;"/>
	    	<div class="row" style="padding-bottom: 2%;padding-top: 2%;margin-bottom: 1%;margin-top: 1%;">
				<div class="col-xs-2" style="padding-right: 0;">
					<span>姓名:</span>
				</div>
				<div class="col-xs-4" style="padding-right: 0;border-bottom: 1px solid;padding-left: 0;">
					<input value="${bingren_hulipinggu.xm }" name="xm" style="width:100%"/>
				</div>
				<div class="col-xs-2" style="padding-right: 0;">
					<span>性别:</span>
				</div>
				<div class="col-xs-4" style="padding-right: 0;border-bottom: 1px solid;padding-left: 0;">
					<input value="${bingren_hulipinggu.xb }" name="xb"  style="width:100%"/>
				</div>
			</div>	    
	    	<div class="row" style="padding-bottom: 2%;padding-top: 2%;margin-bottom: 1%;margin-top: 1%;">
				<div class="col-xs-2" style="padding-right: 0;">
					<span>年龄:</span>
				</div>
				<div class="col-xs-4" style="padding-right: 0;border-bottom: 1px solid;padding-left: 0;">
					<input value="${bingren_hulipinggu.nl }" name="nl"  style="width:100%"/>
				</div>
				<div class="col-xs-2" style="padding-right: 0;">
					<span>科别:</span>
				</div>
				<div class="col-xs-4" style="padding-right: 0;border-bottom: 1px solid;padding-left: 0;">
					<input value="${bingren_hulipinggu.bqksmc }" name="bqksmc"  style="width:100%"/>
				</div>
			</div>	    
	    	<div class="row" style="padding-bottom: 2%;padding-top: 2%;margin-bottom: 1%;margin-top: 1%;">
				<div class="col-xs-2" style="padding-right: 0;">
					<span>床号:</span>
				</div>
				<div class="col-xs-4" style="padding-right: 0;border-bottom: 1px solid;padding-left: 0;">
					<input value="${bingren_hulipinggu.chw }" name="chw"  style="width:100%"/>
				</div>
				<div class="col-xs-2" style="padding-right: 0;">
					<span>职业:</span>
				</div>
				<div class="col-xs-4" style="padding-right: 0;border-bottom: 1px solid;padding-left: 0;">
					<input value="${bingren_hulipinggu.zy }" name="zy"  style="width:100%"/>
				</div>
			</div>	    
	    	<div class="row" style="padding-bottom: 2%;padding-top: 2%;margin-bottom: 1%;margin-top: 1%;">
				<div class="col-xs-2" style="padding-right: 0;">
					<span>民族:</span>
				</div>
				<div class="col-xs-4" style="padding-right: 0;border-bottom: 1px solid;padding-left: 0;">
					<input value="${bingren_hulipinggu.mz }" name="mz"  style="width:100%"/>
				</div>
				<div class="col-xs-2" style="padding-right: 0;">
					<span>文化程度:</span>
				</div>
				<div class="col-xs-4" style="padding-right: 0;border-bottom: 1px solid;padding-left: 0;">
					<input value="${bingren_hulipinggu.whcd }" name="whcd"  style="width:100%"/>
				</div>
			</div>	    
	    	<div class="row" style="padding-bottom: 2%;padding-top: 2%;margin-bottom: 1%;margin-top: 1%;">
				<div class="col-xs-4" style="padding-right: 0;">
					<span>病史供述人:</span>
				</div>
				<div class="col-xs-8" style="padding-right: 0;border-bottom: 1px solid;padding-left: 0;">
					<input value="${bingren_hulipinggu.bsgsr }" name="bsgsr" />
				</div>
			</div>	    
	    	<div class="row" style="padding-bottom: 2%;padding-top: 2%;margin-bottom: 1%;margin-top: 1%;">
				<div class="col-xs-4" style="padding-right: 0;">
					<span>入院时间:</span>
				</div>
				<div class="col-xs-8" style="padding-right: 0;border-bottom: 1px solid;padding-left: 0;">
					<!-- <input value="" name="rysj" /> -->
					<input value="${bingren_hulipinggu.rksj }" class="form-control" name="rksj" id="yiZhuRq" type="text" placeholder="" onchange="" readonly="readonly">
				</div>
			</div>	    
	    	<div class="row" style="padding-bottom: 2%;padding-top: 2%;margin-bottom: 1%;margin-top: 1%;">
				<div class="col-xs-4" style="padding-right: 0;">
					<span>入院途径:</span>
				</div>
				<div class="col-xs-8" style="padding-right: 0;border-bottom: 1px solid;padding-left: 0;">
					<select class="form-control" name="rytj">
						<s:if test="rytj=='急诊'">
							<option value="急诊" selected="selected">急诊</option>
						</s:if>
						<s:else>
							<option value="急诊">急诊</option>
						</s:else>
						<s:if test="rytj=='门诊'">
							<option value="门诊" selected="selected">门诊</option>
						</s:if>
						<s:else>
							<option value="门诊">门诊</option>
						</s:else>
						<s:if test="rytj=='转入'">
							<option value="转入" selected="selected">转入</option>
						</s:if>
						<s:else>
							<option value="转入">转入</option>
						</s:else>
					</select>
				</div>
			</div>	    
	    	<div class="row" style="padding-bottom: 2%;padding-top: 2%;margin-bottom: 1%;margin-top: 1%;">
				<div class="col-xs-4" style="padding-right: 0;">
					<span>费用支付:</span>
				</div>
				<div class="col-xs-8" style="padding-right: 0;border-bottom: 1px solid;padding-left: 0;">
					<select class="form-control" name="fylb" >
						<s:if test="fylb=='医疗保险'">
							<option value="医疗保险" selected="selected">医疗保险</option>
						</s:if>
						<s:else>
							<option value="医疗保险">医疗保险</option>
						</s:else>
						<s:if test="fylb=='新农合'">
							<option value="新农合" selected="selected">新农合</option>
						</s:if>
						<s:else>
							<option value="新农合">新农合</option>
						</s:else>
						<s:if test="fylb=='自费'">
							<option value="自费" selected="selected">自费</option>
						</s:if>
						<s:else>
							<option value="自费">自费</option>
						</s:else>
						<s:if test="fylb=='其它'">
							<option value="其它" selected="selected">其它</option>
						</s:if>
						<s:else>
							<option value="其它">其它</option>
						</s:else>
					</select>
				</div>
			</div>	    
	    	<div class="row" style="padding-bottom: 2%;padding-top: 2%;margin-bottom: 1%;margin-top: 1%;">
				<div class="col-xs-4" style="padding-right: 0;">
					<span>入院方式:</span>
				</div>
				<div class="col-xs-8" style="padding-right: 0;border-bottom: 1px solid;padding-left: 0;">
					<select class="form-control" name="ryfs">
						<s:if test="ryfs=='步行'">
							<option value="步行" selected="selected">步行</option>
						</s:if>
						<s:else>
							<option value="步行">步行</option>
						</s:else>
						<s:if test="ryfs=='轮椅'">
							<option value="轮椅" selected="selected">轮椅</option>
						</s:if>
						<s:else>
							<option value="轮椅">轮椅</option>
						</s:else>
						<s:if test="ryfs=='平车'">
							<option value="平车" selected="selected">平车</option>
						</s:if>
						<s:else>
							<option value="平车">平车</option>
						</s:else>
						<s:if test="ryfs=='其它'">
							<option value="其它" selected="selected">其它</option>
						</s:if>
						<s:else>
							<option value="其它">其它</option>
						</s:else>
					</select>
				</div>
			</div>	    
	    
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