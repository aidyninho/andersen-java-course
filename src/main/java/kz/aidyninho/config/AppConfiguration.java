package kz.aidyninho.config;

import kz.aidyninho.bean.MyFirstBean;
import kz.aidyninho.dao.TicketDao;
import kz.aidyninho.dao.UserDao;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
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
    @ConditionalOnProperty(prefix = "app.condition", value = "true")
    public MyFirstBean myFirstBean() {
        return new MyFirstBean();
    }
}
