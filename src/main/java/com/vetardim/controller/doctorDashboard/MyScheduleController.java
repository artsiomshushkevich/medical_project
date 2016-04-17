package com.vetardim.controller.doctorDashboard;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.vetardim.DAO.DoctorDao;
import com.vetardim.DAO.ScheduleDao;
import com.vetardim.model.Doctor;
import com.vetardim.model.Schedule;
import com.vetardim.util.UnixTimeConverter;

import java.util.List;
import java.util.Map;

public class MyScheduleController extends ActionSupport {

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
        Map session = ActionContext.getContext().getSession();
        if (session.containsKey("id")) {
            id = Integer.parseInt(session.get("id").toString());
            Doctor doctor = DoctorDao.getDoctorByUserId(id);
            this.schedulesList = ScheduleDao.getSchedulesListByDoctorId(doctor.getId());
            for (Schedule schedule : schedulesList) {
                schedule.setBeginWorkdayInString(UnixTimeConverter.convertUnixTimeToTime(
                        schedule.getBeginWorkday(), "hh:mm"));
                schedule.setEndWorkdayInString(UnixTimeConverter.convertUnixTimeToTime(schedule.getEndWorkday(), "hh:mm"));
            }
        }
        return Action.SUCCESS;
    }

}
