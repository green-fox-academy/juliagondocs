package com.greenox.reddit.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String url;
            //"timestamp": 1494339525,
    private Long score;
    private String owner;
    private String vote;

    public Post(String title, String url, Long score, String owner, String vote) {
        this.title = title;
        this.url = url;
        this.score = score;
        this.owner = owner;
        this.vote = vote;
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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }
}
