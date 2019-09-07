package com.demo.razorpay.controller;

import com.demo.razorpay.controller.helper.RegistrationControllerHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistrationController extends RegistrationControllerHelper {

    private static final Logger LOGGER = Logger.getLogger(RegistrationController.class.getName());

    @Override
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) {

        String firstName = request.getParameter("firstname");
        String middleInitial = request.getParameter("middleinitial");
        String lastName = request.getParameter("lastname");
        String emailId = request.getParameter("emailid");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmpassword");

        int status = registerUser(firstName, middleInitial, lastName, emailId, password);

        try {
            response.getWriter().print(status);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            toErrorPage500(request, response);
            return;
        }
    }
}