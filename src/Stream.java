import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Product{
    int id;
    String name;
    double price;
    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
public class Stream {
    public static void main(String[] args) {
        List<Product> productsList = new ArrayList<Product>();
        productsList.add(new Product(1,"Ninja",250000));
        productsList.add(new Product(2,"Rx 100",130000));
        productsList.add(new Product(3,"R15",280000));
        productsList.add(new Product(4,"Royal Enfield",310000));
        productsList.add(new Product(5,"Pulsar",80000));
        List<Double> productPriceList = new ArrayList<>();
        System.out.println("FILTER WITHOUT STREAM: ");
        for(Product product: productsList){
            if(product.price<80000){
                productPriceList.add(product.price);
            }
        }
        System.out.println(productPriceList);
        System.out.println("FILTER WITH STREAM: ");
        productsList.stream()
                .filter(item -> item.price<80000)
                .map(item -> item.price)
                .forEach(System.out::println);
        System.out.println("COUNT ITEMS WITH STREAM: ");
        long count = productsList.stream()
                .filter(product->product.price<80000)
                .count();
        System.out.println(count);
        System.out.println("LIST TO MAP WITH STREAM: ");
        Map<Integer,String> productPriceMap = productsList.stream()
                        .collect(Collectors.toMap(p->p.id, p->p.name));
        System.out.println(productPriceMap);
        System.out.println("CALCULATE TOTAL PRICE WITH STREAM: ");
        Double totalPrice = productsList.stream()
                .map(product->product.price)
                .reduce(0.0, Double::sum);
        System.out.println("Total Price: "+totalPrice);
        System.out.println("FIND ITEM WITH STREAM: ");
        Product product = productsList.stream().parallel()
                .filter(item -> item.price>80000)
                .findFirst().orElse(null);
        System.out.println(product.name+" -> "+product.price);
        System.out.println("FIND ANY METHOD");
        Product product1 = productsList.stream().parallel()
                .filter(item -> item.price>80000)
                .findAny().orElse(null);
        System.out.println(product1.name+" -> "+product1.price);
    }
}
