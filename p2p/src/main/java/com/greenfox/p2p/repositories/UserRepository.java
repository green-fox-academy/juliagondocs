package com.greenfox.p2p.repositories;

import com.greenfox.p2p.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
User findByName(String name);
List<User> findAll();
User findUserById(Long id);
}
