package com.greenfox.msql;

import com.greenfox.msql.model.Todo;
import com.greenfox.msql.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MsqlApplication  implements CommandLineRunner {

    @Autowired
    TodoRepository repo;

    public static void main(String[] args) {
        SpringApplication.run(MsqlApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //repo.save(new Todo("Start the day", true, true));
        //repo.save(new Todo("Finish H2 workshop1", true, true));
        //repo.save(new Todo("Finish JPA workshop2", true, true));
        //repo.save(new Todo("Create a CRUD project", true, true));
        //repo.save(new Todo("Learn Object Relational Mapping", true, false));

        //repo.save(new Todo("Play with MySQL database", true, false));
        //repo.save(new Todo("Lose temper", false, true));
        //repo.save(new Todo("Finally chill a bit", false, false));
    }
}
