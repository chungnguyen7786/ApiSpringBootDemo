package com.tutorial.apidemo.database;

import com.tutorial.apidemo.models.Product;
import com.tutorial.apidemo.repositories.ProductRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Database {
    //logger
    private static final Logger logger = LoggerFactory.getLogger(Database.class); /* sẽ log ra chi tiết nằm ở class nào, hay hơn System.out.println */
    @Bean
    CommandLineRunner initDatabase(ProductRepository productRepository) { 
        return new CommandLineRunner() { /*CommandLineRunner là 1 interface, và dòng code này tạo ra một object để thực thi interface đó */
            @Override
            public void run(String... args) throws Exception {
                Product productA = new Product("Macbook pro 16 inch", 2020, 2400.0, "");
                Product productB = new Product("Ipad air green", 2021, 599.0, "");
                logger.info("insert data: " + productRepository.save(productA)); //hàm save sẽ đưa bản ghi productA vào db
                logger.info("insert data: " + productRepository.save(productB)); //hàm save sẽ đưa bản ghi productB vào db
            } 
        };
    }
}
