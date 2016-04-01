package com.vetardim.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "medical.schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "workday")
    private String workday;
    @Column(name = "beginworkday")
    private int beginWorkday;
    @Column(name = "endworkday")
    private int endWorkday;
    @Column(name = "room")
    private int room;
    @Column(name = "doctor_id")
    private int doctorId;

    public Schedule (){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWorkday() {
        return workday;
    }

    public void setWorkday(String workday) {
        this.workday = workday;
    }

    public int getBeginWorkday() {
        return beginWorkday;
    }

    public void setBeginWorkday(int beginWorkday) {
        this.beginWorkday = beginWorkday;
    }

    public int getEndWorkday() {
        return endWorkday;
    }

    public void setEndWorkday(int endWorkday) {
        this.endWorkday = endWorkday;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }
}
