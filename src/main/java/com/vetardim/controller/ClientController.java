package com.vetardim.controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.vetardim.DAO.RoleDao;
import com.vetardim.DAO.UserDao;
import com.vetardim.model.Client;
import com.vetardim.DAO.ClientDao;
import com.vetardim.model.User;

import java.util.List;

public class ClientController extends ActionSupport {

    private Client client;
    private List<Client> clientsList;
    private int id;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Client> getClientsList() {
        return clientsList;
    }

    public void setClientsList(List<Client> clientsList) {
        this.clientsList = clientsList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String execute() throws Exception {
        this.usersList = UserDao.getUsersList();
        this.clientsList =  ClientDao.getClientsList();
        return Action.SUCCESS;
    }

    public String update() {
        if (!validate(getClient())) return Action.ERROR;
        ClientDao.addOrUpdateClient(getClient());
        return Action.SUCCESS;
    }

    public String delete() {
        ClientDao.deleteClient(getId());
        return Action.SUCCESS;
    }

    public String add() {
        if (!validate(getClient())) return Action.ERROR;
        ClientDao.addOrUpdateClient(getClient());
        return Action.SUCCESS;
    }

    private List<User> usersList;
    private String errorString;

    public List<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }

    public String getErrorString() {
        return errorString;
    }

    public void setErrorString(String errorString) {
        this.errorString = errorString;
    }

    private boolean validate(Client client)
    {
        if (UserDao.getUserById(client.getUserId()) == null) {
            errorString = "User id is invalid";
            return false;
        }
        User user = UserDao.getUserById(client.getUserId());
        if (!RoleDao.getRoleById(user.getRoleId()).getName().equals("Client") ) {
            errorString = "User has not role Client";
            return false;
        }
        return true;
    }


}

