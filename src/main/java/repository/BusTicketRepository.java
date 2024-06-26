package repository;

import model.BusTicket;

import java.util.ArrayList;
import java.util.List;

public class BusTicketRepository {

    List<BusTicket> tickets;

    public BusTicketRepository() {
        this(10);
    }

    public BusTicketRepository(int capacity) {
        this.tickets = new ArrayList<>(capacity);
    }

    public void addTicket(BusTicket ticket) {
        tickets.add(ticket);
    }

    public List<BusTicket> getTickets() {
        return tickets;
    }
}
