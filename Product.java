import java.util.Random;

public class Product {
    private long id;
    private String name;
    private String category;
    private double price;

    public Product(String name, String category) {
        this.name = name;
        this.category = category;
        this.price = (double) Math.round(new Random().nextDouble() * 50000.0) / 100.0;
        this.id = new Random().nextLong();
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = (double) Math.round(price * 100.0) / 100.0;
    }
}
