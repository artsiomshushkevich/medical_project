package com.vetardim.controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.vetardim.DAO.MedicalHistoryDao;
import com.vetardim.DAO.OrderDao;
import com.vetardim.model.MedicalHistory;
import com.vetardim.model.Order;
import com.vetardim.model.Visit;
import com.vetardim.DAO.VisitDao;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VisitController extends ActionSupport {

    private Visit visit;
    private List<Visit> visitsList;
    private int id;

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }

    public List<Visit> getVisitsList() {
        return visitsList;
    }

    public void setVisitsList(List<Visit> visitsList) {
        this.visitsList = visitsList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String execute() throws Exception {
        this.medicalHistoriesList = MedicalHistoryDao.getMedicalHistoriesList();
        this.ordersList = OrderDao.getOrdersList();
        this.visitsList = VisitDao.getVisitsList();
        return Action.SUCCESS;
    }

    public String update() {
        if (!validate(getVisit())) return Action.ERROR;
        VisitDao.addOrUpdateVisit(getVisit());
        return Action.SUCCESS;
    }

    public String delete() {
        VisitDao.deleteVisit(getId());
        return Action.SUCCESS;
    }

    public String add() {
        if (!validate(getVisit())) return Action.ERROR;
        VisitDao.addOrUpdateVisit(getVisit());
        return Action.SUCCESS;
    }

    private String errorString;
    private List<MedicalHistory> medicalHistoriesList;
    private List<Order> ordersList;

    public String getErrorString() {
        return errorString;
    }

    public void setErrorString(String errorString) {
        this.errorString = errorString;
    }

    public List<MedicalHistory> getMedicalHistoriesList() {
        return medicalHistoriesList;
    }

    public void setMedicalHistoriesList(List<MedicalHistory> medicalHistoriesList) {
        this.medicalHistoriesList = medicalHistoriesList;
    }

    public List<Order> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Order> ordersList) {
        this.ordersList = ordersList;
    }

    private boolean validate(Visit visit)
    {
        Pattern namePattern = Pattern.compile("^[A-Za-z\\s]{1,100}$");
        Matcher m = namePattern.matcher(visit.getDiagnosys());
        if (!m.matches())
        {
            errorString = "The diagnosys is invalid";
            return false;
        }
        Pattern idPattern = Pattern.compile("^[0-9]{1,11}$");
        m = idPattern.matcher(Integer.toString(visit.getMedicalHistoryId()));
        if (!m.matches() || MedicalHistoryDao.getMedicalHistoryById(visit.getMedicalHistoryId()) == null) {
            errorString = "Medical history id is invalid";
            return false;
        }
        m = idPattern.matcher(Integer.toString(visit.getOrderId()));
        if (!m.matches() || OrderDao.getOrderById(visit.getOrderId()) == null) {
            errorString = "Order id is invalid";
            return false;
        }
        if (VisitDao.getVisitByOrderId(OrderDao.getOrderById(visit.getOrderId()).getId()) != null) {
            errorString = "Visit with this order id is exist";
            return false;
        }
        return true;
    }
    
}

