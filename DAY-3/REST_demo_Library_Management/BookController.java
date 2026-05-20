package com.example.REST_demo_library_management.Controller;

import com.example.REST_demo_library_management.Books;
import com.example.REST_demo_library_management.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService service;

    // 1. GET: http://localhost:8080/api/books
    @GetMapping
    public List<Books> getAllBooks() {
        return service.getAllBooks();
    }

    // 2. GET: http://localhost:8080/api/books/1
    @GetMapping("/{id}")
    public ResponseEntity<Books> getBookById(@PathVariable int id) {
        Books book = service.getBookById(id);
        if (book != null) {
            return ResponseEntity.ok(book);
        }
        return ResponseEntity.notFound().build();
    }

    // 3. GET: http://localhost:8080/api/books/search?name=book
    @GetMapping("/search")
    public List<Books> searchBooks(@RequestParam String name) {
        return service.searchBooks(name);
    }

    // 4. POST: http://localhost:8080/api/books
    @PostMapping
    public Books createBook(@RequestBody Books book) {
        return service.createBook(book);
    }

    // 5. PUT: http://localhost:8080/api/books
    @PutMapping
    public ResponseEntity<Books> updateBook(@RequestBody Books book) {
        Books updated = service.updateBook(book);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    // 6. DELETE: http://localhost:8080/api/books/1
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id) {
        String message = service.deleteBook(id);
        return ResponseEntity.ok(message);
    }
}
