package com.greenfox.p2p.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@Entity
//@SequenceGenerator(name="seq", initialValue=1000, allocationSize=1000000)
public class Message {
    @Id
    @GeneratedValue//(strategy=GenerationType.SEQUENCE, generator="seq")
    private Long id;
    private String text;
    private Date createdAt = Calendar.getInstance().getTime();
    private Long timeStamp = new Date().getTime();

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
        //this.timeStamp= new Date().getTime();
    }

    public Message(String text) {
        this.text = text;
    }

    public Message(String text, Long id, User user, Long timeStamp) {
        this.user=user;
        this.timeStamp=timeStamp;
        this.text=text;
        this.id=id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
