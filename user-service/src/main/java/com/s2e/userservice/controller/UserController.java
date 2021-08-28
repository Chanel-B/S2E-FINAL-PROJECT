package com.s2e.userservice.controller;

import com.s2e.userservice.model.User;
import com.s2e.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public Collection<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable("id") int id){
        return userRepository.findById(id);
    }

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        return userRepository.save(user);
    }
}
