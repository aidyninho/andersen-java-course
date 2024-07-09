import config.AppConfiguration;
import model.Ticket;
import model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.TicketService;
import service.UserService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        var applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        var userService = applicationContext.getBean(UserService.class);
        var ticketService = applicationContext.getBean(TicketService.class);

//        userService.save(User.builder()
//                .name("test")
//                .createdAt(LocalDate.now())
//                .build());

        try {
            List<Ticket> ticketsFromFile = ticketService.getTicketsFromFile(
                    applicationContext.getResource("classpath:test.txt").getFile()
            );

            System.out.println(ticketsFromFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
