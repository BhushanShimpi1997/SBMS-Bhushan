package com.productapi.xml.service;

import com.productapi.xml.entity.Product;
import com.productapi.xml.exception.ProductNotFoundException;
import com.productapi.xml.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository repository;

    @Override
    public Product saveProduct(Product product) {

        final Product savedProduct = repository.save(product);

        return savedProduct;
    }

    @Override
    public List<Product> getProducts() {

        final List<Product> products = repository.findAll();

        return products;
    }

    @Override
    public Product getProductById(Integer id) {

        final Product product = repository.findById(id)
                              .orElseThrow(() -> new ProductNotFoundException("Invalid Id: "+id));
        return product;
    }
}
