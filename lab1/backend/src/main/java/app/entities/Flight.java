package app.entities;

import java.time.LocalDateTime;
import java.util.Objects;

public class Flight {
    private int id;
    private Airport from;
    private Airport to;
    private LocalDateTime dateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Flight(int id, Airport from, Airport to, LocalDateTime dateTime) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "from=" + from +
                ", to=" + to +
                ", dateTime=" + dateTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(from, flight.from) && Objects.equals(to, flight.to) && Objects.equals(dateTime, flight.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, dateTime);
    }

    public Airport getFrom() {
        return from;
    }

    public void setFrom(Airport from) {
        this.from = from;
    }

    public Airport getTo() {
        return to;
    }

    public void setTo(Airport to) {
        this.to = to;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
