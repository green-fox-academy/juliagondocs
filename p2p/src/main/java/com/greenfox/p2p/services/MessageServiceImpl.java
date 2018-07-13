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
        Message message = new Message("Hi there! Submit your message using the send button!");
        repo.save(message);
    }

    @Override
    public void saveNewMessage(String message, User user) {
        if(message.length()>0) {
            Message text = new Message(message);
            text.setUser(user);
            repo.save(text);
        }
    }

    @Override
    public void saveNewMessage(String text, Long timeStamp, Long id) {
        Message message = new Message();
        message.setText(text);
        message.setTimeStamp(timeStamp);
        message.setId(id);
        repo.save(message);
    }
}
