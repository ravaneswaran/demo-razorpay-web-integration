<html>
    <head>
        <title>Razorpay Login</title>
        <jsp:include page="html-head/css.jsp"/>
    </head>
    <body>
        <div class="wrapper">
            <div class="header">
                <jsp:include page="header/home-header.jsp"/>
            </div>
            <div class="body-container">
	            <div class="container">
					<div class="main">
						<h2>Razorpay Demo : Login</h2>
						<form id="login-form" class="form" method="post" action="../user/login">							
							<label>Email :</label>
							<input type="text" name="demail" id="email">
							<label>Password :</label>
							<input type="password" name="password" id="password">
						</form>
						<input type="button" name="login" id="login" value="Login" onclick="return submitForm();">
						<br /><br /><br />
						<a href="#">Forgot Password</a><a style="float:right;" href="../pages/user-registration.jsp">Register</a>
						<div class="error-message">
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
			/* function submitForm(){
				alert("submitForm"); */
	        	$("#login-form").submit(function(e){
					var postData = $(this).serializeArray();
					var formURL = $(this).attr("action");
					$.ajax({
						url : formURL,
						type: "POST",
						data : postData,
						success:function(data, textStatus, jqXHR){
							alert("success : hai there");
						},
						error: function(jqXHR, textStatus, errorThrown){
							alert("error : hai there");
						}
					});
					e.preventDefault();
				});
				$("#login-form").submit();
			/* } */
        </script>
    </body>
</html>