package service;

import dao.TicketDao;
import model.Ticket;

public class TicketService {

    private TicketDao ticketDao;

    public TicketService(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    public Ticket findById(Long id) {
        return ticketDao.findById(id);
    }

    public void save(Ticket ticket) {
        ticketDao.save(ticket);
    }

    public void update(Ticket ticket) {
        ticketDao.update(ticket);
    }

    public void delete(Ticket ticket) {
        ticketDao.delete(ticket);
    }
}
