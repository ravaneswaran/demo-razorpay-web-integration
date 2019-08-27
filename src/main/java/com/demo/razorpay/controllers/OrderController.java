package com.demo.razorpay.controllers;

import com.demo.razorpay.models.OrderTransaction;
import com.demo.razorpay.services.OrderTransactionService;
import com.razorpay.RazorpayException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderController extends RazorPayController {

    private static final Logger LOGGER = Logger.getLogger(OrderController.class.getName());

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) {
        String command = request.getParameter("cmd");
        switch (command) {
            case "new":
                newOrder(request, response);
                break;
        }
    }

    private void newOrder(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("--------------->>>>>>> "+request.getParameter("cmd"));
    	
    	String orderId = request.getParameter("order-id");

        OrderTransaction orderTransaction = null;
        try {
            orderTransaction = OrderTransactionService.fetchOrderTransaction(orderId);
        } catch (RazorpayException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            toErrorPage500(request, response);
            return;
        }

        if (null != orderTransaction) {

        }
    }
}
