package com.vetardim.controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.vetardim.DAO.CureDao;
import com.vetardim.DAO.VisitDao;
import com.vetardim.model.Cure;
import com.vetardim.model.Treatment;
import com.vetardim.DAO.TreatmentDao;
import com.vetardim.model.Visit;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        this.curesList = CureDao.getCuresList();
        this.visitsList = VisitDao.getVisitsList();
        this.treatmentsList =  TreatmentDao.getTreatmentsList();
        for (Treatment treatment: treatmentsList) {
            treatment.setCure(CureDao.getCureById(treatment.getCureId()).getName());
        }
        return Action.SUCCESS;
    }

    public String update() {
        if (!validate(getTreatment())) return Action.ERROR;
        TreatmentDao.addOrUpdateTreatment(getTreatment());
        return Action.SUCCESS;
    }

    public String delete() {
        TreatmentDao.deleteTreatment(getId());
        return Action.SUCCESS;
    }

    public String add() {
        if (!validate(getTreatment())) return Action.ERROR;
        TreatmentDao.addOrUpdateTreatment(getTreatment());
        return Action.SUCCESS;
    }

    private String errorString;
    private List<Visit> visitsList;
    private List<Cure> curesList;

    public String getErrorString() {
        return errorString;
    }

    public void setErrorString(String errorString) {
        this.errorString = errorString;
    }

    public List<Visit> getVisitsList() {
        return visitsList;
    }

    public void setVisitsList(List<Visit> visitsList) {
        this.visitsList = visitsList;
    }

    public List<Cure> getCuresList() {
        return curesList;
    }

    public void setCuresList(List<Cure> curesList) {
        this.curesList = curesList;
    }

    private boolean validate(Treatment treatment)
    {
        Pattern idPattern = Pattern.compile("^[0-9]{1,11}$");
        Matcher m = idPattern.matcher(Integer.toString(treatment.getCureId()));
        if (!m.matches() || CureDao.getCureById(treatment.getCureId()) == null) {
            errorString = "Cure id is invalid";
            return false;
        }
        m = idPattern.matcher(Integer.toString(treatment.getVisitId()));
        if (!m.matches() || VisitDao.getVisitById(treatment.getVisitId()) == null) {
            errorString = "Visit id is invalid";
            return false;
        }
        m = idPattern.matcher(Integer.toString(treatment.getCureCount()));
        if (!m.matches()) {
            errorString = "Cure count is invalid";
            return false;
        }
        return true;
    }

}

