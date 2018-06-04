package com.greenfox.springstart.Contorller;

public class Greeting {
    Long id;
    String content;

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Greeting(Long id, String content) {
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
