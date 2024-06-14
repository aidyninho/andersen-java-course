package model.base;

public abstract class BaseTicket {

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void print() {
        System.out.println(this);
    }
}
