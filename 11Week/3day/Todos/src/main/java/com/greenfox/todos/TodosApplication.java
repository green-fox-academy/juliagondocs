package com.greenfox.todos;

import com.greenfox.todos.model.Todo;
import com.greenfox.todos.repositories.ToDoRepository;
import com.greenfox.todos.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodosApplication implements CommandLineRunner {

    @Autowired
    ToDoRepository repo;

    public static void main(String[] args) {
        SpringApplication.run(TodosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repo.save(new Todo("szoveg1",false,false));
        repo.save(new Todo("szoveg2",false,false));
        repo.save(new Todo("szoveg3",false,false));
        repo.save(new Todo("szoveg4",false,false));
        repo.save(new Todo("szoveg5",false,false));
    }
}
