$(document).ready(function() {
		var pagerows = 5;
		/*护士工作提醒*/
		var tim = new Date()
			var i = true;
			$("#tim").html(tim.toLocaleDateString());
			$("#inform p").click(function(){
				$("#inform p").addClass("p_wrap");
				$(this).toggleClass("p_wrap")				
			})
	
		/*宣教页面筛选*/
		$("#drop_m li").click(function(){        
			$("#btn-text").html($(this).children().html());
			if($(this).index()==0){
				$("#panel_gp .box-sdow").show(50);
			}else if($(this).index()>0){
				$("#panel_gp .box-sdow").slideUp(300);
			$("#panel_gp .box-sdow").eq($(this).index()-1).slideDown(300);
			}		
		});
		$("#panel_gp button").click(function(){     //点击确定按钮切换样式
			$(this).removeClass("btn-info").addClass("btn-default")
			$(this).html("已宣教")
		});
		
		/*消息页面*/
		if($("#accordion>.box-sdow:last").index()>=pagerows){   //载入页面时，当全部消息条数大于等于9时显示”加载更多“
			$(".more-con").css('display','block')
		}
		
		/*为tab选项绑定切换时判断容器高度并决定是否显示“加载更多”*/
		  $('a[href="#readed"]').on('shown.bs.tab', function (e) {    //切换页面时 监测消息的条数
		      if($("#accordion>.box-sdow:last").index()>=pagerows){  
					$(".more-con").css('display','block')
				}
  			 });
       $('a[href="#unread"]').on('shown.bs.tab', function (e) {
	      if($("#accordion1>.box-sdow:last").index()>=pagerows){  
					$(".more-con1").css('display','block')
				}
  		 });
		
		$('a[href="#over-unread"]').on('shown.bs.tab', function (e) {
		    if($("#accordion2>.box-sdow:last").index()>=pagerows){  
					$(".more-con2").css('display','block')
				}
		   });
		   
		/*为加载更多绑定ajax事件*/
		
//		$(".more-con span").click(function(){     
//			var s ='<div class="panel panel-default box-sdow"><div class="panel-heading">'
//			+ '<h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion" href="#read10">'
//			+ '&gt;全部消息。第 1 部分</a></h4></div><div id="read10" class="panel-collapse collapse">'
//			+'<div class="panel-body padd-l"> Nihil anim keffiyeh helvetica, craft beer labore wes anderson'
//			+'</div></div></div>'
//			+'<div class="panel panel-default box-sdow"><div class="panel-heading">'
//			+ '<h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion" href="#read10">'
//			+ '&gt;全部消息。第 1 部分</a></h4></div><div id="read10" class="panel-collapse collapse">'
//			+'<div class="panel-body padd-l"> Nihil anim keffiyeh helvetica, craft beer labore wes anderson'
//			+'</div></div></div>'
//			+'<div class="panel panel-default box-sdow"><div class="panel-heading">'
//			+ '<h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion" href="#read10">'
//			+ '&gt;全部消息。第 1 部分</a></h4></div><div id="read10" class="panel-collapse collapse">'
//			+'<div class="panel-body padd-l"> Nihil anim keffiyeh helvetica, craft beer labore wes anderson'
//			+'</div></div></div>'
//			+'<div class="panel panel-default box-sdow"><div class="panel-heading">'
//			+ '<h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion" href="#read10">'
//			+ '&gt;全部消息。第 1 部分</a></h4></div><div id="read10" class="panel-collapse collapse">'
//			+'<div class="panel-body padd-l"> Nihil anim keffiyeh helvetica, craft beer labore wes anderson'
//			+'</div></div></div>'
//			+'<div class="panel panel-default box-sdow"><div class="panel-heading">'
//			+ '<h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion" href="#read10">'
//			+ '&gt;全部消息。第 1 部分</a></h4></div><div id="read10" class="panel-collapse collapse">'
//			+'<div class="panel-body padd-l"> Nihil anim keffiyeh helvetica, craft beer labore wes anderson'
//			+'</div></div></div>'
//			+'<div class="panel panel-default box-sdow"><div class="panel-heading">'
//			+ '<h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion" href="#read10">'
//			+ '&gt;全部消息。第 1 部分</a></h4></div><div id="read10" class="panel-collapse collapse">'
//			+'<div class="panel-body padd-l"> Nihil anim keffiyeh helvetica, craft beer labore wes anderson'
//			+'</div></div></div>'
//			+'<div class="panel panel-default box-sdow"><div class="panel-heading">'
//			+ '<h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion" href="#read10">'
//			+ '&gt;全部消息。第 1 部分</a></h4></div><div id="read10" class="panel-collapse collapse">'
//			+'<div class="panel-body padd-l"> Nihil anim keffiyeh helvetica, craft beer labore wes anderson'
//			+'</div></div></div>'
//			+'<div class="panel panel-default box-sdow"><div class="panel-heading">'
//			+ '<h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion" href="#read10">'
//			+ '&gt;全部消息。第 1 部分</a></h4></div><div id="read10" class="panel-collapse collapse">'
//			+'<div class="panel-body padd-l"> Nihil anim keffiyeh helvetica, craft beer labore wes anderson'
//			+'</div></div></div>'
//			+'<div class="panel panel-default box-sdow"><div class="panel-heading">'
//			+ '<h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion" href="#read10">'
//			+ '&gt;全部消息。第 1 部分</a></h4></div><div id="read10" class="panel-collapse collapse">'
//			+'<div class="panel-body padd-l"> Nihil anim keffiyeh helvetica, craft beer labore wes anderson'
//			+'</div></div></div>'
//			+'<div class="panel panel-default box-sdow"><div class="panel-heading">'
//			+ '<h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion" href="#read10">'
//			+ '&gt;全部消息。第 1 部分</a></h4></div><div id="read10" class="panel-collapse collapse">'
//			+'<div class="panel-body padd-l"> Nihil anim keffiyeh helvetica, craft beer labore wes anderson'
//			+'</div></div></div>';
//
//			var i =$(s);
//			$(i).appendTo('#accordion');
//		});
		
//		$(".more-con1 span").click(function(){
//			$.post("",function(data){
//				alert("请求成功!");
////				$(data).appendTo("#accordion1")			
//			});
//		});
//		
//		$(".more-con2 span").click(function(){
//			$.post("",function(data){
//				alert("请求成功!");
////				$(data).appendTo("#accordion2")
//			});
//		});
	});