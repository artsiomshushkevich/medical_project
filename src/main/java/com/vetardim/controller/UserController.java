package com.vetardim.controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.vetardim.model.User;
import com.vetardim.DAO.UserService;

import java.util.List;

/**
 * Created by artsiom on 07.03.2016.
 */
public class UserController extends ActionSupport {

    private User user;
    private List<User> usersList;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String doDefault() throws Exception {
        this.usersList =  UserService.getUsersList();
        return Action.SUCCESS;
    }

    @Override
    public String execute() throws Exception {
        this.usersList =  UserService.getUsersList();
        return Action.SUCCESS;
    }

    public String update() {
        UserService.updateUser(getUser());
        return Action.SUCCESS;
    }

    public String delete() {
        UserService.deleteUser(getId());
        return Action.SUCCESS;
    }

    public String add() {
        UserService.addUser(getUser());
        return Action.SUCCESS;
    }


}
