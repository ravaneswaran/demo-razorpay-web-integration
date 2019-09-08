<div class="user-register-panel">
	<div class="user-register-content">
		<div class="user-register-content-heading">User Registration</div>               	
		<form id="registration-form" class="form" method="POST" action="../user/registration">
			<label>First Name</label><br/>
			<input type="text" name="firstname" id="firstname" class="mandatory">
			<label>Middle Initial</label><br/>
			<input type="text" name="middleinitial" id="middleinitial">
			<label>Last Name</label><br/>
			<input type="text" name="lastname" id="lastname">
			<label>Email</label><br/>
			<input type="text" name="emailid" id="emailid" class="mandatory">
			<label>Password</label><br/>
			<input type="password" name="password" id="password" class="mandatory">
			<label>Confirm Password</label><br/>
			<input type="password" name="confirmpassword" id="confirmpassword" class="mandatory" placeholder="">
			<button type="submit" name="register" id="register">Sign Up</button>
		</form>
		<div id="error-message-box" class="error-message-box">
			<div id="error-message" class="error-message">Error Message</div>
			<img src="../images/cancel-icon.jpg" class="close" onclick="closeErrorMessageBox('#error-message-box')"/>
		</div>
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
	            	  $('#error-message').html(data);
	            	  $('#error-message-box').css('display','block');
	              }
	              // here we will handle errors and validation messages
	          });
		event.preventDefault();
	});
	
	function closeErrorMessageBox(id){
		$(id).css('display','none');
  	}
</script>
     
     