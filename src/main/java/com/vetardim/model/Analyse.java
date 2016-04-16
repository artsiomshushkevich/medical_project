package com.vetardim.model;

import javax.persistence.*;

@Entity
@Table(name = "medical.analyse")
public class Analyse {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "doctor_id")
    private int doctorId;
    @Column(name = "client_id")
    private int clientId;
    @Column(name = "visit_id")
    private int visitId;
    @Column(name = "name")
    private String name;
    @Column(name = "result")
    private String result;

    private String doctorFullname;
    private String doctorSpeciality;

    public String getDoctorSpeciality() {
        return doctorSpeciality;
    }

    public void setDoctorSpeciality(String doctorSpeciality) {
        this.doctorSpeciality = doctorSpeciality;
    }

    public String getDoctorFullname() {
        return doctorFullname;
    }

    public void setDoctorFullname(String doctorFullname) {
        this.doctorFullname = doctorFullname;
    }


    public Analyse (){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getVisitId() {
        return visitId;
    }

    public void setVisitId(int visitId) {
        this.visitId = visitId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}

