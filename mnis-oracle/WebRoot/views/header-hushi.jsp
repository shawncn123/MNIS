<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div id="head_banner_1" style="z-index:1000; " class="bg-info">
		<div class="row" style="border-bottom:1px solid #269abc;padding: 5px 0 5px 0; margin: 0;">
			<div class="col-xs-2"  style="padding-right: 2%; padding-top: .5%;">
				<a href="bingqbr_bysessionbingqid"> 
					<img src="images/icon-m-man-active.png" class="img-responsive" alt="<s:property value='#session.caozuoyuan.ryxm' />">
				</a>
			</div>
			<div class="col-xs-6" style="padding: 2%;color: #807D7D;">
				<span><strong style="font-size: 18px; color: #000;"><s:property value='#session.caozuoyuan.ryxm' /></strong></span>
				<span class="text-left" style="margin-bottom: 5px;" id="bingqu_name"><s:property value="#session.dangqianbingqu_name" /></span>
				<input id="dangq_bingq_id" value="<s:property value='#session.dangqianbingqu_id' />" style="display:none;"/>
			</div>
			<div class="col-xs-2" style="padding-left: 2%;padding-right:2%; position: relative;">
				<a href="javascript:void(0);" style="display: block;">
					<div style="position:relative; width:100%; height:100%;  left:0; top:0;">      
						<img src="images/brxxxx_header_1.png" style="left:0; top:0;" height="100%" width="100%"> 
					</div> 
					<span style="display: block; text-align: center; color: #fff; font-size: 2.6rem; z-index: 2; position: absolute; top: 3PX; left: 0; width:100%; height:100%;">2</span>
				</a>
			</div>
			<div class="col-xs-2" style="padding-left: 2%;padding-right:2%;">
				<a href="javascript:void(0)"><img src="images/brxxxx_header_2.png" class="img-responsive" alt="刷新"></a>
			</div>
		</div>