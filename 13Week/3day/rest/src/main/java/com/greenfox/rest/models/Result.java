package com.greenfox.rest.models;

import org.springframework.stereotype.Component;

@Component
public class Result {
    Integer received;
    Integer result;

    public Result() {
    }

    public Result(Integer received) {
        this.received = received;
        this.result = received*2;
    }

    public Integer getReceived() {
        return received;
    }

    public Integer getResult() {
        return result;
    }

    public void setReceived(Integer received) {
        this.received = received;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}