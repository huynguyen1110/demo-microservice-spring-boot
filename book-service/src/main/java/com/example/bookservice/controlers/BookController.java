package com.example.bookservice.controlers;

import com.example.bookservice.entities.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @GetMapping("/book/{id}")
    public Book getBookId(@PathVariable Long id) {
        Book book = new Book(1, "Cau vang", "HCM");
        return book;
    }
}
