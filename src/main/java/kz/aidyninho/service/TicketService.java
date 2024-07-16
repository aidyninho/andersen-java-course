package kz.aidyninho.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import kz.aidyninho.dto.TicketDto;
import kz.aidyninho.model.Ticket;
import kz.aidyninho.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class TicketService {

    private TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public TicketDto findById(Long id) {
        Ticket ticket = ticketRepository.findById(id).get();
        return new TicketDto(
                ticket.getId(),
                ticket.getUser().getId(),
                ticket.getType(),
                ticket.getCreatedAt()
        );
    }

    @Transactional
    public void save(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    @Transactional
    public void update(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    @Transactional
    public void delete(Ticket ticket) {
        ticketRepository.delete(ticket);
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
