package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexio {

    private static Connection con = null;
    public static Connection getConnection()
    {
        if (con == null ){
            try {
                Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection("jdbc:sqlite:scrumDB1.sqlite");
            }
            catch (ClassNotFoundException | SQLException e) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
            }
            System.out.println("Opened database successfully");
        }
        return con;
    }
}