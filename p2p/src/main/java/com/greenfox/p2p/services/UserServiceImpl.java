package com.greenfox.p2p.services;

import com.greenfox.p2p.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository repo;

    @Autowired
    public UserServiceImpl (UserRepository repo) {
        this.repo = repo;
    }
}
