<html>
    <head>
        <title>Automatic Checkout Demo</title>
        <jsp:include page="html-head/css.jsp"/>
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

                        %>
                        <form action="https://www.example.com/payment/success/" method="POST">
                            <script
                                src="https://checkout.razorpay.com/v1/checkout.js"
                                data-key="D7sc91vo19qGpY"
                                data-amount="29935"
                                data-currency="INR"
                                data-order_id="order_CgmcjRh9ti2lP7"//This is a sample Order ID. Create an Order using Orders API. (https://razorpay.com/docs/payment-gateway/orders/integration/#step-1-create-an-order)
                                data-buttontext="Pay with Razorpay"
                                data-name="Acme Corp"
                                data-description="A Wild Sheep Chase is the third novel by Japanese author Haruki Murakami"
                                data-image="https://example.com/your_logo.jpg"
                                data-prefill.name="Gaurav Kumar"
                                data-prefill.email="gaurav.kumar@example.com"
                                data-theme.color="#F37254">
                            </script>
                            <input type="hidden" custom="Hidden Element" name="hidden">
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