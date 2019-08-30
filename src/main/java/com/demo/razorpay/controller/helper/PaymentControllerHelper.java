package com.demo.razorpay.controller.helper;

import com.demo.razorpay.controller.RazorPayController;
import com.demo.razorpay.models.PaymentTransaction;
import com.demo.razorpay.service.gateway.PaymentGatewayService;
import com.demo.razorpay.service.local.PaymentTransactionLocalService;
import com.demo.razorpay.util.DateUtil;
import com.demo.razorpay.util.HTMLUtil;
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

    private void newTransaction(String paymentId, String checkoutType) throws RazorpayException {
        PaymentTransaction paymentTransaction  = PaymentGatewayService.fetchPayment(paymentId);
        paymentTransaction.setCheckoutType(checkoutType);

        if (null != paymentTransaction) {
            LOGGER.log(Level.INFO, String.format("<<<<< ===== Trying to save PaymentTransaction(%s) ===== >>>>>", paymentTransaction.getId()));
            PaymentTransactionLocalService.save(paymentTransaction);
            LOGGER.log(Level.INFO, String.format("<<<<< ===== Saved PaymentTransaction(%s) ===== >>>>>", paymentTransaction.getId()));
        }
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

    protected String paymentTransactionsDetails(String paymentTransactionId){
        PaymentTransaction paymentTransaction = PaymentTransactionLocalService.get(paymentTransactionId);
        StringBuffer paymentTransactionBuffer = new StringBuffer();

        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_START_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        paymentTransactionBuffer.append("Payment ID");
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        paymentTransactionBuffer.append(paymentTransaction.getId());
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);

        paymentTransactionBuffer.append(String.format(HTMLUtil.HTML_TABLE_DATA_START_TAG_WITH_ROWSPAN_AND_CLASS, "17", "popup-control"));
        paymentTransactionBuffer.append(String.format(HTMLUtil.HTML_INPUT_BUTTON, "Refund"));
        paymentTransactionBuffer.append(String.format(HTMLUtil.HTML_INPUT_BUTTON, "Settle"));
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);

        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_END_TAG);

        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_START_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        paymentTransactionBuffer.append("Entity");
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        paymentTransactionBuffer.append(paymentTransaction.getEntity());
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_END_TAG);

        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_START_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        paymentTransactionBuffer.append("Amount");
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        paymentTransactionBuffer.append(paymentTransaction.getAmount());
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_END_TAG);

        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_START_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        paymentTransactionBuffer.append("Currency");
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        paymentTransactionBuffer.append(paymentTransaction.getCurrency());
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_END_TAG);

        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_START_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        paymentTransactionBuffer.append("Status");
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        paymentTransactionBuffer.append(paymentTransaction.getStatus());
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_END_TAG);

        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_START_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        paymentTransactionBuffer.append("Method");
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        paymentTransactionBuffer.append(paymentTransaction.getMethod());
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_END_TAG);

        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_START_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        paymentTransactionBuffer.append("Order ID");
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        paymentTransactionBuffer.append(paymentTransaction.getOrderId());
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_END_TAG);

        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_START_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        paymentTransactionBuffer.append("Description");
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        paymentTransactionBuffer.append(paymentTransaction.getDescription());
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_END_TAG);

        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_START_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        paymentTransactionBuffer.append("Amount Refunded");
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        paymentTransactionBuffer.append(paymentTransaction.getAmountRefunded());
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_END_TAG);

        String refundStatus = paymentTransaction.getRefundStatus();
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_START_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        paymentTransactionBuffer.append("Refund Status");
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        paymentTransactionBuffer.append((null != refundStatus && !"null".equals(refundStatus) && !refundStatus.isEmpty()) ? refundStatus : "-");
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_END_TAG);

        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_START_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        paymentTransactionBuffer.append("Email");
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        paymentTransactionBuffer.append(paymentTransaction.getEmail());
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_END_TAG);

        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_START_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        paymentTransactionBuffer.append("Notes");
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        paymentTransactionBuffer.append("-");
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_END_TAG);

        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_START_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        paymentTransactionBuffer.append("Fee");
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        paymentTransactionBuffer.append(paymentTransaction.getFee());
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_END_TAG);

        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_START_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        paymentTransactionBuffer.append("Tax");
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        paymentTransactionBuffer.append(paymentTransaction.getTax());
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_END_TAG);

        String errorCode = paymentTransaction.getErrorCode();
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_START_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        paymentTransactionBuffer.append("Error Code");
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        paymentTransactionBuffer.append((null != errorCode && !"null".equals(errorCode) && !errorCode.isEmpty()) ? errorCode : "-");
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_END_TAG);

        String errorDescription = paymentTransaction.getErrorDescription();
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_START_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        paymentTransactionBuffer.append("Error Description");
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        paymentTransactionBuffer.append((null != errorDescription && !"null".equals(errorDescription) && !errorDescription.isEmpty()) ? errorDescription : "-");
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_END_TAG);

        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_START_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        paymentTransactionBuffer.append("Created At");
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        paymentTransactionBuffer.append(DateUtil.getDate(paymentTransaction.getCreatedAt()));
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        paymentTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_END_TAG);

        return paymentTransactionBuffer.toString();
    }
}
