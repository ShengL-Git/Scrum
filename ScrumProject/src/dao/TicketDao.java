package dao;

import database.Connexio;
import models.Customer;
import models.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketDao implements Dao<Ticket>{
    Connection con = Connexio.getConnection();

    @Override
    public List<Ticket> readAll() {
        String query = "SELECT * FROM Ticket";
        List<Ticket> tickets = new ArrayList<>();

        try(PreparedStatement ps = con.prepareStatement(query)) {

        } catch (SQLException e) {
            System.err.println("Error");
        }

        return tickets;
    }

    @Override
    public Ticket read(int id) {
        return null;
    }

    @Override
    public int create(Ticket ticket) {
        return 0;
    }

    @Override
    public void modify(int id, Ticket ticket) {

    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM Ticket WHERE ticketId = ?";

        try(PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error");
        }
    }
}
