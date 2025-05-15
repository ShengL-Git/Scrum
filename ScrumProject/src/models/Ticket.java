package models;

import java.util.ArrayList;

public class Ticket {
    private int ticketId;
    private ArrayList<Product> totalPrudcts;

    public Ticket(int ticketId, ArrayList<Product> totalPrudcts) {
        this.ticketId = ticketId;
        this.totalPrudcts = totalPrudcts;
    }

    public Ticket() {}

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public ArrayList<Product> getTotalPrudcts() {
        return totalPrudcts;
    }

    public void setTotalPrudcts(ArrayList<Product> totalPrudcts) {
        this.totalPrudcts = totalPrudcts;
    }

    @Override
    public String toString() {
        return "models.Ticket{" +
                "ticketId=" + ticketId +
                ", totalPrudcts=" + totalPrudcts +
                '}';
    }
}
