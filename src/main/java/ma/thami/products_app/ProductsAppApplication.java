package ma.thami.products_app;

import ma.thami.products_app.entities.Product;
import ma.thami.products_app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProductsAppApplication implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;
    public static void main(String[] args) {
        SpringApplication.run(ProductsAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        /* productRepository.save(new Product(null, "Computer", 4300, 25));
        productRepository.save(new Product(null, "Smartphone", 1400, 10));
        productRepository.save(new Product(null, "TV", 5700, 132));
        productRepository.save(new Product(null, "Keyboard", 450, 75)); */
        List<Product> products = productRepository.findAll();
        products.forEach(p->{
            System.out.println(p.toString());
        });
        Product product = productRepository.findById(Long.valueOf(1)).get();
        System.out.println("*************");
        System.out.println("Id : " + product.getId());
        System.out.println("Name : " + product.getName());
        System.out.println("Price : " + product.getPrice());
        System.out.println("Quantity : " + product.getQuantity());
        System.out.println("*************");
        System.out.println("-------------------------");
        List<Product> productList = productRepository.findByNameContains("C");
        productList.forEach(System.out::println);
        List<Product> productList2 = productRepository.search("%C%");
        productList2.forEach(System.out::println);
        List<Product> productList3 = productRepository.searchByPrice(3000);
        productList2.forEach(System.out::println);
    }
}
