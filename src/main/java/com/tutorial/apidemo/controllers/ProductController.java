package com.tutorial.apidemo.controllers;


import com.tutorial.apidemo.models.Product;
import com.tutorial.apidemo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/Products")
public class ProductController {
    //DI = Dependency Injection
    @Autowired
    private ProductRepository repository; /* nhờ @Autowired, đối tượng ProductRepository sẽ được tạo ngay khi chương trình chạy, và chỉ tạo 1 lần, sau đó cứ thế dùng*/
    @GetMapping("")
    //this request is: http://localhost:8080/api/v1/Products
    List<Product> getAllProducts(){
        return repository.findAll(); //là hàm có sẵn trong repository
    }
    //Get detail product
    @GetMapping("/{id}")
    Product findById(@PathVariable Long id) {  //Optinal là có thể null -> cho phép ta check xem có data hay không
        return repository.findById(id) //là hàm có sẵn trong repository
            .orElseThrow(()-> new RuntimeException("Cannot find product with id = "+id)); 
    }
}
