<html>
    <head>
        <title>User Registration</title>
        <jsp:include page="html-head/css.jsp"/>
        <jsp:include page="html-head/javascript.jsp"/>
    </head>
    <body>
        <div class="wrapper">
            <div class="header">
                <jsp:include page="header/home-header.jsp"/>
            </div>
            <div class="body-container">
                <div class="register-wrapper">
                	<div class="register-container">
                		<form id="registration-form" class="form" method="POST" action="../user/registration">
	                		<h2>Razorpay Demo : User Registration</h2>
	                		<label>First Name</label><br/>
							<input type="text" name="firstname" id="firstname">
							<label>Middle Initial</label><br/>
							<input type="text" name="middleinitial" id="middleinitial">
							<label>Last Name</label><br/>
							<input type="text" name="lastname" id="lastname">
							<label>Email</label><br/>
							<input type="text" name="emailid" id="emailid">
							<label>Password</label><br/>
							<input type="password" name="password" id="password">
							<label>Confirm Password</label><br/>
							<input type="password" name="confirmpassword" id="confirmpassword">
							<button type="submit" name="register" id="register">Register Me</button>
						</form>
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
        	$("#registration-form").submit(function(event){
				var formData = $(this).serializeArray();
				$.ajax({
		            type        : 'POST', // define the type of HTTP verb we want to use (POST for our form)
		            url         : '../user/registration', // the url where we want to POST
		            data        : formData, // our data object
		            dataType    : 'text', // what type of data do we expect back from the server
		            encode      : true
		        }).done(function(data) {
	                // log data to the console so we can see
	                console.log(data);
	                if("0" == data){
	                	window.location = '../pages/login.jsp';
	                } else {
	                	
	                }
	                // here we will handle errors and validation messages
	            });
				event.preventDefault();
			});
        </script>
    </body>
</html>
