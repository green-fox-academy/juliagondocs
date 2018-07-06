package com.greenox.reddit.models;

import javax.persistence.*;

@Entity
public class Vote {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="post_id")
    private Post post;
    // vote-ba kötöm be,hogy ki, melyik posztot és hogy vote-olt

}
