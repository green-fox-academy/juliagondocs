package com.greenfox.p2p.services;

import com.greenfox.p2p.models.Message;

import java.util.List;

public interface MessageService {
    List<Message> findAll();

    void initMessage();
}
