package rc.demo.app.controller.helper;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.NotImplementedException;

import com.razorpay.RazorpayException;

import rc.demo.app.controller.RazorPayController;
import rc.demo.app.models.Order;
import rc.demo.app.models.OrderProductJoin;
import rc.demo.app.models.OrderTransaction;
import rc.demo.app.service.gateway.OrderGatewayService;
import rc.demo.app.service.local.OrderLocalService;
import rc.demo.app.service.local.OrderProductJoinLocalService;
import rc.demo.app.service.local.OrderTransactionLocalService;
import rc.demo.app.util.HTMLUtil;

public class OrderControllerHelper extends RazorPayController {

	private static final long serialVersionUID = 1L;

    @Override
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) {
        throw new NotImplementedException("'doprocess()' method should be overridden...");
    }

    /********************************/

    protected int deleteOrder(String orderId) throws RazorpayException {
        List<OrderProductJoin> orderProductJoins = OrderProductJoinLocalService.listOrderProductJoinsByOrderId(orderId);

        if(null != orderProductJoins && !orderProductJoins.isEmpty()){
            for(OrderProductJoin orderProductJoin : orderProductJoins){
                OrderProductJoinLocalService.delete(orderProductJoin);
            }
        }

        Order order = OrderLocalService.fetchOrderById(orderId);
        OrderLocalService.purge(order);

        return 0;
    }

    /********************************/

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

        return getOrderTransactionDetails(orderTransaction, "color:#6c6c6c");
    }

    protected String cancelOrderTransaction(String orderTransactionId) throws RazorpayException {
        OrderTransaction orderTransaction = OrderTransactionLocalService.get(orderTransactionId);

        if(null == orderTransaction){
            orderTransaction = OrderGatewayService.fetchOrderTransaction(orderTransactionId);
            OrderTransactionLocalService.save(orderTransaction);
        }

        return getOrderTransactionDetails(orderTransaction, "color:#e74c3c");
    }

    protected void cancelOrder(String orderTransactionId) throws RazorpayException {



        OrderTransaction orderTransaction = OrderTransactionLocalService.get(orderTransactionId);

        if(null == orderTransaction){
            orderTransaction = OrderGatewayService.fetchOrderTransaction(orderTransactionId);
            OrderTransactionLocalService.save(orderTransaction);
        }
    }

    protected String confirmOrderTransaction(String orderTransactionId) throws RazorpayException {
        OrderTransaction orderTransaction = OrderTransactionLocalService.get(orderTransactionId);

        if(null == orderTransaction){
            orderTransaction = OrderGatewayService.fetchOrderTransaction(orderTransactionId);
            OrderTransactionLocalService.save(orderTransaction);
        }

        return getOrderTransactionDetails(orderTransaction, "color:#209c20");
    }

    private String getOrderTransactionDetails(OrderTransaction orderTransaction, String style){
        StringBuffer orderTransactionBuffer = new StringBuffer();

        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_START_TAG);
        orderTransactionBuffer.append(String.format(HTMLUtil.HTML_TABLE_DATA_START_TAG_WITH_STYLE, style));
        orderTransactionBuffer.append("Order ID");
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(String.format(HTMLUtil.HTML_TABLE_DATA_START_TAG_WITH_STYLE, style));
        orderTransactionBuffer.append(orderTransaction.getId());
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(String.format(HTMLUtil.HTML_TABLE_DATA_START_TAG_WITH_ROWSPAN_AND_CLASS, "17", "popup-control"));
        String confirmOrderTransactionFunction = String.format("confirmOrder('%s')", orderTransaction.getId());
        orderTransactionBuffer.append(String.format(HTMLUtil.HTML_INPUT_BUTTON, confirmOrderTransactionFunction, "Confirm"));
        String cancelOrderTransactionFunction = String.format("cancelOrder('%s')", orderTransaction.getId());
        orderTransactionBuffer.append(String.format(HTMLUtil.HTML_INPUT_BUTTON, cancelOrderTransactionFunction, "Cancel"));
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_END_TAG);

        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_START_TAG);
        orderTransactionBuffer.append(String.format(HTMLUtil.HTML_TABLE_DATA_START_TAG_WITH_STYLE, style));
        orderTransactionBuffer.append("Entity");
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(String.format(HTMLUtil.HTML_TABLE_DATA_START_TAG_WITH_STYLE, style));
        orderTransactionBuffer.append(orderTransaction.getEntity());
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_END_TAG);

        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_START_TAG);
        orderTransactionBuffer.append(String.format(HTMLUtil.HTML_TABLE_DATA_START_TAG_WITH_STYLE, style));
        orderTransactionBuffer.append("Amount");
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(String.format(HTMLUtil.HTML_TABLE_DATA_START_TAG_WITH_STYLE, style));
        orderTransactionBuffer.append(orderTransaction.getAmount());
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_END_TAG);

        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_START_TAG);
        orderTransactionBuffer.append(String.format(HTMLUtil.HTML_TABLE_DATA_START_TAG_WITH_STYLE, style));
        orderTransactionBuffer.append("Currency");
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(String.format(HTMLUtil.HTML_TABLE_DATA_START_TAG_WITH_STYLE, style));
        orderTransactionBuffer.append(orderTransaction.getCurrency());
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_END_TAG);

        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_START_TAG);
        orderTransactionBuffer.append(String.format(HTMLUtil.HTML_TABLE_DATA_START_TAG_WITH_STYLE, style));
        orderTransactionBuffer.append("Status");
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(String.format(HTMLUtil.HTML_TABLE_DATA_START_TAG_WITH_STYLE, style));
        orderTransactionBuffer.append(orderTransaction.getStatus());
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_END_TAG);

        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_START_TAG);
        orderTransactionBuffer.append(String.format(HTMLUtil.HTML_TABLE_DATA_START_TAG_WITH_STYLE, style));
        orderTransactionBuffer.append("Amount");
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(String.format(HTMLUtil.HTML_TABLE_DATA_START_TAG_WITH_STYLE, style));
        orderTransactionBuffer.append(orderTransaction.getAmount());
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_END_TAG);

        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_START_TAG);
        orderTransactionBuffer.append(String.format(HTMLUtil.HTML_TABLE_DATA_START_TAG_WITH_STYLE, style));
        orderTransactionBuffer.append("Amount Paid");
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(String.format(HTMLUtil.HTML_TABLE_DATA_START_TAG_WITH_STYLE, style));
        orderTransactionBuffer.append(orderTransaction.getAmountPaid());
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_END_TAG);

        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_START_TAG);
        orderTransactionBuffer.append(String.format(HTMLUtil.HTML_TABLE_DATA_START_TAG_WITH_STYLE, style));
        orderTransactionBuffer.append("Amount Due");
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(String.format(HTMLUtil.HTML_TABLE_DATA_START_TAG_WITH_STYLE, style));
        orderTransactionBuffer.append(orderTransaction.getAmountDue());
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_END_TAG);

        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_START_TAG);
        orderTransactionBuffer.append(String.format(HTMLUtil.HTML_TABLE_DATA_START_TAG_WITH_STYLE, style));
        orderTransactionBuffer.append("Receipt");
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(String.format(HTMLUtil.HTML_TABLE_DATA_START_TAG_WITH_STYLE, style));
        orderTransactionBuffer.append(orderTransaction.getReceipt());
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_END_TAG);

        String offerId = String.valueOf(orderTransaction.getOfferId());
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_START_TAG);
        orderTransactionBuffer.append(String.format(HTMLUtil.HTML_TABLE_DATA_START_TAG_WITH_STYLE, style));
        orderTransactionBuffer.append("Offer ID");
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(String.format(HTMLUtil.HTML_TABLE_DATA_START_TAG_WITH_STYLE, style));
        orderTransactionBuffer.append((null != offerId && !"null".equals(offerId) && !offerId.isEmpty()) ? offerId : "-");
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_END_TAG);

        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_START_TAG);
        orderTransactionBuffer.append(String.format(HTMLUtil.HTML_TABLE_DATA_START_TAG_WITH_STYLE, style));
        orderTransactionBuffer.append("Attempts");
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(String.format(HTMLUtil.HTML_TABLE_DATA_START_TAG_WITH_STYLE, style));
        orderTransactionBuffer.append(orderTransaction.getAttempts());
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_END_TAG);

        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_START_TAG);
        orderTransactionBuffer.append(String.format(HTMLUtil.HTML_TABLE_DATA_START_TAG_WITH_STYLE, style));
        orderTransactionBuffer.append("Notes");
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(String.format(HTMLUtil.HTML_TABLE_DATA_START_TAG_WITH_STYLE, style));
        orderTransactionBuffer.append("-");
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_DATA_END_TAG);
        orderTransactionBuffer.append(HTMLUtil.HTML_TABLE_ROW_END_TAG);

        return orderTransactionBuffer.toString();
    }
}
