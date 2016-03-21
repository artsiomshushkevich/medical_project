package com.vetardim.model;

import javax.persistence.*;

/**
 * Created by vitalyorlov on 21.03.16.
 */
@Entity
@Table(name = "medical.medical_histories")
public class MedicalHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "info")
    private String info;

    public MedicalHistory (){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setName(String info) {
        this.info = info;
    }

}


