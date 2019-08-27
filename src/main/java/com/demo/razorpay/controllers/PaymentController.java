package com.demo.razorpay.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.razorpay.models.OrderTransaction;
import com.demo.razorpay.models.PaymentTransaction;
import com.demo.razorpay.services.OrderTransactionService;
import com.demo.razorpay.services.PaymentTransactionService;
import com.razorpay.RazorpayException;

public class PaymentController extends RazorPayController{
	
	private static final Logger LOGGER = Logger.getLogger(PaymentController.class.getName());

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) {
        String command = request.getParameter("cmd");
        switch (command) {
            case "new":
            	newPaymentTransaction(request, response);
                break;
        }
    }

    private void newPaymentTransaction(HttpServletRequest request, HttpServletResponse response) {
    	String paymentId = request.getParameter("paymentId");

        PaymentTransaction paymentTransaction = null;
        try {
            paymentTransaction = PaymentTransactionService.fetchPaymentTransaction(paymentId);
        } catch (RazorpayException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            toErrorPage500(request, response);
            return;
        }

        if (null != paymentTransaction) {

        }
    }
}
