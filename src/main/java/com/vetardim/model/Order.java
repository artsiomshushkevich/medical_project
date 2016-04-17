package com.vetardim.model;

import javax.persistence.*;

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
    private String doctorFullname;
    private String doctorSpeciality;
    private String departmentAddress;

    private String clientFullname;

    public String getClientFullname() {
        return clientFullname;
    }

    public void setClientFullname(String clientFullname) {
        this.clientFullname = clientFullname;
    }

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

    public String getDepartmentAddress() {
        return departmentAddress;
    }

    public void setDepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }


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

