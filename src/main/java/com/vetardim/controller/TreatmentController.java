package com.vetardim.controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.vetardim.model.Treatment;
import com.vetardim.DAO.TreatmentDao;

import java.util.List;

public class TreatmentController extends ActionSupport {

    private Treatment treatment;
    private List<Treatment> treatmentsList;
    private int id;

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    public List<Treatment> getTreatmentsList() {
        return treatmentsList;
    }

    public void setTreatmentsList(List<Treatment> treatmentsList) {
        this.treatmentsList = treatmentsList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String execute() throws Exception {
        this.treatmentsList =  TreatmentDao.getTreatmentsList();
        return Action.SUCCESS;
    }

    public String update() {
        TreatmentDao.updateTreatment(getTreatment());
        return Action.SUCCESS;
    }

    public String delete() {
        TreatmentDao.deleteTreatment(getId());
        return Action.SUCCESS;
    }

    public String add() {
        TreatmentDao.addTreatment(getTreatment());
        return Action.SUCCESS;
    }


}

