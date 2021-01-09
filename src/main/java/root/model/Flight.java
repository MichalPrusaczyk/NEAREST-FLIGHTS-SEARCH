package root.model;

import javax.persistence.*;

@Entity(name = "tflight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String shape;
    private int length;
    private String ean;
    private double price;
    @Enumerated(EnumType.STRING)
    private Category category;

    public Flight(int id, String name, String shape, int length, String ean, double price, Category category) {
        this.id = id;
        this.name = name;
        this.shape = shape;
        this.length = length;
        this.ean = ean;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
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
        return new Flight(this.id, this.name, this.shape, this.length, this.ean, this.price, this.category);
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Flight{")
                .append("id=")
                .append(id)
                .append(", name='")
                .append(name)
                .append(", shape='")
                .append(shape)
                .append(", length=")
                .append(length)
                .append(", ean='")
                .append(ean)
                .append(", price=")
                .append(price)
                .append(", category=")
                .append(category)
                .append('}').toString();
    }
}
