package com.vetardim.controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.vetardim.model.Analyse;
import com.vetardim.DAO.AnalyseDao;

import java.util.List;

public class AnalyseController extends ActionSupport {

    private Analyse analyse;
    private List<Analyse> analysesList;
    private int id;

    public Analyse getAnalyse() {
        return analyse;
    }

    public void setAnalyse(Analyse analyse) {
        this.analyse = analyse;
    }

    public List<Analyse> getAnalysesList() {
        return analysesList;
    }

    public void setAnalysesList(List<Analyse> analysesList) {
        this.analysesList = analysesList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String execute() throws Exception {
        this.analysesList =  AnalyseDao.getAnalysesList();
        return Action.SUCCESS;
    }

    public String update() {
        AnalyseDao.addOrUpdateAnalyse(getAnalyse());
        return Action.SUCCESS;
    }

    public String delete() {
        AnalyseDao.deleteAnalyse(getId());
        return Action.SUCCESS;
    }

    public String add() {
        AnalyseDao.addOrUpdateAnalyse(getAnalyse());
        return Action.SUCCESS;
    }


}
