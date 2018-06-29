package com.greenfox.msql.services;

import com.greenfox.msql.model.Todo;

import java.util.List;

public interface ToDoService {
    List<Todo> findAll();
    void save(Todo todo);
    void deleteById (Long id);
    Todo findById (Long id);
    List<Todo> findByTitle(String title);
    List<Todo> findByDate(String date);


}
