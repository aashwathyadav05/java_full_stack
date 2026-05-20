package com.example.REST_demo.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;
import com.example.REST_demo.Product;

@Repository
public class ProductRepository {
    private final List<Product> list = new ArrayList<>();

    public ProductRepository() {
        createProducts();
    }

    public void createProducts() {
        list.addAll(List.of(
                new Product(1, "product 1", 10, 1000),
                new Product(2, "product 2", 20, 2000),
                new Product(3, "product 3", 30, 3000)
        ));
    }

    public List<Product> getAllProducts() {
        return list;
    }

    public Product findById(int id){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getP_id() == id) {
                return list.get(i);
            }
        }
        return null;
    }

    public List<Product> search(String name) {
        return list.stream()
                .filter(x -> x.getP_name() != null && x.getP_name().startsWith(name))
                .collect(Collectors.toList());
    }

    public Product save(Product p) {
        Product product = new Product(p.getP_id(), p.getP_name(), p.getP_quantity(), p.getP_price());
        list.add(product);
        return product;
    }

    public String delete(Integer id) {
        list.removeIf(x -> x.getP_id() == id);
        return "Deleted successfully";
    }

    public Product update(Product product) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getP_id() == product.getP_id()) {
                list.set(i, product);
                return product;
            }
        }
        return null;
    }
}
