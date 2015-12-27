package dao.entity;

public class BusEntity {

    private int id;
    private String name;
    private int seats;

    public BusEntity(int id, String name, int seats) {
        this.id = id;
        this.name = name;
        this.seats = seats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
