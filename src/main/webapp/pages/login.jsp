<html>
    <head>
        <title>Razorpay Login</title>
        <jsp:include page="html-head/css.jsp"/>
        <jsp:include page="html-head/javascript.jsp"/>
    </head>
    <body>
        <div class="wrapper">
            <div class="header">
                <jsp:include page="header/home-header.jsp"/>
            </div>
            <div class="body-container">
	            <div class="login-wrapper">
					<div class="login-container">
						<h2>Razorpay Demo : Login</h2>
						<form id="login-form" class="form" method="POST" action="../user/login">							
							<label>Email :</label>
							<input type="text" name="email" id="email">
							<label>Password :</label>
							<input type="password" name="password" id="password">
							<button type="submit" name="login" id="login">Login</button>
						</form>
						<br /><br /><br />
						<a href="#">Forgot Password</a><a style="float:right;" href="../pages/user-registration.jsp">Register</a>
						<div id="error-message" class="error-message">
				        	Email and password does not exist in the system
				        </div>
					</div>
				</div>
			</div>
            <div class="sitemap">
                <jsp:include page="sitemap/sitemap.jsp"/>
            </div>
            <div class="copyright">
                <jsp:include page="footer/footer.jsp"/>
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