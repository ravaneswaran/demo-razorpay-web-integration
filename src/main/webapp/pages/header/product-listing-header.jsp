<div class="caption">
	Razorpay Demo : Product Listing
</div>
<div class="user-strip">
	<div class="user-block" onclick="showOrHideUserMenu('#user-dropdown')">Ravaneswaran Chinnasamy
		<div id="user-dropdown" class="user-dropdown">
			<a href="#">Logout</a>
		</div>
	</div>
	<div class="user-welcome">Welcome</div>
</div>
<div class="background-image"></div>            
<div id="cssmenu">
	<jsp:include page="../../pages/menu-bar/menu-bar.jsp"/>
</div>

<script>
	function showOrHideUserMenu(id){
		var display = $(id).css("display");
		if(display == "block"){
			$(id).css("display", "none");
		} else {
			$(id).css("display", "block");
		}
	}
</script>