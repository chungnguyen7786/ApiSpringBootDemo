package com.tutorial.apidemo.repositories;

import com.tutorial.apidemo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    //Long ở đây là chìa khóa chính - chính là id - có kiểu là Long
    List<Product> findByProductName(String productName);
}
