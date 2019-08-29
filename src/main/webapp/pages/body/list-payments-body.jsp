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
    		<td>Created Date</td>
    		<td>Type</td>
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
    			<td><a href="../pages/payment-transaction-details.jsp?payment-transation-id=<%= paymentTransaction.getId()%>"><%= paymentTransaction.getId()%></a></td>
    			<td><a href="../pages/order-transaction-details.jsp?order-transaction-id=<%= paymentTransaction.getOrderId()%>"><%= paymentTransaction.getOrderId()%></a></td>
    			<td><%= simpleDateFormat.format(new Date(paymentTransaction.getCreatedAt()))%></td>
    			<td><%= null != paymentTransaction.getCheckoutType() ? paymentTransaction.getCheckoutType() : "Automatic"%></td>
    			<td><%= paymentTransaction.getStatus()%></td>
    			<td colspan="3" style="width:100px;">
	    			<a href="../payment/transaction?cmd=show&payment-id=<%=paymentTransaction.getId()%>"><img alt="Show Payment" src="../images/payment-icon.png" style="height:15px;width:15px;border:1px solid #6c6c6c;"/></a>
	    			<a href="../order/transaction?cmd=show&order-id=<%=paymentTransaction.getOrderId()%>"><img alt="Show Order" src="../images/order-icon.png" style="height:15px;width:15px;border:1px solid #6c6c6c;"/></a>
	    			<a href="../payment/transaction?cmd=delete&payment-id=<%=paymentTransaction.getId()%>"><img alt="Delete Payment" src="../images/delete-icon.png" style="height:15px;width:15px;border:1px solid #6c6c6c;"/></a>
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

<script>
    $(document).ready(function () {
        $('#payment-list').DataTable();
    });
</script>
