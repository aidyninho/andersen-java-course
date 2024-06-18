package model;

import annotation.NullableWarning;
import model.base.Ticket;

import java.lang.reflect.Field;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;

public class ConcertTicket extends model.base.Ticket implements Printable, Shareable {

    @NullableWarning
    private ConcertHall concertHall;
    @NullableWarning
    private Event event;
    @NullableWarning
    private Boolean isPromo;
    @NullableWarning
    private Character stadiumSector;
    @NullableWarning
    private final Long createdAtTimestamp;


    public ConcertTicket() {
        this.createdAtTimestamp = getCurrentUnixTimestamp();
        checkForNullFields();
    }

    public ConcertTicket(Long id, ConcertHall concertHall, Event event, boolean isPromo, char stadiumSector) {
        super(id);
        this.concertHall = concertHall;
        this.event = event;
        this.isPromo = isPromo;
        this.stadiumSector = stadiumSector;
        this.createdAtTimestamp = getCurrentUnixTimestamp();
        checkForNullFields();
    }

    public ConcertTicket(ConcertHall concertHall, Event event) {
        this.concertHall = concertHall;
        this.event = event;
        this.createdAtTimestamp = getCurrentUnixTimestamp();
        checkForNullFields();
    }

    private long getCurrentUnixTimestamp() {
        return System.currentTimeMillis() / 1000L;
    }

    // TODO: 14.06.2024 move this method to BaseTicket
    private void checkForNullFields() {
        for (Field field : this.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(NullableWarning.class)) {
                Object o;
                try {
                    o = field.get(this);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                if (o == null) {
                    if (field.getAnnotation(NullableWarning.class).asError()) {
                        System.err.println("Variable " + field.getName() + " is null in " + this.getClass().getSimpleName());
                    } else {
                        System.out.println("Variable " + field.getName() + " is null in " + this.getClass().getSimpleName());
                    }
                }
            }
        }
    }

    public Instant getCreatedDateTime() {
        return Instant.ofEpochSecond(createdAtTimestamp);
    }

    public ConcertHall getConcertHall() {
        return concertHall;
    }

    public Event getEvent() {
        return event;
    }

    public boolean isPromo() {
        return isPromo;
    }

    public char getStadiumSector() {
        return stadiumSector;
    }

    public void setStadiumSector(char stadiumSector) {
        this.stadiumSector = stadiumSector;
    }

    public long getCreatedAt() {
        return createdAtTimestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConcertTicket that = (ConcertTicket) o;
        return Objects.equals(concertHall, that.concertHall) && Objects.equals(event, that.event) && Objects.equals(isPromo, that.isPromo) && Objects.equals(stadiumSector, that.stadiumSector) && Objects.equals(createdAtTimestamp, that.createdAtTimestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(concertHall, event, isPromo, stadiumSector, createdAtTimestamp);
    }

    @Override
    public String toString() {
        return "ConcertTicket{" +
               "id="  +  getId() +
               ", concertHall=" + concertHall +
               ", event=" + event +
               ", isPromo=" + isPromo +
               ", stadiumSector=" + stadiumSector +
               ", createdAtTimestamp=" + createdAtTimestamp +
               '}';
    }
}
