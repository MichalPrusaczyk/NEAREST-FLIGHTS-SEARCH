package root.model;

import javax.persistence.*;

@Entity(name = "tflight")
public class Flight1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String origin;
    private String destination;
    private int date;
    private String ean;
    private double price;
    @Enumerated(EnumType.STRING)
    private Category category;

    public Flight1(int id, String origin, String destination, int date, String ean, double price, Category category) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.ean = ean;
        this.price = price;
        this.category = category;
    }

    public Flight1() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public enum Category {
        BUTTON1,
        BUTTON2
    }

    @Override
    public Object clone() {
        return new Flight(this.id, this.origin, this.destination, this.date, this.ean, this.price, this.category);
    }

    @Override
    public String toString() {
        return "Flight1{" +
                "id=" + id +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", date=" + date +
                ", ean='" + ean + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}
