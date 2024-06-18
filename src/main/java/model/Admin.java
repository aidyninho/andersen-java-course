package model;

import model.base.Ticket;
import model.base.User;

public class Admin extends User {

    public Admin(long id) {
        super(id, Role.ADMIN);
    }

    public boolean checkTicket(Ticket ticket) {
        // TODO: 14.06.2024 implement checking ticket logic
        return true;
    }
}
