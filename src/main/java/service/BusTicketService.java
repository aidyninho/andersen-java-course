package service;

import exception.IllegalPriceException;
import exception.IllegalTypeException;
import model.BusTicket;
import model.Type;
import repository.BusTicketRepository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BusTicketService {

    private BusTicketRepository ticketRepository;

    public BusTicketService(BusTicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void check(List<BusTicket> tickets) {
        Map<RuntimeException, Integer> exceptions = new HashMap<>();
        int violatedTicketsSum = 0;
        RuntimeException exception = new RuntimeException();
        int exceptionMaxCount = 0;

        for (BusTicket ticket : tickets) {
            try {
                validate(ticket);
            } catch (IllegalTypeException | IllegalPriceException e) {
                exceptions.put(e, exceptions.getOrDefault(e, 1));
                violatedTicketsSum++;
            }
        }

        for (RuntimeException e : exceptions.keySet()) {
            if (exceptions.get(e) > exceptionMaxCount) {
                exceptionMaxCount = exceptions.get(e);
                exception = e;
            }
        }

        if (!exceptions.isEmpty()) {
            System.out.printf("Total = %d\nValid = %d\nMost popular violation = %s\n",
                    tickets.size(), tickets.size() - violatedTicketsSum, exception.toString());
        }
    }

    public void add(BusTicket ticket) {
        ticketRepository.addTicket(ticket);
    }

    public List<BusTicket> getTickets() {
        return ticketRepository.getTickets();
    }
    private void validate(BusTicket ticket) {
        if ((ticket.getTicketType() == Type.PRIME || ticket.getTicketType() == Type.MONTH)
            && ticket.getStartDate() != null) {
            throw new IllegalTypeException("PRIME and MONTH type tickets can't have start date. Got " + ticket.getStartDate());
        } else if (BigDecimal.ZERO.equals(ticket.getPrice())) {
            throw new IllegalPriceException("Ticket price can't be zero.");
        }
    }
}
