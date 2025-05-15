package database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    public static void main(String[] args) {
        try {
            createFile();
            createTables();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void createFile() throws IOException {
        Files.createFile(Paths.get("database.sqlite"));
    }

    private static void createTables() throws SQLException {
        Connection con = Connexio.getConnection();

        String productTable = """
                CREATE TABLE Product
                product_id INTEGER PRIMARY KEY,
                name VARCHAR2(50),
                price NUMBER(8, 2),
                """;

        String customerTable = """
                CREATE TABLE Customer
                customer_id INTEGER PRIMARY KEY,
                first_name VARCHAR2(50),
                last_name VARCHAR2(50)
                """;

        String ticketTable = """
                CREATE TABLE Ticket
                ticket_id INTEGER PRIMARY KEY,
                product_id INTEGER FOREIGN KEY REFERENCES Product,
                customer_id INTEGER FOREIGN KEY REFERENCES Customer
                """;

        Statement st = con.createStatement();
        st.executeQuery(productTable);
        st.executeQuery(customerTable);
        st.executeQuery(ticketTable);

    }
}
