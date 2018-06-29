package com.greenfox.msql.repositories;

import com.greenfox.msql.model.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface TodoRepository extends CrudRepository<Todo,Long> {
    List<Todo> todoList = new ArrayList<>();
    List<Todo> findAllByTitle(String title);

}

