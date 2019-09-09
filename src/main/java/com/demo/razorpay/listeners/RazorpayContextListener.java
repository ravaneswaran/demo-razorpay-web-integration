package com.demo.razorpay.listeners;

import com.demo.razorpay.models.Product;
import com.demo.razorpay.service.local.ProductLocalService;
import com.demo.razorpay.util.ProductUtil;
import com.demo.razorpay.util.UserUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.logging.Logger;

public class RazorpayContextListener implements ServletContextListener {

    private static final Logger LOGGER = Logger.getLogger(RazorpayContextListener.class.getName());


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        LOGGER.info("<<<<------- Registering Admin User(s) started... ------->>>>");
        UserUtil.deRegisterUserById("0");
        UserUtil.deRegisterUserById("1");

        UserUtil.registerUser("0", "Admin", "", "Admin", "admin@demo.com", "admin");
        UserUtil.registerUser("1", "Ravaneswaran", "", "Chinnasamy", "ravaneswaran@gmail.com", "welcome");
        LOGGER.info("<<<<------- Registering Admin User(s)  completed. ------->>>>");

        LOGGER.info("<<<<------- Registering Product(s) started... ------->>>>");
        ProductUtil.deRegisterUserById("1");

        ProductUtil.registerProduct("1", 1, "Xiaomi Mi A3", 750000, "Octa core", "6.01\" (720 X 1560)", "64 GB", "48 + 8 + 2 | 32 MP", "4030 MAH", "4 GB", "April 29, 2019 (Official)");
        LOGGER.info("<<<<------- Registering Product(s)  completed. ------->>>>");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
