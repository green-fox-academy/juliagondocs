package com.freenfox.io;

import javafx.application.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IoApplication {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(IoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CostumerRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new Costumer("Jack", "Bauer"));
            repository.save(new Costumer("Chloe", "O'Brian"));
            repository.save(new Costumer("Kim", "Bauer"));
            repository.save(new Costumer("David", "Palmer"));
            repository.save(new Costumer("Michelle", "Dessler"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Costumer customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            repository.findById(1L)
                    .ifPresent(customer -> {
                        log.info("Customer found with findById(1L):");
                        log.info("--------------------------------");
                        log.info(customer.toString());
                        log.info("");
                    });

            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Bauer").forEach(bauer -> {
                log.info(bauer.toString());
            });
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            // 	log.info(bauer.toString());
            // }
            log.info("");
        };
    }
}

