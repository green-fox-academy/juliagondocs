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
        repo.save(new Todo("Start the day", true, true));
        repo.save(new Todo("Finish H2 workshop1", true, true));
        repo.save(new Todo("Finish JPA workshop2", true, true));
        repo.save(new Todo("Create a CRUD project", true, true));
        repo.save(new Todo("Learn Object Relational Mapping", true, false));
        repo.save(new Todo("Play with MySQL database", true, false));
        repo.save(new Todo("Lose temper", false, true));
        repo.save(new Todo("Finally chill a bit", false, false));
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

    public List<Todo> findByDate(String date){
        return repo.findByDeadLineContaining(date);
    }

    public List<Todo> findTodosForOneAssignee(Long id) {
        return repo.findAllByAssigneeId(id);
    }

    public List<Todo> findTodosByAssigneeName( String name){ return repo.findAllByAssigneeName(name);}
}
