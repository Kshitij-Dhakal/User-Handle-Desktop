package userHandleDesktop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
//		String dbDriver = "com.mysql.jdbc.Driver";
        String dbURL = DbConfig.DB_URL;
        String dbName = DbConfig.DB_NAME;
        String dbUsername = DbConfig.DB_USERNAME;
        String dbPassword = DbConfig.DB_PASSWORD;
//		Class.forName(dbDriver);
        Connection con = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword);
        return con;
    }
}
