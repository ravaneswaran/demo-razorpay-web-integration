package com.demo.razorpay.controller.helper;

import com.demo.razorpay.controller.RazorPayController;
import com.demo.razorpay.models.OrderTransaction;
import com.demo.razorpay.service.gateway.OrderGatewayService;
import com.demo.razorpay.service.local.OrderTransactionLocalService;
import com.demo.razorpay.util.HTMLUtil;
import com.razorpay.RazorpayException;
import org.apache.commons.lang3.NotImplementedException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.logging.Logger;

public class OrderControllerHelper extends RazorPayController {

    private static final Logger LOGGER = Logger.getLogger(OrderControllerHelper.class.getName());

    @Override
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) {
        throw new NotImplementedException("'doprocess()' method should be overridden...");
    }

    protected void syncOrderTransactionsWithGateway() throws RazorpayException {
        List<OrderTransaction> orderTransactions = OrderTransactionLocalService.list();
        for(OrderTransaction orderTransaction : orderTransactions){
            OrderTransactionLocalService.delete(orderTransaction);
        }

        orderTransactions = OrderGatewayService.listOrderTransactions();
        for(OrderTransaction orderTransaction : orderTransactions){
            OrderTransactionLocalService.save(orderTransaction);
        }
    }

    protected String orderTransactionDetails(String orderTransactionId) throws RazorpayException {
        OrderTransaction orderTransaction = OrderTransactionLocalService.get(orderTransactionId);

        if(null == orderTransaction){
            orderTransaction = OrderGatewayService.fetchOrderTransaction(orderTransactionId);
            OrderTransactionLocalService.save(orderTransaction);
        }

        StringBuffer orderTransactionBuffer = new StringBuffer();

        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_START_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        orderTransactionBuffer.append("Order ID");
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        orderTransactionBuffer.append(orderTransaction.getId());
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(String.format(HTMLUtil.HTML_TABLE_DATA_START_TAG_WITH_ROWSPAN_AND_CLASS, "17", "popup-control"));
        orderTransactionBuffer.append(String.format(HTMLUtil.HTML_INPUT_BUTTON, "Confirm"));
        orderTransactionBuffer.append(String.format(HTMLUtil.HTML_INPUT_BUTTON, "Cancel"));
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_END_TAG);

        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_START_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        orderTransactionBuffer.append("Entity");
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        orderTransactionBuffer.append(orderTransaction.getEntity());
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_END_TAG);

        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_START_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        orderTransactionBuffer.append("Amount");
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        orderTransactionBuffer.append(orderTransaction.getAmount());
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_END_TAG);

        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_START_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        orderTransactionBuffer.append("Currency");
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        orderTransactionBuffer.append(orderTransaction.getCurrency());
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_END_TAG);

        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_START_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        orderTransactionBuffer.append("Status");
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        orderTransactionBuffer.append(orderTransaction.getStatus());
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_END_TAG);

        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_START_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        orderTransactionBuffer.append("Amount");
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        orderTransactionBuffer.append(orderTransaction.getAmount());
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_END_TAG);

        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_START_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        orderTransactionBuffer.append("Amount Paid");
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        orderTransactionBuffer.append(orderTransaction.getAmountPaid());
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_END_TAG);

        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_START_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        orderTransactionBuffer.append("Amount Due");
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        orderTransactionBuffer.append(orderTransaction.getAmountDue());
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_END_TAG);

        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_START_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        orderTransactionBuffer.append("Receipt");
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        orderTransactionBuffer.append(orderTransaction.getReceipt());
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_END_TAG);

        String offerId = String.valueOf(orderTransaction.getOfferId());
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_START_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        orderTransactionBuffer.append("Offer ID");
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        orderTransactionBuffer.append((null != offerId && !"null".equals(offerId) && !offerId.isEmpty()) ? offerId : "-");
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_END_TAG);

        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_START_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        orderTransactionBuffer.append("Attempts");
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        orderTransactionBuffer.append(orderTransaction.getAttempts());
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_END_TAG);

        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_START_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        orderTransactionBuffer.append("Notes");
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_START_TAG);
        orderTransactionBuffer.append("-");
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_END_TAG);

        return orderTransactionBuffer.toString();
    }
}
