package com.vetardim.model;

import javax.persistence.*;

/**
 * Created by vitalyorlov on 21.03.16.
 */
@Entity
@Table(name = "medical.roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

    public Role (){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

