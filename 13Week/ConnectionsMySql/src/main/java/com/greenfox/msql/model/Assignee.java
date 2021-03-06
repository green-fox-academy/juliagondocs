package com.greenfox.msql.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter

public class Assignee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name="todo_id")
    private List<Todo> todoList;


    public Assignee() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {

        return name;
    }

    public String getEmail() {
        return email;
    }

    public Assignee(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
