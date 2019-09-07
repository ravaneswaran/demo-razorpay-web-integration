package com.demo.razorpay.controller.helper;

import com.demo.razorpay.controller.RazorPayController;
import com.demo.razorpay.service.local.UserLocalService;
import org.apache.commons.lang3.NotImplementedException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

public class RegistrationControllerHelper extends RazorPayController {

    private static final Logger LOGGER = Logger.getLogger(RegistrationControllerHelper.class.getName());

    @Override
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) {
        throw new NotImplementedException("'doprocess()' method should be overridden...");
    }

    protected int registerUser(String firstName, String middleInitial, String lastName, String emailId, String password){
        return UserLocalService.registerUser(firstName, middleInitial, lastName, emailId, password);
    }
}
