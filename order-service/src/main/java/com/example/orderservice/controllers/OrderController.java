package com.example.orderservice.controllers;

import com.example.orderservice.Services.Orderservice;
import com.example.orderservice.feignclient.BookServiceClient;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {

    @Autowired
    private final Orderservice orderservice;

    @Autowired
    private final BookServiceClient bookServiceClient;

    @GetMapping("{orderId}")
    public ResponseEntity<Object> getOrder(@PathVariable Long orderId) {
        Object book = orderservice.getBookById(orderId);
        return ResponseEntity.ok(book);
    }

    @GetMapping("/get-book/{id}")
    public ResponseEntity<Object> getBook(@PathVariable Long id) {
        return ResponseEntity.ok(bookServiceClient.getBookById(id));
    }
}
