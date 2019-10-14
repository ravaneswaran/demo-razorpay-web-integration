<%@page import="rc.demo.app.SessionAttributes"%>
<%@page import="rc.demo.app.models.User"%>

<%
	User sessionUser = (User)session.getAttribute(SessionAttributes.SESSION_USER);
	String homePage = "../pages/login.jsp";
	
	if(null != sessionUser){
		homePage = "../pages/product-listing.jsp";
	}
%>


<ul style="width:75px;">
    <li><a href="<%= homePage%>">Home</a></li>
</ul>

<%
	if(null != sessionUser){
%>
		<ul style="width:165px;">
		    <li>Listings</li>
		    <ul>
		       <li><a href="../pages/product-listing.jsp">Product Listing</a></li>
		       <li><a href="../pages/order-listing.jsp">Order Listing</a></li>
		   </ul>
		</ul>
<%
	}
%>
