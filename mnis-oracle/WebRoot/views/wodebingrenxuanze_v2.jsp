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
<title>我的病人选择</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="SHORTCUT ICON" href="images/favicon.ico">
<link rel="icon" href="images/favicon.ico" type="image/x-icon">
<link href="css/base.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/song.css" />
<script type="text/javascript" src="scripts/jquery-1.12.1.min.js"></script>
<script type="text/javascript" src="scripts/viewjs.js"></script>
<script type="text/javascript" src="scripts/bootstrap.min.js"></script>
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
	/* 	$('.qdclass1').click(function(){ */
		$('#brlb').on("click",".qdclass1",function(){
			/* alert("test"); */
			if($(this).is(':checked')){
				$(this).next().val("1");
				var va1 = $(this).next().val(); 
				}else{
					$(this).next().val("0");
				}
		});
		
		$(".bingqu_select").click(function() {
			var valbq = $(this).val();
			var val_text = $(this).text();
			/* 		var url = "bingqbr_bybingqid"; */
			var url = "woDeBingRenXuanZeWithBqId";
			var args = {"bqid" : valbq};
			$.post(url,args,function(data) {
				a = '';
				d = eval("("+ data+ ")");
				for (var i = 0; i < d.length; i++) {
					a = a + '<a href="javascript:void(0);"><div class="col-xs-4" style="padding: 0 5px 0 5px;">'
						+ '<div class="panel panel-default" style="margin: 5px 0 5px 0; border: 1px solid #ccc; color: #000; text-align: center;">'
						+ '<div class="row" style="margin: 0;"><div class="col-xs-7" style="padding: 0;">'
						+ '<h4 style="font-weight: bold; font-size: 20px; margin-left: -5px;">'
						+ d[i].chw + '床</h4><input name="chw" value="'
						+ d[i].chw + '" style="display:none;"/></div><div class="col-xs-5" style="padding: 0;">'
						+ '<input type="checkbox" class="qdclass1" style="display: block; margin-left: 3px; margin-top: 2px; width: 2rem; height: 2rem;"';
					if(d[i].quedflag==1){
						a = a + 'checked="checked"';
					}
					a = a + '></input><input name="quedflag" value="' + d[i].quedflag 
						  + '" style="display:none;" class="qdclass"/></div></div><p style="color: #333; margin-bottom: 5px;">'
						  + d[i].bqmc + '</p></div></div></a>';
				}
				$("#brlb")[0].innerHTML = a;
				$("#dropdownMenu1")[0].innerHTML = val_text + '<span class="caret"></span>';
				$("#bingqu_name")[0].innerHTML = val_text;
				$("#bqidcanshu").val(valbq);
			});
		});
		$("#allselect").click(function() {
			/* $(".qdclass1").attr("checked",true); */
			$("input[name='quedkuang']").prop("checked",true);
			$("input[name='quedflag']").prop("value","1");
/* 			$(".qdclass").val("1"); */
			
		});
		$("#allcancel").click(function() {
/* 			$(".qdclass1").attr("checked",false); */
			$("input[name='quedkuang']").prop("checked",false);
			$("input[name='quedflag']").prop("value","0");
/* 			$(".qdclass").val("0"); */
			
		});
	});
</script>
</head>

<body class="bg-info">
	<%@ include file="header-hushi.jsp"%>
		<div class="row"
			style="border-bottom:1px solid #269abc;padding: 5px 0 ;">
			<div class="col-xs-3" style="padding: 0 0 0 5%;">
				<div class="dropdown" style="width: 100%">
					<button class="btn btn-default btn-sm dropdown-toggle"
						type="button" id="dropdownMenu1" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="true">
						<s:if test="#request.daixzbingrens!=null"><s:property value="#request.daixzbingrens[0].bqmc"/></s:if>
						<s:elseif test="#session.dangqianbingqu_name!=null"><s:property value="#session.dangqianbingqu_name" /></s:elseif>
						<s:else><s:property value="#session.caozuoyuan.bqmc" /></s:else>
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
				<button type="button" class="btn pull-left btn-primary" id="allselect">全选</button>
			</div>
			<div class="col-xs-3" style="padding: 0 0 0 5%;">
				<button type="button" class="btn pull-left btn-primary" id="allcancel">全消</button>
			</div>
			<div class="col-xs-3" style="padding: 0 0 0 5%;">
				<button type="button" class="btn pull-left btn-primary" onclick="document.getElementById('formbrid').submit();">确定</button>
			</div>
		</div>
		<div class="row"
			style="border-bottom:1px solid #269abc;padding: 5px 0 ;">
			<div class="col-xs-4"></div>
			<div class="col-xs-8" style="padding: 0 5%  0 0;">
				<s:if test="#request.datasaveflag==1">
					<span style="margin: 0 0 0 2%;color: #6EF1F1;font-size: 14px;">保存成功！</span>
				</s:if>
				<s:if test="#request.datasaveflag==0">
					<span style="margin: 0 0 0 2%;color: red;font-size: 14px;">保存失败！</span>
				</s:if>
			</div>
		</div>
	</div>

	<div class="container" style=" position: relative;">
	   <form action="woDeBingRenXuanZeQueDing" method="post" id="formbrid">
		<div class="row" id="brlb">
			<s:iterator value="#request.daixzbingrens">
			<a href="javascript:void(0);">
				<div class="col-xs-4" style="padding: 0 5px 0 5px;">
					<div class="panel panel-default"
						style="margin: 5px 0 5px 0; border: 1px solid #ccc; color: #000; text-align: center;">
						<div class="row" style="margin: 0;">
							<div class="col-xs-7" style="padding: 0;">
								<h4 style="font-weight: bold; font-size: 20px; margin-left: -5px;">${chw}床</h4>
								<input name="chw" value="${chw}" style="display:none;"/>
							</div>
							<div class="col-xs-5" style="padding: 0;">                       
								 <input type="checkbox" class="qdclass1" name="quedkuang"
									style="display: block; margin-left: 3px; margin-top: 2px; width: 2rem; height: 2rem;" <s:if test="quedflag==1">checked="checked"</s:if>></input>
								<input name="quedflag" value="${quedflag}" style="display:none;" class="qdclass"/>
							</div>
						</div>
						<p style="color: #333; margin-bottom: 5px;">${bqmc }</p>
					</div>
				</div>
			</a> 
			</s:iterator>
		</div>
		<input name="bqid" value="<s:property value='#session.dangqianbingqu_id' />" style="display:none;" id="bqidcanshu"/>
		<div class="row" style="border-bottom:1px solid #269abc; display:none;">
				<input type="submit" value="确定" class="btn btn-primary pull-right"
				style="margin-right: 5px; margin-bottom: 10px;">
		</div>
		</form>
		<!--导航结束-->
		<div class="clear"></div>
		<%@ include file="menu-hushi.jsp"%>
	</div>

	<%@ include file="footer.jsp"%>

	<!-- 模态框（Modal）start -->
	<div class="modal fade" id="informationModal"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" id="modal-wrap">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">病人信息</h4>
				</div>
				<div class="modal-body" id="modal_prxx">
					<p>
						姓名：<strong style="font-size: 20px;"></strong>
					</p>
					<p>
						床位号：<strong style="font-size: 20px;"></strong>
					</p>
					<p>
						性别：<strong style="font-size: 20px;"></strong>
					</p>
					<p>
						年龄：<strong style="font-size: 20px;"></strong>
					</p>
				</div>
				<div class="modal-footer" id="motal_f">
					<button type="button" class="btn pull-left btn-primary">
						确定</button>
					<button type="button" id="quxiao" class="btn btn-default"
						data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 模态框（Modal）end -->
</body>

</html>