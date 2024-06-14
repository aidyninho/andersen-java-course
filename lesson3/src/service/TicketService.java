package service;

import model.Ticket;
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

    public Ticket getTicketById(String id) {
        return ticketRepository.getTicketById(id);
    }

    public List<Ticket> getTicketsByStadiumSector(char stadiumSector) {
        List<Ticket> tickets = new ArrayList<>();
        for (Ticket ticket : getTickets()) {
            if (stadiumSector == ticket.getStadiumSector()) {
                tickets.add(ticket);
            }
        }
        return tickets;
    }

    public List<Ticket> getTickets() {
        return new ArrayList<>(ticketRepository.getTickets().values());
    }

    public void addTicket(Ticket ticket) {
        ticketRepository.addTicket(ticket);
    }
}
