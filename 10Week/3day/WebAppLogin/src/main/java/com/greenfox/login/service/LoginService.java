package com.greenfox.login.service;

import com.greenfox.login.models.Login;
import com.greenfox.login.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    LoginRepository loginRepository;

    @Autowired
    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public void login(String userName, String password) {
        Login login = new Login(userName, password);
        loginRepository.save(login);
    }

    public Login getUser(String userName) {
        return loginRepository.findOneByUserName(userName);
    }
}