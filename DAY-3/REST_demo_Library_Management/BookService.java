package com.example.REST_demo_library_management.Service;

import com.example.REST_demo_library_management.Books;
import com.example.REST_demo_library_management.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Books> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    public Books getBookById(int id) {
        return bookRepository.findById(id);
    }

    public List<Books> searchBooks(String name) {
        return bookRepository.search(name);
    }

    public Books createBook(Books book) {
        return bookRepository.save(book);
    }

    public Books updateBook(Books book) {
        return bookRepository.update(book);
    }

    public String deleteBook(Integer id) {
        return bookRepository.delete(id);
    }
}
