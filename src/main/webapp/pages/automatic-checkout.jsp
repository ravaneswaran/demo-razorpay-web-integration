<%@page import="com.demo.razorpay.service.gateway.OrderGatewayService"%>
<%@page import="com.razorpay.RazorpayException"%>
<%@ page import="com.demo.razorpay.models.OrderTransaction"%>
<%@ page import="com.demo.razorpay.properties.RazorPayProperties" %>

<html>
    <head>
        <title>Automatic Checkout</title>
        <jsp:include page="html-head/css.jsp"/>
        <jsp:include page="html-head/javascript.jsp"/>
    </head>
    <body>
        <div class="wrapper">
            <div class="header">
                <jsp:include page="header/automatic-checkout-header.jsp"/>
            </div>
            <div class="body-container">
                <div class="home-body">
                    <div class="home-body-item">&nbsp;</div>
                    <div class="home-body-item-header"><u>Automatic Checkout</u></div>
                    <div class="home-body-item">&nbsp;</div>
                    <div class="home-body-item">
                        <%
                        	String key = RazorPayProperties.getKeyId();
                        	OrderTransaction orderTransaction =  OrderGatewayService.createNewOrderTransaction(50018, "INR", 1, 1);
                        %>
                       	<form action="/order/transaction?cmd=new&checkout-type=auto" method="POST">
                            <script
                                src="https://checkout.razorpay.com/v1/checkout.js"
                                data-key="<%= key %>"
                                data-amount="<%= orderTransaction.getAmount() %>"
                                data-currency="<%= orderTransaction.getCurrency() %>"
                                data-order_id="<%= orderTransaction.getId() %>"//This is a sample Order ID. Create an Order using Orders API. (https://razorpay.com/docs/payment-gateway/orders/integration/#step-1-create-an-order)
                                data-buttontext="Pay with Razorpay"
                                data-name="Razorpay Demo"
                                data-description="Amount to be paid..."
                                data-image="../images/rc-icon.png"
                                data-prefill.name="Ravaneswaran Chinnasamy"
                                data-prefill.email="ravaneswaran@gmail.com"
                                data-theme.color="#F37254">
                            </script>
                            <input type="hidden" name="order-id" value="<%= orderTransaction.getId() %>"/>
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
    </body>
</html>