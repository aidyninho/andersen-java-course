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
        if (code.length() != 3) {
            throw new IllegalArgumentException("Event code must be exactly 3 digits long. Got: " + code.length());
        } else {
            for (int i = 0; i < code.length(); i++) {
                if (!Character.isDigit(code.charAt(i))) {
                    throw new IllegalArgumentException("Event code must contain only digits. Got: " + code.charAt(i));
                }
            }
        }
        this.code = code;
        this.name = name;
        this.time = time;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
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
