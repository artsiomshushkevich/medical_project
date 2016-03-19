package com.vetardim.model;

import javax.persistence.*;

/**
 * Created by artsiom on 06.03.2016.
 */
@Entity
@Table(name = "sppdb.user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "nickname")
    private String nickname;
    @Column(name = "password")
    private String password;

    public User (){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
