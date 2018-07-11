package com.greenfox.p2p.services;


import com.greenfox.p2p.models.User;

import java.util.List;

public interface UserService {
    boolean isValidRegistration(String name);

    void saveNewUser(User user);

    List<User> findAll();

    User findById(Long id);
    User findByName(String name);

    void updateUser(String name);
}
