package com.tutorial.apidemo.database;

import com.tutorial.apidemo.models.Product;
import com.tutorial.apidemo.repositories.ProductRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Now connect with mysql using JPA
/*

\including create and pull the image of container named mysql-spring-boot-tutorial, --rm mean: when you finish and shutdown container=> delele the data
docker run -d --rm --name mysql
-e MYSQL_ROOT_PASSWORD=123456@123456 \ -e mean environment variable
-e MYSQL_USER=chungnguyen7786 \
-e MYSQL_PASSWORD=123456@123456 \
-e MYSQL_DATABASE=mysql \
-p 3306:3306 \mapping: 3306 is port of localhost, that map with the port 3306 of container
--volume mysql-volume:/var/lib/mysql \
mysql:latest  \latest version

mysql -h localhost -P 3306 --protocol=tcp -u chungnguyen7786 -p

* */

@Configuration
public class Database {
    //logger
    private static final Logger logger = LoggerFactory.getLogger(Database.class); /* sẽ log ra chi tiết nằm ở class nào, hay hơn System.out.println */
    @Bean
    CommandLineRunner initDatabase(ProductRepository productRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
//                Product productA = new Product("MacBook Pro 15", 2020,2200.0, "");
//                Product productB = new Product("iPad Air Green", 2021,599.0,"");
//                logger.info("insert data: "+productRepository.save(productA));
//                logger.info("insert data: "+productRepository.save(productB));
            }
        };
    }
}
