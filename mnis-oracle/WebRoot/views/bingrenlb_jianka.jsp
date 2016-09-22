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
<title>用户列表</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="SHORTCUT ICON" href="images/favicon.ico">
<link rel="icon" href="images/favicon.ico" type="image/x-icon">
<script type="text/javascript" src="scripts/jquery-1.12.1.min.js"></script>
<script type="text/javascript" src="scripts/viewjs.js"></script>
<script type="text/javascript">
	$(function() {
		// 绑定
		$("#head_banner_1").smartFloat();
	});
</script>
<script type="text/javascript">
	//选择病区查询病人
		var d = '';
		var a = '';
	$(function() {$(document).ready(function() {
		$(".bingqu_select").click(function() {
		var val = $(this).val();
		var val_text = $(this).text();
		var url = "bingqbr_bybingqid";
		var args = {"bqid" : val/* ,"time" : new Date() */};
		$.post(url,args,function(data) {
			a = '';
			d = eval("("+ data+ ")");
			for (var i = 0; i < d.length; i++) {
				a = a + '<a href="views/yewumokuai.jsp?bingren_key1=' 
				+ d[i].key1 + '&bingren_key2=' + d[i].key2 + '&bingren_name=' + d[i].xm + '&bingren_cw=' + d[i].chw
				+ '&bingren_nl=' + d[i].nl + '&bingren_bq=' + d[i].bq + '"><div class="col-xs-6" style="padding: 0 5px 0 5px;"><div class="panel panel-default" style="margin: 5px 0 5px 0;"><div class="table-responsive"><table class="table table-condensed"><tr><td class="text-center"><span style="color:' 
					  + d[i].fylbBoxcolor + ";background-color: "+ d[i].fylbBoxcolor +'">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>&nbsp;&nbsp;'
					  + d[i].yems + '</td><td class="text-center">' + d[i].hldj + '</td></tr><tr><td class="text-center"><h4>'
					  + d[i].chw + '床</h4></td><td class="text-left"><h4>' + d[i].xm 
					  + '</h4></td></tr><tr><td class="text-center">' + d[i].bah + '</td><td class="text-center">' + d[i].fylb
					  + '&nbsp;' + d[i].nl + '</td></tr></table></div></div></div></a>';
					  }
			$("#brlb")[0].innerHTML = a;
			$("#dropdownMenu1")[0].innerHTML = val_text + '<span class="caret"></span>';
			$("#bingqu_name")[0].innerHTML = val_text;
			/* $("#brlb").html(a); */
			});
		});
		
		$("#leix_check").click(function() {
			/* alert(d.length); */
			a = "";
			if(d == ""){
				var val = $("#dangq_bingq_id").val();
				var url = "bingqbr_bybingqid";
				var args = {"bqid" : val/* ,"time" : new Date() */};
				$.post(url,args,function(data) {
					d = eval("("+ data+ ")");
					for (var i = 0; i < d.length; i++) {
						a = a + '<a href="views/yewumokuai.jsp?bingren_key1=' 
						+ d[i].key1 + '&bingren_key2=' + d[i].key2 + '&bingren_name=' + d[i].xm + '&bingren_cw=' + d[i].chw
						+ '&bingren_nl=' +d[i].nl + '&bingren_bq=' + d[i].bq + '"><div class="col-xs-6" style="padding: 0 5px 0 5px;"><div class="panel panel-default" style="margin: 5px 0 5px 0;"><div class="table-responsive"><table class="table table-condensed" style="table-layout:fixed;"><tr><td style="padding-right:0px;"><span style="color:' 
						+ d[i].fylbBoxcolor +';background-color: '+ d[i].fylbBoxcolor 
						+'">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></td><td colspan="2" style="padding-right:0px;">' 
						+ d[i].yems +'&nbsp;&nbsp;' + d[i].hldj + '</td></tr><tr><td style="padding-right:0px;"><h4>' 
						+ d[i].chw + '床</h4></td><td colspan="2" style="padding-right:0px;"><h4>' 
						+ d[i].xm + '</h4></td></tr><tr><td style="padding-right:0px;">' 
						+ d[i].bah + '</td><td style="padding-right:0px;padding-left:0px;">' 
						+ d[i].fylb + '</td><td style="padding-right:0px;">${xb }&nbsp;' 
						+ d[i].nl + '</td></tr><tr><td style="padding-right:0px;">' 
						+ d[i].ksmc + '</td><td style="padding-right:0px;padding-left:0px;" class="text-right">病情:</td><td style="padding-right:0px;">' 
						+ d[i].dqbkzt + '</td></tr><tr><td colspan="3" style="padding-right:0px;overflow:hidden;text-overflow:ellipsis;" nowrap="nowrap">诊断：' 
						+ d[i].ryzd + '</td></tr><tr><td colspan="3" style="padding-right:0px;overflow:hidden;text-overflow:ellipsis;" nowrap="nowrap">过敏史：' 
						+ d[i].gmls + '</td></tr><tr><td colspan="3" style="padding-right:0px;overflow:hidden;text-overflow:ellipsis;" nowrap="nowrap">膳食：' 
						+ d[i].shanshi + '</td></tr><tr><td style="padding-right:0px;">医生:&nbsp;' + d[i].ysxm 
						+ '</td><td style="padding-right:0px;padding-left:0px;" class="text-right">护士:</td><td style="padding-right:0px;">' 
						+ d[i].hsxm + '</td></tr><tr><td colspan="3" style="padding-right:0px;overflow:hidden;text-overflow:ellipsis;" nowrap="nowrap">手术：' 
						+ d[i].ssms + '</td></tr><tr><td style="padding-right:0px;" colspan="3">' + d[i].ryrq.substring(0,10) + '&nbsp;&nbsp;' 
						+ d[i].zytsms + '</td></tr></table></div></div></div></a>';
					}
					$("#brlb")[0].innerHTML = a;
				});
			}
			if(d != ""){
			for (var i = 0; i < d.length; i++) {
				a = a + '<a href="views/yewumokuai.jsp?bingren_key1=' 
				+ d[i].key1 + '&bingren_key2=' + d[i].key2 + '&bingren_name=' + d[i].xm + '&bingren_cw=' + d[i].chw
				+ '&bingren_nl=' +d[i].nl + '&bingren_bq=' + d[i].bq + '"><div class="col-xs-6" style="padding: 0 5px 0 5px;"><div class="panel panel-default" style="margin: 5px 0 5px 0;"><div class="table-responsive"><table class="table table-condensed" style="table-layout:fixed;"><tr><td style="padding-right:0px;"><span style="color:' 
				+ d[i].fylbBoxcolor +';background-color: '+ d[i].fylbBoxcolor 
				+'">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></td><td colspan="2" style="padding-right:0px;">' 
				+ d[i].yems +'&nbsp;&nbsp;' + d[i].hldj + '</td></tr><tr><td style="padding-right:0px;"><h4>' 
				+ d[i].chw + '床</h4></td><td colspan="2" style="padding-right:0px;"><h4>' 
				+ d[i].xm + '</h4></td></tr><tr><td style="padding-right:0px;">' 
				+ d[i].bah + '</td><td style="padding-right:0px;padding-left:0px;">' 
				+ d[i].fylb + '</td><td style="padding-right:0px;">${xb }&nbsp;' 
				+ d[i].nl + '</td></tr><tr><td style="padding-right:0px;">' 
				+ d[i].ksmc + '</td><td style="padding-right:0px;padding-left:0px;" class="text-right">病情:</td><td style="padding-right:0px;">' 
				+ d[i].dqbkzt + '</td></tr><tr><td colspan="3" style="padding-right:0px;overflow:hidden;text-overflow:ellipsis;" nowrap="nowrap">诊断：' 
				+ d[i].ryzd + '</td></tr><tr><td colspan="3" style="padding-right:0px;overflow:hidden;text-overflow:ellipsis;" nowrap="nowrap">过敏史：' 
				+ d[i].gmls + '</td></tr><tr><td colspan="3" style="padding-right:0px;overflow:hidden;text-overflow:ellipsis;" nowrap="nowrap">膳食：' 
				+ d[i].shanshi + '</td></tr><tr><td style="padding-right:0px;">医生:&nbsp;' + d[i].ysxm 
				+ '</td><td style="padding-right:0px;padding-left:0px;" class="text-right">护士:</td><td style="padding-right:0px;">' 
				+ d[i].hsxm + '</td></tr><tr><td colspan="3" style="padding-right:0px;overflow:hidden;text-overflow:ellipsis;" nowrap="nowrap">手术：' 
				+ d[i].ssms + '</td></tr><tr><td style="padding-right:0px;" colspan="3">' + d[i].ryrq.substring(0,10) + '&nbsp;&nbsp;' 
				+ d[i].zytsms + '</td></tr></table></div></div></div></a>';
			}
			$("#brlb")[0].innerHTML = a;
			}else{
				$("#brlb")[0].innerHTML = "没有数据";
			}
		});
	});
});
</script>
</head>
<body class="bg-info">
	<div id="head_banner_1" style="z-index:1000;" class="bg-info">
		<div class="row"
			style="border-bottom:1px solid #269abc;padding: 10px 15px 5px 15px;">
			<div class="col-xs-2">
				<a href="#"> <img src="images/icon-m-man-active.png"
					class="img-responsive" alt="<s:property value='#session.caozuoyuan.ryxm' />">
				</a>
			</div>
			<div class="col-xs-4">
				<span><strong><s:property
							value="#session.caozuoyuan.ryxm" /></strong></span>
				<p class="text-left" style="margin-bottom: 5px;" id="bingqu_name"><s:property
							value="#session.dangqianbingqu_name" /></p>
				<input id="dangq_bingq_id" value="<s:property value='#session.dangqianbingqu_id' />" style="display:none;"/>
			</div>
			<div class="col-xs-2">
				<a href="#"> <img src="images/i-form-comment.png"
					class="img-responsive" alt="消息数">
				</a>
			</div>
			<div class="col-xs-2">
				<a href="#"> <img src="images/browser_48px.png"
					class="img-responsive" alt="刷新">
				</a>
			</div>
			<div class="col-xs-2" style="padding: 0 2%;margin:1% 0 0 0;">
				<input class="btn btn-default" type="button" value="看细卡" id="leix_check" style="padding: 5%">
			</div>
		</div>
		<div class="row"
			style="border-bottom:1px solid #269abc;padding: 5px 0 5px 0;">
			<div class="col-xs-5" style="padding: 0 0 0 5%;">
				<div class="dropdown" style="width: 100%">
					<button class="btn btn-default btn-sm dropdown-toggle"
						type="button" id="dropdownMenu1" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="true">
						<s:property value="#session.caozuoyuan.bqmc" />
						<span class="caret"></span>
					</button>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
						<s:iterator value="#request.caozuoyuan_bingqu">
							<li class="bingqu_select" value="${bq }">${bqmc }</li>
						</s:iterator>
					</ul>
				</div>
				<%-- <select class="bingqu_select">
					<s:iterator value="#request.caozuoyuan_bingqu">
						<s:if test="bq == #session.caozuoyuan.bq">
							<option value="${bq }" selected="selected">${bqmc }</option>
						</s:if>
						<s:else>
							<option value="${bq }">${bqmc }</option>
						</s:else>
					</s:iterator>
				</select> --%>
			</div>
			<div class="col-xs-4" style="padding: 0 2px;">
				<div class="input-group input-group-xs">
					<input type="text" class="form-control" placeholder="查床号">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button">Go!</button>
					</span>
				</div>
				<!-- /input-group -->
			</div>

			<div class="col-xs-3" style="padding: 0 2px;">
				<div class="checkbox" style="margin: 5px 0">
					<label><input type="checkbox">我的病人</label>
				</div>
			</div>

		</div>
	</div>
	<div class="container">
		<div class="row" style="border-bottom:1px solid #269abc;" id="brlb">
			<s:iterator value="#request.bqry">
				<a href="views/yewumokuai.jsp?bingren_key1=${key1 }&bingren_key2=${key2}&bingren_name=${xm}&bingren_cw=${chw}&bingren_nl=${nl}">
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
				<%-- <a href="views/yewumokuai.jsp">
					<div class="col-xs-6" style="padding: 0 5px 0 5px;">
						<div class="panel panel-default" style="margin: 5px 0 5px 0;">
							<div class="table-responsive">
								<table class="table table-condensed" style="table-layout:fixed;">
									<tr>
										<td style="padding-right:0px;"><span
											style="color: ${fylbBoxcolor };background-color: ${fylbBoxcolor }">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
										<td style="padding-right:0px;padding-left:0px;">${yems}</td>
										<td colspan="2" style="padding-right:0px;">${yems}&nbsp;&nbsp;${hldj }</td>
									</tr>
									<tr>
										<td style="padding-right:0px;"><h4>${chw }床</h4></td>
										<td colspan="2" style="padding-right:0px;"><h4>${xm }</h4></td>
										<!-- <td style="padding-right:0px;"></td> -->
									</tr>
									<tr>
										<td style="padding-right:0px;">${bah }</td>
										<td style="padding-right:0px;padding-left:0px;">${fylb }</td>
										<td style="padding-right:0px;">${xb }&nbsp;${nl }</td>
									</tr>
									<tr>
										<td style="padding-right:0px;">${ksmc }</td>
										<td style="padding-right:0px;padding-left:0px;"
											class="text-right">病情:</td>
										<td style="padding-right:0px;">${dqbkzt }</td>
									</tr>
									<tr>
										<td colspan="3"
											style="padding-right:0px;overflow:hidden;text-overflow:ellipsis;"
											nowrap='nowrap'>诊断：${ryzd }</td>
									</tr>
									<tr>
										<td colspan="3"
											style="padding-right:0px;overflow:hidden;text-overflow:ellipsis;"
											nowrap='nowrap'>过敏史：${gmls }</td>
									</tr>
									<tr>
										<td colspan="3"
											style="padding-right:0px;overflow:hidden;text-overflow:ellipsis;"
											nowrap='nowrap'>膳食：${shanshi }</td>
									</tr>
									<tr>
										<td style="padding-right:0px;">医生:&nbsp;${ysxm }</td>
										<td style="padding-right:0px;padding-left:0px;"
											class="text-right">护士:</td>
										<td style="padding-right:0px;">${hsxm }</td>
									</tr>
									<tr>
										<td colspan="3"
											style="padding-right:0px;overflow:hidden;text-overflow:ellipsis;"
											nowrap='nowrap'>手术：${ssms }厕所看到飞机上的快捷方式</td>
									</tr>
									<tr>
										<td style="padding-right:0px;" colspan="3"><s:property
												value="ryrq.substring(0,10)"></s:property>&nbsp;&nbsp;${zytsms }</td>

										<td colspan="2" style="padding-right:0px;">${zytsms }</td>
									</tr>
								</table>
							</div>
						</div>
					</div>
				</a> --%>
			</s:iterator>
		</div>
		<div class="row">
			<div class="table-responsive" style="margin-bottom: 0px;">
				<table class="table table-condensed" style="padding: 5px;">
					<tr>
						<td><img src="images/foot_tu_1.png"
							class="img-responsive center-block" alt="病区视图"
							style="width: 30%;"></td>
						<td><img src="images/foot_tu_2.png"
							class="img-responsive center-block" alt="巡房视图"
							style="width: 30%;"></td>
						<td><img src="images/foot_tu_3.png"
							class="img-responsive center-block" alt="生命体征视图"
							style="width: 30%;"></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<s:debug></s:debug>
	<!--页脚结束-->
	<script type="text/javascript" src="scripts/bootstrap.min.js"></script>
</body>
</html>
