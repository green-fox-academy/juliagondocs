package com.greenox.reddit.services;

import com.greenox.reddit.models.User;

import java.util.List;

public interface UserService {
List<User> findAll();
User findUserByName(String name);
void saveNewUser(String name);
}
