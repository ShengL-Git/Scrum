package dao;

import database.Connexio;
import models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements Dao<Product>{
    private Connection con = Connexio.getConnection();

    @Override
    public List<Product> readAll() {
        String query = "SELECT * FROM Product";
        List<Product> products = new ArrayList<>();

        try(PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                int id = rs.getInt("product_id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");

                products.add(new Product(id, name, price));
            }

            rs.close();

        } catch (SQLException e) {
            System.err.println("Error" + e);
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
        try(PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, product.getNameProduct());
            ps.setDouble(2, product.getPrice());
            ps.executeUpdate();
            return ps.getGeneratedKeys().getInt(1);
        } catch (SQLException e) {
            System.err.println("Error" + e);
        }
        return 0;
    }

    @Override
    public void modify(int id, Product product) {
        String query = """
                UPDATE Product
                SET
                name = ?,
                price = ?
                WHERE product_id = ?
                """;
        try(PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, product.getNameProduct());
            ps.setDouble(2, product.getPrice());
            ps.setInt(3, id);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error" + e);
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM Product WHERE product_id = ?";

        try(PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error" + e);
        }
    }

    // pruebas (ignorar)
    public static void main(String[] args) {
        Dao dao = new ProductDao();
        System.out.println(dao.readAll());
        //System.out.println(dao.create(new Product(0, "a", 200)));
        System.out.println(dao.read(1));
        //dao.modify(1, new Product(0, "test", 10000));
        //dao.delete(6);
    }
}
