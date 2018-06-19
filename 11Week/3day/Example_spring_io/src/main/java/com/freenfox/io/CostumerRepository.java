package com.freenfox.io;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CostumerRepository extends CrudRepository<Costumer, Long> {

    List<Costumer> findByLastName(String lastName);
}
