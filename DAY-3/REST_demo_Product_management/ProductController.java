package com.example.REST_demo.controller;

import com.example.REST_demo.Product;
import com.example.REST_demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService service;

    // 1. GET: http://localhost:8080/api/products
    @GetMapping
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    // 2. GET: http://localhost:8080/api/products/1
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Product product = service.getProductById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.notFound().build();
    }

    // 3. GET: http://localhost:8080/api/products/search?name=product
    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String name) {
        return service.searchProducts(name);
    }

    // 4. POST: http://localhost:8080/api/products
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return service.createProduct(product);
    }

    // 5. PUT: http://localhost:8080/api/products
    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product updated = service.updateProduct(product);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    // 6. DELETE: http://localhost:8080/api/products/1
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        String message = service.deleteProduct(id);
        return ResponseEntity.ok(message);
    }
}
