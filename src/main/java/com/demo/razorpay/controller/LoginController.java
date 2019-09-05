package com.demo.razorpay.controller;

import com.demo.razorpay.controller.helper.LoginControllerHelper;
import com.demo.razorpay.models.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginController extends LoginControllerHelper {

    private static final Logger LOGGER = Logger.getLogger(LoginController.class.getName());

    @Override
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) {
        String status = "0";
        String emailId = request.getParameter("email");
        String password = request.getParameter("password");

        User registeredUser = this.login(emailId, password);

        if(null != registeredUser){
            HttpSession httpSession =  request.getSession(true);
            httpSession.setAttribute("SESSION-USER", registeredUser);
        } else {
            status = "User not registered in the system";
        }

        try {
            response.getWriter().print(status);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            toErrorPage500(request, response);
            return;
        }
    }
}
