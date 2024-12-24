package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/inventory_db";
    private static final String DB_USER = "neelima";
    private static final String DB_PASSWORD = "Password@123";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public static void closeResources(Connection connection){
        try{
            if(connection != null)
                connection.close();
        }catch(SQLException e){
            System.out.print("Error closing connection: "+ e.getMessage());
        }
    }
}
