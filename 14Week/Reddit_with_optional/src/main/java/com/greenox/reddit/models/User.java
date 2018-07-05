package com.greenox.reddit.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name="user_id")
    private List<Post> postList;

    @ManyToOne
    @JoinColumn(name="vote_id")
    private Vote vote;

    public User() {
    }

    public User(String name) {
        this.name=name;
    }

    public User(String name, List<Post> postList) {
        this.name = name;
        this.postList = postList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }
}
