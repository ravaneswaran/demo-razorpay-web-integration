package rc.demo.app.properties;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApplicationProperties {

    private static final Logger LOGGER = Logger.getLogger(ApplicationProperties.class.getName());

    private static Properties razorPayProperties;

    static {
        razorPayProperties = System.getProperties();
        //loading the main property file
        try {
            razorPayProperties.load(ApplicationProperties.class.getClassLoader().getResourceAsStream("app.properties"));
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }

        //loading the environment specific property files

        //loading development environment specific property file
        String operationMode = razorPayProperties.getProperty("operation.mode");

        if ("development".equals(operationMode)) {
            try {
                razorPayProperties.load(ApplicationProperties.class.getClassLoader().getResourceAsStream("app-dev.properties"));
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, e.getMessage(), e);
            }
        } else if ("testing".equals(operationMode)) {
            try {
                razorPayProperties.load(ApplicationProperties.class.getClassLoader().getResourceAsStream("app-test.properties"));
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, e.getMessage(), e);
            }
        } else {
            try {
                razorPayProperties.load(ApplicationProperties.class.getClassLoader().getResourceAsStream("app-prod.properties"));
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, e.getMessage(), e);
            }
        }
    }

    public ApplicationProperties() {
    }

    public static final String getKeyId() {
        return razorPayProperties.getProperty("razorpay.key.id");
    }

    public static final String getKeySecret() {
        return razorPayProperties.getProperty("razorpay.key.secret");
    }

    public static String getOperationMode() {
        return razorPayProperties.getProperty("operation.mode");
    }

    public static String getValue(String key) {
        return razorPayProperties.getProperty(key);
    }
}
