import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class Order {
    private long id;
    private String status;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<Product> products;
    private Customer customer;


    public Order(List<Product> products, Customer customer) {
        this.customer = customer;
        this.products = products;
        this.id = new Random().nextLong();
        int month = (int) (1 + Math.floor(Math.random() * 7));
        int day;
        if (month == 3) {
            day = (int) (1 + Math.floor(Math.random() * 27));
        } else if (month == 11 || month == 4 || month == 6 || month == 9) {
            day = (int) (1 + Math.floor(Math.random() * 29));
        } else {
            day = (int) (1 + Math.floor(Math.random() * 30));
        }
        this.orderDate = (LocalDate.of(2021, month, day));
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", orderDate=" + orderDate +
                ", products=" + products +
                ", customer=" + customer +
                '}';
    }

    public long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Customer getCustomer() {
        return customer;
    }
}
