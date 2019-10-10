package com.demo.razorpay.listeners;

import com.demo.razorpay.models.User;
import com.demo.razorpay.service.local.ProductLocalService;
import com.demo.razorpay.service.local.UserLocalService;
import com.demo.razorpay.util.ProductUtil;
import com.demo.razorpay.util.UserUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RazorpayContextListener implements ServletContextListener {

	private static final Logger LOGGER = Logger.getLogger(RazorpayContextListener.class.getName());

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {

		Properties properties = System.getProperties();
		String tempDirectoryPath = properties.getProperty("java.io.tmpdir");
		String databaseFileNameAbsolutePathPath = String.format("/%s/%s", tempDirectoryPath, "razorpay");

		File databaseFile = new File(databaseFileNameAbsolutePathPath);
		if (!databaseFile.exists()) {
			try {
				databaseFile.createNewFile();
			} catch (IOException e) {
				LOGGER.log(Level.SEVERE, e.getMessage(), e);
			}
		}

		try {

			boolean hasUsers = UserLocalService.hasUsers();
			if (!hasUsers) {
				LOGGER.info("<<<<------- Registering Admin User(s) started... ------->>>>");
				UserUtil.deRegisterUserById("0");

				UserUtil.registerUser("0", "Admin", "", "Admin", "admin@demo.com", "admin", User.ADMIN_USER);
				LOGGER.info("<<<<------- Registering Admin User(s)  completed. ------->>>>");
			}

			boolean hasProducts = ProductLocalService.hasProducts();
			if (!hasProducts) {
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

				ProductUtil.registerProduct("1", 1, "Xiaomi Mi A3", 1299900, "12999.00", "Octa core",
						"6.01\" (720 X 1560)", "64 GB", "48 + 8 + 2 | 32 MP", "4030 mAh", "4 GB",
						"April 29, 2019 (Official)", "../images/products/xiaomi-mi-a3.jpeg");
				ProductUtil.registerProduct("2", 1, "Xiaomi Mi Play", 1150000, "11500.00", "MediaTek Helio P35",
						"5.84-inch", "64 GB", "12MP + 2MP", "3000 mAh", "4 GB", "December 2018",
						"../images/products/xiaomi-mi-play.jpeg");
				ProductUtil.registerProduct("3", 1, "Xiaomi Readmi 7", 1250000, "12500.00", "Octa core",
						"6.26\" (15.9 cm)", "32 GB", "12MP + 2MP", "4000 mAh", "2 GB", "April 29, 2019 (Official)",
						"../images/products/xiaomi-redmi-7.jpeg");

				ProductUtil.registerProduct("4", 2, "Moto G6", 750000, "7500.00", "Snapdragon 450",
						"5.70-inch (1080x2160)", "64 GB", "16 MP  12 +5 MP", "3000 mAh", "4 GB", "April 2018",
						"../images/products/motorola-g6.jpeg");
				ProductUtil.registerProduct("5", 2, "Motorola Moto G7", 1150000, "11500.00", "Qualcomm Snapdragon 632",
						"6.20-inch (1080x2270)", "64 GB", "8MP 12 + 5 MP", "3000 mAh", "4 GB", "February 2019",
						"../images/products/motorola-moto-g7.jpeg");
				ProductUtil.registerProduct("6", 2, "Motorola Razr", 1799900, "17999.00", "Octa core",
						"6.2\" (15.75 cm)", "64 GB", "12 MP", "2730 mAh", "4 GB", "October 24, 2019 (Unofficial)",
						"../images/products/motorola-razr.jpeg");

				ProductUtil.registerProduct("7", 3, "Apple iPhone 5s", 1895000, "18950.00", "Apple A7",
						"4.00-inch (640x1136)", "16 GB", "1.2MP 8MP", "1570 mAh", "1 GB", "September 2013",
						"../images/products/iphone-5s.jpeg");
				ProductUtil.registerProduct("8", 3, "Apple iPhone 6s", 2250000, "22500.00", "Dual core, 1.84 GHz",
						"4.7\" (11.94 cm)", "64 GB", "12 MP", "1715 mAh", "2 GB", "December 2018",
						"../images/products/iphone-6s.jpeg");
				ProductUtil.registerProduct("9", 3, "Apple iPhone 7", 2690000, "26900.00", "Apple A10 Fusion",
						"4.70-inch (750x1334)", "32 GB", "12MP + 7MP", "1960 mAh", "2 GB", "September 2016",
						"../images/products/iphone-7.jpeg");

				LOGGER.info("<<<<------- Registering Product(s)  completed. ------->>>>");
			}

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {

	}
}
