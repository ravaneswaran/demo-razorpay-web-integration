package com.demo.razorpay.controller;

import com.demo.razorpay.RequestParameter;
import com.demo.razorpay.controller.helper.PaymentControllerHelper;
import com.razorpay.RazorpayException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PaymentController extends PaymentControllerHelper {
	
	private static final long serialVersionUID = 1L;

    private static final Logger LOGGER = Logger.getLogger(PaymentController.class.getName());

    public static final String NEW = "new";
    public static final String DELETE = "delete";
    public static final String SYNC = "sync";
    public static final String DETAILS = "details";
    public static final String REFUND = "refund";
    public static final String SETTLE = "settle";

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) {
        String command = request.getParameter(RequestParameter.COMMAND);
        try {
            switch (command) {
                case NEW:
                    newPaymentTransaction(request, response);
                    break;
                case DELETE:
                    deletePaymentTransaction(request, response);
                    break;
                case SYNC:
                    syncPaymentTransactionsWithGateway(request, response);
                    break;
                case DETAILS:
                    paymentTransactionsDetails(request, response);
                    break;
                case REFUND:
                    refundPaymentTransaction(request, response);
                    break;
                case SETTLE:
                    settlePaymentTransaction(request, response);
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
        String paymentId = request.getParameter(RequestParameter.PAYMENT_TRANSACTION_ID);
        switch (checkoutType) {
            case AUTOMATIC:
                newAutoPaymentTransaction(paymentId);
                break;
            case MANUAL:
                newManualPaymentTransaction(paymentId);
                break;
        }
    }

    protected void deletePaymentTransaction(HttpServletRequest request, HttpServletResponse response) throws RazorpayException {
        String paymentId = request.getParameter(RequestParameter.PAYMENT_TRANSACTION_ID);
        deletePaymentTransaction(paymentId);
        try {
            response.sendRedirect("../pages/list-payments.jsp");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            toErrorPage500(request, response);
            return;
        }
    }

    protected void syncPaymentTransactionsWithGateway(HttpServletRequest request, HttpServletResponse response) throws RazorpayException {
        syncPaymentTransactionsWithGateway();
        try {
            response.sendRedirect("../pages/list-payments.jsp");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            toErrorPage500(request, response);
            return;
        }
    }

    protected void paymentTransactionsDetails(HttpServletRequest request, HttpServletResponse response) throws RazorpayException {
        String paymentTransactionId = request.getParameter(RequestParameter.PAYMENT_TRANSACTION_ID);
        String paymentTransactionDetails = paymentTransactionDetails(paymentTransactionId);
        response.setContentType("text/html");
        try {
            response.getWriter().print(paymentTransactionDetails);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            toErrorPage500(request, response);
            return;
        }
    }

    protected void refundPaymentTransaction(HttpServletRequest request, HttpServletResponse response) throws RazorpayException {
        String paymentTransactionId = request.getParameter(RequestParameter.PAYMENT_TRANSACTION_ID);
        String paymentTransactionDetails = refundPaymentTransaction(paymentTransactionId);

        response.setContentType("text/html");
        try {
            response.getWriter().print(paymentTransactionDetails);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            toErrorPage500(request, response);
            return;
        }
    }

    protected void settlePaymentTransaction(HttpServletRequest request, HttpServletResponse response) throws RazorpayException {
        String paymentTransactionId = request.getParameter(RequestParameter.PAYMENT_TRANSACTION_ID);
        String paymentTransactionDetails = settlePaymentTransaction(paymentTransactionId);

        response.setContentType("text/html");
        try {
            response.getWriter().print(paymentTransactionDetails);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            toErrorPage500(request, response);
            return;
        }
    }
}
