package com.greenfox.p2p.models;

public class ResponseMessageWrong {

    private String status;
    private String message;

    public ResponseMessageWrong() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
