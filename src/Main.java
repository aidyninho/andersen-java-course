import model.*;
import model.base.User;
import repository.TicketRepository;
import service.TicketService;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        var ticketRepository = new TicketRepository();
        var ticketService = new TicketService(ticketRepository);

        var santiagoBernabeuStadium = new ConcertHall(
                "Bernabéu",
                5.0
        );
        var kendrickLamarConcert = new Event(
                "123",
                "Kendrick concert",
                LocalDateTime.of(2024, 6, 6, 18, 0),
                new BigDecimal("99.99")
        );

        var firstTicket = new Ticket("AAA1", santiagoBernabeuStadium, kendrickLamarConcert, false, 'A');
        var secondTicket = new Ticket("BBB2", santiagoBernabeuStadium, kendrickLamarConcert, false, 'A');
        var thirdTicket = new Ticket("CCC3", santiagoBernabeuStadium, kendrickLamarConcert, false, 'C');

        System.out.println(ticketService.getTickets());
        System.out.println(ticketService.getTickets().size());

        ticketService.addTicket(firstTicket);
        ticketService.addTicket(secondTicket);
        ticketService.addTicket(thirdTicket);

        System.out.println(ticketService.getTickets());
        System.out.println(ticketService.getTickets().size());

        System.out.println(ticketService.getTicketById("AAA1"));
        System.out.println(ticketService.getTicketById("BBB2"));

        System.out.println(ticketService.getTicketsByStadiumSector('A').size());
        System.out.println(ticketService.getTicketsByStadiumSector('C').size());
        System.out.println(ticketService.getTicketsByStadiumSector('B').size());

        firstTicket.print();

        firstTicket.share("+777777777");
        firstTicket.share("+777777777", "test@andersen.com");

        var client = new Client(1);
        var admin = new Admin(1);

        client.printRole();
        admin.printRole();

        System.out.println(client.getTickets().size());
        System.out.println(admin.checkTicket(firstTicket));
    }
}
