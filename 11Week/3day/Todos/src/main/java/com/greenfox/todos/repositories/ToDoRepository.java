package com.greenfox.todos.repositories;

import com.greenfox.todos.model.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends CrudRepository<Todo,Long> {

}
