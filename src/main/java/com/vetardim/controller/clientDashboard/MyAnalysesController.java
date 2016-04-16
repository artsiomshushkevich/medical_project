package com.vetardim.controller.clientDashboard;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import com.vetardim.DAO.*;
import com.vetardim.model.*;
import com.vetardim.util.UnixTimeConverter;

import java.util.List;
import java.util.Map;

public class MyAnalysesController extends ActionSupport {

    private Client client;
    private int id;
    private List<Analyse> analysesList;

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

    public List<Analyse> getAnalysesList() {
        return analysesList;
    }

    public void setAnalysesList(List<Analyse> analysesList) {
        this.analysesList = analysesList;
    }

    @Override
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        if (session.containsKey("id")) {
            id = Integer.parseInt(session.get("id").toString());
            client = ClientDao.getClientByUserId(id);
            analysesList = AnalyseDao.getAnalysesListByClientId(client.getId());
            for (Analyse analyse: analysesList) {
                Doctor doctor = DoctorDao.getDoctorById(analyse.getDoctorId());
                analyse.setDoctorFullname(doctor.getFullname());
                analyse.setDoctorSpeciality(doctor.getSpeciality());
            }

        }
        return Action.SUCCESS;
    }

}

