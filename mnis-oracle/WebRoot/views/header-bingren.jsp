<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript">	
	$(function(){
		var url = "weiduxiaoxishu";
		$.post(url,function(data) {
			if(data!="" && data!="error"){
				$("#xxshu").text(data+"");
			}else{
				self.location = "views/login.jsp";
			};		
		});
	});
</script>
<div id="head_banner_1" style="z-index:1000;" class="bg-info">
	<div class="row" style="border-bottom:1px solid #269abc; margin: 0;">
		<s:if test="#session.bingrgetixingxi_yinger!=null">
		<div class="col-xs-3 " style="margin-left: -2%; color: #807D7D; padding-left:13px; padding-right: 0;">
			<strong style="color: #272626; ">${bingrgetixingxi.xm }</strong>
			<p class="text-left " style="margin-bottom: 0; ">${bingrgetixingxi.chw }床&nbsp;${bingrgetixingxi.nl }</p>
		</div>
		<div class="col-xs-3" style="margin: 0 1%; padding: 0 0; font-size: 14px; color: #428CF7; line-height: 40px; ">
			${bingrgetixingxi_yinger.yexm }
		</div>
		<div class="col-xs-6 " style=" padding: 0 1% 0 0;">
			<div class="table table-responsive " style="margin-bottom: 0;border: none; ">
				<table class="table table-condensed " style="background-color: #d9edf7 ">
					<tbody>
						<tr>
							<td style="border: none; width: 25%; height: 40%; padding: 2px;  position: relative;">
								<a href="mymessage?pageno=1" style="display: block;">
								<%-- 	<img style="width: 100%; height: 100%;"  src="images/brxxxx_header_1.png"/>
									<span style="display: block; text-align: center; color: #fff; font-size: 2rem; z-index: 2; position: absolute; top: 10PX; left: 0; width:100%; height:100%;" id="xxshu"></span> --%>
									<span style="display: block;text-align: center;color: #fff;font-size: 2rem;position: absolute;left: 0;width: 90%;height: 90%;border-radius: 60%;background-color: green;padding-top: 10%;" id="xxshu"></span>
								</a>
							</td>
							<td style="border: none; padding: 2px;">
								<a href="${action_name} " class="text-center "> <img src="images/brxxxx_header_2.png " class="img-responsive " alt="刷新 " /> </a>
							</td>
							<td style="border: none; padding: 2px;">
								<a href="bingqbr_bysessionbingqid" class="text-center "> <img src="images/brxxxx_header_3.png " class="img-responsive " alt="病人列表 " /> </a>
							</td>
							<td style="border: none; padding: 2px;">
								<a href="bingreng_yewumokuai?v_key1=${bingrgetixingxi.key1 }&v_key2=${bingrgetixingxi.key2}"
								class="text-center"> <img src="images/brxxxx_header_4.png" class="img-responsive" alt="业务模块">
								</a>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		</s:if>
		<s:else>
		<div class="col-xs-6 " style="margin-left: -2%; margin-right: 2%; color: #807D7D; padding-left:13px; padding-right: 0;">
			<strong style="color: #272626; ">${bingrgetixingxi.xm }</strong>
				<p class="text-left " style="margin-bottom: 0; ">${bingrgetixingxi.chw }床&nbsp;${bingrgetixingxi.nl }</p>
			</div>
				<div class="col-xs-6 " style=" padding: 0 1% 0 0;">
					<div class="table table-responsive " style="margin-bottom: 0;border: none; ">
						<table class="table table-condensed " style="background-color: #d9edf7 ">
							<tbody>
								<tr>
									<td style="border: none; width: 25%; padding: 2px;  position: relative;">
									<a href="mymessage?pageno=1" style="display: block;">
										<%-- <div style="position:relative; width:100%; height:100%;  left:0; top:0;">
											<img src="images/brxxxx_header_1.png" style="left:0; top:0;" height="100%" width="100%">
										</div>
										<span style="display: block; text-align: center; color: #fff; font-size: 2rem; z-index: 2; position: absolute; top: 10px; left: 0; width:100%; height:100%;"  id="xxshu"></span> --%>
										<span style="display: block;text-align: center;color: #fff;font-size: 2rem;position: absolute;left: 0;width: 90%;height: 90%;border-radius: 60%;background-color: green;padding-top: 10%;" id="xxshu"></span>
									</a>
								</td>
									<td style="border: none; padding: 2px;">
										<a href="${action_name}" class="text-center "> <img src="images/brxxxx_header_2.png " class="img-responsive " alt="刷新 " /> </a>
									</td>
									<td style="border: none; padding: 2px;">
										<a href="bingqbr_bysessionbingqid" class="text-center "> <img src="images/brxxxx_header_3.png " class="img-responsive " alt="病人列表 " /> </a>
									</td>
									<td style="border: none; padding: 2px;">
										<a href="bingreng_yewumokuai?v_key1=${bingrgetixingxi.key1 }&v_key2=${bingrgetixingxi.key2}"
											class="text-center"> <img src="images/brxxxx_header_4.png" class="img-responsive" alt="业务模块">
										</a>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
		</s:else>
	</div>