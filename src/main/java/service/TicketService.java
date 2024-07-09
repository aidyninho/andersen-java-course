package service;

import dao.TicketDao;
import jakarta.transaction.Transactional;
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

    @Transactional
    public void save(Ticket ticket) {
        ticketDao.save(ticket);
    }

    @Transactional
    public void update(Ticket ticket) {
        ticketDao.update(ticket);
    }

    @Transactional
    public void delete(Ticket ticket) {
        ticketDao.delete(ticket);
    }
}
