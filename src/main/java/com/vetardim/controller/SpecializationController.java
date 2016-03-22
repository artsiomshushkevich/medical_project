package com.vetardim.controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.vetardim.model.Specialization;
import com.vetardim.DAO.SpecializationDao;

import java.util.List;

public class SpecializationController extends ActionSupport {

    private Specialization specialization;
    private List<Specialization> specializationList;
    private int id;

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public List<Specialization> getSpecializationList() {
        return specializationList;
    }

    public void setSpecializationList(List<Specialization> specializationList) {
        this.specializationList = specializationList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String execute() throws Exception {
        this.specializationList =  SpecializationDao.getSpecializationsList();
        return Action.SUCCESS;
    }

    public String update() {
        SpecializationDao.updateSpecialization(getSpecialization());
        return Action.SUCCESS;
    }

    public String delete() {
        SpecializationDao.deleteSpecialization(getId());
        return Action.SUCCESS;
    }

    public String add() {
        SpecializationDao.addSpecialization(getSpecialization());
        return Action.SUCCESS;
    }


}
