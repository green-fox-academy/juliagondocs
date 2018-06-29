package com.greenfox.todos.repositories;

import com.greenfox.todos.model.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends CrudRepository<Todo,Long> {
    List<Todo> findAllByTitle(String title);


}
