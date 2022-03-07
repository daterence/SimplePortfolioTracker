package com.example.simpleportfoliotracker;

import com.example.simpleportfoliotracker.repositories.UserRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepo.class)
public class SimplePortfolioTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimplePortfolioTrackerApplication.class, args);
    }

}
