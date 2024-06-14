package model;

import java.time.Instant;
import java.util.Objects;

public class Ticket implements Printable, Shareable {

    private String id;
    private ConcertHall concertHall;
    private Event event;
    private boolean isPromo;
    private char stadiumSector;
    private final long createdAtTimestamp;


    public Ticket() {
        this.createdAtTimestamp = getCurrentUnixTimestamp();
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
    }

    public Ticket(ConcertHall concertHall, Event event) {
        this.concertHall = concertHall;
        this.event = event;
        this.createdAtTimestamp = getCurrentUnixTimestamp();
    }

    private long getCurrentUnixTimestamp() {
        return System.currentTimeMillis() / 1000L;
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
