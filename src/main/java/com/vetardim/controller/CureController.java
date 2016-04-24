package com.vetardim.controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.vetardim.model.Cure;
import com.vetardim.DAO.CureDao;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        if (!validate(getCure())) return Action.ERROR;
        CureDao.addOrUpdateCure(getCure());
        return Action.SUCCESS;
    }

    public String delete() {
        CureDao.deleteCure(getId());
        return Action.SUCCESS;
    }

    public String add() {
        if (!validate(getCure())) return Action.ERROR;
        CureDao.addOrUpdateCure(getCure());
        return Action.SUCCESS;
    }

    private String errorString;

    public String getErrorString() {
        return errorString;
    }

    public void setErrorString(String errorString) {
        this.errorString = errorString;
    }

    private boolean validate(Cure cure)
    {
        Pattern namePattern = Pattern.compile("^[A-Za-z\\s]{1,100}$");
        Matcher m = namePattern.matcher(cure.getName());
        if (!m.matches())
        {
            errorString = "The name is invalid";
            return false;
        }
        return true;
    }


}

