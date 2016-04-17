package com.vetardim.model;

import javax.persistence.*;

@Entity
@Table(name = "medical.visit")
public class Visit {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "medical_history_id")
    private int medicalHistoryId;
    @Column(name = "order_id")
    private int orderId;
    @Column(name = "diagnosys")
    private String diagnosys;
    @Column(name = "complaints")
    private String complaints;

    private String doctorFullname;
    private String doctorSpeciality;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private String date;

    public Visit (){}

    public String getDoctorFullname() {
        return doctorFullname;
    }

    public void setDoctorFullname(String doctorFullname) {
        this.doctorFullname = doctorFullname;
    }

    public String getDoctorSpeciality() {
        return doctorSpeciality;
    }

    public void setDoctorSpeciality(String doctorSpeciality) {
        this.doctorSpeciality = doctorSpeciality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMedicalHistoryId() {
        return medicalHistoryId;
    }

    public void setMedicalHistoryId(int medicalHistoryId) {
        this.medicalHistoryId = medicalHistoryId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getDiagnosys() {
        return diagnosys;
    }

    public void setDiagnosys(String diagnosys) {
        this.diagnosys = diagnosys;
    }

    public String getComplaints() {
        return complaints;
    }

    public void setComplaints(String complaints) {
        this.complaints = complaints;
    }
}

