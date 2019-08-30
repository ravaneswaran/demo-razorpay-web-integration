$(document).ready(function () {
	
	$("#onclick").click(function () {
		$("#popup-wrapper").css("display", "block");
	});
	
	$("#popup-container #cancel").click(function () {
		$(this).parent().parent().hide();
	});
	
	
});