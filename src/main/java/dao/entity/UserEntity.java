package dao.entity;

import rest.DataContainer;

import java.util.UUID;

public class UserEntity {

    private int id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String car;
    private String plate;
    private int capacity;
    private String token;

    public UserEntity (int id, String login, String password, String name, String surname,
                      String car, String plate, int capacity) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.car = car;
        this.plate = plate;
        this.capacity = capacity;
        this.token = UUID.randomUUID().toString();
        DataContainer.addToken(this.token, this);
    }

    public UserEntity (int id, String login, String password, String name, String surname,
                      String car, String plate, int capacity, String token) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.car = car;
        this.plate = plate;
        this.capacity = capacity;
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (capacity != that.capacity) return false;
        if (id != that.id) return false;
        if (car != null ? !car.equals(that.car) : that.car != null) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (plate != null ? !plate.equals(that.plate) : that.plate != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (token != null ? !token.equals(that.token) : that.token != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (car != null ? car.hashCode() : 0);
        result = 31 * result + (plate != null ? plate.hashCode() : 0);
        result = 31 * result + capacity;
        result = 31 * result + (token != null ? token.hashCode() : 0);
        return result;
    }
}