package com.greenox.reddit.repositories;

import com.greenox.reddit.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    List<User> findAll();
    List findAllById(Long id);
    User findUserByName(String name);
}
