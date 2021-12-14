package scan.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Dish implements Serializable {
    private int did;
    private String name;
    private String photoUrl;
    private BigDecimal price;
    private int sale;
    private String info;

    public Dish() {
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int sale(){ return sale;}

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "did=" + did +
                ", name='" + name + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", price=" + price +
                ", sale=" + sale +
                ", info='" + info + '\'' +
                '}';
    }
}