package com.greenfox.msql.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private boolean urgent=false;
    private boolean done = false;
    private String addDate;
    private String deadLine;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy. MM dd HH:mm:ss");
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="assignee_id")
    private Assignee assignee;

    public Assignee getAssignee() {
        return assignee;
    }

    public void setAssignee(Assignee assignee) {

        this.assignee = assignee;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }

    public String getAddDate() {

        return addDate;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Long getId() {

        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public boolean isDone() {
        return done;
    }

    public Todo() {

    }

    public Todo(String title, boolean urgent, boolean done) {
        this.title = title;
        this.urgent = urgent;
        this.done = done;
        this.addDate=LocalDateTime.now().format(formatter);
        this.deadLine= LocalDateTime.now().plusDays((int) (Math.random() * ((30  + 1)))).format(formatter);
    }


    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", urgent=" + urgent +
                ", done=" + done +
                '}';
    }

}
