package dao.entity;

import java.util.ArrayList;

public class OldRouteEntity {

    private double fromX;
    private double fromY;
    private double toX;
    private double toY;
    private ArrayList<Stop> stops;
    private String token;
    private ArrayList<String> names;

    public OldRouteEntity(String fromX, String fromY, String toX, String toY, String token) {
        try {
            this.fromX = Double.parseDouble(fromX);
            this.fromY = Double.parseDouble(fromY);
            this.toX = Double.parseDouble(toX);
            this.toY = Double.parseDouble(toY);
        } catch (Exception e) {
            return;
        }
        this.token = token;
        stops = new ArrayList<>();
    }

    public OldRouteEntity(double fromX, double fromY, double toX, double toY, String token) {
        this.fromX = fromX;
        this.fromY = fromY;
        this.toX = toX;
        this.toY = toY;
        this.token = token;
        stops = new ArrayList<>();
    }

    public void addStop (String name, double x, double y) {
        this.stops.add(new Stop (name, x, y));
        this.names.add(name);
    }

    public void removePassenger(String name) {
        for (int i = 0; i < names.size(); i++) {
            if (name.equals(names)) {
                names.remove(i);
            }
        }
    }

    private class Stop {
        public String name;
        public double x;
        public double y;

        public Stop(String name, double x, double y) {
            this.name = name;
            this.x = x;
            this.y = y;
        }
    }

    public double getFromX() {
        return fromX;
    }

    public void setFromX(double fromX) {
        this.fromX = fromX;
    }

    public double getFromY() {
        return fromY;
    }

    public void setFromY(double fromY) {
        this.fromY = fromY;
    }

    public double getToX() {
        return toX;
    }

    public void setToX(double toX) {
        this.toX = toX;
    }

    public double getToY() {
        return toY;
    }

    public void setToY(double toY) {
        this.toY = toY;
    }

    public ArrayList<Stop> getStops() {
        return stops;
    }

    public void setStops(ArrayList<Stop> stops) {
        this.stops = stops;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public void setNames(ArrayList<String> names) {
        this.names = names;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OldRouteEntity that = (OldRouteEntity) o;

        if (Double.compare(that.fromX, fromX) != 0) return false;
        if (Double.compare(that.fromY, fromY) != 0) return false;
        if (Double.compare(that.toX, toX) != 0) return false;
        if (Double.compare(that.toY, toY) != 0) return false;
        if (names != null ? !names.equals(that.names) : that.names != null) return false;
        if (stops != null ? !stops.equals(that.stops) : that.stops != null) return false;
        if (token != null ? !token.equals(that.token) : that.token != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(fromX);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(fromY);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(toX);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(toY);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (stops != null ? stops.hashCode() : 0);
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + (names != null ? names.hashCode() : 0);
        return result;
    }
}
