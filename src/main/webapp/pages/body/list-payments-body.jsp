<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="rc.demo.app.service.local.PaymentTransactionLocalService"%>
<%@page import="rc.demo.app.models.PaymentTransaction"%>
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
    <table class="payment-list" id="payment-listing-table">
    <thead>
    	<tr>
    		<th>Sl No</th>
    		<th>Description</th>
    		<th>Payment-ID</th>
    		<th>Order-ID</th>
    		<!-- <td>Created Date</td>
    		<td>Type</td>
    		 -->
    		 <th>Status</td>
    		<th colspan="3">Actions</th>
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
    			<td><%= paymentTransaction.getDescription()%></td>
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
		$.confirm({
		    title: 'Delete Confirmation!',
		    content: 'Are you sure want to delete this item ( '+paymentTransactionId+' ) ?',
		    type: 'red',
		    buttons: {
		        confirm: function () {
		            window.location = '../payment/transaction?cmd=delete&payment-transaction-id='+paymentTransactionId
		        },
		        cancel: function () {}
		    }
		});
		return false;
	}

	function popupPaymentDetails(paymentTransactionId){
		$.ajax({
			url:'../payment/transaction?cmd=details&payment-transaction-id='+paymentTransactionId,
			success:function(data) {
				$("#popup-body").html(data);
				$("#popup-wrapper").css("display", "block");
			}
		});
	}
	
	function popupOrderDetails(orderTransactionId){
		$.ajax({
			url:'../order/transaction?cmd=details&order-transaction-id='+orderTransactionId,
			success:function(data) {
				$("#popup-body").html(data);
				$("#popup-wrapper").css("display", "block");
			}
		});
	}
	
	function cancelOrder(orderTransactionId){
		$.ajax({
			url:'../order/transaction?cmd=cancel&order-transaction-id='+orderTransactionId,
			success:function(data) {
				$.confirm({
				    title: 'Cancel Order Confirmation!',
				    content: 'Are you sure want to cancel this order ( '+orderTransactionId+' ) ?',
				    type: 'red',
				    buttons: {
				        confirm: function () {
				        	$("#popup-body").html("");
							$("#popup-body").html(data);
				        },
				        cancel: function () {}
				    }
				});
			}
		});
	}
	
	function confirmOrder(orderTransactionId){
		$.ajax({
			url:'../order/transaction?cmd=confirm&order-transaction-id='+orderTransactionId,
			success:function(data) {
				$.confirm({
				    title: 'Confirm Order Confirmation!',
				    content: 'Are you sure want to confirm this order ( '+orderTransactionId+' ) ?',
				    type: 'green',
				    buttons: {
				        confirm: function () {
				        	$("#popup-body").html("");
							$("#popup-body").html(data);
				        },
				        cancel: function () {}
				    }
				});
			}
		});
	}
	
	function refundPayment(paymentTransactionId){
		$.ajax({
			url:'../payment/transaction?cmd=refund&payment-transaction-id='+paymentTransactionId,
			success:function(data) {
				
				$.confirm({
				    title: 'Payment Refund Confirmation!',
				    content: 'Are you sure want to refund this payment ( '+paymentTransactionId+' ) ?',
				    type: 'red',
				    buttons: {
				        confirm: function () {
				        	$("#popup-body").html("");
							$("#popup-body").html(data);
				        },
				        cancel: function () {}
				    }
				});
				return true;
			}
		});
	}
	
	function settlePayment(paymentTransactionId){
		$.ajax({
			url:'../payment/transaction?cmd=settle&payment-transaction-id='+paymentTransactionId,
			success:function(data) {
				
				$.confirm({
				    title: 'Payment Settle Confirmation!',
				    content: 'Are you sure want to settle this payment ( '+paymentTransactionId+' ) ?',
				    type: 'green',
				    buttons: {
				        confirm: function () {
				        	$("#popup-body").html("");
							$("#popup-body").html(data);
				        },
				        cancel: function () {}
				    }
				});
				return true;
			}
		});
	}
</script>
