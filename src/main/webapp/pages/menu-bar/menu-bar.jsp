<%@page import="rc.demo.app.SessionAttributes"%>
<%@page import="rc.demo.app.models.User"%>
<%
	User sessionUser = (User)session.getAttribute(SessionAttributes.SESSION_USER);
	
	String homePage = "../pages/login.jsp";
	if(null != sessionUser){
		homePage = "../pages/product-listing.jsp";
	}
%>


<ul>
   <li><a href='<%= homePage%>'><span>Home</span></a></li>
   <%
   		if(null != sessionUser){
   %>
		   <li class='active has-sub'><a href='#'><span>Listing</span></a>
		      <ul>
		      	 <li class='last'><a href='../pages/product-listing.jsp'><span>Product Listing</span></a>
		         <li class='last'><a href='../pages/order-listing.jsp'><span>Order Listing</span></a>
		      </ul>
		   </li>
		   
		   <!-- <li class='active has-sub'><a href='#'><span>Sync With Gateway</span></a>
		      <ul>
		         <li class='last'><a href='../payment/transaction?cmd=sync'><span>Payment Sync</span></a></li>
		         <li class='last'><a href='../order/transaction?cmd=sync'><span>Order Sync</span></a>
		      </ul>
		   </li> -->
   <%
   		}
   %>
   
</ul>
	
