import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Supplier<Product> bookSupplier = () -> new Product("LOTR", "book");
        Supplier<Product> televisionSupplier = () -> new Product("Samsung", "television");
        Supplier<Product> babyProductSupplier = () -> new Product("ciuccio", "baby");
        Supplier<Product> boysProductSupplier = () -> new Product("trousers", "boys");

        Supplier<Customer> tierOneCustomer = () -> new Customer("Bob", 1);
        Supplier<Customer> tierTwoCustomer = () -> new Customer("Bob", 2);
        Supplier<Customer> tierThreeCustomer = () -> new Customer("Bob", 3);


        List<Customer> customerList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            customerList.add(tierOneCustomer.get());
            customerList.add(tierTwoCustomer.get());
            customerList.add(tierThreeCustomer.get());
        }

        List<Product> productsList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            productsList.add(bookSupplier.get());
            productsList.add(televisionSupplier.get());
            productsList.add(babyProductSupplier.get());
            productsList.add(boysProductSupplier.get());
        }
        System.err.println("Lista prodotti:");
        productsList.forEach(System.out::println);

        TimeUnit.MILLISECONDS.sleep(1500);
        List<Order> orderList = new ArrayList<>();
//        List<Product> orderProductList = new ArrayList<>();
        for (Customer customer : customerList) {
            List<Product> orderProductList = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                int n = (int) Math.floor(Math.random() * 40);
                orderProductList.add(productsList.get(n));
            }
            orderList.add(new Order(orderProductList, customer));
//            orderProductList.clear();
        }
        System.err.println("Lista ordini:");
        orderList.forEach(System.out::println);

        TimeUnit.MILLISECONDS.sleep(1500);
        //************************* NUMERO 1 ********************************
        System.err.println("Numero 1");
        List<Product> bookList = productsList.stream().filter(el -> el.getCategory().equals("book") && el.getPrice() < 100).toList();
        bookList.forEach(System.out::println);


        TimeUnit.MILLISECONDS.sleep(1500);
        //************************* NUMERO 2 ********************************
        System.err.println("Numero 2");
        List<Order> babyOdersList = orderList.stream().filter(el -> el.getProducts().stream().anyMatch(product -> product.getCategory().equals("baby"))).toList();
        babyOdersList.forEach(System.out::println);

        TimeUnit.MILLISECONDS.sleep(1500);
        //************************* NUMERO 3 ********************************
        System.err.println("Numero 3");
        List<Product> boysListOnSales = productsList.stream().filter(el -> el.getCategory().equals("boys")).toList();
        boysListOnSales.forEach(el -> {
            el.setPrice((el.getPrice() - 0.1 * el.getPrice()));
            System.out.println(el);
        });

        TimeUnit.MILLISECONDS.sleep(1500);
        //************************* NUMERO 4 ********************************


        TimeUnit.MILLISECONDS.sleep(1500);
        System.err.println("Numero 4");
        List<Order> tierTwoCustomerOrderList = orderList.stream().filter(order -> order.getCustomer().getTier() == 2).toList();
        List<List<Product>> orderListBetweenDates = tierTwoCustomerOrderList.stream().filter(el -> el.getOrderDate().isAfter(LocalDate.of(2021, 2, 1)) && el.getOrderDate().isBefore(LocalDate.of(2021, 4, 1))).map(Order::getProducts).toList();
        orderListBetweenDates.forEach(list -> list.forEach(System.out::println));
    }
}
