package dao;

import database.Connexio;
import models.Customer;
import models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements Dao<Product>{
    Connection con = Connexio.getConnection();

    @Override
    public List<Product> readAll() {
        String query = "SELECT * FROM Product";
        List<Product> products = new ArrayList<>();

        try(PreparedStatement ps = con.prepareStatement(query)) {

        } catch (SQLException e) {
            System.err.println("Error");
        }

        return products;
    }

    @Override
    public Product read(int id) {
        String query = "SELECT * FROM Product WHERE product_id = ?";
        Product product = new Product();

        try(PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            product.setProductId(rs.getInt("product_id"));
            product.setNameProduct(rs.getString("name"));
            product.setPrice(rs.getFloat("price"));

        } catch (SQLException e) {
            System.err.println("Error" + e);
        }
        return product;
    }

    @Override
    public int create(Product product) {
        String query = """
                INSERT INTO Product
                (name, price)
                VALUES (?, ?)
                """;
        int customerId = 0;
        try(PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, product.getNameProduct());
            ps.setFloat(2, product.getPrice());
            ps.executeUpdate();
            customerId = ps.getGeneratedKeys().getInt(1);
        } catch (SQLException e) {
            System.err.println("Error" + e);
        }
        return customerId;
    }

    @Override
    public void modify(int id, Product product) {

    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM Product WHERE productId = ?";

        try(PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error");
        }
    }

    public static void main(String[] args) {
        Dao dao = new ProductDao();
        dao.create(new Product(0, "a", 200));
        System.out.println(dao.read(1));
    }
}
