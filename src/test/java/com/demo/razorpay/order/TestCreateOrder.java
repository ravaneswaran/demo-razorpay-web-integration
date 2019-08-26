package com.demo.razorpay.order;

import com.demo.razorpay.models.OrderTransaction;
import com.razorpay.RazorpayException;
import junit.framework.Assert;
import junit.framework.TestCase;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class TestCreateOrder extends TestCase {

    public void testCreate() throws IOException, RazorpayException, JAXBException {
        OrderTransaction razorpayOrderTransaction = CreateOrder.create(50000, "INR", 1, 1);
        Assert.assertNotNull(razorpayOrderTransaction);
    }

    /*public void testCreateInst() throws IOException, RazorpayException, JAXBException {
        OrderTransaction razorpayOrder = new OrderTransaction();
        OrderTransaction.marshall(razorpayOrder);
        Assert.assertNotNull(razorpayOrder);
    }*/

}
