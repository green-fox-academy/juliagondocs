package com.greenfox.p2p.services;

import com.greenfox.p2p.models.User;
import com.greenfox.p2p.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<User> findAll() {
        return repo.findAll();
    }

    @Override
    public User findById(Long id) {
        return repo.findUserById(id);
    }

    @Override
    public User findByName(String name) {
        return repo.findByName(name);
    }

    @Override
    public void updateUser(String name) {
        if(name.length() >=1) {
            User user = repo.findUserById(1L);
            user.setName(name);
            repo.save(user);
        }
    }
}
