package com.greenox.reddit.services;

import com.greenox.reddit.models.User;
import com.greenox.reddit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repo;

    @Autowired
    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
        repo.save(new User("Tobi"));
        repo.save(new User("Jony"));
        repo.save(new User("Hans"));
        repo.save(new User("Ivy"));
        repo.save(new User("Hannah"));
        repo.save(new User("Julia"));
    }

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findUserByName(String name) {
        return repo.findUserByName(name);
    }

    public void saveNewUser(String name) {
        if(repo.findUserByName(name) != null ) {
            repo.save(new User(name));
        }
    }
}
