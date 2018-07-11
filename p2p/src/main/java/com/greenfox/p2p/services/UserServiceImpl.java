package com.greenfox.p2p.services;

import com.greenfox.p2p.models.User;
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

    @Override
    public boolean isValidRegistration(String name) {
        if (repo.findByName(name) == null) {
                return true;
        }
        return false;
    }

    @Override
    public void saveNewUser(User user) {
        repo.save(user);
    }
}
