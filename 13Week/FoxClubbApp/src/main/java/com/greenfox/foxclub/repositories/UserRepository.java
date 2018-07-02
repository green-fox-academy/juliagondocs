package com.greenfox.foxclub.repositories;

import com.greenfox.foxclub.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
   User findByName(String name);

}
