package com.vetardim.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "medical.schedules")
public class Schedule {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "id_doctor")
    private int idDoctor;
    @Column(name = "begin_workday")
    private String beginWorkday;
    @Column(name = "end_workday")
    private String endWorkday;
    @Column(name = "week_day")
    private String weekDay;
    @Column(name = "duration")
    private Time duration;
    @Column(name = "cabinet")
    private int cabinet;


    public Schedule (){}

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

    public String getBeginWorkday() {
        return beginWorkday;
    }

    public void setBeginWorkday(String beginWorkday) {
        this.beginWorkday = beginWorkday;
    }

    public String getEndWorkday() {
        return endWorkday;
    }

    public void setEndWorkday(String endWorkday) {
        this.endWorkday = endWorkday;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public int getCabinet() {
        return cabinet;
    }

    public void setCabinet(int cabinet) {
        this.cabinet = cabinet;
    }
}
