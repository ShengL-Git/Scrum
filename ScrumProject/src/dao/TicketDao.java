package dao;

import models.Ticket;

import java.util.List;

public class TicketDao implements Dao<Ticket>{
    @Override
    public List<Ticket> readAll() {
        return List.of();
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

    }
}
