$(document).ready(function() {
	$(window).scroll(function() {
		$(".footer").css("bottom", -$(this).scrollTop());
	});
});