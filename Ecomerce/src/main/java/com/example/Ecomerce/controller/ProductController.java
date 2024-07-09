package com.example.Ecomerce.controller;


import com.example.Ecomerce.model.Product;
import com.example.Ecomerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public ResponseEntity<List<Product>> getAllProduct(){

        return new ResponseEntity<>(service.getAllProducts() , HttpStatus.OK) ;
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product>  getProduct(@PathVariable int id){
      Product product = service.getProductById(id);

      if(product != null){

          return new ResponseEntity<>(service.getProductById(id),HttpStatus.OK);
        }

      else{
         return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product,
                                        @RequestPart MultipartFile imageFile){
        try {
            System.out.println(product);
            Product product1 = service.addProduct(product, imageFile);
            return new ResponseEntity<>(product1, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
