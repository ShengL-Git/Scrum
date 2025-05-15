package models;

import java.util.ArrayList;

public class Ticket {
    private int ticketId;
    private ArrayList<Products> totalPrudcts;

    public Ticket(int ticketId, ArrayList<Products> totalPrudcts) {
        this.ticketId = ticketId;
        this.totalPrudcts = totalPrudcts;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public ArrayList<Products> getTotalPrudcts() {
        return totalPrudcts;
    }

    public void setTotalPrudcts(ArrayList<Products> totalPrudcts) {
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
