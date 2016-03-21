package com.vetardim.model;

import javax.persistence.*;

/**
 * Created by vitalyorlov on 21.03.16.
 */
@Entity
@Table(name = "medical.analyses")
public class Analyse {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "id_doctor")
    private int idDoctor;
    @Column(name = "idClient")
    private int idClient;
    @Column(name = "name")
    private String name;
    @Column(name = "result")
    private String result;

    public Analyse (){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
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

