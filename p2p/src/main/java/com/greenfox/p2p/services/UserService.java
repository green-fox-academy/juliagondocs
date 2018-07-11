package com.greenfox.p2p.services;


import com.greenfox.p2p.models.User;

public interface UserService {
    boolean isValidRegistration(String name);

    void saveNewUser(User user);
}
