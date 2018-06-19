package com.greenfox.todos.services;

import com.greenfox.todos.model.Todo;
import com.greenfox.todos.repositories.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {
    private ToDoRepository repo;

    @Autowired
    public ToDoService(ToDoRepository repo) {
        this.repo = repo;
    }

    private List<Todo> todos = new ArrayList<>();

    public ToDoService() {
        createToDo();
    }

    private void createToDo() {
        todos.add(new Todo("buy milk", true, false));
        todos.add(new Todo("cleaning", true, false));
        todos.add(new Todo("learning H2", true, false));
    }

    public List<Todo> findAll() {
        return todos;
    }

}
