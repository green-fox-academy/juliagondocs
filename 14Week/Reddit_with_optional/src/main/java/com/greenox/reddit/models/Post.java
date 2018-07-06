package com.greenox.reddit.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String url;
    private Long timestamp = new Date().getTime() ;
    private Long score = 0L ;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User owner;

    public Post(String title, String url, Long score, User owner) {
        this.title = title;
        this.url = url;
        this.score = score;
        this.owner = owner;
        this.timestamp = new Date().getTime();
    }

    public Post() {
    }

    public Post(String title, String url) {
        this.title = title;
        this.url = url;
    }

    // SETTEREK ES GETTEREK
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
