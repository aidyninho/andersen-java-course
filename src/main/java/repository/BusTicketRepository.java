package repository;

import model.BusTicket;
import model.Type;

import java.math.BigDecimal;
import java.util.*;

public class BusTicketRepository {

    Map<Long, BusTicket> tickets;

    public BusTicketRepository() {
        this(10);
    }

    public BusTicketRepository(int capacity) {
        this.tickets = new HashMap<>(capacity);
    }

    public void addTicket(BusTicket ticket) {
        tickets.put(ticket.getId(), ticket);
    }

    public List<BusTicket> getTickets() {
        return new ArrayList<>(tickets.values());
    }

    public BusTicket removeById(long id) {
        return tickets.remove(id);
    }

    public BusTicket getById(long id) {
        return tickets.get(id);
    }

    public List<BusTicket> getTicketsByType(Type type) {
        List<BusTicket> ticketsByType = new ArrayList<>();

        for (BusTicket busTicket : tickets.values()) {
            if (busTicket.getTicketType() == type) {
                ticketsByType.add(busTicket);
            }
        }

        return ticketsByType;
    }

    public List<BusTicket> getTicketsInPriceRange(BigDecimal from, BigDecimal to) {
        List<BusTicket> ticketsByPrice = new ArrayList<>();

        for (BusTicket busTicket : tickets.values()) {
            if (busTicket.getPrice() != null
                && busTicket.getPrice().compareTo(from) >= 0
                && busTicket.getPrice().compareTo(to) <= 0) {
                ticketsByPrice.add(busTicket);
            }
        }

        return ticketsByPrice;
    }
}
