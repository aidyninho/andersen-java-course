package kz.aidyninho.service;

import kz.aidyninho.dao.TicketDao;
import kz.aidyninho.dao.UserDao;
import kz.aidyninho.exception.CreatableModeIsTurnedOff;
import jakarta.transaction.Transactional;
import kz.aidyninho.model.Ticket;
import kz.aidyninho.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserDao userDao;
    private TicketDao ticketDao;
    @Value("#{new Boolean(\"${updatable}\")}")
    private boolean updatable;

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
        if (!updatable) {
            throw new CreatableModeIsTurnedOff();
        }
        userDao.save(user);
    }

    @Transactional
    public void update(User user) {
        if (!updatable) {
            throw new CreatableModeIsTurnedOff();
        }
        userDao.update(user);
    }

    @Transactional
    public void delete(User user) {
        userDao.delete(user);
    }
}
