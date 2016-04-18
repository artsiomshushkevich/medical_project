package com.vetardim.controller.doctorDashboard;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.vetardim.DAO.CureDao;
import com.vetardim.DAO.MedicalHistoryDao;
import com.vetardim.DAO.TreatmentDao;
import com.vetardim.DAO.VisitDao;
import com.vetardim.model.Cure;
import com.vetardim.model.MedicalHistory;
import com.vetardim.model.Treatment;
import com.vetardim.model.Visit;

import java.util.List;
import java.util.Map;

public class MakeVisitController extends ActionSupport {

    private Visit visit;
    private String answer;
    private Treatment treatment;
    private List<MedicalHistory> medicalHistories;
    private List<Cure> curesList;

    public List<Cure> getCuresList() {
        return curesList;
    }

    public void setCuresList(List<Cure> curesList) {
        this.curesList = curesList;
    }

    public List<MedicalHistory> getMedicalHistories() {
        return medicalHistories;
    }

    public void setMedicalHistories(List<MedicalHistory> medicalHistories) {
        this.medicalHistories = medicalHistories;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }

    private int orderId;

    @Override
    public String execute() {
        medicalHistories = MedicalHistoryDao.getMedicalHistoriesList();
        return Action.SUCCESS;
    }

    public String addVisit() {
        if(VisitDao.getVisitByOrderId(getVisit().getOrderId()) == null)
        {
            VisitDao.addOrUpdateVisit(getVisit());
            Map session = ActionContext.getContext().getSession();
            session.put("orderId", getVisit().getOrderId());
            answer = "Visit is added successful";
        }
        else
        {
            answer = "Visit with that order id already exists";
            return Action.ERROR;
        }
        return Action.SUCCESS;
    }

    public String makeTreatment() {
        curesList = CureDao.getCuresList();
        return Action.SUCCESS;
    }

    public String addTreatment() {
        Map session = ActionContext.getContext().getSession();
        orderId = Integer.parseInt(session.get("orderId").toString());
        Visit visit = VisitDao.getVisitByOrderId(orderId);
        getTreatment().setVisitId(visit.getId());
        TreatmentDao.addOrUpdateTreatment(getTreatment());
        answer = "Treatment is added successful";
        return Action.SUCCESS;
    }

}
