package com.s2e.lineproducts.controller;

import com.s2e.lineproducts.model.LineProduct;
import com.s2e.lineproducts.model.LineProductDetail;
import com.s2e.lineproducts.model.Product;
import com.s2e.lineproducts.repository.LineProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/lineproducts")
public class LineProductController {

    @Value("${externalService.product.url}")
    private String productUrl;

    @Autowired
    RestTemplate restTemplate; //va a prendere nella classe application.java che initializza il restemplate

    @Autowired
    LineProductRepository repo;

    @GetMapping
    public Collection<LineProduct> getAll(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public LineProduct getLineProductById(@PathVariable("id") int id){
        return repo.findById(id).get();
    }

    @PostMapping("/")
    public LineProduct postProduct(@RequestBody LineProduct lineProduct){// requestbody to save the data in our database
        return repo.save(lineProduct);
    }

    @GetMapping("/lineproductdetails/{id}")
    LineProductDetail LineProductDetail(@PathVariable("id") int id ){
        LineProduct lineProduct = repo.findById(id).get();
        int idProduct = lineProduct.getProductId();
        Product product = restTemplate.getForObject(productUrl + '/' + idProduct, Product.class);

        return new LineProductDetail(lineProduct, product);
    }

}
