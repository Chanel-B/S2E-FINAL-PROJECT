package com.s2e.product.controller;

import com.s2e.product.model.Category;
import com.s2e.product.model.Product;
import com.s2e.product.model.ProductDetail;
import com.s2e.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

/**
 * mapping all request to { "/pruducts" }
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    @Value("${externalService.category.url}")
    private String categoryUrl;

    @Autowired
    RestTemplate restTemplate; //va a prendere nella classe application.java che initializza il restemplate

    @Autowired
    ProductRepository repo;

    @GetMapping
    Collection<Product> getAll(){
        return repo.findAll();
    }

    @GetMapping("/detail/{id}")
    ProductDetail detaliProduct(@PathVariable("id") int id ){
        Product p = repo.findById(id).get();
        Category c = restTemplate.getForObject(categoryUrl, Category.class);

        return new ProductDetail(p, c);
    }

    //TODO for post, put, delete ecc...

}
