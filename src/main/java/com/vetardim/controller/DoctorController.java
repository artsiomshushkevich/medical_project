package com.vetardim.controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.vetardim.model.Doctor;
import com.vetardim.DAO.DoctorDao;

import java.util.List;

public class DoctorController extends ActionSupport {

    private Doctor doctor;
    private List<Doctor> doctorsList;
    private int id;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public List<Doctor> getDoctorsList() {
        return doctorsList;
    }

    public void setDoctorsList(List<Doctor> doctorsList) {
        this.doctorsList = doctorsList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String execute() throws Exception {
        this.doctorsList =  DoctorDao.getDoctorsList();
        return Action.SUCCESS;
    }

    public String update() {
        DoctorDao.updateDoctor(getDoctor());
        return Action.SUCCESS;
    }

    public String delete() {
        DoctorDao.deleteDoctor(getId());
        return Action.SUCCESS;
    }

    public String add() {
        DoctorDao.addDoctor(getDoctor());
        return Action.SUCCESS;
    }


}

