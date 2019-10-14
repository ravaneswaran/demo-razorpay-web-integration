<div class="forgot-password-panel">
	<div class="forgot-password-content">
		<div class="forgot-password-content-heading">Forgot Password</div>               	
        <form id="forgot-password-form" class="form" method="POST" action="../user/password?cmd=forgot-password">							
           <label>Your email-id Please...</label>
           <input type="text" name="email" id="email" class="mandatory">
           <button type="submit" name="forgot-password" id="forgot-password">Get My Password</button>
        </form>
        <div id="forgot-password-response" class="forgot-password-response"></div>
    </div>
</div>

<script type="text/javascript">
   $("#forgot-password-form").submit(function(event){
   var formData = $(this).serializeArray();
   $.ajax({
        type        : 'POST', // define the type of HTTP verb we want to use (POST for our form)
        url         : '../user/password?cmd=forgot-password', // the url where we want to POST
        data        : formData, // our data object
        dataType    : 'text', // what type of data do we expect back from the server
        encode      : true
    }).done(function(data) {
           // log data to the console so we can see
           console.log(data);
           /* if('-1' == data){
        	   $("#forgot-password-response").html("Sorry!!! you are yet to register...");
           } else {
        	   $("#forgot-password-response").html("Your password is : " + data);
           } */
           $("#forgot-password-response").html("");
           $("#forgot-password-response").html(data);
           $("#forgot-password-response").css('display', 'block');
           // here we will handle errors and validation messages
       });
   event.preventDefault();
   });
</script>