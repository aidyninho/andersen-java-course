package model;

import model.base.BaseUser;

public class Admin extends BaseUser {

    public Admin(long id) {
        super(id, Role.ADMIN);
    }

    public boolean checkTicket(Ticket ticket) {
        // TODO: 14.06.2024 implement checking ticket logic
        return true;
    }
}
