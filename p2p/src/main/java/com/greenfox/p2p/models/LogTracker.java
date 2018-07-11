package com.greenfox.p2p.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class LogTracker {
    @Id
    @GeneratedValue
    private Long id;
    private Date logDate;
    private String endPoint;

    public LogTracker(){}

    public LogTracker(Date logDate, String endPoint) {
        this.logDate = logDate;
        this.endPoint = endPoint;
    }
}
