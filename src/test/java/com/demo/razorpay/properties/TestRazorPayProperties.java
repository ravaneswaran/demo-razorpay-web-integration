package com.demo.razorpay.properties;

import junit.framework.Assert;
import junit.framework.TestCase;

public class TestRazorPayProperties extends TestCase {

    public void testOperationMode() {
        String operationMode = RazorPayProperties.getOperationMode();
        Assert.assertNotNull(operationMode);
        Assert.assertEquals("development", operationMode);
    }

    public void testRazorpayKeyId() {
        String keyId = RazorPayProperties.getKeyId();
        Assert.assertNotNull(keyId);
        Assert.assertEquals("rzp_test_ChzI4JHLWDsaWo", keyId);
    }

    public void testRazorpayKeySecret() {
        String keySecret = RazorPayProperties.getKeySecret();
        Assert.assertNotNull(keySecret);
        Assert.assertEquals("9udTGs2Y2nhfJg3yicIWARFm", keySecret);
    }

    public void testGetValue() {
        String key = "operation.mode";
        String value = RazorPayProperties.getValue(key);
        Assert.assertNotNull(key);
        Assert.assertEquals("development", value);
    }
}
