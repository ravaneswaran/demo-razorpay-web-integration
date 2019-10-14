
<html>
   <head>
      <title>Razorpay Login</title>
      <link rel="shortcut icon" type="image/x-icon" href="../../images/rc-icon.png" />
      <link rel="stylesheet" type="text/css" href="../css/main-like.css">
      <link rel="stylesheet" type="text/css" href="../css/user-registration-like.css">
      <script src="../js/jquery/jquery-3.3.1-min.js"></script>
      <script src="../js/jquery/jquery-confirm-3.3.1-min.js"></script>
      <script src="../js/jquery/jquery-dataTables-1.10.16-min.js"></script>
      <script src="../js/jquery/jquery-menu.js"></script>
      <script src="../js/jquery/jquery-popup.js"></script>
   </head>
   <body>
      <div class="wrapper">
         <div class="header">
            <div class="caption">
               Razorpay : Web Integration Demo
            </div>
            <div class="background-image"></div>            
               <div id="cssmenu">
                  <ul>
                     <li><a href='../pages/home.jsp'><span>Home</span></a></li>
                     <li class='active has-sub'>
                        <a href='#'><span>Checkout Methods</span></a>
                        <ul>
                           <li class='last'><a href='../pages/automatic-checkout.jsp'><span>Automatic Checkout</span></a></li>
                           <li class='last'><a href='../pages/manual-checkout.jsp'><span>Manual Checkout</span></a>
                           <li class='last'><a href='#'><span>Subscription</span></a></li>
                        </ul>
                     </li>
                     <li class='active has-sub'>
                        <a href='#'><span>Listing</span></a>
                        <ul>
                           <li class='last'><a href='../pages/list-payments.jsp'><span>Payments</span></a></li>
                           <li class='last'><a href='../pages/list-payments.jsp'><span>Orders</span></a>
                        </ul>
                     </li>
                     <li class='active has-sub'>
                        <a href='#'><span>Sync With Gateway</span></a>
                        <ul>
                           <li class='last'><a href='../payment/transaction?cmd=sync'><span>Payment Sync</span></a></li>
                           <li class='last'><a href='../order/transaction?cmd=sync'><span>Order Sync</span></a>
                        </ul>
                     </li>
                  </ul>
                  <!-- 
                  	 <div style="float: right; border: 1px solid #6c6c6c; height: 33px; margin: 0; width: 33px; border-radius:2px;">		
                     <div style="float: left; border: 1px solid #6c6c6c; height: 5px; margin: 2; width: 5px; background-color: #6c6c6c; border-radius: 2px"></div>
                     <div style="float: left; border: 1px solid #6c6c6c; height: 5px; margin: 2; width: 5px; background-color: #6c6c6c; border-radius: 2px"></div>
                     <div style="float: left; border: 1px solid #6c6c6c; height: 5px; margin: 2; width: 5px; background-color: #6c6c6c; border-radius: 2px"></div>
                     <div style="float: left; border: 1px solid #6c6c6c; height: 5px; margin: 2; width: 5px; background-color: #6c6c6c; border-radius: 2px"></div>
                     <div style="float: left; border: 1px solid #6c6c6c; height: 5px; margin: 2; width: 5px; background-color: #6c6c6c; border-radius: 2px"></div>
                     <div style="float: left; border: 1px solid #6c6c6c; height: 5px; margin: 2; width: 5px; background-color: #6c6c6c; border-radius: 2px"></div>
                     <div style="float: left; border: 1px solid #6c6c6c; height: 5px; margin: 2; width: 5px; background-color: #6c6c6c; border-radius: 2px"></div>
                     <div style="float: left; border: 1px solid #6c6c6c; height: 5px; margin: 2; width: 5px; background-color: #6c6c6c; border-radius: 2px"></div>
                     <div style="float: left; border: 1px solid #6c6c6c; height: 5px; margin: 2; width: 5px; background-color: #6c6c6c; border-radius: 2px"></div>
                  -->
            </div>
         </div>
         <div class="content-panel">
            <div class="user-register-panel">
               <div class="user-register-content">
					<div class="user-register-content-heading">User Registration</div>               	
					<form id="registration-form" class="form" method="POST" action="../user/registration">
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
						<button type="submit" name="register" id="register">Sign Up</button>
					</form>
               </div> 
            </div>
         </div>
         <div class="sitemap">
            <ul style="width:75px;">
               <li><a href="../pages/home.jsp">Home</a></li>
            </ul>
            <ul style="width:165px;">
               <li>Checkout Methods</li>
               <ul>
                  <li><a href="../pages/automatic-checkout.jsp">Automatic Checkout</a></li>
                  <li><a href="../pages/manual-checkout.jsp">Manual Checkout</a></li>
                  <li><a href="#">Subscription</a></li>
               </ul>
            </ul>
         </div>
         <div class="footer">
            &copy; 2019 Ravaneswaran Chinnasamy, All Rights Reserved.
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