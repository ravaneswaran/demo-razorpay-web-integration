<%@page import="rc.demo.app.properties.ApplicationProperties"%>

<div class="caption">
	<%= ApplicationProperties.getValue("app.title") %> : Forgot Password
</div>
<div class="user-strip">
	<div class="non-user-block">
		<div class="non-user-block-one" onclick="showOrHideUserMenu('#user-dropdown')">		
			<div class="non-user-block-one-item"></div>
			<div class="non-user-block-one-item"></div>
			<div class="non-user-block-one-item"></div>
			<div class="non-user-block-one-item"></div>
			<div class="non-user-block-one-item"></div>
			<div class="non-user-block-one-item"></div>
			<div class="non-user-block-one-item"></div>
			<div class="non-user-block-one-item"></div>
			<div class="non-user-block-one-item"></div>
		</div>
		<div id="user-dropdown" class="user-dropdown">
			<a href="../pages/login.jsp">Login</a>
			<div class="separator"></div>
			<a href="../pages/user-registration.jsp">User Registration</a>
		</div>
	</div>
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

