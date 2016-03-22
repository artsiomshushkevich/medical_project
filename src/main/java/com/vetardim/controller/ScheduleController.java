package com.vetardim.controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.vetardim.model.Schedule;
import com.vetardim.DAO.ScheduleDao;

import java.util.List;

public class ScheduleController extends ActionSupport {

    private Schedule schedule;
    private List<Schedule> schedulesList;
    private int id;

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public List<Schedule> getSchedulesList() {
        return schedulesList;
    }

    public void setSchedulesList(List<Schedule> schedulesList) {
        this.schedulesList = schedulesList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String execute() throws Exception {
        this.schedulesList =  ScheduleDao.getSchedulesList();
        return Action.SUCCESS;
    }

    public String update() {
        ScheduleDao.updateSchedule(getSchedule());
        return Action.SUCCESS;
    }

    public String delete() {
        ScheduleDao.deleteSchedule(getId());
        return Action.SUCCESS;
    }

    public String add() {
        ScheduleDao.addSchedule(getSchedule());
        return Action.SUCCESS;
    }

}
