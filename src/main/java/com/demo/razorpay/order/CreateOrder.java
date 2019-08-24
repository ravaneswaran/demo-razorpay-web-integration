package com.demo.razorpay.order;

import com.demo.razorpay.models.RazorpayOrder;
import com.demo.razorpay.properties.RazorPayProperties;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class CreateOrder {

    public static RazorpayOrder create(int amount, String currency, int receiptNumber, int paymentCapture) throws IOException, RazorpayException, JAXBException {
        RazorpayClient razorpayClient = new RazorpayClient(RazorPayProperties.getKeyId(),RazorPayProperties.getKeySecret());

        JSONObject orderCreateRequest = new JSONObject();

        orderCreateRequest.put("amount", amount);
        orderCreateRequest.put("currency", currency);
        orderCreateRequest.put("receipt", String.format("Receipt #%s", receiptNumber));
        orderCreateRequest.put("payment_capture", paymentCapture);

        Order newOrder = razorpayClient.Orders.create(orderCreateRequest);

        System.out.println("---------------->>>>>>>> "+newOrder.toString());

        return null;

        //return RazorpayOrder.create(newOrder.toString());
        //return razorpayClient.Orders.create(orderCreateRequest);
    }
}
