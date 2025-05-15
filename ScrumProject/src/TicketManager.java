import models.Product;
import models.Ticket;

import java.util.ArrayList;

public class TicketManager {
    ArrayList<Ticket> tickets = new ArrayList<>();

    public void allTickets() {
        for (Ticket ticket : tickets) {
            System.out.println(ticket);
        }
    }
    public void checkTicketById(int ticketId) {
        for (Ticket ticket : tickets) {
            if (ticket.getTicketId() == ticketId) {
                System.out.println(ticket);
                break;
            }
        }
    }
    public void deleteTicketById(int ticketId) {
        for (Ticket ticket : tickets) {
            if (ticket.getTicketId() == ticketId) {
                tickets.remove(ticket);
                break;
            }
        }
    }

    public void createTicket(ArrayList<Product> totalProducts, int totalPrice, String establishment) {
        Ticket ticket = new Ticket(tickets.size()+1, totalProducts);
        tickets.add(ticket);
    }
}
