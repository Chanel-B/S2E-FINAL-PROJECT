package com.s2e.lineproducts.controller;

import com.s2e.lineproducts.model.*;
import com.s2e.lineproducts.repository.LineProductRepository;
import com.s2e.lineproducts.virtualobject.LineOrdersDetail;
import com.s2e.lineproducts.virtualobject.LineProductDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/lineproducts")
public class LineProductController {

    /**
     * calling Product-Service with url
     */
    @Value("${externalService.product.url}")
    private String productUrl;

    /**
     * calling Order-Service with url
     */
    @Value("${externalService.order.url}")
    private String ordersUrl;

    @Autowired
    RestTemplate restTemplate; //va a prendere nella classe application.java che initializza il restemplate

    /**
     * calling repository to get services
     */
    @Autowired
    LineProductRepository repo;

    /**
     * Getting the list of all lines-Products
     * @return : the list of all lines-Products
     */
    @GetMapping
    public Collection<LineProduct> getAll(){
        return repo.findAll();
    }

    /**
     * Getting a particular line-product by taking an id in input
     * @param id : line-product id
     * @return : a line-product
     */
    @GetMapping("/{id}")
    public LineProduct getLineProductById(@PathVariable("id") int id){
        return repo.findById(id).get();
    }

    @PostMapping("/")
    public LineProduct postProduct(@RequestBody LineProduct lineProduct){// requestbody to save the data in our database
        return repo.save(lineProduct);
    }

    /**
     * calling external service (PRODUCT-SERVICE)
     * @param id : (id of the lineProduct)
     * @return : lineOrderDetail ( which shows =  lineProduct + Product )
     */
    @GetMapping("/lineproductdetails/{id}")
    LineProductDetail LineProductDetail(@PathVariable("id") int id ){
        LineProduct lineProduct = repo.findById(id).get();
        int idProduct = lineProduct.getProductId();
        Product product = restTemplate.getForObject(productUrl + '/' + idProduct, Product.class);

        return new LineProductDetail(lineProduct, product);
    }

    /**
     * calling external service (ORDER-SERVICE)
     * @param id : (id of the lineProduct)
     * @return : lineOrderDetail ( which shows =  lineProduct + Orders )
     */
    @GetMapping("/lineOdersdetails/{id}")
    LineOrdersDetail LineOrdersDetail(@PathVariable("id") int id ){
        LineProduct lineProduct = repo.findById(id).get();
        int idOrders= lineProduct.getOrderId();
        Orders orders = restTemplate.getForObject(ordersUrl + '/' + 1, Orders.class);

        return new LineOrdersDetail(lineProduct, orders);
    }

}
