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
<div class="table-list-container">
    <%
    	if(null != paymentTransactions && !paymentTransactions.isEmpty()){
    %>
    <br />
    <table class="payment-list">
    <thead>
    	<tr>
    		<td>Sl No</td>
    		<td>Payment-ID</td>
    		<td>Order-ID</td>
    		<!-- <td>Created Date</td>
    		<td>Type</td>
    		 -->
    		 <td>Status</td>
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
    			<td><%= paymentTransaction.getStatus()%></td>
    			<td colspan="3" style="width:100px;text-align:center;">
	    			<a href="../payment/transaction?cmd=delete&payment-transaction-id=<%=paymentTransaction.getId()%>" onclick="return deleteTransaction('<%=paymentTransaction.getId()%>')"><img alt="Delete Payment" src="../images/delete-icon.png" style="height:20px;width:25px;border:0px solid #6c6c6c;"/></a>
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
		<!-- <div style="width:100%;height:50px;background-color:#b7f5a4;">Transaction Details</div>  -->
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
	function deleteTransaction(paymentTransactionId){
		$.alert({
		    title: 'Delete Confirmation!',
		    content: 'Are you sure want to delete?',
		});
		return false;
	}

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
	
	function cancelOrder(orderTransactionId){
		$.ajax({
			url:'../order/transaction?cmd=cancel&order-transaction-id='+orderTransactionId,
			success:function(data) {
				$("#popup-body").html("");
				$("#popup-body").html(data);
				$.alert({
				    title: 'Alert!',
				    content: 'Simple alert!',
				});
				return true;
			}
		});
	}
	
	function confirmOrder(orderTransactionId){
		$.ajax({
			url:'../order/transaction?cmd=confirm&order-transaction-id='+orderTransactionId,
			success:function(data) {
				$("#popup-body").html("");
				$("#popup-body").html(data);
				$.alert({
				    title: 'Alert!',
				    content: 'Simple alert!',
				});
				return true;
			}
		});
	}
	
	function refundPayment(paymentTransactionId){
		$.ajax({
			url:'../payment/transaction?cmd=refund&payment-transaction-id='+paymentTransactionId,
			success:function(data) {
				$("#popup-body").html("");
				$("#popup-body").html(data);
				$.alert({
				    title: 'Alert!',
				    content: 'Simple alert!',
				});
				return true;
			}
		});
	}
	
	function settlePayment(paymentTransactionId){
		$.ajax({
			url:'../payment/transaction?cmd=settle&payment-transaction-id='+paymentTransactionId,
			success:function(data) {
				$("#popup-body").html("");
				$("#popup-body").html(data);
				$.alert({
				    title: 'Alert!',
				    content: 'Simple alert!',
				});
				return true;
			}
		});
	}
</script>
