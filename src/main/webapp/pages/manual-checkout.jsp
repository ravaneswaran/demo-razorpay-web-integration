<%@page import="com.demo.razorpay.services.OrderTransactionService"%>
<%@page import="com.demo.razorpay.models.OrderTransaction"%>
<%@page import="com.demo.razorpay.properties.RazorPayProperties"%>
<html>
    <head>
        <title>Manual Checkout Demo</title>
        <jsp:include page="html-head/css.jsp"/>
    </head>
    <body>
        <div class="wrapper">
            <div class="header">
                <jsp:include page="header/manual-checkout-header.jsp"/>
            </div>
            <div class="body-container">
                <div class="home-body">
                    <div class="home-body-item">&nbsp;</div>
                    <div class="home-body-item-header"><u>Manual Checkout</u></div>
                    <div class="home-body-item">&nbsp;</div>
                    <div class="home-body-item">
                        <%
                        	String key = RazorPayProperties.getKeyId();
                            OrderTransaction orderTransaction = OrderTransactionService.createNewOrderTransaction(40019, "INR", 1, 1);
                        %>
                        <button id="rzp-button">Pay with Razorpay</button>
						<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
						<script>
						var options = {
						    "key": "<%=  key %>", // Enter the Key ID generated from the Dashboard
						    "amount": "<%= orderTransaction.getAmount() %>", // Amount is in currency subunits. Default currency is INR. Hence, 29935 refers to 29935 paise or INR 299.35.
						    "currency": "<%= orderTransaction.getCurrency() %>",
						    "name": "Ravaneswaran Chinnasamy",
						    "description": "Amount to be paid...",
						    "image": "../images/rc-icon.png",
						    "order_id": "<%= orderTransaction.getId() %>",//This is a sample Order ID. Create an Order using Orders API. (https://razorpay.com/docs/payment-gateway/orders/integration/#step-1-create-an-order). Refer the Checkout form table given below
						    "handler": function (response){
						        alert(response.razorpay_payment_id);
						    },
						    "prefill": {
						        "name": "Ravaneswaran Chinnasamy",
						        "email": "ravaneswaran@gmail.com"
						    },
						    "notes": {
						        "address": "Chennai, India"
						    },
						    "theme": {
						        "color": "#F37254"
						    }
						};
						var razorPayButton = new Razorpay(options);
						document.getElementById('rzp-button').onclick = function(e){
							razorPayButton.open();
						    e.preventDefault();
						}
						</script>
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
    </body>
</html>