<%@page import="com.demo.razorpay.models.Product"%>
<%@page import="com.demo.razorpay.service.local.OrderProductJoinLocalService"%>
<%@page import="com.demo.razorpay.models.OrderProductJoin"%>
<%@page import="java.util.List"%>
<%@page import="com.demo.razorpay.SessionAttributes"%>
<%@page import="com.demo.razorpay.models.Order"%>


<%
	Order sessionOrder = (Order)session.getAttribute(SessionAttributes.SESSION_ORDER);
%>


<div class="order-details-panel">
	<div class="order-details-content">
		<div class="order-details-content-heading">Order Details</div>
		<div class="order-details-content-body-right-panel">
			<div class="order-details-content-body-right-panel-header">Order : <%= sessionOrder.getId() %></div>
			<%
				List<OrderProductJoin> orderProductJoins = OrderProductJoinLocalService.listOrderProductJoinsByOrderId(sessionOrder.getId());
				if(null != orderProductJoins && !orderProductJoins.isEmpty()){
					for(OrderProductJoin orderProductJoin : orderProductJoins){
						Product product = orderProductJoin.getProduct();
			%>
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
			<%
					}
				}
			%>
		</div>
		<div class="order-details-content-body-left-panel">
			<div class="order-details-content-body-left-panel-button">
				<img src="../images/razorpay-icon.png" />
				<input type="button" value="Pay with Razorpay"/>
			</div>
		</div>
	</div>
</div>