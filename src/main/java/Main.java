import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.BusTicket;
import repository.BusTicketRepository;
import service.BusTicketService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws JsonProcessingException {

        BusTicketService busTicketService = new BusTicketService(new BusTicketRepository(10));
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            BusTicket ticket = new ObjectMapper().readValue(scanner.nextLine(), BusTicket.class);
            busTicketService.add(ticket);
        }

        busTicketService.check(busTicketService.getTickets());
    }
}
