package root.model;

import javax.persistence.*;

@Entity(name = "tflight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String origin;
    private String destination;
    private int places;
    private String departure;
    private double price;
    @Enumerated(EnumType.STRING)
    private Category category;

    public Flight(int id, String origin, String destination, int places, String departure, double price, Category category) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.places = places;
        this.departure = departure;
        this.price = price;
        this.category = category;
    }

    public Flight() {
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

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
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
        return new Flight(this.id, this.origin, this.destination, this.places, this.departure, this.price, this.category);
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Flight{")
                .append("id=")
                .append(id)
                .append(", origin='")
                .append(origin)
                .append(", destination='")
                .append(destination)
                .append(", places=")
                .append(places)
                .append(", departure='")
                .append(departure)
                .append(", price=")
                .append(price)
                .append(", category=")
                .append(category)
                .append('}').toString();
    }
}
