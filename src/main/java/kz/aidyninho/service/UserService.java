package kz.aidyninho.service;

import jakarta.transaction.Transactional;
import kz.aidyninho.exception.CreatableModeIsTurnedOff;
import kz.aidyninho.model.Ticket;
import kz.aidyninho.model.User;
import kz.aidyninho.repository.TicketRepository;
import kz.aidyninho.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    private TicketRepository ticketRepository;
    @Value("#{new Boolean(\"${updatable}\")}")
    private boolean updatable;

    @Autowired
    public UserService(UserRepository userRepository, TicketRepository ticketRepository) {
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
    }

    public User findById(Long id) {
        User user = userRepository.findById(id).get();
        List<Ticket> ticketsByUser = ticketRepository.findAllByUser(user);
        user.setTickets(ticketsByUser);
        return user;
    }

    @Transactional
    public void save(User user) {
        if (!updatable) {
            throw new CreatableModeIsTurnedOff();
        }
        userRepository.save(user);
    }

    @Transactional
    public void update(User user) {
        if (!updatable) {
            throw new CreatableModeIsTurnedOff();
        }
        userRepository.save(user);
    }

    @Transactional
    public void delete(User user) {
        userRepository.delete(user);
    }
}
