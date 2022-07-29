package com.tutorial.apidemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class 	SpringbootTutorialApplication {

	public static void main(String[] args) {

        try {
            SpringApplication.run(SpringbootTutorialApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}


}

