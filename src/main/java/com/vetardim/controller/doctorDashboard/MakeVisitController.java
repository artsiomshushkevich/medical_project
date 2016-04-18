package com.vetardim.controller.doctorDashboard;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.vetardim.DAO.TreatmentDao;
import com.vetardim.DAO.VisitDao;
import com.vetardim.model.Treatment;
import com.vetardim.model.Visit;

import java.util.Map;

public class MakeVisitController extends ActionSupport {

    private Visit visit;
    private String answer;
    private Treatment treatment;

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
        return Action.SUCCESS;
    }

    public String addVisit() {
        VisitDao.addOrUpdateVisit(getVisit());
        Map session = ActionContext.getContext().getSession();
        session.put("orderId", getVisit().getOrderId());
        answer = "Visit is added successful";
        return Action.SUCCESS;
    }

    public String makeTreatment() {
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
