import dao.TicketDao;
import dao.UserDao;
import model.User;
import service.TicketService;
import service.UserService;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        UserDao userDao = new UserDao();

        TicketDao ticketDao = new TicketDao();
        UserService userService = new UserService(userDao, ticketDao);
        TicketService ticketService = new TicketService(ticketDao);

        User user = User.builder()
                .name("test")
                .createdAt(LocalDate.now())
                .build();

        User user1 = userService.findById(13L);
        user1.setTickets(null);

        userService.update(user1);

    }
}
