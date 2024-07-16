package util;

import model.Ticket;
import model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class SessionFactoryManager {

    private static final SessionFactory SESSION_FACTORY;

    static {
        try {
            var configuration = new Configuration();
            configuration.configure();
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Ticket.class);

            SESSION_FACTORY = configuration.buildSessionFactory();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public SessionFactoryManager() {
    }

    public static SessionFactory get() {
        return SESSION_FACTORY;
    }
}
