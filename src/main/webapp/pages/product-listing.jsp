<%@ include file="../pages/redirect-to-login-if-no-session.jsp" %>

<html>
   <head>
      <title>Product Listing</title>
      <jsp:include page="../pages/css/main-css.jsp"/>
      <jsp:include page="../pages/css/products/product-listing-css.jsp"/>
      <jsp:include page="../pages/javascript/main-javascript.jsp"/>
   </head>
   <body>
      <div class="wrapper">
         <div class="header">
         	<jsp:include page="../pages/header/product-listing-header.jsp"/>
         </div>
         <div class="content-panel">
            <jsp:include page="../pages/body/product-listing-body.jsp"/>
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
