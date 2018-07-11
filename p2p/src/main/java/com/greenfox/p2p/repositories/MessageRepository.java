package com.greenfox.p2p.repositories;

import com.greenfox.p2p.models.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message,Long> {
    List<Message> findAll();
}
