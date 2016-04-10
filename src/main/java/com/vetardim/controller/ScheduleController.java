package com.vetardim.controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.vetardim.model.Schedule;
import com.vetardim.DAO.ScheduleDao;
import com.vetardim.util.UnixTimeConverter;

import java.util.List;

public class ScheduleController extends ActionSupport {

    private Schedule schedule;
    private List<Schedule> schedulesList;
    private int id;
    private String beginWorkTime;
    private String endWorkTime;

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

    public String getEndWorkTime() {
        return endWorkTime;
    }

    public void setEndWorkTime(String endWorkTime) {
        this.endWorkTime = endWorkTime;
    }

    public String getBeginWorkTime() {
        return beginWorkTime;
    }

    public void setBeginWorkTime(String beginWorkTime) {
        this.beginWorkTime = beginWorkTime;
    }

    @Override
    public String execute() throws Exception {
        this.schedulesList =  ScheduleDao.getSchedulesList();
        return Action.SUCCESS;
    }

    public String update() {
        UnixTimeConverter converter = new UnixTimeConverter();
        schedule.setBeginWorkday(converter.convertTimeToUnixTime(getBeginWorkTime(), "hh:mm"));
        schedule.setEndWorkday(converter.convertTimeToUnixTime(getBeginWorkTime(), "hh:mm"));
        ScheduleDao.addOrUpdateSchedule(getSchedule());
        return Action.SUCCESS;
    }

    public String delete() {
        ScheduleDao.deleteSchedule(getId());
        return Action.SUCCESS;
    }

    public String add() {
        UnixTimeConverter converter = new UnixTimeConverter();
        schedule.setBeginWorkday(converter.convertTimeToUnixTime(getBeginWorkTime(), "hh:mm"));
        schedule.setEndWorkday(converter.convertTimeToUnixTime(getBeginWorkTime(), "hh:mm"));
        ScheduleDao.addOrUpdateSchedule(getSchedule());
        return Action.SUCCESS;
    }

}
