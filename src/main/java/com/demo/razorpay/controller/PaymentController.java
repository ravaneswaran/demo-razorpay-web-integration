package com.demo.razorpay.controller;

import com.demo.razorpay.RequestParameter;
import com.demo.razorpay.controller.helper.PaymentControllerHelper;
import com.razorpay.RazorpayException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PaymentController extends PaymentControllerHelper {

    private static final Logger LOGGER = Logger.getLogger(PaymentController.class.getName());

    public static final String NEW = "new";

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) {
        String command = request.getParameter(RequestParameter.COMMAND);
        try {
            switch (command) {
                case NEW:
                    newPaymentTransaction(request, response);
                    break;
            }
        } catch (RazorpayException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            toErrorPage500(request, response);
            return;
        }
    }

    protected void newPaymentTransaction(HttpServletRequest request, HttpServletResponse response) throws RazorpayException {
        String checkoutType = request.getParameter(RequestParameter.CHECKOUT_TYPE);
        String paymentId = request.getParameter(RequestParameter.PAYMENT_ID);
        switch (checkoutType) {
            case AUTOMATIC:
                newAutoPaymentTransaction(paymentId);
                break;
            case MANUAL:
                newManualPaymentTransaction(paymentId);
                break;
        }
    }
}
