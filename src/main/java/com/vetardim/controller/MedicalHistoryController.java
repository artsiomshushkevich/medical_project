package com.vetardim.controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.vetardim.DAO.ClientDao;
import com.vetardim.model.Client;
import com.vetardim.model.MedicalHistory;
import com.vetardim.DAO.MedicalHistoryDao;

import java.util.List;

public class MedicalHistoryController extends ActionSupport {

    private MedicalHistory medicalHistory;
    private List<MedicalHistory> medicalHistoriesList;
    private int id;

    public MedicalHistory getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(MedicalHistory medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public List<MedicalHistory> getMedicalHistoriesList() {
        return medicalHistoriesList;
    }

    public void setMedicalHistoriesList(List<MedicalHistory> medicalHistoryList) {
        this.medicalHistoriesList = medicalHistoryList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String execute() throws Exception {
        this.clientsList = ClientDao.getClientsList();
        this.medicalHistoriesList =  MedicalHistoryDao.getMedicalHistoriesList();
        for (MedicalHistory medicalHistory: medicalHistoriesList) {
            Client client = ClientDao.getClientById(medicalHistory.getClientId());
            medicalHistory.setClientFullname(client.getFullname());
        }
        return Action.SUCCESS;
    }

    public String update() {
        if (!validate(getMedicalHistory())) return Action.ERROR;
        MedicalHistoryDao.addOrUpdateMedicalHistory(getMedicalHistory());
        return Action.SUCCESS;
    }

    public String delete() {
        MedicalHistoryDao.deleteMedicalHistory(getId());
        return Action.SUCCESS;
    }

    public String add() {
        if (!validate(getMedicalHistory())) return Action.ERROR;
        MedicalHistoryDao.addOrUpdateMedicalHistory(getMedicalHistory());
        return Action.SUCCESS;
    }

    private String errorString;
    private List<Client> clientsList;

    public String getErrorString() {
        return errorString;
    }

    public void setErrorString(String errorString) {
        this.errorString = errorString;
    }

    public List<Client> getClientsList() {
        return clientsList;
    }

    public void setClientsList(List<Client> clientsList) {
        this.clientsList = clientsList;
    }

    private boolean validate(MedicalHistory medicalHistory)
    {
        if (ClientDao.getClientById(medicalHistory.getClientId()) == null) {
            errorString = "Client id is invalid";
            return false;
        }

        return true;
    }

}
