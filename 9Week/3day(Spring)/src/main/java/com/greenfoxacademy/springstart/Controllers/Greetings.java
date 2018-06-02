package com.greenfoxacademy.springstart.Controllers;

public class Greetings {
    Long id;
    String content;

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Greetings(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Greetings{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
