package com.greenfox.p2p.models;

import javax.persistence.*;

@Entity
public class Message {
    @Id
    @GeneratedValue
    private Long id;
    private String text;

    @ManyToOne
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Message() {
    }

    public Message(String text, User user) {
        this.text = text;
        this.user = user;
    }
}
