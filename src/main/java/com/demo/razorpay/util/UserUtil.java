package com.demo.razorpay.util;

import com.demo.razorpay.models.User;
import com.demo.razorpay.service.local.UserLocalService;

import java.util.Date;
import java.util.logging.Logger;

public class UserUtil {

    private static final Logger LOGGER = Logger.getLogger(UserUtil.class.getName());

    public static final int registerUser(String id, String firstName, String middleInitial, String lastName, String emailId, String password, String type){

        User user = new User();
        user.setId(id);
        user.setFirstName(firstName);
        user.setMiddleInitial(middleInitial);
        user.setLastName(lastName);
        user.setEmailId(emailId);
        user.setPassword(password);
        user.setType(type);

        Date date = new Date();
        user.setCreatedDate(date);
        user.setModifiedDate(date);

        return UserLocalService.registerUser(user);

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
