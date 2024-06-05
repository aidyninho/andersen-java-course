package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Event {

    private String code;
    private String name;
    private LocalDateTime time;
    private BigDecimal price;

    public Event() {
    }

    public Event(String code, String name, LocalDateTime time, BigDecimal price) {
        this.code = code;
        this.name = name;
        this.time = time;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Event{" +
               "code='" + code + '\'' +
               ", name='" + name + '\'' +
               ", time=" + time +
               ", price=" + price +
               '}';
    }
}
