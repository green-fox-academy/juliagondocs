package com.greenfox.todos.services;

import com.greenfox.todos.model.Todo;
import com.greenfox.todos.repositories.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository repo;

    private List<Todo> todos = new ArrayList<>();

    public List<Todo> findAll() {
        return todos;
    }

}
