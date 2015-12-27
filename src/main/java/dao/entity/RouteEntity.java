package dao.entity;

import java.util.ArrayList;

public class RouteEntity {
    private int from;
    private int to;
    private String token;
    private int id;
    private BusEntity car;
    private ArrayList<Boolean> clients = new ArrayList<>();

    public boolean checkSeat (int seat) {
        if (clients == null) {
            return false;
        } else {
            try {
                return clients.get(seat);
            } catch (Exception e) {
                return false;
            }
        }
    }

    public RouteEntity(int id, int from, int to) {
        this.from = from;
        this.to = to;
        this.id = id;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RouteEntity that = (RouteEntity) o;

        if (from != that.from) return false;
        if (to != that.to) return false;
        if (id != that.id) return false;
        return token != null ? token.equals(that.token) : that.token == null;

    }

    @Override
    public int hashCode() {
        int result = from;
        result = 31 * result + to;
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }

    public BusEntity getCar() {
        return car;
    }

    public void setCar(BusEntity car) {
        this.car = car;
        this.clients.ensureCapacity(car.getSeats());
    }

    public boolean addClient(int i) {
        this.clients.set(i, true);
        return true;
    }

    public void removeClient(int i) {
        this.clients.set(i, false);
    }

    public ArrayList<Boolean> listClients () {
        return this.clients;
    }
}
