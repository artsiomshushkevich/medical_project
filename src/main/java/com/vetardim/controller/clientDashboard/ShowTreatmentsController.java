package com.vetardim.controller.clientDashboard;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.vetardim.DAO.CureDao;
import com.vetardim.DAO.TreatmentDao;
import com.vetardim.model.Cure;
import com.vetardim.model.Treatment;

import java.util.List;

public class ShowTreatmentsController extends ActionSupport {
    private List<Treatment> treatmentsList;
    private int id;

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
        this.treatmentsList =  TreatmentDao.getTreatmentsListByVisitId(getId());
        for (Treatment treatment : treatmentsList) {
            Cure cure = CureDao.getCureById(treatment.getCureId());
            treatment.setCure(cure.getName());
        }
        return Action.SUCCESS;
    }

}
