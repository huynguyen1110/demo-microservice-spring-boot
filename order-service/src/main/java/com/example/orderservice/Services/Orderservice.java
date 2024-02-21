package com.example.orderservice.Services;

import com.netflix.discovery.converters.Auto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.awt.print.Book;

@Service
public class Orderservice {

    @Auto
    public final RestTemplate restTemplate;


    public Orderservice(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Object getBookById(Long bookId) {
        String bookUrl = "http://localhost:9000/book/" + bookId;
        return restTemplate.getForEntity(bookUrl, Object.class);
    }
}
