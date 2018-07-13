package com.greenfox.p2p.services;

import com.greenfox.p2p.models.Message;
import com.greenfox.p2p.models.User;

import java.util.List;

public interface MessageService {
    List<Message> findAll();

    void initMessage();

    void saveNewMessage(String message, User byName);
    void saveNewMessage(String text, Long timeStamp,Long id);
}
