package model;

import java.math.BigDecimal;
import java.time.Instant;

public class Ticket {

    private String id;
    private ConcertHall concertHall;
    private Event event;
    private boolean isPromo;
    private char stadiumSector;
    private long createdAtTimestamp;


    public Ticket() {
        this.createdAtTimestamp = getCurrentUnixTimestamp();
    }

    public Ticket(String id, ConcertHall concertHall, Event event, boolean isPromo, char stadiumSector) {
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

    public void setId(String id) {
        this.id = id;
    }

    public ConcertHall getConcertHall() {
        return concertHall;
    }

    public void setConcertHall(ConcertHall concertHall) {
        this.concertHall = concertHall;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public boolean isPromo() {
        return isPromo;
    }

    public void setPromo(boolean promo) {
        isPromo = promo;
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
