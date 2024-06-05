package service;

import model.ConcertHall;
import model.Event;
import model.Ticket;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TicketService {

    public static void main(String[] args) {
        var santiagoBernabeuStadium = new ConcertHall(
                "Santiago Bernabéu Stadium",
                5.0
        );
        var kendrickLamarConcert = new Event(
                "1234",
                "Kendrick Lamar concert",
                LocalDateTime.of(2024, 6, 6, 18, 0),
                new BigDecimal("99.99")
        );

        var emptyTicket = new Ticket();
        var fullTicket = new Ticket("AAA1", santiagoBernabeuStadium, kendrickLamarConcert, false, 'J');
        var limitedTicket = new Ticket(santiagoBernabeuStadium, kendrickLamarConcert);

        System.out.println(emptyTicket);
        System.out.println(fullTicket);
        System.out.println(limitedTicket);
    }
}
