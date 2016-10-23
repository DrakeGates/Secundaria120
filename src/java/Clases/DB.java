package Clases;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class DB
{
    private static final String URL = "jdbc:mysql://50.21.182.18:3306/Secundaria120";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Gutopia12#$";
    
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException ex) {}
        return DriverManager.getConnection("jdbc:mysql://50.21.182.18:3306/Secundaria120", "root", "Gutopia12#$");
    }
}