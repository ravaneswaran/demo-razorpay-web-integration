package com.demo.razorpay.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RequestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpSession httpSession = httpServletRequest.getSession(false);

        Object userSession = httpSession.getAttribute("SESSION-USER");

        HttpServletResponse httpServletResponse = (HttpServletResponse)servletResponse;
        if(null != userSession){
            filterChain.doFilter(servletRequest, servletResponse);
        } /*else {
            httpServletResponse.sendRedirect("../pages/login.jsp");
        }*/
    }

    @Override
    public void destroy() {

    }
}
