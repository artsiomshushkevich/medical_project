package com.vetardim.controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.vetardim.model.Visit;
import com.vetardim.DAO.VisitDao;

import java.util.List;

public class VisitController extends ActionSupport {

    private Visit visit;
    private List<Visit> visitsList;
    private int id;

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }

    public List<Visit> getVisitsList() {
        return visitsList;
    }

    public void setVisitsList(List<Visit> visitsList) {
        this.visitsList = visitsList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String execute() throws Exception {
        this.visitsList = VisitDao.getVisitsList();
        return Action.SUCCESS;
    }

    public String update() {
        VisitDao.updateVisit(getVisit());
        return Action.SUCCESS;
    }

    public String delete() {
        VisitDao.deleteVisit(getId());
        return Action.SUCCESS;
    }

    public String add() {
        VisitDao.addVisit(getVisit());
        return Action.SUCCESS;
    }
    
}

