package com.greenfox.msql.services;

import com.greenfox.msql.model.Assignee;
import com.greenfox.msql.model.Todo;
import com.greenfox.msql.repositories.AssigneeRepository;
import com.greenfox.msql.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssigneeServiceImpl implements AssigneeService{
    private AssigneeRepository repo;

    @Autowired
    public AssigneeServiceImpl(AssigneeRepository repo) {
        this.repo=repo;
        repo.save(new Assignee("Julcsika","haloka@gmail.com"));
        repo.save(new Assignee("Davidka","masik@gmail.com"));
    }

    public List<Assignee> findAll() {
        return repo.findAll();
    }

    public void save(Assignee assignee) {
        repo.save(assignee);
    }

    public void deleteById (Long id) {
        repo.deleteById(id);
    }

    public Assignee findById (Long id) {
        return repo.findAssigneeById(id);
    }

    public Assignee findByName (String name) {
        return repo.findAssigneeByName(name);
    }
}
