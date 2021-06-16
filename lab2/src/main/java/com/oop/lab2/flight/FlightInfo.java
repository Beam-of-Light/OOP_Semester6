package com.oop.lab2.flight;

import java.util.Objects;

public class FlightInfo {
    public FlightInfo(Long id, Long from, Long to, long datetime) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.datetime = datetime;
    }

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getDatetime() {
        return datetime;
    }

    public void setDatetime(long datetime) {
        this.datetime = datetime;
    }

    private Long from;
    private Long to;
    private long datetime;

    public Long getFrom() {
        return from;
    }

    public void setFrom(Long from) {
        this.from = from;
    }

    public Long getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "FlightInfo{" +
                "from=" + from +
                ", to=" + to +
                ", datetime=" + datetime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlightInfo)) return false;
        FlightInfo that = (FlightInfo) o;
        return getDatetime() == that.getDatetime() && Objects.equals(getId(), that.getId()) && Objects.equals(getFrom(), that.getFrom()) && Objects.equals(getTo(), that.getTo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFrom(), getTo(), getDatetime());
    }

    public void setTo(Long to) {
        this.to = to;
    }

    public long getDeparture() {
        return datetime;
    }

    public void setDeparture(long departure) {
        this.datetime = departure;
    }
}