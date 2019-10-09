package com.demo.razorpay.controller;

import com.demo.razorpay.controller.helper.RegistrationControllerHelper;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistrationController extends RegistrationControllerHelper {
	
	private static final long serialVersionUID = 1L;

    private static final Logger LOGGER = Logger.getLogger(RegistrationController.class.getName());

    @Override
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) {

        String firstName = request.getParameter("firstname");
        String middleInitial = request.getParameter("middleinitial");
        String lastName = request.getParameter("lastname");
        String emailId = request.getParameter("emailid");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmpassword");

        int status = validateRequestParameters(firstName, middleInitial, lastName, emailId, password, confirmPassword);

        if(0 == status){
            status = registerUser(firstName, middleInitial, lastName, emailId, password);
            try {
                switch(status) {
                    case 0:
                        response.getWriter().print(status);
                        break;
                    case -1:
                        response.getWriter().print("You already registered with us...");
                        break;
                }
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, e.getMessage(), e);
                toErrorPage500(request, response);
                return;
            }
        } else {
            try {
                switch(status) {
                    case -1:
                        response.getWriter().print("Your firstname cannot be blank...");
                        break;
                    case -2:
                        response.getWriter().print("You email id cannot be blank...");
                        break;
                    case -3:
                        response.getWriter().print("Your password cannot be blank...");
                        break;
                    case -4:
                        response.getWriter().print("Your confirm password cannot be blank...");
                        break;
                    case -5:
                        response.getWriter().print("Password and Confirm Password should match...");
                        break;
                }
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, e.getMessage(), e);
                toErrorPage500(request, response);
                return;
            }
        }
    }

    private int validateRequestParameters(String firstName, String middleInitial, String lastName, String emailId, String password, String confirmPassword){

        if(StringUtils.isEmpty(firstName)){
            return -1;
        }

        if(StringUtils.isEmpty(emailId)){
            return -2;
        }

        if(StringUtils.isEmpty(password)){
            return -3;
        }

        if(StringUtils.isEmpty(confirmPassword)){
            return -4;
        }

        if(!password.equals(confirmPassword)){
            return -5;
        }

        return 0;
    }
}