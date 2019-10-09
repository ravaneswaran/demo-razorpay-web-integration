package com.demo.razorpay.controller;

import com.demo.razorpay.RequestParameter;
import com.demo.razorpay.controller.helper.PasswordControllerHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PasswordController extends PasswordControllerHelper {
	
	private static final long serialVersionUID = 1L;

    private static final Logger LOGGER = Logger.getLogger(PasswordController.class.getName());

    public static final String FORGOT_PASSWORD = "forgot-password";

    @Override
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) {
        String command = request.getParameter(RequestParameter.COMMAND);
        switch (command) {
            case FORGOT_PASSWORD:
                forgotPassword(request, response);
                break;
        }
    }

    protected void forgotPassword(HttpServletRequest request, HttpServletResponse response){
        String email = request.getParameter(RequestParameter.EMAIL);
        String password = getUserPassword(email);
        try {
            if(null != password) {
                String loginLink = String.format("Your password is : %s <a href=\"%s\">( Use this password here... )</a>", password, "../pages/login.jsp");

                StringBuffer responseBuffer = new StringBuffer();
                responseBuffer.append(loginLink);

                response.getWriter().println(responseBuffer.toString());
            } else {
                String registerLink = String.format("Sorry!!! You are yet to register... <a href=\"%s\">( Go here... )</a>", "../pages/user-registration.jsp");
                response.getWriter().print(registerLink);
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            toErrorPage500(request, response);
            return;
        }
    }
}
