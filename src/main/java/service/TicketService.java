package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.TicketDao;
import jakarta.transaction.Transactional;
import model.BusTicket;
import model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class TicketService {

    private TicketDao ticketDao;

    @Autowired
    public TicketService(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    public Ticket findById(Long id) {
        return ticketDao.findById(id);
    }

    @Transactional
    public void save(Ticket ticket) {
        ticketDao.save(ticket);
    }

    @Transactional
    public void update(Ticket ticket) {
        ticketDao.update(ticket);
    }

    @Transactional
    public void delete(Ticket ticket) {
        ticketDao.delete(ticket);
    }

    public List<Ticket> getTicketsFromFile(File file) {
        List<Ticket> tickets = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File("src/main/resources/test.txt"));
            while (scanner.hasNextLine()) {
                Ticket ticket = new ObjectMapper().readValue(scanner.nextLine(), Ticket.class);
                tickets.add(ticket);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return tickets;
    }
}
