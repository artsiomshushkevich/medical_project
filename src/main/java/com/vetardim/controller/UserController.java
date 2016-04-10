package com.vetardim.controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
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
        this.usersList =  UserDao.getUsersList();

        return Action.SUCCESS;
    }

    public String update() {
        List<User> usersList = UserDao.getUsersList();
        boolean flag = false;
        for (User tempUser : usersList) {
            if(tempUser.getRoleId() == user.getRoleId() && user.getRoleId() == 1) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            UserDao.addOrUpdateUser(getUser());
        }

        return Action.SUCCESS;
    }

    public String delete() {
        UserDao.deleteUser(getId());
        return Action.SUCCESS;
    }

    public String add() {
        List<User> usersList = UserDao.getUsersList();
        boolean flag = false;
        for (User tempUser : usersList) {
            if(tempUser.getRoleId() == user.getRoleId() && user.getRoleId() == 1) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            UserDao.addOrUpdateUser(getUser());
        }

        return Action.SUCCESS;
    }


}
