<%@page import="rc.demo.app.properties.ApplicationProperties"%>
<%@page import="rc.demo.app.SessionAttributes"%>
<%@page import="rc.demo.app.models.User"%>

<%
	User sessionUser = (User)request.getSession().getAttribute(SessionAttributes.SESSION_USER);
%>

<div class="caption">
	<%= ApplicationProperties.getValue("app.title") %> : Order Listing
</div>
<div class="user-strip">
	<%
		if(null != sessionUser){
	%>
	<div class="user-block" onclick="showOrHideUserMenu('#user-dropdown')"><%= sessionUser.getFirstName() + " " + sessionUser.getLastName() %>
		<div id="user-dropdown" class="user-dropdown">
			<a href="../pages/product-listing.jsp">Product Listing</a>
			<a href="../pages/order-listing.jsp">Order Listing</a>
			<div class="separator"></div>
			<a href="../pages/change-password.jsp">Change Password</a>
			<div class="separator"></div>
			<a href="../user/logout">Logout</a>
		</div>
	</div>
	<div class="user-welcome">Welcome</div>
	<%
		}
	%>
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

