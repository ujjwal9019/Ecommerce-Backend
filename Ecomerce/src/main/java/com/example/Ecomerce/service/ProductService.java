package com.example.Ecomerce.service;

import com.example.Ecomerce.model.Product;
import com.example.Ecomerce.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;


    public List<Product> getAllProducts() {
    return  repo.findAll();
    }
}
