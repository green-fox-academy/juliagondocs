package com.greenox.reddit.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;
import java.util.Date;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String url;
    private Long timestamp = new Date().getTime() ;
    private Long score = 0L ;
    private String owner;
    private String vote;

    public Post(String title, String url, Long score, String owner, String vote) {
        this.title = title;
        this.url = url;
        this.score = score;
        this.owner = owner;
        this.vote = vote;
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

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
