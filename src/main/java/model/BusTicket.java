package model;

import model.base.BaseTicket;

import java.time.LocalDate;
import java.util.Objects;

public class BusTicket extends BaseTicket {

    private Classification ticketClass;
    private Type ticketType;
    private String startDate;

    public BusTicket() {
    }

    public Classification getTicketClass() {
        return ticketClass;
    }

    public void setTicketClass(Classification ticketClass) {
        this.ticketClass = ticketClass;
    }

    public Type getTicketType() {
        return ticketType;
    }

    public void setTicketType(Type ticketType) {
        this.ticketType = ticketType;
    }

    public LocalDate getStartDate() {
        if (startDate == null || startDate.isEmpty()){
            return null;
        }
        return LocalDate.parse(startDate);
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusTicket busTicket = (BusTicket) o;
        return ticketClass == busTicket.ticketClass && ticketType == busTicket.ticketType && Objects.equals(startDate, busTicket.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketClass, ticketType, startDate);
    }

    @Override
    public String toString() {
        return "BusTicket{" +
               "classification=" + ticketClass +
               ", type=" + ticketType +
               ", startDate=" + startDate +
               '}';
    }
}
