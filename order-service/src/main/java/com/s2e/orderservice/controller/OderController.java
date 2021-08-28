package com.s2e.orderservice.controller;

import com.s2e.orderservice.model.Orders;
import com.s2e.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("orders")
public class OderController {

    @Autowired
    OrderRepository orderRepository;

    @GetMapping
    Collection<Orders> getAllOrder(){
        return orderRepository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Orders> getOrderById(@PathVariable("id") int id){
        return orderRepository.findById(id);
    }

    @PostMapping("/")
    Orders postProduct(@RequestBody Orders order){// requestbody to save the data in our database
        return orderRepository.save(order);
    }

}
