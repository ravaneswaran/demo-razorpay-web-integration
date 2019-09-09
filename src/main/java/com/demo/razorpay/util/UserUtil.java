package com.demo.razorpay.util;

import com.demo.razorpay.models.User;
import com.demo.razorpay.service.local.UserLocalService;

import java.util.logging.Logger;

public class UserUtil {

    private static final Logger LOGGER = Logger.getLogger(UserUtil.class.getName());

    public static final int registerUser(String id, String firstName, String middleInitial, String lastName, String emailId, String password){

        User adminUser = new User();
        adminUser.setId(id);
        adminUser.setFirstName(firstName);
        adminUser.setMiddleInitial(middleInitial);
        adminUser.setLastName(lastName);
        adminUser.setEmailId(emailId);
        adminUser.setPassword(password);

        return UserLocalService.registerUser(adminUser);

    }

    public static final int deRegisterUserById(String id){
        try {
            return UserLocalService.deRegisterUserById(id);
        } catch(IllegalArgumentException iae){
            LOGGER.severe(iae.getMessage());
            return -1;
        }
    }
}
