package model;

import model.base.Ticket;
import model.base.User;

import java.util.ArrayList;
import java.util.List;

public class Client extends User {

    private List<Ticket> tickets;

    public Client(long id) {
        super(id, Role.CLIENT);
        this.tickets = new ArrayList<>();
    }

    public List<Ticket> getTickets() {
        return tickets;
    }
}
