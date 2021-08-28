package com.s2e.lineproducts.controller;

import com.s2e.lineproducts.model.LineProduct;
import com.s2e.lineproducts.repository.LineProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/lineproducts")
public class LineProductController {

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
}
