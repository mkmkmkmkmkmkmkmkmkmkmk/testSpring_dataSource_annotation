package scan.model;

import java.io.Serializable;

public class DishCart implements Serializable {
    private int id;
    private int uid;
    private int did;
    private int number;


    public DishCart() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", uid=" + uid +
                ", did=" + did  +
                ", number=" + number +
                '}';
    }

}
