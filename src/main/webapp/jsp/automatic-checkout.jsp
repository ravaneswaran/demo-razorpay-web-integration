<html>
<head>
<title>Razorpay : Automatic Checkout</title>
<link rel="stylesheet" type="text/css" href="../css/main.css">
</head>
<body>
<div class="header">
Razorpay Automatic Checkout - Demo
</div>
<div class="menu-bar">
<ul>
<li>Home</li>
</ul>
</div>

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
    data-theme.color="#F37254"
></script>
<input type="hidden" custom="Hidden Element" name="hidden">
</form>

</body>
</html>
