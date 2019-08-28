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
    <table>
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
    			<td><%= paymentTransaction.getId()%></td>
    			<td><%= paymentTransaction.getOrderId()%></td>
    			<td><%= simpleDateFormat.format(new Date(paymentTransaction.getCreatedAt()))%></td>
    			<td><%= null != paymentTransaction.getCheckoutType() ? paymentTransaction.getCheckoutType() : "Automatic"%></td>
    			<td><%= paymentTransaction.getStatus()%></td>
    			<td>Show Payment</td>
    			<td>Show Order</td>
    			<td><a href="../payment/transaction?cmd=delete&payment-id=<%=paymentTransaction.getId()%>">Delete</a></td>
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
