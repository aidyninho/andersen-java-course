package service;

import dao.TicketDao;
import dao.UserDao;
import jakarta.transaction.Transactional;
import model.Ticket;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserDao userDao;
    private TicketDao ticketDao;

    @Autowired
    public UserService(UserDao userDao, TicketDao ticketDao) {
        this.userDao = userDao;
        this.ticketDao = ticketDao;
    }

    public User findById(Long id) {
        User user = userDao.findById(id);
        List<Ticket> ticketsByUser = ticketDao.findTicketsByUserId(user.getId());
        user.setTickets(ticketsByUser);
        return user;
    }

    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Transactional
    public void update(User user) {
        userDao.update(user);
    }

    @Transactional
    public void delete(User user) {
        userDao.delete(user);
    }
}
