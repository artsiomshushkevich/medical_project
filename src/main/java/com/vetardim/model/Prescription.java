package com.vetardim.model;

import javax.persistence.*;

@Entity
@Table(name = "medical.prescriptions")
public class Prescription {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "id_client")
    private int idClient;
    @Column(name = "id_doctor")
    private int idDoctor;
    @Column(name = "name")
    private String name;
    @Column(name = "method_of_using")
    private String methodOfUsing;

    public Prescription (){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMethodOfUsing() {
        return methodOfUsing;
    }

    public void setMethodOfUsing(String methodOfUsing) {
        this.methodOfUsing = methodOfUsing;
    }
}
