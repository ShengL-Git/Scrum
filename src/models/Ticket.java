package models;

import java.util.Objects;

public class Ticket {
    private int ticketId;
    private int productId;
    private int customerId;

    public Ticket(int ticketId, int productId, int customerId) {
        this.ticketId = ticketId;
        this.productId = productId;
        this.customerId = customerId;
    }

    public Ticket() {}

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Ticket{" +
               "ticketId=" + ticketId +
               ", productId=" + productId +
               ", customerId=" + customerId +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return ticketId == ticket.ticketId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ticketId);
    }
}
