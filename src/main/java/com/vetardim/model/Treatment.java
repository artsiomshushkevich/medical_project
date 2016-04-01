package com.vetardim.model;

import javax.persistence.*;

@Entity
@Table(name = "medical.treatment")
public class Treatment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "prescription")
    private String prescription;
    @Column(name = "cure_count")
    private int cureCount;
    @Column(name = "method_of_using")
    private String methodOfUsing;
    @Column(name = "cure_id")
    private int cureId;
    @Column(name = "visit_id")
    private int visitId;

    public Treatment (){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public int getCureCount() {
        return cureCount;
    }

    public void setCureCount(int cureCount) {
        this.cureCount = cureCount;
    }

    public String getMethodOfUsing() {
        return methodOfUsing;
    }

    public void setMethodOfUsing(String methodOfUsing) {
        this.methodOfUsing = methodOfUsing;
    }

    public int getCureId() {
        return cureId;
    }

    public void setCureId(int cureId) {
        this.cureId = cureId;
    }

    public int getVisitId() {
        return visitId;
    }

    public void setVisitId(int visitId) {
        this.visitId = visitId;
    }
}
