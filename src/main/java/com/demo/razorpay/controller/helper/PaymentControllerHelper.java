package com.demo.razorpay.controller.helper;

import com.demo.razorpay.controller.RazorPayController;
import com.demo.razorpay.models.PaymentTransaction;
import com.demo.razorpay.service.gateway.PaymentGatewayService;
import com.demo.razorpay.service.local.PaymentTransactionLocalService;
import com.razorpay.RazorpayException;
import org.apache.commons.lang3.NotImplementedException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PaymentControllerHelper extends RazorPayController {

    private static final Logger LOGGER = Logger.getLogger(PaymentControllerHelper.class.getName());

    public static final String AUTOMATIC = "auto";
    public static final String MANUAL = "manual";

    @Override
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) {
        throw new NotImplementedException("'doprocess()' method should be overridden...");
    }

    protected void newAutoPaymentTransaction(String paymentId) throws RazorpayException {
        newTransaction(paymentId, AUTOMATIC);
    }

    protected void newManualPaymentTransaction(String paymentId) throws RazorpayException {
        newTransaction(paymentId, MANUAL);
    }

    protected void deletePaymentTransaction(String paymentId){
        PaymentTransaction paymentTransaction = PaymentTransactionLocalService.get(paymentId);
        PaymentTransactionLocalService.delete(paymentTransaction);
    }

    protected void syncPaymentTransactionsWithGateway() throws RazorpayException {
        List<PaymentTransaction> paymentTransactions = PaymentTransactionLocalService.list();
        for(PaymentTransaction paymentTransaction : paymentTransactions){
            PaymentTransactionLocalService.delete(paymentTransaction);
        }

        paymentTransactions = PaymentGatewayService.listPaymentTransactions();
        for(PaymentTransaction paymentTransaction : paymentTransactions){
            PaymentTransactionLocalService.save(paymentTransaction);
        }
    }

    private void newTransaction(String paymentId, String checkoutType) throws RazorpayException {
        PaymentTransaction paymentTransaction  = PaymentGatewayService.fetchPayment(paymentId);
        paymentTransaction.setCheckoutType(checkoutType);

        if (null != paymentTransaction) {
            LOGGER.log(Level.INFO, String.format("<<<<< ===== Trying to save PaymentTransaction(%s) ===== >>>>>", paymentTransaction.getId()));
            PaymentTransactionLocalService.save(paymentTransaction);
            LOGGER.log(Level.INFO, String.format("<<<<< ===== Saved PaymentTransaction(%s) ===== >>>>>", paymentTransaction.getId()));
        }
    }
}
