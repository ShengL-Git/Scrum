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

        } catch (SQLException e) {
            System.err.println("Error");
        }

        return customers;
    }

    @Override
    public Customer read(int id) {
        String query = "SELECT * FROM Customer WHERE customerId = ?";
        Customer customer = new Customer();

        try(PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            customer.setDni(rs.getString("dni"));
            customer.setLastName(rs.getString("lastName"));
            customer.setFirstName(rs.getString("firstname"));

        } catch (SQLException e) {
            System.err.println("Error");
        }
        return customer;
    }

    @Override
    public int create(Customer customer) {
        String query = """
                INSERT INTO Customer
                (firstName, lastName, dni)
                VALUES (?, ?, ?)
                """;
        int customerId = 0;
        try(PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            customerId = ps.getGeneratedKeys().getInt(1);
        } catch (SQLException e) {
            System.err.println("Error");
        }
        return customerId;
    }

    @Override
    public void modify(int id, Customer customer) {
        String query = """
                UPDATE Customer
                SET
                firstName = ?,
                lastName = ?,
                dni = ?
                WHERE customerId = ?
                """;

        try(PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setString(3, customer.getDni());
            ps.setInt(4, customer.getCustomerId());

        } catch (SQLException e) {
            System.err.println("Error");
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM Customer WHERE customerId = ?";

        try(PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error");
        }
    }

    public static void main(String[] args) {

    }
}
