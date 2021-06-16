package app.entities;

public class FlightInfo {
    public FlightInfo(int id, int from, int to, long datetime) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.datetime = datetime;
    }

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getDatetime() {
        return datetime;
    }

    public void setDatetime(long datetime) {
        this.datetime = datetime;
    }

    private int from;
    private int to;
    private long datetime;

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
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

    public void setTo(int to) {
        this.to = to;
    }

    public long getDeparture() {
        return datetime;
    }

    public void setDeparture(long departure) {
        this.datetime = departure;
    }
}