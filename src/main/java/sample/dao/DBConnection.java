package sample.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection
{
    private static final String HOST="127.0.0.1";
    private static int PORT = 3306;
    private static String DB_NAME = "college";
    private static String USERNAME = "root";
    private static String PASSWORD = "";

    private static Connection connection;

    public static Connection getConnection()
    {
        try
        {
            connection = DriverManager.getConnection (String.format ("jdbc:mysql://%s:%d/%s",HOST,PORT,DB_NAME),USERNAME,PASSWORD);
        }
        catch (SQLException Se)
        {
            Se.printStackTrace ();
        }
        return connection;
    }

}
