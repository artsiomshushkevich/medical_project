package com.vetardim.controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.vetardim.DAO.DoctorDao;
import com.vetardim.model.Doctor;
import com.vetardim.model.Schedule;
import com.vetardim.DAO.ScheduleDao;
import com.vetardim.util.UnixTimeConverter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        this.doctorsList = DoctorDao.getDoctorsList();
        this.schedulesList =  ScheduleDao.getSchedulesList();
        for (Schedule schedule: schedulesList) {
            schedule.setBeginWorkdayInString(UnixTimeConverter.convertUnixTimeToTime(
                    schedule.getBeginWorkday(),"hh:mm"));
            schedule.setEndWorkdayInString(UnixTimeConverter.convertUnixTimeToTime(schedule.getEndWorkday(),"hh:mm"));
            schedule.setDoctorFullname(DoctorDao.getDoctorById(schedule.getDoctorId()).getFullname());
        }
        return Action.SUCCESS;
    }

    public String update() {
        if (!validate(getSchedule())) return Action.ERROR;
        schedule.setBeginWorkday(UnixTimeConverter.convertTimeToUnixTime(getBeginWorkTime(), "hh:mm"));
        schedule.setEndWorkday(UnixTimeConverter.convertTimeToUnixTime(getBeginWorkTime(), "hh:mm"));
        ScheduleDao.addOrUpdateSchedule(getSchedule());
        return Action.SUCCESS;
    }

    public String delete() {
        ScheduleDao.deleteSchedule(getId());
        return Action.SUCCESS;
    }

    public String add() {
        if (!validate(getSchedule())) return Action.ERROR;
        schedule.setBeginWorkday(UnixTimeConverter.convertTimeToUnixTime(getBeginWorkTime(), "hh:mm"));
        schedule.setEndWorkday(UnixTimeConverter.convertTimeToUnixTime(getBeginWorkTime(), "hh:mm"));
        ScheduleDao.addOrUpdateSchedule(getSchedule());
        return Action.SUCCESS;
    }

    private String errorString;
    private List<Doctor> doctorsList;

    public String getErrorString() {
        return errorString;
    }

    public void setErrorString(String errorString) {
        this.errorString = errorString;
    }

    public List<Doctor> getDoctorsList() {
        return doctorsList;
    }

    public void setDoctorsList(List<Doctor> doctorsList) {
        this.doctorsList = doctorsList;
    }

    private boolean validate(Schedule schedule)
    {
        Pattern timePattern = Pattern.compile("([01]?[0-9]|2[0-3]):[0-5][0-9]");
        Matcher m = timePattern.matcher(String.valueOf(schedule.getBeginWorkday()));
        if (!m.matches())
        {
            errorString = "The begin workday is invalid";
            return false;
        }
        m = timePattern.matcher(String.valueOf(schedule.getEndWorkday()));
        if (!m.matches())
        {
            errorString = "The end workday is invalid";
            return false;
        }
        Pattern idPattern = Pattern.compile("^[0-9]{1,11}$");
        m = idPattern.matcher(Integer.toString(schedule.getDoctorId()));
        if (!m.matches() || DoctorDao.getDoctorById(schedule.getDoctorId()) == null) {
            errorString = "Doctor id is invalid";
            return false;
        }
        Pattern namePattern = Pattern.compile("^[A-Za-z]{1,100}$");
        m = namePattern.matcher(schedule.getWorkday());
        if (!m.matches())
        {
            errorString = "The workday is invalid";
            return false;
        }
        Pattern roomPattern = Pattern.compile("^[0-9]{1,11}$");
        m = roomPattern.matcher(String.valueOf(schedule.getRoom()));
        if (!m.matches())
        {
            errorString = "The room is invalid";
            return false;
        }
        return true;
    }

}
