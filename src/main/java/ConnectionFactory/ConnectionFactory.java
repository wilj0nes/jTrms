package ConnectionFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
//import org.apache.log4j.Logger;

public class ConnectionFactory {

    private static ConnectionFactory cf = null;

    private ConnectionFactory(){}

    public static synchronized ConnectionFactory getInstance(){
        if (cf==null){
            cf = new ConnectionFactory();
        }
        return cf;
    }

    public Connection getConnection(){
        Connection conn = null;
        Properties prop = new Properties();

        try {
            //prop.load(new FileReader("database.properties"));
            //prop.load(ConnectionFactory.class.getResourceAsStream("database.properties"));
            //Class.forName(prop.getProperty("driver"));
//            conn = DriverManager.getConnection(
//                    prop.getProperty("url"),
//                    prop.getProperty("usr"),
//                    prop.getProperty("psw"));

            //TODO change password
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@//trms.cq3j6mhifqbt.us-east-2.rds.amazonaws.com:1521/ORCL",
                    "wiljones",
                    "jones0273");
            conn.setAutoCommit(true);

            //System.out.println(conn);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
//        catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
        return conn;
    }
}
