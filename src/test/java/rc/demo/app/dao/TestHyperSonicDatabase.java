package rc.demo.app.dao;

import junit.framework.TestCase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestHyperSonicDatabase extends TestCase {

    public void testHyperSonicDatabaseConnectivity() {
        Connection connection = null;
        try {
            //Registering the HSQLDB JDBC driver
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            //Creating the connection with HSQLDB
            connection = DriverManager.getConnection("jdbc:hsqldb:file:/home/fiera-mm/razorpay", "admin", "admin");
            if (connection != null) {
                System.out.println("Connection created successfully");
            } else {
                System.out.println("Problem with creating connection");
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            if(null != connection){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace(System.out);
                }
            }
        }
    }
}
