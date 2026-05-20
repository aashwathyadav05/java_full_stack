package com.example.REST_demo_library_management.Repository;

import com.example.REST_demo_library_management.Books;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BookRepository {
    private final List<Books> list = new ArrayList<>();

    public BookRepository() {
        createBooks();
    }

    public void createBooks() {
        list.addAll(List.of(
                new Books(1, "book 1", 10, 1000),
                new Books(2, "book 2", 20, 2000),
                new Books(3, "book 3", 30, 3000)
        ));
    }

    public List<Books> getAllBooks() {
        return list;
    }

    public Books findById(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getB_id() == id) {
                return list.get(i);
            }
        }
        return null;
    }

    public List<Books> search(String name) {
        return list.stream()
                .filter(x -> x.getB_name() != null && x.getB_name().startsWith(name))
                .collect(Collectors.toList());
    }

    public Books save(Books b) {
        Books book = new Books(b.getB_id(), b.getB_name(), b.getB_quantity(), b.getB_price());
        list.add(book);
        return book;
    }

    public String delete(Integer id) {
        list.removeIf(x -> x.getB_id() == id);
        return "Deleted successfully";
    }

    public Books update(Books book) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getB_id() == book.getB_id()) {
                list.set(i, book);
                return book;
            }
        }
        return null;
    }
}
