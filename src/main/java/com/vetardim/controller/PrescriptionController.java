package com.vetardim.controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.vetardim.model.Prescription;
import com.vetardim.DAO.PrescriptionDao;

import java.util.List;

public class PrescriptionController extends ActionSupport {

    private Prescription prescription;
    private List<Prescription> prescriptionList;
    private int id;

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public List<Prescription> getPrescriptionList() {
        return prescriptionList;
    }

    public void setPrescriptionList(List<Prescription> prescriptionList) {
        this.prescriptionList = prescriptionList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String execute() throws Exception {
        this.prescriptionList = PrescriptionDao.getPrescriptionsList();
        return Action.SUCCESS;
    }

    public String update() {
        PrescriptionDao.updatePrescription(getPrescription());
        return Action.SUCCESS;
    }

    public String delete() {
        PrescriptionDao.deletePrescription(getId());
        return Action.SUCCESS;
    }

    public String add() {
        PrescriptionDao.addPrescription(getPrescription());
        return Action.SUCCESS;
    }


}

