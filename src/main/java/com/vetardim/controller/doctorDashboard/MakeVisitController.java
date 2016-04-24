package com.vetardim.controller.doctorDashboard;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.vetardim.DAO.*;
import com.vetardim.model.Cure;
import com.vetardim.model.MedicalHistory;
import com.vetardim.model.Treatment;
import com.vetardim.model.Visit;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        if (!validateVisit(getVisit())) return Action.ERROR;
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
        if (!validateTreatment(getTreatment())) return Action.SUCCESS;
        Map session = ActionContext.getContext().getSession();
        orderId = Integer.parseInt(session.get("orderId").toString());
        Visit visit = VisitDao.getVisitByOrderId(orderId);
        getTreatment().setVisitId(visit.getId());
        TreatmentDao.addOrUpdateTreatment(getTreatment());
        answer = "Treatment is added successful";
        return Action.SUCCESS;
    }

    private boolean validateVisit(Visit visit)
    {
        Pattern namePattern = Pattern.compile("^[A-Za-z\\s]{1,100}$");
        Matcher m = namePattern.matcher(visit.getDiagnosys());
        if (!m.matches())
        {
            answer = "The diagnosys is invalid";
            return false;
        }
        Pattern idPattern = Pattern.compile("^[0-9]{1,11}$");
        m = idPattern.matcher(Integer.toString(visit.getMedicalHistoryId()));
        if (!m.matches() || MedicalHistoryDao.getMedicalHistoryById(visit.getMedicalHistoryId()) == null) {
            answer = "Medical history id is invalid";
            return false;
        }
        m = idPattern.matcher(Integer.toString(visit.getOrderId()));
        if (!m.matches() || OrderDao.getOrderById(visit.getOrderId()) == null) {
            answer = "Order id is invalid";
            return false;
        }
        if (VisitDao.getVisitByOrderId(OrderDao.getOrderById(visit.getOrderId()).getId()) != null) {
            answer = "Visit with this order id is exist";
            return false;
        }
        return true;
    }

    private boolean validateTreatment(Treatment treatment)
    {
        Pattern idPattern = Pattern.compile("^[0-9]{1,11}$");
        Matcher m = idPattern.matcher(Integer.toString(treatment.getCureId()));
        if (!m.matches() || CureDao.getCureById(treatment.getCureId()) == null) {
            answer = "Cure id is invalid";
            return false;
        }
        m = idPattern.matcher(Integer.toString(treatment.getVisitId()));
        if (!m.matches() || VisitDao.getVisitById(treatment.getVisitId()) == null) {
            answer = "Visit id is invalid";
            return false;
        }
        m = idPattern.matcher(Integer.toString(treatment.getCureCount()));
        if (!m.matches()) {
            answer = "Cure count is invalid";
            return false;
        }
        return true;
    }

}
