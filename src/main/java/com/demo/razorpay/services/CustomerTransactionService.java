package com.demo.razorpay.services;

import com.demo.razorpay.models.CustomerTransaction;
import com.demo.razorpay.properties.RazorPayProperties;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

public class CustomerTransactionService {

    public static CustomerTransaction createCustomer() throws RazorpayException {
        RazorpayClient razorpayClient = new RazorpayClient(RazorPayProperties.getKeyId(), RazorPayProperties.getKeySecret());

        return null;
    }


}
