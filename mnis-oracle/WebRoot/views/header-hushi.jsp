<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">	
	$(function(){
		var url = "weiduxiaoxishu";
	/* 	var args = {"time" : new Date()}; */
		$.post(url,function(data) {
			if(data!=""){
				/* alert(data); */
				$("#xxshu").text(data+"");
			};		
		});
	});
</script>
<div id="head_banner_1" style="z-index:1000; " class="bg-info">
		<div class="row" style="border-bottom:1px solid #269abc;padding: 1% 0 1% 0;">
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
			<div class="col-xs-2" style="padding-left: 2%;padding-right:2%; position: relative;width: 16.6%; height: 80%;">
				<a href="mymessage?pageno=1" style="display: block;">
					<img src="images/brxxxx_header_1.png" style="height:100%; width:100%"> 
					<span style="display: block; text-align: center; color: #fff; font-size: 2rem; z-index: 2; position: absolute; top: 10PX; left: 0; width:100%; height:100%;" id="xxshu"></span>
				</a>
			</div>
			<div class="col-xs-2" style="padding-left: 2%;padding-right:2%;">
				<a href="${action_name}"><img src="images/brxxxx_header_2.png" class="img-responsive" alt="刷新"></a>
			</div>
		</div>
		<!-- <div class="row" style="height:1px;">	<input type="text" id="smName" placeholder="扫腕带测试" onfocus="javascript:this.value='';"
						oninput="allsaowandai_Function()" style="width: 0px;height: 0px;border: none;"/></div> -->