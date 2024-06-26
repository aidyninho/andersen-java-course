import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.BusTicket;
import repository.BusTicketRepository;
import service.BusTicketService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws JsonProcessingException {

        BusTicketService busTicketService = new BusTicketService(new BusTicketRepository(10));
//        checkFromConsole(busTicketService);
        checkFromFile(busTicketService);

        System.out.println(busTicketService.getById(0));;
        busTicketService.removeById(0);
        System.out.println(busTicketService.getById(0));

        System.out.println(busTicketService.getTicketsInPriceRange("10", "50"));
        System.out.println(busTicketService.getTicketsInPriceRange("0", "10000"));

    }

    private static void checkFromFile(BusTicketService busTicketService) throws JsonProcessingException {
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/test.txt"));
            while (scanner.hasNextLine()) {
                BusTicket ticket = new ObjectMapper().readValue(scanner.nextLine(), BusTicket.class);
                busTicketService.add(ticket);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static void checkFromConsole(BusTicketService busTicketService) throws JsonProcessingException {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            BusTicket ticket = new ObjectMapper().readValue(scanner.nextLine(), BusTicket.class);
            busTicketService.add(ticket);
        }

        busTicketService.check(busTicketService.getTickets());
    }
}
