package com.greenfox.p2p.services;

import com.greenfox.p2p.models.Message;
import com.greenfox.p2p.models.User;
import com.greenfox.p2p.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    private MessageRepository repo;

    @Autowired
    public MessageServiceImpl(MessageRepository repo) {
        this.repo=repo;
        //initRepo();
    }

    @Override
    public List<Message> findAll() {
        return repo.findAll();
    }
    
    @Override
    public void initMessage() {
        repo.save(new Message("Hi there! Submit your message using the send button!",new User()));
    }
}
