package com.vetardim.controller.clientDashboard;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import com.vetardim.model.User;
import com.vetardim.DAO.UserDao;
import com.vetardim.model.Client;
import com.vetardim.DAO.ClientDao;

import java.util.List;
import java.util.Map;

public class MyInfoController extends ActionSupport {

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User user;
    private Client client;
    private int id;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        if (session.containsKey("id")) {
            id = Integer.parseInt(session.get("id").toString());
            client = ClientDao.getClientByUserId(id);
            user = UserDao.getUserById(id);
            client.setLogin(user.getNickname());
        }
        return Action.SUCCESS;
    }

//    public String update() {
//        AnalyseDao.addOrUpdateAnalyse(getAnalyse());
//        return Action.SUCCESS;
//    }
//
//    public String delete() {
//        AnalyseDao.deleteAnalyse(getId());
//        return Action.SUCCESS;
//    }
//
//    public String add() {
//        AnalyseDao.addOrUpdateAnalyse(getAnalyse());
//        return Action.SUCCESS;
//    }


}
