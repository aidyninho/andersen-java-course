package model.base;

import annotation.NullableWarning;

public abstract class Ticket {

    @NullableWarning
    private Long id;

    public Ticket() {
    }

    public Ticket(Long id) {
        setId(id);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        if (id > 9999) {
            throw new IllegalArgumentException("ID must be less than 9999, got " + id);
        }
        this.id = id;
    }
}
