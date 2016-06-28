$(function(){
		var height = $('#head_banner_1').height();  
	    $('#sideWrap').css('margin-top', height + 'px');
		
		$('#sideWrap').hide();     //护士菜单
		$('#sideBtn').click(function(){
			$('.sideBtnIcon').toggleClass("glyphicon-align-justify").addClass('glyphicon-remove'); //
			$('#sideWrap').toggle(300);			
		});			
		
		$('#sideWrap').click(function(e){    //点击护士菜单以外的地方隐藏菜单
			$('.sideBtnIcon').addClass("glyphicon-align-justify");
			var $tar = $(e.target);
			if(!$tar.is('#sideMenu')) {
				$(this).hide();
			}
		});

		(function() {        //返回顶部
			var $backToTopTxt = "",
				$backToTopEle = $('<div class="backToTop"></div>').appendTo($("body"))
				.text($backToTopTxt).attr("title", $backToTopTxt).click(function() {
					$("html, body").animate({
						scrollTop: 0
					}, 120);
				}),
				$backToTopFun = function() {
					var st = $(document).scrollTop(),
						winh = $(window).height();
					(st > 0) ? $backToTopEle.show(): $backToTopEle.hide();
				};
			$(window).bind("scroll", $backToTopFun);
			$(function() {
				$backToTopFun();
			});
		})();
				
		$('#tishi').hide();    //扫描腕带的提示信息隐藏
		$('#saoBtn').click(function(){    //点击扫描按钮
			$('#tishi').toggle();
			$('#smName').focus();     //尾部接收数据的input隐藏输入框获取焦点
			var val = $('#smName').val();
			if (val) {				
				$('#tishi').hide();   //input接收到数据以后提示信息自动隐藏
			}
		});
		
		var height = $('#head_banner_1').height();   //扫描腕带弹出模态框距离头部距离
		$('#modalWrap').css({   
			'position':'fixed',
			'top':height + 'px'		
		});		
	    $('#module').on('shown.bs.modal', function () {
	        $('.modal-backdrop').css('top', height + 'px')
	    });	 
});
