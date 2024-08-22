package com.spring.spring_second_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringSecondProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecondProjectApplication.class, args);
    }

}
