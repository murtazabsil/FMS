$(document).ready(function() {
	var path = location.pathname.split('/');
	path = path[path.length - 1];
	$('#main-menu a').each(function() {
		if ($(this).attr('href') === path) {
			$(this).addClass('menu-active');
		}
	});

	if ($(window).width() < 600) {
		$('.bs-navbar-collapse').addClass('collapse');
	}
	
	$('.table-responsive').css('border','none');
});
