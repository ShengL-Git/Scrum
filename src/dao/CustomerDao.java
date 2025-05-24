package dao;

import database.Connexio;
import models.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements Dao<Customer> {
    private Connection con = Connexio.getConnection();

    @Override
    public List<Customer> readAll() {
        String query = "SELECT * FROM Customer";
        List<Customer> customers = new ArrayList<>();

        try(PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                int id = rs.getInt("customer_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String dni = rs.getString("dni");

                customers.add(new Customer(id, firstName, lastName, dni));
            }

            rs.close();

        } catch (SQLException e) {
            System.err.println("Error" + e);
        }

        return customers;
    }

    @Override
    public Customer read(int id) {
        String query = "SELECT * FROM Customer WHERE customer_id = ?";
        Customer customer = new Customer();

        try(PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            customer.setCustomerId(rs.getInt("customer_id"));
            customer.setDni(rs.getString("dni"));
            customer.setLastName(rs.getString("last_name"));
            customer.setFirstName(rs.getString("first_name"));

            rs.close();

        } catch (SQLException e) {
            System.err.println("Error" + e);
        }
        return customer;
    }

    @Override
    public int create(Customer customer) {
        String query = """
                INSERT INTO Customer
                (first_name, last_name, dni)
                VALUES (?, ?, ?)
                """;
        int customerId = 0;
        try(PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setString(3, customer.getDni());
            customerId = ps.getGeneratedKeys().getInt(1);

            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error" + e);
        }
        return customerId;
    }

    @Override
    public void modify(int id, Customer customer) {
        String query = """
                UPDATE Customer
                SET
                first_name = ?,
                last_name = ?,
                dni = ?
                WHERE customer_id = ?
                """;

        try(PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setString(3, customer.getDni());
            ps.setInt(4, id);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error" + e);
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM Customer WHERE customer_id = ?";

        try(PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error" + e);
        }
    }

    // pruebas (ignorar)
    public static void main(String[] args) {
        //Dao<Customer> dao = new CustomerDao();
        //System.out.println(dao.readAll());
        //System.out.println(dao.read(2));
    }
}
