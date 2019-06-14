package model.connectorhepper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectorHandel {
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if(connection == null || connection.isClosed()){
            connection = DriverManager.getConnection("jdbc:mysql://localhost/information_of_phone?user=root&password=");
        }
        return connection;
    }
}
