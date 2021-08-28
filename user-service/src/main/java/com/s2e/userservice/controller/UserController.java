package com.s2e.userservice.controller;

import com.s2e.userservice.model.Orders;
import com.s2e.userservice.model.Users;
import com.s2e.userservice.repository.UserRepository;
import com.s2e.userservice.virtualobjects.UsersOrdersDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    /**
     * calling Order-Service with url
     */
    @Value("${externalService.order.url}")
    private String ordersUrl;

    /**
     * calling the restTemplate
     * from application
     */
    @Autowired
    RestTemplate restTemplate; //va a prendere nella classe application.java che initializza il restemplate

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

    /**
     * calling external service (ORDER-SERVICE)
     * @param id : (id of the User)
     * @return : UserOrderDetail ( which shows =  User + Orders )
     */
    @GetMapping("/usersOdersdetails/{id}")
    UsersOrdersDetail UsersOrdersDetail(@PathVariable("id") int id ){
        Users users = userRepository.findById(id).get();
        int idOrders= users.getOrderId();
        Orders orders = restTemplate.getForObject(ordersUrl + '/' + idOrders, Orders.class);

        return new UsersOrdersDetail(users, orders);
    }
}
