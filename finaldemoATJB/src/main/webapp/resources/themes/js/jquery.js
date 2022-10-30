jQuery(function($) {

	$(".sidebar-dropdown > a").click(
			function() {
				$(".sidebar-submenu").slideUp(200);
				$(this).parent().children().children().children().removeClass(
						"submenu-active");
				if ($(this).parent().hasClass("active")) {
					// co class active thi xoa class active do di
					$(this).parent().removeClass("active");
				} else {
					// khong co class active thi xoa toan vo class o nhung thang
					// khac roi add class active vao
					$(".sidebar-dropdown").removeClass("active");
					$(this).next(".sidebar-submenu").slideDown(200);
					$(this).parent().addClass("active");
					$(this).parent().children().children().children(
							".submenu:eq(0)").addClass("submenu-active");
				}
			});

	$(".submenu > a").click(function() {
		if ($(this).parent().hasClass("submenu-active")) {
		} else {
			$(".submenu").removeClass("submenu-active");
			$(this).parent().addClass("submenu-active");
		}
	});
	$("#arrow-down").click(function() {
		if ($('.sidebar-content').is(':visible')) {
			$('#arrow-down').css('transform', 'rotate(180deg)');
			$('#arrow-down').css('transition-duration', '0.2s');
			$('.font-arrow-down').css('top', '65px');
			$(".sidebar-content").slideUp(200);
		} else {
			$(".sidebar-content").slideDown(200);
			$('#arrow-down').css('transform', 'rotate(0deg)');
			$('.font-arrow-down').css('top', '70px');
		}
	});
});