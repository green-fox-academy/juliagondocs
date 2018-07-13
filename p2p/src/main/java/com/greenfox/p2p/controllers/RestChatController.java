package com.greenfox.p2p.controllers;

import com.greenfox.p2p.models.ReceivedObject;
import com.greenfox.p2p.models.ResponseMessageOk;
import com.greenfox.p2p.models.ResponseMessageWrong;
import com.greenfox.p2p.services.MessageService;
import com.greenfox.p2p.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestChatController {

    private UserService userService;
    private MessageService messageService;

    @Autowired
    public RestChatController(UserService userService, MessageService messageService) {
        this.userService = userService;
        this.messageService = messageService;
    }

    @PostMapping("/api/message/receive")
    public Object messageReceiver(@RequestBody ReceivedObject object) {
        messageService.saveNewMessage(object.getMessage().getText(), object.getMessage().getTimeStamp(), object.getMessage().getId());
        ResponseMessageWrong response = new ResponseMessageWrong();
        response.setStatus("error");
        return response;
    }

}
