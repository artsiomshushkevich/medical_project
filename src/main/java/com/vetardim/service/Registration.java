package com.vetardim.service;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.vetardim.DAO.ClientDao;
import com.vetardim.DAO.MedicalHistoryDao;
import com.vetardim.model.Client;
import com.vetardim.model.MedicalHistory;
import com.vetardim.model.User;
import com.vetardim.DAO.UserDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dima on 27.03.16.
 */
public class Registration extends ActionSupport {

    private User user = new User();
    private Client client = new Client();
    private MedicalHistory medicalHistory = new MedicalHistory();
    private List<User> usersList = new ArrayList<User>();
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public MedicalHistory getMedicalHistory() {
        return medicalHistory;
    }
    public void setMedicalHistory(MedicalHistory medicalHistory) {
        this.medicalHistory = medicalHistory;
    }


    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    public List<User> getUsersList() {
        return usersList;
    }
    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }

    private String login;
    private String password;
    public void setLogin(String login){this.login = login;}
    public String getLogin() {return login;}
    public void setPassword(String password){this.password = password;}
    public String getPassword() {return password;}

    private String message;
    public void setMessage(String message){this.message = message;}
    public String getMessage() {return message;}

    @Override
    public String execute() throws Exception {
        this.usersList =  UserDao.getUsersList();

        return Action.SUCCESS;
    }

    public String singup() throws  Exception {

        for (User listElement : UserDao.getUsersList()) {



            if(this.login.equals(listElement.getNickname()))
            {
                return Action.SUCCESS;
            }

        }

        this.user.setNickname(this.login);
        this.user.setPassword(this.password);
        this.user.setRoleId(2);
        UserDao.addOrUpdateUser(getUser());
        for (User listElement : UserDao.getUsersList()) {
            if(this.login.equals(listElement.getNickname()))
            {
               client.setUserId(listElement.getId());
                ClientDao.addOrUpdateClient(getClient());
                for (Client Element : ClientDao.getClientsList()) {
                    if (Element.getUserId()== listElement.getId()) {
                        medicalHistory.setClientId(Element.getId());
                        MedicalHistoryDao.addOrUpdateMedicalHistory(getMedicalHistory());
                    }
                }

            }



        }


        return Action.SUCCESS;
    }

}

