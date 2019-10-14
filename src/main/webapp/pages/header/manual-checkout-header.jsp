<%@page import="rc.demo.app.properties.ApplicationProperties"%>

<div class="header-caption">
    <%= ApplicationProperties.getValue("app.title") %> : Manual Checkout
</div>
<jsp:include page="background-image-and-navbar.jsp" />