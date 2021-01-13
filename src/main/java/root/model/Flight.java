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
    private String departureDate;
    private String departureHour;
    private double price;
    @Enumerated(EnumType.STRING)
    private Category category;

    public Flight(int id, String origin, String destination, int places, String departureDate, String departureHour, double price, Category category) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.places = places;
        this.departureDate = departureDate;
        this.departureHour = departureHour;
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

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureHour() {
        return departureHour;
    }

    public void setDepartureHour(String departureHour) {
        this.departureHour = departureHour;
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
        return new Flight(this.id, this.origin, this.destination, this.places, this.departureDate, this.departureHour, this.price, this.category);
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
                .append(", departureDate='")
                .append(departureDate)
                .append(", departureHour='")
                .append(departureHour)
                .append(", price=")
                .append(price)
                .append(", category=")
                .append(category)
                .append('}').toString();
    }
}
