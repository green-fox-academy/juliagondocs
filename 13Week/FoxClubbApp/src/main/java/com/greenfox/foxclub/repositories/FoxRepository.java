package com.greenfox.foxclub.repositories;

import com.greenfox.foxclub.models.Fox;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoxRepository extends CrudRepository<Fox,Long>{
    List<Fox> findAll();
    Fox findByName(String name);

}
