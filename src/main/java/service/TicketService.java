package service;

import dao.TicketDao;
import model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    private TicketDao ticketDao;

    @Autowired
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
