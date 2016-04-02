package com.vetardim.controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.vetardim.model.Cure;
import com.vetardim.DAO.CureDao;

import java.util.List;

public class CureController extends ActionSupport {

    private Cure cure;
    private List<Cure> curesList;
    private int id;

    public Cure getCure() {
        return cure;
    }

    public void setCure(Cure cure) {
        this.cure = cure;
    }

    public List<Cure> getCuresList() {
        return curesList;
    }

    public void setCuresList(List<Cure> curesList) {
        this.curesList = curesList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String execute() throws Exception {
        this.curesList =  CureDao.getCuresList();
        return Action.SUCCESS;
    }

    public String update() {
        CureDao.addOrUpdateCure(getCure());
        return Action.SUCCESS;
    }

    public String delete() {
        CureDao.deleteCure(getId());
        return Action.SUCCESS;
    }

    public String add() {
        CureDao.addOrUpdateCure(getCure());
        return Action.SUCCESS;
    }


}

