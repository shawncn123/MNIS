$(document).ready(function() {
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
		if($("#accordion>.box-sdow:last").index()>20){   //载入页面时，当全部消息条数大于等于9时显示”加载更多“
			$(".more-con").css('display','block')
		}
		
		/*为tab选项绑定切换时判断容器高度并决定是否显示“加载更多”*/
		  $('a[href="#readed"]').on('shown.bs.tab', function (e) {    //切换页面时 监测消息的条数
		      if($("#accordion>.box-sdow:last").index()>=9){  
					$(".more-con").css('display','block')
				}
  			 });
       $('a[href="#unread"]').on('shown.bs.tab', function (e) {
	      if($("#accordion1>.box-sdow:last").index()>20){  
					$(".more-con1").css('display','block')
				}
  		 });
		
		$('a[href="#over-unread"]').on('shown.bs.tab', function (e) {
		    if($("#accordion2>.box-sdow:last").index()>20){  
					$(".more-con2").css('display','block')
				}
		   });
		   
		/*为加载更多绑定ajax事件*/
//		$(".more-con span").click(function(){     
//			$.post("",function(data){
//				alert("请求成功!");
//				//这里是将返回的html片段  直接插入到结构中；如果返回的是json或者对象，则处理json数据拼接成html      															要格式化成html格式，再执行插入；
//				//$(data).appendTo("#accordion");	
//			});
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