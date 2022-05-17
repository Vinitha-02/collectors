import java.util.stream.Collectors;
import java.util.*;

class product {
    int id;
    String name;
    float price;

    public product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

public class collectors {
    public static void main(String[] args) {
        HashSet<product> productsList = new HashSet<product>();

        productsList.add(new product(1, "HP Laptop", 25000f));
        productsList.add(new product(2, "Dell Laptop", 30000f));
        productsList.add(new product(3, "Lenevo Laptop", 28000f));
        productsList.add(new product(4, "Sony Laptop", 28000f));
        productsList.add(new product(5, "Apple Laptop", 90000f));
        System.out.println("Normal method to print the element");
        for (product b : productsList) {
            System.out.println(b.id + " " + b.name + " " + b.price);
        }
        // List<String> productPriceList = productsList.stream()
        System.out.println("print the element using the collector");

        productsList.stream().map(x -> x.name)
                .collect(Collectors.toList()).forEach(System.out::println);
        // System.out.println(productPriceList);
        System.out.println("add the value using the collector");
        Double sum = productsList.stream()
                .collect(Collectors.summingDouble(product -> product.price));
        System.out.println(sum);
        System.out.println("averaging the value using the collector");
        Double avg = productsList.stream()
                .collect(Collectors.averagingDouble(product -> product.price));
        System.out.println(avg);
        System.out.println("Counting the elements using the collector");

        Long n = productsList.stream()
                .collect(Collectors.counting());
        System.out.println(n);
    }
}