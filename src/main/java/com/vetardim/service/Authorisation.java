package com.vetardim.service;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.vetardim.DAO.RoleDao;
import com.vetardim.DAO.UserDao;
import com.vetardim.model.Role;
import com.vetardim.model.User;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by dima on 27.03.16.
 */
public class Authorisation extends ActionSupport implements SessionAware {

    private User user = new User();
    private List<User> usersList = new ArrayList<User>();
    private List<Role> rolesList = new ArrayList<Role>();
    private SessionMap<String, Object> session;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }

    public List<Role> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<Role> rolesList) {
        this.rolesList = rolesList;
    }

    private String login;
    private String password;
    private int role_id;

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String execute() throws Exception {
       // this.usersList = UserDao.getUsersList();
       // this.rolesList = RoleDao.getRolesList();
        return Action.SUCCESS;
    }

    public String logout() throws Exception {
        session.invalidate();
        return Action.SUCCESS;
    }

    public String login() throws Exception {

        for (User listElement : UserDao.getUsersList()) {
            if (this.login.equals(listElement.getNickname())) {
                if (this.password.equals(listElement.getPassword()))
                    role_id = listElement.getRoleId();
                for (Role role : RoleDao.getRolesList()) {
                    if (this.role_id == role.getId()) {
                        session.put("id", listElement.getId());
                        session.put("login", listElement.getNickname());
                        session.put("role", role.getName());
                        return Action.SUCCESS;
                    }
                }

            }

        }
       return Action.LOGIN;
    }




    public void setSession(Map<String, Object> map) {
        this.session = (SessionMap<String, Object>) map;
    }
}

