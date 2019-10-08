<%@page import="com.demo.razorpay.util.NumberFormatterUtil"%>
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
		<div class="order-details-content-body-left-panel">
			<div class="order-details-content-body-left-panel-header">Order : <%= sessionOrder.getId() %></div>
			<%
				long totalPrice = 0l;
				long gst = 0l;
				
				List<OrderProductJoin> orderProductJoins = OrderProductJoinLocalService.listOrderProductJoinsByOrderId(sessionOrder.getId());
				if(null != orderProductJoins && !orderProductJoins.isEmpty()){
					for(OrderProductJoin orderProductJoin : orderProductJoins){
						Product product = orderProductJoin.getProduct();
						totalPrice += product.getPrice();
						gst += (product.getPrice() * 5) / 100;
			%>
						<table class="order-details-content-body-left-panel-outer-table">
							<tbody>
								<tr>
									<td colspan="3" class="order-details-content-body-left-panel-outer-table-image" style="border: 0px solid red;width:100px;">
										<img src="<%= product.getImageLocation()%>"/>
									</td>
									<td>
										<table class="order-details-content-body-left-panel-inner-table">
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
									</td> 
								</tr>
							</tbody>
						</table>
			<%
					}
				}
			%>
		</div>
		<div class="order-details-content-body-right-panel">
			<div class="order-details-content-body-right-panel-button">
				<img src="../images/razorpay-icon.png" />
				<input type="button" value="Pay with Razorpay"/>
			</div>
			<table>
				<tbody>
					<tr>
						<td colspan="2" class="header">Cheque Details</td>
					</tr>
					<tr>
						<td class="product-spec-property-name">Amount</td><td class="product-spec-property-value"><%= NumberFormatterUtil.getFormattedString(totalPrice) %></td>
					</tr>
					<tr>
						<td class="product-spec-property-name">GST %</td><td class="product-spec-property-value">10</td>
					</tr>
					<tr>
						<td class="product-spec-property-name">CGST</td><td class="product-spec-property-value"><%= NumberFormatterUtil.getFormattedString(gst) %></td>
					</tr>
					<tr>
						<td class="product-spec-property-name">SGsT</td><td class="product-spec-property-value"><%= NumberFormatterUtil.getFormattedString(gst) %></td>
					</tr>
					<tr>
						<td class="product-spec-property-name"></td><td class="product-spec-property-value"></td>
					</tr>
					<tr>
						<td class="product-spec-property-name">Gross Amount</td><td class="product-spec-property-value"><%= NumberFormatterUtil.getFormattedString(totalPrice + (2 * gst)) %></td>
					</tr>
				</tbody>
			</table>
			<div class="order-details-content-body-right-panel-button">
				<img src="../images/razorpay-icon.png" />
				<input type="button" value="Pay with Razorpay"/>
			</div>
		</div>
	</div>
</div>