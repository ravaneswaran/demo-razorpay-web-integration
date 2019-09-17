<%@page import="com.demo.razorpay.service.local.ProductLocalService"%>
<%@page import="com.demo.razorpay.models.Product"%>
<%@page import="com.demo.razorpay.models.OrderProductJoin"%>
<%@page import="com.demo.razorpay.service.local.OrderProductJoinLocalService"%>
<%@page import="com.demo.razorpay.service.local.OrderLocalService"%>
<%@page import="com.demo.razorpay.models.Order"%>
<%@page import="java.util.List"%>
<%@page import="com.demo.razorpay.SessionAttributes"%>
<%@page import="com.demo.razorpay.models.User"%>

<%
	User sessionUser = (User)session.getAttribute(SessionAttributes.SESSION_USER);
	List<Order> previousOrders = OrderLocalService.listOrdersByUserId(sessionUser.getId());
%>

<div class="order-panel">
	<div class="order-content">
		<div class="order-content-heading">Order Listing</div>
		<div class="order-content-body">
			
				<%
					if(null != previousOrders && !previousOrders.isEmpty()){
						for(Order previousOrder : previousOrders){
							List<OrderProductJoin> orderProductJoins = OrderProductJoinLocalService.listOrderProductJoinsByOrderId(previousOrder.getId());
							if(null != orderProductJoins && !orderProductJoins.isEmpty()){
								for(OrderProductJoin orderProductJoin : orderProductJoins){
									Product product = orderProductJoin.getProduct();
									String orderAndProductIdCombo = String.format("#%s-%s",previousOrder.getId(), product.getId());
				%>
									<div class="order-content-body-accordion" onclick="toggleAccordionInfo('<%= orderAndProductIdCombo%>')">
										Order : <%= previousOrder.getId() %>
										<span><%= previousOrder.getStatus() %></span>
									</div> 
									<div class="order-content-body-accordion-info" id="<%= orderAndProductIdCombo %>">
										<%= product.getName() %>
									</div>
				<%
								}
							}
						}
					}
				%>
			
		</div>
	</div>
</div>

<script>
	function toggleAccordionInfo(id){
		alert(id);
		$(id).toggle(0);
		/* $(id).toggle(0); */
		//$(id).css("display", "block");
		/* var displayStyle = $(id).css("display");
		alert(displayStyle);
		if("none" == displayStyle){
			$(id).css("display", "block");
		} else {
			$(id).css("display", "none");
		} */
  	}
</script>