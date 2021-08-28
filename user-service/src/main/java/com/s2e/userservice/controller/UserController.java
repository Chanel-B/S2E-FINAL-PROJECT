package com.s2e.userservice.controller;

import com.s2e.userservice.model.Users;
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
    public Collection<Users> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Users> getUserById(@PathVariable("id") int id){
        return userRepository.findById(id);
    }

    @PostMapping("/")
    public Users saveUser(@RequestBody Users user){
        return userRepository.save(user);
    }
}
