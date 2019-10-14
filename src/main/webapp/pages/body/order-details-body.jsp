<%@page import="rc.demo.app.models.User"%>
<%@page import="rc.demo.app.service.gateway.OrderGatewayService"%>
<%@page import="rc.demo.app.models.OrderTransaction"%>
<%@page import="rc.demo.app.properties.ApplicationProperties"%>
<%@page import="rc.demo.app.util.NumberFormatterUtil"%>
<%@page import="rc.demo.app.models.Product"%>
<%@page import="rc.demo.app.service.local.OrderProductJoinLocalService"%>
<%@page import="rc.demo.app.models.OrderProductJoin"%>
<%@page import="java.util.List"%>
<%@page import="rc.demo.app.SessionAttributes"%>
<%@page import="rc.demo.app.models.Order"%>


<%
	Order sessionOrder = (Order)session.getAttribute(SessionAttributes.SESSION_ORDER);
	User sessionUser = (User)session.getAttribute(SessionAttributes.SESSION_USER);
%>


<div class="order-details-panel">
	<div class="order-details-content">
		<div class="order-details-content-heading">Order Details</div>
		<div class="order-details-content-body-left-panel">
			<%
				long totalPrice = 0l;
					long gst = 0l;
					if(null != sessionOrder){
			%>
					<div class="order-details-content-body-left-panel-header">Order : <%=sessionOrder.getId()%></div>
			<%
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
											<img src="<%=product.getImageLocation()%>"/>
										</td>
										<td>
											<table class="order-details-content-body-left-panel-inner-table">
												<tbody>
													<tr>
														<td class="product-spec-property-name">Name</td>
														<td class="product-spec-property-value"><%=product.getName()%></td>
														<td class="product-spec-property-name">RAM</td>
														<td class="product-spec-property-value"><%=product.getRam()%></td>
													</tr>
													<tr>
														<td class="product-spec-property-name">Battery</td>
														<td class="product-spec-property-value"><%=product.getBattery()%></td>
														<td class="product-spec-property-name">Camera</td>
														<td class="product-spec-property-value"><%=product.getCamera()%></td>
													</tr>
													<tr>
														<td class="product-spec-property-name">Performance</td>
														<td class="product-spec-property-value"><%=product.getPerformance()%></td>
														<td class="product-spec-property-name">Price</td>
														<td class="product-spec-property-value"><%=product.getFormattedPrice()%></td>
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
					}
			%>
		</div>
		<%
			String key = ApplicationProperties.getKeyId();
			    	OrderTransaction orderTransaction =  OrderGatewayService.createNewOrderTransaction(totalPrice + (2 * gst), "INR", 1, 1);
		%>
		<div class="order-details-content-body-right-panel">
			<form action="/order/transaction?cmd=new&checkout-type=auto" method="POST" class="order-details-content-body-right-panel-form-upper">
				<script
                    src="https://checkout.razorpay.com/v1/checkout.js"
                    data-key="<%= key %>"
                    data-amount="<%= orderTransaction.getAmount() %>"
                    data-currency="<%= orderTransaction.getCurrency() %>"
                    data-order_id="<%= orderTransaction.getId() %>"//This is a sample Order ID. Create an Order using Orders API. (https://razorpay.com/docs/payment-gateway/orders/integration/#step-1-create-an-order)
                    data-buttontext="Pay with Razorpay"
                    data-name="Razorpay Demo"
                    data-description="Mobile Purchase"
                    data-image="../images/rc-icon.png"
                    data-prefill.name="<%= sessionUser.getFirstName() + " " + sessionUser.getLastName() %>"
                    data-prefill.email="<%= sessionUser.getEmailId() %>"
                    data-theme.color="#b7f5a4">
                </script>
                <input type="hidden" name="order-id" value="<%= orderTransaction.getId() %>"/>
				<!-- <div class="order-details-content-body-right-panel-button">
					<img src="../images/razorpay-icon.png" />
					<input type="button" value="Pay with Razorpay"/>
				</div> -->
			</form>
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
						<td class="product-spec-property-name">SGST</td><td class="product-spec-property-value"><%= NumberFormatterUtil.getFormattedString(gst) %></td>
					</tr>
					<tr>
						<td class="product-spec-property-name"></td><td class="product-spec-property-value"></td>
					</tr>
					<tr>
						<td class="product-spec-property-name">Gross Amount</td><td class="product-spec-property-value"><%= NumberFormatterUtil.getFormattedString(totalPrice + (2 * gst)) %></td>
					</tr>
				</tbody>
			</table> 
			<form action="/order/transaction?cmd=new&checkout-type=auto" method="POST" class="order-details-content-body-right-panel-form-lower">
				<script
                    src="https://checkout.razorpay.com/v1/checkout.js"
                    data-key="<%= key %>"
                    data-amount="<%= orderTransaction.getAmount() %>"
                    data-currency="<%= orderTransaction.getCurrency() %>"
                    data-order_id="<%= orderTransaction.getId() %>"//This is a sample Order ID. Create an Order using Orders API. (https://razorpay.com/docs/payment-gateway/orders/integration/#step-1-create-an-order)
                    data-buttontext="Pay with Razorpay"
                    data-name="Razorpay Demo"
                    data-description="Mobile Purchase"
                    data-image="../images/rc-icon.png"
                    data-prefill.name="<%= sessionUser.getFirstName() + " " + sessionUser.getLastName() %>"
                    data-prefill.email="<%= sessionUser.getEmailId() %>"
                    data-theme.color="#b7f5a4">
                </script>
                <input type="hidden" name="order-id" value="<%= orderTransaction.getId() %>"/>
				<!-- <div class="order-details-content-body-right-panel-button">
					<img src="../images/razorpay-icon.png" />
					<input type="button" value="Pay with Razorpay"/>
				</div> -->
			</form>
		</div>
	</div>
</div>