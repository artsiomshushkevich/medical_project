package com.vetardim.model;

/**
 * Created by vitalyorlov on 21.03.16.
 */

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

/**
 * Created by artsiom on 06.03.2016.
 */
@Entity
@Table(name = "medical.orders")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "id_client")
    private int idClient;
    @Column(name = "date")
    private Date date;
    @Column(name = "id_doctor")
    private int idDoctor;
    @Column(name = "begin_time")
    private Time beginTime;
    @Column(name = "end_time")
    private Time endTime;

    public Order (){}

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Time beginTime) {
        this.beginTime = beginTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
}

