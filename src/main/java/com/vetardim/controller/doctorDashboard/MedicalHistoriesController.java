package com.vetardim.controller.doctorDashboard;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.vetardim.DAO.*;
import com.vetardim.model.*;
import com.vetardim.util.UnixTimeConverter;

import java.util.List;
import java.util.Map;

public class MedicalHistoriesController extends ActionSupport {

    private List<MedicalHistory> medicalHistoriesList;

    public MedicalHistory getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(MedicalHistory medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public List<MedicalHistory> getMedicalHistoriesList() {
        return medicalHistoriesList;
    }

    public void setMedicalHistoriesList(List<MedicalHistory> medicalHistoryList) {
        this.medicalHistoriesList = medicalHistoryList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String execute() throws Exception {
        this.medicalHistoriesList =  MedicalHistoryDao.getMedicalHistoriesList();
        for (MedicalHistory medicalHistory: medicalHistoriesList) {
            Client client = ClientDao.getClientById(medicalHistory.getClientId());
            medicalHistory.setClientFullname(client.getFullname());
        }
        return Action.SUCCESS;
    }

    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Visit> getVisitsList() {
        return visitsList;
    }

    public void setVisitsList(List<Visit> visitsList) {
        this.visitsList = visitsList;
    }

    private int id;
    private MedicalHistory medicalHistory;
    private List<Visit> visitsList;

    public String showMedicalHistory() throws Exception {
        client = ClientDao.getClientById(getId());
        medicalHistory = MedicalHistoryDao.getMedicalHistoryByClientId(client.getId());
        visitsList = VisitDao.getVisitsListByMedicalHistoryId(medicalHistory.getId());
        for (Visit visit: visitsList) {
            Order order = OrderDao.getOrderById(visit.getOrderId());
            Doctor doctor = DoctorDao.getDoctorById(order.getDoctorId());
            visit.setDoctorFullname(doctor.getFullname());
            visit.setDoctorSpeciality(doctor.getSpeciality());
            visit.setDate(UnixTimeConverter.convertUnixTimeToTime(order.getDate(),"yyyy-MM-dd"));
        }
        return Action.SUCCESS;
    }

    private List<Treatment> treatmentsList;

    public List<Treatment> getTreatmentsList() {
        return treatmentsList;
    }

    public void setTreatmentsList(List<Treatment> treatmentsList) {
        this.treatmentsList = treatmentsList;
    }

    public String getTreatments() throws Exception {
        this.treatmentsList =  TreatmentDao.getTreatmentsListByVisitId(getId());
        for (Treatment treatment : treatmentsList) {
            Cure cure = CureDao.getCureById(treatment.getCureId());
            treatment.setCure(cure.getName());
        }
        return Action.SUCCESS;
    }

}
