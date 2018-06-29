package com.greenfox.msql.services;

import com.greenfox.msql.model.Todo;
import com.greenfox.msql.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements ToDoService {

    private TodoRepository repo;

    @Autowired
    public TodoServiceImpl(TodoRepository repo) {
        this.repo=repo;
        repo.save(new Todo ("Learn HTML",true,true));
        repo.save(new Todo ("Learn python",true,true));
    }


    public List<Todo> findAll() {
        return repo.findAll();
    }

    public void save(Todo todo) {
        repo.save(todo);
    }

    public void deleteById (Long id) {
        repo.deleteById(id);
    }

    public Todo findById (Long id) {
        return repo.findTodoById(id);
    }

    public List<Todo> findByTitle(String title){
        return repo.findByTitleContaining(title);
    }

}
