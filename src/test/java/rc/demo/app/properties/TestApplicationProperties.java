package rc.demo.app.properties;

import junit.framework.Assert;
import junit.framework.TestCase;
import rc.demo.app.properties.ApplicationProperties;

public class TestApplicationProperties extends TestCase {

    public void testOperationMode() {
        String operationMode = ApplicationProperties.getOperationMode();
        Assert.assertNotNull(operationMode);
        Assert.assertEquals("development", operationMode);
    }

    public void testRazorpayKeyId() {
        String keyId = ApplicationProperties.getKeyId();
        Assert.assertNotNull(keyId);
        Assert.assertEquals("rzp_test_ChzI4JHLWDsaWo", keyId);
    }

    public void testRazorpayKeySecret() {
        String keySecret = ApplicationProperties.getKeySecret();
        Assert.assertNotNull(keySecret);
        Assert.assertEquals("9udTGs2Y2nhfJg3yicIWARFm", keySecret);
    }

    public void testGetValue() {
        String key = "operation.mode";
        String value = ApplicationProperties.getValue(key);
        Assert.assertNotNull(key);
        Assert.assertEquals("development", value);
    }
}
