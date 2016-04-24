package com.vetardim.controller.clientDashboard;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import com.vetardim.DAO.*;
import com.vetardim.model.*;
import com.vetardim.util.UnixTimeConverter;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddOrderController extends ActionSupport {

    private Client client;
    private int id;
    private List<Doctor> doctorsList;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Doctor> getDoctorsList() {
        return doctorsList;
    }

    public void setDoctorsList(List<Doctor> doctorsList) {
        this.doctorsList = doctorsList;
    }

    @Override
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        if (!validate(getTime(), getDate(), getDoctorId())) return Action.SUCCESS; // error :)
        if (session.containsKey("id")) {
            id = Integer.parseInt(session.get("id").toString());
            client = ClientDao.getClientByUserId(id);
            Order order = new Order();
            order.setBeginTime(UnixTimeConverter.convertTimeToUnixTime(getTime(), "hh:mm"));
            order.setDate(UnixTimeConverter.convertTimeToUnixTime(getDate(), "yyyy-MM-dd"));
            order.setClientId(client.getId());
            order.setDoctorId(getDoctorId());
            OrderDao.addOrUpdateOrder(order);
            answer = "The operation completed successfully.";
        }
        return Action.SUCCESS;
    }

    private String answer;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    private int doctorId;
    private String date;
    private String time;

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private boolean validate(String time, String date, int doctorId)
    {
        Pattern datePattern = Pattern.compile("((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])");
        Matcher m = datePattern.matcher(date);
        if (!m.matches())
        {
            answer = "Error: The date is invalid";
            return false;
        }
        Pattern timePattern = Pattern.compile("([01]?[0-9]|2[0-3]):[0-5][0-9]");
        m = timePattern.matcher(time);
        if (!m.matches())
        {
            answer = "Error: The begin time is invalid";
            return false;
        }
        Pattern idPattern = Pattern.compile("^[0-9]{1,11}$");
        m = idPattern.matcher(Integer.toString(doctorId));
        if (!m.matches() || DoctorDao.getDoctorById(doctorId) == null) {
            answer = "Error: Doctor id is invalid";
            return false;
        }
        return true;
    }
}

