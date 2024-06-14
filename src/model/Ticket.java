package model;

import annotation.NullableWarning;

import java.lang.reflect.Field;
import java.time.Instant;
import java.util.Objects;

public class Ticket implements Printable, Shareable {

    @NullableWarning(asError = true)
    private String id;
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


    public Ticket() {
        this.createdAtTimestamp = getCurrentUnixTimestamp();
        checkForNullFields();
    }

    public Ticket(String id, ConcertHall concertHall, Event event, boolean isPromo, char stadiumSector) {
        if (id.length() > 4) {
            throw new IllegalArgumentException("ID length must be less than 5 characters. Got: " + id.length());
        }
        this.id = id;
        this.concertHall = concertHall;
        this.event = event;
        this.isPromo = isPromo;
        this.stadiumSector = stadiumSector;
        this.createdAtTimestamp = getCurrentUnixTimestamp();
        checkForNullFields();
    }

    public Ticket(ConcertHall concertHall, Event event) {
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

    public String getId() {
        return id;
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
        Ticket ticket = (Ticket) o;
        return isPromo == ticket.isPromo
               && stadiumSector == ticket.stadiumSector
               && createdAtTimestamp == ticket.createdAtTimestamp
               && Objects.equals(id, ticket.id)
               && Objects.equals(concertHall, ticket.concertHall)
               && Objects.equals(event, ticket.event);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, concertHall, event, isPromo, stadiumSector, createdAtTimestamp);
    }

    @Override
    public String toString() {
        return "Ticket{" +
               "id='" + id + '\'' +
               ", concertHall=" + concertHall +
               ", event=" + event +
               ", isPromo=" + isPromo +
               ", stadiumSector=" + stadiumSector +
               ", createdAtTimestamp=" + createdAtTimestamp +
               '}';
    }
}
