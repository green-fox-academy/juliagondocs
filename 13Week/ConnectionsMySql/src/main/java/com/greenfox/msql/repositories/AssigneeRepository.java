package com.greenfox.msql.repositories;

import com.greenfox.msql.model.Assignee;
import com.greenfox.msql.model.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssigneeRepository extends CrudRepository<Assignee,Long> {
    List<Assignee> findAll();
    Assignee findAssigneeById(Long id);
}
