package com.vetardim.model;

import javax.persistence.*;

@Entity
@Table(name = "medical.medical_history")
public class MedicalHistory {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "client_id")
    private int clientId;

    private String clientFullname;

    public String getClientFullname() {
        return clientFullname;
    }

    public void setClientFullname(String clientFullname) {
        this.clientFullname = clientFullname;
    }

    public MedicalHistory (){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
}


