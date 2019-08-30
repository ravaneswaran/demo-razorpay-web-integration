<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.demo.razorpay.service.local.PaymentTransactionLocalService"%>
<%@page import="com.demo.razorpay.models.PaymentTransaction"%>
<%@page import="java.util.List"%>

<%
	List<PaymentTransaction> paymentTransactions = PaymentTransactionLocalService.list();
%>
<div style="background-color:#6c6c6c;height:2px;width:100%;">
</div>
<div style="color:#000000; border: 4px solid #b7f5a4; background-color:#ffffff; overflow-y:auto; min-height:550px; opacity: 0.90; text-indent:10px;margin-top:2px;">
    <%
    	if(null != paymentTransactions && !paymentTransactions.isEmpty()){
    %>
    <br />
    <table id="payment-list">
    <thead>
    	<tr>
    		<td>Sl No</td>
    		<td>Payment-ID</td>
    		<td>Order-ID</td>
    		<!-- <td>Created Date</td>
    		<td>Type</td>
    		<td>Status</td> -->
    		<td colspan="3">Actions</td>
    	</tr>
    </thead>
    <tbody>
    <%
    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    	int serialNo = 1;
    	for(PaymentTransaction paymentTransaction : paymentTransactions){
    %>
    		<tr>
    			<td><%= serialNo++ %></td>
    			<td><a onclick="return popupPaymentDetails('<%= paymentTransaction.getId()%>')"><%= paymentTransaction.getId()%></a></td>
    			<td><a onclick="return popupOrderDetails('<%= paymentTransaction.getOrderId()%>')"><%= paymentTransaction.getOrderId()%></a></td>
    			<td colspan="3" style="width:100px;">
	    			<a href="../payment/transaction?cmd=delete&payment-transaction-id=<%=paymentTransaction.getId()%>"><img alt="Delete Payment" src="../images/delete-icon.png" style="height:15px;width:40px;border:1px solid #6c6c6c;"/></a>
    			</td>
    		</tr>
    <%	
    	}
    %>
    </tbody>
    </table>
    <%
    	}    
    %>
</div>
<div id="popup-wrapper">
	<div class="popup-container-class" id="popup-container">
		<img src="../images/cancel-icon.jpg" class="img" id="cancel"/>
		<table class="popup-table">
			<thead id="popup-head">
				<tr>
					<td colspan="3">Transaction Details</td>
				</tr>
				<tr>
					<td colspan="3" class="spacer">&nbsp;</td>
				</tr>
			</thead>
			<tbody id="popup-body">
			</tbody>
		</table>
	</div>
</div>

<script>
	function popupPaymentDetails(paymentTransactionId){
		$.ajax({
			url:'../payment/transaction?cmd=details&payment-transaction-id='+paymentTransactionId,
			success:function(data) {
				$("#popup-body").html(data);
				$("#popup-wrapper").css("display", "block");
				return true;
			}
		});
	}
	
	function popupOrderDetails(orderTransactionId){
		$.ajax({
			url:'../order/transaction?cmd=details&order-transaction-id='+orderTransactionId,
			success:function(data) {
				$("#popup-body").html(data);
				$("#popup-wrapper").css("display", "block");
				return true;
			}
		});
	}
</script>
