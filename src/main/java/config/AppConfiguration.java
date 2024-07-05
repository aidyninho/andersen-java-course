package config;

import dao.TicketDao;
import dao.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import service.TicketService;
import service.UserService;

@Configuration
@ComponentScan
public class AppConfiguration {

    @Bean
    public UserDao userDao() {
        return new UserDao();
    }

    @Bean
    public TicketDao ticketDao() {
        return new TicketDao();
    }

    @Bean
    public UserService userService() {
        return new UserService(userDao(), ticketDao());
    }

    @Bean
    public TicketService ticketService() {
        return new TicketService(ticketDao());
    }
}
