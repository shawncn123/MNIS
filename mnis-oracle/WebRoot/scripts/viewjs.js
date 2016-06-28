/**
 * 
 */
$.fn.smartFloat = function() {
	var position = function(element) {
		var top = element.position().top, pos = element.css("position");
		$(window).scroll(function() {
			var scrolls = $(this).scrollTop();
			if (scrolls > top) {
				if (window.XMLHttpRequest) {
					element.css({
						position : "fixed",
						top : 0
						//left : 0
					});
				} else {
					element.css({
						top : scrolls
					});
				}
			} else {
				element.css({
//					position : "absolute",
					position : "relative",
					top : top
				});
			}
		});
	};
	return $(this).each(function() {
		position($(this));
	});
};



