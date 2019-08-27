package com.demo.razorpay.properties;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RazorPayProperties {

    private static final Logger LOGGER = Logger.getLogger(RazorPayProperties.class.getName());

    private static Properties razorPayProperties;

    static {
        razorPayProperties = System.getProperties();
        //loading the main property file
        try {
            razorPayProperties.load(RazorPayProperties.class.getClassLoader().getResourceAsStream("razorpay.properties"));
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }

        //loading the environment specific property files

        //loading development environment specific property file
        String operationMode = razorPayProperties.getProperty("operation.mode");

        if ("development".equals(operationMode)) {
            try {
                razorPayProperties.load(RazorPayProperties.class.getClassLoader().getResourceAsStream("razorpay-dev.properties"));
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, e.getMessage(), e);
            }
        } else if ("testing".equals(operationMode)) {
            try {
                razorPayProperties.load(RazorPayProperties.class.getClassLoader().getResourceAsStream("razorpay-test.properties"));
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, e.getMessage(), e);
            }
        } else {
            try {
                razorPayProperties.load(RazorPayProperties.class.getClassLoader().getResourceAsStream("razorpay-prod.properties"));
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, e.getMessage(), e);
            }
        }
    }

    public RazorPayProperties() {
    }

    public static final String getKeyId() {
        return razorPayProperties.getProperty("razorpay.key.id");
    }

    public static final String getKeySecret() {
        return razorPayProperties.getProperty("razorpay.key.secret");
    }

    public static String getOperationMode() {
        return razorPayProperties.getProperty("operation.mode");
    }

    public static String getValue(String key) {
        return razorPayProperties.getProperty(key);
    }
}
