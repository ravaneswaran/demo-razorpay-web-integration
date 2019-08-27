<html>
    <head>
        <title>Internal Server Error</title>
        <jsp:include page="html-head/css.jsp"/>
    </head>
    <body>
        <div class="wrapper">
            <div class="header">
                <jsp:include page="header/internal-server-error-header.jsp"/>
            </div>
            <div class="body-container">
               <jsp:include page="body/internal-server-error-body.jsp"/>
            </div>
            <div class="sitemap">
                <jsp:include page="sitemap/sitemap.jsp"/>
            </div>
            <div class="copyright">
                <jsp:include page="footer/footer.jsp"/>
            </div>
        </div>
    </body>
</html>