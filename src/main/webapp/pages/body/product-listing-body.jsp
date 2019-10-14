<%@page import="rc.demo.app.models.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="rc.demo.app.models.session.Cart"%>
<%@page import="rc.demo.app.SessionAttributes"%>
<%@page import="rc.demo.app.models.Product"%>
<%@page import="java.util.List"%>
<%@page import="rc.demo.app.service.local.ProductLocalService"%>


<%
	User sessionUser = (User)session.getAttribute(SessionAttributes.SESSION_USER);

	Cart cart = (Cart)session.getAttribute(SessionAttributes.SESSION_CART);
	List<String> productIdsFromCart = new ArrayList<>();
	if(null != cart){
		productIdsFromCart = cart.getProductIds();
	}

	List<Product> products = ProductLocalService.fetchAllProducts();
%>

<div class="product-panel">
	<div class="product-content">
		<div class="product-content-heading">Product Listing</div>
		<%
			for(Product product : products){
				
				String id = product.getId();
				String productSpecDisplayId = String.format("product-spec-display-%s", id);
				String productInfoSliderId = String.format("%s-%s", id, "1");
				String backgroundColor = "#ffffff;";
				if(productIdsFromCart.contains(id)){
					backgroundColor = "rgb(46, 204, 113);";
				}
		%>
		<div class="product-outer-div" id="<%= id %>" style="background-color: <%= backgroundColor%>">
	    	<div class="product-inner-div">
	    		<img class="product-image" src="<%= product.getImageLocation() %>" onclick="addToOrRemoveFromCart('#<%= id %>', '<%= id %>')" onmouseenter="showOrHideInfoBar('#<%= productInfoSliderId %>')" onmouseleave="showOrHideInfoBar('#<%= productInfoSliderId %>')"/>
	    	</div>
	    	<div class="product-info-slider" id="<%= productInfoSliderId %>" onclick="showOrHideProductSpec('#<%= productSpecDisplayId %>')" onmouseenter="showOrHideInfoBar('#<%= productInfoSliderId %>')" onmouseleave="showOrHideInfoBar('#<%= productInfoSliderId %>')">
	    		<div class="product-info"></div>
	    	</div>
	    	<div id="<%= productSpecDisplayId %>" class="product-spec-display">
	    		<div class="product-spec-header">Product Specification</div>
	    		<table>
	    			<tbody>
	    				<tr>
	    					<td class="product-spec-property-name">Name</td><td class="product-spec-property-value"><%= product.getName() %></td>
	    				</tr>
	    				<tr>
	    					<td class="product-spec-property-name">Price</td><td class="product-spec-property-value"><%= product.getFormattedPrice() %></td>
	    				</tr>
	    				<tr>
	    					<td class="product-spec-property-name">Performance</td><td class="product-spec-property-value"><%= product.getPerformance() %></td>
	    				</tr>
	    				<tr>
	    					<td class="product-spec-property-name">Display</td><td class="product-spec-property-value"><%= product.getDisplay() %></td>
	    				</tr>
	    				<tr>
	    					<td class="product-spec-property-name">Storage</td><td class="product-spec-property-value"><%= product.getStorage() %></td>
	    				</tr>
	    				<tr>
	    					<td class="product-spec-property-name">Camera</td><td class="product-spec-property-value"><%= product.getCamera() %></td>
	    				</tr>
	    				<tr>
	    					<td class="product-spec-property-name">Battery</td><td class="product-spec-property-value"><%= product.getBattery() %></td>
	    				</tr>
	    				<tr>
	    					<td class="product-spec-property-name">RAM</td><td class="product-spec-property-value"><%= product.getRam() %></td>
	    				</tr>
	    				<tr>
	    					<td class="product-spec-property-name">Launch Date</td><td class="product-spec-property-value"><%= product.getLaunchDate() %></td>
	    				</tr>
	    			</tbody>
	    		</table>
    			<button type="button" onclick="addToCart('#<%= id %>', '<%= id %>')">Add to Cart</button>
	    		<img src="../images/cancel-icon.jpg" class="close" onclick="closeProductSpec('#<%= productSpecDisplayId %>')"/>
	    	</div>
	    </div>
	    <%
			}
			if(null != sessionUser){
	    %>
	    		<button type="submit" onclick="checkOut('<%= sessionUser.getId()%>')">Checkout</button>
	    <%
			} else {
		%>
				<button type="submit">Checkout</button>
		<%
			}
	    %>
	</div>
</div>

<script>

	function checkOut(userId){
		$.ajax({
			url:'../cart/checkout?cmd=checkout-cart',
			success:function(data) {
				if("0" == data){
					window.location = "../order/listing?cmd=listing&user-id="+userId;
				} else {
					alert(data);
					window.location = "../pages/login.jsp";
				}
			}
		});
	}

	function addToCart(componentId, productId){
		$.ajax({
			url:'../cart/product?cmd=add-to-cart&product-id='+productId,
			success:function(data) {
				$(componentId).css("background-color", "#2ecc71");
			}
		});
	}
	
	function addToOrRemoveFromCart(componentId, productId){
		var backgroundColor = $(componentId).css("background-color");
  		if(backgroundColor == "rgb(255, 255, 255)"){
  			$.ajax({
  				url:'../cart/product?cmd=add-to-cart&product-id='+productId,
  				success:function(data) {
  					$(componentId).css("background-color", "#2ecc71");
  				}
  			});
  		} else {
  			$.ajax({
  				url:'../cart/product?cmd=remove-from-cart&product-id='+productId,
  				success:function(data) {
  					$(componentId).css("background-color", "#ffffff");
  				}
  			});
  		}
	}
  	
  	function showOrHideInfoBar(id){
  		$(id).toggle(0);
  	}
  	
  	function showOrHideProductSpec(id){
  		var idPrefix = "#product-spec-display-";
  		for(var i = 1; i < 10; i++){
  			var actualId = idPrefix + i;
  			if(id == actualId){
  				$(actualId).css("display", "block");
  			} else {
  				$(actualId).css("display", "none");
  			}
  		}
  	}
  	
  	function closeProductSpec(id){
  		$(id).toggle(0);
  	}
</script>
