package com.demo.razorpay.properties;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RazorPayProperties extends Properties {

    private static final Logger LOGGER = Logger.getLogger(RazorPayProperties.class.getName());

    private RazorPayProperties(){
        try {
            this.load(this.getClass().getResourceAsStream("razorpay-dev.properties"));
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }

}
