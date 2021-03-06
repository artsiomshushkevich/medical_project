package com.vetardim.model;

import javax.persistence.*;

@Entity
@Table(name = "medical.user")
public class User {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "login")
    private String nickname;
    @Column(name = "password")
    private String password;
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Column(name = "role_id")
    private int roleId;

    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

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
