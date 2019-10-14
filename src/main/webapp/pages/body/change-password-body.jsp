<div class="change-password-panel">
	<div class="change-password-content">
		<div class="change-password-content-heading">Change Password</div>
		  	
        <form id="change-password-form" class="form" method="POST" action="../user/password?cmd=change-password">							
           <label>Your email-id Please...</label>
           <input type="text" name="email" id="email" class="mandatory">
           <label>Current Password</label>
           <input type="password" name="current-password" id="current-password" class="mandatory">
           <label>New Password</label>
           <input type="password" name="new-password" id="new-password" class="mandatory">
           <label>Confirm New Password</label>
           <input type="password" name="confirm-password" id="confirm-password" class="mandatory">
           <button type="submit" name="change-password" id="change-password">Change My Password</button>
        </form>
        
        <div id="error-message-box" class="error-message-box">
			<div id="error-message" class="error-message"></div>
			<img src="../images/cancel-icon.jpg" class="close" onclick="closeErrorMessageBox('#error-message-box')"/>
		</div>
        
    </div>
</div>

<script type="text/javascript">
   $("#change-password-form").submit(function(event){
   var formData = $(this).serializeArray();
   $.ajax({
        type        : 'POST', // define the type of HTTP verb we want to use (POST for our form)
        url         : '../user/password?cmd=change-password', // the url where we want to POST
        data        : formData, // our data object
        dataType    : 'text', // what type of data do we expect back from the server
        encode      : true
    }).done(function(data) {
           // log data to the console so we can see
           console.log(data);
           if("0" == data){
        	   alert("Password updated successfully, please relogin again.");
        	   window.location = "../user/logout";
           } else {
        	   $("#error-message").html("");
               $("#error-message").html(data);
               $("#error-message-box").css('display', 'block');
           }
       });
   event.preventDefault();
   });
   
   function closeErrorMessageBox(id){
		$(id).css('display','none');
	}
</script>