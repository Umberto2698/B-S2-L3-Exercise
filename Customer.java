import java.util.Random;

public class Customer {
    private long id;
    private String name;
    private Integer tier;

    public Customer(String name, Integer tier) {
        this.name = name;
        this.tier = tier;
        this.id = new Random().nextLong();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tier=" + tier +
                '}';
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getTier() {
        return tier;
    }
}
