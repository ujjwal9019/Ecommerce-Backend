package com.example.Ecomerce.controller;


import com.example.Ecomerce.model.Product;
import com.example.Ecomerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService service;
    @RequestMapping("/")
    public String greet(){
        return "hello";
    }

    @GetMapping("/products")
    public List<Product> getAllProduct(){
        return service.getAllProducts();
    }


}
