package kz.aidyninho.model;

import kz.aidyninho.model.base.BaseUser;

import java.util.ArrayList;
import java.util.List;

public class Client extends BaseUser {

    private List<Ticket> tickets;

    public Client(long id) {
        super(id, Role.CLIENT);
        this.tickets = new ArrayList<>();
    }

    public List<Ticket> getTickets() {
        return tickets;
    }
}
