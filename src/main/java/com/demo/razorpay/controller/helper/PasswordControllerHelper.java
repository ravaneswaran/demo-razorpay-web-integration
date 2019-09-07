package com.demo.razorpay.controller.helper;

import com.demo.razorpay.controller.RazorPayController;
import com.demo.razorpay.models.User;
import com.demo.razorpay.service.local.UserLocalService;
import org.apache.commons.lang3.NotImplementedException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

public class PasswordControllerHelper extends RazorPayController {

    private static final Logger LOGGER = Logger.getLogger(PasswordControllerHelper.class.getName());

    @Override
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) {
        throw new NotImplementedException("'doprocess()' method should be overridden...");
    }

    protected String getUserPassword(String email){
        User user = UserLocalService.fetchUserBy(email);
        if(null != user){
            return user.getPassword();
        }
        return null;
    }
}
