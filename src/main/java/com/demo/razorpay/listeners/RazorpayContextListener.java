package com.demo.razorpay.listeners;

import com.demo.razorpay.models.User;
import com.demo.razorpay.models.Product;
import com.demo.razorpay.service.local.ProductLocalService;
import com.demo.razorpay.service.local.UserLocalService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.logging.Logger;

public class RazorpayContextListener implements ServletContextListener {

    private static final Logger LOGGER = Logger.getLogger(RazorpayContextListener.class.getName());


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        registerAdminUser();
        registerProducts();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    private void registerAdminUser(){
        LOGGER.info("<<<<------- Registering Admin User(s) started... ------->>>>");

        try {
            UserLocalService.deRegisterUserById("0");
        } catch(IllegalArgumentException iae){
            LOGGER.severe(iae.getMessage());
        }

        User adminUser = new User();
        adminUser.setId("0");
        adminUser.setFirstName("Admin");
        adminUser.setMiddleInitial("");
        adminUser.setLastName("Admin");
        adminUser.setEmailId("admin@demo.com");
        adminUser.setPassword("admin");

        UserLocalService.registerAdminUser(adminUser);

        LOGGER.info("<<<<------- Registering Admin User(s)  completed. ------->>>>");
    }

    private void registerProducts(){
        LOGGER.info("<<<<------- Registering Product(s) started... ------->>>>");

        try {
            ProductLocalService.deRegisterProductUsingId("1");
        } catch(IllegalArgumentException iae){
            LOGGER.severe(iae.getMessage());
        }

        Product xiaomiMiA3 = new Product();
        xiaomiMiA3.setId("1");
        xiaomiMiA3.setRowId(1);
        xiaomiMiA3.setName("Xiaomi Mi A3");
        xiaomiMiA3.setPrice(750000);
        xiaomiMiA3.setPerformance("Octa core");
        xiaomiMiA3.setDisplay("6.01\" (720 X 1560)");
        xiaomiMiA3.setStorage("64 GB");
        xiaomiMiA3.setCamera("48 + 8 + 2 | 32 MP");
        xiaomiMiA3.setBattery("4030 MAH");
        xiaomiMiA3.setRam("4 GB");
        xiaomiMiA3.setLaunchDate("April 29, 2019 (Official)");

        ProductLocalService.registerProduct(xiaomiMiA3);

        LOGGER.info("<<<<------- Registering Product(s)  completed. ------->>>>");
    }
}
