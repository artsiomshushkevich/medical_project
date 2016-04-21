package com.vetardim.controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.vetardim.DAO.ClientDao;
import com.vetardim.DAO.DoctorDao;
import com.vetardim.DAO.VisitDao;
import com.vetardim.model.Analyse;
import com.vetardim.DAO.AnalyseDao;
import com.vetardim.model.Client;
import com.vetardim.model.Doctor;
import com.vetardim.model.Visit;

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

    private List<Doctor> doctorsList;
    private List<Client> clientsList;
    private List<Visit> visitsList;

    public List<Doctor> getDoctorsList() {
        return doctorsList;
    }

    public void setDoctorsList(List<Doctor> doctorsList) {
        this.doctorsList = doctorsList;
    }

    public List<Client> getClientsList() {
        return clientsList;
    }

    public void setClientsList(List<Client> clientsList) {
        this.clientsList = clientsList;
    }

    public List<Visit> getVisitsList() {
        return visitsList;
    }

    public void setVisitsList(List<Visit> visitsList) {
        this.visitsList = visitsList;
    }

    public String getErrorString() {
        return errorString;
    }

    public void setErrorString(String errorString) {
        this.errorString = errorString;
    }

    @Override
    public String execute() throws Exception {
        this.clientsList = ClientDao.getClientsList();
        this.visitsList = VisitDao.getVisitsList();
        this.doctorsList = DoctorDao.getDoctorsList();
        this.analysesList =  AnalyseDao.getAnalysesList();
        for (Analyse analyse: analysesList) {
            Doctor doctor = DoctorDao.getDoctorById(analyse.getDoctorId());
            analyse.setDoctorFullname(doctor.getFullname());
            Client client = ClientDao.getClientById(analyse.getClientId());
            analyse.setClientFullname(client.getFullname());
        }
        return Action.SUCCESS;
    }

    public String update() {
        if (!validate(getAnalyse())) return Action.ERROR;
        AnalyseDao.addOrUpdateAnalyse(getAnalyse());
        return Action.SUCCESS;
    }

    public String delete() {
        AnalyseDao.deleteAnalyse(getId());
        return Action.SUCCESS;
    }

    public String add() {
        if (!validate(getAnalyse())) return Action.ERROR;
        AnalyseDao.addOrUpdateAnalyse(getAnalyse());
        return Action.SUCCESS;
    }

    private String errorString;

    private boolean validate(Analyse analyse)
    {
        if (DoctorDao.getDoctorById(analyse.getDoctorId()) == null) {
            errorString = "Doctor id is invalid";
            return false;
        }
        if (ClientDao.getClientById(analyse.getClientId()) == null) {
            errorString = "Client id is invalid";
            return false;
        }
        if (VisitDao.getVisitById(analyse.getVisitId()) == null) {
            errorString = "Visit id is invalid";
            return false;
        }
        return true;
    }

}
