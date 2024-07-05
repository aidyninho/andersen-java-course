package dao;

import model.Ticket;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import util.SessionFactoryManager;

import java.util.List;

@Component
public class TicketDao {

    public Ticket findById(Long id) {

        try (var session = SessionFactoryManager.get().openSession()) {
            return session.get(Ticket.class, id);
        }
    }

    public List<Ticket> findTicketsByUserId(Long id) {

        try (var session = SessionFactoryManager.get().openSession()) {
            Ticket ticket = session.get(Ticket.class, id);

            Query query = session.createQuery("select t from tickets t where t.user.id = " + id);
            return query.list();
        }
    }

    public void save(Ticket ticket) {
        try (var session = SessionFactoryManager.get().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(ticket);
            transaction.commit();
        }
    }

    public void update(Ticket ticket) {
        try (var session = SessionFactoryManager.get().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(ticket);
            transaction.commit();
        }
    }

    public void delete(Ticket ticket) {
        try (var session = SessionFactoryManager.get().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(ticket);
            transaction.commit();
        }
    }
}
