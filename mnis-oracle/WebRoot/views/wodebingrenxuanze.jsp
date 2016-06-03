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
<link href="css/base.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/caidan.css" />
<script type="text/javascript" src="scripts/jquery-1.12.1.min.js"></script>
<script type="text/javascript" src="scripts/viewjs.js"></script>
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
		
		$('.qdclass1').click(function(){
			if($(this).is(':checked')){
				$(this).next().val("1");
				var va1 = $(this).next().val(); 
				}else{
					$(this).next().val("0");
				}
		});
	});
</script>
</head>

<body class="bg-info">
	<div id="head_banner_1" style="z-index:1000;" class="bg-info">
		<div class="row"
			style="border-bottom:1px solid #269abc;padding: 10px 15px 5px 15px;">
			<div class="col-xs-2"  style="padding-right: 2%;">
				<a href="javascript:void(0);"> <img src="images/icon-m-man-active.png"
					class="img-responsive" alt="<s:property value='#session.caozuoyuan.ryxm' />">
				</a>
			</div>
			<div class="col-xs-4" style="padding-left: 2%;padding-right: 2%;color: #807D7D;">
				<span><strong><s:property
							value="#session.caozuoyuan.ryxm" /></strong></span>
				<p class="text-left" style="margin-bottom: 5px;" id="bingqu_name"><s:property
							value="#session.dangqianbingqu_name" /></p>
				<input id="dangq_bingq_id" value="<s:property value='#session.dangqianbingqu_id' />" style="display:none;"/>
			</div>
			<div class="col-xs-2" style="padding-left: 2%;padding-right:2%;">
				<a href="javascript:void(0);"> <img src="images/brxxxx_header_1.png"
					class="img-responsive" alt="消息数">
				</a>
			</div>
			<div class="col-xs-2" style="padding-left: 2%;padding-right:2%;">
				<a href="bingqbr_bysessionbingqid"> <img src="images/brxxxx_header_2.png"
					class="img-responsive" alt="刷新">
				</a>
			</div>
			<div class="col-xs-2" style="padding-left: 2%;padding-right:2%;">
				<a href="javascript:void(0);"> <img src="images/brxxxx_header_4.png"
					class="img-responsive" alt="业务模块">
				</a>
			</div>
			<!-- <div class="col-xs-2" style="padding: 0 2%;margin:1% 0 0 0;">
				<input class="btn btn-default" type="button" value="看细卡" id="leix_check" style="padding: 5%">
			</div> -->
		</div>
		<div class="row"
			style="border-bottom:1px solid #269abc;padding: 5px 0 ;">
			<div class="col-xs-6" style="padding: 0 0 0 5%;">
				<div class="dropdown" style="width: 100%">
					<button class="btn btn-default btn-sm dropdown-toggle"
						type="button" id="dropdownMenu1" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="true">
						<s:if test="#session.dangqianbingqu_name!=null"><s:property value="#session.dangqianbingqu_name" /></s:if>
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
			<div class="col-xs-6" style="padding: 0 5%  0 0;">
				<div class="input-group input-group-xs">
					<input type="text" class="form-control" id="saowandai"
						placeholder="扫腕带" onfocus="javascript:this.value='';"
						oninput="myFunction()" /> <span class="input-group-btn">
						<button class="btn btn-default" type="button" id="chacw">查</button>
					</span>
				</div>
			</div>
		</div>
	</div>



	<div class="container" style=" position: relative;">
	   <form action="woDeBingRenXuanZeQueDing" method="post">
		<div class="row">
			<s:iterator value="#request.daixzbingrens">
			<a href="javascript:void(0);">
				<div class="col-xs-4" style="padding: 0 5px 0 5px;">
					<div class="panel panel-default"
						style="margin: 5px 0 5px 0; border: 1px solid #ccc; color: #000; text-align: center;">
						<div class="row" style="margin: 0;">
							<div class="col-xs-3" style="padding: 0; ">
								<%-- ${xb } --%>
								<s:if test='xb=="女"'>
									<img style="width: 80%; height: 80%;" class="img-responsive"
									src="images/nv.png" />
								</s:if>
								<s:elseif test='xb=="男"'>
									<img style="width: 80%; height: 80%;" class="img-responsive"
									src="images/nan.png" />
								</s:elseif>
							</div>
							<div class="col-xs-6" style="padding: 0;">
								<h4 style="font-weight: bold; font-size: 20px; margin-left: -5px;">${chw}床</h4>
								<input name="chw" value="${chw}" style="display:none;"/>
							</div>
							<div class="col-xs-3" style="padding: 0;">                       
<!-- 								 <input type="checkbox" id="quedflag_xianshi" onclick='javascript:if(this.checked){document.getElementById("quedflag").value="1";}else{document.getElementById("quedflag").value="0";}' -->
								 <input type="checkbox" class="qdclass1"
									style="display: block; margin-left: 3px; margin-top: 2px; width: 2rem; height: 2rem;" <s:if test="quedflag==1">checked="checked"</s:if>></input>
								<input name="quedflag" value="${quedflag}" style="display:none;" class="qdclass"/>
							</div>
						</div>
						<p style="color: #333; margin-bottom: 5px;">${xm }</p>
						<p style="color: #333; margin-bottom: 5px;">${nl }</p>
						
					</div>
				</div>
			</a> 
			</s:iterator>
		</div>
		<div class="row" style="border-bottom:1px solid #269abc;">
			<!-- <button type="button" onclick="location.href='bingrenliebiao.html'"
				class="btn btn-primary pull-right"
				style="margin-right: 5px; margin-bottom: 10px;">确定</button> -->
				<input type="submit" value="确定" class="btn btn-primary pull-right"
				style="margin-right: 5px; margin-bottom: 10px;">
		</div>
		</form>
		<div class="sideWrap" id="sideWrap">
			<div class="sideMenu" id="sideMenu">
				<div class="navItem_1">
					<a href=""> <span class="glyphicon glyphicon-bell"></span> <span
						class="gnavItemName">护士工作提醒</span>
					</a>
				</div>
				<div class="navItem_2">
					<a href="linzhuweizhixing.html"> <span
						class="glyphicon glyphicon-exclamation-sign"></span> <span
						class="gnavItemName">临嘱未执行</span>
					</a>
				</div>
				<div class="navItem_3">
					<a href="shuyezhixing.html"> <span
						class="glyphicon glyphicon-check"></span> <span
						class="gnavItemName">输液执行</span>
					</a>
				</div>
				<div class="navItem_4">
					<a href="woDeBingRenXuanZe"> <span
						class="glyphicon glyphicon-list"></span> <span
						class="gnavItemName">我的病人选择</span>
					</a>
				</div>
				<div class="navItem_5">
					<a href=""> <span class="glyphicon glyphicon-comment"></span> <span
						class="gnavItemName">消息模块</span>
					</a>
				</div>
			</div>

		</div>
		<div class="sideBtn" id="sideBtn">
			<a href="javascript:void(0)"> <span
				class="glyphicon glyphicon-align-justify sideBtnIcon"
				style="font-size: 2.4rem;"></span>
			</a>
		</div>
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

	<script type="text/javascript" src="scripts/bootstrap.min.js"></script>
</body>

</html>