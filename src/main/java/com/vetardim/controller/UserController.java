package com.vetardim.controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.vetardim.model.User;
import com.vetardim.DAO.UserDao;
import com.vetardim.model.Role;
import com.vetardim.DAO.RoleDao;
import java.util.List;

public class UserController extends ActionSupport {

    private User user;
    private List<User> usersList;
    private List<Role> rolesList;
    private int id;
    public String errorString;

    public List<Role> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<Role> rolesList) {
        this.rolesList = rolesList;
    }

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
    public String execute() throws Exception {
        this.rolesList = RoleDao.getRolesList();
        this.usersList =  UserDao.getUsersList();
        for (User user: usersList) {
            user.setRole(RoleDao.getRoleById(user.getRoleId()).getName());
        }
        return Action.SUCCESS;
    }

    public String update() {
        if(!validate(getUser())) return Action.ERROR;
        UserDao.addOrUpdateUser(getUser());
        return Action.SUCCESS;
    }

    public String delete() {
        if(!validate(UserDao.getUserById(getId()))) return Action.ERROR;

        UserDao.deleteUser(getId());
        return Action.SUCCESS;
    }

    public String add() {
        if(!validate(getUser())) return Action.ERROR;
        UserDao.addOrUpdateUser(getUser());
        return Action.SUCCESS;
    }

    private boolean validate(User user)
    {
        if(user.getNickname().equals("admin")) {
            errorString = "Operations with admin are prohibited";
            return false;
        }
        if (RoleDao.getRoleById(user.getRoleId()) == null) {
            errorString = "Role id is invalid";
            return false;
        }
        return true;
    }
}
