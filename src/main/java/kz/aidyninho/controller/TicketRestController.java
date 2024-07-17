package kz.aidyninho.controller;

import kz.aidyninho.dto.TicketDto;
import kz.aidyninho.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class TicketRestController {

    private TicketService ticketService;

    @Autowired
    public TicketRestController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/tickets/{id}")
    public TicketDto findById(@PathVariable(name = "id") String id) {
        return ticketService.findById(Long.parseLong(id));
    }
}
