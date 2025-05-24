package dao;

import database.Connexio;
import models.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketDao implements Dao<Ticket>{
    private Connection con = Connexio.getConnection();

    @Override
    public List<Ticket> readAll() {
        String query = "SELECT * FROM Tickets";
        List<Ticket> tickets = new ArrayList<>();

        try(PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                int ticketId = rs.getInt("ticket_id");
                int productId = rs.getInt("product_id");
                int customerId = rs.getInt("customer_id");

                tickets.add(new Ticket(ticketId, productId, customerId));
            }

            rs.close();

        } catch (SQLException e) {
            System.err.println("Error");
        }

        return tickets;
    }

    @Override
    public Ticket read(int id) {
        String query = "SELECT * FROM Tickets WHERE ticket_id = ?";

        try(PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            int ticketId = rs.getInt("ticket_id");
            int productId = rs.getInt("product_id");
            int customerId = rs.getInt("customer_id");

            return new Ticket(ticketId, productId, customerId);


        } catch (SQLException e) {
            System.err.println("Error: " + e);
        }
        return null;
    }

    @Override
    public int create(Ticket ticket) {
        String query = """
                INSERT INTO Tickets
                (product_id, customer_id)
                VALUES (?, ?)
                """;

        try(PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, ticket.getProductId());
            ps.setInt(2, ticket.getCustomerId());

            ps.executeUpdate();

            return ps.getGeneratedKeys().getInt(1);

        } catch (SQLException e) {
            System.err.println("Error: " + e);
        }
        return 0;
    }

    @Override
    public void modify(int id, Ticket ticket) {
        String query = """
                UPDATE Tickets
                SET
                product_id = ?,
                customer_id = ?
                WHERE ticket_id = ?
                """;

        try(PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, ticket.getProductId());
            ps.setInt(2, ticket.getCustomerId());
            ps.setInt(3, id);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error: " + e);
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM Tickets WHERE ticket_id = ?";

        try(PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error");
        }
    }

    // pruebas (ignorar)
    public static void main(String[] args) {
        Dao<Ticket> ticketDao = new TicketDao();
        System.out.println(ticketDao.readAll());
        //System.out.println(ticketDao.read(2));
        //ticketDao.modify(2, new Ticket(0, 1, 100));
        //ticketDao.delete(2);
    }
}
