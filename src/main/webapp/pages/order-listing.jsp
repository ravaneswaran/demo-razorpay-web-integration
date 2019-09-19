<%@ include file="../pages/redirect-to-login-if-no-session.jsp" %>

<html>
   <head>
      <title>Order Listing</title>
      <jsp:include page="../pages/css/main-css.jsp"/>
      <jsp:include page="../pages/css/order/order-listing-css.jsp"/>
      <jsp:include page="../pages/javascript/main-javascript.jsp"/>
   </head>
   <body>
      <div class="wrapper">
         <div class="header">
         	<jsp:include page="../pages/header/order-listing-header.jsp"/>
         </div>
         <div class="content-panel">
            <jsp:include page="../pages/body/order-listing-body.jsp"/>
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
