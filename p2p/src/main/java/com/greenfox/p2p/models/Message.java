package com.greenfox.p2p.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Message {
    @Id
    @GeneratedValue
    private Long id;
    private String text;
    private Date createdAt;

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
        this.createdAt= Calendar.getInstance().getTime();
    }

    public Message(String text) {
        this.text = text;
        this.createdAt= Calendar.getInstance().getTime();
    }
}
