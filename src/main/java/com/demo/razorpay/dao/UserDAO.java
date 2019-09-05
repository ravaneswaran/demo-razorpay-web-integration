package com.demo.razorpay.dao;

import com.demo.razorpay.models.User;

import javax.persistence.Query;
import java.util.List;

public class UserDAO extends AbstractDAO<User>{

    public UserDAO() {
        super(User.class);
    }

    public User findBy(String emailId, String password){
        Query query = this.getEntityManager().createQuery("SELECT u FROM User AS u WHERE u.emailId = :emailId AND u.password = :password");
        query.setParameter("emailId", emailId);
        query.setParameter("password", password);

        List<User> users = query.getResultList();

        if(!users.isEmpty()){
            return (User)query.getResultList().get(0);
        } else {
            return null;
        }
    }
}
