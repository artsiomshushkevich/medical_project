package com.vetardim.controller.clientDashboard;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import com.vetardim.DAO.*;
import com.vetardim.model.*;
import com.vetardim.util.UnixTimeConverter;

import java.util.List;
import java.util.Map;

public class MyMedicalHistoryController extends ActionSupport {

    private Client client;
    private int id;
    private MedicalHistory medicalHistory;
    private List<Visit> visitsList;

    public MedicalHistory getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(MedicalHistory medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public List<Visit> getVisitsList() {
        return visitsList;
    }

    public void setVisitsList(List<Visit> visitsList) {
        this.visitsList = visitsList;
    }

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

    @Override
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        if (session.containsKey("id")) {
            id = Integer.parseInt(session.get("id").toString());
            client = ClientDao.getClientByUserId(id);
            medicalHistory = MedicalHistoryDao.getMedicalHistoryByClientId(client.getId());
            visitsList = VisitDao.getVisitsListByMedicalHistoryId(medicalHistory.getId());
            for (Visit visit: visitsList) {
                Order order = OrderDao.getOrderById(visit.getOrderId());
                Doctor doctor = DoctorDao.getDoctorById(order.getDoctorId());
                visit.setDoctorFullname(doctor.getFullname());
                visit.setDoctorSpeciality(doctor.getSpeciality());
                visit.setDate(UnixTimeConverter.convertUnixTimeToTime(order.getDate(),"yyyy-MM-dd"));
            }
        }
        return Action.SUCCESS;
    }

}

