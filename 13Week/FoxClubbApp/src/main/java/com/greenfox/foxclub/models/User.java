package com.greenfox.foxclub.models;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String pswd;
    @OneToOne
    private Fox fox;

    public User () {

    }

    public User(String name, String pswd) {
        this.name = name;
        this.pswd = pswd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public Fox getFox() {
        return fox;
    }

    public void setFox(Fox fox) {
        this.fox = fox;
    }
}
