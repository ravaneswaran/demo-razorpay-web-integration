<%@page import="rc.demo.app.properties.ApplicationProperties"%>

<div class="header-caption">
    <%= ApplicationProperties.getValue("app.title") %> : Web Integration Demo
</div>
<jsp:include page="background-image-and-navbar.jsp" />
