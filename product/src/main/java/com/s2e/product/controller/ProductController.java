package com.s2e.product.controller;

import com.s2e.product.model.Product;
import com.s2e.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * mapping all request to { "/pruducts" }
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository repo;

    @GetMapping
    Collection<Product> getAll(){
        return repo.findAll();
    }

    //TODO for post, put, delete ecc...

}
