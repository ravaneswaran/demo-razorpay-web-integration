<%@page import="rc.demo.app.SessionAttributes"%>
<%@page import="rc.demo.app.models.User"%>

<%
	User sessionUser = (User)request.getSession().getAttribute(SessionAttributes.SESSION_USER);
	
	if(null == sessionUser){
		response.sendRedirect("../pages/login.jsp");
	}
%>