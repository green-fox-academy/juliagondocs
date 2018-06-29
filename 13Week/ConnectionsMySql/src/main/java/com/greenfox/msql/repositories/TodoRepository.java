package com.greenfox.msql.repositories;

import com.greenfox.msql.model.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
    List<Todo> findAll();

    Todo findTodoById(Long id);

    List<Todo> findByTitleContaining(String title);

    List<Todo> findByDeadLineContaining(String date);
    List<Todo> findAllByAssigneeId(Long id);



}

