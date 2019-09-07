package com.demo.razorpay.service.local;

import com.demo.razorpay.dao.UserDAO;
import com.demo.razorpay.models.User;

import java.util.UUID;

public class UserLocalService {

    private static final UserDAO USER_DAO = new UserDAO();

    public static int registerUser(String firstName, String middleInitial, String lastName, String emailId, String password){

        String id = UUID.randomUUID().toString();

        User user = new User();
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setMiddleInitial(middleInitial);
        user.setEmailId(emailId);
        user.setPassword(password);

        USER_DAO.save(user);

        return 0;
    }

    public static User fetchUserBy(String emailId, String password){
        return USER_DAO.findBy(emailId, password);
    }

    public static User fetchUserBy(String emailId){
        return USER_DAO.findBy(emailId);
    }
}
