package com.demo.razorpay.controller;

import com.demo.razorpay.RequestParameter;
import com.demo.razorpay.controller.helper.PasswordControllerHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PasswordController extends PasswordControllerHelper {

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
                response.getWriter().println(password);
            } else {
                response.getWriter().print("-1");
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            toErrorPage500(request, response);
            return;
        }
    }
}
