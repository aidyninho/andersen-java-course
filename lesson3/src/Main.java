import model.ConcertHall;
import model.Event;
import model.Ticket;
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
        var secondTicket = new Ticket("BBB2", santiagoBernabeuStadium, kendrickLamarConcert, false, 'B');
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
        System.out.println(ticketService.getTicketById("DDD4"));
    }
}
