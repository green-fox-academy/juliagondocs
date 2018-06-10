package com.greenfox.login.repositories;

import com.greenfox.login.models.Login;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends CrudRepository<Login,Long> {

    Login findOneByUserName(String userName);
}
