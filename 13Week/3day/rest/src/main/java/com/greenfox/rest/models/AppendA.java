package com.greenfox.rest.models;

import org.springframework.stereotype.Component;

@Component
public class AppendA {
    private String appended;

    public AppendA() {
    }

    public AppendA(String value) {
        this.appended = value + "a";
    }

    public String getAppended() {
        return appended;
    }

    public void setAppended(String appended) {
        this.appended = appended;
    }
}
