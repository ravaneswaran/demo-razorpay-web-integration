package com.demo.razorpay.listeners;

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
        ProductUtil.deRegisterUserById("2");
        ProductUtil.deRegisterUserById("3");
        ProductUtil.deRegisterUserById("4");
        ProductUtil.deRegisterUserById("5");
        ProductUtil.deRegisterUserById("6");
        ProductUtil.deRegisterUserById("7");
        ProductUtil.deRegisterUserById("8");
        ProductUtil.deRegisterUserById("9");

        ProductUtil.registerProduct("1", 1, "Xiaomi Mi A3", 750000, "Octa core", "6.01\" (720 X 1560)", "64 GB", "48 + 8 + 2 | 32 MP", "4030 mAh", "4 GB", "April 29, 2019 (Official)");
        ProductUtil.registerProduct("2", 1, "Xiaomi Mi Play", 1150000, "MediaTek Helio P35", "5.84-inch", "64 GB", "12MP + 2MP", "3000 mAh", "4 GB", "December 2018");
        ProductUtil.registerProduct("3", 1, "Xiaomi Readmi 7", 1250000, "Octa core", "6.26\" (15.9 cm)", "32 GB", "12MP + 2MP", "4000 mAh", "2 GB", "April 29, 2019 (Official)");

        ProductUtil.registerProduct("4", 2, "Xiaomi Mi A3", 750000, "Octa core", "6.01\" (720 X 1560)", "64 GB", "48 + 8 + 2 | 32 MP", "4030 mAh", "4 GB", "April 29, 2019 (Official)");
        ProductUtil.registerProduct("5", 2, "Xiaomi Mi Play", 1150000, "MediaTek Helio P35", "5.84-inch", "64 GB", "12MP + 2MP", "3000 mAh", "4 GB", "December 2018");
        ProductUtil.registerProduct("6", 2, "Xiaomi Readmi 7", 1250000, "Octa core", "6.26\" (15.9 cm)", "32 GB", "12MP + 2MP", "4000 mAh", "2 GB", "April 29, 2019 (Official)");

        ProductUtil.registerProduct("7", 3, "Xiaomi Mi A3", 750000, "Octa core", "6.01\" (720 X 1560)", "64 GB", "48 + 8 + 2 | 32 MP", "4030 mAh", "4 GB", "April 29, 2019 (Official)");
        ProductUtil.registerProduct("8", 3, "Xiaomi Mi Play", 1150000, "MediaTek Helio P35", "5.84-inch", "64 GB", "12MP + 2MP", "3000 mAh", "4 GB", "December 2018");
        ProductUtil.registerProduct("9", 3, "Xiaomi Readmi 7", 1250000, "Octa core", "6.26\" (15.9 cm)", "32 GB", "12MP + 2MP", "4000 mAh", "2 GB", "April 29, 2019 (Official)");

        LOGGER.info("<<<<------- Registering Product(s)  completed. ------->>>>");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
