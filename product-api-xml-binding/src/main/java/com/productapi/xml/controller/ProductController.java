package com.productapi.xml.controller;

import com.productapi.xml.entity.Product;
import com.productapi.xml.service.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping(value = "/product",
    consumes = {
            "application/json",
            "application/xml"
    },
    produces = {
            "application/json",
            "application/xml"
    })
    public ResponseEntity<Product> getProduct(@RequestBody Product product){

        final Product savedProduct = service.saveProduct(product);

        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @GetMapping(value = "/products",
    produces = {
            "application/json",
            "application/xml"
    })
    public ResponseEntity<List<Product>> getProducts(){

        final List<Product> products = service.getProducts();

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping(value = "/product/{id}",
    produces = {
            "application/json",
            "application/xml"
    })
    public ResponseEntity<Product> getProductById(@PathVariable Integer id){

        final Product productById = service.getProductById(id);

        return new ResponseEntity<>(productById, HttpStatus.OK);
    }
}
