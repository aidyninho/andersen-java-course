package kz.aidyninho.dao;

import kz.aidyninho.model.User;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import kz.aidyninho.util.SessionFactoryManager;

@Component
public class UserDao {

    public User findById(Long id) {

        try (var session = SessionFactoryManager.get().openSession()) {
            User user = session.get(User.class, id);
            return user;
        }
    }

    public void save(User user) {
        try (var session = SessionFactoryManager.get().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
        }
    }

    public void update(User user) {
        try (var session = SessionFactoryManager.get().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(user);
            transaction.commit();
        }
    }

    public void delete(User user) {
        try (var session = SessionFactoryManager.get().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(user);
            transaction.commit();
        }
    }
}
