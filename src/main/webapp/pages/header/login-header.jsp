<%@page import="rc.demo.app.properties.ApplicationProperties"%>

<div class="caption">
	<%= ApplicationProperties.getValue("app.title") %> : Login
</div>
<div class="user-strip">
	<div class="page-box">		
		<div class="page"></div>
		<div class="page"></div>
		<div class="page"></div>
		<div class="page"></div>
		<div class="page"></div>
		<div class="page"></div>
		<div class="page"></div>
		<div class="page"></div>
		<div class="page"></div>
	</div>
</div>
<div class="background-image"></div>            
<div id="cssmenu">
	<jsp:include page="../../pages/menu-bar/menu-bar.jsp"/>
</div>