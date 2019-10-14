<%@page import="java.util.ArrayList"%>
<%@page import="rc.demo.app.service.local.ProductLocalService"%>
<%@page import="rc.demo.app.models.Product"%>
<%@page import="rc.demo.app.models.OrderProductJoin"%>
<%@page import="rc.demo.app.service.local.OrderProductJoinLocalService"%>
<%@page import="rc.demo.app.service.local.OrderLocalService"%>
<%@page import="rc.demo.app.models.Order"%>
<%@page import="java.util.List"%>
<%@page import="rc.demo.app.SessionAttributes"%>
<%@page import="rc.demo.app.models.User"%>

<%
	User sessionUser = (User)session.getAttribute(SessionAttributes.SESSION_USER);
	List<Order> previousOrders = new ArrayList<Order>();
	if(null != sessionUser){
		previousOrders = OrderLocalService.listOrdersByUserId(sessionUser.getId());
	}
%>

<div class="order-panel">
	<div class="order-content">
		<div class="order-content-heading">Order Listing</div>
		<div class="order-content-body">
			<%
				if(null != previousOrders && !previousOrders.isEmpty()){
					for(Order previousOrder : previousOrders){
						
			%>
						<div class="order-content-body-accordion">
							<a class="underline" onclick="toggleAccordionInfo('<%= previousOrder.getId() %>')">Order : <%= previousOrder.getId() %></a>
							<a href="../order/details?cmd=details&order-id=<%=previousOrder.getId()%>"><img class="icon" src="../images/payment-icon.png"/></a>
							<img class="icon" src="../images/delete-icon.png" onclick="deleteOrder('<%= previousOrder.getId()%>')"/>
							<span><%= previousOrder.getStatus() %></span>
						</div> 
						<div class="order-content-body-accordion-info" id="<%= previousOrder.getId() %>">
			<%
						List<OrderProductJoin> orderProductJoins = OrderProductJoinLocalService.listOrderProductJoinsByOrderId(previousOrder.getId());
						if(null != orderProductJoins && !orderProductJoins.isEmpty()){
							for(OrderProductJoin orderProductJoin : orderProductJoins){
								Product product = orderProductJoin.getProduct();
			%>
								<div class="order-content-body-accordion-product">
									<img src="<%= product.getImageLocation() %>"/>
									<table>
										<tbody>
											<tr>
												<td class="product-spec-property-name">Name</td>
												<td class="product-spec-property-value"><%= product.getName() %></td>
												<td class="product-spec-property-name">RAM</td>
												<td class="product-spec-property-value"><%= product.getRam() %></td>
											</tr>
											<tr>
												<td class="product-spec-property-name">Battery</td>
												<td class="product-spec-property-value"><%= product.getBattery() %></td>
												<td class="product-spec-property-name">Camera</td>
												<td class="product-spec-property-value"><%= product.getCamera() %></td>
											</tr>
											<tr>
												<td class="product-spec-property-name">Performance</td>
												<td class="product-spec-property-value"><%= product.getPerformance() %></td>
												<td class="product-spec-property-name">Price</td>
												<td class="product-spec-property-value"><%= product.getFormattedPrice() %></td>
											</tr>
										</tbody>
									</table>
								</div>
								
			<%
							}
						}			
			%>
						</div>		
			<%
					}
				} else {		
			%>
						<div class="order-content-body-no-order">
							<div class="order-content-body-no-order-header">No Orders !!!</div>
							<div class="order-content-body-no-order-body">
								<img src="../images/no-orders.png" />
							</div>
							
						</div>		
			<%
				}
			%>
		</div>
	</div>
</div>

<script>

	function toggleAccordionInfo(orderId){
		var elementId = "#"+orderId;
		var displayStyle = $(elementId).css("display");
		if("none" == displayStyle){
			$(elementId).css("display", "block");
		} else {
			$(elementId).css("display", "none");
		}
	}
	
	function deleteOrder(orderId){
		$.confirm({
		    title: 'Delete Confirmation!',
		    content: 'Are you sure want to delete this item ( '+orderId+' ) ?',
		    type: 'red',
		    buttons: {
		        confirm: function () {
		        	$.ajax({
		    			url:'../order?cmd=delete&order-id='+orderId,
		    			success:function(data) {
		    				if("0" == data){
		    					window.location = "../pages/order-listing.jsp";
		    				} else {
		    					alert(data);
		    				}
		    			}
		    		});
		        },
		        cancel: function () {}
		    }
		});
	}
</script>