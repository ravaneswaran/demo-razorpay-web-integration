<html>
   <head>
      <title>Razorpay Login</title>
      <jsp:include page="../pages/css/main-css.jsp"/>
      <jsp:include page="../pages/css/login/login-css.jsp"/>
      <jsp:include page="../pages/javascript/main-javascript.jsp"/>
   </head>
   <body>
      <div class="wrapper">
         <div class="header">
            <div class="caption">
               Razorpay : Web Integration Demo
            </div>
            <div class="background-image"></div>            
            <div id="cssmenu">
               <jsp:include page="../pages/menu-bar/menu-bar.jsp"/>
         	</div>
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
      <script type="text/javascript">
         $("#login-form").submit(function(event){
         var formData = $(this).serializeArray();
         $.ajax({
              type        : 'POST', // define the type of HTTP verb we want to use (POST for our form)
              url         : '../user/login', // the url where we want to POST
              data        : formData, // our data object
              dataType    : 'text', // what type of data do we expect back from the server
              encode      : true
          }).done(function(data) {
                 // log data to the console so we can see
                 console.log(data);
                 if("0" == data){
                 	window.location = '../pages/product-listing.jsp';
                 } else {
                 	$("#error-message").html(data);
                 	$("#error-message").css('display', 'block');
                 }
                 // here we will handle errors and validation messages
             });
         event.preventDefault();
         });
      </script>
   </body>
</html>