package com.vetardim.controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.vetardim.model.Client;
import com.vetardim.DAO.ClientDao;

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
        this.clientsList =  ClientDao.getClientsList();
        return Action.SUCCESS;
    }

    public String update() {
        ClientDao.updateClient(getClient());
        return Action.SUCCESS;
    }

    public String delete() {
        ClientDao.deleteClient(getId());
        return Action.SUCCESS;
    }

    public String add() {
        ClientDao.addClient(getClient());
        return Action.SUCCESS;
    }


}

