package service;

import model.ConcertTicket;
import model.base.Ticket;
import repository.TicketRepository;

import java.util.ArrayList;
import java.util.List;

public class TicketService {

    TicketRepository ticketRepository;

    public TicketService() {
    }

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket getTicketById(Long id) {
        return ticketRepository.getTicketById(id);
    }

    public List<Ticket> getTickets() {
        return new ArrayList<>(ticketRepository.getTickets().values());
    }

    public void addTicket(Ticket ticket) {
        ticketRepository.addTicket(ticket);
    }
}
