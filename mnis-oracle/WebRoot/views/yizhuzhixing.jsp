
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>医嘱执行</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="沈旭峰" />
<meta name="keywords" content="移动护理信息系统" />
<meta name="description" content="医嘱本,高大上的移动护理系统。" />
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<link href="css/base.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/song.css"/>
<script type="text/javascript" src="scripts/jquery-1.12.1.min.js"></script>
<script type="text/javascript" src="scripts/viewjs.js"></script>
<script src="scripts/song.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	$(function() {
		// 绑定
		$("#head_banner_1").smartFloat();
		
		var height = $('#head_banner_1').height();  
		$('#modal-wrap').css({   //模态框距离头部距离
			'position':'fixed',
			'top':'10%'		
		});
		
	    $('#moduleModal').on('shown.bs.modal', function () {
	        $('.modal-backdrop').css('top', height + 'px')
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
				$("#infocontent").html(html);
			});
		        
			$('#ensure').click(function(){ //点击模态框确定按钮后主页时间按钮禁用
				
				var yz_zxms = $("#textcontent").val();
				var url = "bingrGeTi_YiZhuZhiXing_baocun";
				alert(yz_zxms);
				alert("sjd:"+zx_sjd);
				alert("groupxh:"+yz_groupxh);
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
	<%@ include file="header-bingren.jsp"%>
  	</div>
	<div id="content" class="container">
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
		
			<div class="row module" id="yzmc_0">
				
					<div class="col-xs-8">
						<span>内科护理常规</span>
					</div>
					
				
			</div>
			<div class="row">
				<div class="col-xs-12 text-right"
					style="margin: 10px 0 10px 0;padding-bottom: 5px;border-top: #666666 1px dashed;">
					
				</div>
			</div>
			<div class="row"
				style="border-bottom: #666666 1px dashed;padding-bottom: 5px;margin-bottom: 5px;">
				<div class="col-xs-12">
					<span>持续性</span>
				</div>
			</div>
			<div class="row"
				style="border-bottom: 2px solid #333333;padding-bottom: 10px;margin-bottom: 10px;">
				<div class="col-xs-12">
					
						<div class="btn-group" data-toggle="buttons">
							
							
								
								<input value="3958389" style="display:none;"/>
								<button type="button" class="btn btn-primary moduleTime" data-toggle="modal" data-target="#moduleModal">00:00</button>
								<input value="yzmc_0" style="display:none;"/>
							
						</div>
					
				</div>
			</div>
		
			<div class="row module" id="yzmc_1">
				
					<div class="col-xs-8">
						<span>低盐低脂饮食</span>
					</div>
					
				
			</div>
			<div class="row">
				<div class="col-xs-12 text-right"
					style="margin: 10px 0 10px 0;padding-bottom: 5px;border-top: #666666 1px dashed;">
					
				</div>
			</div>
			<div class="row"
				style="border-bottom: #666666 1px dashed;padding-bottom: 5px;margin-bottom: 5px;">
				<div class="col-xs-12">
					<span>持续性</span>
				</div>
			</div>
			<div class="row"
				style="border-bottom: 2px solid #333333;padding-bottom: 10px;margin-bottom: 10px;">
				<div class="col-xs-12">
					
						<div class="btn-group" data-toggle="buttons">
							
							
								
								<input value="3958391" style="display:none;"/>
								<button type="button" class="btn btn-primary moduleTime" data-toggle="modal" data-target="#moduleModal">00:00</button>
								<input value="yzmc_1" style="display:none;"/>
							
						</div>
					
				</div>
			</div>
		
			<div class="row module" id="yzmc_2">
				
					<div class="col-xs-8">
						<span>测血压</span>
					</div>
					
				
			</div>
			<div class="row">
				<div class="col-xs-12 text-right"
					style="margin: 10px 0 10px 0;padding-bottom: 5px;border-top: #666666 1px dashed;">
					
				</div>
			</div>
			<div class="row"
				style="border-bottom: #666666 1px dashed;padding-bottom: 5px;margin-bottom: 5px;">
				<div class="col-xs-12">
					<span>每天二次</span>
				</div>
			</div>
			<div class="row"
				style="border-bottom: 2px solid #333333;padding-bottom: 10px;margin-bottom: 10px;">
				<div class="col-xs-12">
					
						<div class="btn-group" data-toggle="buttons">
							
							
								
								<input value="3958392" style="display:none;"/>
								<button type="button" class="btn btn-primary moduleTime" data-toggle="modal" data-target="#moduleModal">08:00</button>
								<input value="yzmc_2" style="display:none;"/>
							
						</div>
					
						<div class="btn-group" data-toggle="buttons">
							
							
								
								<input value="3958392" style="display:none;"/>
								<button type="button" class="btn btn-primary moduleTime" data-toggle="modal" data-target="#moduleModal">16:00</button>
								<input value="yzmc_2" style="display:none;"/>
							
						</div>
					
				</div>
			</div>
		
			<div class="row module" id="yzmc_3">
				
					<div class="col-xs-8">
						<span>陪住一人</span>
					</div>
					
				
			</div>
			<div class="row">
				<div class="col-xs-12 text-right"
					style="margin: 10px 0 10px 0;padding-bottom: 5px;border-top: #666666 1px dashed;">
					
				</div>
			</div>
			<div class="row"
				style="border-bottom: #666666 1px dashed;padding-bottom: 5px;margin-bottom: 5px;">
				<div class="col-xs-12">
					<span>每天早晨一次</span>
				</div>
			</div>
			<div class="row"
				style="border-bottom: 2px solid #333333;padding-bottom: 10px;margin-bottom: 10px;">
				<div class="col-xs-12">
					
						<div class="btn-group" data-toggle="buttons">
							
							
								
								<input value="3958393" style="display:none;"/>
								<button type="button" class="btn btn-primary moduleTime" data-toggle="modal" data-target="#moduleModal">10:00</button>
								<input value="yzmc_3" style="display:none;"/>
							
						</div>
					
				</div>
			</div>
		
			<div class="row module" id="yzmc_4">
				
					<div class="col-xs-8">
						<span>住高等单人间（A级丙类）</span>
					</div>
					
				
			</div>
			<div class="row">
				<div class="col-xs-12 text-right"
					style="margin: 10px 0 10px 0;padding-bottom: 5px;border-top: #666666 1px dashed;">
					
				</div>
			</div>
			<div class="row"
				style="border-bottom: #666666 1px dashed;padding-bottom: 5px;margin-bottom: 5px;">
				<div class="col-xs-12">
					<span>每天一次</span>
				</div>
			</div>
			<div class="row"
				style="border-bottom: 2px solid #333333;padding-bottom: 10px;margin-bottom: 10px;">
				<div class="col-xs-12">
					
						<div class="btn-group" data-toggle="buttons">
							
							
								
								<input value="3958427" style="display:none;"/>
								<button type="button" class="btn btn-primary moduleTime" data-toggle="modal" data-target="#moduleModal">10:00</button>
								<input value="yzmc_4" style="display:none;"/>
							
						</div>
					
				</div>
			</div>
		
			<div class="row module" id="yzmc_5">
				
					<div class="col-xs-8">
						<span>持续低流量吸氧</span>
					</div>
					
				
			</div>
			<div class="row">
				<div class="col-xs-12 text-right"
					style="margin: 10px 0 10px 0;padding-bottom: 5px;border-top: #666666 1px dashed;">
					
				</div>
			</div>
			<div class="row"
				style="border-bottom: #666666 1px dashed;padding-bottom: 5px;margin-bottom: 5px;">
				<div class="col-xs-12">
					<span>每天一次</span>
				</div>
			</div>
			<div class="row"
				style="border-bottom: 2px solid #333333;padding-bottom: 10px;margin-bottom: 10px;">
				<div class="col-xs-12">
					
						<div class="btn-group" data-toggle="buttons">
							
							
								
								<input value="3960595" style="display:none;"/>
								<button type="button" class="btn btn-primary moduleTime" data-toggle="modal" data-target="#moduleModal">08:00</button>
								<input value="yzmc_5" style="display:none;"/>
							
						</div>
					
				</div>
			</div>
		
			<div class="row module" id="yzmc_6">
				
					<div class="col-xs-8">
						<span>低嘌呤饮食</span>
					</div>
					
				
			</div>
			<div class="row">
				<div class="col-xs-12 text-right"
					style="margin: 10px 0 10px 0;padding-bottom: 5px;border-top: #666666 1px dashed;">
					
				</div>
			</div>
			<div class="row"
				style="border-bottom: #666666 1px dashed;padding-bottom: 5px;margin-bottom: 5px;">
				<div class="col-xs-12">
					<span>持续性</span>
				</div>
			</div>
			<div class="row"
				style="border-bottom: 2px solid #333333;padding-bottom: 10px;margin-bottom: 10px;">
				<div class="col-xs-12">
					
						<div class="btn-group" data-toggle="buttons">
							
							
								
								<input value="3963552" style="display:none;"/>
								<button type="button" class="btn btn-primary moduleTime" data-toggle="modal" data-target="#moduleModal">00:00</button>
								<input value="yzmc_6" style="display:none;"/>
							
						</div>
					
				</div>
			</div>
		
			<div class="row module" id="yzmc_7">
				
					<div class="col-xs-8">
						<span>氯化钠注射液(北京双鹤药业) 250ml（袋） 250ml</span>
					</div>
					
				
					<div class="col-xs-8">
						<span>注射用血塞通（冻干）(黑龙江珍宝岛制药) 200mg/支. 400mg</span>
					</div>
					
				
			</div>
			<div class="row">
				<div class="col-xs-12 text-right"
					style="margin: 10px 0 10px 0;padding-bottom: 5px;border-top: #666666 1px dashed;">
					
				</div>
			</div>
			<div class="row"
				style="border-bottom: #666666 1px dashed;padding-bottom: 5px;margin-bottom: 5px;">
				<div class="col-xs-12">
					<span>每天一次</span>
				</div>
			</div>
			<div class="row"
				style="border-bottom: 2px solid #333333;padding-bottom: 10px;margin-bottom: 10px;">
				<div class="col-xs-12">
					
						<div class="btn-group" data-toggle="buttons">
							
							
								
								<input value="3963558" style="display:none;"/>
								<button type="button" class="btn btn-primary moduleTime" data-toggle="modal" data-target="#moduleModal">08:00</button>
								<input value="yzmc_7" style="display:none;"/>
							
						</div>
					
				</div>
			</div>
		
			<div class="row module" id="yzmc_8">
				
					<div class="col-xs-8">
						<span>氯化钠注射液(石家庄四药) 100ml 100ml</span>
					</div>
					
				
					<div class="col-xs-8">
						<span>吡拉西坦氯化钠注射液(江苏晨牌药业) 20g/100ml 100ml</span>
					</div>
					
				
			</div>
			<div class="row">
				<div class="col-xs-12 text-right"
					style="margin: 10px 0 10px 0;padding-bottom: 5px;border-top: #666666 1px dashed;">
					
				</div>
			</div>
			<div class="row"
				style="border-bottom: #666666 1px dashed;padding-bottom: 5px;margin-bottom: 5px;">
				<div class="col-xs-12">
					<span>每天一次</span>
				</div>
			</div>
			<div class="row"
				style="border-bottom: 2px solid #333333;padding-bottom: 10px;margin-bottom: 10px;">
				<div class="col-xs-12">
					
						<div class="btn-group" data-toggle="buttons">
							
							
								
								<input value="3963598" style="display:none;"/>
								<button type="button" class="btn btn-primary moduleTime" data-toggle="modal" data-target="#moduleModal">08:00</button>
								<input value="yzmc_8" style="display:none;"/>
							
						</div>
					
				</div>
			</div>
		
			<div class="row module" id="yzmc_9">
				
					<div class="col-xs-8">
						<span>葡萄糖氯化钠注射液(北京双鹤药业) 500ml（袋） 500ml</span>
					</div>
					
				
					<div class="col-xs-8">
						<span>注射用维生素C(山西普德) 2.0g/支 2g</span>
					</div>
					
				
					<div class="col-xs-8">
						<span>维生素B6注射液 100mg</span>
					</div>
					
				
			</div>
			<div class="row">
				<div class="col-xs-12 text-right"
					style="margin: 10px 0 10px 0;padding-bottom: 5px;border-top: #666666 1px dashed;">
					
				</div>
			</div>
			<div class="row"
				style="border-bottom: #666666 1px dashed;padding-bottom: 5px;margin-bottom: 5px;">
				<div class="col-xs-12">
					<span>每天一次</span>
				</div>
			</div>
			<div class="row"
				style="border-bottom: 2px solid #333333;padding-bottom: 10px;margin-bottom: 10px;">
				<div class="col-xs-12">
					
						<div class="btn-group" data-toggle="buttons">
							
							
								
								<input value="3963605" style="display:none;"/>
								<button type="button" class="btn btn-primary moduleTime" data-toggle="modal" data-target="#moduleModal">08:00</button>
								<input value="yzmc_9" style="display:none;"/>
							
						</div>
					
				</div>
			</div>
		
			<div class="row module" id="yzmc_10">
				
					<div class="col-xs-8">
						<span>中药汤剂</span>
					</div>
					
				
			</div>
			<div class="row">
				<div class="col-xs-12 text-right"
					style="margin: 10px 0 10px 0;padding-bottom: 5px;border-top: #666666 1px dashed;">
					
				</div>
			</div>
			<div class="row"
				style="border-bottom: #666666 1px dashed;padding-bottom: 5px;margin-bottom: 5px;">
				<div class="col-xs-12">
					<span>每天二次</span>
				</div>
			</div>
			<div class="row"
				style="border-bottom: 2px solid #333333;padding-bottom: 10px;margin-bottom: 10px;">
				<div class="col-xs-12">
					
				</div>
			</div>
		
		<div class="clear"></div>
			<!--#include file="menu-hushi.html"-->
	</div>
	<!-- 20160510 by 小宋 模态框（Modal）start -->
		<div class="modal fade" id="moduleModal" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" id="modal-wrap" style="width: 94%;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">模态框</h4>
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
	
<!--页脚开始-->
	<!--#include file="footer.html"-->
<!--页脚结束-->

	<script type="text/javascript" src="scripts/bootstrap.min.js"></script>
</body>
</html>