package com.greenfox.rest.models;

import org.springframework.stereotype.Component;

@Component
public class Until {
    private Integer until;

    public Until() {
    }

    public Until(Integer until) {
        this.until = until;
    }

    public Integer getUntil() {
        return until;
    }

    public void setUntil(Integer until) {
        this.until = until;
    }
}
