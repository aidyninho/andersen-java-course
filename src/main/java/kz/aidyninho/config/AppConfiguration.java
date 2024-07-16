package kz.aidyninho.config;

import kz.aidyninho.dao.TicketDao;
import kz.aidyninho.dao.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import kz.aidyninho.service.TicketService;
import kz.aidyninho.service.UserService;

@Configuration
@ComponentScan
@PropertySources(@PropertySource("classpath:application.yml"))
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
