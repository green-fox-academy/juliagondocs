package com.greenfox.foxclub.services;

import com.greenfox.foxclub.models.Fox;
import com.greenfox.foxclub.models.User;
import com.greenfox.foxclub.repositories.FoxRepository;
import com.greenfox.foxclub.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository repo;

    @Autowired
    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    public boolean isValidRegistration(String name, String pswd1, String pswd2) {
        if (repo.findByName(name) == null) {
            if (pswd1.equals(pswd2)) {
                return true;
            }
        }
        return false;
    }

    public List<String> whatIsWrongWithTheRegistration(String name, String pswd1, String pswd2) {
        List<String> errors = new ArrayList<>();

        if (repo.findByName(name) != null) {
            errors.add("Choose a new account name, it is taken already.");
        }

        if (!pswd1.equals(pswd2)) {
            errors.add("Wrong password! Type the same twice!");
        }
        return errors;
    }

    public User findByName( String name) {
        return repo.findByName(name);
    }


    public void saveNewAccount(String name, String pswd1) {
        User user = new User();
        user.setName(name);
        user.setPswd(pswd1);
        repo.save(user);
    }

    public boolean isContainsUserName(String name) {
        if (repo.findByName(name) != null) {
            return true;
        }
        return false;
    }
}
