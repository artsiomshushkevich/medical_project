package com.vetardim.controller.clientDashboard;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import com.vetardim.DAO.*;
import com.vetardim.model.*;
import com.vetardim.util.UnixTimeConverter;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class MakeOrderController extends ActionSupport {

    private Client client;
    private int id;
    private List<Doctor> doctorsList;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Doctor> getDoctorsList() {
        return doctorsList;
    }

    public void setDoctorsList(List<Doctor> doctorsList) {
        this.doctorsList = doctorsList;
    }

    @Override
    public String execute() throws Exception {
        doctorsList = DoctorDao.getDoctorsList();
        return Action.SUCCESS;
    }

}

