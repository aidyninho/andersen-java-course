import model.*;
import model.base.Ticket;
import repository.TicketRepository;
import service.TicketService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {

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

        var firstTicket = new ConcertTicket(1L, santiagoBernabeuStadium, kendrickLamarConcert, false, 'A');

        firstTicket.print();

        firstTicket.share("+777777777");
        firstTicket.share("+777777777", "test@andersen.com");

        var client = new Client(1);
        var admin = new Admin(1);

        client.printRole();
        admin.printRole();

        System.out.println(LocalDate.parse("2025-01-01"));
    }
}
