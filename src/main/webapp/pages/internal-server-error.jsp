<html>
   <head>
      <title>HTTP : 500</title>
      <jsp:include page="../pages/css/main-css.jsp"/>
      <jsp:include page="../pages/css/http-status/http-status-css.jsp"/>
      <jsp:include page="../pages/javascript/main-javascript.jsp"/>
   </head>
   <body>
      <div class="wrapper">
         <div class="header">
            <jsp:include page="../pages/header/internal-server-error-header.jsp"/>
         </div>
         <div class="content-panel">
            <jsp:include page="../pages/body/http-status/500-body.jsp"/>
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