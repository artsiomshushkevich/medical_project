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

    public Visit (){}

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

