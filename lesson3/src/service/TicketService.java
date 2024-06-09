package service;

import model.Ticket;
import repository.TicketRepository;

import java.util.ArrayList;

public class TicketService {

    TicketRepository ticketRepository;

    public TicketService() {
    }

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public ArrayList<Ticket> getTickets() {
        return new ArrayList<>(ticketRepository.getTickets().values());
    }

    public void addTicket(Ticket ticket) {
        ticketRepository.addTicket(ticket);
    }
}
