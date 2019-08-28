package com.demo.razorpay.controller.helper;

import com.demo.razorpay.controller.RazorPayController;
import com.demo.razorpay.dao.PaymentTransactionDAO;
import com.demo.razorpay.models.PaymentTransaction;
import com.demo.razorpay.services.PaymentTransactionService;
import com.razorpay.RazorpayException;
import org.apache.commons.lang3.NotImplementedException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PaymentControllerHelper extends RazorPayController {

    private static final Logger LOGGER = Logger.getLogger(PaymentControllerHelper.class.getName());

    public static final String AUTOMATIC = "auto";
    public static final String MANUAL = "manual";

    @Override
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) {
        throw new NotImplementedException("'doprocess() method should be overridden...");
    }

    protected void newAutoPaymentTransaction(String paymentId) throws RazorpayException {
        newTransaction(paymentId, AUTOMATIC);
    }

    protected void newManualPaymentTransaction(String paymentId) throws RazorpayException {
        newTransaction(paymentId, MANUAL);
    }

    private void newTransaction(String paymentId, String checkoutType) throws RazorpayException {
        PaymentTransaction paymentTransaction  = PaymentTransactionService.fetchPaymentTransaction(paymentId);
        paymentTransaction.setCheckoutType(checkoutType);

        if (null != paymentTransaction) {
            LOGGER.log(Level.INFO, String.format("<<<<< ===== Trying to save PaymentTransaction(%s) ===== >>>>>", paymentTransaction.getId()));
            PaymentTransactionDAO paymentTransactionDAO = new PaymentTransactionDAO();
            paymentTransactionDAO.save(paymentTransaction);
            LOGGER.log(Level.INFO, String.format("<<<<< ===== Saved PaymentTransaction(%s) ===== >>>>>", paymentTransaction.getId()));
        }
    }
}
