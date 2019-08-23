package com.demo.razorpay.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class RazorPayController extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(RazorPayController.class.getName());

    protected Properties razorPayProperties;

    public RazorPayController() {
        this.razorPayProperties = System.getProperties();
        //loading the main property file
        try {
            this.razorPayProperties.load(this.getClass().getResourceAsStream("razorpay.properties"));
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }

        //loading the environment specific property files

        //loading development environment specific property file
        String operationMode = this.razorPayProperties.getProperty("operation.mode");

        if ("development".equals(operationMode)) {
            try {
                this.razorPayProperties.load(this.getClass().getResourceAsStream("razorpay-dev.properties"));
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, e.getMessage(), e);
            }
        } else if ("testing".equals(operationMode)) {
            try {
                this.razorPayProperties.load(this.getClass().getResourceAsStream("razorpay-test.properties"));
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, e.getMessage(), e);
            }
        } else {
            try {
                this.razorPayProperties.load(this.getClass().getResourceAsStream("razorpay-prod.properties"));
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, e.getMessage(), e);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doProcess(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doProcess(request, response);
    }

    protected abstract void doProcess(HttpServletRequest request, HttpServletResponse response);
}
