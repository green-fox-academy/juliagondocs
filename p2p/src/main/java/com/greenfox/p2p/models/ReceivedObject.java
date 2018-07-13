package com.greenfox.p2p.models;

import java.util.Date;

public class ReceivedObject {
    private Message message;
    private User client;

    public ReceivedObject() {
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }
}
