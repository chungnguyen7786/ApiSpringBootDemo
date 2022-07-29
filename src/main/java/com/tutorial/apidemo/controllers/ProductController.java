package com.tutorial.apidemo.controllers;


import com.tutorial.apidemo.models.Product;
import com.tutorial.apidemo.models.ResponseObject;
import com.tutorial.apidemo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/Products"  )
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
    //Let's return an object with: data, message, status
     ResponseEntity<ResponseObject> findById(@PathVariable Long id) {  //Optinal là có thể null -> cho phép ta check xem có data hay không
        Optional<Product> foundProduct = repository.findById(id);
        if(foundProduct.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "Query product successfully", foundProduct)
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "Cannot find product with id = "+id, "")
            );
        }
    }

    //Insert new Product with POST method
    //Data: Raw, JSON
    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertProduct(@RequestBody Product newProduct) {
        //2 products must not have the same name
        List<Product> foundProduct = repository.findByProductName(newProduct.getProductName().trim()); //trim to cut the space at the beginning and at the end of string
        if (foundProduct.size() > 0) {
            new ResponseObject("failed", "Product name already taken", "");
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("success", "Insert Product successfully", repository.save(newProduct))
        );
    }
}
