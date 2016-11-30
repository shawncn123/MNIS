<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>配液扫描记录</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="SHORTCUT ICON" href="images/favicon.ico">
<link rel="icon" href="images/favicon.ico" type="image/x-icon">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="融汇国康" />
<meta name="keywords" content="移动护理信息系统" />
<meta name="description" content="配液扫描记录,高大上的移动护理系统。" />
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<link href="css/base.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/song.css" />
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
		
		 var vkey = "";
		 var height = $('#head_banner_1').height();     //模态框距离头部距离
		 
		// 扫描筛选病人信息
		$('#chacw').click(function() { //点击‘查’按钮
			
			var val = $('#saowandai').val(); //获取扫腕带的值
			var lxflag = val.substr(0,1);
			
			if(lxflag=="P" || lxflag=="p"){
				
				//example: p20160913-30383236-20:00_37458438-1-0
				//取时间点的id
				var vsjd_id = val.substr(1,val.indexOf("_")-1);  //20160913-30383236-20:00
				vsjd_id = vsjd_id.replace(":","q");				 //20160913-30383236-20q00
				var yo = document.getElementById(vsjd_id);
				//判断是否是该医嘱
				if(yo){
					var vqd = vsjd_id + '_quedflag';
					var vcheck = vsjd_id + '_check';
					var vqd_value = $("#"+vqd).val();
					if(vqd_value=='0' || vqd_value=='' || vqd_value==null){
						var url = "peiye_queren";
						var cszhi = "1";
						var args = {"peiye_qdflag" : cszhi,"rowkey":vsjd_id};
						$.post(url,args,function(data){
							if(data == "0"){
								$("#"+vqd).val("1");
								$("#"+vcheck).attr('checked','checked');
								$('#prompt1').hide();
								$('#prompt2').hide();
								$('#prompt3').hide();
								$('#prompt4').hide();
							}else{
							//若data 的返回值是1，则提示失败
								$('#prompt1').hide();
								$('#prompt2').hide();
								$('#prompt3').hide();
								$('#prompt4').show();							
							}
						});	
					}
					else{
						$('#prompt1').hide();
						$('#prompt2').hide();
						$('#prompt3').show();
						$('#prompt4').hide();
					}
					$("." + vsjd_id).css("border-color","#EF9C04");
					var yomove_offset = $("." + vsjd_id).offset().top - height - height;
					$("html,body").animate({scrollTop:yomove_offset},120);
					$("#saowandai").val("");
					document.getElementById("saowandai").focus();
				}else{
					$('#prompt1').show();
					$('#prompt2').hide();
					$('#prompt3').hide();
					$('#prompt4').hide();
					$("#saowandai").val("");
					document.getElementById("saowandai").focus();
				}
			}else{
				$('#prompt2').show();
				$('#prompt1').hide();
				$('#prompt3').hide();
				$('#prompt4').hide();
				$("#saowandai").val("");
				document.getElementById("saowandai").focus();
			}
		});
		// 扫描筛选输液信息
		$('#chapq').click(function() {
			var val = $('#saopingqian').val();
			
			var pqName = $('.pqName');
			for (var i = 0; i < pqName.length; i++) {
				var $this = $(pqName[i]);
				var pq_tex = $this.text();
				if (val != pq_tex) {
					$this.parents('.row').hide();
				}
			}
		});
		
		//20160909 by shen 写的模态框
		
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
		var vrq = "";
		var vcrlflag = "";
		
	 	$('#accordion').on('click','.moduleTime', function(){
	 		$clickBtn = $(this);
			yz_groupxh = $(this).prev().val();
			var yzmc_gid = $(this).next().val();
			vrq = $(this).next().next().val();
			vcrlflag = $(this).next().next().next().val();
			vcrl = $(this).next().next().next().next().val();
			var html = $("#" + yzmc_gid).html();
			zx_sjd = $(this).html();
			if(vcrlflag=="0"){
				$("#mcrlmess").hide();
				$("#mcrlbody").hide();
			}
			if(vcrlflag=="1"){
				$("#mcrlvalue").val(vcrl);
				$("#mcrlmess").show();
				$("#mcrlbody").show();
			}
			$("#infocontent").html(html);	
			var sss = '<button type="button" class="btn pull-left btn-primary" id="ensure">确定</button><button type="button" id="quxiao" class="btn btn-default" data-dismiss="modal">退出</button>';
			$("#modfooter").html(sss);
     	});
	 	
	 	/* $('#ensure').click(function(){ */ //点击模态框确定按钮后主页时间按钮禁用
	 	$('#modfooter').on('click','#ensure', function(){
			var yz_zxms = $("#textcontent").val();
			var url = "bingrGeTi_YiZhuZhiXing_baocun";
			var xzcrlflag = "0";
			var xzxflag = "1";
			var vcrl = 0;
			
			if(vcrlflag=="1"){
				xzcrlflag = $('input[name="quedflag"]:checked').attr("value");
				if(xzcrlflag=="1"){
					/* vcrl = $("#mcrlvalue").attr("value"); */
					vcrl = $("#mcrlvalue").val();
				}else{
					xzcrlflag = "0";
					vcrl = 0;
				}
			}
			var args = {"vsjd" : zx_sjd,"groupxh":yz_groupxh,"zxms":yz_zxms,"vrq":vrq,"vcrlflag":xzcrlflag,"vcrl":vcrl,"vzxflag":xzxflag};
			$.post(url,args,function(data){
				if(data == "0"){
					$('#textcontent').val('');     //隐藏模态框时textarea值清空
					$('#moduleModal').modal('hide'); //隐藏模态窗口
					/* $clickBtn.attr('disabled','disabled'); */
					$clickBtn.attr("class","btn btn-primary zxTime");
					$clickBtn.css('background-color','#5cb85c'); 
					$clickBtn.css('border-color','#4cae4c'); 
					/* var sss = '<button type="button" class="btn pull-left btn-primary" id="ensure">确定</button><button type="button" id="quxiao" class="btn btn-default" data-dismiss="modal">退出</button>';
					$("#modfooter").html(sss); */	 
				}else{
				//若data 的返回值不是1，则提示删除失败
					alert("数据保存失败！");							
				}
			});	
		});
	 	
		// $('#ensure_cancel').click(function(){ 
			//点击模态框确定按钮后主页时间按钮禁用
			$('#modfooter').on('click','#ensure_cancel', function(){
			var yz_zxms = $("#textcontent").val();
			var url = "bingrGeTi_YiZhuZhiXing_baocun";
			var xzcrlflag = "0";
			var xzxflag = "0";
			var vcrl = 0;
			var args = {"vsjd" : zx_sjd,"groupxh":yz_groupxh,"zxms":yz_zxms,"vrq":vrq,"vcrlflag":xzcrlflag,"vcrl":vcrl,"vzxflag":xzxflag};
			$.post(url,args,function(data){
				if(data == "0"){
					$('#textcontent').val('');     //隐藏模态框时textarea值清空
					$('#moduleModal').modal('hide'); //隐藏模态窗口
					/* $clickBtn.attr('disabled','disabled'); */
					$clickBtn.attr("class","btn btn-primary moduleTime"); 
					$clickBtn.css('background-color','#428bca'); 
					$clickBtn.css('border-color','#357ebd'); 
					/* var sss = '<button type="button" class="btn pull-left btn-primary" id="ensure">确定</button><button type="button" id="quxiao" class="btn btn-default" data-dismiss="modal">退出</button>';
					$("#modfooter").html(sss); */
				}else{
				//若data 的返回值不是1，则提示删除失败
					alert("数据保存失败！");							
				}
			});	
		});
	 	
	});
	
	
	function myFunction() {
		document.getElementById("chacw").click();
	}
		
	function changeDate() {
/* 	使用$(this).val() 回丢失前面的数字0	alert( $(this).val()); */
		var url = "peiye_saomiao_jquery";
		var vxzrq = $("#yiZhuRq").val();
		var args = {"vxzrq":vxzrq}; 
		$.post(url,args,function(data) {
			var a = '';
			var chuangwei="";
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
					
					a = a + '<div class="row ' + d[i].rowkey 
					+ '" style="margin: 2% 0 0 0;padding: 2% 4%;border: 2px solid #C1D7F9;border-radius: 5px;" id="' 
					+ d[i].rowkey + '"><div class="row module">';
					for(var j = 0;j<d[i].yzmcs.length;j++){
						a = a + '<div class="col-xs-12"><span>' + d[i].yzmcs[j] + '</span></div>';
					}
					a = a + '</div><div class="row"><div class="col-xs-12 text-right" '
					+ 'style="margin: 10px 0 10px 0;padding-bottom: 5px;border-top: #666666 1px dashed;"></div></div>'
					+ '<div class="row" style="border-bottom: #666666 1px dashed;padding-bottom: 5px;margin-bottom: 5px;">'
					+ '<div class="col-xs-8" style="padding: 0 0 0 1%;"><span>'
					+ vyzrq2 + ' ' + d[i].sjd
					+ '</span></div><div class="col-xs-4" style="padding-right:0;">';
					if(d[i].bzflag==1){
						a = a + '<input type="checkbox" class="qdclass1" style="width: 100%; height: 2rem;" checked=checked id="'
						+ d[i].rowkey + '_check"></input>';
					}
					else{
						a = a + '<input type="checkbox" class="qdclass1" style="width: 100%; height: 2rem;" id="'
						+ d[i].rowkey + '_check"></input>';
					}
					a = a + '<input name="quedflag" value="' + d[i].bzflag 
						+ '" style="display:none;" class="qdclass" id="'
						+ d[i].rowkey + '_quedflag"/></div>'
						+ '<input value="' + d[i].rowkey + '" style="display:none;" name="rowkey"/></div></div>';
				}
			}else{
				a = "无配液数据！";
			} 
			 $("#content")[0].innerHTML = a; 
			 $("#saowandai").val("");
			 document.getElementById("saowandai").focus();
		})
	}
	window.onload = function() {
		document.getElementById("saowandai").focus();
	}
	
	$(function() {
		
		$('#content').on("click",".qdclass1",function(){
			if($(this).is(':checked')){
				$(this).next().val("1");
				/* var va1 = $(this).next().val(); */ 
				}else{
					$(this).next().val("0");
				}
		});
		
	});
</script>
</head>

<body>
	<%@ include file="header-hushi.jsp"%>
		<div class="row" style="border-bottom:1px solid #269abc;padding: 5px 0 ; margin: 0;">
			<div class="col-xs-4" style="padding: 0 2px;">
				<div class="demos">
					<input value="" class="form-control" name="chajiantime" id="yiZhuRq" type="text" placeholder="" onchange="changeDate()" readonly="readonly">
				</div>
			</div>
			<%-- <div class="col-xs-4" style="padding: 0 2px;">
				合计：<span id="hejishu"></span>
			</div> --%>
			<%-- <div class="col-xs-4" id="prompt1" style="display:none;">
		   		<span class="label label-warning">无此医嘱</span>
		   	</div>
			<div class="col-xs-4" id="prompt2" style="display:none;">
		   		<span class="label label-default">无关瓶签</span>
		   	</div>
			<div class="col-xs-4" id="prompt3" style="display:none;">
		   		<span class="label label-info">瓶签已扫过</span>
		   	</div>
			<div class="col-xs-4" id="prompt4" style="display:none;">
		   		<span class="label label-danger">记录失败</span>
		   	</div> --%>
			<div class="col-xs-4">
		   		<span class="label label-warning" id="prompt1" style="display:none;">无此医嘱</span>
		   		<span class="label label-default" id="prompt2" style="display:none;">无关瓶签</span>
		   		<span class="label label-info" id="prompt3" style="display:none;">瓶签已扫过</span>
		   		<span class="label label-danger" id="prompt4" style="display:none;">记录失败</span>
		   	</div>
			
			<div class="col-xs-4" style="padding: 0 2px;">
				<div class="input-group input-group-xs">
					<input type="text" class="form-control" id="saowandai"
						placeholder="扫描" onfocus="javascript:this.value='';" oninput="myFunction()" /> 
					<span class="input-group-btn" style="display:none;">
						<button class="btn btn-default" type="button" id="chacw">查</button>
					</span>
				</div>
			</div>
		</div>
	</div>
	
	<div id="content" class="container" style="padding: 0;">
		<s:iterator value="#request.shuye_yizhu_data" status="status">
			<div class="row ${rowkey}" style="margin: 2% 0 0 0;padding: 2% 4%;border: 2px solid #C1D7F9;border-radius: 5px;" id="${rowkey}">
				<div class="row module">
					<s:iterator value="yzmcs" id="mc_yz">
						<div class="col-xs-12">
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
					<%-- <div class="col-xs-7">
						<span>${yf2mc }</span>
					</div> --%>
					<div class="col-xs-8" style="padding: 0 0 0 1%;">
						<span><s:date name="rq" format="yyyy-MM-dd"/> ${sjd}</span>
					</div>
					<div class="col-xs-4" style="padding-right:0;">
						<s:if test="bzflag==1">
							 <input type="checkbox" class="qdclass1" 
										style="width: 100%; height: 2rem;" checked=checked id="${rowkey}_check"></input>
						</s:if>
						<s:else>
						 	<input type="checkbox" class="qdclass1"
										style="width: 100%; height: 2rem;" id="${rowkey}_check"></input>
						</s:else>
						 <input name="quedflag" value="${bzflag}" style="display:none;" class="qdclass" id="${rowkey}_quedflag"/>
					</div>
					<input value="${rowkey }" style="display:none;" name="rowkey"/>
				</div>
			</div>
		</s:iterator>
				
		<!--导航结束-->
		<div class="clear"></div>
		<%@ include file="menu-hushi.jsp"%>
	</div>
	<!--页脚开始-->
	<%@ include file="footer.jsp"%>
	<!--页脚结束-->
	
	<!-- 20160909 by shen 模态框（Modal）start -->
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
						
						<div class="row" style="padding:5%;" id="mcrlmess">
							<form>
							<div class="col-xs-2" style="padding: 0;">                       
								<input type="radio" class="qdclass1" name="quedflag" value="1"
									style="display: block; margin-left: 3px; margin-top: 2px; width: 2rem; height: 2rem;" checked="checked"></input>
								<!-- <input name="quedflag" value="1" style="display:none;" class="qdclass"/> -->
							</div>
							<div class="col-xs-4" style="padding: 0;">                       
								<span>记入出量</span>
							</div>
							<div class="col-xs-2" style="padding: 0;">                       
								<input type="radio" class="qdclass1" name="quedflag" value="0" 
									style="display: block; margin-left: 3px; margin-top: 2px; width: 2rem; height: 2rem;" ></input>
								<!-- <input name="quedflag" value="0" style="display:none;" class="qdclass"/> -->
							</div>
							<div class="col-xs-4" style="padding: 0;">                       
								<span>不记入出量</span>
							</div>
							</form>
						</div>
						<div class="row" style="padding:5%;" id="mcrlbody">
							<div class="col-xs-3" style="padding: 0;">                       
								<span>值：</span>
							</div>
							<div class="col-xs-9" style="padding: 0;" >                       
								<input type="text" value="" style="border: 1px solid #ccc;" id="mcrlvalue"></input>
							</div>
						</div>
					</div>
					<div class="modal-footer" id="modfooter">
						<button type="button" class="btn pull-left btn-primary" id="ensure">
							确定
						</button>
						<button type="button" id="quxiao" class="btn btn-default" data-dismiss="modal">
							退出
						</button>
					</div>
				</div>
			</div>
		</div>
		<!-- 模态框（Modal）end -->
		<script src="scripts/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>