package com.demo.razorpay.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogOutController extends RazorPayController{
	
	private static final long serialVersionUID = 1L;

    private static final Logger LOGGER = Logger.getLogger(LogOutController.class.getName());

    @Override
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) {
        HttpSession httpSession = request.getSession(false);

        if(null != httpSession){
            httpSession.invalidate();
        }

        try {
            response.sendRedirect("../pages/login.jsp");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            toErrorPage500(request, response);
            return;
        }
    }
}
