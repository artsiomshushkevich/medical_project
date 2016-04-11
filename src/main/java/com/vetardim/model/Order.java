package com.vetardim.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "medical.order")
public class Order {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "client_id")
    private int clientId;
    @Column(name = "date")
    private long date;
    @Column(name = "doctor_id")
    private int doctorId;
    @Column(name = "begin_time")
    private long beginTime;

    private String dateInString;
    private String beginTimeInString;

    public String getDateInString() {
        return dateInString;
    }

    public void setDateInString(String dateInString) {
        this.dateInString = dateInString;
    }

    public String getBeginTimeInString() {
        return beginTimeInString;
    }

    public void setBeginTimeInString(String beginTimeInString) {
        this.beginTimeInString = beginTimeInString;
    }

    public Order (){}

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

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public long getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(long beginTime) {
        this.beginTime = beginTime;
    }
}

