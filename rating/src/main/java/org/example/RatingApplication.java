package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
//@EnableEurekaClient
@EnableFeignClients
public class RatingApplication{
    public static void main(String[] args) {
        SpringApplication.run(RatingApplication.class, args);
    }
}