package repository;

import model.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {

    Map<String, Ticket> tickets;

    public TicketRepository() {
        this(10);
    }

    public TicketRepository(int capacity) {
        this.tickets = new HashMap<>(capacity);
    }

    public void addTicket(Ticket ticket) {
        tickets.put(ticket.getId(), ticket);
    }

    public Ticket getTicketById(String id) {
        if (!tickets.containsKey(id)) {
            throw new IllegalArgumentException("Ticket with id " + id + " not found");
        }
        return tickets.get(id);
    }

    public Map<String, Ticket> getTickets() {
        return tickets;
    }
}