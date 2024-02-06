package com.productapi.xml.service;

import com.productapi.xml.entity.Product;

import java.util.List;

public interface ProductService {

    public Product saveProduct(Product product);

    public List<Product> getProducts();

    public Product getProductById(Integer id);
}
