<%@page import="rc.demo.app.properties.ApplicationProperties"%>

<%@ include file="../pages/redirect-to-product-listing-if-session-exists.jsp" %>

<html>
   <head>
      <title>Login</title>
      <jsp:include page="../pages/css/main-css.jsp"/>
      <jsp:include page="../pages/css/login/login-css.jsp"/>
      <jsp:include page="../pages/javascript/main-javascript.jsp"/>
   </head>
   <body>
      <div class="wrapper">
         <div class="header">
            <jsp:include page="../pages/header/login-header.jsp"/>
         </div>
         <div class="content-panel">
            <jsp:include page="../pages/body/login-body.jsp"/>
         </div>
         <div class="sitemap">
            <jsp:include page="../pages/sitemap/sitemap.jsp"/>
         </div>
         <div class="footer">
            <jsp:include page="../pages/footer/footer.jsp"/>
         </div>
      </div>
   </body>
</html>