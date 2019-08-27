package com.demo.razorpay.services;

import com.demo.razorpay.models.OrderTransaction;
import com.demo.razorpay.properties.RazorPayProperties;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Date;

public class OrderTransactionService {

    public static OrderTransaction createNewOrderTransaction(int amount, String currency, int receiptNumber, int paymentCapture) throws IOException, RazorpayException, JAXBException {
        
    	RazorpayClient razorpayClient = new RazorpayClient(RazorPayProperties.getKeyId(), RazorPayProperties.getKeySecret());

        JSONObject orderCreateRequest = new JSONObject();

        orderCreateRequest.put("amount", amount);
        orderCreateRequest.put("currency", currency);
        orderCreateRequest.put("receipt", String.format("Receipt #%s", receiptNumber));
        orderCreateRequest.put("payment_capture", paymentCapture);

        Order newOrder = razorpayClient.Orders.create(orderCreateRequest);

        OrderTransaction razorpayOrder = new OrderTransaction();
        razorpayOrder.setAmount(Integer.valueOf("" + newOrder.get("amount")));
        razorpayOrder.setAmountPaid(Integer.valueOf("" + newOrder.get("amount_paid")));
        razorpayOrder.setNotes(newOrder.get("notes"));
        razorpayOrder.setCreatedAt(((Date) newOrder.get("created_at")).getTime());
		razorpayOrder.setAmountDue(Integer.valueOf("" + newOrder.get("amount_due")));
		razorpayOrder.setCurrency(String.valueOf(newOrder.get("currency")));
        razorpayOrder.setReceipt(String.valueOf(newOrder.get("receipt")));
        razorpayOrder.setId(String.valueOf(newOrder.get("id")));
        razorpayOrder.setEntity(String.valueOf(newOrder.get("entity")));
        razorpayOrder.setOfferId(newOrder.get("offer_id"));
        razorpayOrder.setStatus(String.valueOf(newOrder.get("status")));
        razorpayOrder.setAmountDue(Integer.valueOf("" + newOrder.get("attempts")));

        return razorpayOrder;
    }

    public static OrderTransaction fetchOrderTransaction(String orderId) throws RazorpayException {
        
    	RazorpayClient razorpayClient = new RazorpayClient(RazorPayProperties.getKeyId(), RazorPayProperties.getKeySecret());

        Order oldOrder = razorpayClient.Orders.fetch(orderId);

        OrderTransaction razorpayOrder = new OrderTransaction();
        razorpayOrder.setAmount(Integer.valueOf("" + oldOrder.get("amount")));
        razorpayOrder.setAmountPaid(Integer.valueOf("" + oldOrder.get("amount_paid")));
        razorpayOrder.setNotes(oldOrder.get("notes"));
        razorpayOrder.setCreatedAt(((Date) oldOrder.get("created_at")).getTime());
        razorpayOrder.setAmountDue(Integer.valueOf("" + oldOrder.get("amount_due")));
        razorpayOrder.setCurrency(String.valueOf(oldOrder.get("currency")));
        razorpayOrder.setReceipt(String.valueOf(oldOrder.get("receipt")));
        razorpayOrder.setId(String.valueOf(oldOrder.get("id")));
        razorpayOrder.setEntity(String.valueOf(oldOrder.get("entity")));
        razorpayOrder.setOfferId(oldOrder.get("offer_id"));
        razorpayOrder.setStatus(String.valueOf(oldOrder.get("status")));
        razorpayOrder.setAmountDue(Integer.valueOf("" + oldOrder.get("attempts")));

        return razorpayOrder;
    }
}
