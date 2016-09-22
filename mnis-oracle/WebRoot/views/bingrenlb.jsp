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
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<title>病人列表</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link href="css/base.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/song.css"/>
<link rel="SHORTCUT ICON" href="images/favicon.ico">
<link rel="icon" href="images/favicon.ico" type="image/x-icon">
<script type="text/javascript" src="scripts/jquery-1.12.1.min.js"></script>
<script type="text/javascript" src="scripts/viewjs.js"></script>
<script src="scripts/song.js" type="text/javascript"></script>

<script type="text/javascript">
	$(function() {
		// 绑定
		$("#head_banner_1").smartFloat();

		$('#sideWrap').hide(); //菜单
		$('#sideBtn').click(function() {
			$('#sideWrap').show();
			$('#sideMenu').show();
		});
		$('#sideWrap').click(function(e) { //点击菜单以外的地方隐藏菜单
			var $tar = $(e.target);
			if (!$tar.is('#sideMenu')) {
				$(this).hide();
			}
		});
	});
	function myFunction() {
		document.getElementById("chacw").click();
	}
	window.onload = function() {
		document.getElementById("saowandai").focus();
	}
</script>
<script type="text/javascript">
	//选择病区查询病人
	var d = '';
	var a = '';
	var c = '';
	var vbq =  '';
	var vbrlb = 'qbbr';
	$(function() {$(document).ready(function() {
		$(".bingqu_select").click(function() {
		$("#leix_check").val("看细卡");
		var valbq = $(this).val();
		vbq = valbq;
		var val_text = $(this).text();
		var url = "bingqbr_bybqidbrlb";
		var args = {"bqid" : vbq,"brxzlx":vbrlb/* ,"time" : new Date() */};
		$.post(url,args,function(data) {
			a = '';
			d = eval("("+ data+ ")");
			for (var i = 0; i < d.length; i++) {
				a = a + '<a href="bingreng_yewumokuai?v_key1='+ d[i].key1+ '&v_key2='+ d[i].key2
				+ '"><div class="col-xs-6" style="padding: 0;"><div class="panel panel-default" style="margin: 1% 0 0 0;"><div class="table-responsive"><table class="table table-condensed"><tr><td class="text-center"><span style="color:' 
				+ d[i].fylbBoxcolor + ";background-color: "+ d[i].fylbBoxcolor +'">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>&nbsp;&nbsp;'
				+ d[i].yems+ '</td><td class="text-center">'+ d[i].hldj
				+ '</td></tr><tr><td class="text-center"><h4>'+ d[i].chw
				+ '床</h4></td><td class="text-left"><h4>'
				+ d[i].xm + '</h4></td></tr><tr><td class="text-center">' + d[i].bah + '</td><td class="text-center">'
				+ d[i].fylb + '&nbsp;' + d[i].nl + '</td></tr></table></div></div></div></a>';
			}
			$("#brlb")[0].innerHTML = a;
			$("#dropdownMenu1")[0].innerHTML = val_text + '<span class="caret"></span>';
			$("#bingqu_name")[0].innerHTML = val_text;
		});
	});
	//选择病人类型 全部病人 责任病人 我的病人 查询
	
	$(".bingren_select").click(function() {
		$("#leix_check").val("看细卡");
		var val = $(this).val();
		vbrlb = val;
		var val_text = $(this).text();
		var url = "bingqbr_bybqidbrlb";
		if(vbq == ''){
			vbq = $("#dangq_bingq_id").val();
		}
		var args = {"bqid" : vbq,"brxzlx":vbrlb/* ,"time" : new Date() */};
		$.post(url,args,function(data) {
			a = '';
			d = eval("("+ data+ ")");
			for (var i = 0; i < d.length; i++) {
				a = a + '<a href="bingreng_yewumokuai?v_key1='+ d[i].key1+ '&v_key2='+ d[i].key2
				+ '"><div class="col-xs-6" style="padding: 0;"><div class="panel panel-default" style="margin: 1% 0 0 0;;"><div class="table-responsive"><table class="table table-condensed"><tr><td class="text-center"><span style="color:' 
				+ d[i].fylbBoxcolor + ";background-color: "+ d[i].fylbBoxcolor +'">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>&nbsp;&nbsp;'
				+ d[i].yems+ '</td><td class="text-center">'+ d[i].hldj
				+ '</td></tr><tr><td class="text-center"><h4>'+ d[i].chw
				+ '床</h4></td><td class="text-left"><h4>'
				+ d[i].xm + '</h4></td></tr><tr><td class="text-center">' + d[i].bah + '</td><td class="text-center">'
				+ d[i].fylb + '&nbsp;' + d[i].nl + '</td></tr></table></div></div></div></a>';
			}
			$("#brlb")[0].innerHTML = a;
			$("#dropdownMenu2")[0].innerHTML = val_text + '<span class="caret"></span>';
			/* $("#bingqu_name")[0].innerHTML = val_text; */
		});
	});

	$("#leix_check").click(function() {
		var lxtext = $("#leix_check").val();
		if(lxtext=="看细卡"){
			$("#leix_check").val("看简卡");
			a = "";
			if (d == "") {
				var val = $("#dangq_bingq_id").val();
				var url = "bingqbr_bybingqid";
				var args = {"bqid" : val/* ,"time" : new Date() */};
					$.post(url,args,function(data) {
						d = eval("(" + data+ ")");
						for (var i = 0; i < d.length; i++) {
						a = a + '<a href="bingreng_yewumokuai?v_key1=' + d[i].key1 + '&v_key2=' + d[i].key2
						+ '"><div class="col-xs-6" style="padding: 0;"><div class="panel panel-default" style="margin: 1% 0 0 0;;"><div class="table-responsive"><table class="table table-condensed" style="table-layout:fixed;"><tr><td style="padding-right:0px;"><span style="color:' 
						+ d[i].fylbBoxcolor +';background-color: '+ d[i].fylbBoxcolor 
						+'">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></td><td colspan="2" style="padding-right:0px;">'
						+ d[i].yems + '&nbsp;&nbsp;' + d[i].hldj
						+ '</td></tr><tr><td style="padding-right:0px;"><h4>' + d[i].chw
						+ '床</h4></td><td colspan="2" style="padding-right:0px;"><h4>'
						+ d[i].xm + '</h4></td></tr><tr><td style="padding-right:0px;">'+ d[i].bah
						+ '</td><td style="padding-right:0px;padding-left:0px;">'+ d[i].fylb
						+ '</td><td style="padding-right:0px;">${xb }&nbsp;' + d[i].nl + '</td></tr><tr><td style="padding-right:0px;">'
						+ d[i].ksmc + '</td><td style="padding-right:0px;padding-left:0px;" class="text-right">病情:</td><td style="padding-right:0px;">'
						+ d[i].dqbkzt
						+ '</td></tr><tr><td colspan="3" style="padding-right:0px;overflow:hidden;text-overflow:ellipsis;" nowrap="nowrap">诊断：'
						+ d[i].ryzd
						+ '</td></tr><tr><td colspan="3" style="padding-right:0px;overflow:hidden;text-overflow:ellipsis;" nowrap="nowrap">过敏史：'
						+ d[i].gmls
						+ '</td></tr><tr><td colspan="3" style="padding-right:0px;overflow:hidden;text-overflow:ellipsis;" nowrap="nowrap">膳食：'
						+ d[i].shanshi 
						+ '</td></tr><tr><td colspan="3" style="padding-right:0px;overflow:hidden;text-overflow:ellipsis;" nowrap="nowrap">安全提醒：'
						+ d[i].aqtx 
						+ '</td></tr><tr><td style="padding-right:0px;">医生:&nbsp;' + d[i].ysxm
						+ '</td><td style="padding-right:0px;padding-left:0px;" class="text-right">护士:</td><td style="padding-right:0px;">'
						+ d[i].hsxm
						+ '</td></tr><tr><td colspan="3" style="padding-right:0px;overflow:hidden;text-overflow:ellipsis;" nowrap="nowrap">手术：'
						+ d[i].ssms + '</td></tr><tr><td style="padding-right:0px;" colspan="3">'
						+ d[i].ryrq.substring(0,10) + '&nbsp;&nbsp;'+ d[i].zytsms + '</td></tr></table></div></div></div></a>';
					}
					$("#brlb")[0].innerHTML = a;
				});
			}
			if (d != "") {
				for (var i = 0; i < d.length; i++) {
					a = a + '<a href="bingreng_yewumokuai?v_key1=' + d[i].key1 + '&v_key2=' + d[i].key2
					+ '"><div class="col-xs-6" style="padding: 0;"><div class="panel panel-default" style="margin: 1% 0 0 0;;"><div class="table-responsive"><table class="table table-condensed" style="table-layout:fixed;"><tr><td style="padding-right:0px;"><span style="color:' 
					+ d[i].fylbBoxcolor +';background-color: '+ d[i].fylbBoxcolor 
					+'">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></td><td colspan="2" style="padding-right:0px;">'
					+ d[i].yems + '&nbsp;&nbsp;' + d[i].hldj + '</td></tr><tr><td style="padding-right:0px;"><h4>'
					+ d[i].chw + '床</h4></td><td colspan="2" style="padding-right:0px;"><h4>'
					+ d[i].xm + '</h4></td></tr><tr><td style="padding-right:0px;">' + d[i].bah
					+ '</td><td style="padding-right:0px;padding-left:0px;">'
					+ d[i].fylb+ '</td><td style="padding-right:0px;">${xb }&nbsp;'+ d[i].nl
					+ '</td></tr><tr><td style="padding-right:0px;">'+ d[i].ksmc
					+ '</td><td style="padding-right:0px;padding-left:0px;" class="text-right">病情:</td><td style="padding-right:0px;">'
					+ d[i].dqbkzt
					+ '</td></tr><tr><td colspan="3" style="padding-right:0px;overflow:hidden;text-overflow:ellipsis;" nowrap="nowrap">诊断：'
					+ d[i].ryzd
					+ '</td></tr><tr><td colspan="3" style="padding-right:0px;overflow:hidden;text-overflow:ellipsis;" nowrap="nowrap">过敏史：'
					+ d[i].gmls
					+ '</td></tr><tr><td colspan="3" style="padding-right:0px;overflow:hidden;text-overflow:ellipsis;" nowrap="nowrap">膳食：'
					+ d[i].shanshi 
					+ '</td></tr><tr><td colspan="3" style="padding-right:0px;overflow:hidden;text-overflow:ellipsis;" nowrap="nowrap">安全提醒：'
					+ d[i].aqtx 
					+ '</td></tr><tr><td style="padding-right:0px;">医生:&nbsp;'+ d[i].ysxm
					+ '</td><td style="padding-right:0px;padding-left:0px;" class="text-right">护士:</td><td style="padding-right:0px;">'
					+ d[i].hsxm
					+ '</td></tr><tr><td colspan="3" style="padding-right:0px;overflow:hidden;text-overflow:ellipsis;" nowrap="nowrap">手术：'
					+ d[i].ssms + '</td></tr><tr><td style="padding-right:0px;" colspan="3">'+ d[i].ryrq.substring(0,10) + '&nbsp;&nbsp;'
					+ d[i].zytsms+ '</td></tr></table></div></div></div></a>';
				}
				$("#brlb")[0].innerHTML = a;
			} else {
				$("#brlb")[0].innerHTML = "没有数据";
			}
		}
		else{
			$("#leix_check").val("看细卡");
			a="";
			for (var i = 0; i < d.length; i++) {
				a = a + '<a href="bingreng_yewumokuai?v_key1='+ d[i].key1+ '&v_key2='+ d[i].key2
				+ '"><div class="col-xs-6" style="padding: 0;"><div class="panel panel-default" style="margin: 1% 0 0 0;;"><div class="table-responsive"><table class="table table-condensed"><tr><td class="text-center"><span style="color:' 
				+ d[i].fylbBoxcolor + ";background-color: "+ d[i].fylbBoxcolor +'">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>&nbsp;&nbsp;'
				+ d[i].yems+ '</td><td class="text-center">'+ d[i].hldj
				+ '</td></tr><tr><td class="text-center"><h4>'+ d[i].chw
				+ '床</h4></td><td class="text-left"><h4>'
				+ d[i].xm + '</h4></td></tr><tr><td class="text-center">' + d[i].bah + '</td><td class="text-center">'
				+ d[i].fylb + '&nbsp;' + d[i].nl + '</td></tr></table></div></div></div></a>';
			}
			$("#brlb")[0].innerHTML = a;
		}
	});

		$("#chacw").click(function() {
			var val = $("#saowandai").val();/* var val_text = $(this).text(); */
			var url = "chabingren_byWanDai";
			var args = {
				"wandaixx" : val/* ,"time" : new Date() */};
				$.post(url,args,function(data) {
					if (data != "") {
						d = eval("(" + data + ")");
						var a = "<p>姓名：<strong style='font-size: 20px;'>" + d.br_name
						+ "</strong></p>"
						+ "<p>床位号：<strong style='font-size: 20px;'>"
						+ d.br_chw + "</strong></p>"
						+ "<p>性别：<strong style='font-size: 20px;'>" + d.br_xb + "</strong></p>"
						+ "<p>年龄：<strong style='font-size: 20px;'>" + d.br_age + "</strong></p>"
						$("#modal_prxx")[0].innerHTML = a;
						$("#motal_f")[0].innerHTML = "<a href='bingreng_yewumokuai?v_key1=" + d.br_key1 + "&v_key2="
						+ d.br_key2 + "' class='btn pull-left btn-primary'>确定</a>"
						+ "<button type='button' id='quxiao' class='btn btn-default' data-dismiss='modal'>取消</button>"
						$('#moduleallswd').modal('show');
					} else {
						$("#modal_prxx")[0].innerHTML = "<p>没有相关病人信息</p>";
						$("#motal_f")[0].innerHTML = "<button type='button' id='quxiao' class='btn btn-default' data-dismiss='modal'>确定</button>";
						$('#moduleallswd').modal('show');
					}
				});
			});

			$(function() {

				var height = $('#head_banner_1').height(); //模态框距离头部距离
				$('#content').css('margin-top', height + 'px');
				$('#modal-wrap').css('margin-top',height + 'px');
				$('#informationModal').on('shown.bs.modal',function() {
					$('.modal-backdrop').css('top',height + 'px')
				});

			});
		});
	});
</script>
</head>
<body class="bg-info">
	<%@ include file="header-hushi.jsp" %>
		<div class="row"
			style="border-bottom:1px solid #269abc;padding: 5px 0 5px 0;">
			<div class="col-xs-4" style="padding: 0 0 0 5%;">
				<div class="dropdown" style="width: 100%">
					<button class="btn btn-default btn-sm dropdown-toggle"
						type="button" id="dropdownMenu1" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="true">
						<s:if test="#session.dangqianbingqu_name!=null">
							<s:property value="#session.dangqianbingqu_name" />
						</s:if>
						<s:else>
							<s:property value="#session.caozuoyuan.bqmc" />
						</s:else>
						<span class="caret"></span>
					</button>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
						<s:iterator value="#request.caozuoyuan_bingqu">
							<li class="bingqu_select" value="${bq }">${bqmc }</li>
						</s:iterator>
					</ul>
				</div>
			</div>
			<div class="col-xs-3" style="padding: 0 0 0 5%;">
				<div class="dropdown" style="width: 100%">
					<button class="btn btn-default btn-sm dropdown-toggle"
						type="button" id="dropdownMenu2" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="true">
						全部病人 <span class="caret"></span>
					</button>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
						<li class="bingren_select" value="0">全部病人</li>
						<li class="bingren_select" value="1">责任病人</li>
						<li class="bingren_select" value="2">我的病人</li>
					</ul>
				</div>
			</div>
			<div class="col-xs-3" style="padding: 0 2px;">
				<div class="input-group input-group-xs">
					<!-- <input type="text" class="form-control" id="saowandai" placeholder="扫腕带" id="prwandxx" onfocus="javascript:this.value='';"> -->
					<input type="text" class="form-control" id="saowandai"
						placeholder="扫腕带" onfocus="javascript:this.value='';"
						oninput="myFunction()" />
					<span class="input-group-btn" style="display:none;">
						<button class="btn btn-default" type="button" id="chacw">查</button>
					</span>
				</div>
				<!-- /input-group -->
			</div>
			<div class="col-xs-2" style="padding: 0 2px;">
				<input class="btn btn-default" type="button" value="看细卡"
					id="leix_check" style="padding: 5%">
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row" style="border-bottom:1px solid #269abc;" id="brlb">
			<s:iterator value="#request.bqry">
				<a href="bingreng_yewumokuai?v_key1=${key1 }&v_key2=${key2}">
					<div class="col-xs-6" style="padding: 0;">
						<div class="panel panel-default" style="margin: 1% 0 0 0;">
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
	<!--页脚开始-->
	<%@ include file="footer.jsp" %>
	<!--页脚结束-->
	<script type="text/javascript" src="scripts/bootstrap.min.js"></script>
</body>
</html>
