package com.s2e.category.controller;

import com.s2e.category.model.Category;
import com.s2e.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * use of REST annotation
 */
@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryRepository repo;

    @GetMapping
    Collection<Category> getAll(){
        return repo.findAll();
    }

    //returns by id we just call this in products
    @GetMapping("/{id}")
    Category getById(@PathVariable("id") int id){
        return repo.findById(id).get();
    }

    //TODO POST, PUT, DELETE ECC...
}