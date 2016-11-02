package Clases;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB
{
    private static final String url = "jdbc:mysql://50.21.182.18:3306/Secundaria120";
    private static final String user = "root";
    private static final String pass = "Gutopia12#$";
    private final String driverClassName = "com.mysql.jdbc.Driver";
    private Connection con;
    private Statement estancia;

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException ex) {}
        return DriverManager.getConnection(url, user, pass);
    }

    public void conectar() throws SQLException {
        try {
            Class.forName(this.driverClassName).newInstance();
            this.con = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException err) {
            System.out.println("Error " + err.getMessage());
        }
    }
    
    public void cierraConexion() throws SQLException {
        this.con.close();
    }
    
    public ResultSet consulta(String query) throws SQLException {
        this.estancia = (Statement) con.createStatement();
        return this.estancia.executeQuery(query);
    }

}