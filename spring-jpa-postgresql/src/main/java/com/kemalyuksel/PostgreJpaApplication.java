package com.kemalyuksel;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories
public class PostgreJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostgreJpaApplication.class, args);
    }
}
